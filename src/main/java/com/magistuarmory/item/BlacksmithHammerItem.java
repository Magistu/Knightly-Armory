package com.magistuarmory.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

public class BlacksmithHammerItem extends MedievalWeaponItem
{
    public BlacksmithHammerItem(Item.Properties build, IItemTier material, float baseAttackDamage, float baseAttackSpeed, float weight)
    {
        super(build, material, baseAttackDamage, baseAttackSpeed, weight);
    }
}
