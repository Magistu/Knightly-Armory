package com.magistuarmory.init;


import com.google.common.collect.ImmutableMap;
import com.magistuarmory.KnightlyArmory;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(modid = KnightlyArmory.ID)
public class MerchOffers
{
	@SubscribeEvent
	public static void addTrade(VillagerTradesEvent ev)
	{
		if (ev.getType() == VillagerProfession.SHEPHERD)
		{
			List<VillagerTrades.ItemListing> trades = ev.getTrades().get(1);
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.APOSTOLIC_CROSS_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.BOWL_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.BULL_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.CHESS_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.CRUSADER_CROSS_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.DRAGON_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.EAGLE_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.HORSE_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.LILY_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.LION1_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.LION2_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.ORTHODOX_CROSS_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.SNAKE_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.SUN_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.SWORDS_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.TOWER_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.TREE_PATTERN.get()), 100, 0));
			trades.add(new BasicItemListing(1, new ItemStack(ModItems.TWOHEADED_EAGLE_PATTERN.get()), 100, 0));
		}



	}

	private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> p_35631_)
	{
		return new Int2ObjectOpenHashMap<>(p_35631_);
	}
}
