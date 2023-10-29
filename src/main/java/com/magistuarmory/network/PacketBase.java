package com.magistuarmory.network;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;



public abstract class PacketBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ>
{
	public REQ onMessage(final REQ message, final MessageContext ctx) 
	{
		if (ctx.side.isServer()) 
		{
			
			MinecraftServer minecraftServer = (ctx.getServerHandler()).player.getServer();
			minecraftServer.addScheduledTask(new Runnable()
					{
						
						public void run()
						{
							PacketBase.this.handleServerSide(message, (ctx.getServerHandler()).player);
						}
					});
		
		}
		else {

			
			Minecraft minecraft = Minecraft.getMinecraft();
			minecraft.addScheduledTask(new Runnable()
					{
						
						public void run()
						{
							PacketBase.this.handleClientSide(message, (EntityPlayer)(Minecraft.getMinecraft()).player);
						}
					});
		} 
		
		return null;
	}
	
	public abstract void handleClientSide(REQ paramREQ, EntityPlayer paramEntityPlayer);
	
	public abstract void handleServerSide(REQ paramREQ, EntityPlayerMP paramEntityPlayerMP);
}