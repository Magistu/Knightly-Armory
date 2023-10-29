package com.magistuarmory.config;

import java.io.File;

import com.magistuarmory.KnightlyArmory;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class ModConfigurations
{
	public static Configuration config;

    public static boolean put_armor_on_mobs;
	public static float put_armor_chance;
    public static boolean steel_enabled;

    public static void init(File configDirectory)
	{
		File configFile = new File(configDirectory, "epic-knights.cfg");

		if (config == null)
		{
			config = new Configuration(configFile, "2.0");
		}
		
		loadConfig();
	}
    
    @SubscribeEvent
	public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent ev) 
	{
		if (ev.getModID().equalsIgnoreCase(KnightlyArmory.ID))
		{
			loadConfig();
		}
	}
	
	
	private static void loadConfig() 
	{
		put_armor_on_mobs = config.getBoolean("putArmorOnMobs", "global", true, "Works only if the game is set to the hard difficulty. Affects whether or not mobs will wear armor from the mod.");
		put_armor_chance = config.getFloat("putArmorChance", "global", 0.5f, 0.0f, 1.0f, "Works only if the game is set to the hard difficulty. Affects the chance that mobs will wear armor from the mod.");
		steel_enabled = config.getBoolean("steelEnabled", "global", true, "Enable steel crafting recipe.");

		if (config.hasChanged())
		{
			config.save();
		}
	}

}
