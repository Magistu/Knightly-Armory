package com.magistuarmory.item;

import java.util.function.BiFunction;

import com.magistuarmory.client.renderer.model.item.HeaterShieldModel;
import com.magistuarmory.client.renderer.model.item.EllipticalShieldModel;
import com.magistuarmory.client.renderer.model.item.PaveseModel;
import com.magistuarmory.client.renderer.model.item.RondacheModel;
import com.magistuarmory.client.renderer.model.item.RoundShieldModel;
import com.magistuarmory.client.renderer.model.item.TartscheModel;

import net.minecraft.item.Item.Properties;
import net.minecraft.item.ShieldItem;


public class ShieldsWorkshop
{
    public static final BiFunction<ModItemTier, Properties, ShieldItem> HEATERSHIELD;
    public static final BiFunction<ModItemTier, Properties, ShieldItem> TARGET;
    public static final BiFunction<ModItemTier, Properties, ShieldItem> BUCKLER;
    public static final BiFunction<ModItemTier, Properties, ShieldItem> RONDACHE;
    public static final BiFunction<ModItemTier, Properties, ShieldItem> TARTSCHE;
    public static final BiFunction<ModItemTier, Properties, ShieldItem> ELLIPTICALSHIELD;
    public static final BiFunction<ModItemTier, Properties, ShieldItem> ROUNDSHIELD;
    public static final BiFunction<ModItemTier, Properties, ShieldItem> PAVESE;
    public static final BiFunction<ModItemTier, Properties, ShieldItem> KITESHIELD;


    static
    {
        HEATERSHIELD = ((material, prop) -> (new MedievalShieldItem("heatershield", prop, material, getDurability(material, 350, 0.8f), 4, 10, true)));
        TARGET = ((material, prop) -> (new MedievalShieldItem("target", prop, material, getDurability(material, 350, 0.8f), 1, 6, false)));
        BUCKLER = ((material, prop) -> (new MedievalShieldItem("buckler", prop, material, getDurability(material, 350, 0.8f), 1, 6, false)));
        RONDACHE = ((material, prop) -> (new MedievalShieldItem("rondache", prop, material, getDurability(material, 420, 1.2f), 6, 13, false)).setRepairItem(() -> { return material.getRepairIngredient(); }));
        TARTSCHE = ((material, prop) -> (new MedievalShieldItem("tartsche", prop, material, getDurability(material, 350, 0.8f), 4, 10, true)));
        ELLIPTICALSHIELD = ((material, prop) -> (new MedievalShieldItem("ellipticalshield", prop, material, getDurability(material, 370, 0.8f), 5, 10, true)));
        ROUNDSHIELD = ((material, prop) -> (new MedievalShieldItem("roundshield", prop, material, getDurability(material, 350, 0.8f), 3, 7, true)));
        PAVESE = ((material, prop) -> (new MedievalShieldItem("pavese", prop, material, getDurability(material, 450, 0.7f), 10, 17, true)));
        KITESHIELD = ((material, prop) -> (new MedievalShieldItem("kiteshield", prop, material, getDurability(material, 370, 0.8f), 5, 10, true)));

    }


    private static int getDurability(ModItemTier material, int baseDuration, float materialFactor)
    {
        return (int) (baseDuration + materialFactor * material.getUses());
    }
}
