package com.magistuarmory.item;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;
import com.magistuarmory.client.renderer.model.item.MedievalShieldModel;
import com.magistuarmory.client.renderer.tileentity.HeraldryItemStackRenderer;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.ToolAction;

public class MedievalShieldItem extends ShieldItem implements IHasModelProperty
{
	private LazyLoadedValue<Ingredient> repairItem = new LazyLoadedValue(() -> { return Ingredient.of(ItemTags.PLANKS);});
	private HeraldryItemStackRenderer renderer;
	private final boolean paintable;
	private final float maxBlockDamage;
	private final float weight;


	public MedievalShieldItem(String id, String name, Properties prop, ModItemTier material, int durability, float weigth, float maxBlockDamage, boolean paintable, boolean is3d)
	{
		super(prop.durability(durability));
		this.paintable = paintable;
		this.maxBlockDamage = maxBlockDamage + material.getAttackDamageBonus();
		this.weight = weigth + material.getAttackDamageBonus();
		if (is3d && KnightlyArmory.PROXY instanceof ClientProxy)
		{
			renderer = (HeraldryItemStackRenderer) ClientProxy.getHeraldryItemStackRenderer(id, name);
		}

	}
	
	@Override
	public void appendHoverText(ItemStack p_43094_, @Nullable Level p_43095_, List<Component> p_43096_, TooltipFlag p_43097_)
    {
    	p_43096_.add(Component.literal(getMaxBlockDamage() + " ").append(Component.translatable("maxdamageblock")).withStyle(ChatFormatting.BLUE));
    	p_43096_.add(Component.literal(getWeight() + " ").append(Component.translatable("kgweight")).withStyle(ChatFormatting.BLUE));
		if (weight >= 10)
		{
			p_43096_.add(Component.translatable("slowmovementspeed").withStyle(ChatFormatting.RED));
		}
	    BannerItem.appendHoverTextFromBannerBlockEntityTag(p_43094_, p_43096_);
    }
	
	@Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
    	if (getWeight() < 10 || !(entityIn instanceof LivingEntity) || (((LivingEntity)entityIn).getMainHandItem() != stack && ((LivingEntity)entityIn).getMainHandItem() != stack))
    	{
    		return;
    	}
    	((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1, false, false, false));
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
	
	public HeraldryItemStackRenderer getRenderer() 
	{
		return renderer;
	}
	
	public float getMaxBlockDamage() 
	{
		return maxBlockDamage;
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction action)
	{
		return net.minecraftforge.common.ToolActions.DEFAULT_SHIELD_ACTIONS.contains(action);
	}
	
	public MedievalShieldItem setRepairItem(Supplier<Ingredient> repairItem)
    {
		this.repairItem = new LazyLoadedValue<>(repairItem);
		return this;
    }

	public void onBlocked(ItemStack stack, float damage, Player player, DamageSource source) 
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
			stack.hurtAndBreak((int) (armorPiercingFactor * 1.5f * getMaxBlockDamage()), player, (p_40992_) ->
					p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
			float damage1 = damage - getMaxBlockDamage();
			float damage2 = CombatRules.getDamageAfterAbsorb(damage1, (float)player.getArmorValue(), (float)player.getAttributeValue(Attributes.ARMOR_TOUGHNESS));
			player.hurt(DamageSource.GENERIC, damage2);
			return;
		}
		stack.hurtAndBreak((int) (armorPiercingFactor * damage), player, (p_40992_) ->
				p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer)
	{
		consumer.accept(new IClientItemExtensions()
		{
			@Override
		    public BlockEntityWithoutLevelRenderer getCustomRenderer()
			{
				return renderer;
			}
		});
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void registerModelProperty() 
	{
		ItemProperties.register(this, new ResourceLocation("blocking"), (p_174590_, p_174591_, p_174592_, p_174593_) ->
				p_174592_ != null && p_174592_.isUsingItem() && p_174592_.getUseItem() == p_174590_ ? 1.0F : 0.0F);
	}
}