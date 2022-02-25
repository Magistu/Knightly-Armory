package com.magistuarmory.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ModConfigurations
{
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> put_armor_on_mobs;
    public static final ForgeConfigSpec.ConfigValue<Float> put_armor_chance;
    public static final ForgeConfigSpec.ConfigValue<Boolean> decorations_for_all_armor;
    public static final ForgeConfigSpec.ConfigValue<Boolean> steel_enabled;

    static
    {
        BUILDER.push("Config for Epic Knights Mod!");

        put_armor_on_mobs = BUILDER.comment("Works only in game with the difficulty set to hard. Affects whether or not mobs will wear armor from the mod. This is an boolean. Default value is true.").define("Put Armor on Mobs", true);
        put_armor_chance = BUILDER.comment("Works only if the game is set to the hard difficulty. Affects the chance that mobs will wear armor from the mod. This is an float. Default value is 0.5.").define("Put Armor Chance", 0.5f);
        decorations_for_all_armor = BUILDER.comment("If true, allows wearing decorations on any type of armor, not only from this mod. This is an boolean. Default value is true.").define("Decorations for All Armor", true);
        steel_enabled = BUILDER.comment("Doesn't change anything yet! This is an boolean. Default value is true.").define("Steel Enabled", true);

        BUILDER.pop();
        SPEC = BUILDER.build();


    }

}
