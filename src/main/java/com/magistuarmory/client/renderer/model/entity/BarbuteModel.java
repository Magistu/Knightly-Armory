package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class BarbuteModel extends BipedModel<LivingEntity> {
    private final ModelRenderer Helmet;

    public BarbuteModel() {
        super(-4.0F, 0.0F, 64, 64);

        this.head = new ModelRenderer(this);
        this.hat = new ModelRenderer(this);

        this.texWidth = 64;
        this.texHeight = 32;

        this.Helmet = new ModelRenderer(this, 0, 0);
        this.Helmet.setPos(0.0F, 0.0F, 0.0F);
        this.head.addChild(this.Helmet);
        this.Helmet.addBox(-4.0F, -7.9F, -4.2F, 8.0F, 7.0F, 8.0F, 1.0F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
