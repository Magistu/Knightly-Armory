package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.proxy.ClientProxy;
import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class  JoustingItem extends ArmorItem implements INoHatLayer, ISurcoat
{
    public JoustingItem(IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties)
    {
        super(materialIn, slot, properties);
    }

    public <A extends net.minecraft.client.renderer.entity.model.BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default)
    {
        return (KnightlyArmory.PROXY instanceof ClientProxy) ? (A)((ClientProxy)KnightlyArmory.PROXY).getJoustingModel(armorSlot) : null;
    }

  	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
	{
		player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 40, 1, false, false, false));
	}
  
    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add((new TranslationTextComponent("joustingarmor.slowness")).withStyle(TextFormatting.RED));
    }
}
