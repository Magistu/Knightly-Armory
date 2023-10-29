package com.magistuarmory.init;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.config.ModConfigurations;
import com.magistuarmory.item.BlacksmithHammerItem;
import com.magistuarmory.item.ArmorItem;
import com.magistuarmory.item.GothicItem;
import com.magistuarmory.item.HalfarmorItem;
import com.magistuarmory.item.JoustingItem;
import com.magistuarmory.item.KnightItem;
import com.magistuarmory.item.MaximilianItem;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.item.PlatemailItem;
import com.magistuarmory.item.ShieldsFactory;
import com.magistuarmory.item.IngridientItem;
import com.magistuarmory.item.WeaponsFactory;
import com.magistuarmory.item.WingedHussarItem;
import com.magistuarmory.item.XIVCenturyKnightItem;
import com.magistuarmory.item.crafting.RecipesShieldHeraldy;
import com.magistuarmory.util.IHasModel;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemShield;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

@EventBusSubscriber(modid = KnightlyArmory.ID)
public class ModItems 
{
	public static final CreativeTabs GROUP_KA = new CreativeTabs(KnightlyArmory.ID + ".armor")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(ARMET);
		}
	};
	
	public static final Item APOSTOLIC_CROSS_PATTERN = new IngridientItem("apostolic_cross_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item BOWL_PATTERN = new IngridientItem("bowl_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item BULL_PATTERN = new IngridientItem("bull_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item CHESS_PATTERN = new IngridientItem("chess_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item CRUSADER_CROSS_PATTERN = new IngridientItem("crusader_cross_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item DRAGON_PATTERN = new IngridientItem("dragon_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item EAGLE_PATTERN = new IngridientItem("eagle_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item HORSE_PATTERN = new IngridientItem("horse_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item LILY_PATTERN = new IngridientItem("lily_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item LION1_PATTERN = new IngridientItem("lion1_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item LION2_PATTERN = new IngridientItem("lion2_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item ORTHODOX_CROSS_PATTERN = new IngridientItem("orthodox_cross_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item SNAKE_PATTERN = new IngridientItem("snake_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item SUN_PATTERN = new IngridientItem("sun_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item SWORDS_PATTERN = new IngridientItem("swords_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item TOWER_PATTERN = new IngridientItem("tower_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item TREE_PATTERN = new IngridientItem("tree_pattern").setCreativeTab(CreativeTabs.MISC);
	public static final Item TWOHEADED_EAGLE_PATTERN = new IngridientItem("two-headed_eagle_pattern").setCreativeTab(CreativeTabs.MISC);
	
	
	//Ingridients
	public static final Item STEEL_INGOT = new IngridientItem("steel_ingot").setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item STEEL_NUGGET = new IngridientItem("steel_nugget").setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item STEEL_RING = new IngridientItem("steel_ring").setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item STEEL_CHAINMAIL = new IngridientItem("steel_chainmail").setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item STEEL_PLATE = new IngridientItem("steel_plate").setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item LEATHER_STRIP = new IngridientItem("leather_strip").setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item HILT = new IngridientItem("hilt").setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item POLE = new IngridientItem("pole").setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item STEEL_CHAIN = new IngridientItem("steel_chain").setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item WOOLEN_FABRIC = new IngridientItem("woolen_fabric").setCreativeTab(CreativeTabs.MATERIALS);

	//Tool Materials
	public static final ToolMaterial TOOL_MATERIAL_COPPER = EnumHelper.addToolMaterial("copper", 1, 160, 0.7F, 0.0F, 10);
	public static final ToolMaterial TOOL_MATERIAL_SILVER = EnumHelper.addToolMaterial("silver", 2, 230, 5.5F, 1.0F, 18);
	public static final ToolMaterial TOOL_MATERIAL_STEEL = EnumHelper.addToolMaterial("steel", 2, 400, 6.0F, 2.5F, 14);
	public static final ToolMaterial TOOL_MATERIAL_TIN = EnumHelper.addToolMaterial("tin", 2, 130, 6.0F, 0.0F, 20);
	public static final ToolMaterial TOOL_MATERIAL_BRONZE = EnumHelper.addToolMaterial("bronze", 2, 200, 6.0F, 2.0F, 15);

	
	//Armor Materials
	public static final ArmorMaterial ARMOR_MATERIAL_ARMET = EnumHelper.addArmorMaterial("armet", KnightlyArmory.ID + ":armet", 23, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.25f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));
	public static final ArmorMaterial ARMOR_MATERIAL_KNIGHT = EnumHelper.addArmorMaterial("knight", KnightlyArmory.ID + ":knight", 23, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.25f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));

	public static final ArmorMaterial ARMOR_MATERIAL_STECHHELM = EnumHelper.addArmorMaterial("stechhelm", KnightlyArmory.ID + ":stechhelm", 34, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));
	public static final ArmorMaterial ARMOR_MATERIAL_JOUSTING = EnumHelper.addArmorMaterial("jousting", KnightlyArmory.ID + ":jousting", 34, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));

	public static final ArmorMaterial ARMOR_MATERIAL_SALLET = EnumHelper.addArmorMaterial("sallet", KnightlyArmory.ID + ":sallet", 23, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.25f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));
	public static final ArmorMaterial ARMOR_MATERIAL_GOTHIC = EnumHelper.addArmorMaterial("gothic", KnightlyArmory.ID + ":gothic", 23, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.25f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));

	public static final ArmorMaterial ARMOR_MATERIAL_MAXIMILIANHELMET = EnumHelper.addArmorMaterial("maximilian_helmet", KnightlyArmory.ID + ":maximilian_helmet", 34, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.8f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));
	public static final ArmorMaterial ARMOR_MATERIAL_MAXIMILIAN = EnumHelper.addArmorMaterial("maximilian", KnightlyArmory.ID + ":maximilian", 34, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.8f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));

	public static final ArmorMaterial ARMOR_MATERIAL_CHAINMAIL = EnumHelper.addArmorMaterial("chainmail", KnightlyArmory.ID + ":chainmail", 15, new int[] { 1, 4, 5, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0f);

	public static final ArmorMaterial ARMOR_MATERIAL_KETTLEHAT = EnumHelper.addArmorMaterial("kettlehat", KnightlyArmory.ID + ":kettlehat", 18, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.3f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));
	public static final ArmorMaterial ARMOR_MATERIAL_PLATEMAIL = EnumHelper.addArmorMaterial("platemail", KnightlyArmory.ID + ":platemail", 18, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.3f);

	public static final ArmorMaterial ARMOR_MATERIAL_BARBUTE = EnumHelper.addArmorMaterial("barbute", KnightlyArmory.ID + ":barbute", 20, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.3f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));
	public static final ArmorMaterial ARMOR_MATERIAL_HALFARMOR = EnumHelper.addArmorMaterial("halfarmor", KnightlyArmory.ID + ":halfarmor", 20, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.3f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));
	
	public static final ArmorMaterial ARMOR_MATERIAL_CRUSADER = EnumHelper.addArmorMaterial("crusader", KnightlyArmory.ID + ":crusader", 19, new int[] { 1, 5, 6, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.6f);

	public static final ArmorMaterial ARMOR_MATERIAL_BRIGANDINE = EnumHelper.addArmorMaterial("brigandine", KnightlyArmory.ID + ":brigandine", 17, new int[] { 2, 3, 5, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.25f);

	public static final ArmorMaterial ARMOR_MATERIAL_GAMBESON = EnumHelper.addArmorMaterial("gambeson", KnightlyArmory.ID + ":gambeson", 8, new int[] { 1, 0, 2, 1 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);

	public static final ArmorMaterial ARMOR_MATERIAL_CEREMONIALARMET = EnumHelper.addArmorMaterial("ceremonialarmet", KnightlyArmory.ID + ":ceremonialarmet", 23, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.25f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));
	public static final ArmorMaterial ARMOR_MATERIAL_CEREMONIAL = EnumHelper.addArmorMaterial("ceremonial", KnightlyArmory.ID + ":ceremonial", 23, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.25f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));

	public static final ArmorMaterial ARMOR_MATERIAL_SHISHAK = EnumHelper.addArmorMaterial("shishak", KnightlyArmory.ID + ":shishak", 19, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.3f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));
	
	public static final ArmorMaterial ARMOR_MATERIAL_NORMAN = EnumHelper.addArmorMaterial("norman", KnightlyArmory.ID + ":norman", 17, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.2f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));

	public static final ArmorMaterial ARMOR_MATERIAL_RUSTEDBARBUTE = EnumHelper.addArmorMaterial("rustedbarbute", KnightlyArmory.ID + ":rustedbarbute", 11, new int[] { 2, 5, 6, 2 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f);
	
	public static final ArmorMaterial ARMOR_MATERIAL_RUSTEDHALFARMOR = EnumHelper.addArmorMaterial("rustedhalfarmor", KnightlyArmory.ID + ":rustedhalfarmor", 11, new int[] { 1, 5, 6, 2 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f);
	
    public static final ArmorMaterial ARMOR_MATERIAL_RUSTEDCHAINMAIL = EnumHelper.addArmorMaterial("rustedchainmail", KnightlyArmory.ID + ":rustedchainmail", 9, new int[] { 1, 4, 5, 2 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f);
    
    public static final ArmorMaterial ARMOR_MATERIAL_RUSTEDKETTLEHAT = EnumHelper.addArmorMaterial("rustedkettlehat", KnightlyArmory.ID + ":rustedkettlehat", 9, new int[] { 2, 5, 6, 2 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f);
    
    public static final ArmorMaterial ARMOR_MATERIAL_RUSTEDNORMAN = EnumHelper.addArmorMaterial("rustednorman", KnightlyArmory.ID + ":rustednorman", 8, new int[] { 1, 4, 5, 2 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f);
    
    public static final ArmorMaterial ARMOR_MATERIAL_RUSTEDCRUSADER = EnumHelper.addArmorMaterial("rustedcrusader", KnightlyArmory.ID + ":rustedcrusader", 9, new int[] { 1, 5, 6, 3 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f);
	
	public static final ArmorMaterial ARMOR_MATERIAL_BASCINET = EnumHelper.addArmorMaterial("bascinet", KnightlyArmory.ID + ":bascinet", 21, new int[] { 2, 5, 7, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.25f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));
	public static final ArmorMaterial ARMOR_MATERIAL_XIVCENTURYKNIGHT = EnumHelper.addArmorMaterial("xivcenturyknight", KnightlyArmory.ID + ":xivcenturyknight", 20, new int[] { 2, 5, 7, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.2f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));

	public static final ArmorMaterial ARMOR_MATERIAL_WINGEDHUSSARCHESTPLATE = EnumHelper.addArmorMaterial("wingedhussarchestplate", KnightlyArmory.ID + ":wingedhussarchestplate", 20, new int[] { 1, 0, 7, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));

	public static final ArmorMaterial ARMOR_MATERIAL_CUIRASSIER = EnumHelper.addArmorMaterial("cuirassier", KnightlyArmory.ID + ":cuirassier", 20, new int[] { 1, 0, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f).setRepairItem(new ItemStack(ModItems.STEEL_INGOT));

	
	//Armor
	public static final KnightItem ARMET = (KnightItem) new KnightItem("armet", ARMOR_MATERIAL_ARMET, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
	public static final KnightItem KNIGHT_CHESTPLATE = (KnightItem) new KnightItem("knight_chestplate", ARMOR_MATERIAL_KNIGHT, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
	public static final KnightItem KNIGHT_LEGGINGS = (KnightItem) new KnightItem("knight_leggings", ARMOR_MATERIAL_KNIGHT, 0, EntityEquipmentSlot.LEGS).setCreativeTab(GROUP_KA);
	public static final KnightItem KNIGHT_BOOTS = (KnightItem) new KnightItem("knight_boots", ARMOR_MATERIAL_KNIGHT, 0, EntityEquipmentSlot.FEET).setCreativeTab(GROUP_KA);
	
	public static final JoustingItem STECHHELM = (JoustingItem) new JoustingItem("stechhelm", ARMOR_MATERIAL_STECHHELM, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
	public static final JoustingItem JOUSTING_CHESTPLATE = (JoustingItem) new JoustingItem("jousting_chestplate", ARMOR_MATERIAL_JOUSTING, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
	public static final JoustingItem JOUSTING_LEGGINGS = (JoustingItem) new JoustingItem("jousting_leggings", ARMOR_MATERIAL_JOUSTING, 0, EntityEquipmentSlot.LEGS).setCreativeTab(GROUP_KA);
	public static final JoustingItem JOUSTING_BOOTS = (JoustingItem) new JoustingItem("jousting_boots", ARMOR_MATERIAL_JOUSTING, 0, EntityEquipmentSlot.FEET).setCreativeTab(GROUP_KA);
	
	public static final GothicItem SALLET = (GothicItem) new GothicItem("sallet", ARMOR_MATERIAL_SALLET, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
	public static final GothicItem GOTHIC_CHESTPLATE = (GothicItem) new GothicItem("gothic_chestplate", ARMOR_MATERIAL_GOTHIC, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
	public static final GothicItem GOTHIC_LEGGINGS = (GothicItem) new GothicItem("gothic_leggings", ARMOR_MATERIAL_GOTHIC, 0, EntityEquipmentSlot.LEGS).setCreativeTab(GROUP_KA);
	public static final GothicItem GOTHIC_BOOTS = (GothicItem) new GothicItem("gothic_boots", ARMOR_MATERIAL_GOTHIC, 0, EntityEquipmentSlot.FEET).setCreativeTab(GROUP_KA);
	
	public static final MaximilianItem MAXIMILIAN_HELMET = (MaximilianItem) new MaximilianItem("maximilian_helmet", ARMOR_MATERIAL_MAXIMILIANHELMET, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
	public static final MaximilianItem MAXIMILIAN_CHESTPLATE = (MaximilianItem) new MaximilianItem("maximilian_chestplate", ARMOR_MATERIAL_MAXIMILIAN, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
	public static final MaximilianItem MAXIMILIAN_LEGGINGS = (MaximilianItem) new MaximilianItem("maximilian_leggings", ARMOR_MATERIAL_MAXIMILIAN, 0, EntityEquipmentSlot.LEGS).setCreativeTab(GROUP_KA);
	public static final MaximilianItem MAXIMILIAN_BOOTS = (MaximilianItem) new MaximilianItem("maximilian_boots", ARMOR_MATERIAL_MAXIMILIAN, 0, EntityEquipmentSlot.FEET).setCreativeTab(GROUP_KA);
	
	public static final ArmorItem CHAINMAIL_HELMET = (ArmorItem) new ArmorItem("chainmail_helmet", ARMOR_MATERIAL_CHAINMAIL, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
	public static final ArmorItem CHAINMAIL_CHESTPLATE = (ArmorItem) new ArmorItem("chainmail_chestplate", ARMOR_MATERIAL_CHAINMAIL, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
	public static final ArmorItem CHAINMAIL_LEGGINGS = (ArmorItem) new ArmorItem("chainmail_leggings", ARMOR_MATERIAL_CHAINMAIL, 0, EntityEquipmentSlot.LEGS).setCreativeTab(GROUP_KA);
	public static final ArmorItem CHAINMAIL_BOOTS = (ArmorItem) new ArmorItem("chainmail_boots", ARMOR_MATERIAL_CHAINMAIL, 0, EntityEquipmentSlot.FEET).setCreativeTab(GROUP_KA);
	
	public static final PlatemailItem KETTLEHAT = (PlatemailItem) new PlatemailItem("kettlehat", ARMOR_MATERIAL_KETTLEHAT, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
	public static final PlatemailItem PLATEMAIL_CHESTPLATE = (PlatemailItem) new PlatemailItem("platemail_chestplate", ARMOR_MATERIAL_PLATEMAIL, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
	public static final PlatemailItem PLATEMAIL_LEGGINGS = (PlatemailItem) new PlatemailItem("platemail_leggings", ARMOR_MATERIAL_PLATEMAIL, 0, EntityEquipmentSlot.LEGS).setCreativeTab(GROUP_KA);
	public static final PlatemailItem PLATEMAIL_BOOTS = (PlatemailItem) new PlatemailItem("platemail_boots", ARMOR_MATERIAL_PLATEMAIL, 0, EntityEquipmentSlot.FEET).setCreativeTab(GROUP_KA);
	
	public static final HalfarmorItem BARBUTE = (HalfarmorItem) new HalfarmorItem("barbute", ARMOR_MATERIAL_BARBUTE, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
	public static final HalfarmorItem HALFARMOR_CHESTPLATE = (HalfarmorItem) new HalfarmorItem("halfarmor_chestplate", ARMOR_MATERIAL_HALFARMOR, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);

	public static final ArmorItem GREATHELM = (ArmorItem) new ArmorItem("greathelm", ARMOR_MATERIAL_CRUSADER, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
	public static final ArmorItem CRUSADER_CHESTPLATE = (ArmorItem) new ArmorItem("crusader_chestplate", ARMOR_MATERIAL_CRUSADER, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
	public static final ArmorItem CRUSADER_LEGGINGS = (ArmorItem) new ArmorItem("crusader_leggings", ARMOR_MATERIAL_CRUSADER, 0, EntityEquipmentSlot.LEGS).setCreativeTab(GROUP_KA);
	public static final ArmorItem CRUSADER_BOOTS = (ArmorItem) new ArmorItem("crusader_boots", ARMOR_MATERIAL_CRUSADER, 0, EntityEquipmentSlot.FEET).setCreativeTab(GROUP_KA);

	public static final KnightItem CEREMONIALARMET = (KnightItem) new KnightItem("ceremonialarmet", ARMOR_MATERIAL_CEREMONIALARMET, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
	public static final KnightItem CEREMONIAL_CHESTPLATE = (KnightItem) new KnightItem("ceremonial_chestplate", ARMOR_MATERIAL_CEREMONIAL, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
	public static final KnightItem CEREMONIAL_BOOTS = (KnightItem) new KnightItem("ceremonial_boots", ARMOR_MATERIAL_CEREMONIAL, 0, EntityEquipmentSlot.FEET).setCreativeTab(GROUP_KA);
	
	public static final ArmorItem COIF = (ArmorItem) new ArmorItem("coif", ARMOR_MATERIAL_GAMBESON, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
	public static final ArmorItem GAMBESON = (ArmorItem) new ArmorItem("gambeson_chestplate", ARMOR_MATERIAL_GAMBESON, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
	public static final ArmorItem PANTYHOSE = (ArmorItem) new ArmorItem("pantyhose", ARMOR_MATERIAL_GAMBESON, 0, EntityEquipmentSlot.LEGS).setCreativeTab(GROUP_KA);
	public static final ArmorItem GAMBESONBOOTS = (ArmorItem) new ArmorItem("gambeson_boots", ARMOR_MATERIAL_GAMBESON, 0, EntityEquipmentSlot.FEET).setCreativeTab(GROUP_KA);
	
	public static final ArmorItem BRIGANDINE = (ArmorItem) new ArmorItem("brigandine_chestplate", ARMOR_MATERIAL_BRIGANDINE, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
	
	public static final ArmorItem NORMAN_HELMET = (ArmorItem) new ArmorItem("norman_helmet", ARMOR_MATERIAL_NORMAN, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);

	public static final ArmorItem SHISHAK = (ArmorItem) new ArmorItem("shishak", ARMOR_MATERIAL_SHISHAK, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);

	public static final HalfarmorItem RUSTEDBARBUTE = new HalfarmorItem("rustedbarbute", ARMOR_MATERIAL_RUSTEDBARBUTE, 0, EntityEquipmentSlot.HEAD);
	public static final HalfarmorItem RUSTEDHALFARMOR_CHESTPLATE = new HalfarmorItem("rustedhalfarmor_chestplate", ARMOR_MATERIAL_RUSTEDHALFARMOR, 0, EntityEquipmentSlot.CHEST);

	public static final ArmorItem RUSTEDGREATHELM = new ArmorItem("rustedgreathelm", ARMOR_MATERIAL_RUSTEDCRUSADER, 0, EntityEquipmentSlot.HEAD);
    public static final ArmorItem RUSTEDCRUSADER_CHESTPLATE = new ArmorItem("rustedcrusader_chestplate", ARMOR_MATERIAL_RUSTEDCRUSADER, 0, EntityEquipmentSlot.CHEST);
    public static final ArmorItem RUSTEDCRUSADER_BOOTS = new ArmorItem("rustedcrusader_boots", ARMOR_MATERIAL_RUSTEDCRUSADER, 0, EntityEquipmentSlot.FEET);

    public static final ArmorItem RUSTEDNORMAN_HELMET = new ArmorItem("rustednorman_helmet", ARMOR_MATERIAL_RUSTEDNORMAN, 0, EntityEquipmentSlot.HEAD);

    public static final ArmorItem RUSTEDCHAINMAIL_HELMET = new ArmorItem("rustedchainmail_helmet", ARMOR_MATERIAL_RUSTEDCHAINMAIL, 0, EntityEquipmentSlot.HEAD);
    public static final ArmorItem RUSTEDCHAINMAIL_CHESTPLATE = new ArmorItem("rustedchainmail_chestplate", ARMOR_MATERIAL_RUSTEDCHAINMAIL, 0, EntityEquipmentSlot.CHEST);
    public static final ArmorItem RUSTEDCHAINMAIL_LEGGINGS = new ArmorItem("rustedchainmail_leggings", ARMOR_MATERIAL_RUSTEDCHAINMAIL, 0, EntityEquipmentSlot.LEGS);
    public static final ArmorItem RUSTEDCHAINMAIL_BOOTS = new ArmorItem("rustedchainmail_boots", ARMOR_MATERIAL_RUSTEDCHAINMAIL, 0, EntityEquipmentSlot.FEET);

    public static final PlatemailItem RUSTEDKETTLEHAT = new PlatemailItem("rustedkettlehat", ARMOR_MATERIAL_RUSTEDKETTLEHAT, 0, EntityEquipmentSlot.HEAD);

	public static final XIVCenturyKnightItem BASCINET = (XIVCenturyKnightItem) new XIVCenturyKnightItem("bascinet", ARMOR_MATERIAL_BASCINET, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
	public static final XIVCenturyKnightItem XIVCENTURYKNIGHT_CHESTPLATE = (XIVCenturyKnightItem) new XIVCenturyKnightItem("xivcenturyknight_chestplate", ARMOR_MATERIAL_XIVCENTURYKNIGHT, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
	public static final XIVCenturyKnightItem XIVCENTURYKNIGHT_LEGGINGS = (XIVCenturyKnightItem) new XIVCenturyKnightItem("xivcenturyknight_leggings", ARMOR_MATERIAL_XIVCENTURYKNIGHT, 0, EntityEquipmentSlot.LEGS).setCreativeTab(GROUP_KA);
	public static final XIVCenturyKnightItem XIVCENTURYKNIGHT_BOOTS = (XIVCenturyKnightItem) new XIVCenturyKnightItem("xivcenturyknight_boots", ARMOR_MATERIAL_XIVCENTURYKNIGHT, 0, EntityEquipmentSlot.FEET).setCreativeTab(GROUP_KA);

    public static final WingedHussarItem WINGEDHUSSAR_CHESTPLATE = (WingedHussarItem) new WingedHussarItem("wingedhussar_chestplate", ARMOR_MATERIAL_WINGEDHUSSARCHESTPLATE, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);

    public static final ArmorItem BURGONET = (ArmorItem) new ArmorItem("cuirassier_helmet", ARMOR_MATERIAL_CUIRASSIER, 0, EntityEquipmentSlot.HEAD).setCreativeTab(GROUP_KA);
    public static final ArmorItem CUIRASSIER_CHESTPLATE = (ArmorItem) new ArmorItem("cuirassier_chestplate", ARMOR_MATERIAL_CUIRASSIER, 0, EntityEquipmentSlot.CHEST).setCreativeTab(GROUP_KA);
    public static final ArmorItem CUIRASSIER_LEGGINGS = (ArmorItem) new ArmorItem("cuirassier_leggings", ARMOR_MATERIAL_CUIRASSIER, 0, EntityEquipmentSlot.LEGS).setCreativeTab(GROUP_KA);
    public static final ArmorItem CUIRASSIER_BOOTS = (ArmorItem) new ArmorItem("cuirassier_boots", ARMOR_MATERIAL_CUIRASSIER, 0, EntityEquipmentSlot.FEET).setCreativeTab(GROUP_KA);

	
	public static final CreativeTabs GROUP_KW = new CreativeTabs(KnightlyArmory.ID + ".weapons")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(flamebladedswords.iron);
		}
	};
	
	public static final CreativeTabs GROUP_KPW = new CreativeTabs(KnightlyArmory.ID + ".particular_weapons")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(NOBLE_SWORD);
		}
	};
	
	public static final CreativeTabs GROUP_KS = new CreativeTabs(KnightlyArmory.ID + ".shields")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(heatershields.iron);
		}
	};
	
	
	
	//Weapons
	public static WeaponItemsStandard stylets = new WeaponItemsStandard(WeaponsFactory.STYLET);
	public static WeaponItemsStandard shortswords = new WeaponItemsStandard(WeaponsFactory.SHORTSWORD);
	public static WeaponItemsStandard katzbalgers = new WeaponItemsStandard(WeaponsFactory.KATZBALGER);
	public static WeaponItemsStandard pikes = new WeaponItemsStandard(WeaponsFactory.PIKE);
	public static WeaponItemsStandard ranseurs = new WeaponItemsStandard(WeaponsFactory.RANSEUR);
	public static WeaponItemsStandard ahlspiesses = new WeaponItemsStandard(WeaponsFactory.AHLSPIESS);
	public static WeaponItemsStandard chivalrylances = new WeaponItemsStandard(WeaponsFactory.CHIVALRYLANCE);
	public static WeaponItemsStandard bastardswords = new WeaponItemsStandard(WeaponsFactory.BASTARDSWORD);
	public static WeaponItemsStandard estocs = new WeaponItemsStandard(WeaponsFactory.ESTOC);
	public static WeaponItemsStandard claymors = new WeaponItemsStandard(WeaponsFactory.CLAYMORE);
	public static WeaponItemsStandard zweihanders = new WeaponItemsStandard(WeaponsFactory.ZWEIHANDER);
	public static WeaponItemsStandard flamebladedswords = new WeaponItemsStandard(WeaponsFactory.FlAMEBLADEDSWORD);
	public static WeaponItemsStandard lochaberaxes = new WeaponItemsStandard(WeaponsFactory.LOCHABERAXE);
	public static WeaponItemsStandard concavehalberds = new WeaponItemsStandard(WeaponsFactory.CONCAVEHALBERD);
	public static WeaponItemsStandard heavymaces = new WeaponItemsStandard(WeaponsFactory.HEAVYMACE);
	public static WeaponItemsStandard heavywarhammers = new WeaponItemsStandard(WeaponsFactory.HEAVYWARHAMMER);
	public static WeaponItemsStandard lucernhammers = new WeaponItemsStandard(WeaponsFactory.LUCERNHAMMER);
	public static WeaponItemsStandard morgensterns = new WeaponItemsStandard(WeaponsFactory.MORGENSTERN);
	public static WeaponItemsStandard chainmorgensterns = new WeaponItemsStandard(WeaponsFactory.CHAINMORGENSTERN);
	public static WeaponItemsStandard guisarmes = new WeaponItemsStandard(WeaponsFactory.GUISARME);
	
	public static ShieldItemsStandard heatershields = new ShieldItemsStandard(ShieldsFactory.HEATERSHIELD);
	public static ShieldItemsStandard targets = new ShieldItemsStandard(ShieldsFactory.TARGET);
	public static ShieldItemsStandard bucklers = new ShieldItemsStandard(ShieldsFactory.BUCKLER);
	public static ShieldItemsStandard rondaches = new ShieldItemsStandard(ShieldsFactory.RONDACHE);
	public static ShieldItemsStandard tartsches = new ShieldItemsStandard(ShieldsFactory.TARTSCHE);
	public static ShieldItemsStandard ellipticalshields = new ShieldItemsStandard(ShieldsFactory.ELLIPTICALSHIELD);
	public static ShieldItemsStandard roundshields = new ShieldItemsStandard(ShieldsFactory.ROUNDSHIELD);
	public static ShieldItemsStandard paveses = new ShieldItemsStandard(ShieldsFactory.PAVESE);
	
	public static final Item BLACKSMITH_HAMMER = new BlacksmithHammerItem("blacksmith_hammer", TOOL_MATERIAL_STEEL, 5.0f, 1.0f, -3.0f, 4).setCreativeTab(GROUP_KPW);
	public static final Item BARBED_CLUB = new MedievalWeaponItem("barbedclub", ToolMaterial.IRON, 5.6f, 1.1f, -3.0f).setCreativeTab(GROUP_KPW);
	public static final Item PITCHFORK = new MedievalWeaponItem("pitchfork", ToolMaterial.IRON, 2.8f, 1.0f, -3.0f, 0, 1.0f).setTwoHanded(2).setCreativeTab(GROUP_KPW);
	public static final Item NOBLE_SWORD = new MedievalWeaponItem("noble_sword", ToolMaterial.IRON, 4.25f, 1.0f, -2.49f).setTwoHanded(1).setBlocking(5.0f, 6.0f).setCreativeTab(GROUP_KPW);
	public static final Item RUSTEDBASTARDSWORD = new MedievalWeaponItem("rusted_bastardsword", ToolMaterial.IRON, 2.0F, 1.0F, -2.49F).setTwoHanded(1).setBlocking(4.0f, 6.0f);
	public static final Item RUSTEDHEAVYMACE = new MedievalWeaponItem("rusted_heavymace", ToolMaterial.IRON, 2.0F, 1.0F, -2.49F);

	public static class ShieldItemsStandard
	{
		public ItemShield wood;
		public ItemShield stone;
		public ItemShield iron;
		public ItemShield gold;
		public ItemShield diamond;
		
		public ItemShield copper;
		public ItemShield steel;
		public ItemShield silver;
		public ItemShield tin;
		public ItemShield bronze;
		
		
		
		public ShieldItemsStandard(BiFunction<ToolMaterial, String, ItemShield> factory) 
		{
			
			this.wood = (ItemShield) factory.apply(ToolMaterial.WOOD, "wood").setCreativeTab(GROUP_KS);
			this.stone = (ItemShield) factory.apply(ToolMaterial.STONE, "stone").setCreativeTab(GROUP_KS);
			this.iron = (ItemShield) factory.apply(ToolMaterial.IRON, "iron").setCreativeTab(GROUP_KS);
			this.gold = (ItemShield) factory.apply(ToolMaterial.GOLD, "gold").setCreativeTab(GROUP_KS);
			this.diamond = (ItemShield) factory.apply(ToolMaterial.DIAMOND, "diamond").setCreativeTab(GROUP_KS);
			
			this.copper = (ItemShield) factory.apply(TOOL_MATERIAL_COPPER, "copper").setCreativeTab(GROUP_KS);
			this.steel = (ItemShield) factory.apply(TOOL_MATERIAL_STEEL, "steel").setCreativeTab(GROUP_KS);
			this.silver = (ItemShield) factory.apply(TOOL_MATERIAL_SILVER, "silver").setCreativeTab(GROUP_KS);
			this.tin = (ItemShield) factory.apply(TOOL_MATERIAL_TIN, "tin").setCreativeTab(GROUP_KS);
			this.bronze = (ItemShield) factory.apply(TOOL_MATERIAL_BRONZE, "bronze").setCreativeTab(GROUP_KS);
		}
		
		public void registerItems(IForgeRegistry<Item> reg) 
		{
			Item[] shieldStandard = new Item[] { (Item)this.wood, (Item)this.stone, (Item)this.iron, (Item)this.gold, (Item)this.diamond, (Item)this.copper, (Item)this.steel, (Item)this.silver, (Item)this.tin, (Item)this.bronze };
			reg.registerAll(shieldStandard);
			
			for(Item item : shieldStandard)
			{
				if(item instanceof IHasModel)
				{
					((IHasModel)item).registerModels();
				}
				
				KnightlyArmory.PROXY.registerHeraldyItemStackRenderer(item);
			}
		}
	}
	
	public static class WeaponItemsStandard
	{
		public ItemSword wood;
		public ItemSword stone;
		public ItemSword iron;
		public ItemSword gold;
		public ItemSword diamond;
		
		public ItemSword copper;
		public ItemSword steel;
		public ItemSword silver;
		public ItemSword tin;
		public ItemSword bronze;
		
		
		public WeaponItemsStandard(BiFunction<ToolMaterial, String, ItemSword> factory) 
		{
			
			this.wood = (ItemSword) factory.apply(ToolMaterial.WOOD, "wood").setCreativeTab(GROUP_KW);
			this.stone = (ItemSword) factory.apply(ToolMaterial.STONE, "stone").setCreativeTab(GROUP_KW);
			this.iron = (ItemSword) factory.apply(ToolMaterial.IRON, "iron").setCreativeTab(GROUP_KW);
			this.gold = (ItemSword) factory.apply(ToolMaterial.GOLD, "gold").setCreativeTab(GROUP_KW);
			this.diamond = (ItemSword) factory.apply(ToolMaterial.DIAMOND, "diamond").setCreativeTab(GROUP_KW);
			
			this.copper = (ItemSword) factory.apply(TOOL_MATERIAL_COPPER, "copper").setCreativeTab(GROUP_KW);
			this.steel = (ItemSword) factory.apply(TOOL_MATERIAL_STEEL, "steel").setCreativeTab(GROUP_KW);
			this.silver = (ItemSword) factory.apply(TOOL_MATERIAL_SILVER, "silver").setCreativeTab(GROUP_KW);
			this.tin = (ItemSword) factory.apply(TOOL_MATERIAL_TIN, "tin").setCreativeTab(GROUP_KW);
			this.bronze = (ItemSword) factory.apply(TOOL_MATERIAL_BRONZE, "bronze").setCreativeTab(GROUP_KW);

		}
		
		public void registerItems(IForgeRegistry<Item> reg) 
		{
			Item[] weaponStandard = new Item[] { (Item)this.wood, (Item)this.stone, (Item)this.iron, (Item)this.gold, (Item)this.diamond, (Item)this.copper, (Item)this.steel, (Item)this.silver, (Item)this.tin, (Item)this.bronze };
			reg.registerAll(weaponStandard);
			
			for(Item item : weaponStandard)
			{
				if(item instanceof IHasModel)
				{
					((IHasModel)item).registerModels();
				}
			}
		}
	}

	public static final Item[] items = new Item[] {
			STEEL_INGOT,
			STEEL_NUGGET,
			STEEL_PLATE,
			STEEL_RING,
			STEEL_CHAINMAIL,
			LEATHER_STRIP,
			HILT,
			POLE,
			STEEL_CHAIN,
			WOOLEN_FABRIC,
			APOSTOLIC_CROSS_PATTERN,
			BOWL_PATTERN,
			BULL_PATTERN,
			CHESS_PATTERN,
			CRUSADER_CROSS_PATTERN,
			DRAGON_PATTERN,
			EAGLE_PATTERN,
			HORSE_PATTERN,
			LILY_PATTERN,
			LION1_PATTERN,
			LION2_PATTERN,
			ORTHODOX_CROSS_PATTERN,
			SNAKE_PATTERN,
			SUN_PATTERN,
			SWORDS_PATTERN,
			TOWER_PATTERN,
			TREE_PATTERN,
			TWOHEADED_EAGLE_PATTERN,
			BLACKSMITH_HAMMER, 
			ARMET, 
			KNIGHT_CHESTPLATE, 
			KNIGHT_LEGGINGS, 
			KNIGHT_BOOTS, 
			STECHHELM, 
			JOUSTING_CHESTPLATE, 
			JOUSTING_LEGGINGS, 
			JOUSTING_BOOTS, 
			SALLET, 
			GOTHIC_CHESTPLATE, 
			GOTHIC_LEGGINGS, 
			GOTHIC_BOOTS, 
			MAXIMILIAN_HELMET, 
			MAXIMILIAN_CHESTPLATE, 
			MAXIMILIAN_LEGGINGS, 
			MAXIMILIAN_BOOTS, 
			CHAINMAIL_HELMET, 
			CHAINMAIL_CHESTPLATE, 
			CHAINMAIL_LEGGINGS, 
			CHAINMAIL_BOOTS, 
			KETTLEHAT, 
			PLATEMAIL_CHESTPLATE, 
			PLATEMAIL_LEGGINGS, 
			PLATEMAIL_BOOTS, 
			BARBUTE, 
			HALFARMOR_CHESTPLATE,
			GREATHELM,
			CRUSADER_CHESTPLATE,
			CRUSADER_LEGGINGS,
			CRUSADER_BOOTS,
			BARBED_CLUB,
			PITCHFORK,
			NOBLE_SWORD,
			RUSTEDBASTARDSWORD,
			RUSTEDHEAVYMACE,
			BARBUTE,
			HALFARMOR_CHESTPLATE,
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
	
	static IRecipe recipesShieldHeraldy = new RecipesShieldHeraldy();
	static IRecipe recipesStandards = new RecipesShieldHeraldy();
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> ev)
	{
		IForgeRegistry<Item> reg = ev.getRegistry();
		
		//Armor and ingridients
		reg.registerAll(items);
		
		//Forge tags
		OreDictionary.registerOre("ingotSteel", STEEL_INGOT);
		OreDictionary.registerOre("nuggetSteel", STEEL_NUGGET);
		OreDictionary.registerOre("plateSteel", STEEL_PLATE);
		
		//Smelting Recipes
		if (ModConfigurations.steel_enabled)
		{
			GameRegistry.addSmelting(new ItemStack(Items.IRON_INGOT), new ItemStack(STEEL_INGOT), 0.1f);
		}
		
		//Weapons
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

		//Shields
		heatershields.registerItems(reg);
		targets.registerItems(reg);
		bucklers.registerItems(reg);
		rondaches.registerItems(reg);
		tartsches.registerItems(reg);
		ellipticalshields.registerItems(reg);
		roundshields.registerItems(reg);
		paveses.registerItems(reg);
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerRecipes(RegistryEvent.Register<IRecipe> ev)
	{
		ev.getRegistry().register(recipesShieldHeraldy);
		ev.getRegistry().register(recipesStandards);
	}
}