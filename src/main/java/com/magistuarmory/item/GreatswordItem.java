package com.magistuarmory.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class GreatswordItem extends MedievalWeaponItem
{
   public GreatswordItem(Properties build, Tier material, float baseAttackDamage, float baseAttackSpeed, int armorPiercing, float reachDistance, float weight)
   {
      super(build, material, baseAttackDamage, baseAttackSpeed, armorPiercing, reachDistance, weight);
      DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
   }

   public UseAnim getUseAnimation(ItemStack p_43105_) {
      return UseAnim.BLOCK;
   }

   public int getUseDuration(ItemStack p_43107_) {
      return 72000;
   }

   public InteractionResultHolder<ItemStack> use(Level p_43099_, Player p_43100_, InteractionHand p_43101_) {
      ItemStack itemstack = p_43100_.getItemInHand(p_43101_);
      p_43100_.startUsingItem(p_43101_);
      return InteractionResultHolder.consume(itemstack);
   }
}
