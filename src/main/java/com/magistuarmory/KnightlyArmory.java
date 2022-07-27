package com.magistuarmory;

import com.magistuarmory.client.proxy.ClientProxy;
import com.magistuarmory.config.EpicFightConfig;
import com.magistuarmory.config.ModConfigurations;
import com.magistuarmory.event.EventHandler;
import com.magistuarmory.init.ModItems;
import com.magistuarmory.network.PacketHandler;
import com.magistuarmory.proxy.IProxy;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.stream.Collectors;

@Mod("magistuarmory")
public class KnightlyArmory
{
    public static final String ID = "magistuarmory";

    public static final IProxy PROXY = DistExecutor.safeRunForDist(() -> com.magistuarmory.client.proxy.ClientProxy::new, () -> com.magistuarmory.server.proxy.ServerProxy::new);

    public KnightlyArmory() throws IOException
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        PROXY.setup(modEventBus, forgeEventBus);
        modEventBus.addListener(this::commonSetup);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doLateInit);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(EventHandler.class);

        ModItems.ITEMS.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigurations.SPEC, "epic-knights.toml");

        PacketHandler.init();

        EpicFightConfig epicFightConfig = new EpicFightConfig();
        epicFightConfig.addEpicFightConfig();
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    static final Logger LOGGER = LogManager.getLogger();

    private void setup(FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(FMLClientSetupEvent event)
    {
        ClientProxy.doClientStuff(event);
    }

    private void doLateInit(FMLLoadCompleteEvent event)
    {
        if (PROXY instanceof ClientProxy)
        {
            ((ClientProxy) PROXY).onLateInit();
        }
    }

    private void enqueueIMC(InterModEnqueueEvent event)
    {
        InterModComms.sendTo("examplemod", "helloworld", () ->
        {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream()
                .map(m -> m.getMessageSupplier().get())
                .collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(RegistryEvent.Register<Block> blockRegistryEvent)
        {
            KnightlyArmory.LOGGER.info("HELLO from Register Block");
        }
    }
}
