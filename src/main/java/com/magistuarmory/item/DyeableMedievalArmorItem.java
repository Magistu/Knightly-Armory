package com.magistuarmory.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class DyeableMedievalArmorItem extends MedievalArmorItem implements IDyeableArmorItem
{
    int defaultcolor;

    public DyeableMedievalArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties properties, int defaultcolor)
    {
        super(materialIn, slot, properties);
        this.defaultcolor = defaultcolor;
    }

    @Override
    public int getColor(ItemStack p_200886_1_)
    {
        CompoundNBT compoundnbt = p_200886_1_.getTagElement("display");
        return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : defaultcolor;
    }
}
