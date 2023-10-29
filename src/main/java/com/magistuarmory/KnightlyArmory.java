package com.magistuarmory;

import java.io.IOException;

import com.magistuarmory.config.ModConfigurations;
import com.magistuarmory.event.ClientEvent;
import com.magistuarmory.event.ModEvent;
import com.magistuarmory.init.HeraldyPatterns;
import com.magistuarmory.init.ModTrade;
import com.magistuarmory.network.PacketHandler;
import com.magistuarmory.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = KnightlyArmory.ID, name = "Epic Knights: Armor and Weapons")
public class KnightlyArmory 
{
	@Instance
	public static KnightlyArmory instance;
	
	public static final String ID = "magistuarmory";
	
	@SidedProxy(clientSide = "com.magistuarmory.proxy.ClientProxy", serverSide = "com.magistuarmory.proxy.CommonProxy")
	public static CommonProxy PROXY;

	public KnightlyArmory()
	{
        
	}
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		HeraldyPatterns.initCraftingBanners();
		ModTrade.addTrade();
		
		ModConfigurations.init(event.getModConfigurationDirectory());
		MinecraftForge.EVENT_BUS.register(new ModConfigurations());
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) throws IOException
	{
		PacketHandler.init();
		
		MinecraftForge.EVENT_BUS.register(new ClientEvent());
		MinecraftForge.EVENT_BUS.register(new ModEvent());
		
		PROXY.addEpicFightConfig();
	}
	
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event)
	{
		
	}
}
