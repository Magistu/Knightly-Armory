package com.magistuarmory.item;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MedievalBowItem extends BowItem implements IHasModelProperty
{

    private final float pullTime;
    private final float projectileSpeed;

    public MedievalBowItem(Properties p_i48522_1_, float projectileSpeed, float pullTime)
    {
        super(p_i48522_1_);
        this.projectileSpeed = projectileSpeed;
        this.pullTime = pullTime;
    }

	public void releaseUsing(ItemStack p_77615_1_, World p_77615_2_, LivingEntity p_77615_3_, int p_77615_4_)
    {
		if (p_77615_3_ instanceof PlayerEntity)
        {
			PlayerEntity playerentity = (PlayerEntity)p_77615_3_;
			boolean flag = playerentity.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, p_77615_1_) > 0;
			ItemStack itemstack = playerentity.getProjectile(p_77615_1_);

			int i = this.getUseDuration(p_77615_1_) - p_77615_4_;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_77615_1_, p_77615_2_, playerentity, i, !itemstack.isEmpty() || flag);
			if (i < 0) return;

			if (!itemstack.isEmpty() || flag)
            {
				if (itemstack.isEmpty())
                {
					itemstack = new ItemStack(Items.ARROW);
				}

				float f = this.getPower(i);
				if (!((double)f < 0.1D)) {
					boolean flag1 = playerentity.abilities.instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, p_77615_1_, playerentity));
					if (!p_77615_2_.isClientSide) {
						ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
						AbstractArrowEntity abstractarrowentity = arrowitem.createArrow(p_77615_2_, itemstack, playerentity);
						abstractarrowentity = customArrow(abstractarrowentity);
						abstractarrowentity.shootFromRotation(playerentity, playerentity.xRot, playerentity.yRot, 0.0F, f * this.projectileSpeed, 1.0F);
						if (f == 1.0F) {
							abstractarrowentity.setCritArrow(true);
						}

						int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, p_77615_1_);
						if (j > 0) {
							abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + (double)j * 0.5D + 0.5D);
						}

						int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, p_77615_1_);
						if (k > 0) {
							abstractarrowentity.setKnockback(k);
						}

						if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, p_77615_1_) > 0) {
							abstractarrowentity.setSecondsOnFire(100);
						}

						p_77615_1_.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
							p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
						});
						if (flag1 || playerentity.abilities.instabuild && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
							abstractarrowentity.pickup = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
						}

						p_77615_2_.addFreshEntity(abstractarrowentity);
					}

					p_77615_2_.playSound((PlayerEntity)null, playerentity.getX(), playerentity.getY(), playerentity.getZ(), SoundEvents.ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
					if (!flag1 && !playerentity.abilities.instabuild) {
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							playerentity.inventory.removeItem(itemstack);
						}
					}

					playerentity.awardStat(Stats.ITEM_USED.get(this));
				}
			}
		}
	}

    public float getPower(int p_185059_0_) {
      float f = (float)p_185059_0_ / this.pullTime;
      f = (f * f + f * 2.0F) / 3.0F;
      if (f > 1.0F) {
         f = 1.0F;
      }

      return f;
   }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void registerModelProperty()
    {
        ItemModelsProperties.register(this, new ResourceLocation("pull"), (p_210310_0_, p_210310_1_, p_210310_2_) -> (p_210310_2_ == null) ? 0.0F : (!(p_210310_2_.getUseItem().getItem() instanceof BowItem) ? 0.0F : ((p_210310_0_.getUseDuration() - p_210310_2_.getUseItemRemainingTicks()) / this.pullTime)));
        ItemModelsProperties.register(this, new ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) ->
            (p_239428_2_ != null && p_239428_2_.isUsingItem() && p_239428_2_.getUseItem() == p_239428_0_) ? 1.0F : 0.0F);
    }
}
