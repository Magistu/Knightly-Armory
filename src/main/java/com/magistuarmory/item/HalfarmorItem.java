package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;


import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class HalfarmorItem extends ArmorItem implements ISurcoat
{
	public HalfarmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties properties) {
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
				return KnightlyArmory.PROXY instanceof ClientProxy ? ((ClientProxy) KnightlyArmory.PROXY).getHalfarmorModel(armorSlot) : null;
			}
		});
	}
}
