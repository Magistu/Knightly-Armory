package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class StechhelmModel extends BipedModel<LivingEntity> {

    private final ModelRenderer Helmet;
    private final ModelRenderer Helmet_r1;
    private final ModelRenderer Helmet_r2;
    private final ModelRenderer Helmet_r3;
    private final ModelRenderer Helmet_r4;
    private final ModelRenderer Helmet_r5;

    public StechhelmModel() {
        super(-4.0F, 0.0F, 64, 64);

        this.head = new ModelRenderer(this);
        this.hat = new ModelRenderer(this);

        this.texWidth = 64;
        this.texHeight = 32;

        Helmet = new ModelRenderer(this);
		Helmet.setPos(0.0F, 0.0F, 0.0F);
		Helmet.texOffs(34, 0).addBox(-4.0F, -7.5F, -3.2F, 8.0F, 7.0F, 7.0F, 1.0F, false);
        head.addChild(Helmet);

		Helmet_r1 = new ModelRenderer(this);
		Helmet_r1.setPos(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r1);
		setRotationAngle(Helmet_r1, 1.0472F, -0.4363F, 1.5708F);
		Helmet_r1.texOffs(0, 0).addBox(-10.001F, -4.2F, -2.46F, 8.0F, 4.0F, 7.0F, 0.0F, false);

		Helmet_r2 = new ModelRenderer(this);
		Helmet_r2.setPos(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r2);
		setRotationAngle(Helmet_r2, 2.0944F, -0.4363F, 1.5708F);
		Helmet_r2.texOffs(0, 12).addBox(-10.0F, -4.2F, -4.54F, 8.0F, 4.0F, 7.0F, 0.0F, false);

		Helmet_r3 = new ModelRenderer(this);
		Helmet_r3.setPos(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r3);
		Helmet_r3.texOffs(0, 23).addBox(-4.0F, -9.3F, -4.0F, 8.0F, 1.0F, 8.0F, 0.3F, false);

		Helmet_r4 = new ModelRenderer(this);
		Helmet_r4.setPos(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r4);
		setRotationAngle(Helmet_r4, 1.0472F, -0.4363F, 1.5708F);
		Helmet_r4.texOffs(54, 8).addBox(-9.96F, -4.16F, 4.0F, 2.0F, 3.0F, 0.0F, 0.03F, true);

		Helmet_r5 = new ModelRenderer(this);
		Helmet_r5.setPos(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r5);
		setRotationAngle(Helmet_r5, 2.0944F, -0.4363F, 1.5708F);
		Helmet_r5.texOffs(56, 8).addBox(-9.96F, -4.16F, -4.0F, 2.0F, 3.0F, 0.0F, 0.03F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
