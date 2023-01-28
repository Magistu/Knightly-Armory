package com.magistuarmory.proxy;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public interface IProxy {

	void setup(IEventBus modEventBus, IEventBus forgeEventBus);
}
