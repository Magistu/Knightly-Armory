package com.magistuarmory.item;

import java.util.function.BiFunction;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class WeaponsWorkshop
{
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> STYLET;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> SHORTSWORD;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> KATZBALGER;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> PIKE;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> RANSEUR;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> AHLSPIESS;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> CHIVALRYLANCE;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> BASTARDSWORD;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> ESTOC;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> CLAYMORE;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> ZWEIHANDER;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> FlAMEBLADEDSWORD;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> LOCHABERAXE;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> CONCAVEHALBERD;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> HEAVYMACE;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> HEAVYWARHAMMER;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> LUCERNHAMMER;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> MORGENSTERN;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> CHAINMORGENSTERN;
    public static final BiFunction<ModItemTier, Item.Properties, SwordItem> GUISARME;

    static
    {
        STYLET = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_stylet", modifyDurability(prop, material, 1.0f), material, 2.0f, 1.0f, getAttackSpeed(1.6f, material, 0.0f), 20, 0.0f)));
        SHORTSWORD = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_shortsword", modifyDurability(prop, material, 1.0f), material, 2.5f, 1.0f, getAttackSpeed(1.7f, material, 0.0f))));
        KATZBALGER = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_katzbalger", modifyDurability(prop, material, 1.0f), material, 3.0f, 1.0f, getAttackSpeed(1.65f, material, 0.0f))));
        PIKE = ((material, prop) -> (new LanceItem(material.getMaterialName() + "_pike", modifyDurability(prop, material, 1.0f), material, 3.0f, 1.0f, getAttackSpeed(1.07f, material, 0.0f), 0, 1.2f)).setTwoHanded(2));
        RANSEUR = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_ranseur", modifyDurability(prop, material, 1.0f), material, 3.1f, 1.0f, getAttackSpeed(1.07f, material, 0.0f), 0, 1.0f)).setTwoHanded(1));
        AHLSPIESS = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_ahlspiess", modifyDurability(prop, material, 1.0f), material, 4.0f, 1.0f, getAttackSpeed(1.28f, material, 0.02f), 18, 0.5f)).setTwoHanded(2));
        CHIVALRYLANCE = ((material, prop) -> (new LanceItem(material.getMaterialName() + "_chivalrylance", modifyDurability(prop, material, 1.0f), material, 2.5f, 1.0f, getAttackSpeed(0.84f, material, 0.0f), 10, 1.0f)).setTwoHanded(2));
        BASTARDSWORD = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_bastardsword", modifyDurability(prop, material, 1.0f), material, 4.25f, 1.0f, getAttackSpeed(1.55f, material, 0.02f))).setTwoHanded(1));
        ESTOC = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_estoc", modifyDurability(prop, material, 1.0f), material, 4.0f, 1.0f, getAttackSpeed(1.45f, material, 0.0f), 3, 0.2f)).setTwoHanded(1));
        CLAYMORE = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_claymore", modifyDurability(prop, material, 1.0f), material, 4.4f, 1.0f, getAttackSpeed(1.45f, material, 0.0f))).setTwoHanded(1));
        ZWEIHANDER = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_zweihander", modifyDurability(prop, material, 1.0f), material, 6.6f, 1.0f, getAttackSpeed(1.15f, material, 0.05f), 4, 0.4f)).setTwoHanded(2));
        FlAMEBLADEDSWORD = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_flamebladedsword", modifyDurability(prop, material, 1.0f), material, 6.5f, 1.0f, getAttackSpeed(1.15f, material, 0.05f), 4, 0.4f)).setTwoHanded(2).setFlamebladed());
        LOCHABERAXE = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_lochaberaxe", modifyDurability(prop, material, 1.0f), material, 8.0f, 1.0f, getAttackSpeed(1.0f, material, 0.05f), 0, 0.5f)).setTwoHanded(1));
        CONCAVEHALBERD = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_concavehalberd", modifyDurability(prop, material, 1.0f), material, 9.5f, 1.0f, getAttackSpeed(0.9f, material, 0.05f), 2, 0.5f)).setTwoHanded(2));
        HEAVYMACE = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_heavymace", modifyDurability(prop, material, 1.0f), material, 4.5f, 1.0f, getAttackSpeed(1.15f, material, 0.05f), 11, 0.0f)));
        HEAVYWARHAMMER = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_heavywarhammer", modifyDurability(prop, material, 1.0f), material, 5.2f, 1.0f, getAttackSpeed(1.05f, material, 0.05f), 13, 0.0f)));
        LUCERNHAMMER = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_lucernhammer", modifyDurability(prop, material, 1.0f), material, 4.6f, 1.0f, getAttackSpeed(1.1f, material, 0.05f), 16, 0.0f)).setTwoHanded(1));
        MORGENSTERN = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_morgenstern", modifyDurability(prop, material, 1.0f), material, 5.0f, 1.0f, getAttackSpeed(1.25f, material, 0.05f))));
        CHAINMORGENSTERN = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_chainmorgenstern", modifyDurability(prop, material, 1.0f), material, 6.2f, 1.0f, getAttackSpeed(1.0f, material, 0.05f))));
        GUISARME = ((material, prop) -> (new MedievalWeaponItem(material.getMaterialName() + "_guisarme", modifyDurability(prop, material, 1.0f), material, 3.15f, 1.0f, getAttackSpeed(1.02f, material, 0.0f), 0, 0.8f)).setTwoHanded(1));
    }

    public static Item.Properties modifyDurability(Item.Properties prop, ModItemTier material, float f)
    {
        return prop.durability((int)(material.getUses() * f));
    }

    public static float getAttackSpeed(float attackSpeed, ModItemTier material, float f)
    {
        return -material.getDensity() * f + attackSpeed - 4.0F;
    }
}
