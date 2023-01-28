package com.magistuarmory.server.proxy;

import com.magistuarmory.proxy.IProxy;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class ServerProxy implements IProxy {

	@Override
	public void setup(IEventBus modEventBus, IEventBus forgeEventBus) {}
}
