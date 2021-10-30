package com.magistuarmory.item;

import java.util.function.Supplier;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;

public class ModItemTier implements IItemTier
{
    private final String name;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final int level;
    private final LazyValue<Ingredient> repairIngredient;
    private final float speed;
    private final int uses;
    private final float density;

    public static ModItemTier WOOD = new ModItemTier("wood", ItemTier.WOOD, 0.0F);
    public static ModItemTier STONE = new ModItemTier("stone", ItemTier.STONE, 1.0F);
    public static ModItemTier IRON = new ModItemTier("iron", ItemTier.IRON, 2.0F);
    public static ModItemTier DIAMOND = new ModItemTier("diamond", ItemTier.DIAMOND, 3.0F);
    public static ModItemTier GOLD = new ModItemTier("gold", ItemTier.GOLD, 4.0F);
    public static ModItemTier NETHERITE = new ModItemTier("netherite", ItemTier.NETHERITE, 5.0F);

    public static ModItemTier COPPER = new ModItemTier("copper", 1, 150, 0.7F, 0.0F, 10, () -> Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/copper"))), 1);
    public static ModItemTier SILVER = new ModItemTier("silver", 2, 230, 5.5F, 1.0F, 18, () -> Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/silver"))), 2);
    public static ModItemTier STEEL = new ModItemTier("steel", 2, 400, 6.0F, 2.5F, 14, () -> Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))), 2);

    public ModItemTier(String name, IItemTier tier, float density)
    {
        this.name = name;
        this.level = tier.getLevel();
        this.uses = tier.getUses();
        this.speed = tier.getSpeed();
        this.attackDamageBonus = tier.getAttackDamageBonus();
        this.enchantmentValue = tier.getEnchantmentValue();
        this.repairIngredient = new LazyValue(tier::getRepairIngredient);
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
        this.repairIngredient = new LazyValue(p_i48458_8_);
        this.density = density;
    }

    public float getAttackDamageBonus()
    {
        return this.attackDamageBonus;
    }

    public int getEnchantmentValue()
    {
        return this.enchantmentValue;
    }

    public int getLevel()
    {
        return this.level;
    }

    public Ingredient getRepairIngredient()
    {
        return (Ingredient)this.repairIngredient.get();
    }

    public float getSpeed()
    {
        return this.speed;
    }

    public int getUses()
    {
        return this.uses;
    }

    public String getMaterialName()
    {
        return this.name;
    }

    public float getDensity()
    {
        return this.density;
    }
}
