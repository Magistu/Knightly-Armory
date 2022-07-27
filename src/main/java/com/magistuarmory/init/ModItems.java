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
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.function.BiFunction;

@EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KnightlyArmory.ID);
    
    //Armor
    public static final ItemGroup GROUP_KA = new ItemGroup(KnightlyArmory.ID + ".armor")
    {
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(ModItems.ARMET.get());
        }
    };
    
    public static final RegistryObject<KnightItem> ARMET = ITEMS.register("armet", () -> new KnightItem(ArmorMaterials.ARMET, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> KNIGHT_CHESTPLATE = ITEMS.register("knight_chestplate", () -> new MedievalArmorItem(ArmorMaterials.KNIGHT, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> KNIGHT_LEGGINGS = ITEMS.register("knight_leggings", () -> new MedievalArmorItem(ArmorMaterials.KNIGHT, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> KNIGHT_BOOTS = ITEMS.register("knight_boots", () -> new MedievalArmorItem(ArmorMaterials.KNIGHT, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<JoustingItem> STECHHELM = ITEMS.register("stechhelm", () -> new JoustingItem(ArmorMaterials.STECHHELM, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<JoustingItem> JOUSTING_CHESTPLATE = ITEMS.register("jousting_chestplate", () -> new JoustingItem(ArmorMaterials.JOUSTING, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<JoustingItem> JOUSTING_LEGGINGS = ITEMS.register("jousting_leggings", () -> new JoustingItem(ArmorMaterials.JOUSTING, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<JoustingItem> JOUSTING_BOOTS = ITEMS.register("jousting_boots", () -> new JoustingItem(ArmorMaterials.JOUSTING, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<GothicItem> SALLET = ITEMS.register("sallet", () -> new GothicItem(ArmorMaterials.SALLET, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> GOTHIC_CHESTPLATE = ITEMS.register("gothic_chestplate", () -> new MedievalArmorItem(ArmorMaterials.GOTHIC, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> GOTHIC_LEGGINGS = ITEMS.register("gothic_leggings", () -> new MedievalArmorItem(ArmorMaterials.GOTHIC, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> GOTHIC_BOOTS = ITEMS.register("gothic_boots", () -> new MedievalArmorItem(ArmorMaterials.GOTHIC, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<MaximilianItem> MAXIMILIAN_HELMET = ITEMS.register("maximilian_helmet", () -> new MaximilianItem(ArmorMaterials.MAXIMILIANHELMET, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> MAXIMILIAN_CHESTPLATE = ITEMS.register("maximilian_chestplate", () -> new MedievalArmorItem(ArmorMaterials.MAXIMILIAN, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> MAXIMILIAN_LEGGINGS = ITEMS.register("maximilian_leggings", () -> new MedievalArmorItem(ArmorMaterials.MAXIMILIAN, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> MAXIMILIAN_BOOTS = ITEMS.register("maximilian_boots", () -> new MedievalArmorItem(ArmorMaterials.MAXIMILIAN, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<MedievalArmorItem> CHAINMAIL_HELMET = ITEMS.register("chainmail_helmet", () -> new MedievalArmorItem(ArmorMaterials.CHAINMAIL, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> CHAINMAIL_CHESTPLATE = ITEMS.register("chainmail_chestplate", () -> new MedievalArmorItem(ArmorMaterials.CHAINMAIL, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> CHAINMAIL_LEGGINGS = ITEMS.register("chainmail_leggings", () -> new MedievalArmorItem(ArmorMaterials.CHAINMAIL, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> CHAINMAIL_BOOTS = ITEMS.register("chainmail_boots", () -> new MedievalArmorItem(ArmorMaterials.CHAINMAIL, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<PlatemailItem> KETTLEHAT = ITEMS.register("kettlehat", () -> new PlatemailItem(ArmorMaterials.KETTLEHAT, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> PLATEMAIL_CHESTPLATE = ITEMS.register("platemail_chestplate", () -> new MedievalArmorItem(ArmorMaterials.PLATEMAIL, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> PLATEMAIL_LEGGINGS = ITEMS.register("platemail_leggings", () -> new MedievalArmorItem(ArmorMaterials.PLATEMAIL, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> PLATEMAIL_BOOTS = ITEMS.register("platemail_boots", () -> new MedievalArmorItem(ArmorMaterials.PLATEMAIL, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<HalfarmorItem> BARBUTE = ITEMS.register("barbute", () -> new HalfarmorItem(ArmorMaterials.BARBUTE, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> HALFARMOR_CHESTPLATE = ITEMS.register("halfarmor_chestplate", () -> new MedievalArmorItem(ArmorMaterials.HALFARMOR, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<MedievalArmorItem> GREATHELM = ITEMS.register("greathelm", () -> new MedievalArmorItem(ArmorMaterials.CRUSADER, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<DyeableMedievalArmorItem> CRUSADER_CHESTPLATE = ITEMS.register("crusader_chestplate", () -> new DyeableMedievalArmorItem(ArmorMaterials.CRUSADER, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA), -3227226));
    public static final RegistryObject<MedievalArmorItem> CRUSADER_LEGGINGS = ITEMS.register("crusader_leggings", () -> new MedievalArmorItem(ArmorMaterials.CRUSADER, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<DyeableMedievalArmorItem> CRUSADER_BOOTS = ITEMS.register("crusader_boots", () -> new DyeableMedievalArmorItem(ArmorMaterials.CRUSADER, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA), -3227226));

    public static final RegistryObject<KnightItem> CEREMONIALARMET = ITEMS.register("ceremonialarmet", () -> new KnightItem(ArmorMaterials.CEREMONIALARMET, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> CEREMONIAL_CHESTPLATE = ITEMS.register("ceremonial_chestplate", () -> new MedievalArmorItem(ArmorMaterials.CEREMONIAL, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> CEREMONIAL_BOOTS = ITEMS.register("ceremonial_boots", () -> new MedievalArmorItem(ArmorMaterials.CEREMONIAL, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<DyeableMedievalArmorItem> COIF = ITEMS.register("coif", () -> new DyeableMedievalArmorItem(ArmorMaterials.GAMBESON, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA), -4280691));
    public static final RegistryObject<DyeableMedievalArmorItem> GAMBESON = ITEMS.register("gambeson_chestplate", () -> new DyeableMedievalArmorItem(ArmorMaterials.GAMBESON, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA), -4280691));
    public static final RegistryObject<DyeableMedievalArmorItem> PANTYHOSE = ITEMS.register("pantyhose", () -> new DyeableMedievalArmorItem(ArmorMaterials.GAMBESON, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA), -14531028));
    public static final RegistryObject<DyeableMedievalArmorItem> GAMBESONBOOTS = ITEMS.register("gambeson_boots", () -> new DyeableMedievalArmorItem(ArmorMaterials.GAMBESON, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA), -4280691));

    public static final RegistryObject<DyeableMedievalArmorItem> BRIGANDINE = ITEMS.register("brigandine_chestplate", () -> new DyeableMedievalArmorItem(ArmorMaterials.BRIGANDINE, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA), 10511680));

    public static final RegistryObject<MedievalArmorItem> NORMAN_HELMET = ITEMS.register("norman_helmet", () -> new MedievalArmorItem(ArmorMaterials.NORMAN, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<MedievalArmorItem> SHISHAK = ITEMS.register("shishak", () -> new MedievalArmorItem(ArmorMaterials.SHISHAK, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<HalfarmorItem> RUSTEDBARBUTE = ITEMS.register("rustedbarbute", () -> new HalfarmorItem(ArmorMaterials.RUSTEDBARBUTE, EquipmentSlotType.HEAD, new Item.Properties()));
    public static final RegistryObject<MedievalArmorItem> RUSTEDHALFARMOR_CHESTPLATE = ITEMS.register("rustedhalfarmor_chestplate", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDHALFARMOR, EquipmentSlotType.CHEST, new Item.Properties()));

    public static final RegistryObject<MedievalArmorItem> RUSTEDGREATHELM = ITEMS.register("rustedgreathelm", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCRUSADER, EquipmentSlotType.HEAD, new Item.Properties()));
    public static final RegistryObject<MedievalArmorItem> RUSTEDCRUSADER_CHESTPLATE = ITEMS.register("rustedcrusader_chestplate", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCRUSADER, EquipmentSlotType.CHEST, new Item.Properties()));
    public static final RegistryObject<MedievalArmorItem> RUSTEDCRUSADER_BOOTS = ITEMS.register("rustedcrusader_boots", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCRUSADER, EquipmentSlotType.FEET, new Item.Properties()));

    public static final RegistryObject<MedievalArmorItem> RUSTEDNORMAN_HELMET = ITEMS.register("rustednorman_helmet", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDNORMAN, EquipmentSlotType.HEAD, new Item.Properties()));

    public static final RegistryObject<MedievalArmorItem> RUSTEDCHAINMAIL_HELMET = ITEMS.register("rustedchainmail_helmet", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlotType.HEAD, (new Item.Properties())));
    public static final RegistryObject<MedievalArmorItem> RUSTEDCHAINMAIL_CHESTPLATE = ITEMS.register("rustedchainmail_chestplate", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlotType.CHEST, (new Item.Properties())));
    public static final RegistryObject<MedievalArmorItem> RUSTEDCHAINMAIL_LEGGINGS = ITEMS.register("rustedchainmail_leggings", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlotType.LEGS, (new Item.Properties())));
    public static final RegistryObject<MedievalArmorItem> RUSTEDCHAINMAIL_BOOTS = ITEMS.register("rustedchainmail_boots", () -> new MedievalArmorItem(ArmorMaterials.RUSTEDCHAINMAIL, EquipmentSlotType.FEET, (new Item.Properties())));

    public static final RegistryObject<PlatemailItem> RUSTEDKETTLEHAT = ITEMS.register("rustedkettlehat", () -> new PlatemailItem(ArmorMaterials.RUSTEDKETTLEHAT, EquipmentSlotType.HEAD, (new Item.Properties())));

    public static final RegistryObject<XIVCenturyKnightItem> BASCINET = ITEMS.register("bascinet", () -> new XIVCenturyKnightItem(ArmorMaterials.BASCINET, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> XIVCENTURYKNIGHT_CHESTPLATE = ITEMS.register("xivcenturyknight_chestplate", () -> new MedievalArmorItem(ArmorMaterials.XIVCENTURYKNIGHT, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> XIVCENTURYKNIGHT_LEGGINGS = ITEMS.register("xivcenturyknight_leggings", () -> new MedievalArmorItem(ArmorMaterials.XIVCENTURYKNIGHT, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> XIVCENTURYKNIGHT_BOOTS = ITEMS.register("xivcenturyknight_boots", () -> new MedievalArmorItem(ArmorMaterials.XIVCENTURYKNIGHT, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<WingedHussarItem> WINGEDHUSSAR_CHESTPLATE = ITEMS.register("wingedhussar_chestplate", () -> new WingedHussarItem(ArmorMaterials.WINGEDHUSSARCHESTPLATE, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<MedievalArmorItem> BURGONET = ITEMS.register("cuirassier_helmet", () -> new MedievalArmorItem(ArmorMaterials.CUIRASSIER, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<DyeableMedievalArmorItem> CUIRASSIER_CHESTPLATE = ITEMS.register("cuirassier_chestplate", () -> new DyeableMedievalArmorItem(ArmorMaterials.CUIRASSIER, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA), -5465480));
    public static final RegistryObject<DyeableMedievalArmorItem> CUIRASSIER_LEGGINGS = ITEMS.register("cuirassier_leggings", () -> new DyeableMedievalArmorItem(ArmorMaterials.CUIRASSIER, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA), -5465480));
    public static final RegistryObject<MedievalArmorItem> CUIRASSIER_BOOTS = ITEMS.register("cuirassier_boots", () -> new MedievalArmorItem(ArmorMaterials.CUIRASSIER, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<KastenbrustItem> GRAND_BASCINET = ITEMS.register("grand_bascinet", () -> new KastenbrustItem(ArmorMaterials.GRAND_BASCINET, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> KASTENBRUST_CHESTPLATE = ITEMS.register("kastenbrust_chestplate", () -> new MedievalArmorItem(ArmorMaterials.KASTENBRUST, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> KASTENBRUST_LEGGINGS = ITEMS.register("kastenbrust_leggings", () -> new MedievalArmorItem(ArmorMaterials.KASTENBRUST, EquipmentSlotType.LEGS, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> KASTENBRUST_BOOTS = ITEMS.register("kastenbrust_boots", () -> new MedievalArmorItem(ArmorMaterials.KASTENBRUST, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<MedievalArmorItem> FACE_HELMET = ITEMS.register("face_helmet", () -> new MedievalArmorItem(ArmorMaterials.LAMELLAR, EquipmentSlotType.HEAD, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> LAMELLAR_CHESTPLATE = ITEMS.register("lamellar_chestplate", () -> new MedievalArmorItem(ArmorMaterials.LAMELLAR, EquipmentSlotType.CHEST, new Item.Properties().tab(GROUP_KA)));
    public static final RegistryObject<MedievalArmorItem> LAMELLAR_BOOTS = ITEMS.register("lamellar_boots", () -> new MedievalArmorItem(ArmorMaterials.LAMELLAR, EquipmentSlotType.FEET, new Item.Properties().tab(GROUP_KA)));

    public static final RegistryObject<Item> BARDING = ITEMS.register("barding", () -> new HorseArmorItem(12, new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/barding.png"), new Item.Properties().stacksTo(1).tab(GROUP_KA)));
    public static final RegistryObject<Item> CHAINMAIL_HORSE_ARMOR = ITEMS.register("chainmail_horse_armor", () -> new HorseArmorItem(6, new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/horse_armor_chainmail.png"), new Item.Properties().stacksTo(1).tab(GROUP_KA)));

    //Weapons
    public static final ItemGroup GROUP_KW = new ItemGroup(KnightlyArmory.ID + ".weapons")
    {
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(flamebladedswords.iron.get());
        }
    };

    public static final ItemGroup GROUP_KPW = new ItemGroup(KnightlyArmory.ID + ".particular_weapons")
    {
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(NOBLE_SWORD.get());
        }
    };

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

    public static final RegistryObject<Item> BLACKSMITH_HAMMER = ITEMS.register("blacksmith_hammer", () -> new MedievalWeaponItem(new Item.Properties().tab(GROUP_KPW), ModItemTier.STEEL, 5.0f, 1.0f, 4, 0.0f, 1.4f));
    public static final RegistryObject<Item> BARBED_CLUB = ITEMS.register("barbedclub", () -> new MedievalWeaponItem(new Item.Properties().tab(GROUP_KPW), ModItemTier.IRON, 5.6f, 1.0f, 1.0f));
    public static final RegistryObject<Item> PITCHFORK = ITEMS.register("pitchfork", () -> new MedievalWeaponItem(new Item.Properties().tab(GROUP_KPW), ModItemTier.IRON, 2.8f, 1.0f, 0, 1.0f, 1.2f));
    public static final RegistryObject<Item> NOBLE_SWORD = ITEMS.register("noble_sword", () -> new MedievalWeaponItem(new Item.Properties().tab(GROUP_KPW), ModItemTier.IRON, 4.25f, 1.51f, 2.7f).setTwoHanded(1).setBlocking(6.0f));
    public static final RegistryObject<Item> RUSTEDBASTARDSWORD = ITEMS.register("rusted_bastardsword", () -> new MedievalWeaponItem(new Item.Properties(), ModItemTier.IRON, 2.0F, 1.51F, 2.7f).setTwoHanded(1).setBlocking(6.0f));
    public static final RegistryObject<Item> RUSTEDHEAVYMACE = ITEMS.register("rusted_heavymace", () -> new MedievalWeaponItem(new Item.Properties(), ModItemTier.IRON, 2.0F, 1.51F, 2.6f));
    public static final RegistryObject<Item> CLUB = ITEMS.register("club", () -> new MedievalWeaponItem(new Item.Properties().tab(GROUP_KPW), ModItemTier.WOOD, 11.3F, 0.8f, 5.0f).setTwoHanded(1));
    public static final RegistryObject<Item> MESSER_SWORD = ITEMS.register("messer_sword", () -> new MedievalWeaponItem(new Item.Properties().tab(GROUP_KPW), ModItemTier.IRON, 3.8f, 1.56f, 1.2f).setBlocking(5.0f));

    public static final RegistryObject<Item> LONGBOW = ITEMS.register("longbow", () -> new MedievalBowItem(new Item.Properties().tab(GROUP_KPW), 4.2f, 26.0f));
    public static final RegistryObject<Item> HEAVY_CROSSBOW = ITEMS.register("heavy_crossbow", () -> new MedievalCrossbowItem(new Item.Properties().tab(GROUP_KPW), 4.3f, 50));

    //Shields
    public static final ItemGroup GROUP_KS = new ItemGroup(KnightlyArmory.ID + ".shields")
    {
        @Override
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(heatershields.iron.get());
        }
    };
    
    public static final ShieldsSupply heatershields = new ShieldsSupply(ShieldsWorkshop.HEATERSHIELD, "heatershield", true);
    public static final ShieldsSupply targets = new ShieldsSupply(ShieldsWorkshop.TARGET, "target", false);
    public static final ShieldsSupply bucklers = new ShieldsSupply(ShieldsWorkshop.BUCKLER, "buckler", false);
    public static final ShieldsSupply rondaches = new ShieldsSupply(ShieldsWorkshop.RONDACHE, "rondache", true);
    public static final ShieldsSupply tartsches = new ShieldsSupply(ShieldsWorkshop.TARTSCHE, "tartsche", true);
    public static final ShieldsSupply ellipticalshields = new ShieldsSupply(ShieldsWorkshop.ELLIPTICALSHIELD, "ellipticalshield", true);
    public static final ShieldsSupply roundshields = new ShieldsSupply(ShieldsWorkshop.ROUNDSHIELD, "roundshield", true);
    public static final ShieldsSupply paveses = new ShieldsSupply(ShieldsWorkshop.PAVESE, "pavese", true);
    public static final ShieldsSupply kiteshields = new ShieldsSupply(ShieldsWorkshop.KITESHIELD, "kiteshield", true);
    
    //Patterns
    public static final RegistryObject<Item> APOSTOLIC_CROSS_PATTERN = ITEMS.register("apostolic_cross_pattern", () -> new BannerPatternItem(HeraldryPatterns.APOSTOLIC_CROSS_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> BOWL_PATTERN = ITEMS.register("bowl_pattern", () -> new BannerPatternItem(HeraldryPatterns.BOWL_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> BULL_PATTERN = ITEMS.register("bull_pattern", () -> new BannerPatternItem(HeraldryPatterns.BULL_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> CHESS_PATTERN = ITEMS.register("chess_pattern", () -> new BannerPatternItem(HeraldryPatterns.CHESS_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> CRUSADER_CROSS_PATTERN = ITEMS.register("crusader_cross_pattern", () -> new BannerPatternItem(HeraldryPatterns.CRUSADER_CROSS_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> DRAGON_PATTERN = ITEMS.register("dragon_pattern", () -> new BannerPatternItem(HeraldryPatterns.DRAGON_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> EAGLE_PATTERN = ITEMS.register("eagle_pattern", () -> new BannerPatternItem(HeraldryPatterns.EAGLE_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> HORSE_PATTERN = ITEMS.register("horse_pattern", () -> new BannerPatternItem(HeraldryPatterns.HORSE_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> LILY_PATTERN = ITEMS.register("lily_pattern", () -> new BannerPatternItem(HeraldryPatterns.LILY_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> LION1_PATTERN = ITEMS.register("lion1_pattern", () -> new BannerPatternItem(HeraldryPatterns.LION1_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> LION2_PATTERN = ITEMS.register("lion2_pattern", () -> new BannerPatternItem(HeraldryPatterns.LION2_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> ORTHODOX_CROSS_PATTERN = ITEMS.register("orthodox_cross_pattern", () -> new BannerPatternItem(HeraldryPatterns.ORTHODOX_CROSS_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> SNAKE_PATTERN = ITEMS.register("snake_pattern", () -> new BannerPatternItem(HeraldryPatterns.SNAKE_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> SUN_PATTERN = ITEMS.register("sun_pattern", () -> new BannerPatternItem(HeraldryPatterns.SUN_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> SWORDS_PATTERN = ITEMS.register("swords_pattern", () -> new BannerPatternItem(HeraldryPatterns.SWORDS_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> TOWER_PATTERN = ITEMS.register("tower_pattern", () -> new BannerPatternItem(HeraldryPatterns.TOWER_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> TREE_PATTERN = ITEMS.register("tree_pattern", () -> new BannerPatternItem(HeraldryPatterns.TREE_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> TWOHEADED_EAGLE_PATTERN = ITEMS.register("two-headed_eagle_pattern", () -> new BannerPatternItem(HeraldryPatterns.TWOHEADED_EAGLE_PATTERN, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    
    //Materials
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> STEEL_RING = ITEMS.register("steel_ring", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> STEEL_CHAINMAIL = ITEMS.register("steel_chainmail", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> LEATHER_STRIP = ITEMS.register("leather_strip", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> HILT = ITEMS.register("hilt", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> POLE = ITEMS.register("pole", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> STEEL_CHAIN = ITEMS.register("steel_chain", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> WOOLEN_FABRIC = ITEMS.register("woolen_fabric", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> SMALL_STEEL_PLATE = ITEMS.register("small_steel_plate", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> LAMELLAR_ROWS = ITEMS.register("lamellar_rows", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    public static class ItemsSupply<T extends Item>
    {
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

        public ItemsSupply(BiFunction<ModItemTier, Item.Properties, RegistryObject<T>> workshop, Item.Properties prop)
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

        public ArrayList<RegistryObject<T>> get()
        {
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

        public ShieldsSupply(BiFunction<ModItemTier, Properties, RegistryObject<ShieldItem>> workshop, String shieldName, boolean is3d)
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
        public WeaponsSupply(BiFunction<ModItemTier, Item.Properties, RegistryObject<SwordItem>> workshop)
        {
            super(workshop, new Item.Properties().tab(GROUP_KW));
        }
    }

    public static final ShieldsSupply[] shieldsSupply = new ShieldsSupply[] { heatershields, targets, bucklers, rondaches, tartsches, ellipticalshields, roundshields, paveses, kiteshields };
    public static final WeaponsSupply[] weaponsSupply = new WeaponsSupply[] { ranseurs, ahlspiesses, chivalrylances, bastardswords, estocs, claymors, zweihanders, flamebladedswords, lochaberaxes, concavehalberds, guisarmes };
    public static ArrayList<RegistryObject<? extends Item>> dyeableItems;
    static
    {
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

    public static class WeaponsWorkshop
    {
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

    public static class ShieldsWorkshop
    {
        public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> HEATERSHIELD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_" + "heatershield", () -> (new MedievalShieldItem("heatershield", prop, material, getDurability(material, 350, 0.8f), 4, 10, true))));
        public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> TARGET = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_" + "target", () -> (new MedievalShieldItem("target", prop, material, getDurability(material, 350, 0.8f), 1, 6, false)).setRepairItem(material::getRepairIngredient)));
        public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> BUCKLER = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_" + "buckler", () -> (new MedievalShieldItem("buckler", prop, material, getDurability(material, 350, 0.8f), 1, 6, false)).setRepairItem(material::getRepairIngredient)));
        public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> RONDACHE = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_" + "rondache", () -> (new MedievalShieldItem("rondache", prop, material, getDurability(material, 420, 1.2f), 6, 13, false)).setRepairItem(material::getRepairIngredient)));
        public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> TARTSCHE = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_" + "tartsche", () -> (new MedievalShieldItem("tartsche", prop, material, getDurability(material, 350, 0.8f), 4, 10, true))));
        public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> ELLIPTICALSHIELD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_" + "ellipticalshield", () -> (new MedievalShieldItem("ellipticalshield", prop, material, getDurability(material, 370, 0.8f), 5, 10, true))));
        public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> ROUNDSHIELD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_" + "roundshield", () -> (new MedievalShieldItem("roundshield", prop, material, getDurability(material, 350, 0.8f), 3, 7, true))));
        public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> PAVESE = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_" + "pavese", () -> (new MedievalShieldItem("pavese", prop, material, getDurability(material, 450, 0.7f), 10, 17, true))));
        public static final BiFunction<ModItemTier, Item.Properties, RegistryObject<ShieldItem>> KITESHIELD = ((material, prop) -> ModItems.ITEMS.register(material.getMaterialName() + "_" + "kiteshield", () -> (new MedievalShieldItem("kiteshield", prop, material, getDurability(material, 370, 0.8f), 5, 10, true))));

        private static int getDurability(IItemTier material, int baseDuration, float materialFactor)
        {
            return (int) (baseDuration + materialFactor * material.getUses());
        }
    }
}
