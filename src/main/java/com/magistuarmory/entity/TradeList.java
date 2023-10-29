package com.magistuarmory.entity;

import java.util.Random;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

public class TradeList implements EntityVillager.ITradeList
{
	/**
     * The itemstack to buy with an emerald. The Item and damage value is used only, any tag data is not
     * retained.
     */
    public ItemStack buyingItemStack;
    /** The price info defining the amount of the buying item required with 1 emerald to match the selling item. */
    public EntityVillager.PriceInfo buyingPriceInfo;
	
	public TradeList(Item p_i45813_1_, EntityVillager.PriceInfo p_i45813_2_)
    {
        this.buyingItemStack = new ItemStack(p_i45813_1_);
        this.buyingPriceInfo = p_i45813_2_;
    }

	@Override
	public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) 
	{
		int price = this.buyingPriceInfo.getPrice(random);
        recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD, price), new ItemStack(this.buyingItemStack.getItem())));
	}
}
