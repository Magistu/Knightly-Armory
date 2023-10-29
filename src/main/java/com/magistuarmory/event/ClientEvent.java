package com.magistuarmory.event;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.network.PacketHandler;
import com.magistuarmory.network.PacketBase;
import com.magistuarmory.network.PacketLongReachAttack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ClientEvent
{
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public static void onMouseEvent(MouseEvent ev) 
	{
		KeyBinding keyAttack = (Minecraft.getMinecraft()).gameSettings.keyBindAttack;
		
		if (keyAttack.getKeyCode() < 0 && ev.getButton() == keyAttack.getKeyCode() + 100 && ev.isButtonstate()) 
		{
			
			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayerSP entityPlayerSP = mc.player;
			if (entityPlayerSP.isActiveItemStackBlocking())
			{
				return;
			}
			
			if (entityPlayerSP != null) 
			{
				
				ItemStack stack = entityPlayerSP.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
				
				if (!stack.isEmpty()) 
				{
					float reachDistance;
					if (stack.getItem() instanceof MedievalWeaponItem) 
					{
						
						reachDistance = ((MedievalWeaponItem)stack.getItem()).getReachDistance();
						if (reachDistance > 5.0f) 
						{
							RayTraceResult result = getMouseOver(reachDistance);
							
							if (result != null)
							{
								if (result.entityHit != null && result.entityHit.hurtResistantTime == 0 && result.entityHit != entityPlayerSP && result.entityHit != entityPlayerSP.getRidingEntity())
								{
									PacketHandler.sendPacketToServer((PacketBase)new PacketLongReachAttack(result.entityHit.getEntityId()));
								}
							}
						} 
					}
				} 
			} 
		} 
	}
	
    
	public static RayTraceResult getMouseOver(float distance) {
		RayTraceResult result = null;
		Minecraft mc = Minecraft.getMinecraft();
		Entity renderViewEntity = mc.getRenderViewEntity();
		
		if (renderViewEntity != null)
		{
			if (mc.world != null) {

				
				double d0 = distance;
				result = renderViewEntity.rayTrace(d0, 0.0F);
				Vec3d eyePos = renderViewEntity.getPositionEyes(0.0F);
				boolean flag = false;
				
				double d1 = d0;
				
				if (mc.playerController.extendedReach() && d1 < 6.0D) {
					
					d1 = 6.0D;
					d0 = d1;

				
				}
				else if (d0 > distance) {
					
					flag = true;
				} 

				
				if (result != null)
				{
					d1 = result.hitVec.distanceTo(eyePos);
				}
				
				Vec3d lookVec = renderViewEntity.getLook(0.0F);
				Vec3d vec3d2 = eyePos.addVector(lookVec.x * d0, lookVec.y * d0, lookVec.z * d0);
				Entity pointedEntity = null;
				Vec3d vec3d3 = null;
				
				List<Entity> list = mc.world.getEntitiesInAABBexcluding(renderViewEntity, renderViewEntity.getEntityBoundingBox().expand(lookVec.x * d0, lookVec.y * d0, lookVec.z * d0).expand(1.0D, 1.0D, 1.0D), Predicates.and(EntitySelectors.NOT_SPECTATING, new Predicate<Entity>()
							{
								public boolean apply(@Nullable Entity p_apply_1_)
								{
									return (p_apply_1_ != null && p_apply_1_.canBeCollidedWith());
								}
							}));
				double d2 = d1;
				
				for (int j = 0; j < list.size(); j++) {
					
					Entity entity1 = list.get(j);
					AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow(entity1.getCollisionBorderSize());
					RayTraceResult result0 = axisalignedbb.calculateIntercept(eyePos, vec3d2);
					
					if (axisalignedbb.contains(eyePos)) 
					{
						
						if (d2 >= 0.0D)
						{
							pointedEntity = entity1;
							vec3d3 = (result0 == null) ? eyePos : result0.hitVec;
							d2 = 0.0D;
						}
					
					} 
					else if (result0 != null) 
					{
						
						double d3 = eyePos.distanceTo(result0.hitVec);
						
						if (d3 < d2 || d2 == 0.0D)
						{
							if (entity1.getLowestRidingEntity() == renderViewEntity.getLowestRidingEntity() && !renderViewEntity.canRiderInteract()) 
							{
								
								if (d2 == 0.0D)
								{
									pointedEntity = entity1;
									vec3d3 = result0.hitVec;
								}
							
							} 
							else 
							{
								
								pointedEntity = entity1;
								vec3d3 = result0.hitVec;
								d2 = d3;
							} 
						}
					} 
				} 
				
				if (pointedEntity != null && flag && eyePos.distanceTo(vec3d3) > distance) {
					
					pointedEntity = null;
					result = new RayTraceResult(RayTraceResult.Type.MISS, vec3d3, (EnumFacing)null, new BlockPos(vec3d3));
				} 
				
				if (pointedEntity != null && (d2 < d1 || result == null)) {
					
					result = new RayTraceResult(pointedEntity, vec3d3);
					
					if (pointedEntity instanceof EntityLivingBase || pointedEntity instanceof net.minecraft.entity.item.EntityItemFrame);
				} 
			} 
		}
		return result;
	}
}
