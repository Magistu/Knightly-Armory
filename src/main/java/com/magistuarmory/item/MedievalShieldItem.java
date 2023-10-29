package com.magistuarmory.item;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.model.item.AbstractModelBase;
import com.magistuarmory.client.renderer.tileentity.HeraldyItemStackRenderer;
import com.magistuarmory.init.ModItems;
import com.magistuarmory.util.IHasModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.*;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MedievalShieldItem extends ItemShield implements IHasModel
{
	private int durability;
	private Item repairItem = Item.getItemFromBlock(Blocks.PLANKS);
	private boolean paintable;
	private String shieldName;
	private AbstractModelBase model;
	private String materialName;
	private float maxBlockDamage;
	private float weight;
	

	public MedievalShieldItem(String shieldName, String materialName, ToolMaterial material, int durability, float weigth, float maxBlockDamage, boolean paintable)
    {
		super();
		setRegistryName(materialName + '_' + shieldName);
		setUnlocalizedName(materialName + '_' + shieldName);
		this.durability = durability;
		this.setMaxDamage(durability);
		this.paintable = paintable;
		this.shieldName = shieldName;
		this.materialName = materialName;
		this.maxBlockDamage = maxBlockDamage + material.getAttackDamage();
		this.weight = weigth + material.getAttackDamage();
    }
	
	public String getShieldName()
    {
        return shieldName;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(getMaxBlockDamage() + " max damage block");
		tooltip.add(getWeight() + "kg weight");
		if (weight >= 10)
		{
			tooltip.add("Slow movement speed");
		}
        ItemBanner.appendHoverTextFromTileEntityTag(stack, tooltip);
    }
	
	@Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
    	if (getWeight() < 10 || !(entityIn instanceof EntityLivingBase) || (((EntityLivingBase)entityIn).getHeldItemMainhand() != stack && ((EntityLivingBase)entityIn).getHeldItemOffhand() != stack))
    	{
    		return;
    	}
    	((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(2), 40, 1, false, false));
	}
	
	private float getWeight() 
	{
		return weight;
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		return I18n.translateToLocal("item." + materialName + '_' + shieldName + ".name");
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return (int) (12000 * weight);
    }
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == repairItem;
    }

	@Override
	public void registerModels() 
	{
		KnightlyArmory.PROXY.registerItemRenderer(this, 0, "inventory");
	}
	
	public boolean isPaintable()
	{
		return paintable;
	}
	
	public MedievalShieldItem setModel(AbstractModelBase model) 
	{
		this.model = model;
		return this;
	}

	public AbstractModelBase getModel() 
	{
		return model;
	}
	
	public float getMaxBlockDamage() 
	{
		return maxBlockDamage;
	}
	
	public MedievalShieldItem setRepairItem(Item repairItem)
    {
		this.repairItem = repairItem;
		return this;
    }

	public void onBlocked(ItemStack stack, float damage, EntityPlayer player, DamageSource source) 
	{
		float armorPiercingFactor = 1.0f;
		if (source.getTrueSource() instanceof EntityLivingBase)
		{
			EntityLivingBase attacker = (EntityLivingBase)source.getTrueSource();
			if (attacker.getHeldItemMainhand().getItem() instanceof MedievalWeaponItem)
			{
				armorPiercingFactor += ((MedievalWeaponItem)attacker.getHeldItemMainhand().getItem()).armorPiercing / 100.0f;
			}
		}
		
		if (damage > getMaxBlockDamage())
		{
			stack.damageItem((int) (armorPiercingFactor * 0.2f * stack.getMaxDamage()), player);
			float damage1 = damage - getMaxBlockDamage();
			float damage2 = CombatRules.getDamageAfterAbsorb(damage1, (float)player.getTotalArmorValue(), (float)player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue());
			player.attackEntityFrom(DamageSource.GENERIC, damage2);
			return;
		}
		stack.damageItem((int) (armorPiercingFactor * damage), player);
	}

	@Override
    public boolean isShield(ItemStack stack, EntityLivingBase entity)
    {
        return true;
    }
}