package com.magistuarmory.network;

import com.magistuarmory.item.MedievalWeaponItem;

import java.util.function.Supplier;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketLongWeaponAttack
{
    private int entityId;
    public PacketLongWeaponAttack(int entityId) {
        this.entityId = entityId;
    }
    public static PacketLongWeaponAttack read(PacketBuffer buf) {
        return new PacketLongWeaponAttack(buf.readInt());
    }
    public static void write(PacketLongWeaponAttack message, PacketBuffer buf) {
        buf.writeInt(message.entityId);
    }

    public static class Handler
    {
        public static void handle(PacketLongWeaponAttack message, Supplier<NetworkEvent.Context> ctx)
        {
            NetworkEvent.Context context = ctx.get();
            if (context.getDirection().getReceptionSide() == LogicalSide.SERVER)
            {
                context.enqueueWork(() -> PacketLongWeaponAttack.handleServerSide(message, context.getSender()));
            }
            context.setPacketHandled(true);
        }
    }

    public static void handleServerSide(PacketLongWeaponAttack message, ServerPlayerEntity player)
    {
        if (message == null || player == null) 
        {
            return;
        }

        Entity victim = player.level.getEntity(message.entityId);
        if (victim == null) 
        {
            return;
        }
        
        ItemStack mainStack = player.getItemBySlot(EquipmentSlotType.MAINHAND);
        
        if (mainStack.isEmpty())
        {
            return;
        }
        
        if (mainStack.getItem() instanceof MedievalWeaponItem)
        {
            float reachDistance = ((MedievalWeaponItem) mainStack.getItem()).getReachDistance();

            if (reachDistance > player.getAttributeValue(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()))
            {
                double distanceSqr = player.distanceToSqr(victim);
                double reachSquared = (reachDistance * reachDistance);
                
                if (reachSquared >= distanceSqr)
                {
                    player.attack(victim);
                }
            }
            player.swing(Hand.MAIN_HAND);
            player.resetAttackStrengthTicker();
        }
    }

    public static void handleClientSide(PacketLongWeaponAttack message, PlayerEntity paramPlayerEntity) {}
}
