package com.magistuarmory.network;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.item.LanceItem;
import com.magistuarmory.item.MedievalWeaponItem;

import io.netty.buffer.ByteBuf;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;


public class PacketLanceCollision extends PacketBase<PacketLanceCollision>
{
	private int entityId;
	private int bonusDamage;
	
	public PacketLanceCollision() {}
	
	public PacketLanceCollision(int entId, int bonusDamage) 
	{
		this.entityId = entId;
		this.bonusDamage = bonusDamage;
	}


	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.entityId = ByteBufUtils.readVarInt(buf, 4);
		this.bonusDamage = ByteBufUtils.readVarInt(buf, 4);
	}


	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeVarInt(buf, this.entityId, 4);
		ByteBufUtils.writeVarInt(buf, this.bonusDamage, 4);
	}



	@Override
	public void handleClientSide(PacketLanceCollision message, EntityPlayer player) {}


	@Override
	public void handleServerSide(PacketLanceCollision message, EntityPlayerMP player) 
	{
		if (message == null || player == null) 
		{
			return;
		}
		Entity victim = player.world.getEntityByID(message.entityId);
		if (!(victim instanceof EntityLivingBase))
		{
			return;
		}
		
		ItemStack weapon = player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);

		
		if (weapon.isEmpty()) 
		{
			return;
		}
		if (weapon.getItem() instanceof LanceItem) 
		{
			
			if (weapon.getItemDamage() <= weapon.getItem().getMaxItemUseDuration(weapon) - 1)
			{
				((LanceItem)weapon.getItem()).onBroken(player);
			}
			else if (!player.isCreative() && ((EntityLivingBase)victim).getTotalArmorValue() >= 18)
			{
				weapon.damageItem((int)((0.6 + bonusDamage / 20) * Math.random() * weapon.getMaxDamage()), player);
			}
			
			((LanceItem)weapon.getItem()).attacking = true;
			((LanceItem)weapon.getItem()).strength = bonusDamage;
			player.attackTargetEntityWithCurrentItem(victim);
			victim.attackEntityFrom(DamageSource.causePlayerDamage(player), ((LanceItem)weapon.getItem()).getAttackDamage() + message.bonusDamage);
			if (weapon.getItem() instanceof LanceItem)
			{
				((LanceItem)weapon.getItem()).attacking = false;
			}
			
			for (ItemStack itemStack : player.inventoryContainer.inventoryItemStacks)
			{
				((LanceItem)weapon.getItem()).setRaised(player, true);
				player.getCooldownTracker().setCooldown(itemStack.getItem(), (int)(40 / (4 + ((LanceItem)weapon.getItem()).getAttackSpeed())));
			}
			player.swingArm(EnumHand.MAIN_HAND);
			
			if (weapon.getItemDamage() >= weapon.getMaxDamage())
			{
				((LanceItem)weapon.getItem()).onBroken(player);
				weapon.setCount(0);
			}
		}
	}
}