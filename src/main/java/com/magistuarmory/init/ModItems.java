package com.magistuarmory.init;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;
import com.magistuarmory.item.*;
import com.magistuarmory.item.crafting.RecipesHeraldry;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

@EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems
{

    public static final ItemGroup GROUP_KA = new ItemGroup(KnightlyArmory.ID + ".armor")
    {
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(ModItems.ARMET);
        }
    };

    public static final KnightItem ARMET = new KnightItem("armet", ArmorMaterials.ARMET, EquipmentSlotType.HEAD, (new Item.Properties()).tab(GROUP_KA));
    public static final MedievalArmorItem KNIGHT_CHESTPLATE = new MedievalArmorItem("knight_chestplate", ArmorMaterials.KNIGHT, EquipmentSlotType.CHEST, (new Item.Properties()).tab(GROUP_KA));
    public static final MedievalArmorItem KNIGHT_LEGGINGS = new MedievalArmorItem("knight_leggings", ArmorMaterials.KNIGHT, EquipmentSlotType.LEGS, (new Item.Properties()).tab(GROUP_KA));
    public static final MedievalArmorItem KNIGHT_BOOTS = new MedievalArmorItem("knight_boots", ArmorMaterials.KNIGHT, EquipmentSlotType.FEET, (new Item.Properties()).tab(GROUP_KA));

    public static final JoustingItem STECHHELM = new JoustingItem("stechhelm", ArmorMaterials.STECHHELM, EquipmentSlotType.HEAD, (new Item.Properties()).tab(GROUP_KA));
    public static final JoustingItem JOUSTING_CHESTPLATE = new JoustingItem("jousting_chestplate", ArmorMaterials.JOUSTING, EquipmentSlotType.CHEST, (new Item.Properties()).tab(GROUP_KA));
    public static final JoustingItem JOUSTING_LEGGINGS = new JoustingItem("jousting_leggings", ArmorMaterials.JOUSTING, EquipmentSlotType.LEGS, (new Item.Properties()).tab(GROUP_KA));
    public static final JoustingItem JOUSTING_BOOTS = new JoustingItem("jousting_boots", ArmorMaterials.JOUSTING, EquipmentSlotType.FEET, (new Item.Properties()).tab(GROUP_KA));

    public static final GothicItem SALLET = new GothicItem("sallet", ArmorMaterials.SALLET, EquipmentSlotType.HEAD, (new Item.Properties()).tab(GROUP_KA));
    public static final GothicItem GOTHIC_CHESTPLATE = new GothicItem("gothic_chestplate", ArmorMaterials.GOTHIC, EquipmentSlotType.CHEST, (new Item.Properties()).tab(GROUP_KA));
    public static final GothicItem GOTHIC_LEGGINGS = new GothicItem("gothic_leggings", ArmorMaterials.GOTHIC, EquipmentSlotType.LEGS, (new Item.Properties()).tab(GROUP_KA));
    public static final GothicItem GOTHIC_BOOTS = new GothicItem("gothic_boots", ArmorMaterials.GOTHIC, EquipmentSlotType.FEET, (new Item.Properties()).tab(GROUP_KA));

    public static final MaximilianItem MAXIMILIAN_HELMET = new MaximilianItem("maximilian_helmet", ArmorMaterials.MAXIMILIANHELMET, EquipmentSlotType.HEAD, (new Item.Properties()).tab(GROUP_KA));
    public static final MaximilianItem MAXIMILIAN_CHESTPLATE = new MaximilianItem("maximilian_chestplate", ArmorMaterials.MAXIMILIAN, EquipmentSlotType.CHEST, (new Item.Properties()).tab(GROUP_KA));
    public static final MaximilianItem MAXIMILIAN_LEGGINGS = new MaximilianItem("maximilian_leggings", ArmorMaterials.MAXIMILIAN, EquipmentSlotType.LEGS, (new Item.Properties()).tab(GROUP_KA));
    public static final MaximilianItem MAXIMILIAN_BOOTS = new MaximilianItem("maximilian_boots", ArmorMaterials.MAXIMILIAN, EquipmentSlotType.FEET, (new Item.Properties()).tab(GROUP_KA));

    public static final MedievalArmorItem CHAINMAIL_HELMET = new MedievalArmorItem("chainmail_helmet", ArmorMaterials.CHAINMAIL, EquipmentSlotType.HEAD, (new Item.Properties()).tab(GROUP_KA));
    public static final MedievalArmorItem CHAINMAIL_CHESTPLATE = new MedievalArmorItem("chainmail_chestplate", ArmorMaterials.CHAINMAIL, EquipmentSlotType.CHEST, (new Item.Properties()).tab(GROUP_KA));
    public static final MedievalArmorItem CHAINMAIL_LEGGINGS = new MedievalArmorItem("chainmail_leggings", ArmorMaterials.CHAINMAIL, EquipmentSlotType.LEGS, (new Item.Properties()).tab(GROUP_KA));
    public static final MedievalArmorItem CHAINMAIL_BOOTS = new MedievalArmorItem("chainmail_boots", ArmorMaterials.CHAINMAIL, EquipmentSlotType.FEET, (new Item.Properties()).tab(GROUP_KA));

    public static final PlatemailItem KETTLEHAT = new PlatemailItem("kettlehat", ArmorMaterials.KETTLEHAT, EquipmentSlotType.HEAD, (new Item.Properties()).tab(GROUP_KA));
    public static final PlatemailItem PLATEMAIL_CHESTPLATE = new PlatemailItem("platemail_chestplate", ArmorMaterials.PLATEMAIL, EquipmentSlotType.CHEST, (new Item.Properties()).tab(GROUP_KA));
    public static final PlatemailItem PLATEMAIL_LEGGINGS = new PlatemailItem("platemail_leggings", ArmorMaterials.PLATEMAIL, EquipmentSlotType.LEGS, (new Item.Properties()).tab(GROUP_KA));
    public static final PlatemailItem PLATEMAIL_BOOTS = new PlatemailItem("platemail_boots", ArmorMaterials.PLATEMAIL, EquipmentSlotType.FEET, (new Item.Properties()).tab(GROUP_KA));

    public static final HalfarmorItem BARBUTE = new HalfarmorItem("barbute", ArmorMaterials.BARBUTE, EquipmentSlotType.HEAD, (new Item.Properties()).tab(GROUP_KA));
    public static final HalfarmorItem HALFARMOR_CHESTPLATE = new HalfarmorItem("halfarmor_chestplate", ArmorMaterials.HALFARMOR, EquipmentSlotType.CHEST, (new Item.Properties()).tab(GROUP_KA));

    public static final MedievalArmorItem GREATHELM = new MedievalArmorItem("greathelm", ArmorMaterials.CRUSADER, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA));
    public static final DyeableMedievalArmorItem CRUSADER_CHESTPLATE = new DyeableMedievalArmorItem("crusader_chestplate", ArmorMaterials.CRUSADER, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA), -3227226);
    public static final MedievalArmorItem CRUSADER_LEGGINGS = new MedievalArmorItem("crusader_leggings", ArmorMaterials.CRUSADER, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA));
    public static final DyeableMedievalArmorItem CRUSADER_BOOTS = new DyeableMedievalArmorItem("crusader_boots", ArmorMaterials.CRUSADER, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA), -3227226);

    public static final KnightItem CEREMONIALARMET = new KnightItem("ceremonialarmet", ArmorMaterials.CEREMONIALARMET, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA));
    public static final MedievalArmorItem CEREMONIAL_CHESTPLATE = new MedievalArmorItem("ceremonial_chestplate", ArmorMaterials.CEREMONIAL, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA));
    public static final MedievalArmorItem CEREMONIAL_BOOTS = new MedievalArmorItem("ceremonial_boots", ArmorMaterials.CEREMONIAL, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA));

    public static final DyeableMedievalArmorItem COIF = new DyeableMedievalArmorItem("coif", ArmorMaterials.GAMBESON, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA), -4280691);
    public static final DyeableMedievalArmorItem GAMBESON = new DyeableMedievalArmorItem("gambeson_chestplate", ArmorMaterials.GAMBESON, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA), -4280691);
    public static final DyeableMedievalArmorItem PANTYHOSE = new DyeableMedievalArmorItem("pantyhose", ArmorMaterials.GAMBESON, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA), -14531028);
    public static final DyeableMedievalArmorItem GAMBESONBOOTS = new DyeableMedievalArmorItem("gambeson_boots", ArmorMaterials.GAMBESON, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA), -4280691);

    public static final DyeableMedievalArmorItem BRIGANDINE = new DyeableMedievalArmorItem("brigandine_chestplate", ArmorMaterials.BRIGANDINE, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA), 10511680);

    public static final MedievalArmorItem NORMAN_HELMET = new MedievalArmorItem("norman_helmet", ArmorMaterials.NORMAN, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA));

    public static final MedievalArmorItem SHISHAK = new MedievalArmorItem("shishak", ArmorMaterials.SHISHAK, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA));

    public static final HalfarmorItem RUSTEDBARBUTE = new HalfarmorItem("rustedbarbute", ArmorMaterials.RUSTEDBARBUTE, EquipmentSlotType.HEAD, new Item.Properties());
    public static final HalfarmorItem RUSTEDHALFARMOR_CHESTPLATE = new HalfarmorItem("rustedhalfarmor_chestplate", ArmorMaterials.RUSTEDHALFARMOR, EquipmentSlotType.CHEST, new Item.Properties());

    public static final MedievalArmorItem RUSTEDGREATHELM = new MedievalArmorItem("rustedgreathelm", ArmorMaterials.RUSTEDCRUSADER, EquipmentSlotType.HEAD, new Item.Properties());
    public static final MedievalArmorItem RUSTEDCRUSADER_CHESTPLATE = new MedievalArmorItem("rustedcrusader_chestplate", ArmorMaterials.RUSTEDCRUSADER, EquipmentSlotType.CHEST, new Item.Properties());
    public static final MedievalArmorItem RUSTEDCRUSADER_BOOTS = new MedievalArmorItem("rustedcrusader_boots", ArmorMaterials.RUSTEDCRUSADER, EquipmentSlotType.FEET, new Item.Properties());

    public static final MedievalArmorItem RUSTEDNORMAN_HELMET = new MedievalArmorItem("rustednorman_helmet", ArmorMaterials.RUSTEDNORMAN, EquipmentSlotType.HEAD, new Item.Properties());

    public static final MedievalArmorItem RUSTEDCHAINMAIL_HELMET = new MedievalArmorItem("rustedchainmail_helmet", ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlotType.HEAD, (new Item.Properties()));
    public static final MedievalArmorItem RUSTEDCHAINMAIL_CHESTPLATE = new MedievalArmorItem("rustedchainmail_chestplate", ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlotType.CHEST, (new Item.Properties()));
    public static final MedievalArmorItem RUSTEDCHAINMAIL_LEGGINGS = new MedievalArmorItem("rustedchainmail_leggings", ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlotType.LEGS, (new Item.Properties()));
    public static final MedievalArmorItem RUSTEDCHAINMAIL_BOOTS = new MedievalArmorItem("rustedchainmail_boots", ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlotType.FEET, (new Item.Properties()));

    public static final PlatemailItem RUSTEDKETTLEHAT = new PlatemailItem("rustedkettlehat", ArmorMaterials.RUSTEDKETTLEHAT, EquipmentSlotType.HEAD, (new Item.Properties()));

    public static final XIVCenturyKnightItem BASCINET = new XIVCenturyKnightItem("bascinet", ArmorMaterials.BASCINET, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA));
    public static final XIVCenturyKnightItem XIVCENTURYKNIGHT_CHESTPLATE = new XIVCenturyKnightItem("xivcenturyknight_chestplate", ArmorMaterials.XIVCENTURYKNIGHT, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA));
    public static final XIVCenturyKnightItem XIVCENTURYKNIGHT_LEGGINGS = new XIVCenturyKnightItem("xivcenturyknight_leggings", ArmorMaterials.XIVCENTURYKNIGHT, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA));
    public static final XIVCenturyKnightItem XIVCENTURYKNIGHT_BOOTS = new XIVCenturyKnightItem("xivcenturyknight_boots", ArmorMaterials.XIVCENTURYKNIGHT, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA));

    public static final WingedHussarItem WINGEDHUSSAR_CHESTPLATE = new WingedHussarItem("wingedhussar_chestplate", ArmorMaterials.WINGEDHUSSARCHESTPLATE, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA));

    public static final MedievalArmorItem BURGONET = new MedievalArmorItem("cuirassier_helmet", ArmorMaterials.CUIRASSIER, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA));
    public static final DyeableMedievalArmorItem CUIRASSIER_CHESTPLATE = new DyeableMedievalArmorItem("cuirassier_chestplate", ArmorMaterials.CUIRASSIER, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA), -5465480);
    public static final DyeableMedievalArmorItem CUIRASSIER_LEGGINGS = new DyeableMedievalArmorItem("cuirassier_leggings", ArmorMaterials.CUIRASSIER, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA), -5465480);
    public static final MedievalArmorItem CUIRASSIER_BOOTS = new MedievalArmorItem("cuirassier_boots", ArmorMaterials.CUIRASSIER, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA));


    public static final Item[] armor = new Item[] {
            ARMET, KNIGHT_CHESTPLATE, KNIGHT_LEGGINGS, KNIGHT_BOOTS, STECHHELM, JOUSTING_CHESTPLATE, JOUSTING_LEGGINGS, JOUSTING_BOOTS, SALLET, GOTHIC_CHESTPLATE,
            GOTHIC_LEGGINGS, GOTHIC_BOOTS, MAXIMILIAN_HELMET, MAXIMILIAN_CHESTPLATE, MAXIMILIAN_LEGGINGS, MAXIMILIAN_BOOTS, CHAINMAIL_HELMET, CHAINMAIL_CHESTPLATE, CHAINMAIL_LEGGINGS, CHAINMAIL_BOOTS,
            KETTLEHAT, PLATEMAIL_CHESTPLATE, PLATEMAIL_LEGGINGS, PLATEMAIL_BOOTS, BARBUTE, HALFARMOR_CHESTPLATE,
            GREATHELM,
            CRUSADER_CHESTPLATE,
            CRUSADER_LEGGINGS,
            CRUSADER_BOOTS,
            CEREMONIALARMET,
            CEREMONIAL_CHESTPLATE,
            CEREMONIAL_BOOTS,
            COIF,
            GAMBESON,
            PANTYHOSE,
            GAMBESONBOOTS,
            BRIGANDINE,
            NORMAN_HELMET,
            SHISHAK,
            RUSTEDBARBUTE,
            RUSTEDHALFARMOR_CHESTPLATE,
            RUSTEDGREATHELM,
            RUSTEDCRUSADER_CHESTPLATE,
            RUSTEDCRUSADER_BOOTS,
            RUSTEDKETTLEHAT,
            RUSTEDNORMAN_HELMET,
            RUSTEDCHAINMAIL_HELMET,
            RUSTEDCHAINMAIL_CHESTPLATE,
            RUSTEDCHAINMAIL_LEGGINGS,
            RUSTEDCHAINMAIL_BOOTS,
            BASCINET,
            XIVCENTURYKNIGHT_CHESTPLATE,
            XIVCENTURYKNIGHT_LEGGINGS,
            XIVCENTURYKNIGHT_BOOTS,
            WINGEDHUSSAR_CHESTPLATE,
            BURGONET,
            CUIRASSIER_CHESTPLATE,
            CUIRASSIER_LEGGINGS,
            CUIRASSIER_BOOTS
    };

    public static final ItemGroup GROUP_KW = new ItemGroup(KnightlyArmory.ID + ".weapons")
    {
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(flamebladedswords.iron);
        }
    };

    public static final ItemGroup GROUP_KPW = new ItemGroup(KnightlyArmory.ID + ".particular_weapons")
    {
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(NOBLE_SWORD);
        }
    };

    public static final ItemGroup GROUP_KS = new ItemGroup(KnightlyArmory.ID + ".shields")
    {
        @Override
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(heatershields.iron);
        }
    };

    public static final Item BARDING = new HorseArmorItem(12, new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/barding.png"), new Item.Properties().stacksTo(1).tab(GROUP_KA)).setRegistryName("barding");
    public static final Item CHAINMAIL_HORSE_ARMOR = new HorseArmorItem(6, new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/horse_armor_chainmail.png"), new Item.Properties().stacksTo(1).tab(GROUP_KA)).setRegistryName("chainmail_horse_armor");


    public static final Item APOSTOLIC_CROSS_PATTERN = new BannerPatternItem(HeraldyPatterns.APOSTOLIC_CROSS_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("apostolic_cross_pattern");
    public static final Item BOWL_PATTERN = new BannerPatternItem(HeraldyPatterns.BOWL_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("bowl_pattern");
    public static final Item BULL_PATTERN = new BannerPatternItem(HeraldyPatterns.BULL_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("bull_pattern");
    public static final Item CHESS_PATTERN = new BannerPatternItem(HeraldyPatterns.CHESS_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("chess_pattern");
    public static final Item CRUSADER_CROSS_PATTERN = new BannerPatternItem(HeraldyPatterns.CRUSADER_CROSS_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("crusader_cross_pattern");
    public static final Item DRAGON_PATTERN = new BannerPatternItem(HeraldyPatterns.DRAGON_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("dragon_pattern");
    public static final Item EAGLE_PATTERN = new BannerPatternItem(HeraldyPatterns.EAGLE_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("eagle_pattern");
    public static final Item HORSE_PATTERN = new BannerPatternItem(HeraldyPatterns.HORSE_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("horse_pattern");
    public static final Item LILY_PATTERN = new BannerPatternItem(HeraldyPatterns.LILY_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("lily_pattern");
    public static final Item LION1_PATTERN = new BannerPatternItem(HeraldyPatterns.LION1_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("lion1_pattern");
    public static final Item LION2_PATTERN = new BannerPatternItem(HeraldyPatterns.LION2_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("lion2_pattern");
    public static final Item ORTHODOX_CROSS_PATTERN = new BannerPatternItem(HeraldyPatterns.ORTHODOX_CROSS_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("orthodox_cross_pattern");
    public static final Item SNAKE_PATTERN = new BannerPatternItem(HeraldyPatterns.SNAKE_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("snake_pattern");
    public static final Item SUN_PATTERN = new BannerPatternItem(HeraldyPatterns.SUN_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("sun_pattern");
    public static final Item SWORDS_PATTERN = new BannerPatternItem(HeraldyPatterns.SWORDS_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("swords_pattern");
    public static final Item TOWER_PATTERN = new BannerPatternItem(HeraldyPatterns.TOWER_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("tower_pattern");
    public static final Item TREE_PATTERN = new BannerPatternItem(HeraldyPatterns.TREE_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("tree_pattern");
    public static final Item TWOHEADED_EAGLE_PATTERN = new BannerPatternItem(HeraldyPatterns.TWOHEADED_EAGLE_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName("two-headed_eagle_pattern");


    public static final Item STEEL_INGOT = new IngridientItem((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS), "steel_ingot");
    public static final Item STEEL_NUGGET = new IngridientItem((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS), "steel_nugget");
    public static final Item STEEL_RING = new IngridientItem((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS), "steel_ring");
    public static final Item STEEL_CHAINMAIL = new IngridientItem((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS), "steel_chainmail");
    public static final Item STEEL_PLATE = new IngridientItem((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS), "steel_plate");
    public static final Item LEATHER_STRIP = new IngridientItem((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS), "leather_strip");
    public static final Item HILT = new IngridientItem((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS), "hilt");
    public static final Item POLE = new IngridientItem((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS), "pole");
    public static final Item STEEL_CHAIN = new IngridientItem((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS), "steel_chain");
    public static final Item WOOLEN_FABRIC = new IngridientItem(new Item.Properties().tab(ItemGroup.TAB_MATERIALS), "woolen_fabric");


    public static WeaponsSupply stylets = new WeaponsSupply(WeaponsWorkshop.STYLET);
    public static WeaponsSupply shortswords = new WeaponsSupply(WeaponsWorkshop.SHORTSWORD);
    public static WeaponsSupply katzbalgers = new WeaponsSupply(WeaponsWorkshop.KATZBALGER);
    public static WeaponsSupply pikes = new WeaponsSupply(WeaponsWorkshop.PIKE);
    public static WeaponsSupply ranseurs = new WeaponsSupply(WeaponsWorkshop.RANSEUR);
    public static WeaponsSupply ahlspiesses = new WeaponsSupply(WeaponsWorkshop.AHLSPIESS);
    public static WeaponsSupply chivalrylances = new WeaponsSupply(WeaponsWorkshop.CHIVALRYLANCE);
    public static WeaponsSupply bastardswords = new WeaponsSupply(WeaponsWorkshop.BASTARDSWORD);
    public static WeaponsSupply estocs = new WeaponsSupply(WeaponsWorkshop.ESTOC);
    public static WeaponsSupply claymors = new WeaponsSupply(WeaponsWorkshop.CLAYMORE);
    public static WeaponsSupply zweihanders = new WeaponsSupply(WeaponsWorkshop.ZWEIHANDER);
    public static WeaponsSupply flamebladedswords = new WeaponsSupply(WeaponsWorkshop.FlAMEBLADEDSWORD);
    public static WeaponsSupply lochaberaxes = new WeaponsSupply(WeaponsWorkshop.LOCHABERAXE);
    public static WeaponsSupply concavehalberds = new WeaponsSupply(WeaponsWorkshop.CONCAVEHALBERD);
    public static WeaponsSupply heavymaces = new WeaponsSupply(WeaponsWorkshop.HEAVYMACE);
    public static WeaponsSupply heavywarhammers = new WeaponsSupply(WeaponsWorkshop.HEAVYWARHAMMER);
    public static WeaponsSupply lucernhammers = new WeaponsSupply(WeaponsWorkshop.LUCERNHAMMER);
    public static WeaponsSupply morgensterns = new WeaponsSupply(WeaponsWorkshop.MORGENSTERN);
    public static WeaponsSupply chainmorgensterns = new WeaponsSupply(WeaponsWorkshop.CHAINMORGENSTERN);
    public static WeaponsSupply guisarmes = new WeaponsSupply(WeaponsWorkshop.GUISARME);

    public static ShieldsSupply heatershields = new ShieldsSupply(ShieldsWorkshop.HEATERSHIELD, "heatershield", true);
    public static ShieldsSupply targets = new ShieldsSupply(ShieldsWorkshop.TARGET, "target", false);
    public static ShieldsSupply bucklers = new ShieldsSupply(ShieldsWorkshop.BUCKLER, "buckler", false);
    public static ShieldsSupply rondaches = new ShieldsSupply(ShieldsWorkshop.RONDACHE, "rondache", true);
    public static ShieldsSupply tartsches = new ShieldsSupply(ShieldsWorkshop.TARTSCHE, "tartsche", true);
    public static ShieldsSupply ellipticalshields = new ShieldsSupply(ShieldsWorkshop.ELLIPTICALSHIELD, "ellipticalshield", true);
    public static ShieldsSupply roundshields = new ShieldsSupply(ShieldsWorkshop.ROUNDSHIELD, "roundshield", true);
    public static ShieldsSupply paveses = new ShieldsSupply(ShieldsWorkshop.PAVESE, "pavese", true);
    public static ShieldsSupply kiteshields = new ShieldsSupply(ShieldsWorkshop.KITESHIELD, "kiteshield", true);

    public static final Item BLACKSMITH_HAMMER = new MedievalWeaponItem("blacksmith_hammer", new Item.Properties().tab(GROUP_KPW), ModItemTier.STEEL, 5.0f, 1.0f, -3.0f, 4, 0.0f);
	public static final Item BARBED_CLUB = new MedievalWeaponItem("barbedclub", new Item.Properties().tab(GROUP_KPW), ModItemTier.IRON, 5.6f, 1.1f, -3.0f);
	public static final Item PITCHFORK = new MedievalWeaponItem("pitchfork", new Item.Properties().tab(GROUP_KPW), ModItemTier.IRON, 2.8f, 1.0f, -3.0f, 0, 1.0f);
	public static final Item NOBLE_SWORD = new MedievalWeaponItem("noble_sword", new Item.Properties().tab(GROUP_KPW), ModItemTier.IRON, 4.25f, 1.0f, -2.49f).setTwoHanded(1).setBlocking(5.0f, 5.0f);
	public static final Item RUSTEDBASTARDSWORD = new MedievalWeaponItem("rusted_bastardsword", new Item.Properties(), ModItemTier.IRON, 2.0F, 1.0F, -2.49F).setTwoHanded(1).setBlocking(5.0f, 5.0f);
	public static final Item RUSTEDHEAVYMACE = new MedievalWeaponItem("rusted_heavymace", new Item.Properties(), ModItemTier.IRON, 2.0F, 1.0F, -2.49F);

    public static final Item LONGBOW = new MedievalBowItem("longbow", new Item.Properties().tab(GROUP_KPW), 4.2f, 26.0f);

    public static final ArrayList<IHasModelProperty> modelProperties = new ArrayList<>();
    public static final ArrayList<Item> dyeableItems = new ArrayList<>();

    public static class ItemsSupply<T extends Item>
    {
        public T wood;
        public T stone;
        public T iron;
        public T gold;
        public T diamond;
        public T netherite;

        public T copper;
        public T steel;
        public T silver;
        public T tin;
        public T bronze;

        public ItemsSupply(BiFunction<ModItemTier, Item.Properties, T> workshop, Item.Properties prop)
        {
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

        public Item[] get()
        {
            return new Item[] { this.wood, this.stone, this.iron, this.gold, this.diamond, this.copper, this.steel, this.silver, this.netherite, this.tin, this.bronze };
        }

        public void registerItems(IForgeRegistry<Item> reg)
        {
            Item[] items = this.get();
            if (items[0] instanceof IHasModelProperty)
            {
                for (Item item : items)
                {
                    ModItems.modelProperties.add((IHasModelProperty) item);
                }
            }
            reg.registerAll(items);
        }
    }

    public static class ShieldsSupply extends ItemsSupply<ShieldItem>
    {
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

        public static Item.Properties getProperties(boolean is3d)
        {
            Item.Properties prop = new Item.Properties().tab(ModItems.GROUP_KS);
            if (KnightlyArmory.PROXY instanceof ClientProxy && is3d)
            {
                prop = ClientProxy.setHeraldyItemStackRenderer(prop);
            }
            return prop;
        }

        public ShieldsSupply(BiFunction<ModItemTier, Properties, ShieldItem> workshop, String shieldName, boolean is3d)
        {
            super(workshop, getProperties(is3d));

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

        public void registerStitchesWithoutPatterns(TextureStitchEvent.Pre ev)
        {
            if (ev.getMap().location() == AtlasTexture.LOCATION_BLOCKS)
            {
                String[] textures = new String[] { this.woodTexture, this.stoneTexture, this.ironTexture, this.goldTexture, this.diamondTexture, this.netheriteTexture, this.copperTexture, this.steelTexture, this.silverTexture, this.netheriteTexture, this.tinTexture, this.bronzeTexture };
                for (String texture : textures)
                {
                    ev.addSprite(new ResourceLocation(KnightlyArmory.ID, texture + "_nopattern"));
                }
            }
        }

        public void registerStitches(TextureStitchEvent.Pre ev)
        {
            if (ev.getMap().location() == AtlasTexture.LOCATION_BLOCKS)
            {
                String[] textures = new String[] { this.woodTexture, this.stoneTexture, this.ironTexture, this.goldTexture, this.diamondTexture, this.netheriteTexture, this.copperTexture, this.steelTexture, this.silverTexture, this.netheriteTexture, this.tinTexture, this.bronzeTexture };
                for (String texture : textures)
                {
                    ev.addSprite(new ResourceLocation(KnightlyArmory.ID, texture + "_pattern"));
                    ev.addSprite(new ResourceLocation(KnightlyArmory.ID, texture + "_nopattern"));
                }
            }

            if (ev.getMap().location() == Atlases.SHIELD_SHEET)
            {
                for (BannerPattern bannerPattern : BannerPattern.values())
                {
                    ev.addSprite(new ResourceLocation(KnightlyArmory.ID, "entity/" + shieldName + "/" + bannerPattern.getFilename()));
                }
            }
        }
    }

    public static class WeaponsSupply extends ItemsSupply<SwordItem>
    {
        public WeaponsSupply(BiFunction<ModItemTier, Item.Properties, SwordItem> workshop)
        {
            super(workshop, new Item.Properties().tab(GROUP_KW));
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> ev)
    {
        IForgeRegistry<Item> reg = ev.getRegistry();

        for (Item armor0 : armor)
		{
			if (armor0 instanceof IHasModelProperty)
			{
				modelProperties.add((IHasModelProperty) armor0);
			}
			if (armor0 instanceof IDyeableArmorItem)
			{
				dyeableItems.add(armor0);
			}
		}
        dyeableItems.addAll(Arrays.asList(chivalrylances.get()));
        modelProperties.add((IHasModelProperty) LONGBOW);
        modelProperties.add((IHasModelProperty) NOBLE_SWORD);

        reg.registerAll(armor);

        reg.register(BARDING);
        reg.register(CHAINMAIL_HORSE_ARMOR);

        reg.register(APOSTOLIC_CROSS_PATTERN);
        reg.register(BOWL_PATTERN);
        reg.register(BULL_PATTERN);
        reg.register(CHESS_PATTERN);
        reg.register(CRUSADER_CROSS_PATTERN);
        reg.register(DRAGON_PATTERN);
        reg.register(EAGLE_PATTERN);
        reg.register(HORSE_PATTERN);
        reg.register(LILY_PATTERN);
        reg.register(LION1_PATTERN);
        reg.register(LION2_PATTERN);
        reg.register(ORTHODOX_CROSS_PATTERN);
        reg.register(SNAKE_PATTERN);
        reg.register(SUN_PATTERN);
        reg.register(SWORDS_PATTERN);
        reg.register(TOWER_PATTERN);
        reg.register(TREE_PATTERN);
        reg.register(TWOHEADED_EAGLE_PATTERN);

        reg.register(STEEL_INGOT);
        reg.register(STEEL_NUGGET);
        reg.register(STEEL_PLATE);
        reg.register(STEEL_RING);
        reg.register(STEEL_CHAINMAIL);
        reg.register(LEATHER_STRIP);
        reg.register(HILT);
        reg.register(POLE);
        reg.register(STEEL_CHAIN);
        reg.register(WOOLEN_FABRIC);

        reg.register(BLACKSMITH_HAMMER);
        reg.register(BARBED_CLUB);
        reg.register(PITCHFORK);
        reg.register(NOBLE_SWORD);
        reg.register(RUSTEDBASTARDSWORD);
        reg.register(RUSTEDHEAVYMACE);

		reg.register(LONGBOW);

        stylets.registerItems(reg);
        shortswords.registerItems(reg);
        katzbalgers.registerItems(reg);
        pikes.registerItems(reg);
        ranseurs.registerItems(reg);
        ahlspiesses.registerItems(reg);
        chivalrylances.registerItems(reg);
        bastardswords.registerItems(reg);
        estocs.registerItems(reg);
        claymors.registerItems(reg);
        zweihanders.registerItems(reg);
        flamebladedswords.registerItems(reg);
        lochaberaxes.registerItems(reg);
        concavehalberds.registerItems(reg);
        heavymaces.registerItems(reg);
        heavywarhammers.registerItems(reg);
        lucernhammers.registerItems(reg);
        morgensterns.registerItems(reg);
        chainmorgensterns.registerItems(reg);
        guisarmes.registerItems(reg);

        heatershields.registerItems(reg);
        targets.registerItems(reg);
        bucklers.registerItems(reg);
        rondaches.registerItems(reg);
        tartsches.registerItems(reg);
        ellipticalshields.registerItems(reg);
        roundshields.registerItems(reg);
        paveses.registerItems(reg);
        kiteshields.registerItems(reg);
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onTextureStitchEvent(TextureStitchEvent.Pre ev)
    {
        heatershields.registerStitches(ev);
        rondaches.registerStitchesWithoutPatterns(ev);
        tartsches.registerStitches(ev);
        ellipticalshields.registerStitches(ev);
        roundshields.registerStitches(ev);
        paveses.registerStitches(ev);
        kiteshields.registerStitches(ev);
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipeSerializer<?>> ev)
    {
        ev.getRegistry().register(RecipesHeraldry.HERALDRY_RECIPES);
    }
}
