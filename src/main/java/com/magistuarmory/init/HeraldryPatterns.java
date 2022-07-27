package com.magistuarmory.init;

import com.magistuarmory.KnightlyArmory;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.BannerPattern;

public class HeraldryPatterns 
{
	public static final BannerPattern APOSTOLIC_CROSS_PATTERN = addPattern("apostolic_cross");
	public static final BannerPattern BOWL_PATTERN = addPattern("bowl");
	public static final BannerPattern BULL_PATTERN = addPattern("bull");
	public static final BannerPattern CHESS_PATTERN = addPattern("chess");
	public static final BannerPattern CRUSADER_CROSS_PATTERN = addPattern("crusader_cross");
	public static final BannerPattern DRAGON_PATTERN = addPattern("dragon");
	public static final BannerPattern EAGLE_PATTERN = addPattern("eagle");
	public static final BannerPattern HORSE_PATTERN = addPattern("horse");
	public static final BannerPattern LILY_PATTERN = addPattern("lily");
	public static final BannerPattern LION1_PATTERN = addPattern("lion1");
	public static final BannerPattern LION2_PATTERN = addPattern("lion2");
	public static final BannerPattern ORTHODOX_CROSS_PATTERN = addPattern("orthodox_cross");
	public static final BannerPattern SNAKE_PATTERN = addPattern("snake");
	public static final BannerPattern SUN_PATTERN = addPattern("sun");
	public static final BannerPattern SWORDS_PATTERN = addPattern("swords");
	public static final BannerPattern TOWER_PATTERN = addPattern("tower");
	public static final BannerPattern TREE_PATTERN = addPattern("tree");
	public static final BannerPattern TWOHEADED_EAGLE_PATTERN = addPattern("two-headed_eagle");
	
	public static BannerPattern addPattern(String name)
	{
		return BannerPattern.create(name.toUpperCase(), name, KnightlyArmory.ID + "." + name, true);
	}
}
