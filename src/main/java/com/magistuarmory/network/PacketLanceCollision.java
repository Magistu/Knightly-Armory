package com.magistuarmory.network;

import com.magistuarmory.item.LanceItem;
import io.netty.channel.ChannelHandler.Sharable;
import java.util.function.Supplier;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

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
  
    public static PacketLanceCollision read(PacketBuffer buf)
    {
        return new PacketLanceCollision(buf.readInt(), buf.readInt());
    }
  
    public static void write(PacketLanceCollision message, PacketBuffer buf)
    {
        buf.writeInt(message.entityId);
        buf.writeInt(message.bonusDamage);
    }
  
    public static class Handler
    {
        public static void handle(PacketLanceCollision packet, Supplier<NetworkEvent.Context> ctx)
        {
            NetworkEvent.Context context = ctx.get();
            if (context.getDirection().getReceptionSide() == LogicalSide.SERVER)
            {
                context.enqueueWork(() -> PacketLanceCollision.handleServerSide(packet, context.getSender()));
            }
            context.setPacketHandled(true);
        }
    }
  
    public static void handleServerSide(PacketLanceCollision message, ServerPlayerEntity player)
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

        ItemStack mainStack = player.getItemBySlot(EquipmentSlotType.MAINHAND);
        if (mainStack.isEmpty())
        {
            return;
        }

        if (mainStack.getItem() instanceof LanceItem)
        {
            LanceItem lance = (LanceItem) mainStack.getItem();

            if (mainStack.getDamageValue() >= mainStack.getMaxDamage() - 1)
            {
                lance.onBroken(player);
            }
            else if (!player.isCreative() && ((LivingEntity)victim).getArmorValue() >= 18)
            {
                mainStack.setDamageValue(mainStack.getDamageValue() + (int)((0.6D + (message.bonusDamage / 20)) * Math.random() * mainStack.getMaxDamage()));
            }

            lance.attacking = true;

            player.attack(victim);
            victim.hurt(DamageSource.GENERIC, lance.getAttackDamage() + message.bonusDamage + (lance.isSilver() && ((LivingEntity)victim).getMobType().equals(CreatureAttribute.UNDEAD) ? lance.getSilverAttackDamage() : 0.0f));
            if (mainStack.getItem() instanceof LanceItem)
            {
                lance.attacking = false;
            }
		
            for (ItemStack itemStack : player.inventory.items)
            {
                lance.setRaised(player, true);
                player.getCooldowns().addCooldown(itemStack.getItem(), (int)(40 / (4 + lance.getAttackSpeed())));
            }
            player.swing(Hand.MAIN_HAND);
		
            if (mainStack.getDamageValue() >= mainStack.getMaxDamage())
            {
                lance.onBroken(player);
                mainStack.setCount(0);
            }
        }
    }
}
