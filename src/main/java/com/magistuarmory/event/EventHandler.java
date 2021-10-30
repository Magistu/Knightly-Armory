package com.magistuarmory.event;

import com.magistuarmory.config.ModConfigurations;
import com.magistuarmory.init.ModItems;
import com.magistuarmory.item.MedievalShieldItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;


public class EventHandler
{
    static final ArmorItem[] rustedHelmets = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_HELMET, ModItems.RUSTEDNORMAN_HELMET, ModItems.RUSTEDKETTLEHAT, ModItems.RUSTEDBARBUTE, ModItems.RUSTEDGREATHELM };
    static final ArmorItem[] rustedChestplates = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_CHESTPLATE, ModItems.RUSTEDCRUSADER_CHESTPLATE, ModItems.RUSTEDHALFARMOR_CHESTPLATE };
    static final ArmorItem[] rustedLeggings = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_LEGGINGS };
    static final ArmorItem[] rustedBoots = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_BOOTS, ModItems.RUSTEDCRUSADER_BOOTS };
    static final Item[] rustedMeleeWeapons = new Item[] { ModItems.RUSTEDBASTARDSWORD };

    static final Item[] skeletonWeapons = new Item[] { ModItems.RUSTEDBASTARDSWORD, Items.BOW };

    static final ArmorItem[] witherHelmets = new ArmorItem[] { ModItems.SALLET, ModItems.MAXMILIAN_HELMET };
    static final ArmorItem[] witherChestplates = new ArmorItem[] { ModItems.GOTHIC_CHESTPLATE, ModItems.MAXMILIAN_CHESTPLATE };
    static final ArmorItem[] witherLeggings = new ArmorItem[] { ModItems.GOTHIC_LEGGINGS, ModItems.MAXMILIAN_LEGGINGS };
    static final ArmorItem[] witherBoots = new ArmorItem[] { ModItems.GOTHIC_BOOTS, ModItems.MAXMILIAN_BOOTS };
    static final Item[] witherMeleeWeapons = new Item[] { ModItems.zweihanders.steel, ModItems.flamebladedswords.steel, ModItems.lucernhammers.steel, Items.STONE_SWORD};

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

                if (player.isBlocking() && (activeItem).getItem() instanceof MedievalShieldItem)
                {
                    ((MedievalShieldItem) activeItem.getItem()).onBlocked(activeItem, damage, player, ev.getSource());
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityEvent(EntityJoinWorldEvent ev)
    {
        if (ev != null && ModConfigurations.put_armor_on_mobs.get())
        {
            Entity entity = ev.getEntity();

            if (entity instanceof ZombieEntity && !((ZombieEntity)entity).isBaby() && !(entity instanceof ZombieVillagerEntity))
            {
                entity.setItemSlot(EquipmentSlotType.HEAD, getRandomItemStack(rustedHelmets, 0.5, new Random()));
                entity.setItemSlot(EquipmentSlotType.CHEST, getRandomItemStack(rustedChestplates, 0.5, new Random()));
                entity.setItemSlot(EquipmentSlotType.LEGS, getRandomItemStack(rustedLeggings, 0.5, new Random()));
                entity.setItemSlot(EquipmentSlotType.FEET, getRandomItemStack(rustedBoots, 0.5, new Random()));
                entity.setItemSlot(EquipmentSlotType.MAINHAND, getRandomItemStack(rustedMeleeWeapons, 0.5, new Random()));
            }

            if (entity instanceof SkeletonEntity)
            {
                entity.setItemSlot(EquipmentSlotType.HEAD, getRandomItemStack(rustedHelmets, 0.5, new Random()));
                entity.setItemSlot(EquipmentSlotType.CHEST, getRandomItemStack(rustedChestplates, 0.5, new Random()));
                entity.setItemSlot(EquipmentSlotType.LEGS, getRandomItemStack(rustedLeggings, 0.5, new Random()));
                entity.setItemSlot(EquipmentSlotType.FEET, getRandomItemStack(rustedBoots, 0.5, new Random()));
                entity.setItemSlot(EquipmentSlotType.MAINHAND, getRandomItemStack(skeletonWeapons, 1.0, new Random()));
            }

            if (entity instanceof WitherSkeletonEntity)
            {
                Random rand0 = new Random();
				entity.setItemSlot(EquipmentSlotType.HEAD, getRandomItemStack(witherHelmets, 0.5, rand0));
                entity.setItemSlot(EquipmentSlotType.CHEST, getRandomItemStack(witherChestplates, 0.5, rand0));
                entity.setItemSlot(EquipmentSlotType.LEGS, getRandomItemStack(witherLeggings, 0.5, rand0));
                entity.setItemSlot(EquipmentSlotType.FEET, getRandomItemStack(witherBoots, 0.5, rand0));
                entity.setItemSlot(EquipmentSlotType.MAINHAND, getRandomItemStack(witherMeleeWeapons, 1.0, rand0));
            }
        }
    }

    static ItemStack getRandomItemStack(Item[] items, double chance, Random rand)
    {
        int id = rand.nextInt((int) (items.length / chance));

        return id < items.length ? new ItemStack(items[id]) : ItemStack.EMPTY;
    }
}
