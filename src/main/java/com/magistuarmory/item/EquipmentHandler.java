package com.magistuarmory.item;

import com.magistuarmory.config.ModConfigurations;
import com.magistuarmory.init.ModItems;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Random;

public class EquipmentHandler {
    static final ArmorItem[] rustedHelmets = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_HELMET.get(), ModItems.RUSTEDNORMAN_HELMET.get(), ModItems.RUSTEDKETTLEHAT.get(), ModItems.RUSTEDBARBUTE.get(), ModItems.RUSTEDGREATHELM.get() };
    static final ArmorItem[] rustedChestplates = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_CHESTPLATE.get(), ModItems.RUSTEDCRUSADER_CHESTPLATE.get(), ModItems.RUSTEDHALFARMOR_CHESTPLATE.get() };
    static final ArmorItem[] rustedLeggings = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_LEGGINGS.get() };
    static final ArmorItem[] rustedBoots = new ArmorItem[] { ModItems.RUSTEDCHAINMAIL_BOOTS.get(), ModItems.RUSTEDCRUSADER_BOOTS.get() };

    static final Item[] rustedMeleeWeapons = new Item[] { ModItems.RUSTEDBASTARDSWORD.get(), ModItems.RUSTEDBASTARDSWORD.get(), ModItems.RUSTEDHEAVYMACE.get() };
    static final Item[] rustedShields = new MedievalShieldItem[] { ModItems.CORRUPTEDROUNDSHIELD.get() };

    static final ArmorItem[] goldenHelmets = new ArmorItem[] { (ArmorItem) Items.GOLDEN_HELMET };
    static final ArmorItem[] goldenChestplates = new ArmorItem[] { (ArmorItem) Items.GOLDEN_CHESTPLATE };
    static final ArmorItem[] goldenLeggings = new ArmorItem[] { (ArmorItem) Items.GOLDEN_LEGGINGS };
    static final ArmorItem[] goldenBoots = new ArmorItem[] { (ArmorItem) Items.GOLDEN_BOOTS };

    static final ArmorItem[] banditHelmets = new ArmorItem[] {};
    static final ArmorItem[] banditChestplates = new ArmorItem[] { ModItems.BRIGANDINE.get() };
    static final ArmorItem[] banditLeggings = new ArmorItem[] {};
    static final ArmorItem[] banditBoots = new ArmorItem[] { ModItems.GAMBESONBOOTS.get() };

    static final Item[] goldenMeleeWeapons = new Item[] { ModItems.bastardswords.gold.get(), ModItems.guisarmes.gold.get(), ModItems.shortswords.gold.get(), ModItems.lochaberaxes.gold.get() };
    static final Item[] goldenShields = new Item[] { ModItems.bucklers.gold.get(), ModItems.targets.gold.get() };

    static final Item[] skeletonRangedWeapons = new Item[] { Items.BOW, ModItems.LONGBOW.get() };

    static final ArmorItem[] witherHelmets = new ArmorItem[] { ModItems.SALLET.get(), ModItems.MAXIMILIAN_HELMET.get() };
    static final ArmorItem[] witherChestplates = new ArmorItem[] { ModItems.GOTHIC_CHESTPLATE.get(), ModItems.MAXIMILIAN_CHESTPLATE.get() };
    static final ArmorItem[] witherLeggings = new ArmorItem[] { ModItems.GOTHIC_LEGGINGS.get(), ModItems.MAXIMILIAN_LEGGINGS.get() };
    static final ArmorItem[] witherBoots = new ArmorItem[] { ModItems.GOTHIC_BOOTS.get(), ModItems.MAXIMILIAN_BOOTS.get() };

    static final Item[] witherMeleeWeapons = new Item[] { ModItems.zweihanders.steel.get(), ModItems.flamebladedswords.steel.get(), ModItems.lucernhammers.steel.get()};

    public static void equip(Entity entity)
    {
        double chance = ModConfigurations.equip_chance.get();

        if (ModConfigurations.equip_monsters.get() && entity.level.getDifficulty().equals(Difficulty.HARD))
        {
            if (entity instanceof Zombie && !((Zombie)entity).isBaby() && !(entity instanceof ZombifiedPiglin) && !(entity instanceof ZombieVillager))
            {
                Random rand0 = new Random();
                setRandomItemSlot(entity, EquipmentSlot.HEAD, rustedHelmets, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.CHEST, rustedChestplates, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.LEGS, rustedLeggings, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.FEET, rustedBoots, chance, rand0);
                if (setRandomItemSlot(entity, EquipmentSlot.MAINHAND, rustedMeleeWeapons, chance, rand0));
                {
                    setRandomItemSlot(entity, EquipmentSlot.OFFHAND, rustedShields, 0.5f * chance, rand0);
                }
            }
            else if (entity instanceof PiglinBrute || entity instanceof ZombifiedPiglin)
            {
                Random rand0 = new Random();
                if ((rand0).nextInt(2) == 1)
                {
                    setRandomItemSlot(entity, EquipmentSlot.HEAD, goldenHelmets, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.CHEST, goldenChestplates, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.LEGS, goldenLeggings, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.FEET, goldenBoots, chance, rand0);
                }
                else
                {
                    setRandomItemSlot(entity, EquipmentSlot.HEAD, banditHelmets, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.CHEST, banditChestplates, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.LEGS, banditLeggings, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.FEET, banditBoots, chance, rand0);
                }
                if (setRandomItemSlot(entity, EquipmentSlot.MAINHAND, goldenMeleeWeapons, chance, rand0));
                {
                    setRandomItemSlot(entity, EquipmentSlot.OFFHAND, goldenShields, 0.5f * chance, rand0);
                }
            }
            else if (entity instanceof Skeleton)
            {
                Random rand0 = new Random();
                setRandomItemSlot(entity, EquipmentSlot.HEAD, rustedHelmets, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.CHEST, rustedChestplates, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.LEGS, rustedLeggings, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.FEET, rustedBoots, chance, rand0);
                if (setRandomItemSlot(entity, EquipmentSlot.MAINHAND, rustedMeleeWeapons, chance, rand0))
                {
                    setRandomItemSlot(entity, EquipmentSlot.OFFHAND, rustedShields, 0.5f * chance, rand0);
                }
                else
                {
                    setRandomItemSlot(entity, EquipmentSlot.MAINHAND, skeletonRangedWeapons, chance, rand0);
                }
            }
            else if (entity instanceof WitherSkeleton)
            {
                Random rand0 = new Random();
                setRandomItemSlot(entity, EquipmentSlot.HEAD, witherHelmets, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.CHEST, witherChestplates, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.LEGS, witherLeggings, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.FEET, witherBoots, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.MAINHAND, witherMeleeWeapons, chance, rand0, Items.STONE_SWORD);
            }
        }
    }

    static boolean setRandomItemSlot(Entity entity, EquipmentSlot slot, Item[] items, double chance, Random rand)
    {
        return setRandomItemSlot(entity, slot, items, chance, rand, Items.AIR);
    }

    static boolean setRandomItemSlot(Entity entity, EquipmentSlot slot, Item[] items, double chance, Random rand, Item defaultItem)
    {
        if (items.length == 0)
        {
            if (ModConfigurations.override_equipment.get());
            {
                entity.setItemSlot(slot, new ItemStack(defaultItem));
            }
            return false;
        }

        int id = rand.nextInt((int) (items.length / chance));

        if (id < items.length)
        {
            entity.setItemSlot(slot, new ItemStack(items[id]));
            return true;
        }
        else if (ModConfigurations.override_equipment.get())
        {
            entity.setItemSlot(slot, new ItemStack(defaultItem));
        }

        return false;
    }
}
