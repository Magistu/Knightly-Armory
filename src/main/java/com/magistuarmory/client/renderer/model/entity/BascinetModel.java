package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class BascinetModel extends BipedModel<LivingEntity> {
    private final ModelRenderer Helmet;
    private final ModelRenderer Helmet_r1;
    private final ModelRenderer Helmet_r2;
    private final ModelRenderer Helmet_r3;
    private final ModelRenderer Helmet_r4;
    private final ModelRenderer Helmet_r5;

    public BascinetModel()
    {
        super(-4.5F, 0.0F, 64, 64);

        this.head = new ModelRenderer(this);
        this.hat = new ModelRenderer(this);

        texWidth = 64;
        texHeight = 32;

        Helmet = new ModelRenderer(this);
		Helmet.setPos(0.0F, 1.0F, 0.0F);
		Helmet.texOffs(0, 0).addBox(-4.0F, -8.9F, -3.2F, 8.0F, 7.0F, 7.0F, 1.0F, false);
		Helmet.texOffs(6, 6).addBox(-4.0F, -8.9F, -3.7F, 8.0F, 7.0F, 1.0F, 0.97F, false);
		head.addChild(Helmet);

		Helmet_r1 = new ModelRenderer(this);
		Helmet_r1.setPos(0.0F, -6.0F, -4.7F);
		Helmet.addChild(Helmet_r1);
		setRotationAngle(Helmet_r1, 0.5672F, 0.0F, 0.0F);
		Helmet_r1.texOffs(34, 0).addBox(-4.0F, 0.0F, -6.05F, 8.0F, 0.0F, 7.0F, 0.0F, false);

		Helmet_r2 = new ModelRenderer(this);
		Helmet_r2.setPos(0.0F, -2.872F, -7.8663F);
		Helmet.addChild(Helmet_r2);
		setRotationAngle(Helmet_r2, -0.2618F, 0.0F, 0.0F);
		Helmet_r2.texOffs(36, 8).addBox(-4.0F, 0.372F, -2.1337F, 8.0F, 0.0F, 6.0F, 0.0F, false);

		Helmet_r3 = new ModelRenderer(this);
		Helmet_r3.setPos(0.0F, -8.0F, -5.5F);
		Helmet.addChild(Helmet_r3);
		setRotationAngle(Helmet_r3, 0.7854F, 0.0F, 0.0F);
		Helmet_r3.texOffs(0, 14).addBox(-4.0F, 1.0F, -1.8F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		Helmet_r4 = new ModelRenderer(this);
		Helmet_r4.setPos(4.0F, -4.5F, -5.0F);
		Helmet.addChild(Helmet_r4);
		setRotationAngle(Helmet_r4, 0.0F, 0.6615F, 0.0F);
		Helmet_r4.texOffs(50, 21).addBox(-0.4F, -1.2F, -6.3F, 0.0F, 4.0F, 7.0F, 0.0F, false);

		Helmet_r5 = new ModelRenderer(this);
		Helmet_r5.setPos(4.0F, -4.5F, -5.0F);
		Helmet.addChild(Helmet_r5);
		setRotationAngle(Helmet_r5, 0.0F, -0.6615F, 0.0F);
		Helmet_r5.texOffs(50, 21).addBox(-5.95F, -1.2F, -1.37F, 0.0F, 4.0F, 7.0F, 0.0F, true);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
