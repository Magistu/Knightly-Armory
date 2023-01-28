package com.magistuarmory.item;

import java.util.Locale;
import java.util.function.Supplier;

import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.resources.ResourceLocation;

public class ModItemTier implements Tier
{
	private final String name;
	private final float attackDamageBonus;
	private final int enchantmentValue;
	private final int level;
	private final LazyLoadedValue<Ingredient> repairIngredient;
	private final float speed;
	private final int uses;
	private final float density;
	
	public static ModItemTier WOOD = new ModItemTier("wood", Tiers.WOOD, 0);
	public static ModItemTier STONE = new ModItemTier("stone", Tiers.STONE, 1);
	public static ModItemTier IRON = new ModItemTier("iron", Tiers.IRON, 2);
	public static ModItemTier DIAMOND = new ModItemTier("diamond", Tiers.DIAMOND, 3);
	public static ModItemTier GOLD = new ModItemTier("gold", Tiers.GOLD, 4);
	public static ModItemTier NETHERITE = new ModItemTier("netherite", Tiers.NETHERITE, 5);
	
	public static ModItemTier COPPER = new ModItemTier("copper", 1, 150, 0.7F, 0.0F, 10, () -> { return Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/copper"))); }, 1);
	public static ModItemTier SILVER = new ModItemTier("silver", 2, 230, 5.5F, 1.0F, 18, () -> { return Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/silver"))); }, 2);
	public static ModItemTier STEEL = new ModItemTier("steel", 2, 400, 6.0F, 2.5F, 14, () -> { return Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/steel"))); }, 2);
    public static ModItemTier TIN = new ModItemTier("tin", 2, 130, 6.0F, 0.0F, 20, () -> { return Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/tin"))); }, 2);
    public static ModItemTier BRONZE = new ModItemTier("bronze", 2, 200, 6.0F, 2.0F, 15, () -> { return Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/bronze"))); }, 2);

	public ModItemTier(String name, Tier tier, float density)
	{
		this.name = name;
		this.level = tier.getLevel();
		this.uses = tier.getUses();
		this.speed = tier.getSpeed();
		this.attackDamageBonus = tier.getAttackDamageBonus();
		this.enchantmentValue = tier.getEnchantmentValue();
		this.repairIngredient = new LazyLoadedValue<>(() -> { return tier.getRepairIngredient(); });
		this.density = density;
	}

	public ModItemTier(String name, int p_i48458_3_, int p_i48458_4_, float p_i48458_5_, float p_i48458_6_, int p_i48458_7_, Supplier<Ingredient> p_i48458_8_, float density) 
	{
		this.name = name;
		this.level = p_i48458_3_;
		this.uses = p_i48458_4_;
		this.speed = p_i48458_5_;
		this.attackDamageBonus = p_i48458_6_;
		this.enchantmentValue = p_i48458_7_;
		this.repairIngredient = new LazyLoadedValue<>(p_i48458_8_);
		this.density = density;
	}

	@Override
	public float getAttackDamageBonus() 
	{
		return attackDamageBonus;
	}

	@Override
	public int getEnchantmentValue() 
	{
		return enchantmentValue;
	}

	@Override
	public int getLevel() 
	{
		return level;
	}

	@Override
	public Ingredient getRepairIngredient() 
	{
		return repairIngredient.get();
	}

	@Override
	public float getSpeed() 
	{
		return speed;
	}

	@Override
	public int getUses() 
	{
		return uses;
	}

	public String getMaterialName() 
	{
		return name;
	}
	
	public float getDensity() 
	{
		return density;
	}
}
