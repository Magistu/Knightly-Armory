package com.magistuarmory.network;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public abstract class PacketBase<Packet extends PacketBase> 
{
	
	
	
	public abstract void handleClientSide(Packet message, Player paramPlayer);
	
	public abstract void handleServerSide(Packet message, ServerPlayer paramPlayerMP);
}
