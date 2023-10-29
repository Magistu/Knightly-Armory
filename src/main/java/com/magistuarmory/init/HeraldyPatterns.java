package com.magistuarmory.init;

import com.magistuarmory.KnightlyArmory;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.BannerPattern;
import net.minecraftforge.common.util.EnumHelper;

public class HeraldyPatterns 
{
	
	public static void initCraftingBanners() 
	{
		addCraftingPattern("apostolic_cross", new ItemStack(ModItems.APOSTOLIC_CROSS_PATTERN));
		addCraftingPattern("bowl", new ItemStack(ModItems.BOWL_PATTERN));
		addCraftingPattern("bull", new ItemStack(ModItems.BULL_PATTERN));
		addCraftingPattern("chess", new ItemStack(ModItems.CHESS_PATTERN));
		addCraftingPattern("crusader_cross", new ItemStack(ModItems.CRUSADER_CROSS_PATTERN));
		addCraftingPattern("dragon", new ItemStack(ModItems.DRAGON_PATTERN));
		addCraftingPattern("eagle", new ItemStack(ModItems.EAGLE_PATTERN));
		addCraftingPattern("horse", new ItemStack(ModItems.HORSE_PATTERN));
		addCraftingPattern("lily", new ItemStack(ModItems.LILY_PATTERN));
		addCraftingPattern("lion1", new ItemStack(ModItems.LION1_PATTERN));
		addCraftingPattern("lion2", new ItemStack(ModItems.LION2_PATTERN));
		addCraftingPattern("orthodox_cross", new ItemStack(ModItems.ORTHODOX_CROSS_PATTERN));
		addCraftingPattern("snake", new ItemStack(ModItems.SNAKE_PATTERN));
		addCraftingPattern("sun", new ItemStack(ModItems.SUN_PATTERN));
		addCraftingPattern("swords", new ItemStack(ModItems.SWORDS_PATTERN));
		addCraftingPattern("tower", new ItemStack(ModItems.TOWER_PATTERN));
		addCraftingPattern("tree", new ItemStack(ModItems.TREE_PATTERN));
		addCraftingPattern("two-headed_eagle", new ItemStack(ModItems.TWOHEADED_EAGLE_PATTERN));
	}
	
	public static BannerPattern addCraftingPattern(String name, ItemStack craftingStack) 
	{
		Class<?>[] paramTypes = new Class[] { String.class, String.class, ItemStack.class };
		Object[] paramValues = { name, KnightlyArmory.ID + "." + name, craftingStack };
		return (BannerPattern)EnumHelper.addEnum(BannerPattern.class, name.toUpperCase(), paramTypes, paramValues);
	}
}
