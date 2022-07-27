package com.magistuarmory.item;

import com.magistuarmory.config.ModConfigurations;
import com.magistuarmory.init.ModItems;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.PiglinBruteEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.Difficulty;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;

import java.util.Random;

public class EquipmentHandler {
    static final ArmorItem[] rustedHelmets = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_HELMET.get(), ModItems.RUSTEDNORMAN_HELMET.get(), ModItems.RUSTEDKETTLEHAT.get(), ModItems.RUSTEDBARBUTE.get(), ModItems.RUSTEDGREATHELM.get() };
    static final ArmorItem[] rustedChestplates = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_CHESTPLATE.get(), ModItems.RUSTEDCRUSADER_CHESTPLATE.get(), ModItems.RUSTEDHALFARMOR_CHESTPLATE.get() };
    static final ArmorItem[] rustedLeggings = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_LEGGINGS.get() };
    static final ArmorItem[] rustedBoots = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_BOOTS.get(), ModItems.RUSTEDCRUSADER_BOOTS.get() };

    static final Item[] rustedMeleeWeapons = new Item[] { ModItems.RUSTEDBASTARDSWORD.get(), ModItems.RUSTEDBASTARDSWORD.get(), ModItems.RUSTEDHEAVYMACE.get() };

    static final ArmorItem[] goldenHelmets = new ArmorItem[] { (ArmorItem) Items.GOLDEN_HELMET };
    static final ArmorItem[] goldenChestplates = new ArmorItem[] { (ArmorItem) Items.GOLDEN_CHESTPLATE };
    static final ArmorItem[] goldenLeggings = new ArmorItem[] { (ArmorItem) Items.GOLDEN_LEGGINGS };
    static final ArmorItem[] goldenBoots = new ArmorItem[] { (ArmorItem) Items.GOLDEN_BOOTS };

    static final ArmorItem[] banditHelmets = new ArmorItem[] {};
    static final ArmorItem[] banditChestplates = new ArmorItem[] { ModItems.BRIGANDINE.get() };
    static final ArmorItem[] banditLeggings = new ArmorItem[] {};
    static final ArmorItem[] banditBoots = new ArmorItem[] { ModItems.GAMBESONBOOTS.get() };

    static final Item[] goldenMeleeWeapons = new Item[] { ModItems.bastardswords.gold.get(), ModItems.guisarmes.gold.get(), ModItems.shortswords.gold.get(), ModItems.lochaberaxes.gold.get() };

    static final Item[] skeletonWeapons = new Item[] { ModItems.RUSTEDBASTARDSWORD.get(), ModItems.RUSTEDBASTARDSWORD.get(), ModItems.RUSTEDHEAVYMACE.get() };

    static final ArmorItem[] witherHelmets = new ArmorItem[] { ModItems.SALLET.get(), ModItems.MAXIMILIAN_HELMET.get() };
    static final ArmorItem[] witherChestplates = new ArmorItem[] { ModItems.GOTHIC_CHESTPLATE.get(), ModItems.MAXIMILIAN_CHESTPLATE.get() };
    static final ArmorItem[] witherLeggings = new ArmorItem[] { ModItems.GOTHIC_LEGGINGS.get(), ModItems.MAXIMILIAN_LEGGINGS.get() };
    static final ArmorItem[] witherBoots = new ArmorItem[] { ModItems.GOTHIC_BOOTS.get(), ModItems.MAXIMILIAN_BOOTS.get() };
    static final Item[] witherMeleeWeapons = new Item[] { ModItems.zweihanders.steel.get(), ModItems.flamebladedswords.steel.get(), ModItems.lucernhammers.steel.get()};

    public static void equip(Entity entity)
    {
        float chance = ModConfigurations.put_armor_chance.get();

        if (ModConfigurations.put_armor_on_mobs.get() && entity.level.getDifficulty().equals(Difficulty.HARD))
        {
            if (entity instanceof ZombieEntity && !((ZombieEntity)entity).isBaby() && !(entity instanceof ZombifiedPiglinEntity) && !(entity instanceof ZombieVillagerEntity))
            {
                Random rand0 = new Random();
                setRandomItemSlot(entity, EquipmentSlotType.HEAD, rustedHelmets, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.CHEST, rustedChestplates, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.LEGS, rustedLeggings, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.FEET, rustedBoots, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.MAINHAND, rustedMeleeWeapons, chance, rand0);
            }

            if (entity instanceof PiglinBruteEntity || entity instanceof ZombifiedPiglinEntity)
            {
                Random rand0 = new Random();
                if ((rand0).nextInt(2) == 1)
                {
                    setRandomItemSlot(entity, EquipmentSlotType.HEAD, goldenHelmets, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlotType.CHEST, goldenChestplates, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlotType.LEGS, goldenLeggings, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlotType.FEET, goldenBoots, chance, rand0);
                }
                else
                {
                    setRandomItemSlot(entity, EquipmentSlotType.HEAD, banditHelmets, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlotType.CHEST, banditChestplates, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlotType.LEGS, banditLeggings, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlotType.FEET, banditBoots, chance, rand0);
                }
                setRandomItemSlot(entity, EquipmentSlotType.MAINHAND, goldenMeleeWeapons, chance, rand0, Items.GOLDEN_SWORD);

            }

            if (entity instanceof SkeletonEntity)
            {
                Random rand0 = new Random();
                setRandomItemSlot(entity, EquipmentSlotType.HEAD, rustedHelmets, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.CHEST, rustedChestplates, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.LEGS, rustedLeggings, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.FEET, rustedBoots, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.MAINHAND, skeletonWeapons, chance, rand0, Items.BOW);
            }

            if (entity instanceof WitherSkeletonEntity)
            {
                Random rand0 = new Random();
                setRandomItemSlot(entity, EquipmentSlotType.HEAD, witherHelmets, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.CHEST, witherChestplates, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.LEGS, witherLeggings, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.FEET, witherBoots, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlotType.MAINHAND, witherMeleeWeapons, chance, rand0, Items.STONE_SWORD);
            }
        }
    }
    
    static void setRandomItemSlot(Entity entity, EquipmentSlotType slot, Item[] items, double chance, Random rand)
    {
        setRandomItemSlot(entity, slot, items, chance, rand, Items.AIR);
    }

    static void setRandomItemSlot(Entity entity, EquipmentSlotType slot, Item[] items, double chance, Random rand, Item defaultItem)
    {
        if (items.length == 0)
        {
            if (ModConfigurations.override_equipment.get());
            {
                entity.setItemSlot(slot, new ItemStack(defaultItem));
            }
            return;
        }

        int id = rand.nextInt((int) (items.length / chance));

        if (id < items.length)
        {
            entity.setItemSlot(slot, new ItemStack(items[id]));
        } 
        else if (ModConfigurations.override_equipment.get()) 
        {
            entity.setItemSlot(slot, new ItemStack(defaultItem));
        }
    }
}
