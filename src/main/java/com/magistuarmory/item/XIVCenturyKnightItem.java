package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class XIVCenturyKnightItem extends ArmorItem implements INoHatLayer, ISurcoat
{
	public XIVCenturyKnightItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties properties) {
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
				return KnightlyArmory.PROXY instanceof ClientProxy ? ((ClientProxy) KnightlyArmory.PROXY).getXIVCenturyKnightModel(armorSlot) : null;
			}
		});
	}

	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player)
	{
		if (player.getInventory().armor.get(3).getItem().equals(this) && level.isClientSide && player.isModelPartShown(PlayerModelPart.HAT))
		{
			Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.HAT, false);
		}
	}
}
