package com.magistuarmory.proxy;

import net.minecraftforge.eventbus.api.IEventBus;

public interface IProxy
{
    void setup(IEventBus paramIEventBus1, IEventBus paramIEventBus2);

    void onLateInit(final IEventBus modbus);
}
