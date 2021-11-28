package com.magistuarmory.event;

import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.network.PacketHandler;
import com.magistuarmory.network.PacketLongWeaponAttack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.settings.KeyBinding;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@EventBusSubscriber
public class ClientEventHandler
{
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    @OnlyIn(Dist.CLIENT)
    public static void onMouseEvent(InputEvent.MouseInputEvent ev)
    {
        if ((Minecraft.getInstance()).level == null || (Minecraft.getInstance()).screen != null || Minecraft.getInstance().isPaused())
        {
            return;
        }

        KeyBinding keyAttack = (Minecraft.getInstance()).options.keyAttack;
        if (ev.getButton() == keyAttack.getKey().getValue() && ev.getAction() == 1)
        {
            Minecraft mc = Minecraft.getInstance();
            ClientPlayerEntity player = mc.player;
            if (player == null || player.isBlocking())
            {
                return;
            }

            ItemStack weapon = player.getMainHandItem();
            if (!(weapon.getItem() instanceof MedievalWeaponItem))
            {
                return;
            }

            float reach = ((MedievalWeaponItem)weapon.getItem()).getReachDistance();
            if (reach <= 5.0F)
            {
                return;
            }

            RayTraceResult rayTrace = getMouseOver(reach, player.getAttributeValue(ForgeMod.REACH_DISTANCE.get()));
            if (!(rayTrace instanceof EntityRayTraceResult))
            {
                return;
            }

            EntityRayTraceResult entityRayTrace = (EntityRayTraceResult)rayTrace;
            Entity entityHit = entityRayTrace.getEntity();

            if (entityHit.invulnerableTime == 0 && entityHit != player && entityHit != player.getVehicle())
            {
                PacketHandler.sendToServer(new PacketLongWeaponAttack(entityHit.getId()));
            }
        }
    }

    public static RayTraceResult getMouseOver(float reach, double reach0)
    {
        RayTraceResult result = null;
        Minecraft mc = Minecraft.getInstance();
        Entity viewEntity = mc.getCameraEntity();

        if (viewEntity != null)
        {
            result = viewEntity.pick(reach, 0.0F, false);

            Vector3d eyePos = viewEntity.getEyePosition(1.0f);
            double d0 = reach0 * reach0;
            double d1 = result.getLocation().distanceToSqr(eyePos);

            Vector3d lookVec = viewEntity.getViewVector(1.0F);
            Vector3d attackVec = eyePos.add(lookVec.x * (double) reach, lookVec.y * (double) reach, lookVec.z * reach);

            AxisAlignedBB expBounds = viewEntity.getBoundingBox().expandTowards(lookVec.scale(reach)).inflate(1.0D, 1.0D, 1.0D);
            EntityRayTraceResult entityRayTrace = ProjectileHelper.getEntityHitResult(viewEntity, eyePos, attackVec, expBounds, entity -> (!entity.isSpectator() && entity.isPickable()), d1);


            if (entityRayTrace != null && d1 > d0)
            {
                result = entityRayTrace;
            }
            else
            {
                result = BlockRayTraceResult.miss(attackVec, Direction.getNearest(lookVec.x, lookVec.y, lookVec.z), new BlockPos(attackVec));
            }
        }
        return result;
    }
}
