package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;

public abstract class HorseArmorDecorationModel<T extends AbstractHorseEntity> extends HorseModel<T>
{
    public HorseArmorDecorationModel(float p_i51065_1_)
    {
        super(p_i51065_1_);
    }

    public abstract ModelRenderer[] getParts();
}
