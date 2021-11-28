package com.magistuarmory.event;

import com.magistuarmory.config.ModConfigurations;
import com.magistuarmory.init.ModItems;
import com.magistuarmory.item.MedievalShieldItem;

import com.magistuarmory.item.MedievalWeaponItem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.PiglinBruteEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.world.Difficulty;
import net.minecraftforge.event.TickEvent;
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

    static final Item[] rustedMeleeWeapons = new Item[] { ModItems.RUSTEDBASTARDSWORD, ModItems.RUSTEDBASTARDSWORD, ModItems.RUSTEDHEAVYMACE };

    static final ArmorItem[] goldenHelmets = new ArmorItem[] { (ArmorItem) Items.GOLDEN_HELMET };
    static final ArmorItem[] goldenChestplates = new ArmorItem[] { (ArmorItem) Items.GOLDEN_CHESTPLATE };
    static final ArmorItem[] goldenLeggings = new ArmorItem[] { (ArmorItem) Items.GOLDEN_LEGGINGS };
    static final ArmorItem[] goldenBoots = new ArmorItem[] { (ArmorItem) Items.GOLDEN_BOOTS };

    static final ArmorItem[] banditHelmets = new ArmorItem[] {};
    static final ArmorItem[] banditChestplates = new ArmorItem[] { ModItems.BRIGANDINE };
    static final ArmorItem[] banditLeggings = new ArmorItem[] {};
    static final ArmorItem[] banditBoots = new ArmorItem[] { ModItems.GAMBESONBOOTS };

    static final Item[] goldenMeleeWeapons = new Item[] { ModItems.bastardswords.gold, ModItems.guisarmes.gold, ModItems.shortswords.gold, ModItems.lochaberaxes.gold };

    static final Item[] skeletonWeapons = new Item[] { ModItems.RUSTEDBASTARDSWORD, ModItems.RUSTEDBASTARDSWORD, ModItems.RUSTEDHEAVYMACE };

    static final ArmorItem[] witherHelmets = new ArmorItem[] { ModItems.SALLET, ModItems.MAXIMILIAN_HELMET };
    static final ArmorItem[] witherChestplates = new ArmorItem[] { ModItems.GOTHIC_CHESTPLATE, ModItems.MAXIMILIAN_CHESTPLATE };
    static final ArmorItem[] witherLeggings = new ArmorItem[] { ModItems.GOTHIC_LEGGINGS, ModItems.MAXIMILIAN_LEGGINGS };
    static final ArmorItem[] witherBoots = new ArmorItem[] { ModItems.GOTHIC_BOOTS, ModItems.MAXIMILIAN_BOOTS };
    static final Item[] witherMeleeWeapons = new Item[] { ModItems.zweihanders.steel, ModItems.flamebladedswords.steel, ModItems.lucernhammers.steel};

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
                        ((MedievalShieldItem) activeItem.getItem()).onBlocked(activeItem, damage, player, ev.getSource());
                    }

                    if (activeItem.getItem() instanceof MedievalWeaponItem)
                    {
                        ((MedievalWeaponItem) activeItem.getItem()).onBlocked(activeItem, damage, player, ev.getSource());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityEvent(EntityJoinWorldEvent ev)
    {
        float chance = ModConfigurations.put_armor_chance.get();

        if (ev != null && ModConfigurations.put_armor_on_mobs.get() && ev.getWorld().getDifficulty().equals(Difficulty.HARD))
        {
            Entity entity = ev.getEntity();

            if (entity instanceof ZombieEntity && !((ZombieEntity)entity).isBaby() && !(entity instanceof ZombifiedPiglinEntity) && !(entity instanceof ZombieVillagerEntity))
            {
                entity.setItemSlot(EquipmentSlotType.HEAD, getRandomItemStack(rustedHelmets, chance, new Random()));
                entity.setItemSlot(EquipmentSlotType.CHEST, getRandomItemStack(rustedChestplates, chance, new Random()));
                entity.setItemSlot(EquipmentSlotType.LEGS, getRandomItemStack(rustedLeggings, chance, new Random()));
                entity.setItemSlot(EquipmentSlotType.FEET, getRandomItemStack(rustedBoots, chance, new Random()));
                entity.setItemSlot(EquipmentSlotType.MAINHAND, getRandomItemStack(rustedMeleeWeapons, chance, new Random()));
            }

            if (entity instanceof PiglinBruteEntity || entity instanceof ZombifiedPiglinEntity)
            {
                if ((new Random()).nextInt(2) == 1)
                {
                    entity.setItemSlot(EquipmentSlotType.HEAD, getRandomItemStack(goldenHelmets, chance, new Random()));
                    entity.setItemSlot(EquipmentSlotType.CHEST, getRandomItemStack(goldenChestplates, chance, new Random()));
                    entity.setItemSlot(EquipmentSlotType.LEGS, getRandomItemStack(goldenLeggings, chance, new Random()));
                    entity.setItemSlot(EquipmentSlotType.FEET, getRandomItemStack(goldenBoots, chance, new Random()));
                }
                else
                {
                    entity.setItemSlot(EquipmentSlotType.HEAD, getRandomItemStack(banditHelmets, chance, new Random()));
                    entity.setItemSlot(EquipmentSlotType.CHEST, getRandomItemStack(banditChestplates, chance, new Random()));
                    entity.setItemSlot(EquipmentSlotType.LEGS, getRandomItemStack(banditLeggings, chance, new Random()));
                    entity.setItemSlot(EquipmentSlotType.FEET, getRandomItemStack(banditBoots, chance, new Random()));
                }
                entity.setItemSlot(EquipmentSlotType.MAINHAND, getRandomItemStack(goldenMeleeWeapons, chance, new Random(), Items.GOLDEN_SWORD));

            }

            if (entity instanceof SkeletonEntity)
            {
                entity.setItemSlot(EquipmentSlotType.HEAD, getRandomItemStack(rustedHelmets, chance, new Random()));
                entity.setItemSlot(EquipmentSlotType.CHEST, getRandomItemStack(rustedChestplates, chance, new Random()));
                entity.setItemSlot(EquipmentSlotType.LEGS, getRandomItemStack(rustedLeggings, chance, new Random()));
                entity.setItemSlot(EquipmentSlotType.FEET, getRandomItemStack(rustedBoots, chance, new Random()));
                entity.setItemSlot(EquipmentSlotType.MAINHAND, getRandomItemStack(skeletonWeapons, chance, new Random(), Items.BOW));
            }

            if (entity instanceof WitherSkeletonEntity)
            {
                Random rand0 = new Random();
				entity.setItemSlot(EquipmentSlotType.HEAD, getRandomItemStack(witherHelmets, chance, rand0));
                entity.setItemSlot(EquipmentSlotType.CHEST, getRandomItemStack(witherChestplates, chance, rand0));
                entity.setItemSlot(EquipmentSlotType.LEGS, getRandomItemStack(witherLeggings, chance, rand0));
                entity.setItemSlot(EquipmentSlotType.FEET, getRandomItemStack(witherBoots, chance, rand0));
                entity.setItemSlot(EquipmentSlotType.MAINHAND, getRandomItemStack(witherMeleeWeapons, chance, rand0, Items.STONE_SWORD));
            }
        }
    }

    static ItemStack getRandomItemStack(Item[] items, double chance, Random rand)
    {
        return getRandomItemStack(items, chance, rand, Items.AIR);
    }

    static ItemStack getRandomItemStack(Item[] items, double chance, Random rand, Item defaultItem)
    {
        if (items.length == 0)
        {
            return new ItemStack(defaultItem);
        }

        int id = rand.nextInt((int) (items.length / chance));

        return id < items.length ? new ItemStack(items[id]) : new ItemStack(defaultItem);
    }
}
