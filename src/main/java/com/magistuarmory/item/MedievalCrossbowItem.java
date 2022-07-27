package com.magistuarmory.item;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MedievalCrossbowItem extends CrossbowItem implements IHasModelProperty
{
	private final int pullTime;
    private final float projectileSpeed;

	protected boolean startSoundPlayed = false;
	protected boolean midLoadSoundPlayed = false;

    public MedievalCrossbowItem(Properties p_40660_, float projectileSpeed, int pullTime)
    {
        super(p_40660_);
		this.projectileSpeed = projectileSpeed;
        this.pullTime = pullTime;
    }

	@Override
	public void onUseTick(World p_219972_1_, LivingEntity p_219972_2_, ItemStack p_219972_3_, int p_219972_4_) {
		if (!p_219972_1_.isClientSide) {
			int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, p_219972_3_);
			SoundEvent soundevent = this.getStartSound(i);
			SoundEvent soundevent1 = i == 0 ? SoundEvents.CROSSBOW_LOADING_MIDDLE : null;
			float f = (float)(p_219972_3_.getUseDuration() - p_219972_4_) / (float)getPullTime(p_219972_3_);
			if (f < 0.2F) {
				this.startSoundPlayed = false;
				this.midLoadSoundPlayed = false;
			}

			if (f >= 0.2F && !this.startSoundPlayed) {
				this.startSoundPlayed = true;
				p_219972_1_.playSound((PlayerEntity)null, p_219972_2_.getX(), p_219972_2_.getY(), p_219972_2_.getZ(), soundevent, SoundCategory.PLAYERS, 0.5F, 1.0F);
			}

			if (f >= 0.5F && soundevent1 != null && !this.midLoadSoundPlayed) {
				this.midLoadSoundPlayed = true;
				p_219972_1_.playSound((PlayerEntity)null, p_219972_2_.getX(), p_219972_2_.getY(), p_219972_2_.getZ(), soundevent1, SoundCategory.PLAYERS, 0.5F, 1.0F);
			}
		}

	}

	@Override
	public void releaseUsing(ItemStack p_77615_1_, World p_77615_2_, LivingEntity p_77615_3_, int p_77615_4_) {
		int i = this.getUseDuration(p_77615_1_) - p_77615_4_;
		float f = getPower(i, p_77615_1_);
		if (f >= 1.0F && !isCharged(p_77615_1_) && tryLoadProjectiles(p_77615_3_, p_77615_1_)) {
			setCharged(p_77615_1_, true);
			SoundCategory soundcategory = p_77615_3_ instanceof PlayerEntity ? SoundCategory.PLAYERS : SoundCategory.HOSTILE;
			p_77615_2_.playSound((PlayerEntity)null, p_77615_3_.getX(), p_77615_3_.getY(), p_77615_3_.getZ(), SoundEvents.CROSSBOW_LOADING_END, soundcategory, 1.0F, 1.0F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
		}

	}

	private static boolean tryLoadProjectiles(LivingEntity p_220021_0_, ItemStack p_220021_1_) {
		int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MULTISHOT, p_220021_1_);
		int j = i == 0 ? 1 : 3;
		boolean flag = p_220021_0_ instanceof PlayerEntity && ((PlayerEntity)p_220021_0_).abilities.instabuild;
		ItemStack itemstack = p_220021_0_.getProjectile(p_220021_1_);
		ItemStack itemstack1 = itemstack.copy();

		for(int k = 0; k < j; ++k) {
			if (k > 0) {
				itemstack = itemstack1.copy();
			}

			if (itemstack.isEmpty() && flag) {
				itemstack = new ItemStack(Items.ARROW);
				itemstack1 = itemstack.copy();
			}

			if (!loadProjectile(p_220021_0_, p_220021_1_, itemstack, k > 0, flag)) {
				return false;
			}
		}

		return true;
	}

	private static boolean loadProjectile(LivingEntity p_220023_0_, ItemStack p_220023_1_, ItemStack p_220023_2_, boolean p_220023_3_, boolean p_220023_4_) {
		if (p_220023_2_.isEmpty()) {
			return false;
		} else {
			boolean flag = p_220023_4_ && p_220023_2_.getItem() instanceof ArrowItem;
			ItemStack itemstack;
			if (!flag && !p_220023_4_ && !p_220023_3_) {
				itemstack = p_220023_2_.split(1);
				if (p_220023_2_.isEmpty() && p_220023_0_ instanceof PlayerEntity) {
					((PlayerEntity)p_220023_0_).inventory.removeItem(p_220023_2_);
				}
			} else {
				itemstack = p_220023_2_.copy();
			}

			addChargedProjectile(p_220023_1_, itemstack);
			return true;
		}
	}

	private static void addChargedProjectile(ItemStack p_220029_0_, ItemStack p_220029_1_) {
		CompoundNBT compoundnbt = p_220029_0_.getOrCreateTag();
		ListNBT listnbt;
		if (compoundnbt.contains("ChargedProjectiles", 9)) {
			listnbt = compoundnbt.getList("ChargedProjectiles", 10);
		} else {
			listnbt = new ListNBT();
		}

		CompoundNBT compoundnbt1 = new CompoundNBT();
		p_220029_1_.save(compoundnbt1);
		listnbt.add(compoundnbt1);
		compoundnbt.put("ChargedProjectiles", listnbt);
	}

	public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
		ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
		if (isCharged(itemstack)) {
			performShooting(p_77659_1_, p_77659_2_, p_77659_3_, itemstack, getProjectileSpeed(itemstack), 1.0F);
			setCharged(itemstack, false);
			return ActionResult.consume(itemstack);
		} else if (!p_77659_2_.getProjectile(itemstack).isEmpty()) {
			if (!isCharged(itemstack)) {
				this.startSoundPlayed = false;
				this.midLoadSoundPlayed = false;
				p_77659_2_.startUsingItem(p_77659_3_);
			}

			return ActionResult.consume(itemstack);
		} else {
			return ActionResult.fail(itemstack);
		}
	}

	private SoundEvent getStartSound(int p_40852_) {
		switch (p_40852_) {
			case 1:
				return SoundEvents.CROSSBOW_QUICK_CHARGE_1;
			case 2:
				return SoundEvents.CROSSBOW_QUICK_CHARGE_2;
			case 3:
				return SoundEvents.CROSSBOW_QUICK_CHARGE_3;
			default:
				return SoundEvents.CROSSBOW_LOADING_START;
		}
	}

	public int getPullTime(ItemStack p_40940_) 
	{
		int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, p_40940_);
		return i == 0 ? pullTime : pullTime - 5 * i;
	}

	public float getProjectileSpeed(ItemStack p_40946_) 
	{
		return containsChargedProjectile(p_40946_, Items.FIREWORK_ROCKET) ? 1.6F : projectileSpeed;
	}

	private float getPower(int p_40854_, ItemStack p_40855_) {
		float f = (float)p_40854_ / (float)getPullTime(p_40855_);
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	@Override
	public int getUseDuration(ItemStack p_40938_) {
		return getPullTime(p_40938_) + 3;
	}

    @Override
	@OnlyIn(Dist.CLIENT)
	public void registerModelProperty()
	{
		ItemModelsProperties.register(this, new ResourceLocation("pull"), (p_239427_0_, p_239427_1_, p_239427_2_) -> {
			if (p_239427_2_ == null) {
				return 0.0F;
			} else {
				return CrossbowItem.isCharged(p_239427_0_) ? 0.0F : (float)(p_239427_0_.getUseDuration() - p_239427_2_.getUseItemRemainingTicks()) / (float)getPullTime(p_239427_0_);
			}
		});
		ItemModelsProperties.register(this, new ResourceLocation("pulling"), (p_239426_0_, p_239426_1_, p_239426_2_) -> p_239426_2_ != null && p_239426_2_.isUsingItem() && p_239426_2_.getUseItem() == p_239426_0_ && !CrossbowItem.isCharged(p_239426_0_) ? 1.0F : 0.0F);
		ItemModelsProperties.register(this, new ResourceLocation("charged"), (p_239425_0_, p_239425_1_, p_239425_2_) -> p_239425_2_ != null && isCharged(p_239425_0_) ? 1.0F : 0.0F);
		ItemModelsProperties.register(this, new ResourceLocation("firework"), (p_239424_0_, p_239424_1_, p_239424_2_) -> p_239424_2_ != null && isCharged(p_239424_0_) && CrossbowItem.containsChargedProjectile(p_239424_0_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F);
	}
}
