package com.magistuarmory.config;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import com.magistuarmory.KnightlyArmory;

public class EpicConfigBuilder 
{
	
	
	public class Weapon
	{
	    private String name;
		private float armor_ignorance;
		private float impact;
		private float size;
		private int hit_at_once;
		private String weapon_type;
		private float penetrate_factor;
		private float impact_factor;
		
		Weapon(String name, float armor_ignorance, float impact, float size, int hit_at_once, String weapon_type, float penetrate_factor, float impact_factor)
	    {
			this(name, armor_ignorance, impact, size, hit_at_once, weapon_type, penetrate_factor);
	        this.impact_factor = impact_factor;
	    }

		Weapon(String name, float armor_ignorance, float impact, float size, int hit_at_once, String weapon_type, float penetrate_factor)
	    {
	        this.name = name;
	        this.armor_ignorance = armor_ignorance;
	        this.impact = impact;
	        this.size = size;
	        this.hit_at_once = hit_at_once;
	        this.weapon_type = weapon_type;
	        this.penetrate_factor = penetrate_factor;
	        this.impact_factor = 1.0f;
	    }

		String getName()
		{
			return name;
		}
	}
	
	
	Weapon[] weapons = { new Weapon("stylet", 0.2f, 1.0f, 0.2f, 1, "HOE", 0.0f, 0.0f),
	           			 new Weapon("katzbalger", 0.0f, 1.0f, 0.2f, 2, "SWORD", 0.0f),
	           			 new Weapon("shortsword", 0.0f, 1.0f, 0.2f, 2, "SWORD", 0.0f),
	           			 new Weapon("pike", 0.02f, 1.1f, 0.3f, 1, "SPEAR", 0.01f),
	           			 new Weapon("ranseur", 0.04f, 1.1f, 0.5f, 2, "SPEAR", 0.02f),
	           			 new Weapon("ahlspiess", 0.18f, 1.2f, 0.55f, 1, "SPEAR", 0.02f),
	           			 new Weapon("chivalrylance", 0.04f, 2.4f, 0.4f, 1, "SPEAR", 0.04f),
	           			 new Weapon("bastardsword", 0.03f, 1.2f, 0.4f, 3, "SWORD", 0.01f),
	           			 new Weapon("estoc", 0.07f, 1.3f, 0.3f, 2, "SWORD", 0.01f),
	           			 new Weapon("claymore", 0.03f, 1.3f, 0.4f, 3, "SWORD", 0.01f),
	           			 new Weapon("zweihander", 0.02f, 2.2f, 0.4f, 4, "GREATSWORD", 0.04f),
	           			 new Weapon("flamebladedsword", 0.04f, 2.2f, 0.4f, 4, "GREATSWORD", 0.02f),
	           			 new Weapon("lochaberaxe", 0.04f, 2.1f, 0.4f, 3, "SPEAR", 0.02f),
	           			 new Weapon("concavehalberd", 0.06f, 2.3f, 0.5f, 4, "SPEAR", 0.03f),
	           			 new Weapon("heavymace", 0.08f, 2.0f, 0.6f, 2, "AXE", 0.03f),
	           			 new Weapon("heavywarhammer", 0.08f, 1.9f, 0.5f, 2, "AXE", 0.04f),
	           			 new Weapon("lucernhammer", 0.1f, 1.8f, 0.5f, 2, "AXE", 0.04f),
	           			 new Weapon("morgenstern", 0.0f, 1.9f, 0.6f, 2, "AXE", 0.01f),
	           			 new Weapon("chainmorgenstern", 0.0f, 2.1f, 0.8f, 2, "AXE", 0.01f),
	           			 new Weapon("guisarme", 0.04f, 0.9f, 0.5f, 3, "SPEAR", 0.02f),};
	
	Weapon[] particular_weapons = { 
						 new Weapon("noble_sword", 0.03f, 1.2f, 0.4f, 3, "SWORD", 0.01f),
						 new Weapon("barbedclub", 0.0f, 2.2f, 0.7f, 2, "AXE", 0.01f),
						 new Weapon("pitchfork", 0.02f, 1.1f, 0.3f, 1, "SPEAR", 0.01f),
						 new Weapon("blacksmith_hammer", 0.04f, 1.9f, 0.5f, 2, "AXE", 0.04f),
						 new Weapon("rusted_bastardsword", 0.03f, 1.2f, 0.4f, 3, "LONGSWORD", 0.01f),
			  			 new Weapon("rusted_heavymace", 0.04f, 1.9f, 0.5f, 2, "AXE", 0.04f)};
	
	
	public class Armor
	{
		private String name;
		private float stunArmor;
		private float weight;

		Armor(String name, float stunArmor, float weight)
		{
			this.name = name;
			this.stunArmor = stunArmor;
			this.weight = weight;
		}
	}
	
	public class Material
	{
	    private String name;
		private float density;
		private float hardness;

		Material(String name, float density, float hardness)
	    {
	        this.name = name;
	        this.density = density;
	        this.hardness = hardness;
	    }
	}
	
	
	Material[] materials = { new Material("wood", 0f, 0.8f),
	             			 new Material("stone", 1f, 0.7f),
	             			 new Material("iron", 2f, 1.0f),
	             			 new Material("diamond", 3f, 1.2f),
	             			 new Material("gold", 4f, 0.8f),
	             			 new Material("silver", 2f, 1.0f),
	             			 new Material("copper", 1f, 1.0f),
	             			 new Material("steel", 2f, 1.1f),
							 new Material("tin", 0.8f, 1.0f),
	             			 new Material("bronze", 2f, 1.0f) };
	
	
	public String generateWeaponConfig()
	{
		String configText = "custom_weaponry {\n";
		
		
		for (Weapon weapon : weapons)
		{
		    for (Material material : materials)
		    {
		        String weapon_name = material.name + "_" + weapon.name;
		        float weapon_armor_ignorance = roundSig(getArmorIgnorance(material.density,
			                                                              material.hardness,
			                                                              weapon.penetrate_factor,
			                                                              weapon.armor_ignorance));
		        float weapon_impact = roundSig(getImpact(material.density,
			                                             weapon.size, 
			                                             weapon.impact_factor, 
			                                             weapon.impact));
		
		        configText += "        custom_weaponry." + weapon_name + " {\n" + 
		                	  "            D:armor_negation=" + weapon_armor_ignorance + "\n" + 
 		                	  "            D:impact=" + weapon_impact + "\n" + 
		                	  "            I:max_strikes=" + weapon.hit_at_once + "\n" + 
		                	  "            S:registry_name=" + KnightlyArmory.ID + ":" + (String)(weapon_name) + "\n" +
		                	  "            S:weapon_type=" + weapon.weapon_type + "\n        }\n\n";

		    }
		}
		for (Weapon weapon : particular_weapons)
		{
			Material material = materials[3];
			String weapon_name = weapon.name;
	        float weapon_armor_ignorance = roundSig(getArmorIgnorance(material.density,
		                                                              material.hardness,
		                                                              weapon.penetrate_factor,
		                                                              weapon.armor_ignorance));
	        float weapon_impact = roundSig(getImpact(material.density,
		                                             weapon.size, 
		                                             weapon.impact_factor, 
		                                             weapon.impact));
	
	        configText += "        custom_weaponry." + weapon_name + " {\n" + 
	                	  "            D:armor_negation=" + weapon_armor_ignorance + "\n" + 
		                	  "            D:impact=" + weapon_impact + "\n" + 
	                	  "            I:max_strikes=" + weapon.hit_at_once + "\n" + 
	                	  "            S:registry_name=" + KnightlyArmory.ID + ":" + (String)(weapon_name) + "\n" +
	                	  "            S:weapon_type=" + weapon.weapon_type + "\n        }\n\n";
		}
		return configText;
	}
	
	public String generateArmorConfig() {
		String configText = "custom_armor {\n";
		return configText;
	}
	
	
	float roundSig(float value)
	{
		return roundSig(value, 3);
	}
	
	float roundSig(float value, int sig)
	{
		MathContext context = new MathContext(sig, RoundingMode.HALF_UP);
		BigDecimal result = new BigDecimal(value, context);
		
		return result.floatValue();
	}
	
	float getArmorIgnorance(float d, float h, float f, float b)
	{
	    return 100 * d * h * f + b;
	}
	
	float getImpact(float d, float s, float f, float b)
	{
	    return d * s * f + b;
	}
}