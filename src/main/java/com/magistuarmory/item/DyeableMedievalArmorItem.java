package com.magistuarmory.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public class DyeableMedievalArmorItem extends MedievalArmorItem implements DyeableLeatherItem
{
    int defaultcolor;

	public DyeableMedievalArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties properties, int defaultcolor)
    {
        super(materialIn, slot, properties);
        this.defaultcolor = defaultcolor;
    }

    @Override
    public int getColor(ItemStack p_200886_1_)
    {
        CompoundTag compoundnbt = p_200886_1_.getTagElement("display");
        return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : defaultcolor;
    }
}
