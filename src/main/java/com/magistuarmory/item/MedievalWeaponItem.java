package com.magistuarmory.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.magistuarmory.effects.LacerationEffect;

import java.util.List;
import java.util.Random;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

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
    private float reachDistance = 0.0F;
    protected int twoHanded = 0;
    private float maxBlockDamage = 0.0f;
    private float weight;
    private boolean canBlock = false;
    private boolean blockingPriority = false;

    public MedievalWeaponItem(Item.Properties build, IItemTier material, float baseAttackDamage, float baseAttackSpeed, int armorPiercing, float reachDistance, float weight)
    {
        this(build, material, baseAttackDamage, baseAttackSpeed, weight);
        this.armorPiercing = armorPiercing;
        this.reachDistance = reachDistance;
    }

    public MedievalWeaponItem(Item.Properties build, IItemTier material, float baseAttackDamage, float baseAttackSpeed, float weight)
    {
        super(material, 0, 0.0F, build);
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
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack)
    {
        if (slot == EquipmentSlotType.MAINHAND)
        {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.getAttackDamage(), AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", this.getAttackSpeed(), AttributeModifier.Operation.ADDITION));
            return builder.build();
        }
        return super.getAttributeModifiers(slot, stack);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack par1ItemStack, @NotNull World world, @NotNull Entity entityIn, int par4, boolean par5)
    {
        boolean flag = false;
        if (twoHanded > 0 && entityIn instanceof LivingEntity && !((LivingEntity)entityIn).getOffhandItem().getItem().equals(Items.AIR))
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
            if (entityIn instanceof LivingEntity)
            {
                ItemStack itemstack = ((LivingEntity) entityIn).getMainHandItem();

                for (EquipmentSlotType entityequipmentslot : EquipmentSlotType.values())
                {
                    ((LivingEntity) entityIn).getAttributes().removeAttributeModifiers(itemstack.getAttributeModifiers(entityequipmentslot));
                    ((LivingEntity) entityIn).getAttributes().addTransientAttributeModifiers(itemstack.getAttributeModifiers(entityequipmentslot));
                }
            }
        }

        if (this.canBlock() && entityIn instanceof LivingEntity)
        {
            blockingPriority = !(((LivingEntity) entityIn).getMainHandItem().getItem() instanceof ShieldItem) && !(((LivingEntity) entityIn).getOffhandItem().getItem() instanceof ShieldItem);
        }

        super.inventoryTick(par1ItemStack, world, entityIn, par4, par5);
    }

    @Override
    public boolean hurtEnemy(ItemStack p_77644_1_, @NotNull LivingEntity p_77644_2_, @NotNull LivingEntity p_77644_3_)
    {
        if (this.isSilver && p_77644_2_.getMobType().equals(CreatureAttribute.UNDEAD))
            p_77644_2_.hurt(DamageSource.MAGIC, this.getAttackDamage() + getSilverAttackDamage());
        if (this.isFlamebladed)
        {
            float damage = CombatRules.getDamageAfterAbsorb(this.attackDamage, (float)p_77644_2_.getArmorValue(), (float)p_77644_2_.getAttributeValue(Attributes.ARMOR_TOUGHNESS));
            p_77644_2_.addEffect(new EffectInstance(LacerationEffect.LACERATION.setDamageValue(damage), 300, 1, true, true, true));
        }
        if (isHalberd && p_77644_2_.isPassenger() && new Random().nextInt(20) == 1)
        {
            p_77644_2_.stopRiding();
        }
        if (armorPiercing != 0 && p_77644_2_.getArmorValue() > 0)
        {
            float piercedArmor = p_77644_2_.getArmorValue() * (1 - armorPiercing / 100);
            float baseDamage = CombatRules.getDamageAfterAbsorb(attackDamage, (float)p_77644_2_.getArmorValue(), (float)p_77644_2_.getAttributeValue(Attributes.ARMOR_TOUGHNESS));
            float totalDamage = (float) (attackDamage * (1 - Math.min(20, Math.max( piercedArmor / 5, piercedArmor - attackDamage / (p_77644_2_.getAttributeValue(Attributes.ARMOR_TOUGHNESS) / 4 + 2))) / 25));
            float bonusDamage = totalDamage - baseDamage;
            p_77644_2_.hurt(DamageSource.mobAttack(p_77644_3_).bypassArmor(), bonusDamage);
        }
        return super.hurtEnemy(p_77644_1_, p_77644_2_, p_77644_3_);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, World worldIn, @NotNull List<ITextComponent> tooltip, @NotNull ITooltipFlag flagIn)
    {
        if (this.isSilver)
            tooltip.add(new StringTextComponent("+" + this.getSilverAttackDamage() + " ").append(new TranslationTextComponent("silvertools.hurt")).withStyle(TextFormatting.GREEN));
        if (this.isFlamebladed)
            tooltip.add(new TranslationTextComponent("flamebladed.hurt").withStyle(TextFormatting.BLUE));
        if (this.armorPiercing != 0)
            tooltip.add(new StringTextComponent(this.armorPiercing + "% ").append(new TranslationTextComponent("armorpiercing")).withStyle(TextFormatting.BLUE));
        if (this.reachDistance != 0.0F)
            tooltip.add(new StringTextComponent("+" + this.reachDistance + " ").append(new TranslationTextComponent("reachdistance")).withStyle(TextFormatting.BLUE));
        if (this.twoHanded == 1)
            tooltip.add(new TranslationTextComponent("twohandedi").withStyle(TextFormatting.BLUE));
        else if (this.twoHanded > 1)
            tooltip.add(new TranslationTextComponent("twohandedii").withStyle(TextFormatting.BLUE));
        if (this.canBlock())
            tooltip.add(new StringTextComponent(getMaxBlockDamage() + " ").append(new TranslationTextComponent("maxdamageblock")).withStyle(TextFormatting.BLUE));
        tooltip.add(new StringTextComponent(getWeight() + "").append(new TranslationTextComponent("kgweight")).withStyle(TextFormatting.BLUE));
    }

    public float getAttackDamage()
    {
        return this.currentAttackDamage;
    }

    public float getAttackSpeed()
    {
        return currentAttackSpeed;
    }

    public float getReachDistance()
    {
        return reachDistance + 5.0f;
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
        return this.canBlock;
    }

    @Override
    public boolean isShield(ItemStack stack, LivingEntity entity)
    {
        return this.canBlock();
    }

    boolean haveBlocked(Random rand, DamageSource source)
    {
        return !source.isProjectile() && rand.nextInt(18) > this.getWeight();
    }

    @Override
    public @NotNull ActionResult<ItemStack> use(@NotNull World p_77659_1_, @NotNull PlayerEntity p_77659_2_, @NotNull Hand p_77659_3_)
    {
        if (this.canBlock() && this.blockingPriority)
        {
            ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
            p_77659_2_.startUsingItem(p_77659_3_);

            return ActionResult.consume(itemstack);
        }

        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }

    public int getUseDuration(@NotNull ItemStack p_77626_1_)
    {
        return canBlock() ? (int) (500 / getWeight()) : 0;
    }

    @Override
    public @NotNull UseAction getUseAnimation(@NotNull ItemStack p_77661_1_)
    {
        return (this.canBlock() && this.blockingPriority) ? UseAction.BLOCK : super.getUseAnimation(p_77661_1_);
    }

    public void onBlock(ItemStack stack, float damage, PlayerEntity player, DamageSource source)
    {
        if (this.canBlock())
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
            else if (!this.haveBlocked(new Random(), source))
            {
                float damage2 = CombatRules.getDamageAfterAbsorb(damage, (float)player.getArmorValue(), (float)player.getAttributeValue(Attributes.ARMOR_TOUGHNESS));
                player.hurt(DamageSource.GENERIC, damage2);
            }
            else if (damage > getMaxBlockDamage())
            {
                stack.hurtAndBreak((int) (armorPiercingFactor * 1.5f * getMaxBlockDamage()), player, (p_220044_0_) ->
                        p_220044_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND));
                float damage1 = damage - getMaxBlockDamage();
                float damage2 = CombatRules.getDamageAfterAbsorb(damage1, (float)player.getArmorValue(), (float)player.getAttributeValue(Attributes.ARMOR_TOUGHNESS));
                player.hurt(DamageSource.GENERIC, damage2);

                return;
            }

            stack.hurtAndBreak((int) (armorPiercingFactor * damage), player, (p_220044_0_) ->
                    p_220044_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND));
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void registerModelProperty()
    {
        if (this.canBlock())
        {
            ItemModelsProperties.register(this, new ResourceLocation("blocking"), (p_239421_0_, p_239421_1_, p_239421_2_) ->
                    p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == p_239421_0_ ? 1.0F : 0.0F);
        }
    }
}
