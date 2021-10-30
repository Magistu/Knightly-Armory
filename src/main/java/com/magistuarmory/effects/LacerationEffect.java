package com.magistuarmory.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LacerationEffect extends Effect
{
    public static final LacerationEffect LACERATION = new LacerationEffect();

    private float damage = 1.0F;

    public LacerationEffect()
    {
        super(EffectType.HARMFUL, -10092544);
        setRegistryName("laceration");
        addAttributeModifier(Attributes.MAX_HEALTH, "81AEAA56-376B-4498-935B-2F7F68070635", -2.0D, AttributeModifier.Operation.ADDITION);
    }

    public String getName()
    {
        return "effect.laceration";
    }

    public boolean isBeneficial()
    {
        return false;
    }

    public boolean isInstant()
    {
        return false;
    }

    public boolean shouldRenderInvText(EffectInstance effect)
    {
        return true;
    }

    public boolean shouldRender(EffectInstance effect)
    {
        return true;
    }

    public boolean shouldRenderHUD(EffectInstance effect)
    {
        return true;
    }

    public void applyAttributesModifiersToEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier)
    {
        super.addAttributeModifiers(entity, attributeMapIn, amplifier);
        if (entity.getHealth() > entity.getMaxHealth())
            entity.setHealth(entity.getMaxHealth());
    }

    public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier)
    {
        super.addAttributeModifiers(entity, attributeMapIn, amplifier);
    }

    @SubscribeEvent
    public static void registerEffects(RegistryEvent.Register<Effect> ev)
    {
        IForgeRegistry<Effect> reg = ev.getRegistry();
        reg.register(LACERATION);
    }

    public LacerationEffect setDamageValue(float damage)
    {
        this.damage = damage;
        return this;
    }
}
