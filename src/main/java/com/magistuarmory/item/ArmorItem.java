package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.util.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

import net.minecraft.item.ItemStack;

public class ArmorItem extends ItemArmor implements IHasModel {
	
	public ArmorItem(String unlocName, ArmorMaterial materialIn, int renderId, EntityEquipmentSlot slot) 
	{
		super(materialIn, renderId, slot);
		setRegistryName(unlocName);
		setUnlocalizedName(unlocName);
	}
	
	@Override
	public void registerModels() 
	{
		KnightlyArmory.PROXY.registerItemRenderer(this, 0, "inventory");
	}
}
