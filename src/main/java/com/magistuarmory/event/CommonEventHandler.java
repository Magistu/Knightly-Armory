package com.magistuarmory.event;

import com.magistuarmory.item.MedievalShieldItem;

import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.item.EquipmentHandler;
import com.magistuarmory.item.ModLoot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommonEventHandler
{
    @SubscribeEvent
    public static void onLivingAttackEvent(LivingAttackEvent ev)
    {
        if (ev != null)
        {
            Entity entity = ev.getEntity();
            float damage = ev.getAmount();

            if (entity instanceof Player player)
            {
                ItemStack activeItem = player.getUseItem();

                if (player.isBlocking() && (activeItem).getItem() instanceof MedievalShieldItem)
                {
                    ((MedievalShieldItem) activeItem.getItem()).onBlocked(activeItem, damage, player, ev.getSource());
                }

                if (player.isBlocking() && activeItem.getItem() instanceof MedievalWeaponItem && ((MedievalWeaponItem) activeItem.getItem()).canBlock())
                {
                    ((MedievalWeaponItem) activeItem.getItem()).onBlocked(activeItem, damage, player, ev.getSource());
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityJoinLevelEvent(EntityJoinLevelEvent ev)
    {
        if (ev != null) 
        {
            EquipmentHandler.equip(ev.getEntity());
        }
    }

    @SubscribeEvent
    public static void onLivingHurtEvent(LivingHurtEvent ev)
    {
        if (ev.getSource().getEntity() instanceof LivingEntity damager && damager.getMainHandItem().getItem() instanceof MedievalWeaponItem weapon)
        {
            weapon.onHurtEntity((LivingEntity) ev.getSource().getEntity(), ev.getEntity(), ev.getAmount());
        }
    }

    @SubscribeEvent
    public static void onLootTableLoadEvent(LootTableLoadEvent ev) 
    {
        ModLoot.loadLoot(ev.getName(), ev.getTable());
    }

}