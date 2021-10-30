package com.magistuarmory.init;

import com.magistuarmory.KnightlyArmory;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.BannerPattern;

public class HeraldyPatterns 
{
	public static final BannerPattern APOSTOLIC_CROSS_PATTERN = addPattern("apostolic_cross", new ItemStack(ModItems.APOSTOLIC_CROSS_PATTERN));
	public static final BannerPattern BOWL_PATTERN = addPattern("bowl", new ItemStack(ModItems.BOWL_PATTERN));
	public static final BannerPattern BULL_PATTERN = addPattern("bull", new ItemStack(ModItems.BULL_PATTERN));
	public static final BannerPattern CHESS_PATTERN = addPattern("chess", new ItemStack(ModItems.CHESS_PATTERN));
	public static final BannerPattern CRUSADER_CROSS_PATTERN = addPattern("crusader_cross", new ItemStack(ModItems.CRUSADER_CROSS_PATTERN));
	public static final BannerPattern DRAGON_PATTERN = addPattern("dragon", new ItemStack(ModItems.DRAGON_PATTERN));
	public static final BannerPattern EAGLE_PATTERN = addPattern("eagle", new ItemStack(ModItems.EAGLE_PATTERN));
	public static final BannerPattern HORSE_PATTERN = addPattern("horse", new ItemStack(ModItems.HORSE_PATTERN));
	public static final BannerPattern LILY_PATTERN = addPattern("lily", new ItemStack(ModItems.LILY_PATTERN));
	public static final BannerPattern LION1_PATTERN = addPattern("lion1", new ItemStack(ModItems.LION1_PATTERN));
	public static final BannerPattern LION2_PATTERN = addPattern("lion2", new ItemStack(ModItems.LION2_PATTERN));
	public static final BannerPattern ORTHODOX_CROSS_PATTERN = addPattern("orthodox_cross", new ItemStack(ModItems.ORTHODOX_CROSS_PATTERN));
	public static final BannerPattern SNAKE_PATTERN = addPattern("snake", new ItemStack(ModItems.SNAKE_PATTERN));
	public static final BannerPattern SUN_PATTERN = addPattern("sun", new ItemStack(ModItems.SUN_PATTERN));
	public static final BannerPattern SWORDS_PATTERN = addPattern("swords", new ItemStack(ModItems.SWORDS_PATTERN));
	public static final BannerPattern TOWER_PATTERN = addPattern("tower", new ItemStack(ModItems.TOWER_PATTERN));
	public static final BannerPattern TREE_PATTERN = addPattern("tree", new ItemStack(ModItems.TREE_PATTERN));
	public static final BannerPattern TWOHEADED_EAGLE_PATTERN = addPattern("two-headed_eagle", new ItemStack(ModItems.TWOHEADED_EAGLE_PATTERN));
	
	public static BannerPattern addPattern(String name, ItemStack craftingStack)
	{
		return BannerPattern.create(name.toUpperCase(), name, KnightlyArmory.ID + "." + name, true);
	}
}
