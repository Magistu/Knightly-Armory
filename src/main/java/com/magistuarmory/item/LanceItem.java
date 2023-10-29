package com.magistuarmory.item;

import java.util.List;

import javax.annotation.Nullable;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.event.ClientEvent;
import com.magistuarmory.network.PacketBase;
import com.magistuarmory.network.PacketHandler;
import com.magistuarmory.network.PacketLanceCollision;
import com.magistuarmory.network.PacketLongReachAttack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class LanceItem extends MedievalWeaponItem
{
	
	public boolean attacking = false;
	public double velocityProjection = 0.0;
	private int ticksLastUpdtate = 20;
	public int strength = 0;
	private int clickedTicks = 0;
	

	
	public LanceItem(String unlocName, ToolMaterial material, float baseAttackDamage, float materialFactor, float baseAttackSpeed, int armorPiercing, float reachDistance) 
	{
		super(unlocName, material, baseAttackDamage, materialFactor, baseAttackSpeed, armorPiercing, reachDistance);
		addPropertyOverride(new ResourceLocation(KnightlyArmory.ID, "raised"),
                new IItemPropertyGetter() {
                    @Override
                    @SideOnly(Side.CLIENT)
                    public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                        return isRaised(entityIn) ? 1 : 0;
                    }
                });
	}

	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean isFull3D() 
	{
		return false;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		setRaised(playerIn, isRaised(playerIn) ? false : true);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) 
	{
		return EnumAction.BOW;
	}

	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World world, Entity entity, int par4, boolean par5) 
	{
		if (entity != null && entity instanceof EntityPlayer) 
		{
			EntityPlayer player = (EntityPlayer)entity;
			if (FMLLaunchHandler.side() == Side.CLIENT && player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof LanceItem) 
			{
				RayTraceResult result = ClientEvent.getMouseOver(this.getReachDistance());
				if (result != null && result.entityHit != null) 
				{
					Entity aim = result.entityHit;
					if (player.isRiding() && aim instanceof EntityLivingBase && !aim.isDead && aim.getEntityId() != player.getRidingEntity().getEntityId())
					{
						collide((EntityLivingBase)aim, player, world);
					}
				} 
			}
			
			if (clickedTicks > 0)
			{
				clickedTicks--;
			}
			
			if (!isRaised(player) && player.getCooldownTracker().hasCooldown(this))
			{
				setRaised(player, true);
			}
		} 
		super.onUpdate(par1ItemStack, world, entity, par4, par5);
	}

	
	public void collide(EntityLivingBase victim, EntityPlayer player, World world) 
	{
		if (player == null) 
		{
			return;
		}
		if (world == null) 
		{
			return;
		}
		
		if (!isRaised(player) && !player.getCooldownTracker().hasCooldown(this))
		{
			
			int bonusDamage = (int)calcBonusDamage(player, velocityProjection);
			
			if (player.isRiding())
			{
				velocityProjection = getVelocityProjection(player, victim);
				if (velocityProjection > 0.233)
				{
					PacketHandler.sendPacketToServer((PacketBase)new PacketLanceCollision(victim.getEntityId(), bonusDamage));
				}
			}
		}
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		return EnumActionResult.PASS;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) 
	{
		
		if (attacking)
		{
			Vec3d vec = player.getLook(1.0f);
			double b = Math.sqrt(Math.max(0.0, velocityProjection) / Math.max(0.5, vec.lengthVector() * getSummaryMass(entity))) / 5.0;
			
			if (entity.isRiding())
			{
				entity.getRidingEntity().motionX += vec.x * b;
				entity.getRidingEntity().motionY += vec.y * b;
				entity.getRidingEntity().motionZ += vec.z * b;
				if (((clickedTicks > 0 ? 0.3 : 0.0) + 0.6 + 0.2 * entity.getEntityBoundingBox().getCenter().subtract(player.getPositionEyes(1.0f).add(player.getLook(getReachDistance()))).dotProduct(vec) / vec.lengthVector()) * Math.random() > 1)
				{
					entity.dismountRidingEntity();
				}
				
			}
			else
			{
				entity.motionX += vec.x * b;
				entity.motionY += vec.y * b;
				entity.motionZ += vec.z * b;
			}
			return false;
		}
		else if (!isRaised(player) && !player.getCooldownTracker().hasCooldown(this))
		{
			clickedTicks = 15;
		}
		return true;
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) 
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
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add("Rider only");
		tooltip.add("Left-click before hitting to dismount target");
		tooltip.add("+bonus damage based on mass and speed");
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	
	double getVelocityProjection(Entity entity1, Entity entity2) 
	{
		Vec3d velocity;
		if (entity1.isRiding())
		{
			velocity = new Vec3d(entity1.getRidingEntity().motionX, entity1.getRidingEntity().motionY, entity1.getRidingEntity().motionZ);
		}
		else
		{
			velocity = new Vec3d(entity1.motionX, entity1.motionY, entity1.motionZ);
		}
		
		Vec3d vec = entity1.getLook(1.0f);		
		
		if (vec.lengthSquared() == 0.0)
		{
			return 0.0;
		}
		
		return velocity.dotProduct(vec) / vec.lengthVector();
	}
	
	
	public double getSummaryMass(Entity entityIn)
	{
		Entity entity = entityIn;
		double summaryMass = getMass(entity);
		
		while (entity.isRiding())
		{
			entity = entity.getRidingEntity();
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
		
		AxisAlignedBB box = entity.getEntityBoundingBox();
		if (box != null)
		{
			mass += (box.maxX - box.minX) * (box.maxY - box.minY) * (box.maxZ - box.minZ);
		}
		
		for (ItemStack armorPiece : entity.getArmorInventoryList())
		{
			if (!armorPiece.isEmpty() && armorPiece.getItem() instanceof ItemArmor)
			{
				mass += (((ItemArmor)armorPiece.getItem()).damageReduceAmount + ((ItemArmor)armorPiece.getItem()).toughness) / 20.0;
			}
		}
		
		return mass;
	}
	
	public void onBroken(EntityPlayer player) 
	{
		if (player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() == this) 
		{
			player.dropItem(new ItemStack(Items.STICK), true);
		}
	}
	
	public boolean isRaised(@Nullable EntityLivingBase entityIn)
	{
		if (entityIn == null)
		{
			return false;
		}
		ItemStack stack = entityIn.getHeldItemMainhand();
        if (stack.hasTagCompound()) 
        {
            NBTTagCompound nbt = stack.getTagCompound();
            return nbt.hasKey("raised") && nbt.getLong("raised") == 1 ? true : false;
        }
        return false;
	}
	
	public void setRaised(EntityLivingBase entityIn, boolean raisedIn)
	{
		ItemStack stack = entityIn.getHeldItemMainhand();
		NBTTagCompound nbt;
		if (!stack.hasTagCompound()) 
        {
			nbt = new NBTTagCompound();
        }
		else
		{
			nbt = getNBTShareTag(stack);
		}
		nbt.setLong("raised", raisedIn ? 1 : 0);
		stack.setTagCompound(nbt);
	}
	
	
	public void setAttackDamage(float attackDamageIn)
	{
		attackDamage = attackDamageIn;
	}
}