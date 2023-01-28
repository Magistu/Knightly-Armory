package com.magistuarmory.network;

import com.magistuarmory.item.MedievalWeaponItem;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;


public class PacketLongReachAttack
{
private int entityId;
	
	public PacketLongReachAttack(int entityId) 
	{
		this.entityId = entityId;
	}
	
	public static PacketLongReachAttack read(FriendlyByteBuf buf) 
	{
		return new PacketLongReachAttack(buf.readInt());
	}
	
	public static void write(PacketLongReachAttack message, FriendlyByteBuf buf) 
	{
		buf.writeInt(message.entityId);
	}
	
	public static class Handler
	{
		public static void handle(PacketLongReachAttack message, Supplier<NetworkEvent.Context> ctx)
		{
			NetworkEvent.Context context = ctx.get();
	        if (context.getDirection().getReceptionSide() == LogicalSide.SERVER) {
	        	context.enqueueWork(() -> {
	                
	            	handleServerSide(message, context.getSender());
	            	
	                });
	        	
	        }
	        context.setPacketHandled(true);
		}
	}

	
	public static void handleServerSide(PacketLongReachAttack message, ServerPlayer player) {
		
		if (message == null || player == null) 
		{
			return;
		}
		Entity victim = player.level.getEntity(message.entityId);
		if (victim == null) 
		{
			return;
		}
		
		ItemStack weapon = player.getItemBySlot(EquipmentSlot.MAINHAND);

		
		if (weapon.isEmpty()) 
		{
			return;
		}
		if (weapon.getItem() instanceof MedievalWeaponItem) 
		{

			float reachDistance = ((MedievalWeaponItem)weapon.getItem()).getReachDistance();
			
			if (reachDistance > 5.0f) 
			{
				
				double distanceSquared = player.distanceToSqr(victim);
				
				double reachSquared = (reachDistance * reachDistance);
				
				if (reachSquared >= distanceSquared) 
				{
					
					player.attack(victim);
				} 
			} 
			player.swing(InteractionHand.MAIN_HAND);
			player.resetAttackStrengthTicker();
		} 
		
	}

	
	public static void handleClientSide(PacketLongReachAttack message, Player paramPlayer) {
		// TODO Auto-generated method stub
		
	}
}