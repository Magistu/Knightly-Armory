package com.magistuarmory.event;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.ModSpriteSourceProvider;
import com.magistuarmory.client.renderer.model.CaparisonModel;
import com.magistuarmory.client.renderer.model.SurcoatModel;
import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.network.PacketHandler;
import com.magistuarmory.network.PacketLongReachAttack;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.texture.atlas.sources.SingleFile;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SpriteSourceProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value=Dist.CLIENT)
public class ClientEventHandler
{
	public static final ModelLayerLocation SURCOAT = new ModelLayerLocation(new ResourceLocation(KnightlyArmory.ID, "surcoat"), "decorations");
	public static final ModelLayerLocation CAPARISON = new ModelLayerLocation(new ResourceLocation(KnightlyArmory.ID, "caparison"), "decorations");

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	@OnlyIn(Dist.CLIENT)
	public static void onMouseEvent(InputEvent.MouseButton ev) 
	{
		if ((Minecraft.getInstance()).level == null || (Minecraft.getInstance()).screen != null || Minecraft.getInstance().isPaused()) 
		{
			return;
		}
		KeyMapping keyAttack = (Minecraft.getInstance()).options.keyAttack;

		
		if (ev.getButton() == keyAttack.getKey().getValue() && ev.getAction() == 1)
		{
			Minecraft mc = Minecraft.getInstance();
			LocalPlayer clientPlayerEntity = mc.player;

			if (clientPlayerEntity == null || clientPlayerEntity.isBlocking()) 
			{
				return;
			}
			ItemStack weapon = clientPlayerEntity.getMainHandItem();
			
			
			if (!(weapon.getItem() instanceof MedievalWeaponItem)) 
			{
				return;
			}
			
			float reach = ((MedievalWeaponItem)weapon.getItem()).getReachDistance();
			
			if (reach <= 5.0F) 
			{
				return;
			}
			
			HitResult rayTrace = getMouseOver(reach);
			
			if (!(rayTrace instanceof EntityHitResult)) 
			{
				return;
			}
			EntityHitResult entityRayTrace = (EntityHitResult)rayTrace;
			Entity entityHit = entityRayTrace.getEntity();
			
			
			if (entityHit != null && entityHit.invulnerableTime == 0 && entityHit != clientPlayerEntity && entityHit != clientPlayerEntity.getVehicle()) 
			{
				PacketHandler.sendToServer(new PacketLongReachAttack(entityHit.getId()));
			} 
		}
	}
	
	
	public static HitResult getMouseOver(float reach) 
	{
		BlockHitResult blockHitResult = null;
		HitResult result = null;
		Minecraft mc = Minecraft.getInstance();
		Entity viewEntity = mc.getCameraEntity();
		
		if (viewEntity != null) 
		{
			double d0 = reach;
			result = viewEntity.pick(d0, 0.0F, false);
			Vec3 eyePos = viewEntity.getEyePosition();
			boolean flag = false;
			double d1 = d0;
			
			if (mc.player.isCreative() && d1 < 6.0D) 
			{
				
				d1 = 6.0D;
				d0 = d1;
			}
			else if (d0 > reach) 
			{
				flag = true;
			} 
			d1 *= d1;
			
			if (result != null)
			{
				d1 = result.getLocation().distanceToSqr(eyePos);
			}
			Vec3 lookVec = viewEntity.getViewVector(1.0F);
			Vec3 attackVec = eyePos.add(lookVec.x * d0, lookVec.y * d0, lookVec.z * d0);
			
			AABB expBounds = viewEntity.getBoundingBox().expandTowards(lookVec.scale(d0)).inflate(1.0D, 1.0D, 1.0D);
			EntityHitResult entityRayTrace = ProjectileUtil.getEntityHitResult(viewEntity, eyePos, attackVec, expBounds, entity -> (!entity.isSpectator() && entity.isPickable()), d1);

			
			if (entityRayTrace != null) 
			{
				
				Vec3 hitVec = entityRayTrace.getLocation();
				double d2 = eyePos.distanceToSqr(hitVec);
				if (flag && d2 > (reach * reach)) 
				{
					result = BlockHitResult.miss(hitVec, Direction.getNearest(lookVec.x, lookVec.y, lookVec.z), new BlockPos(hitVec));
				}
				else if (d2 < d1 || blockHitResult == null) 
				{
					result = entityRayTrace;
				} 
			} 
			else 
			{
				
				result = BlockHitResult.miss(attackVec, Direction.getNearest(lookVec.x, lookVec.y, lookVec.z), new BlockPos(attackVec));
			} 
		} 
		return result;
	}


    @SubscribeEvent
	@OnlyIn(Dist.CLIENT)
    public static void onRegisterLayerDefinitions(final EntityRenderersEvent.RegisterLayerDefinitions event)
	{
		event.registerLayerDefinition(SURCOAT, SurcoatModel::createLayer);
		event.registerLayerDefinition(CAPARISON, CaparisonModel::createLayer);
	}
}