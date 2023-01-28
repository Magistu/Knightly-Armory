package com.magistuarmory.item;

import java.util.List;

import javax.annotation.Nullable;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.event.ClientEventHandler;
import com.magistuarmory.network.PacketHandler;
import com.magistuarmory.network.PacketLanceCollision;

import net.minecraft.ChatFormatting;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class LanceItem extends MedievalWeaponItem implements IHasModelProperty
{
	public boolean attacking = false;
	public double velocityProjection = 0.0;
	private int clickedTicks = 0;
	
	public LanceItem(Properties build, Tier material, float baseAttackDamage, float baseAttackSpeed, int armorPiercing, float reachDistance, float weight)
	{
		super(build, material, baseAttackDamage, baseAttackSpeed, armorPiercing, reachDistance, weight);

	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_)
    {
		setRaised(p_41433_, isRaised(p_41433_) ? false : true);
        return super.use(p_41432_, p_41433_, p_41434_);
    }


	@Override
	public UseAnim getUseAnimation(ItemStack par1ItemStack) 
	{
		return UseAnim.BOW;
	}

	
	@Override
	public void inventoryTick(ItemStack par1ItemStack, Level world, Entity entity, int par4, boolean par5) 
	{
		if (entity != null && entity instanceof Player) 
		{
			Player player = (Player)entity;
			if (world.isClientSide && player.getMainHandItem() != null && player.getMainHandItem().getItem() instanceof LanceItem) 
			{
				HitResult result = ClientEventHandler.getMouseOver(this.getReachDistance());
				if (result != null && result instanceof EntityHitResult) 
				{
					Entity aim = ((EntityHitResult)result).getEntity();
					if (player.isPassenger() && aim instanceof LivingEntity && aim.isAlive() && aim.getId() != player.getVehicle().getId())
					{
						collide((LivingEntity)aim, player, world);
					}
				} 
			}
			
			if (clickedTicks > 0)
			{
				clickedTicks--;
			}
			
			if (!isRaised(player) && player.getCooldowns().isOnCooldown(this))
			{
				setRaised(player, true);
			}
		} 
		super.inventoryTick(par1ItemStack, world, entity, par4, par5);
	}

	
	public void collide(LivingEntity victim, Player player, Level world) 
	{
		if (player == null) 
		{
			return;
		}
		if (world == null) 
		{
			return;
		}
		
		if (!isRaised(player) && !player.getCooldowns().isOnCooldown(this))
		{
			
			int bonusDamage = (int)calcBonusDamage(player, velocityProjection);
			
			if (player.isPassenger())
			{
				velocityProjection = getVelocityProjection(player, victim);
				
				if ((player.getRootVehicle() instanceof Horse && 
						velocityProjection >= ((Horse)player.getRootVehicle()).getAttribute(Attributes.MOVEMENT_SPEED).getValue())
						|| (!(player.getRootVehicle() instanceof Horse) && velocityProjection >= 0.233))
				{
					PacketHandler.sendToServer(new PacketLanceCollision(victim.getId(), bonusDamage));
				}
			}
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext context) 
	{
		return InteractionResult.PASS;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) 
	{
		
		if (attacking)
		{
			Vec3 vec = player.getViewVector(1.0f);		
			double b = 70.0 * Math.sqrt(Math.max(0.0, velocityProjection) / Math.max(0.5, vec.length() * getSummaryMass(entity))) / 5.0;
			
			if (entity.isPassenger())
			{
				entity.getRootVehicle().setDeltaMovement(entity.getRootVehicle().getDeltaMovement().add(vec.x * b, vec.y * b, vec.z * b));
				entity.getRootVehicle().hasImpulse = true;
				if (((clickedTicks > 0 ? 0.3 : 0.0) + 0.6 + 0.2 * entity.getBoundingBox().getCenter().subtract(player.getEyePosition(1.0f).add(player.getViewVector(getReachDistance()))).dot(vec) / vec.length()) * Math.random() > 1)
				{
					entity.stopRiding();
				}
				
			}
			else
			{
				entity.setDeltaMovement(entity.getDeltaMovement().add(vec.x * b, vec.y * b, vec.z * b));
				entity.hasImpulse = true;
			}
			return false;
		}
		else if (!isRaised(player) && !player.getCooldowns().isOnCooldown(this))
		{
			clickedTicks = 15;
		}
		return true;
	}

	@Override
	public boolean onEntitySwing(ItemStack stack, LivingEntity entityLiving) 
	{
		return true;
	}
	
	public double calcBonusDamage(Entity player, double velocityProjection) 
	{
		double bonusDamage = 0.0F;
		
		bonusDamage = 5.0 * getSummaryMass(player) * velocityProjection;
		
		return Math.max(0.0, bonusDamage);
	}
	
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) 
	{
		tooltip.add(Component.translatable("lance.rideronly").withStyle(ChatFormatting.BLUE));
		tooltip.add(Component.translatable("lance.leftclick").withStyle(ChatFormatting.BLUE));
		tooltip.add(Component.translatable("lance.bonusdamage").withStyle(ChatFormatting.BLUE));
		super.appendHoverText(stack, level, tooltip, flagIn);
	}
	
	
	double getVelocityProjection(Entity entity1, Entity entity2) 
	{
		Vec3 velocity;
		if (entity1.isPassenger())
		{
			velocity = entity1.getRootVehicle().getDeltaMovement();
		}
		else
		{
			velocity = entity1.getDeltaMovement();
		}
		
		Vec3 vec = entity1.getViewVector(1.0f);		
		
		if (vec.lengthSqr() == 0.0)
		{
			return 0.0;
		}
		
		return velocity.dot(vec) / vec.length();
	}
	
	
	public double getSummaryMass(Entity entityIn)
	{
		Entity entity = entityIn;
		double summaryMass = getMass(entity);
		
		while (entity.isPassenger())
		{
			entity = entity.getVehicle();
			summaryMass += getMass(entity);
		}
		
		entity = entityIn;
		
		while (entity.getControllingPassenger() != null)
		{
			entity = entity.getControllingPassenger();
			summaryMass += getMass(entity);
		}
		
		return summaryMass;
	}
	
	
	public double getMass(Entity entity)
	{
		double mass = 0.0F;
		
		AABB box = entity.getBoundingBox();
		if (box != null)
		{
			mass += (box.maxX - box.minX) * (box.maxY - box.minY) * (box.maxZ - box.minZ);
		}
		
		for (ItemStack armorPiece : entity.getArmorSlots())
		{
			if (!armorPiece.isEmpty() && armorPiece.getItem() instanceof ArmorItem)
			{
				mass += (((ArmorItem)armorPiece.getItem()).getDefense() + ((ArmorItem)armorPiece.getItem()).getToughness()) / 20.0;
			}
		}
		
		return mass;
	}
	
	public void onBroken(Player player) 
	{
		if (player.getMainHandItem() != null && player.getMainHandItem().getItem() == this) 
		{
			player.drop(new ItemStack(Items.STICK), true);
			player.playSound(SoundEvents.ITEM_BREAK, 1.0f, 1.0f);
		}
	}
	
	public boolean isRaised(@Nullable LivingEntity entityIn)
	{
		if (entityIn == null)
		{
			return false;
		}
		ItemStack stack = entityIn.getMainHandItem();
        if (stack.hasTag()) 
        {
            CompoundTag nbt = stack.getTag();
            return nbt.contains("raised") && nbt.getLong("raised") == 1 ? true : false;
        }
        return false;
	}
	
	public void setRaised(LivingEntity entityIn, boolean raisedIn)
	{
		ItemStack stack = entityIn.getMainHandItem();
		CompoundTag nbt;
		if (!stack.hasTag()) 
        {
			nbt = new CompoundTag();
        }
		else
		{
			nbt = getShareTag(stack);
		}
		nbt.putLong("raised", raisedIn ? 1 : 0);
		stack.setTag(nbt);
	}
	
	
	public void setAttackDamage(float attackDamageIn)
	{
		attackDamage = attackDamageIn;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void registerModelProperty() 
	{
		ItemProperties.register(this, 
	    		new ResourceLocation(KnightlyArmory.ID, "raised"), new ItemPropertyFunction() {
					@Override
						public float call(ItemStack p_174676_, @Nullable ClientLevel p_174677_, @Nullable LivingEntity p_174678_, int p_174679_)
						{
							return isRaised(p_174678_) ? 1 : 0;
						}
	    	    });
	}
	
	public boolean isSilver()
	{
		return isSilver;
	}
}