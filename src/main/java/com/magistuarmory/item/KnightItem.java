package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class KnightItem extends ArmorItem implements INoHatLayer, ISurcoat, DyeableLeatherItem
{
	public KnightItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties properties) {
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
				return KnightlyArmory.PROXY instanceof ClientProxy ? ((ClientProxy) KnightlyArmory.PROXY).getKnightModel(armorSlot) : null;
			}
		});
	}

	@Override
    public int getColor(ItemStack p_200886_1_)
    {
        CompoundTag compoundnbt = p_200886_1_.getTagElement("display");
        return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : -10092544;
    }
}
