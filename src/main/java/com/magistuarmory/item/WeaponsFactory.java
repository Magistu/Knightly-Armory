package com.magistuarmory.item;

import java.util.function.BiFunction;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.obj.OBJModel.Material;

public class WeaponsFactory
{
	public static final BiFunction<ToolMaterial, String, ItemSword> STYLET;
	public static final BiFunction<ToolMaterial, String, ItemSword> SHORTSWORD;
	public static final BiFunction<ToolMaterial, String, ItemSword> KATZBALGER;
	public static final BiFunction<ToolMaterial, String, ItemSword> PIKE;
	public static final BiFunction<ToolMaterial, String, ItemSword> RANSEUR;
	public static final BiFunction<ToolMaterial, String, ItemSword> AHLSPIESS;
	public static final BiFunction<ToolMaterial, String, ItemSword> CHIVALRYLANCE;
	public static final BiFunction<ToolMaterial, String, ItemSword> BASTARDSWORD;
	public static final BiFunction<ToolMaterial, String, ItemSword> ESTOC;
	public static final BiFunction<ToolMaterial, String, ItemSword> CLAYMORE;
	public static final BiFunction<ToolMaterial, String, ItemSword> ZWEIHANDER;
	public static final BiFunction<ToolMaterial, String, ItemSword> FlAMEBLADEDSWORD;
	public static final BiFunction<ToolMaterial, String, ItemSword> LOCHABERAXE;
	public static final BiFunction<ToolMaterial, String, ItemSword> CONCAVEHALBERD;
	public static final BiFunction<ToolMaterial, String, ItemSword> HEAVYMACE;
	public static final BiFunction<ToolMaterial, String, ItemSword> HEAVYWARHAMMER;
	public static final BiFunction<ToolMaterial, String, ItemSword> LUCERNHAMMER;
	public static final BiFunction<ToolMaterial, String, ItemSword> MORGENSTERN;
	public static final BiFunction<ToolMaterial, String, ItemSword> CHAINMORGENSTERN;
	public static final BiFunction<ToolMaterial, String, ItemSword> GUISARME;

	static
	{
		STYLET = ((material, material_name) -> new MedievalWeaponItem(material_name + "_stylet", material, 2.0f, 1.0f, getAttackSpeed(1.6f, material, 0.0f), 20, 0.0f));
		SHORTSWORD = ((material, material_name) -> new MedievalWeaponItem(material_name + "_shortsword", material, 2.5f, 1.0f, getAttackSpeed(1.7f, material, 0.0f)));
		KATZBALGER = ((material, material_name) -> new MedievalWeaponItem(material_name + "_katzbalger", material, 3.0f, 1.0f, getAttackSpeed(1.65f, material, 0.0f)));
		PIKE = ((material, material_name) -> (new MedievalWeaponItem(material_name + "_pike", material, 3.0f, 1.0f, getAttackSpeed(1.07f, material, 0.0f), 0, 1.2f)).setTwoHanded(2));
		RANSEUR = ((material, material_name) -> (new MedievalWeaponItem(material_name + "_ranseur", material, 3.1f, 1.0f, getAttackSpeed(1.07f, material, 0.0f), 0, 1.0f)).setTwoHanded(1).setBlocking(3.0f, 3.0f));
		AHLSPIESS = ((material, material_name) -> (new MedievalWeaponItem(material_name + "_ahlspiess", material, 4.0f, 1.0f, getAttackSpeed(1.28f, material, 0.02f), 18, 0.5f)).setTwoHanded(2).setBlocking(6.0f, 3.0f));
		CHIVALRYLANCE = ((material, material_name) -> (new LanceItem(material_name + "_chivalrylance", material, 2.5f, 1.0f, getAttackSpeed(0.84f, material, 0.0f), 10, 1.0f)).setTwoHanded(2));
		BASTARDSWORD = ((material, material_name) -> new MedievalWeaponItem(material_name + "_bastardsword", material, 4.25f, 1.0f, getAttackSpeed(1.55f, material, 0.02f)).setTwoHanded(1).setBlocking(6.0f, 5.0f));
		ESTOC = ((material, material_name) -> new MedievalWeaponItem(material_name + "_estoc", material, 4.0f, 1.0f, getAttackSpeed(1.45f, material, 0.0f), 3, 0.2f).setTwoHanded(1).setBlocking(4.0f, 5.0f));
		CLAYMORE = ((material, material_name) -> new MedievalWeaponItem(material_name + "_claymore", material, 4.4f, 1.0f, getAttackSpeed(1.45f, material, 0.0f)).setTwoHanded(1).setBlocking(5.0f, 5.0f));
		ZWEIHANDER = ((material, material_name) -> (new MedievalWeaponItem(material_name + "_zweihander", material, 6.6f, 1.0f, getAttackSpeed(1.15f, material, 0.05f), 4, 0.4f)).setTwoHanded(2).setBlocking(7.0f, 6.0f));
		FlAMEBLADEDSWORD = ((material, material_name) -> (new MedievalWeaponItem(material_name + "_flamebladedsword", material, 6.5f, 1.0f, getAttackSpeed(1.15f, material, 0.05f), 4, 0.4f)).setTwoHanded(2).setFlamebladed().setBlocking(7.0f, 6.0f));
		LOCHABERAXE = ((material, material_name) -> (new MedievalWeaponItem(material_name + "_lochaberaxe", material, 8.0f, 1.0f, getAttackSpeed(1.0f, material, 0.05f), 0, 0.5f)).setTwoHanded(1).setBlocking(5.0f, 3.0f));
		CONCAVEHALBERD = ((material, material_name) -> (new MedievalWeaponItem(material_name + "_concavehalberd", material, 9.5f, 1.0f, getAttackSpeed(0.9f, material, 0.05f), 2, 0.5f)).setTwoHanded(2).setBlocking(10.0f, 3.0f));
		HEAVYMACE = ((material, material_name) -> new MedievalWeaponItem(material_name + "_heavymace", material, 4.5f, 1.0f, getAttackSpeed(1.15f, material, 0.05f), 11, 0.0f));
		HEAVYWARHAMMER = ((material, material_name) -> new MedievalWeaponItem(material_name + "_heavywarhammer", material, 5.2f, 1.0f, getAttackSpeed(1.05f, material, 0.05f), 13, 0.0f));
		LUCERNHAMMER = ((material, material_name) -> (new MedievalWeaponItem(material_name + "_lucernhammer", material, 4.6f, 1.0f, getAttackSpeed(1.1f, material, 0.05f), 16, 0.0f)).setTwoHanded(1));
		MORGENSTERN = ((material, material_name) -> new MedievalWeaponItem(material_name + "_morgenstern", material, 5.0f, 1.0f, getAttackSpeed(1.25f, material, 0.05f)));
		CHAINMORGENSTERN = ((material, material_name) -> new MedievalWeaponItem(material_name + "_chainmorgenstern", material, 6.2f, 1.0f, getAttackSpeed(1.0f, material, 0.05f)));
		GUISARME = ((material, material_name) -> (new MedievalWeaponItem(material_name + "_guisarme", material, 3.15f, 1.0f, getAttackSpeed(1.02f, material, 0.0f), 0, 0.8f)).setTwoHanded(1).setBlocking(3.0f, 3.0f));

	}
	
	public static float getAttackSpeed(float attackSpeed, ToolMaterial material, float f) 
	{
		return -material.getHarvestLevel() * f + attackSpeed - 4;
	}
}
