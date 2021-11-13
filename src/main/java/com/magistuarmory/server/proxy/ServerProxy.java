package com.magistuarmory.server.proxy;

import com.magistuarmory.proxy.IProxy;
import net.minecraftforge.eventbus.api.IEventBus;

public class ServerProxy implements IProxy
{
    public void setup(IEventBus modEventBus, IEventBus forgeEventBus) {}

    public void onLateInit(final IEventBus modbus) {}
}
