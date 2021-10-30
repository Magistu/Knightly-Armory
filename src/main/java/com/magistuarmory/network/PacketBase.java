package com.magistuarmory.network;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;

public abstract class PacketBase<Packet extends PacketBase>
{
    public abstract void handleClientSide(Packet paramPacket, PlayerEntity paramPlayerEntity);

    public abstract void handleServerSide(Packet paramPacket, ServerPlayerEntity paramServerPlayerEntity);
}
