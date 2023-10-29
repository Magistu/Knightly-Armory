package com.magistuarmory.event;

import java.util.Random;

import com.magistuarmory.init.ModItems;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.config.ModConfigurations;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ModEvent 
{
    static final ItemArmor[] rustedHelmets = new ItemArmor[] { ModItems.RUSTEDCHAINMAIL_HELMET, ModItems.RUSTEDNORMAN_HELMET, ModItems.RUSTEDKETTLEHAT, ModItems.RUSTEDBARBUTE, ModItems.RUSTEDGREATHELM };
    static final ItemArmor[] rustedChestplates = new ItemArmor[] { ModItems.RUSTEDCHAINMAIL_CHESTPLATE, ModItems.RUSTEDCRUSADER_CHESTPLATE, ModItems.RUSTEDHALFARMOR_CHESTPLATE };
    static final ItemArmor[] rustedLeggings = new ItemArmor[] { ModItems.RUSTEDCHAINMAIL_LEGGINGS };
    static final ItemArmor[] rustedBoots = new ItemArmor[] { ModItems.RUSTEDCHAINMAIL_BOOTS, ModItems.RUSTEDCRUSADER_BOOTS };

    static final Item[] rustedMeleeWeapons = new Item[] { ModItems.RUSTEDBASTARDSWORD, ModItems.RUSTEDBASTARDSWORD, ModItems.RUSTEDHEAVYMACE };

    static final ItemArmor[] goldenHelmets = new ItemArmor[] { Items.GOLDEN_HELMET };
    static final ItemArmor[] goldenChestplates = new ItemArmor[] { Items.GOLDEN_CHESTPLATE };
    static final ItemArmor[] goldenLeggings = new ItemArmor[] { Items.GOLDEN_LEGGINGS };
    static final ItemArmor[] goldenBoots = new ItemArmor[] { Items.GOLDEN_BOOTS };

    static final ItemArmor[] banditHelmets = new ItemArmor[] {};
    static final ItemArmor[] banditChestplates = new ItemArmor[] { ModItems.BRIGANDINE };
    static final ItemArmor[] banditLeggings = new ItemArmor[] {};
    static final ItemArmor[] banditBoots = new ItemArmor[] { ModItems.GAMBESONBOOTS };

    static final Item[] goldenMeleeWeapons = new Item[] { ModItems.bastardswords.gold, ModItems.guisarmes.gold, ModItems.shortswords.gold, ModItems.lochaberaxes.gold };

    static final Item[] skeletonWeapons = new Item[] { ModItems.RUSTEDBASTARDSWORD, ModItems.RUSTEDBASTARDSWORD, ModItems.RUSTEDHEAVYMACE };

    static final ItemArmor[] witherHelmets = new ItemArmor[] { ModItems.SALLET, ModItems.MAXIMILIAN_HELMET };
    static final ItemArmor[] witherChestplates = new ItemArmor[] { ModItems.GOTHIC_CHESTPLATE, ModItems.MAXIMILIAN_CHESTPLATE };
    static final ItemArmor[] witherLeggings = new ItemArmor[] { ModItems.GOTHIC_LEGGINGS, ModItems.MAXIMILIAN_LEGGINGS };
    static final ItemArmor[] witherBoots = new ItemArmor[] { ModItems.GOTHIC_BOOTS, ModItems.MAXIMILIAN_BOOTS };
    static final Item[] witherMeleeWeapons = new Item[] { ModItems.zweihanders.steel, ModItems.flamebladedswords.steel, ModItems.lucernhammers.steel};

    @SubscribeEvent
    public void onEntityAttacked(LivingAttackEvent ev)
    {
        Entity entity = ev != null ? ev.getEntity() : null;
        float damage = ev.getAmount();
        if (entity != null && entity instanceof EntityPlayer) 
        {
            EntityPlayer player = (EntityPlayer)entity;
            ItemStack activeItem = player.getActiveItemStack();

            if (player.isActiveItemStackBlocking() && (activeItem).getItem() instanceof MedievalShieldItem) 
            {
                ((MedievalShieldItem)activeItem.getItem()).onBlocked(activeItem, damage, player, ev.getSource());
            }
        }
    }
    
    @SubscribeEvent
    public static void onEntityEvent(EntityJoinWorldEvent ev)
    {
        float chance = ModConfigurations.put_armor_chance;

        if (ev != null && ModConfigurations.put_armor_on_mobs && ev.getWorld().getDifficulty().equals(EnumDifficulty.HARD))
        {
            Entity entity = ev.getEntity();

            if (entity instanceof EntityZombie && !((EntityZombie) entity).isChild() && !(entity instanceof EntityZombieVillager) && !(entity instanceof EntityPigZombie))
            {
                entity.setItemStackToSlot(EntityEquipmentSlot.HEAD, getRandomItemStack(rustedHelmets, chance, new Random()));
                entity.setItemStackToSlot(EntityEquipmentSlot.CHEST, getRandomItemStack(rustedChestplates, chance, new Random()));
                entity.setItemStackToSlot(EntityEquipmentSlot.LEGS, getRandomItemStack(rustedLeggings, chance, new Random()));
                entity.setItemStackToSlot(EntityEquipmentSlot.FEET, getRandomItemStack(rustedBoots, chance, new Random()));
                entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, getRandomItemStack(rustedMeleeWeapons, chance, new Random()));
            }

            if (entity instanceof EntityPigZombie)
            {
                if ((new Random()).nextInt(2) == 1)
                {
                    entity.setItemStackToSlot(EntityEquipmentSlot.HEAD, getRandomItemStack(goldenHelmets, chance, new Random()));
                    entity.setItemStackToSlot(EntityEquipmentSlot.CHEST, getRandomItemStack(goldenChestplates, chance, new Random()));
                    entity.setItemStackToSlot(EntityEquipmentSlot.LEGS, getRandomItemStack(goldenLeggings, chance, new Random()));
                    entity.setItemStackToSlot(EntityEquipmentSlot.FEET, getRandomItemStack(goldenBoots, chance, new Random()));
                }
                else
                {
                    entity.setItemStackToSlot(EntityEquipmentSlot.HEAD, getRandomItemStack(banditHelmets, chance, new Random()));
                    entity.setItemStackToSlot(EntityEquipmentSlot.CHEST, getRandomItemStack(banditChestplates, chance, new Random()));
                    entity.setItemStackToSlot(EntityEquipmentSlot.LEGS, getRandomItemStack(banditLeggings, chance, new Random()));
                    entity.setItemStackToSlot(EntityEquipmentSlot.FEET, getRandomItemStack(banditBoots, chance, new Random()));
                }
                entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, getRandomItemStack(goldenMeleeWeapons, chance, new Random(), Items.GOLDEN_SWORD));

            }

            if (entity instanceof EntitySkeleton)
            {
                entity.setItemStackToSlot(EntityEquipmentSlot.HEAD, getRandomItemStack(rustedHelmets, chance, new Random()));
                entity.setItemStackToSlot(EntityEquipmentSlot.CHEST, getRandomItemStack(rustedChestplates, chance, new Random()));
                entity.setItemStackToSlot(EntityEquipmentSlot.LEGS, getRandomItemStack(rustedLeggings, chance, new Random()));
                entity.setItemStackToSlot(EntityEquipmentSlot.FEET, getRandomItemStack(rustedBoots, chance, new Random()));
                entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, getRandomItemStack(skeletonWeapons, chance, new Random(), Items.BOW));
            }

            if (entity instanceof EntityWitherSkeleton)
            {
                Random rand0 = new Random();
                entity.setItemStackToSlot(EntityEquipmentSlot.HEAD, getRandomItemStack(witherHelmets, chance, rand0));
                entity.setItemStackToSlot(EntityEquipmentSlot.CHEST, getRandomItemStack(witherChestplates, chance, rand0));
                entity.setItemStackToSlot(EntityEquipmentSlot.LEGS, getRandomItemStack(witherLeggings, chance, rand0));
                entity.setItemStackToSlot(EntityEquipmentSlot.FEET, getRandomItemStack(witherBoots, chance, rand0));
                entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, getRandomItemStack(witherMeleeWeapons, chance, rand0, Items.STONE_SWORD));
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTickEvent(TickEvent.PlayerTickEvent ev)
    {
        EntityPlayer player = ev.player;
        if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty() && ev.side.isClient() && !player.isWearing(EnumPlayerModelParts.HAT))
        {
			Minecraft.getMinecraft().gameSettings.setModelPartEnabled(EnumPlayerModelParts.HAT, true);
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