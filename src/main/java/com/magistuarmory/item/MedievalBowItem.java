package com.magistuarmory.item;

import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MedievalBowItem extends BowItem implements IHasModelProperty
{

    private final float pullTime;

    public MedievalBowItem(String unlocname, Properties p_i48522_1_, float pullTime)
    {
        super(p_i48522_1_);
        setRegistryName(unlocname);
        this.pullTime = pullTime;
    }

    float getPullTime()
    {
        return pullTime;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void registerModelProperty()
    {
        ItemModelsProperties.register(this, new ResourceLocation("pull"), (p_210310_0_, p_210310_1_, p_210310_2_) -> (p_210310_2_ == null) ? 0.0F : (!(p_210310_2_.getUseItem().getItem() instanceof BowItem) ? 0.0F : ((p_210310_0_.getUseDuration() - p_210310_2_.getUseItemRemainingTicks()) / this.getPullTime())));
        ItemModelsProperties.register(this, new ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) ->
            (p_239428_2_ != null && p_239428_2_.isUsingItem() && p_239428_2_.getUseItem() == p_239428_0_) ? 1.0F : 0.0F);
    }
}
