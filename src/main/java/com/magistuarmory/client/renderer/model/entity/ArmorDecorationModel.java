package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;

import java.util.function.Function;

public abstract class ArmorDecorationModel<T extends LivingEntity> extends BipedModel<T>
{
    public ArmorDecorationModel(float p_i225946_2_, float p_i225946_3_, int p_i225946_4_, int p_i225946_5_)
    {
        super(p_i225946_2_, p_i225946_3_, p_i225946_4_, p_i225946_5_);
    }

    public abstract ModelRenderer[] getParts();
}
