package com.magistuarmory.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

public class BlacksmithHammerItem extends MedievalWeaponItem
{
    public BlacksmithHammerItem(String unlocName, Item.Properties build, IItemTier material, float attackDamage, float materialFactor, float attackSpeed)
    {
        super(unlocName, build, material, attackDamage, materialFactor, attackSpeed);
    }

    public ItemStack getContainerItem(ItemStack itemstack)
    {
        ItemStack retval = new ItemStack(this);
        retval.setDamageValue(itemstack.getDamageValue() + 1);
        if (retval.getDamageValue() >= retval.getMaxDamage())
        {
            return ItemStack.EMPTY;
        }
        return retval;
    }
}
