package com.magistuarmory.config;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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
            this.impact_factor = 1.0F;
        }

        public String getName()
        {
            return this.name;
        }
    }

    Weapon[] weapons = new Weapon[]
            { new Weapon("stylet", 0.2F, 1.0F, 0.2F, 1, "DAGGER", 0.0F, 0.0F), new Weapon("katzbalger", 0.0F, 1.0F, 0.2F, 2, "SWORD", 0.0F), new Weapon("pike", 0.0F, 1.1F, 0.3F, 1, "SPEAR", 0.01F), new Weapon("ranseur", 0.0F, 1.1F, 0.5F, 2, "SPEAR", 0.02F), new Weapon("ahlspiess", 0.18F, 1.2F, 0.55F, 1, "SPEAR", 0.02F), new Weapon("chivalrylance", 0.1F, 2.4F, 0.4F, 1, "SPEAR", 0.04F), new Weapon("bastardsword", 0.0F, 1.2F, 0.4F, 3, "LONGSWORD", 0.01F), new Weapon("estoc", 0.03F, 1.3F, 0.3F, 2, "LONGSWORD", 0.01F), new Weapon("claymore", 0.0F, 1.3F, 0.4F, 3, "LONGSWORD", 0.01F), new Weapon("zweihander", 0.04F, 2.2F, 0.4F, 4, "GREATSWORD", 0.04F),  new Weapon("flamebladedsword", 0.04F, 2.2F, 0.4F, 4, "GREATSWORD", 0.02F), new Weapon("lochaberaxe", 0.0F, 2.1F, 0.4F, 3, "SPEAR", 0.02F), new Weapon("concavehalberd", 0.02F, 2.3F, 0.5F, 4, "SPEAR", 0.03F), new Weapon("heavymace", 0.11F, 2.0F, 0.6F, 2, "AXE", 0.03F), new Weapon("heavywarhammer", 0.12F, 1.9F, 0.5F, 2, "AXE", 0.04F), new Weapon("lucernhammer", 0.16F, 1.8F, 0.5F, 2, "AXE", 0.04F), new Weapon("morgenstern", 0.0F, 1.9F, 0.6F, 2, "AXE", 0.01F), new Weapon("chainmorgenstern", 0.0F, 2.1F, 0.8F, 2, "AXE", 0.01F), new Weapon("guisarme", 0.0F, 0.9F, 0.5F, 3, "SPEAR", 0.02F) };

    Weapon[] particular_weapons = new Weapon[]
            { new Weapon("noble_sword", 0.03F, 1.2F, 0.4F, 3, "SWORD", 0.01F), new Weapon("barbedclub", 0.0F, 2.2F, 0.7F, 2, "AXE", 0.01F), new Weapon("pitchfork", 0.02F, 1.1F, 0.3F, 1, "SPEAR", 0.01F), new Weapon("blacksmith_hammer", 0.04F, 1.9F, 0.5F, 2, "AXE", 0.04F) };

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

    Material[] materials = new Material[]
            { new Material("wood", 0.0F, 0.8F), new Material("stone", 1.0F, 0.7F), new Material("iron", 2.0F, 1.0F), new Material("diamond", 3.0F, 1.2F), new Material("gold", 4.0F, 0.8F), new Material("netherite", 5.0F, 1.0F), new Material("silver", 2.0F, 1.0F), new Material("copper", 1.0F, 1.0F), new Material("steel", 2.0F, 1.1F) };

    public String generateWeaponConfig()
    {
        String configText = "[custom_weaponry]\n";
        for (Weapon weapon : this.weapons)
        {
            for (Material material : this.materials)
            {
                String weapon_name = material.name + "_" + weapon.name;
                float weapon_armor_ignorance = roundSig(getArmorIgnorance(material.density, material
                        .hardness, weapon
                        .penetrate_factor, weapon
                        .armor_ignorance));
                float weapon_impact = roundSig(getImpact(material.density, weapon
                        .size, weapon
                        .impact_factor, weapon
                        .impact));
                configText = configText + "    [custom_weaponry." + weapon_name + "]\n        armor_ignorance = " + weapon_armor_ignorance + "\n        hit_at_once = " + weapon.hit_at_once + "\n        impact = " + weapon_impact + "\n        weapon_type = \"" + weapon.weapon_type + "\"\n        registry_name = \"" + "magistuarmory" + ":" + weapon_name + "\"\n\n";
            }
        }
        for (Weapon weapon : this.particular_weapons)
        {
            Material material = this.materials[3];
            String weapon_name = weapon.name;
            float weapon_armor_ignorance = roundSig(getArmorIgnorance(material.density, material
                    .hardness, weapon
                    .penetrate_factor, weapon
                    .armor_ignorance));
            float weapon_impact = roundSig(getImpact(material.density, weapon
                    .size, weapon
                    .impact_factor, weapon
                    .impact));
            configText = configText + "    [custom_weaponry." + weapon_name + "]\n        armor_ignorance = " + weapon_armor_ignorance + "\n        hit_at_once = " + weapon.hit_at_once + "\n        impact = " + weapon_impact + "\n        weapon_type = \"" + weapon.weapon_type + "\"\n        registry_name = \"" + "magistuarmory" + ":" + weapon_name + "\"\n\n";
        }
        return configText;
    }

    public String generateArmorConfig()
    {
        String configText = "[custom_armor]\n";
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
        return 100.0F * d * h * f + b;
    }

    float getImpact(float d, float s, float f, float b)
    {
        return d * s * f + b;
    }
}
