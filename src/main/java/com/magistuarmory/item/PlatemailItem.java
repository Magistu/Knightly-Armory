package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.model.entity.BascinetModel;
import com.magistuarmory.client.renderer.model.entity.KettlehatModel;
import com.magistuarmory.client.renderer.model.entity.MaximilianHelmetModel;
import com.magistuarmory.proxy.ClientProxy;
import com.magistuarmory.util.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlatemailItem extends ItemArmor implements IHasModel {
	
	KettlehatModel model;
	
	public PlatemailItem(String unlocName, ArmorMaterial materialIn, int renderId, EntityEquipmentSlot slot) {
		super(materialIn, renderId, slot);
		setRegistryName(unlocName);
		setUnlocalizedName(unlocName);
		
		if (KnightlyArmory.PROXY instanceof ClientProxy)
		{
			model = new KettlehatModel();
		}
	}
	
	@Override
	public void registerModels() 
	{
		KnightlyArmory.PROXY.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default)
	{
		if(itemStack != ItemStack.EMPTY)
		{
			if (armorSlot == EntityEquipmentSlot.HEAD)
			{
				if (itemStack.getItem() instanceof ItemArmor)
				{
					model.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					
					model.isChild = _default.isChild;
					model.isRiding = _default.isRiding;
					model.isSneak = _default.isSneak;
					model.rightArmPose = _default.rightArmPose;
					model.leftArmPose = _default.leftArmPose;
					
					return model;
				}
			}
			else
			{
				super.getArmorModel(entityLiving, itemStack, armorSlot, _default);
			}
		}
		
		return null;
	}
}
