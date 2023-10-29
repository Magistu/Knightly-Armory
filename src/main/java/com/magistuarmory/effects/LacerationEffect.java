package com.magistuarmory.effects;


import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.magistuarmory.KnightlyArmory;


@EventBusSubscriber(modid = KnightlyArmory.ID)
public class LacerationEffect extends Potion {
	public static final LacerationEffect LACERATION = (LacerationEffect) new LacerationEffect();

	private float damage = 1.0f;
	
	public LacerationEffect() {
		super(true, -10092544);
		setRegistryName("laceration");
		registerPotionAttributeModifier(SharedMonsterAttributes.MAX_HEALTH, "81AEAA56-376B-4498-935B-2F7F68070635", -2.0f, 0);
	}

	@Override
	public String getName() {
		return "Laceration";
	}

	@Override
	public boolean isBeneficial() {
		return false;
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public boolean shouldRenderInvText(PotionEffect effect) {
		return true;
	}

	@Override
	public boolean shouldRender(PotionEffect effect) {
		return true;
	}

	@Override
	public boolean shouldRenderHUD(PotionEffect effect) {
		return true;
	}

	@Override
	public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier)
	{
		super.applyAttributesModifiersToEntity(entity, attributeMap, amplifier);
		if (entity.getHealth() > entity.getMaxHealth())
		{
			entity.setHealth(entity.getMaxHealth());
		}
	}
	
	@Override
	public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMapIn, int amplifier)
	{	
		super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}
	
	@SubscribeEvent
	public static void registerEffects(RegistryEvent.Register<Potion> ev) 
	{
		IForgeRegistry<Potion> reg = ev.getRegistry();
		
		reg.register(LACERATION);
	}
	
	@Override
	public double getAttributeModifierAmount(int amplifier, AttributeModifier modifier)
	{
		return -0.5 * damage;
	}
	
	public LacerationEffect setDamage(float damage)
	{
		this.damage = damage;
		return this;
	}
}
