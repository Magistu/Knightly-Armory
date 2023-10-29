package com.magistuarmory.network;

import com.magistuarmory.item.MedievalWeaponItem;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;


public class PacketLongReachAttack extends PacketBase<PacketLongReachAttack>
{
	private int entityId;
	
	public PacketLongReachAttack() {}
	
	public PacketLongReachAttack(int entId) 
	{
		this.entityId = entId;
	}


	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.entityId = ByteBufUtils.readVarInt(buf, 4);
	}


	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeVarInt(buf, this.entityId, 4);
	}



	@Override
	public void handleClientSide(PacketLongReachAttack message, EntityPlayer player) {}


	@Override
	public void handleServerSide(PacketLongReachAttack message, EntityPlayerMP player) 
	{
		if (message == null || player == null) 
		{
			return;
		}
		Entity victim = player.world.getEntityByID(message.entityId);
		if (victim == null) 
		{
			return;
		}
		
		ItemStack weapon = player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);

		
		if (weapon.isEmpty()) 
		{
			return;
		}
		if (weapon.getItem() instanceof MedievalWeaponItem) 
		{

			float reachDistance = ((MedievalWeaponItem)weapon.getItem()).getReachDistance();
			
			if (reachDistance > 5.0f) 
			{
				
				double distanceSquared = player.getDistanceSq(victim);
				
				double reachSquared = (reachDistance * reachDistance);
				
				if (reachSquared >= distanceSquared) 
				{
					
					player.attackTargetEntityWithCurrentItem(victim);
				} 
			} 
			player.swingArm(EnumHand.MAIN_HAND);
			player.resetCooldown();
		} 
	}
}