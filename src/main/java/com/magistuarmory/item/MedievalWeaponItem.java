package com.magistuarmory.item;


import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import com.magistuarmory.KnightlyArmory;

import com.magistuarmory.config.ModConfigurations;
import com.magistuarmory.init.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class MedievalWeaponItem extends SwordItem implements IHasModelProperty
{
	protected float attackDamage;
	protected float attackSpeed;
	protected float currentAttackDamage;
	private float currentAttackSpeed;
	private float decreasedAttackDamage;
	private float decreasedAttackSpeed;
	protected boolean isFlamebladed = false;
	protected boolean isHalberd = false;
	protected boolean isSilver = false;
	private float silverAttackDamage = 0.0f;
	protected int armorPiercing = 0;
	private float bonusReachDistance = 0.0f;
	protected int twoHanded = 0;
	private float maxBlockDamage = 0.0f;
    private float weight;
    private boolean canBlock = false;
	private boolean blockingPriority = false;


	public MedievalWeaponItem(Properties build, Tier material, float baseAttackDamage, float baseAttackSpeed, int armorPiercing, float reachDistance, float weight)
	{
		this(build, material, baseAttackDamage, baseAttackSpeed, weight);
		this.armorPiercing = armorPiercing;
		this.bonusReachDistance = reachDistance;
	}

	public MedievalWeaponItem(Properties build, Tier material, float baseAttackDamage, float baseAttackSpeed, float weight)
	{
		super(material, 0, 0.0f, build);
		this.attackDamage = baseAttackDamage + 1.6f * material.getAttackDamageBonus() / baseAttackSpeed;
		this.attackSpeed = baseAttackSpeed - 4;
		this.currentAttackDamage = attackDamage;
		this.currentAttackSpeed = attackSpeed;
		if (getTier().equals(ModItemTier.SILVER))
		{
			isSilver = true;
			silverAttackDamage = Math.round(6.0F / baseAttackSpeed * 100.0f) / 100.0f;
		}
		this.weight = weight;
	}

	public MedievalWeaponItem setFlamebladed()
	{
		isFlamebladed = true;
		return this;
	}

	public MedievalWeaponItem setTwoHanded(int level)
	{
		twoHanded = level;
		decreasedAttackDamage = level > 1 ? 14.0f * attackDamage / (3.0f * level + 12.0f) : attackDamage;
		decreasedAttackSpeed = 14.0f * (attackSpeed + 4.0f) / (5.0f * level + 10.0f) - 4.0f;
		return this;
	}

	public MedievalWeaponItem setBlocking(float maxBlockDamage)
	{
		this.maxBlockDamage = maxBlockDamage;
		this.canBlock = true;
		return this;
	}

	public MedievalWeaponItem setHalberd()
	{
		isHalberd = true;
		return this;
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) 
	{
		if (slot == EquipmentSlot.MAINHAND) 
		{
    		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
    		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", getAttackDamage(), Operation.ADDITION));
    		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", getAttackSpeed(), Operation.ADDITION));
    	    return builder.build();
        }
        
        return super.getAttributeModifiers(slot, stack);
    }

	@Override
	public void inventoryTick(ItemStack par1ItemStack, Level world, Entity entityIn, int par4, boolean par5)
	{
		boolean flag = false;
		if (!ModConfigurations.disable_two_handed.get() && twoHanded > 0 && entityIn instanceof LivingEntity && !((LivingEntity)entityIn).getOffhandItem().getItem().equals(Items.AIR))
		{
			if (currentAttackDamage != decreasedAttackDamage)
			{
				currentAttackDamage = decreasedAttackDamage;
				flag = true;
			}

			if (currentAttackDamage != decreasedAttackSpeed)
			{
				currentAttackSpeed = decreasedAttackSpeed;
				flag = true;
			}
		}
		else
		{
			if (currentAttackDamage != attackDamage)
			{
				currentAttackDamage = attackDamage;
				flag = true;
			}

			if (currentAttackDamage != attackSpeed)
			{
				currentAttackSpeed = attackSpeed;
				flag = true;
			}
		}

		if (flag)
		{
			ItemStack itemstack = ((LivingEntity) entityIn).getMainHandItem();

			for (EquipmentSlot entityequipmentslot : EquipmentSlot.values())
			{
				((LivingEntity) entityIn).getAttributes().removeAttributeModifiers(itemstack.getAttributeModifiers(entityequipmentslot));
				((LivingEntity) entityIn).getAttributes().addTransientAttributeModifiers(itemstack.getAttributeModifiers(entityequipmentslot));
			}
		}

		if (canBlock() && entityIn instanceof LivingEntity)
		{
			blockingPriority = !(((LivingEntity) entityIn).getMainHandItem().getItem() instanceof ShieldItem) && !(((LivingEntity) entityIn).getOffhandItem().getItem() instanceof ShieldItem);
		}

		super.inventoryTick(par1ItemStack, world, entityIn, par4, par5);
	}
	
	public void onHurtEntity(LivingEntity damager, LivingEntity victim, float damage) 
	{
		if (isSilver && victim.getMobType().equals(MobType.UNDEAD))
		{
			victim.hurt(DamageSource.MAGIC, damage + getSilverAttackDamage());
		}
		if (isFlamebladed && !(victim instanceof Creeper))
		{
			victim.addEffect(new MobEffectInstance(ModEffects.LACERATION_EFFECT.get().setDamage(damage), 300, 1, true, true, true));
		}
		if (isHalberd && victim.isPassenger() && new Random().nextInt(20) >= 14) 
		{
			victim.stopRiding();
		}
		if (!ModConfigurations.disable_armor_piercing.get() && armorPiercing != 0 && victim.getArmorValue() > 0)
		{
			if (damage <= 0) return;
			float f = CombatRules.getDamageAfterAbsorb(damage, (float)victim.getArmorValue(), (float)victim.getAttributeValue(Attributes.ARMOR_TOUGHNESS));
			float f2 = Math.max(f - victim.getAbsorptionAmount(), 0.0F);
			
			float bonusDamage = armorPiercing / 100.0f * (damage - f2);
			victim.hurt(DamageSource.GENERIC.bypassArmor(), damage + bonusDamage);
		}
    }
	
	
	@Override
	public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_)
	{
		if (isSilver)
			p_41423_.add(Component.literal("+" + getSilverAttackDamage() + " ").append(Component.translatable("silvertools.hurt")).withStyle(ChatFormatting.GREEN));
		if (isFlamebladed)
			p_41423_.add(Component.translatable("flamebladed.hurt").withStyle(ChatFormatting.BLUE));
		if (isHalberd)
			p_41423_.add(Component.translatable("halberd.hurt").withStyle(ChatFormatting.BLUE));
		if (!ModConfigurations.disable_armor_piercing.get() && armorPiercing != 0)
			p_41423_.add(Component.literal(armorPiercing + "% ").append(Component.translatable("armorpiercing")).withStyle(ChatFormatting.BLUE));
		if (!ModConfigurations.disable_reach_distance.get() && this.getReachDistance() != 0.0f)
			p_41423_.add(Component.literal("+" + bonusReachDistance + " ").append(Component.translatable("reachdistance")).withStyle(ChatFormatting.BLUE));
		if (twoHanded == 1)
			p_41423_.add(Component.translatable("twohandedi").withStyle(ChatFormatting.BLUE));
		else if (twoHanded > 1)
			p_41423_.add(Component.translatable("twohandedii").withStyle(ChatFormatting.BLUE));
		if (canBlock()) 
		{
			p_41423_.add(Component.literal(getMaxBlockDamage() + " ").append(Component.translatable("maxdamageblock")).withStyle(ChatFormatting.BLUE));
		}
		p_41423_.add(Component.literal(getWeight() + " ").append(Component.translatable("kgweight")).withStyle(ChatFormatting.BLUE));
	}
	
	public float getAttackDamage()
	{
		return currentAttackDamage;
	}
	
	public float getAttackSpeed()
	{
		return currentAttackSpeed;
	}
	
	public float getReachDistance()
	{
		return KnightlyArmory.BC_or_EF_instaled || ModConfigurations.disable_armor_piercing.get() || bonusReachDistance == 0.0f ? 0.0f : 5.0f + bonusReachDistance;
	}

	public float getSilverAttackDamage()
	{
		return silverAttackDamage;
	}

	public float getMaxBlockDamage()
	{
		return this.maxBlockDamage;
	}

	public float getWeight()
	{
		return this.weight;
	}

	public boolean canBlock()
	{
		return !ModConfigurations.disable_weapon_blocking.get() && this.canBlock;
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction action)
	{
		return (canBlock() && ToolActions.DEFAULT_SHIELD_ACTIONS.contains(action)) || ToolActions.DEFAULT_SWORD_ACTIONS.contains(action);
	}

	boolean haveBlocked(Random rand, DamageSource source)
	{
		return !source.isProjectile() && rand.nextInt(18) > this.getWeight();
	}

	@Override
    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_)
    {
        if (canBlock() && blockingPriority)
        {
            ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
            p_77659_2_.startUsingItem(p_77659_3_);

            return InteractionResultHolder.consume(itemstack);
        }

        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }

    public int getUseDuration(ItemStack p_77626_1_)
    {
        return canBlock() ? (int) (500 / getWeight()) : 0;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_77661_1_)
    {
        return (canBlock() && blockingPriority) ? UseAnim.BLOCK : super.getUseAnimation(p_77661_1_);
    }

    public void onBlocked(ItemStack stack, float damage, Player player, DamageSource source)
    {
        if (canBlock())
        {
            float armorPiercingFactor = 1.0f;
            if (source.getEntity() instanceof LivingEntity)
            {
                LivingEntity attacker = (LivingEntity) source.getEntity();
                if (attacker.getMainHandItem().getItem() instanceof MedievalWeaponItem)
                {
                    armorPiercingFactor += (float) ((MedievalWeaponItem) attacker.getMainHandItem().getItem()).armorPiercing / 100.0f;
                }
            }

			if (source.isExplosion())
            {
                player.hurt(DamageSource.GENERIC, damage);

                return;
            }
            else if (!haveBlocked(new Random(), source))
            {
                float damage2 = CombatRules.getDamageAfterAbsorb(damage, (float)player.getArmorValue(), (float)player.getAttributeValue(Attributes.ARMOR_TOUGHNESS));
                player.hurt(DamageSource.GENERIC, damage2);

                return;
            }
            else if (damage > getMaxBlockDamage())
            {
                stack.hurtAndBreak((int) (armorPiercingFactor * 1.5f * getMaxBlockDamage()), player, (p_220044_0_) ->
						p_220044_0_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                float damage1 = damage - getMaxBlockDamage();
                float damage2 = CombatRules.getDamageAfterAbsorb(damage1, (float)player.getArmorValue(), (float)player.getAttributeValue(Attributes.ARMOR_TOUGHNESS));
				player.hurt(DamageSource.GENERIC, damage2);
                return;
            }

            stack.hurtAndBreak((int) (armorPiercingFactor * damage), player, (p_220044_0_) ->
					p_220044_0_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
    }

	@Override
	@OnlyIn(Dist.CLIENT)
	public void registerModelProperty()
	{
		if (canBlock)
		{
			ItemProperties.register(this, new ResourceLocation("blocking"), (p_174590_, p_174591_, p_174592_, p_174593_) ->
					p_174592_ != null && p_174592_.isUsingItem() && p_174592_.getUseItem() == p_174590_ ? 1.0F : 0.0F);
		}
	}
}
