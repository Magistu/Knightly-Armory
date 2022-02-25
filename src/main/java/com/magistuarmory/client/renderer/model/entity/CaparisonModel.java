package com.magistuarmory.client.renderer.model.entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class CaparisonModel<T extends AbstractHorseEntity> extends HorseArmorDecorationModel<T>
{
    private final ModelRenderer caparison;

    public CaparisonModel()
    {
        super(-4.0F);

        this.caparison = new ModelRenderer(this, 0, 0);
        this.caparison.addBox(-5.0F, -8.0F, -17.0F, 10.0F, 18.0F, 22.0F, 0.2F);
        this.caparison.setPos(0.0F, 11.0F, 5.0F);
    }



    @Override
    protected @NotNull Iterable<ModelRenderer> bodyParts()
    {
        return ImmutableList.of(this.caparison);
    }

    @Override
    public ModelRenderer[] getParts()
    {
        return new ModelRenderer[] { caparison };
    }

    @Override
    public void prepareMobModel(T p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_)
    {
        super.prepareMobModel(p_212843_1_, p_212843_2_, p_212843_3_, p_212843_4_);

        float f6 = p_212843_1_.getStandAnim(p_212843_4_);
        float f7 = 1.0F - f6;
        this.caparison.xRot = 0.0F;
        this.caparison.xRot = f6 * (-(float)Math.PI / 4F) + f7 * this.caparison.xRot;
   }
}
