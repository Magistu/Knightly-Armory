package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class MaximilianHelmetModel extends BipedModel<LivingEntity> {
    private final ModelRenderer Helmet;
    private final ModelRenderer Helmet_r1;
    private final ModelRenderer Helmet_r2;
    private final ModelRenderer Helmet_r3;
    private final ModelRenderer Helmet_r4;

    public MaximilianHelmetModel() {
        super(-4.0F, 0.0F, 64, 64);

        this.head = new ModelRenderer(this);
        this.hat = new ModelRenderer(this);

        this.texWidth = 64;
        this.texHeight = 32;

        Helmet = new ModelRenderer(this);
		Helmet.setPos(0.0F, 0.0F, 0.0F);
		Helmet.texOffs(32, 0).addBox(-4.0F, -7.9F, -3.2F, 8.0F, 7.0F, 7.0F, 1.0F, false);
		Helmet.texOffs(38, 6).addBox(-4.0F, -7.9F, -3.7F, 8.0F, 7.0F, 1.0F, 0.97F, false);
		head.addChild(Helmet);

		Helmet_r1 = new ModelRenderer(this);
		Helmet_r1.setPos(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r1);
		setRotationAngle(Helmet_r1, 0.552F, -0.4648F, 0.0F);
		Helmet_r1.texOffs(0, 5).addBox(-3.6F, -7.2F, -3.75F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		Helmet_r2 = new ModelRenderer(this);
		Helmet_r2.setPos(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r2);
		setRotationAngle(Helmet_r2, 0.552F, 0.4648F, 0.0F);
		Helmet_r2.texOffs(0, 5).addBox(-3.4F, -7.2F, -3.75F, 7.0F, 5.0F, 0.0F, 0.0F, true);

		Helmet_r3 = new ModelRenderer(this);
		Helmet_r3.setPos(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r3);
		setRotationAngle(Helmet_r3, -0.552F, -0.4648F, 0.0F);
		Helmet_r3.texOffs(0, 0).addBox(-3.6F, -4.9F, -8.1F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		Helmet_r4 = new ModelRenderer(this);
		Helmet_r4.setPos(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r4);
		setRotationAngle(Helmet_r4, -0.552F, 0.4648F, 0.0F);
		Helmet_r4.texOffs(0, 0).addBox(-3.4F, -4.9F, -8.1F, 7.0F, 5.0F, 0.0F, 0.0F, true);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
