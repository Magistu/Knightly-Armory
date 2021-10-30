package com.magistuarmory.network;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class PacketHandler
{
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation("magistuarmory", "main"), () -> "1", "1"::equals, "1"::equals);

    protected static int currentId = 0;

    public static void init()
    {
        INSTANCE.registerMessage(getNextPacketId(), PacketLongWeaponAttack.class, PacketLongWeaponAttack::write, PacketLongWeaponAttack::read, PacketLongWeaponAttack.Handler::handle);
        INSTANCE.registerMessage(getNextPacketId(), PacketLanceCollision.class, PacketLanceCollision::write, PacketLanceCollision::read, PacketLanceCollision.Handler::handle);
    }

    public static int getNextPacketId()
    {
        int id = currentId;
        currentId++;
        return id;
    }

    public static void sendToServer(Object packet) {
        INSTANCE.sendToServer(packet);
    }

    public static void sendTo(Object packet, ServerPlayerEntity player)
    {
        if (!(player instanceof net.minecraftforge.common.util.FakePlayer))
            INSTANCE.sendTo(packet, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendPacketToAll(Object packet)
    {
        for (ServerPlayerEntity player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers())
        {
            sendTo(packet, player);
        }
    }
}
