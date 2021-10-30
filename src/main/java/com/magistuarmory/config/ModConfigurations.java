package com.magistuarmory.config;

import com.sun.org.apache.xpath.internal.operations.Bool;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ModConfigurations
{
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> put_armor_on_mobs;
    public static final ForgeConfigSpec.ConfigValue<Boolean> steel_enabled;

    static
    {
        BUILDER.push("Config for Epic Knights Mod!");

        put_armor_on_mobs = BUILDER.comment("This is an boolean. Default value is true.").define("Put Armor on Mobs", true);
        steel_enabled = BUILDER.comment("This is an boolean. Default value is true.").define("Steel Enabled", true);

        BUILDER.pop();
        SPEC = BUILDER.build();


    }

}
