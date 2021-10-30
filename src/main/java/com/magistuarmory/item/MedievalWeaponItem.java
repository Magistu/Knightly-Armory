package com.magistuarmory.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.magistuarmory.effects.LacerationEffect;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class MedievalWeaponItem extends SwordItem
{

    protected float attackDamage;
    protected float attackSpeed;
    protected float currentAttackDamage;
    private float currentAttackSpeed;
    private float decreasedAttackDamage;
    private float decreasedAttackSpeed;

    private boolean isSilver = false;

    private boolean isFlamebladed = false;

    int armorPiercing = 0;

    private float reachDistance = 0.0F;
    private int twoHanded;

    public MedievalWeaponItem(String unlocName, Item.Properties build, IItemTier material, float attackDamage, float materialFactor, float attackSpeed, int armorPiercing, float reachDistance)
    {
        this(unlocName, build, material, attackDamage, materialFactor, attackSpeed);
        this.armorPiercing = armorPiercing;
        this.reachDistance = reachDistance;
    }

    public MedievalWeaponItem(String unlocName, Item.Properties build, IItemTier material, float attackDamageIn, float materialFactor, float attackSpeedIn)
    {
        super(material, 0, 0.0F, build);
        setRegistryName(unlocName);
        this.attackDamage = attackDamageIn + materialFactor * material.getAttackDamageBonus();
        this.attackSpeed = attackSpeedIn;
        this.currentAttackDamage = this.attackDamage;
        this.currentAttackSpeed = this.attackSpeed;
        if (getTier().equals(ModItemTier.SILVER))
        {
            isSilver = true;
        }
    }

    public MedievalWeaponItem setFlamebladed()
    {
        isFlamebladed = true;
        return this;
    }

    public MedievalWeaponItem setTwoHanded(int level)
    {
        twoHanded = level;
        decreasedAttackDamage = 12.0f * attackDamage / (5.0f * level + 10.0f);
        decreasedAttackSpeed = 14.0f * (attackSpeed + 4.0f) / (15.0f * level + 5.0f) - 4.0f;
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
    public void inventoryTick(ItemStack par1ItemStack, World world, Entity entityIn, int par4, boolean par5)
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

        super.inventoryTick(par1ItemStack, world, entityIn, par4, par5);
    }

    @Override
    public boolean hurtEnemy(ItemStack p_77644_1_, LivingEntity p_77644_2_, LivingEntity p_77644_3_)
    {
        if (this.isSilver && p_77644_2_.getMobType().equals(CreatureAttribute.UNDEAD))
            p_77644_2_.hurt(DamageSource.MAGIC, this.getAttackDamage() + 3.0F);
        if (this.isFlamebladed)
        {
            float damage = (float)(this.attackDamage * (1.0D - Math.min(20.0D, Math.max((p_77644_2_.getArmorValue() / 5), p_77644_2_.getArmorValue() - this.attackDamage / (p_77644_2_.getAttributeValue(Attributes.ARMOR_TOUGHNESS) / 4.0D + 2.0D))) / 25.0D));
            p_77644_2_.addEffect(new EffectInstance(LacerationEffect.LACERATION.setDamageValue(damage), 300, 1, true, true, true));
        }
        return super.hurtEnemy(p_77644_1_, p_77644_2_, p_77644_3_);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        if (this.isSilver)
            tooltip.add((new TranslationTextComponent("silvertools.hurt")).withStyle(TextFormatting.GREEN));
        if (this.isFlamebladed)
            tooltip.add((new TranslationTextComponent("flamebladed.hurt")).withStyle(TextFormatting.BLUE));
        if (this.armorPiercing != 0)
            tooltip.add((new StringTextComponent(this.armorPiercing + "% armor piercing")).withStyle(TextFormatting.BLUE));
        if (this.reachDistance != 0.0F)
            tooltip.add((new StringTextComponent("+" + this.reachDistance + " reach distance")).withStyle(TextFormatting.BLUE));
        if (twoHanded == 1)
            tooltip.add((new StringTextComponent("Two-Handed I")).withStyle(TextFormatting.BLUE));
        else if (twoHanded > 1)
            tooltip.add((new StringTextComponent("Two-Handed II")).withStyle(TextFormatting.BLUE));
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
        return reachDistance + 5.0f;
    }
}
