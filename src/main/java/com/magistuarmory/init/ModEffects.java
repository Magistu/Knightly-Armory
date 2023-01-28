package com.magistuarmory.init;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.effects.LacerationEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects 
{
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, KnightlyArmory.ID);

    public static final RegistryObject<LacerationEffect> LACERATION_EFFECT = EFFECTS.register("laceration", LacerationEffect::new);
}
