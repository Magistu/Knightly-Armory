package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class XIVCenturyKnightItem extends ArmorItem
{
    public XIVCenturyKnightItem(String unlocName, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties)
    {
        super(materialIn, slot, properties);
        setRegistryName(unlocName);
    }

    public <A extends net.minecraft.client.renderer.entity.model.BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default)
    {
        return (KnightlyArmory.PROXY instanceof ClientProxy) ? (A)((ClientProxy)KnightlyArmory.PROXY).getXIVCenturyKnightModel(armorSlot) : null;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
        if (player.inventory.armor.get(3).getItem().equals(this) && world.isClientSide && player.isModelPartShown(PlayerModelPart.HAT))
        {
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.HAT);
        }
    }
}
