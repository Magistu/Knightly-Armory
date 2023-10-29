package com.magistuarmory.item;
import net.minecraft.item.ItemStack;

public class BlacksmithHammerItem extends MedievalWeaponItem
{

	public BlacksmithHammerItem(String unlocName, ToolMaterial material, float baseAttackDamage, float materialFactor, float baseAttackSpeed, int armorPiercing) 
	{
		super(unlocName, material, baseAttackDamage, materialFactor, baseAttackSpeed, armorPiercing, 0.0f);
	}
	
	/*
	 * @Override public ItemStack getContainerItem(ItemStack itemstack) { ItemStack
	 * retval = new ItemStack((IItemProvider)this);
	 * retval.setDamageValue(itemstack.getDamageValue() + 1); if
	 * (retval.getDamageValue() >= retval.getMaxDamage()) { return ItemStack.EMPTY;
	 * } return retval; }
	 */
}
