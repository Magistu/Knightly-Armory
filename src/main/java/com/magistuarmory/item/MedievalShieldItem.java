package com.magistuarmory.item;

import java.util.List;
import java.util.function.Supplier;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BannerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class MedievalShieldItem extends ShieldItem implements IHasModelProperty
{
    private LazyValue<Ingredient> repairItem = new LazyValue<>(() -> Ingredient.of(ItemTags.PLANKS));
    private final boolean paintable;
    private final float maxBlockDamage;
    private final float weight;
    private final String shieldName;
    private final String materialName;

    public MedievalShieldItem(String shieldName, Item.Properties build, ModItemTier material, int durability, float weigth, float maxBlockDamage, boolean paintable)
    {
        super(build.durability(durability));
        this.shieldName = shieldName;
        this.materialName = material.getMaterialName();
        this.paintable = paintable;
        this.maxBlockDamage = maxBlockDamage + material.getAttackDamageBonus();
        this.weight = weigth + material.getAttackDamageBonus();
    }

    public String getShieldName()
    {
        return this.shieldName;
    }

    public String getMaterialName()
    {
        return this.materialName;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, World worldIn, List<ITextComponent> tooltip, @NotNull ITooltipFlag flagIn)
    {
        tooltip.add(new StringTextComponent(getMaxBlockDamage() + " max damage block").withStyle(TextFormatting.BLUE));
        tooltip.add(new StringTextComponent(getWeight() + "kg weight").withStyle(TextFormatting.BLUE));
        if (this.weight >= 10)
        {
            tooltip.add(new StringTextComponent("Slow movement speed").withStyle(TextFormatting.RED));
        }
        BannerItem.appendHoverTextFromBannerBlockEntityTag(stack, tooltip);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull World worldIn, @NotNull Entity entityIn, int itemSlot, boolean isSelected)
    {
        if (this.getWeight() < 10 || !(entityIn instanceof LivingEntity) || (((LivingEntity)entityIn).getMainHandItem() != stack && ((LivingEntity)entityIn).getMainHandItem() != stack))
        {
            return;
        }
        ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 40, 1, false, false, false));
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    private float getWeight()
    {
        return this.weight;
    }

    @Override
    public @NotNull String getDescriptionId(@NotNull ItemStack p_43109_)
    {
        return this.getDescriptionId();
    }

    @Override
    public int getUseDuration(@NotNull ItemStack p_43107_)
    {
        return (int) (1200 / this.getWeight());
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack p_40392_, @NotNull ItemStack p_40393_)
    {
        return this.repairItem.get().test(p_40393_);
    }

    public boolean isPaintable()
    {
        return this.paintable;
    }

    public float getMaxBlockDamage()
    {
        return this.maxBlockDamage;
    }

    public MedievalShieldItem setRepairItem(Supplier<Ingredient> repairItem)
    {
        this.repairItem = new LazyValue<>(repairItem);
        return this;
    }

    public void onBlock(ItemStack stack, float damage, PlayerEntity player, DamageSource source)
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

        if (damage > this.getMaxBlockDamage())
        {
            stack.hurtAndBreak((int) (armorPiercingFactor * 1.5f * getMaxBlockDamage()), player, (p_220044_0_) ->
                    p_220044_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND));

            float damage1 = damage - this.getMaxBlockDamage();
            float damage2 = CombatRules.getDamageAfterAbsorb(damage1, (float)player.getArmorValue(), (float)player.getAttributeValue(Attributes.ARMOR_TOUGHNESS));

            player.hurt(DamageSource.GENERIC, damage2);
            return;
        }
        stack.hurtAndBreak((int) (armorPiercingFactor * damage), player, (p_220044_0_) ->
                p_220044_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND));
    }

    @Override
    public boolean isShield(ItemStack stack, LivingEntity entity)
    {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void registerModelProperty()
    {
        ItemModelsProperties.register(this, new ResourceLocation("blocking"), (p_239421_0_, p_239421_1_, p_239421_2_) ->
                p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == p_239421_0_ ? 1.0F : 0.0F);
    }
}