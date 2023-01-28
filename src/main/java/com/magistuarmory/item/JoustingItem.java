package com.magistuarmory.item;

import java.util.List;

import javax.annotation.Nullable;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class JoustingItem extends ArmorItem implements INoHatLayer, ISurcoat
{
	public JoustingItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties properties) {
		super(materialIn, slot, properties);
	}

	@Override
	public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer)
	{
		consumer.accept(new IClientItemExtensions()
		{
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default)
			{
				return KnightlyArmory.PROXY instanceof ClientProxy ? ((ClientProxy) KnightlyArmory.PROXY).getJoustingModel(armorSlot) : null;
			}
		});
	}
	
	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player)
	{
		player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1, false, false, false));

		if (player.getInventory().armor.get(3).getItem().equals(this) && level.isClientSide && player.isModelPartShown(PlayerModelPart.HAT))
		{
			Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.HAT, false);
		}
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) 
	{
		tooltip.add(Component.translatable("Slow movement speed").withStyle(ChatFormatting.RED));
	}
}
