package com.magistuarmory.item;

import java.util.*;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;
import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.effects.LacerationEffect;
import com.magistuarmory.init.ModItems;
import com.magistuarmory.util.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MedievalWeaponItem extends ItemSword implements IHasModel
{

	protected float attackDamage;
	protected float attackSpeed;
	protected int armorPiercing = 0;
	protected float reachDistance = 0.0f;
	protected boolean isSilver = false;
	protected boolean isFlamebladed = false;
	protected int twoHanded = 0;
	private float currentAttackDamage;
	private float currentAttackSpeed;
	private float decreasedAttackDamage;
	private float decreasedAttackSpeed;
	private float maxBlockDamage = 0.0f;
    private float weight = 1.0f;
    private boolean canBlock = false;
	private boolean blockingPriority = false;
	

	
	public MedievalWeaponItem(String unlocName, ToolMaterial material, float baseAttackDamage, float materialFactor, float baseAttackSpeed, int armorPiercing, float reachDistance)
	{
		this(unlocName, material, baseAttackDamage, materialFactor, baseAttackSpeed);
		this.armorPiercing = armorPiercing;
		this.reachDistance = reachDistance;
	}
	
	public MedievalWeaponItem(String unlocName, ToolMaterial material, float baseAttackDamage, float materialFactor, float baseAttackSpeed) 
	{
		super(material);
		setRegistryName(unlocName);
		setUnlocalizedName(unlocName);
		this.attackDamage = baseAttackDamage + materialFactor * material.getAttackDamage();
		this.attackSpeed = baseAttackSpeed;
		this.currentAttackDamage = attackDamage;
		this.currentAttackSpeed = attackSpeed;
		
		if (material.equals(ModItems.TOOL_MATERIAL_SILVER))
		{
			isSilver = true;
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean isFull3D() 
	{
		return false;
	}
	
	@Override
	public void registerModels() 
	{
		KnightlyArmory.PROXY.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
        	replaceModifier(multimap, SharedMonsterAttributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, (double)getAttackDamage());
        	replaceModifier(multimap, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, (double)getAttackSpeed());
        }

        return multimap;
    }
	
	@Override
	public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_) 
	{
		if (isSilver && p_77644_2_.getCreatureAttribute().equals(EnumCreatureAttribute.UNDEAD))
		{
			p_77644_2_.attackEntityFrom(DamageSource.MAGIC, getAttackDamage() + 3.0F);
		}
		if (isFlamebladed)
		{
			float damage = (float) (getAttackDamage() * (1 - Math.min(20, Math.max( p_77644_2_.getTotalArmorValue() / 5, p_77644_2_.getTotalArmorValue() - getAttackDamage() / (p_77644_2_.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue() / 4 + 2))) / 25));
			p_77644_2_.addPotionEffect(new PotionEffect(LacerationEffect.LACERATION.setDamage(damage), 300, 1, true, true));
		}
		if (armorPiercing != 0 && p_77644_2_.getTotalArmorValue() > 0)
		{
			float piercedArmor = p_77644_2_.getTotalArmorValue() * (1 - armorPiercing / 100);
			float baseDamage = (float) (getAttackDamage() * (1 - Math.min(20, Math.max( p_77644_2_.getTotalArmorValue() / 5, p_77644_2_.getTotalArmorValue() - getAttackDamage() / (p_77644_2_.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue() / 4 + 2))) / 25));
			float totalDamage = (float) (getAttackDamage() * (1 - Math.min(20, Math.max( piercedArmor / 5, piercedArmor - getAttackDamage() / (p_77644_2_.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue() / 4 + 2))) / 25));
			float bonusDamage = totalDamage - baseDamage;
			p_77644_2_.attackEntityFrom(DamageSource.GENERIC, bonusDamage);
		}
		
		return super.hitEntity(p_77644_1_, p_77644_2_, p_77644_3_);
    }
	
	private void replaceModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id, double value)
    {
        // Get the modifiers for the specified attribute
        final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());

        // Find the modifier with the specified ID, if any
        final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();
 
        if (modifierOptional.isPresent()) 
      	{
            final AttributeModifier modifier = modifierOptional.get();
      
            modifiers.remove(modifier); // Remove it
            modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), value, modifier.getOperation())); // Might wanna change the formula a bit because it's funky...
        }
    }
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		if (isSilver)
			tooltip.add("+2 damage against undead");
		if (isFlamebladed)
			tooltip.add("Inflicts non-healing wounds");
		if (twoHanded == 1)
			tooltip.add("Two-Handed I");
		else if (twoHanded > 1)
			tooltip.add("Two-Handed II");
		if (armorPiercing != 0)
			tooltip.add(armorPiercing + "% armor piercing");
		if (reachDistance != 0.0f)
			tooltip.add("+" + reachDistance + " reach distance");
		if (canBlock())
		    tooltip.add(getMaxBlockDamage() + " max damage block");
            tooltip.add(getWeight() + "kg weight");

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

	public MedievalWeaponItem setBlocking(float weight, float maxBlockDamage)
    {
        this.weight = weight;
        this.maxBlockDamage = maxBlockDamage;
        this.canBlock = true;
		this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        return this;
    }
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		boolean flag = false;
		if (twoHanded > 0 && entityIn instanceof EntityLivingBase && !((EntityLivingBase)entityIn).getHeldItemOffhand().getItem().equals(Items.AIR))
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
			ItemStack itemstack = ((EntityLivingBase)entityIn).getHeldItemMainhand();
			
			for (EntityEquipmentSlot entityequipmentslot : EntityEquipmentSlot.values())
			{
				((EntityLivingBase)entityIn).getAttributeMap().removeAttributeModifiers(itemstack.getAttributeModifiers(entityequipmentslot));
				((EntityLivingBase)entityIn).getAttributeMap().applyAttributeModifiers(itemstack.getAttributeModifiers(entityequipmentslot));
			}
		}

		if (canBlock() && entityIn instanceof EntityLivingBase)
        {
            blockingPriority = !(((EntityLivingBase) entityIn).getHeldItemMainhand().getItem() instanceof ItemShield) && !(((EntityLivingBase) entityIn).getHeldItemOffhand().getItem() instanceof ItemShield);
        }
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		return super.onEntitySwing(entityLiving, stack);
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

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		if (canBlock() && blockingPriority)
		{
			ItemStack itemstack = playerIn.getHeldItem(handIn);
			playerIn.setActiveHand(handIn);

			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		}

		return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public int getUseDuration(ItemStack p_77626_1_)
    {
        return canBlock() ? (int) (500 / getWeight()) : 0;
    }

	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return canBlock() ? (int) (500 / getWeight()) : 0;
    }

    @Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
		return (canBlock() && blockingPriority) ? EnumAction.BLOCK : super.getItemUseAction(stack);
    }

	public void onBlocked(ItemStack stack, float damage, EntityPlayer player, DamageSource source)
    {
        if (canBlock())
        {
            float armorPiercingFactor = 1.0f;
            if (source.getTrueSource() instanceof EntityLivingBase)
            {
                EntityLivingBase attacker = (EntityLivingBase) source.getTrueSource();
                if (attacker.getHeldItemMainhand().getItem() instanceof MedievalWeaponItem)
                {
                    armorPiercingFactor += ((MedievalWeaponItem) attacker.getHeldItemMainhand().getItem()).armorPiercing / 100.0f;
                }
            }

			if (source.isExplosion())
            {
                player.attackEntityFrom(DamageSource.GENERIC, damage);

                return;
            }
            else if (!haveBlocked(new Random(), source))
            {
                float damage2 = CombatRules.getDamageAfterAbsorb(damage, (float)player.getTotalArmorValue(), (float)player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue());
                player.attackEntityFrom(DamageSource.GENERIC, damage2);

                return;
            }
            else if (damage > getMaxBlockDamage())
            {
                stack.damageItem((int) (armorPiercingFactor * 0.2f * stack.getMaxDamage()), player);
                float damage1 = damage - getMaxBlockDamage();
                float damage2 = CombatRules.getDamageAfterAbsorb(damage1, (float)player.getTotalArmorValue(), (float)player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue());
                player.attackEntityFrom(DamageSource.GENERIC, damage2);

                return;
            }

            stack.damageItem((int) (armorPiercingFactor * damage), player);
        }
    }

    public float getMaxBlockDamage()
    {
        return maxBlockDamage;
    }

    public float getWeight()
    {
        return weight;
    }

    public boolean canBlock()
    {
        return canBlock;
    }

	@Override
    public boolean isShield(ItemStack stack, EntityLivingBase entity)
    {
        return canBlock();
    }

	boolean haveBlocked(Random rand, DamageSource source)
	{
		return !source.isProjectile() && rand.nextInt(14) > getWeight();
	}
}
