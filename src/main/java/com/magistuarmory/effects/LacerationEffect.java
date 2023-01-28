package com.magistuarmory.effects;

import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LacerationEffect extends MobEffect 
{
	private float damage = 1.0f;
	
	public LacerationEffect() 
	{
		super(MobEffectCategory.HARMFUL, -10092544);
		addAttributeModifier(Attributes.MAX_HEALTH, "81AEAA56-376B-4498-935B-2F7F68070635", -2.0f, Operation.ADDITION);
	}

	@Override
	public String getDescriptionId() { return "effect.laceration"; }

	@Override
	public boolean isBeneficial() {
		return false;
	}

	@Override
	public boolean isInstantenous() {
		return false;
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMapIn, int amplifier) {
		super.addAttributeModifiers(entity, attributeMapIn, amplifier);
		if (entity.getHealth() > entity.getMaxHealth())
		{
			entity.setHealth(entity.getMaxHealth());
		}
	}
	
	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMapIn, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMapIn, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
	
	@Override
	public double getAttributeModifierValue(int p_111183_1_, AttributeModifier p_111183_2_) {
		return -0.5 * damage;
	}
	
	public LacerationEffect setDamage(float damage)
	{
		this.damage = damage;
		return this;
	}
}
