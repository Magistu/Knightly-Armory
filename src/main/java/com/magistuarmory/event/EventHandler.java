package com.magistuarmory.event;

import com.magistuarmory.item.EquipmentHandler;
import com.magistuarmory.item.MedievalShieldItem;

import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.item.ModLoot;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraftforge.eventbus.api.SubscribeEvent;



public class EventHandler
{
    @SubscribeEvent
    public static void onLivingAttackEvent(LivingAttackEvent ev)
    {
        if (ev != null)
        {
            Entity entity = ev.getEntity();
            float damage = ev.getAmount();

            if (entity instanceof PlayerEntity)
            {
                PlayerEntity player = (PlayerEntity) entity;
                ItemStack activeItem = player.getUseItem();

                if (player.isBlocking())
                {
                    if (activeItem.getItem() instanceof MedievalShieldItem)
                    {
                        ((MedievalShieldItem) activeItem.getItem()).onBlock(activeItem, damage, player, ev.getSource());
                    }

                    if (activeItem.getItem() instanceof MedievalWeaponItem)
                    {
                        ((MedievalWeaponItem) activeItem.getItem()).onBlock(activeItem, damage, player, ev.getSource());
                    }
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void onEntityEvent(EntityJoinWorldEvent ev)
    {
        if (ev != null) 
        {
            EquipmentHandler.equip(ev.getEntity());
        }
    }

    @SubscribeEvent
    public static void onLootTableLoadEvent(LootTableLoadEvent ev)
    {
        ModLoot.loadLoot(ev.getName(), ev.getTable());
    }
}
