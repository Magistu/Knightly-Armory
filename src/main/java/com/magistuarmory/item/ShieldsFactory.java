package com.magistuarmory.item;

import java.util.function.BiFunction;

import com.magistuarmory.client.renderer.model.item.HeaterShieldModel;
import com.magistuarmory.client.renderer.model.item.EllipticalShieldModel;
import com.magistuarmory.client.renderer.model.item.PaveseModel;
import com.magistuarmory.client.renderer.model.item.RondacheModel;
import com.magistuarmory.client.renderer.model.item.RoundShieldModel;
import com.magistuarmory.client.renderer.model.item.TartscheModel;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.obj.OBJModel.Material;

public class ShieldsFactory
{
	public static final BiFunction<ToolMaterial, String, ItemShield> HEATERSHIELD;
	public static final BiFunction<ToolMaterial, String, ItemShield> TARGET;
	public static final BiFunction<ToolMaterial, String, ItemShield> BUCKLER;
	public static final BiFunction<ToolMaterial, String, ItemShield> RONDACHE;
	public static final BiFunction<ToolMaterial, String, ItemShield> TARTSCHE;
	public static final BiFunction<ToolMaterial, String, ItemShield> ELLIPTICALSHIELD;
	public static final BiFunction<ToolMaterial, String, ItemShield> ROUNDSHIELD;
	public static final BiFunction<ToolMaterial, String, ItemShield> PAVESE;


	static
	{
		HEATERSHIELD = ((material, material_name) -> (new MedievalShieldItem("heatershield", material_name, material, getDurability(material, 300, 0.5f), 4, 10, true)).setModel(new HeaterShieldModel()));
		TARGET = ((material, material_name) -> (new MedievalShieldItem("target", material_name, material, getDurability(material, 300, 0.5f), 1, 6, false)).setRepairItem(material.getRepairItemStack().getItem()));
		BUCKLER = ((material, material_name) -> (new MedievalShieldItem("buckler", material_name, material, getDurability(material, 300, 0.5f), 1, 6, false)).setRepairItem(material.getRepairItemStack().getItem()));
		RONDACHE = ((material, material_name) -> (new MedievalShieldItem("rondache", material_name, material, getDurability(material, 400, 1.0f), 6, 13, false)).setModel(new RondacheModel()).setRepairItem(material.getRepairItemStack().getItem()));
		TARTSCHE = ((material, material_name) -> (new MedievalShieldItem("tartsche", material_name, material, getDurability(material, 300, 0.5f), 4, 10, true)).setModel(new TartscheModel()));
		ELLIPTICALSHIELD = ((material, material_name) -> (new MedievalShieldItem("ellipticalshield", material_name, material, getDurability(material, 320, 0.5f), 5, 10, true)).setModel(new EllipticalShieldModel()));
		ROUNDSHIELD = ((material, material_name) -> (new MedievalShieldItem("roundshield", material_name, material, getDurability(material, 300, 0.5f), 3, 7, true)).setModel(new RoundShieldModel()));
		PAVESE = ((material, material_name) -> (new MedievalShieldItem("pavese", material_name, material, getDurability(material, 400, 0.5f), 10, 17, true)).setModel(new PaveseModel()));
		
	}


	private static int getDurability(ToolMaterial material, int baseDuration, float materialFactor) 
	{
		return (int) (baseDuration + materialFactor * material.getMaxUses());
	}
}
