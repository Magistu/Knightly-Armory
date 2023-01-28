package com.magistuarmory.init;

import java.util.ArrayList;
import java.util.function.BiFunction;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.item.*;
import com.magistuarmory.item.ArmorMaterials;
import com.magistuarmory.item.crafting.RecipesHeraldry;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KnightlyArmory.ID);

	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, KnightlyArmory.ID);
	public static final RegistryObject<SimpleCraftingRecipeSerializer<RecipesHeraldry>> HERALDRY_RECIPES = RECIPE_SERIALIZERS.register("heraldry_recipes", () -> RecipesHeraldry.HERALDRY_RECIPES);

	//Armor
	public static CreativeModeTab GROUP_KA;

	public static final RegistryObject<KnightItem> ARMET = ITEMS.register("armet", () -> new KnightItem(ArmorMaterials.ARMET, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> KNIGHT_CHESTPLATE = ITEMS.register("knight_chestplate", () -> new MedievalArmorItem(ArmorMaterials.KNIGHT, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> KNIGHT_LEGGINGS = ITEMS.register("knight_leggings", () -> new MedievalArmorItem(ArmorMaterials.KNIGHT, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> KNIGHT_BOOTS = ITEMS.register("knight_boots", () -> new MedievalArmorItem(ArmorMaterials.KNIGHT, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<JoustingItem> STECHHELM = ITEMS.register("stechhelm", () -> new JoustingItem(ArmorMaterials.STECHHELM, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<JoustingItem> JOUSTING_CHESTPLATE = ITEMS.register("jousting_chestplate", () -> new JoustingItem(ArmorMaterials.JOUSTING, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<JoustingItem> JOUSTING_LEGGINGS = ITEMS.register("jousting_leggings", () -> new JoustingItem(ArmorMaterials.JOUSTING, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<JoustingItem> JOUSTING_BOOTS = ITEMS.register("jousting_boots", () -> new JoustingItem(ArmorMaterials.JOUSTING, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<GothicItem> SALLET = ITEMS.register("sallet", () -> new GothicItem(ArmorMaterials.SALLET, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> GOTHIC_CHESTPLATE = ITEMS.register("gothic_chestplate", () -> new MedievalArmorItem(ArmorMaterials.GOTHIC, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> GOTHIC_LEGGINGS = ITEMS.register("gothic_leggings", () -> new MedievalArmorItem(ArmorMaterials.GOTHIC, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> GOTHIC_BOOTS = ITEMS.register("gothic_boots", () -> new MedievalArmorItem(ArmorMaterials.GOTHIC, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<MaximilianItem> MAXIMILIAN_HELMET = ITEMS.register("maximilian_helmet", () -> new MaximilianItem(ArmorMaterials.MAXIMILIANHELMET, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> MAXIMILIAN_CHESTPLATE = ITEMS.register("maximilian_chestplate", () -> new MedievalArmorItem(ArmorMaterials.MAXIMILIAN, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> MAXIMILIAN_LEGGINGS = ITEMS.register("maximilian_leggings", () -> new MedievalArmorItem(ArmorMaterials.MAXIMILIAN, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> MAXIMILIAN_BOOTS = ITEMS.register("maximilian_boots", () -> new MedievalArmorItem(ArmorMaterials.MAXIMILIAN, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<MedievalArmorItem> CHAINMAIL_HELMET = ITEMS.register("chainmail_helmet", () -> new MedievalArmorItem(ArmorMaterials.CHAINMAIL, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> CHAINMAIL_CHESTPLATE = ITEMS.register("chainmail_chestplate", () -> new MedievalArmorItem(ArmorMaterials.CHAINMAIL, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> CHAINMAIL_LEGGINGS = ITEMS.register("chainmail_leggings", () -> new MedievalArmorItem(ArmorMaterials.CHAINMAIL, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> CHAINMAIL_BOOTS = ITEMS.register("chainmail_boots", () -> new MedievalArmorItem(ArmorMaterials.CHAINMAIL, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<PlatemailItem> KETTLEHAT = ITEMS.register("kettlehat", () -> new PlatemailItem(ArmorMaterials.KETTLEHAT, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> PLATEMAIL_CHESTPLATE = ITEMS.register("platemail_chestplate", () -> new MedievalArmorItem(ArmorMaterials.PLATEMAIL, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> PLATEMAIL_LEGGINGS = ITEMS.register("platemail_leggings", () -> new MedievalArmorItem(ArmorMaterials.PLATEMAIL, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> PLATEMAIL_BOOTS = ITEMS.register("platemail_boots", () -> new MedievalArmorItem(ArmorMaterials.PLATEMAIL, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<HalfarmorItem> BARBUTE = ITEMS.register("barbute", () -> new HalfarmorItem(ArmorMaterials.BARBUTE, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> HALFARMOR_CHESTPLATE = ITEMS.register("halfarmor_chestplate", () -> new MedievalArmorItem(ArmorMaterials.HALFARMOR, EquipmentSlot.CHEST, new Item.Properties()));

	public static final RegistryObject<MedievalArmorItem> GREATHELM = ITEMS.register("greathelm", () -> new MedievalArmorItem(ArmorMaterials.CRUSADER, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<DyeableMedievalArmorItem> CRUSADER_CHESTPLATE = ITEMS.register("crusader_chestplate", () -> new DyeableMedievalArmorItem(ArmorMaterials.CRUSADER, EquipmentSlot.CHEST, new Item.Properties(), -3227226));
	public static final RegistryObject<MedievalArmorItem> CRUSADER_LEGGINGS = ITEMS.register("crusader_leggings", () -> new MedievalArmorItem(ArmorMaterials.CRUSADER, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<DyeableMedievalArmorItem> CRUSADER_BOOTS = ITEMS.register("crusader_boots", () -> new DyeableMedievalArmorItem(ArmorMaterials.CRUSADER, EquipmentSlot.FEET, new Item.Properties(), -3227226));

	public static final RegistryObject<KnightItem> CEREMONIALARMET = ITEMS.register("ceremonialarmet", () -> new KnightItem(ArmorMaterials.CEREMONIALARMET, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> CEREMONIAL_CHESTPLATE = ITEMS.register("ceremonial_chestplate", () -> new MedievalArmorItem(ArmorMaterials.CEREMONIAL, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> CEREMONIAL_BOOTS = ITEMS.register("ceremonial_boots", () -> new MedievalArmorItem(ArmorMaterials.CEREMONIAL, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<DyeableMedievalArmorItem> COIF = ITEMS.register("coif", () -> new DyeableMedievalArmorItem(ArmorMaterials.GAMBESON, EquipmentSlot.HEAD, new Item.Properties(), -4280691));
	public static final RegistryObject<DyeableMedievalArmorItem> GAMBESON = ITEMS.register("gambeson_chestplate", () -> new DyeableMedievalArmorItem(ArmorMaterials.GAMBESON, EquipmentSlot.CHEST, new Item.Properties(), -4280691));
	public static final RegistryObject<DyeableMedievalArmorItem> PANTYHOSE = ITEMS.register("pantyhose", () -> new DyeableMedievalArmorItem(ArmorMaterials.GAMBESON, EquipmentSlot.LEGS, new Item.Properties(), -14531028));
	public static final RegistryObject<DyeableMedievalArmorItem> GAMBESONBOOTS = ITEMS.register("gambeson_boots", () -> new DyeableMedievalArmorItem(ArmorMaterials.GAMBESON, EquipmentSlot.FEET, new Item.Properties(), -4280691));

	public static final RegistryObject<DyeableMedievalArmorItem> BRIGANDINE = ITEMS.register("brigandine_chestplate", () -> new DyeableMedievalArmorItem(ArmorMaterials.BRIGANDINE, EquipmentSlot.CHEST, new Item.Properties(), 10511680));

	public static final RegistryObject<MedievalArmorItem> NORMAN_HELMET = ITEMS.register("norman_helmet", () -> new MedievalArmorItem(ArmorMaterials.NORMAN, EquipmentSlot.HEAD, new Item.Properties()));

	public static final RegistryObject<MedievalArmorItem> SHISHAK = ITEMS.register("shishak", () -> new MedievalArmorItem(ArmorMaterials.SHISHAK, EquipmentSlot.HEAD, new Item.Properties()));

	public static final RegistryObject<HalfarmorItem> RUSTEDBARBUTE = ITEMS.register("rustedbarbute", () -> new HalfarmorItem(ArmorMaterials.RUSTEDBARBUTE, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> RUSTEDHALFARMOR_CHESTPLATE = ITEMS.register("rustedhalfarmor_chestplate", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDHALFARMOR, EquipmentSlot.CHEST, new Item.Properties()));

	public static final RegistryObject<MedievalArmorItem> RUSTEDGREATHELM = ITEMS.register("rustedgreathelm", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCRUSADER, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> RUSTEDCRUSADER_CHESTPLATE = ITEMS.register("rustedcrusader_chestplate", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCRUSADER, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> RUSTEDCRUSADER_BOOTS = ITEMS.register("rustedcrusader_boots", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCRUSADER, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<MedievalArmorItem> RUSTEDNORMAN_HELMET = ITEMS.register("rustednorman_helmet", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDNORMAN, EquipmentSlot.HEAD, new Item.Properties()));

	public static final RegistryObject<MedievalArmorItem> RUSTEDCHAINMAIL_HELMET = ITEMS.register("rustedchainmail_helmet", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlot.HEAD, (new Item.Properties())));
	public static final RegistryObject<MedievalArmorItem> RUSTEDCHAINMAIL_CHESTPLATE = ITEMS.register("rustedchainmail_chestplate", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlot.CHEST, (new Item.Properties())));
	public static final RegistryObject<MedievalArmorItem> RUSTEDCHAINMAIL_LEGGINGS = ITEMS.register("rustedchainmail_leggings", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlot.LEGS, (new Item.Properties())));
	public static final RegistryObject<MedievalArmorItem> RUSTEDCHAINMAIL_BOOTS = ITEMS.register("rustedchainmail_boots", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlot.FEET, (new Item.Properties())));

	public static final RegistryObject<PlatemailItem> RUSTEDKETTLEHAT = ITEMS.register("rustedkettlehat", () -> new PlatemailItem(ArmorMaterials.RUSTEDKETTLEHAT, EquipmentSlot.HEAD, (new Item.Properties())));

	public static final RegistryObject<XIVCenturyKnightItem> BASCINET = ITEMS.register("bascinet", () -> new XIVCenturyKnightItem(ArmorMaterials.BASCINET, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> XIVCENTURYKNIGHT_CHESTPLATE = ITEMS.register("xivcenturyknight_chestplate", () -> new MedievalArmorItem(ArmorMaterials.XIVCENTURYKNIGHT, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> XIVCENTURYKNIGHT_LEGGINGS = ITEMS.register("xivcenturyknight_leggings", () -> new MedievalArmorItem(ArmorMaterials.XIVCENTURYKNIGHT, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> XIVCENTURYKNIGHT_BOOTS = ITEMS.register("xivcenturyknight_boots", () -> new MedievalArmorItem(ArmorMaterials.XIVCENTURYKNIGHT, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<WingedHussarItem> WINGEDHUSSAR_CHESTPLATE = ITEMS.register("wingedhussar_chestplate", () -> new WingedHussarItem(ArmorMaterials.WINGEDHUSSARCHESTPLATE, EquipmentSlot.CHEST, new Item.Properties()));

	public static final RegistryObject<MedievalArmorItem> BURGONET = ITEMS.register("cuirassier_helmet", () -> new MedievalArmorItem(ArmorMaterials.CUIRASSIER, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<DyeableMedievalArmorItem> CUIRASSIER_CHESTPLATE = ITEMS.register("cuirassier_chestplate", () -> new DyeableMedievalArmorItem(ArmorMaterials.CUIRASSIER, EquipmentSlot.CHEST, new Item.Properties(), -5465480));
	public static final RegistryObject<DyeableMedievalArmorItem> CUIRASSIER_LEGGINGS = ITEMS.register("cuirassier_leggings", () -> new DyeableMedievalArmorItem(ArmorMaterials.CUIRASSIER, EquipmentSlot.LEGS, new Item.Properties(), -5465480));
	public static final RegistryObject<MedievalArmorItem> CUIRASSIER_BOOTS = ITEMS.register("cuirassier_boots", () -> new MedievalArmorItem(ArmorMaterials.CUIRASSIER, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<KastenbrustItem> GRAND_BASCINET = ITEMS.register("grand_bascinet", () -> new KastenbrustItem(ArmorMaterials.GRAND_BASCINET, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> KASTENBRUST_CHESTPLATE = ITEMS.register("kastenbrust_chestplate", () -> new MedievalArmorItem(ArmorMaterials.KASTENBRUST, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> KASTENBRUST_LEGGINGS = ITEMS.register("kastenbrust_leggings", () -> new MedievalArmorItem(ArmorMaterials.KASTENBRUST, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> KASTENBRUST_BOOTS = ITEMS.register("kastenbrust_boots", () -> new MedievalArmorItem(ArmorMaterials.KASTENBRUST, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<MedievalArmorItem> FACE_HELMET = ITEMS.register("face_helmet", () -> new MedievalArmorItem(ArmorMaterials.LAMELLAR, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> LAMELLAR_CHESTPLATE = ITEMS.register("lamellar_chestplate", () -> new MedievalArmorItem(ArmorMaterials.LAMELLAR, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<MedievalArmorItem> LAMELLAR_BOOTS = ITEMS.register("lamellar_boots", () -> new MedievalArmorItem(ArmorMaterials.LAMELLAR, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<Item> BARDING = ITEMS.register("barding", () -> new HorseArmorItem(12, new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/barding.png"), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHAINMAIL_HORSE_ARMOR = ITEMS.register("chainmail_horse_armor", () -> new HorseArmorItem(6, new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/horse_armor_chainmail.png"), new Item.Properties().stacksTo(1)));

	//Weapons
	public static CreativeModeTab GROUP_KW;

	public static CreativeModeTab GROUP_KPW;

	public static final WeaponsSupply stylets = new WeaponsSupply(WeaponsWorkshop.STYLET);
	public static final WeaponsSupply shortswords = new WeaponsSupply(WeaponsWorkshop.SHORTSWORD);
	public static final WeaponsSupply katzbalgers = new WeaponsSupply(WeaponsWorkshop.KATZBALGER);
	public static final WeaponsSupply pikes = new WeaponsSupply(WeaponsWorkshop.PIKE);
	public static final WeaponsSupply ranseurs = new WeaponsSupply(WeaponsWorkshop.RANSEUR);
	public static final WeaponsSupply ahlspiesses = new WeaponsSupply(WeaponsWorkshop.AHLSPIESS);
	public static final WeaponsSupply chivalrylances = new WeaponsSupply(WeaponsWorkshop.CHIVALRYLANCE);
	public static final WeaponsSupply bastardswords = new WeaponsSupply(WeaponsWorkshop.BASTARDSWORD);
	public static final WeaponsSupply estocs = new WeaponsSupply(WeaponsWorkshop.ESTOC);
	public static final WeaponsSupply claymors = new WeaponsSupply(WeaponsWorkshop.CLAYMORE);
	public static final WeaponsSupply zweihanders = new WeaponsSupply(WeaponsWorkshop.ZWEIHANDER);
	public static final WeaponsSupply flamebladedswords = new WeaponsSupply(WeaponsWorkshop.FlAMEBLADEDSWORD);
	public static final WeaponsSupply lochaberaxes = new WeaponsSupply(WeaponsWorkshop.LOCHABERAXE);
	public static final WeaponsSupply concavehalberds = new WeaponsSupply(WeaponsWorkshop.CONCAVEHALBERD);
	public static final WeaponsSupply heavymaces = new WeaponsSupply(WeaponsWorkshop.HEAVYMACE);
	public static final WeaponsSupply heavywarhammers = new WeaponsSupply(WeaponsWorkshop.HEAVYWARHAMMER);
	public static final WeaponsSupply lucernhammers = new WeaponsSupply(WeaponsWorkshop.LUCERNHAMMER);
	public static final WeaponsSupply morgensterns = new WeaponsSupply(WeaponsWorkshop.MORGENSTERN);
	public static final WeaponsSupply chainmorgensterns = new WeaponsSupply(WeaponsWorkshop.CHAINMORGENSTERN);
	public static final WeaponsSupply guisarmes = new WeaponsSupply(WeaponsWorkshop.GUISARME);

	public static final RegistryObject<Item> BLACKSMITH_HAMMER = ITEMS.register("blacksmith_hammer", () -> new MedievalWeaponItem(new Item.Properties(), ModItemTier.STEEL, 5.0f, 1.0f, 4, 0.0f, 1.4f));
	public static final RegistryObject<Item> BARBED_CLUB = ITEMS.register("barbedclub", () -> new MedievalWeaponItem(new Item.Properties(), ModItemTier.IRON, 5.6f, 1.0f, 1.0f));
	public static final RegistryObject<Item> PITCHFORK = ITEMS.register("pitchfork", () -> new MedievalWeaponItem(new Item.Properties(), ModItemTier.IRON, 2.8f, 1.0f, 0, 1.0f, 1.2f));
	public static final RegistryObject<Item> NOBLE_SWORD = ITEMS.register("noble_sword", () -> new MedievalWeaponItem(new Item.Properties(), ModItemTier.IRON, 4.25f, 1.51f, 2.7f).setTwoHanded(1).setBlocking(6.0f));
	public static final RegistryObject<Item> RUSTEDBASTARDSWORD = ITEMS.register("rusted_bastardsword", () -> new MedievalWeaponItem(new Item.Properties(), ModItemTier.IRON, 2.0F, 1.51F, 2.7f).setTwoHanded(1).setBlocking(6.0f));
	public static final RegistryObject<Item> RUSTEDHEAVYMACE = ITEMS.register("rusted_heavymace", () -> new MedievalWeaponItem(new Item.Properties(), ModItemTier.IRON, 2.0F, 1.51F, 2.6f));
	public static final RegistryObject<Item> CLUB = ITEMS.register("club", () -> new MedievalWeaponItem(new Item.Properties(), ModItemTier.WOOD, 11.3F, 0.8f, 5.0f).setTwoHanded(1));
	public static final RegistryObject<Item> MESSER_SWORD = ITEMS.register("messer_sword", () -> new MedievalWeaponItem(new Item.Properties(), ModItemTier.IRON, 3.8f, 1.56f, 1.2f).setBlocking(5.0f));

	public static final RegistryObject<Item> LONGBOW = ITEMS.register("longbow", () -> new MedievalBowItem(new Item.Properties().stacksTo(1).durability(420), 4.2f, 26.0f));
	public static final RegistryObject<Item> HEAVY_CROSSBOW = ITEMS.register("heavy_crossbow", () -> new MedievalCrossbowItem(new Item.Properties().stacksTo(1).durability(500), 4.3f, 50));

	//Shields
	public static CreativeModeTab GROUP_KS;

	public static final ShieldsSupply heatershields = new ShieldsSupply(ShieldsWorkshop.HEATERSHIELD, "heatershield");
	public static final ShieldsSupply targets = new ShieldsSupply(ShieldsWorkshop.TARGET, "target");
	public static final ShieldsSupply bucklers = new ShieldsSupply(ShieldsWorkshop.BUCKLER, "buckler");
	public static final ShieldsSupply rondaches = new ShieldsSupply(ShieldsWorkshop.RONDACHE, "rondache");
	public static final ShieldsSupply tartsches = new ShieldsSupply(ShieldsWorkshop.TARTSCHE, "tartsche");
	public static final ShieldsSupply ellipticalshields = new ShieldsSupply(ShieldsWorkshop.ELLIPTICALSHIELD, "ellipticalshield");
	public static final ShieldsSupply roundshields = new ShieldsSupply(ShieldsWorkshop.ROUNDSHIELD, "roundshield");
	public static final ShieldsSupply paveses = new ShieldsSupply(ShieldsWorkshop.PAVESE, "pavese");
	public static final ShieldsSupply kiteshields = new ShieldsSupply(ShieldsWorkshop.KITESHIELD, "kiteshield");

	public static final RegistryObject<MedievalShieldItem> CORRUPTEDROUNDSHIELD = ITEMS.register("corruptedroundshield", () -> new MedievalShieldItem("corruptedroundshield", "corruptedroundshield", new Item.Properties(), ModItemTier.WOOD, 100, 2, 4, false, true));

	//Patterns
	public static final RegistryObject<Item> APOSTOLIC_CROSS_PATTERN = ITEMS.register("apostolic_cross_pattern", () -> new BannerPatternItem(ModBannerPatternTags.APOSTOLIC_CROSS_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> BOWL_PATTERN = ITEMS.register("bowl_pattern", () -> new BannerPatternItem(ModBannerPatternTags.BOWL_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> BULL_PATTERN = ITEMS.register("bull_pattern", () -> new BannerPatternItem(ModBannerPatternTags.BULL_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> CHESS_PATTERN = ITEMS.register("chess_pattern", () -> new BannerPatternItem(ModBannerPatternTags.CHESS_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> CRUSADER_CROSS_PATTERN = ITEMS.register("crusader_cross_pattern", () -> new BannerPatternItem(ModBannerPatternTags.CRUSADER_CROSS_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> DRAGON_PATTERN = ITEMS.register("dragon_pattern", () -> new BannerPatternItem(ModBannerPatternTags.DRAGON_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> EAGLE_PATTERN = ITEMS.register("eagle_pattern", () -> new BannerPatternItem(ModBannerPatternTags.EAGLE_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> HORSE_PATTERN = ITEMS.register("horse_pattern", () -> new BannerPatternItem(ModBannerPatternTags.HORSE_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> LILY_PATTERN = ITEMS.register("lily_pattern", () -> new BannerPatternItem(ModBannerPatternTags.LILY_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> LION1_PATTERN = ITEMS.register("lion1_pattern", () -> new BannerPatternItem(ModBannerPatternTags.LION1_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> LION2_PATTERN = ITEMS.register("lion2_pattern", () -> new BannerPatternItem(ModBannerPatternTags.LION2_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> ORTHODOX_CROSS_PATTERN = ITEMS.register("orthodox_cross_pattern", () -> new BannerPatternItem(ModBannerPatternTags.ORTHODOX_CROSS_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> SNAKE_PATTERN = ITEMS.register("snake_pattern", () -> new BannerPatternItem(ModBannerPatternTags.SNAKE_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> SUN_PATTERN = ITEMS.register("sun_pattern", () -> new BannerPatternItem(ModBannerPatternTags.SUN_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> SWORDS_PATTERN = ITEMS.register("swords_pattern", () -> new BannerPatternItem(ModBannerPatternTags.SWORDS_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> TOWER_PATTERN = ITEMS.register("tower_pattern", () -> new BannerPatternItem(ModBannerPatternTags.TOWER_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> TREE_PATTERN = ITEMS.register("tree_pattern", () -> new BannerPatternItem(ModBannerPatternTags.TREE_PATTERN, new Item.Properties()));
	public static final RegistryObject<Item> TWOHEADED_EAGLE_PATTERN = ITEMS.register("two-headed_eagle_pattern", () -> new BannerPatternItem(ModBannerPatternTags.TWOHEADED_EAGLE_PATTERN, new Item.Properties()));

	//Materials
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> STEEL_RING = ITEMS.register("steel_ring", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> STEEL_CHAINMAIL = ITEMS.register("steel_chainmail", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LEATHER_STRIP = ITEMS.register("leather_strip", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> HILT = ITEMS.register("hilt", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> POLE = ITEMS.register("pole", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> STEEL_CHAIN = ITEMS.register("steel_chain", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> WOOLEN_FABRIC = ITEMS.register("woolen_fabric", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SMALL_STEEL_PLATE = ITEMS.register("small_steel_plate", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LAMELLAR_ROWS = ITEMS.register("lamellar_rows", () -> new Item(new Item.Properties()));

	public static class ItemsSupply<T extends Item> {
		public RegistryObject<T> wood;
		public RegistryObject<T> stone;
		public RegistryObject<T> iron;
		public RegistryObject<T> gold;
		public RegistryObject<T> diamond;

		public RegistryObject<T> copper;
		public RegistryObject<T> steel;
		public RegistryObject<T> silver;
		public RegistryObject<T> netherite;
		public RegistryObject<T> tin;
		public RegistryObject<T> bronze;

		public ItemsSupply(BiFunction<ModItemTier, Item.Properties, RegistryObject<T>> workshop, Item.Properties prop) {
			this.wood = workshop.apply(ModItemTier.WOOD, prop);
			this.stone = workshop.apply(ModItemTier.STONE, prop);
			this.iron = workshop.apply(ModItemTier.IRON, prop);
			this.gold = workshop.apply(ModItemTier.GOLD, prop);
			this.diamond = workshop.apply(ModItemTier.DIAMOND, prop);
			this.netherite = workshop.apply(ModItemTier.NETHERITE, prop.fireResistant());

			this.copper = workshop.apply(ModItemTier.COPPER, prop);
			this.steel = workshop.apply(ModItemTier.STEEL, prop);
			this.silver = workshop.apply(ModItemTier.SILVER, prop);
			this.tin = workshop.apply(ModItemTier.TIN, prop);
			this.bronze = workshop.apply(ModItemTier.BRONZE, prop);
		}

		public ArrayList<RegistryObject<T>> get() {
			ArrayList<RegistryObject<T>> itemRegistries = new ArrayList<>();
			itemRegistries.add(this.wood);
			itemRegistries.add(this.stone);
			itemRegistries.add(this.iron);
			itemRegistries.add(this.gold);
			itemRegistries.add(this.diamond);
			itemRegistries.add(this.copper);
			itemRegistries.add(this.steel);
			itemRegistries.add(this.silver);
			itemRegistries.add(this.netherite);
			itemRegistries.add(this.tin);
			itemRegistries.add(this.bronze);
			return itemRegistries;
		}
	}

	public static class WeaponsSupply extends ItemsSupply<SwordItem> {
		public WeaponsSupply(BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> workshop) {
			super(workshop, new Item.Properties());
		}
	}


	public static class ShieldsSupply extends ItemsSupply<ShieldItem> {
		public String shieldName;

		public String woodTexture;
		public String stoneTexture;
		public String ironTexture;
		public String goldTexture;
		public String diamondTexture;
		public String netheriteTexture;

		public String copperTexture;
		public String steelTexture;
		public String silverTexture;
		public String tinTexture;
		public String bronzeTexture;

		public ShieldsSupply(BiFunction<ModItemTier, Properties, RegistryObject<ShieldItem>> workshop, String shieldName) {
			super(workshop, new Item.Properties());

			this.shieldName = shieldName;

			this.woodTexture = "entity/" + ModItemTier.WOOD.getMaterialName() + "_" + shieldName;
			this.stoneTexture = "entity/" + ModItemTier.STONE.getMaterialName() + "_" + shieldName;
			this.ironTexture = "entity/" + ModItemTier.IRON.getMaterialName() + "_" + shieldName;
			this.goldTexture = "entity/" + ModItemTier.GOLD.getMaterialName() + "_" + shieldName;
			this.diamondTexture = "entity/" + ModItemTier.DIAMOND.getMaterialName() + "_" + shieldName;
			this.copperTexture = "entity/" + ModItemTier.COPPER.getMaterialName() + "_" + shieldName;
			this.steelTexture = "entity/" + ModItemTier.STEEL.getMaterialName() + "_" + shieldName;
			this.silverTexture = "entity/" + ModItemTier.SILVER.getMaterialName() + "_" + shieldName;
			this.netheriteTexture = "entity/" + ModItemTier.NETHERITE.getMaterialName() + "_" + shieldName;
			this.tinTexture = "entity/" + ModItemTier.TIN.getMaterialName() + "_" + shieldName;
			this.bronzeTexture = "entity/" + ModItemTier.BRONZE.getMaterialName() + "_" + shieldName;
		}
	}

	public static final ShieldsSupply[] shieldsSupply = new ShieldsSupply[]{heatershields, targets, bucklers, rondaches, tartsches, ellipticalshields, roundshields, paveses, kiteshields};
	public static final WeaponsSupply[] weaponsWithModelPropertySupply = new WeaponsSupply[]{ranseurs, ahlspiesses, chivalrylances, bastardswords, estocs, claymors, zweihanders, flamebladedswords, lochaberaxes, concavehalberds, guisarmes};
	public static final WeaponsSupply[] weaponsSupply = new WeaponsSupply[]{stylets, shortswords, katzbalgers, pikes, ranseurs, ahlspiesses, chivalrylances, bastardswords, estocs, claymors, zweihanders, flamebladedswords, lochaberaxes, concavehalberds, heavymaces, heavywarhammers, lucernhammers, morgensterns, chainmorgensterns, guisarmes};

	public static ArrayList<RegistryObject<? extends Item>> dyeableItems;

	static {
		dyeableItems = new ArrayList<>();
		dyeableItems.add(ARMET);
		dyeableItems.add(CRUSADER_CHESTPLATE);
		dyeableItems.add(CRUSADER_BOOTS);
		dyeableItems.add(CEREMONIALARMET);
		dyeableItems.add(COIF);
		dyeableItems.add(GAMBESON);
		dyeableItems.add(PANTYHOSE);
		dyeableItems.add(GAMBESONBOOTS);
		dyeableItems.add(BRIGANDINE);
		dyeableItems.add(CUIRASSIER_CHESTPLATE);
		dyeableItems.add(CUIRASSIER_LEGGINGS);
		dyeableItems.addAll(chivalrylances.get());
	}

	public static ArrayList<RegistryObject<? extends Item>> armorItems;

	static {
		armorItems = new ArrayList<>();
		armorItems.add(ARMET);
		armorItems.add(KNIGHT_CHESTPLATE);
		armorItems.add(KNIGHT_LEGGINGS);
		armorItems.add(KNIGHT_BOOTS);
		armorItems.add(STECHHELM);
		armorItems.add(JOUSTING_CHESTPLATE);
		armorItems.add(JOUSTING_LEGGINGS);
		armorItems.add(JOUSTING_BOOTS);
		armorItems.add(SALLET);
		armorItems.add(GOTHIC_CHESTPLATE);
		armorItems.add(GOTHIC_LEGGINGS);
		armorItems.add(GOTHIC_BOOTS);
		armorItems.add(MAXIMILIAN_HELMET);
		armorItems.add(MAXIMILIAN_CHESTPLATE);
		armorItems.add(MAXIMILIAN_LEGGINGS);
		armorItems.add(MAXIMILIAN_BOOTS);
		armorItems.add(CHAINMAIL_HELMET);
		armorItems.add(CHAINMAIL_CHESTPLATE);
		armorItems.add(CHAINMAIL_LEGGINGS);
		armorItems.add(CHAINMAIL_BOOTS);
		armorItems.add(KETTLEHAT);
		armorItems.add(PLATEMAIL_CHESTPLATE);
		armorItems.add(PLATEMAIL_LEGGINGS);
		armorItems.add(PLATEMAIL_BOOTS);
		armorItems.add(BARBUTE);
		armorItems.add(HALFARMOR_CHESTPLATE);
		armorItems.add(GREATHELM);
		armorItems.add(CRUSADER_CHESTPLATE);
		armorItems.add(CRUSADER_LEGGINGS);
		armorItems.add(CRUSADER_BOOTS);
		armorItems.add(CEREMONIALARMET);
		armorItems.add(CEREMONIAL_CHESTPLATE);
		armorItems.add(CEREMONIAL_BOOTS);
		armorItems.add(COIF);
		armorItems.add(GAMBESON);
		armorItems.add(PANTYHOSE);
		armorItems.add(GAMBESONBOOTS);
		armorItems.add(BRIGANDINE);
		armorItems.add(NORMAN_HELMET);
		armorItems.add(SHISHAK);
		armorItems.add(RUSTEDBARBUTE);
		armorItems.add(RUSTEDHALFARMOR_CHESTPLATE);
		armorItems.add(RUSTEDGREATHELM);
		armorItems.add(RUSTEDCRUSADER_CHESTPLATE);
		armorItems.add(RUSTEDCRUSADER_BOOTS);
		armorItems.add(RUSTEDNORMAN_HELMET);
		armorItems.add(RUSTEDCHAINMAIL_HELMET);
		armorItems.add(RUSTEDCHAINMAIL_CHESTPLATE);
		armorItems.add(RUSTEDCHAINMAIL_LEGGINGS);
		armorItems.add(RUSTEDCHAINMAIL_BOOTS);
		armorItems.add(RUSTEDKETTLEHAT);
		armorItems.add(BASCINET);
		armorItems.add(XIVCENTURYKNIGHT_CHESTPLATE);
		armorItems.add(XIVCENTURYKNIGHT_LEGGINGS);
		armorItems.add(XIVCENTURYKNIGHT_BOOTS);
		armorItems.add(WINGEDHUSSAR_CHESTPLATE);
		armorItems.add(BURGONET);
		armorItems.add(CUIRASSIER_CHESTPLATE);
		armorItems.add(CUIRASSIER_LEGGINGS);
		armorItems.add(CUIRASSIER_BOOTS);
		armorItems.add(GRAND_BASCINET);
		armorItems.add(KASTENBRUST_CHESTPLATE);
		armorItems.add(KASTENBRUST_LEGGINGS);
		armorItems.add(KASTENBRUST_BOOTS);
		armorItems.add(FACE_HELMET);
		armorItems.add(LAMELLAR_CHESTPLATE);
		armorItems.add(LAMELLAR_BOOTS);
		armorItems.add(BARDING);
		armorItems.add(CHAINMAIL_HORSE_ARMOR);
	}

	public static ArrayList<RegistryObject<? extends Item>> particularWeaponItems;

	static {
		particularWeaponItems = new ArrayList<>();
		particularWeaponItems.add(BLACKSMITH_HAMMER);
		particularWeaponItems.add(BARBED_CLUB);
		particularWeaponItems.add(PITCHFORK);
		particularWeaponItems.add(NOBLE_SWORD);
		particularWeaponItems.add(RUSTEDBASTARDSWORD);
		particularWeaponItems.add(RUSTEDHEAVYMACE);
		particularWeaponItems.add(CLUB);
		particularWeaponItems.add(MESSER_SWORD);
	}

	public static ArrayList<RegistryObject<? extends Item>> materialItems;

	static {
		materialItems = new ArrayList<>();
		materialItems.add(STEEL_INGOT);
		materialItems.add(STEEL_NUGGET);
		materialItems.add(STEEL_RING);
		materialItems.add(STEEL_CHAINMAIL);
		materialItems.add(STEEL_PLATE);
		materialItems.add(LEATHER_STRIP);
		materialItems.add(HILT);
		materialItems.add(POLE);
		materialItems.add(STEEL_CHAIN);
		materialItems.add(WOOLEN_FABRIC);
		materialItems.add(SMALL_STEEL_PLATE);
		materialItems.add(LAMELLAR_ROWS);
	}

	static class ShieldsWorkshop {
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> HEATERSHIELD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_heatershield", () -> (new MedievalShieldItem(material.getMaterialName() + "_heatershield", "heatershield", prop, material, getDurability(material, 350, 0.8f), 4, 10, true, true))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> TARGET = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_target", () -> (new MedievalShieldItem(material.getMaterialName() + "_target", "target", prop, material, getDurability(material, 350, 0.8f), 1, 6, false, true)).setRepairItem(material::getRepairIngredient)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> BUCKLER = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_buckler", () -> (new MedievalShieldItem(material.getMaterialName() + "_buckler", "buckler", prop, material, getDurability(material, 350, 0.8f), 1, 6, false, true)).setRepairItem(material::getRepairIngredient)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> RONDACHE = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_rondache", () -> (new MedievalShieldItem(material.getMaterialName() + "_rondache", "rondache", prop, material, getDurability(material, 420, 1.2f), 6, 13, false, true)).setRepairItem(material::getRepairIngredient)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> TARTSCHE = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_tartsche", () -> (new MedievalShieldItem(material.getMaterialName() + "_tartsche", "tartsche", prop, material, getDurability(material, 350, 0.8f), 4, 10, true, true))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> ELLIPTICALSHIELD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_ellipticalshield", () -> (new MedievalShieldItem(material.getMaterialName() + "_ellipticalshield", "ellipticalshield", prop, material, getDurability(material, 370, 0.8f), 5, 10, true, true))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> ROUNDSHIELD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_roundshield", () -> (new MedievalShieldItem(material.getMaterialName() + "_roundshield", "roundshield", prop, material, getDurability(material, 350, 0.8f), 3, 7, true, true))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> PAVESE = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_pavese", () -> (new MedievalShieldItem(material.getMaterialName() + "_pavese", "pavese", prop, material, getDurability(material, 450, 0.7f), 10, 17, true, true))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> KITESHIELD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_kiteshield", () -> (new MedievalShieldItem(material.getMaterialName() + "_kiteshield", "kiteshield", prop, material, getDurability(material, 370, 0.8f), 5, 10, true, true))));
	
		private static int getDurability(Tier material, int baseDuration, float materialFactor) {
			return (int) (baseDuration + materialFactor * material.getUses());
		}
	}
	
	static class WeaponsWorkshop {
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> STYLET = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_stylet", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 2.0f, getAttackSpeed(1.6f, material, 0.0f), 15, 0.0f, 0.6f))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> SHORTSWORD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_shortsword", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 2.5f, getAttackSpeed(1.7f, material, 0.0f), 0.9f))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> KATZBALGER = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_katzbalger", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 3.0f, getAttackSpeed(1.65f, material, 0.0f), 1.1f))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> PIKE = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_pike", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 3.0f, getAttackSpeed(1.07f, material, 0.0f), 0, 1.2f, 3.0f)).setTwoHanded(2)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> RANSEUR = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_ranseur", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 3.1f, getAttackSpeed(1.07f, material, 0.0f), 0, 1.0f, 2.5f)).setTwoHanded(1).setBlocking(3.0f)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> AHLSPIESS = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_ahlspiess", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 4.0f, getAttackSpeed(1.28f, material, 0.02f), 12, 0.5f, 4.0f)).setTwoHanded(2).setBlocking(3.0f)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> CHIVALRYLANCE = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_chivalrylance", () -> (new LanceItem(getDurability(prop, material, 1.0f), material, 2.5f, getAttackSpeed(0.84f, material, 0.0f), 10, 1.0f, 4.5f))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> BASTARDSWORD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_bastardsword", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 4.25f, getAttackSpeed(1.4f, material, 0.02f), 1.8f)).setTwoHanded(1).setBlocking(5.0f)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> ESTOC = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_estoc", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 4.1f, getAttackSpeed(1.4f, material, 0.02f), 3, 0.2f, 2.0f)).setTwoHanded(1).setBlocking(5.0f)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> CLAYMORE = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_claymore", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 5.4f, getAttackSpeed(1.22f, material, 0.04f), 2.6f)).setTwoHanded(2).setBlocking(6.0f)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> ZWEIHANDER = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_zweihander", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 6.5f, getAttackSpeed(1.12f, material, 0.05f), 4, 0.4f, 4.0f)).setTwoHanded(2).setBlocking(6.0f)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> FlAMEBLADEDSWORD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_flamebladedsword", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 6.4f, getAttackSpeed(1.12f, material, 0.05f), 4, 0.4f, 4.0f)).setTwoHanded(2).setFlamebladed().setBlocking(6.0f)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> LOCHABERAXE = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_lochaberaxe", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 7.0f, getAttackSpeed(1.0f, material, 0.05f), 0, 0.3f, 3.5f)).setTwoHanded(1).setBlocking(3.0f)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> CONCAVEHALBERD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_concavehalberd", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 8.0f, getAttackSpeed(0.9f, material, 0.05f), 2, 0.5f, 4.1f)).setTwoHanded(2).setBlocking(3.0f).setHalberd()));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> HEAVYMACE = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_heavymace", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 4.5f, getAttackSpeed(1.15f, material, 0.05f), 11, 0.0f, 2.6f))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> HEAVYWARHAMMER = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_heavywarhammer", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 5.2f, getAttackSpeed(1.05f, material, 0.05f), 15, 0.0f, 2.5f))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> LUCERNHAMMER = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_lucernhammer", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 4.8f, getAttackSpeed(1.1f, material, 0.05f), 20, 0.0f, 2.5f)).setTwoHanded(1)));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> MORGENSTERN = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_morgenstern", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 5.0f, getAttackSpeed(1.25f, material, 0.05f), 2.5f))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> CHAINMORGENSTERN = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_chainmorgenstern", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 6.2f, getAttackSpeed(1.1f, material, 0.06f), 3.0f))));
		public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> GUISARME = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_guisarme", () -> (new MedievalWeaponItem(getDurability(prop, material, 1.0f), material, 3.15f, getAttackSpeed(1.02f, material, 0.0f), 0, 0.8f, 2.5f)).setTwoHanded(1).setBlocking(3.0f)));
	
	
		public static Item.Properties getDurability(Item.Properties prop, ModItemTier material, float f) {
			return prop.durability((int) (material.getUses() * f));
		}
	
		public static float getAttackSpeed(float attackSpeed, ModItemTier material, float f) {
			return -material.getDensity() * f + attackSpeed;
		}
	}
}