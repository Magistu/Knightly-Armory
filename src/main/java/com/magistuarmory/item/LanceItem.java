package com.magistuarmory.item;

import com.magistuarmory.event.ClientEventHandler;
import com.magistuarmory.network.PacketHandler;
import com.magistuarmory.network.PacketLanceCollision;
import java.util.List;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class LanceItem extends MedievalWeaponItem implements IHasModelProperty, IDyeableArmorItem
{
    public boolean attacking = false;
    public double velocityProjection = 0.0D;
    private int clickedTicks = 0;

    public LanceItem(Item.Properties build, IItemTier material, float baseAttackDamage, float baseAttackSpeed, int armorPiercing, float reachDistance, float weight)
    {
        super(build, material, baseAttackDamage, baseAttackSpeed, armorPiercing, reachDistance, weight);
    }

    @Override
    public @NotNull ActionResult<ItemStack> use(@NotNull World p_41432_, @NotNull PlayerEntity p_41433_, @NotNull Hand p_41434_)
    {
        setRaised(p_41433_, !isRaised(p_41433_));

        return super.use(p_41432_, p_41433_, p_41434_);
    }

    @Override
    public @NotNull UseAction getUseAnimation(@NotNull ItemStack par1ItemStack)
    {
        return UseAction.BOW;
    }

    @Override
    public void inventoryTick(@NotNull ItemStack par1ItemStack, @NotNull World world, @NotNull Entity entity, int par4, boolean par5)
    {
        if (entity != null && entity instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity)entity;
            if (world.isClientSide && player.getMainHandItem() != null && player.getMainHandItem().getItem() instanceof LanceItem)
            {
                RayTraceResult result = ClientEventHandler.getMouseOver(getReachDistance(), 0.0);
                if (result != null && result instanceof EntityRayTraceResult)
                {
                    Entity aim = ((EntityRayTraceResult)result).getEntity();
                    if (player.isPassenger() && aim instanceof LivingEntity && aim.isAlive() && aim.getId() != player.getVehicle().getId())
                    {
                        collide((LivingEntity) aim, player, world);
                    }
                }
            }

            if (this.clickedTicks > 0)
            {
                this.clickedTicks--;
            }

            if (!isRaised(player) && player.getCooldowns().isOnCooldown(this))
            {
                setRaised(player, true);
            }
        }
    }

    public void collide(LivingEntity victim, PlayerEntity player, World world)
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

                if ((player.getRootVehicle() instanceof HorseEntity &&
                        velocityProjection >= ((HorseEntity)player.getRootVehicle()).getAttribute(Attributes.MOVEMENT_SPEED).getValue())
                        || (!(player.getRootVehicle() instanceof HorseEntity) && velocityProjection >= 0.233))
                {
                    PacketHandler.sendToServer(new PacketLanceCollision(victim.getId(), bonusDamage));
                }
            }
        }
    }

    @Override
    public ActionResultType useOn(ItemUseContext context)
    {
        return ActionResultType.PASS;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity)
    {
        if (attacking)
        {
            Vector3d vec = player.getViewVector(1.0f);
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
        double bonusDamage = 0.0D;
        bonusDamage = 5.0D * getSummaryMass(player) * velocityProjection;

        return Math.max(0.0D, bonusDamage);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, World level, List<ITextComponent> tooltip, @NotNull ITooltipFlag flagIn)
    {
        tooltip.add((new TranslationTextComponent("lance.rideronly")).withStyle(TextFormatting.BLUE));
        tooltip.add((new TranslationTextComponent("lance.leftclick")).withStyle(TextFormatting.BLUE));
        tooltip.add((new TranslationTextComponent("lance.bonusdamage")).withStyle(TextFormatting.BLUE));

        super.appendHoverText(stack, level, tooltip, flagIn);
    }

    double getVelocityProjection(Entity entity1, Entity entity2)
    {
        Vector3d velocity;
        if (entity1.isPassenger())
        {
            velocity = entity1.getRootVehicle().getDeltaMovement();
        }
        else
        {
            velocity = entity1.getDeltaMovement();
        }

        Vector3d vec = entity1.getViewVector(1.0f);

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

        AxisAlignedBB box = entity.getBoundingBox();
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

    public void onBroken(PlayerEntity player)
    {
        if (player.getMainHandItem() != null && player.getMainHandItem().getItem() == this)
        {
            player.drop(new ItemStack(Items.STICK), true);
            player.playSound(SoundEvents.ITEM_BREAK, 1.0f, 1.0f);
        }
    }

    public boolean isRaised(LivingEntity entityIn)
    {
        if (entityIn == null)
        {
            return false;
        }

        ItemStack stack = entityIn.getMainHandItem();
        if (stack.hasTag())
        {
            CompoundNBT nbt = stack.getTag();

            return (nbt.contains("raised") && nbt.getLong("raised") == 1L);
        }

        return false;
    }

    public void setRaised(LivingEntity entityIn, boolean raisedIn)
    {
        CompoundNBT nbt;
        ItemStack stack = entityIn.getMainHandItem();
        if (!stack.hasTag())
        {
            nbt = new CompoundNBT();
        }
        else
        {
            nbt = getShareTag(stack);
        }
        nbt.putLong("raised", raisedIn ? 1L : 0L);
        stack.setTag(nbt);
    }

    public void setAttackDamage(float attackDamageIn)
    {
        this.attackDamage = attackDamageIn;
    }

    public void registerModelProperty()
    {
        ItemModelsProperties.register((Item)this, new ResourceLocation("magistuarmory", "raised"), (stack, world, entity) -> isRaised(entity) ? 1.0F : 0.0F);
    }

    @Override
    public int getColor(ItemStack p_200886_1_)
    {
        CompoundNBT compoundnbt = p_200886_1_.getTagElement("display");
        return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : -10092544;
    }

    public boolean isSilver()
    {
        return isSilver;
    }
}
