package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class XIVCenturyKnightItem extends ArmorItem implements INoHatLayer, ISurcoat
{
    public XIVCenturyKnightItem(IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties)
    {
        super(materialIn, slot, properties);
    }

    public <A extends net.minecraft.client.renderer.entity.model.BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default)
    {
        return (KnightlyArmory.PROXY instanceof ClientProxy) ? (A)((ClientProxy)KnightlyArmory.PROXY).getXIVCenturyKnightModel(armorSlot) : null;
    }
}
