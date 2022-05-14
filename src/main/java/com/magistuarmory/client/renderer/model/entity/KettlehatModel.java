package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class KettlehatModel extends BipedModel<LivingEntity> {
    private final ModelRenderer Helmet;
    private final ModelRenderer Helmet_r1;

    public KettlehatModel() {
        super(-4.0F, 0.0F, 64, 64);

        this.head = new ModelRenderer(this);
        this.hat = new ModelRenderer(this);

        this.texWidth = 64;
        this.texHeight = 32;

        this.Helmet = new ModelRenderer(this, 32, 0);
        this.Helmet.setPos(0.0F, 0.0F, 0.0F);
        this.head.addChild(this.Helmet);
        this.Helmet.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 1.0F, false);

        this.Helmet_r1 = new ModelRenderer(this, 0, 18);
        this.Helmet_r1.setPos(0.0F, 0.0F, 0.0F);
        this.head.addChild(this.Helmet_r1);
        this.Helmet_r1.addBox(-7.0F, -4.3F, -7.0F, 14.0F, -1.9F, 14.0F, 1.0F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
