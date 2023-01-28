package com.magistuarmory.event;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = KnightlyArmory.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeModeTabEventHandler {
	@SubscribeEvent
	public static void onCreativeModeTabRegisterEvent(CreativeModeTabEvent.Register ev)
	{
		ModItems.GROUP_KA = ev.registerCreativeModeTab(new ResourceLocation(KnightlyArmory.ID, "armor"), builder -> builder.icon(() -> new ItemStack(ModItems.ARMET.get())).title(Component.translatable("itemGroup." + KnightlyArmory.ID + ".armor")));
		ModItems.GROUP_KPW = ev.registerCreativeModeTab(new ResourceLocation(KnightlyArmory.ID, "particular_weapons"), builder -> builder.icon(() -> new ItemStack(ModItems.NOBLE_SWORD.get())).title(Component.translatable("itemGroup." + KnightlyArmory.ID + ".particular_weapons")));
		ModItems.GROUP_KW = ev.registerCreativeModeTab(new ResourceLocation(KnightlyArmory.ID, "weapons"), builder -> builder.icon(() -> new ItemStack(ModItems.flamebladedswords.iron.get())).title(Component.translatable("itemGroup." + KnightlyArmory.ID + ".weapons")));
		ModItems.GROUP_KS = ev.registerCreativeModeTab(new ResourceLocation(KnightlyArmory.ID, "shields"), builder -> builder.icon(() -> new ItemStack(ModItems.heatershields.iron.get())).title(Component.translatable("itemGroup." + KnightlyArmory.ID + ".shields")));
	}

	@SubscribeEvent
	public static void onCreativeModeTabBuildContentsEvent(CreativeModeTabEvent.BuildContents ev)
	{
		if (ev.getTab() == CreativeModeTabs.INGREDIENTS)
		{
			ModItems.materialItems.forEach(e -> ev.accept(new ItemStack(e.get())));
		}

		if (ev.getTab() == ModItems.GROUP_KA)
		{
			ModItems.armorItems.forEach(e -> ev.accept(new ItemStack(e.get())));
		}

		if (ev.getTab() == ModItems.GROUP_KPW)
		{
			ModItems.particularWeaponItems.forEach(e -> ev.accept(new ItemStack(e.get())));
		}

		if (ev.getTab() == ModItems.GROUP_KW)
		{
			for (ModItems.WeaponsSupply supply : ModItems.weaponsSupply)
			{
				supply.get().forEach(e -> ev.accept(new ItemStack(e.get())));
			}
		}

		if (ev.getTab() == ModItems.GROUP_KS)
		{
			for (ModItems.ShieldsSupply supply : ModItems.shieldsSupply)
			{
				supply.get().forEach(e -> ev.accept(new ItemStack(e.get())));
			}
		}
	}
}
