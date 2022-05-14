package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class SalletModel extends BipedModel<LivingEntity> {
    private final ModelRenderer Helmet;
    private final ModelRenderer Helmet_r1;
    private final ModelRenderer Helmet_r2;
    private final ModelRenderer Helmet_r3;
    private final ModelRenderer Helmet_r4;
    private final ModelRenderer Helmet_r5;
    private final ModelRenderer Helmet_r6;

    public SalletModel() {
        super(-4.0F, 0.0F, 64, 64);

        this.head = new ModelRenderer(this);
        this.hat = new ModelRenderer(this);

        this.texWidth = 64;
        this.texHeight = 32;

        this.Helmet = new ModelRenderer(this, 32, 0);
        this.Helmet.setPos(0.0F, 0.0F, 0.0F);
        this.head.addChild(this.Helmet);
        this.Helmet.addBox(-4.0F, -8.1F, -4.2F, 8.0F, 7.0F, 8.0F, 1.0F, false);

        this.Helmet_r1 = new ModelRenderer(this, 39, 5);
        this.Helmet_r1.setPos(-4.0F, 0.0F, -3.0F);
        this.head.addChild(this.Helmet_r1);
        setRotationAngle(this.Helmet_r1, 0.0F, 0.2618F, 1.5708F);
        this.Helmet_r1.addBox(-3.3F, -9.5F, -1.6F, 1.0F, 11.0F, 9.0F, 0.0F, false);

        this.Helmet_r2 = new ModelRenderer(this, 0, 18);
        this.Helmet_r2.setPos(6.0F, 0.0F, 0.0F);
        this.head.addChild(this.Helmet_r2);
        setRotationAngle(this.Helmet_r2, -1.789F, 0.1309F, 1.5708F);
        this.Helmet_r2.addBox(-9.3F, 1.6F, 1.67F, 8.0F, 4.0F, 6.0F, 0.0F, false);

        this.Helmet_r3 = new ModelRenderer(this, 0, 0);
        this.Helmet_r3.setPos(0.0F, 0.0F, 0.0F);
        this.head.addChild(this.Helmet_r3);
        setRotationAngle(this.Helmet_r3, -1.3526F, 0.1309F, 1.5708F);
        this.Helmet_r3.addBox(-9.3F, 2.9F, -1.806F, 8.0F, 4.0F, 6.0F, 0.0F, false);

        this.Helmet_r4 = new ModelRenderer(this, 28, 18);
        this.Helmet_r4.setPos(-4.0F, 0.0F, 0.0F);
        this.head.addChild(this.Helmet_r4);
        setRotationAngle(this.Helmet_r4, -2.0071F, 0.2618F, 1.5708F);
        this.Helmet_r4.addBox(-2.501F, -4.7F, -6.6F, 1.0F, 4.0F, 6.0F, 0.0F, false);

        this.Helmet_r5 = new ModelRenderer(this, 28, 18);
        this.Helmet_r5.setPos(0.0F, 0.0F, 0.0F);
        this.head.addChild(this.Helmet_r5);
        setRotationAngle(this.Helmet_r5, -1.1345F, 0.2618F, 1.5708F);
        this.Helmet_r5.addBox(-2.5F, -6.4F, -3.01F, 1.0F, 4.0F, 6.0F, 0.0F, false);

        this.Helmet_r6 = new ModelRenderer(this, 45, 15);
        this.Helmet_r6.setPos(0.0F, 0.0F, 0.0F);
        this.head.addChild(this.Helmet_r6);
        setRotationAngle(this.Helmet_r6, 0.0F, -0.7854F, 0.0F);
        this.Helmet_r6.addBox(-4.7F, -2.6F, -4.7F, 3.0F, 3.0F, 3.0F, -0.2F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
