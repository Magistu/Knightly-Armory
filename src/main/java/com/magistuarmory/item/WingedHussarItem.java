package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class WingedHussarItem extends ArmorItem
{
    public WingedHussarItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties properties)
    {
        super(materialIn, slot, properties);
    }

    public <A extends net.minecraft.client.renderer.entity.model.BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default)
    {
        return (KnightlyArmory.PROXY instanceof ClientProxy) ? (A)((ClientProxy)KnightlyArmory.PROXY).getWingedHussarModel(armorSlot) : null;
    }
}
