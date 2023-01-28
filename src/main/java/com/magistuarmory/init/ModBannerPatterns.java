package com.magistuarmory.init;

import com.magistuarmory.KnightlyArmory;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.registries.*;

public class ModBannerPatterns {
	public static final DeferredRegister<BannerPattern> PATTERNS = DeferredRegister.create(Registries.BANNER_PATTERN, KnightlyArmory.ID);

	public static final RegistryObject<BannerPattern> APOSTOLIC_CROSS_PATTERN = PATTERNS.register("apostolic_cross", () -> create("apostolic_cross"));
	public static final RegistryObject<BannerPattern> BOWL_PATTERN = PATTERNS.register("bowl", () -> create("bowl"));
	public static final RegistryObject<BannerPattern> BULL_PATTERN = PATTERNS.register("bull", () -> create("bull"));
	public static final RegistryObject<BannerPattern> CHESS_PATTERN = PATTERNS.register("chess", () -> create("chess"));
	public static final RegistryObject<BannerPattern> CRUSADER_CROSS_PATTERN = PATTERNS.register("crusader_cross", () -> create("crusader_cross"));
	public static final RegistryObject<BannerPattern> DRAGON_PATTERN = PATTERNS.register("dragon", () -> create("dragon"));
	public static final RegistryObject<BannerPattern> EAGLE_PATTERN = PATTERNS.register("eagle", () -> create("eagle"));
	public static final RegistryObject<BannerPattern> HORSE_PATTERN = PATTERNS.register("horse", () -> create("horse"));
	public static final RegistryObject<BannerPattern> LILY_PATTERN = PATTERNS.register("lily", () -> create("lily"));
	public static final RegistryObject<BannerPattern> LION1_PATTERN = PATTERNS.register("lion1", () -> create("lion1"));
	public static final RegistryObject<BannerPattern> LION2_PATTERN = PATTERNS.register("lion2", () -> create("lion2"));
	public static final RegistryObject<BannerPattern> ORTHODOX_CROSS_PATTERN = PATTERNS.register("orthodox_cross", () -> create("orthodox_cross"));
	public static final RegistryObject<BannerPattern> SNAKE_PATTERN = PATTERNS.register("snake", () -> create("snake"));
	public static final RegistryObject<BannerPattern> SUN_PATTERN = PATTERNS.register("sun", () -> create("sun"));
	public static final RegistryObject<BannerPattern> SWORDS_PATTERN = PATTERNS.register("swords", () -> create("swords"));
	public static final RegistryObject<BannerPattern> TOWER_PATTERN = PATTERNS.register("tower", () -> create("tower"));
	public static final RegistryObject<BannerPattern> TREE_PATTERN = PATTERNS.register("tree", () -> create("tree"));
	public static final RegistryObject<BannerPattern> TWOHEADED_EAGLE_PATTERN = PATTERNS.register("two-headed_eagle", () -> create("two-headed_eagle"));

	private static BannerPattern create(String name) 
	{
		return new BannerPattern(name);
	}
}
