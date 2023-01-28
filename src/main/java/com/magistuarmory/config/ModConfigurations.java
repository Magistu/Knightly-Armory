package com.magistuarmory.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ModConfigurations
{
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> equip_monsters;
    public static final ForgeConfigSpec.ConfigValue<Double> equip_chance;
    public static final ForgeConfigSpec.ConfigValue<Boolean> enable_surcoat_recipe_for_all_armor;
    public static final ForgeConfigSpec.ConfigValue<Boolean> override_equipment;
    public static final ForgeConfigSpec.ConfigValue<Boolean> disable_reach_distance;
    public static final ForgeConfigSpec.ConfigValue<Boolean> disable_armor_piercing;
    public static final ForgeConfigSpec.ConfigValue<Boolean> disable_two_handed;
    public static final ForgeConfigSpec.ConfigValue<Boolean> disable_weapon_blocking;

    static
    {
        BUILDER.push("Config for Epic Knights Mod!");

        equip_monsters = BUILDER.comment("Works only in game with the difficulty set to hard. If true, monsters will be equipped with some armor and weapons of the mod. This is an boolean. Default value is true.").define("equipMonsters", true);
        equip_chance = BUILDER.comment("Works only if the game is set to the hard difficulty. Affects the chance that monsters will be equipped with some armor and weapons of the mod. This is an float. Default value is 0.5, Maximum value is 1.0.").defineInRange("equipChance", 0.5, 0.0, 1.0);
        override_equipment = BUILDER.comment("Works only if the game is set to the hard difficulty. If false, equipment will not be overriden by equipping an armor. This is an float. Default value is false.").define("doOverrideEquipment", false);
        enable_surcoat_recipe_for_all_armor = BUILDER.comment("If true, crafting recipes with the surcoat is available not only for the armor of this mod. Default value is true.").define("enableSurcoatRecipeForAllArmor", true);
        disable_reach_distance = BUILDER.comment("If Epic Fight or Better Combat is installed, it will be used as true. If true, all the weapons have the same reach distance. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.").define("disableReachDistance", false);
        disable_armor_piercing = BUILDER.comment("If true, all the weapons don't penetrate armor. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.").define("disableArmorPiercing", false);
        disable_two_handed = BUILDER.comment("If true, all the weapons don't have any debuff as long as you hold something with both hands. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.").define("disableTwoHanded", false);
        disable_weapon_blocking = BUILDER.comment("If true, you can't block with the weapons from the mod. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.").define("disableWeaponBlocking", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    
}
