package com.magistuarmory.network;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.PacketLoggingHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;




public class PacketHandler
{
	public static PacketLoggingHandler packetHandler;
	protected static SimpleNetworkWrapper instance;
	protected static int currentId = 0;
	
	public static void init() 
	{
		packetHandler = new PacketLoggingHandler();
		instance = NetworkRegistry.INSTANCE.newSimpleChannel("magistuarmory".toLowerCase());

		instance.registerMessage(PacketLongReachAttack.class, PacketLongReachAttack.class, getNextPacketId(), Side.SERVER);
		instance.registerMessage(PacketLanceCollision.class, PacketLanceCollision.class, getNextPacketId(), Side.SERVER);

	}

	public static int getNextPacketId() 
	{
		int id = currentId;
		currentId++;
		return id;
	}
	
	public static void sendPacketToAll(PacketBase packet) 
	{
		instance.sendToAll(packet);
	}
	
	public static void sendPacketTo(PacketBase packet, EntityPlayerMP player) 
	{
		instance.sendTo(packet, player);
	}
	
	public static void sendPacketToAllAround(PacketBase packet, NetworkRegistry.TargetPoint point) 
	{
		instance.sendToAllAround(packet, point);
	}
	
	public static void sendPacketToDimension(PacketBase packet, int dimensionId) 
	{
		instance.sendToDimension(packet, dimensionId);
	}
	
	public static void sendPacketToServer(PacketBase packet) 
	{
		instance.sendToServer(packet);
	}
}