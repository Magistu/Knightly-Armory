package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.util.IHasModel;

import net.minecraft.item.Item;

public class IngridientItem extends Item implements IHasModel
{

	public IngridientItem(String unlocName) {
		super();
		setRegistryName(unlocName);
		setUnlocalizedName(unlocName);
	}
	
	@Override
	public void registerModels() 
	{
		KnightlyArmory.PROXY.registerItemRenderer(this, 0, "inventory");
	}
}
