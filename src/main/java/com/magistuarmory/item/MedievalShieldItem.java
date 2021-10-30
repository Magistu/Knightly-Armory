package com.magistuarmory.item;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;
import com.magistuarmory.client.renderer.model.item.AbstractShieldModel;
import com.magistuarmory.client.renderer.tileentity.HeraldyItemStackRenderer;
import com.magistuarmory.init.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BannerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.ModelLoader;

public class MedievalShieldItem extends ShieldItem implements IHasModelProperty
{
    private int durability;
    private LazyValue<Ingredient> repairItem = new LazyValue(() -> { return Ingredient.of(ItemTags.PLANKS);});
    private boolean paintable;
    private AbstractShieldModel model;
    private HeraldyItemStackRenderer renderer;
    private float maxBlockDamage;
    private float weight;
    private String shieldName;
    private String materialName;



    public MedievalShieldItem(String shieldName, Item.Properties build, ModItemTier material, int durability, float weigth, float maxBlockDamage, boolean paintable)
    {
        super(build.defaultDurability(durability));
        setRegistryName(material.getMaterialName() + "_" + shieldName);
        this.shieldName = shieldName;
        this.materialName = material.getMaterialName();
        this.durability = durability;
        this.paintable = paintable;
        this.maxBlockDamage = maxBlockDamage + material.getAttackDamageBonus();
        this.weight = weigth + material.getAttackDamageBonus();

    }

    public String getShieldName()
    {
        return shieldName;
    }

    public String getMaterialName()
    {
        return materialName;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add(new StringTextComponent(getMaxBlockDamage() + " max damage block").withStyle(TextFormatting.BLUE));
        tooltip.add(new StringTextComponent(getWeight() + "kg weight").withStyle(TextFormatting.BLUE));
        if (weight >= 10)
        {
            tooltip.add(new StringTextComponent("Slow movement speed").withStyle(TextFormatting.RED));
        }
        BannerItem.appendHoverTextFromBannerBlockEntityTag(stack, tooltip);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
        if (getWeight() < 10 || !(entityIn instanceof LivingEntity) || (((LivingEntity)entityIn).getMainHandItem() != stack && ((LivingEntity)entityIn).getMainHandItem() != stack))
        {
            return;
        }
        ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 40, 1, false, false, false));
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    private float getWeight()
    {
        return weight;
    }

    @Override
    public String getDescriptionId(ItemStack p_43109_)
    {
        return getDescriptionId();
    }

    @Override
    public int getUseDuration(ItemStack p_43107_)
    {
        return (int) (12000 * weight);
    }

    @Override
    public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_)
    {
        return this.repairItem.get().test(p_40393_);
    }

    public boolean isPaintable()
    {
        return paintable;
    }


    public HeraldyItemStackRenderer getRenderer()
    {
        return renderer;
    }

    public float getMaxBlockDamage()
    {
        return maxBlockDamage;
    }

    public MedievalShieldItem setRepairItem(Supplier<Ingredient> repairItem)
    {
        this.repairItem = new LazyValue<>(repairItem);
        return this;
    }

    public void onBlocked(ItemStack stack, float damage, PlayerEntity player, DamageSource source)
    {
        float armorPiercingFactor = 1.0f;
        if (source.getEntity() instanceof LivingEntity)
        {
            LivingEntity attacker = (LivingEntity)source.getEntity();
            if (attacker.getMainHandItem().getItem() instanceof MedievalWeaponItem)
            {
                armorPiercingFactor += ((MedievalWeaponItem)attacker.getMainHandItem().getItem()).armorPiercing / 100.0f;
            }
        }

        if (damage > getMaxBlockDamage())
        {
            stack.hurtAndBreak((int) (armorPiercingFactor * 0.2f * stack.getMaxDamage()), player, (p_220044_0_) ->
            {
                p_220044_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
            });

            float damage1 = damage - getMaxBlockDamage();
            float damage2 = (float) (damage1 * (1 - Math.min(20, Math.max( player.getArmorValue() / 5, player.getArmorValue() - damage1 / (player.getAttributeValue(Attributes.ARMOR_TOUGHNESS) / 4 + 2))) / 25));
            player.hurt(DamageSource.GENERIC, damage2);
            return;
        }
        stack.hurtAndBreak((int) (armorPiercingFactor * damage), player, (p_220044_0_) ->
        {
            p_220044_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
        });
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void registerModelProperty()
    {
        ItemModelsProperties.register(this, new ResourceLocation("blocking"), (p_239421_0_, p_239421_1_, p_239421_2_) ->
        {
            return p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == p_239421_0_ ? 1.0F : 0.0F;
        });
    }
}