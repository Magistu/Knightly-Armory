package com.magistuarmory.network;

import com.magistuarmory.item.LanceItem;

import io.netty.channel.ChannelHandler.Sharable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;


@Sharable
public class PacketLanceCollision
{
private int entityId;
private int bonusDamage;
	
	public PacketLanceCollision(int entityId, int bonusDamage) 
	{
		this.entityId = entityId;
		this.bonusDamage = bonusDamage;
	}
	
	public static PacketLanceCollision read(FriendlyByteBuf buf) 
	{
		return new PacketLanceCollision(buf.readInt(), buf.readInt());
	}
	
	public static void write(PacketLanceCollision message, FriendlyByteBuf buf) 
	{
		buf.writeInt(message.entityId);
		buf.writeInt(message.bonusDamage);
	}
	
	public static class Handler
	{
		public static void handle(PacketLanceCollision packet, Supplier<NetworkEvent.Context> ctx)
		{
			NetworkEvent.Context context = ctx.get();
	        if (context.getDirection().getReceptionSide() == LogicalSide.SERVER) {
	        	context.enqueueWork(() -> handleServerSide(packet, context.getSender()));
	        	
	        }
	        context.setPacketHandled(true);
		}
	}
	
	public static void handleServerSide(PacketLanceCollision message, ServerPlayer player) 
	{
		if (message == null || player == null) 
		{
			return;
		}
		Entity victim = player.level.getEntity(message.entityId);
		if (!(victim instanceof LivingEntity))
		{
			return;
		}
		
		ItemStack weapon = player.getItemBySlot(EquipmentSlot.MAINHAND);

		
		if (weapon.isEmpty()) 
		{
			return;
		}
		if (weapon.getItem() instanceof LanceItem lance) 
		{
			if (weapon.getDamageValue() >= weapon.getMaxDamage() - 1)
			{
				lance.onBroken(player);
			}
			else if (!player.isCreative() && ((LivingEntity)victim).getArmorValue() >= 18)
			{
				weapon.setDamageValue(weapon.getDamageValue() + (int)((0.6 + message.bonusDamage / 20) * Math.random() * weapon.getMaxDamage()));
			}
			
			lance.attacking = true;
			player.attack(victim);
			victim.hurt(DamageSource.GENERIC, lance.getAttackDamage() + message.bonusDamage + (lance.isSilver() && ((LivingEntity)victim).getMobType().equals(MobType.UNDEAD) ? lance.getSilverAttackDamage() : 0.0f));
			if (weapon.getItem() instanceof LanceItem)
			{
				lance.attacking = false;
			}
			
			for (ItemStack itemStack : player.getInventory().items)
			{
				lance.setRaised(player, true);
				player.getCooldowns().addCooldown(itemStack.getItem(), (int)(40 / (4 + lance.getAttackSpeed())));
			}
			player.swing(InteractionHand.MAIN_HAND);
			
			if (weapon.getDamageValue() >= weapon.getMaxDamage())
			{
				lance.onBroken(player);
				weapon.setCount(0);
			}
		}
	}
}