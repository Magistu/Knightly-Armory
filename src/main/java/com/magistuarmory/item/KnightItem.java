package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;

public class KnightItem extends ArmorItem implements INoHatLayer, ISurcoat, IDyeableArmorItem
{
    public KnightItem(IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties)
    {
        super(materialIn, slot, properties);
    }

    public <A extends net.minecraft.client.renderer.entity.model.BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default)
    {
        return (KnightlyArmory.PROXY instanceof ClientProxy) ? (A)((ClientProxy)KnightlyArmory.PROXY).getKnightModel(armorSlot) : null;
    }

    @Override
    public int getColor(ItemStack p_200886_1_)
    {
        CompoundNBT compoundnbt = p_200886_1_.getTagElement("display");
        return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : -10092544;
    }
}
