package com.magistuarmory;

import java.io.IOException;
import java.util.stream.Collectors;

import com.magistuarmory.config.ModConfigurations;
import com.magistuarmory.event.CommonEventHandler;
import com.magistuarmory.init.*;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.magistuarmory.client.proxy.ClientProxy;
import com.magistuarmory.network.PacketHandler;
import com.magistuarmory.proxy.IProxy;
import com.magistuarmory.server.proxy.ServerProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(KnightlyArmory.ID)
public class KnightlyArmory
{
	public static final String ID = "magistuarmory";
	
	public static final IProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
    public static boolean BC_or_EF_instaled;

    public KnightlyArmory() throws IOException
	{
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus(),
				forgeEventBus = MinecraftForge.EVENT_BUS;
		
		//Basic Setup
		PROXY.setup(modEventBus, forgeEventBus);
		
		//Mod Event Bus Listeners
		modEventBus.addListener(this::commonSetup);
		
        // Register the setup method for modloading
        modEventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        modEventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        modEventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        modEventBus.addListener(this::doClientStuff);
        modEventBus.addListener(this::onLateInit);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(CommonEventHandler.class);
        ModItems.ITEMS.register(modEventBus);
        ModBannerPatterns.PATTERNS.register(modEventBus);
        ModEffects.EFFECTS.register(modEventBus);
        ModItems.RECIPE_SERIALIZERS.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigurations.SPEC, "epic-knights.toml");
        
        PacketHandler.init();
	}
	
	private void commonSetup(final FMLCommonSetupEvent event) {}
	
	   // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void doClientStuff(FMLClientSetupEvent event)
    {
        ClientProxy.doClientStuff(event);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    public void onLateInit(final EntityRenderersEvent.AddLayers event)
	{
        if (PROXY instanceof ClientProxy)
        {
            ClientProxy.onLateInit(event);
        }
        BC_or_EF_instaled = ModList.get().isLoaded("bettercombat") || ModList.get().isLoaded("epicfight");
    }
}
