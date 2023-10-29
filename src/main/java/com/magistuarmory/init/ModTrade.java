package com.magistuarmory.init;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.entity.TradeList;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

@EventBusSubscriber(modid = KnightlyArmory.ID)
public class ModTrade
{
	public static void addTrade()
	{
		VillagerProfession professionInstance = ForgeRegistries.VILLAGER_PROFESSIONS.getValue(new ResourceLocation("librarian"));

		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.APOSTOLIC_CROSS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.BOWL_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.BULL_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.CHESS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.CRUSADER_CROSS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.DRAGON_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.EAGLE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.HORSE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.LILY_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.LION1_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.LION2_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.ORTHODOX_CROSS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.SNAKE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.SUN_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.SWORDS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.TOWER_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.TREE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(0).addTrade(1, new TradeList(ModItems.TWOHEADED_EAGLE_PATTERN, new EntityVillager.PriceInfo(1, 1)));

		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.APOSTOLIC_CROSS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.BOWL_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.BULL_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.CHESS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.CRUSADER_CROSS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.DRAGON_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.EAGLE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.HORSE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.LILY_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.LION1_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.LION2_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.ORTHODOX_CROSS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.SNAKE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.SUN_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.SWORDS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.TOWER_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.TREE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(1).addTrade(1, new TradeList(ModItems.TWOHEADED_EAGLE_PATTERN, new EntityVillager.PriceInfo(1, 1)));

		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.APOSTOLIC_CROSS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.BOWL_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.BULL_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.CHESS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.CRUSADER_CROSS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.DRAGON_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.EAGLE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.HORSE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.LILY_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.LION1_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.LION2_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.ORTHODOX_CROSS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.SNAKE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.SUN_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.SWORDS_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.TOWER_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.TREE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
		professionInstance.getCareer(2).addTrade(1, new TradeList(ModItems.TWOHEADED_EAGLE_PATTERN, new EntityVillager.PriceInfo(1, 1)));
	}
}
