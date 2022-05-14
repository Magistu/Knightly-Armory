package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class ArmetModel extends BipedModel<LivingEntity> {
    private final ModelRenderer Plume4;
    private final ModelRenderer Plume12;
    private final ModelRenderer VisorTopLeft;
    private final ModelRenderer VisorBottomRight;
    private final ModelRenderer Plume7;
    private final ModelRenderer Plume21;
    private final ModelRenderer Plume1;
    private final ModelRenderer Plume0;
    private final ModelRenderer Plume2;
    private final ModelRenderer Plume11;
    private final ModelRenderer Plume27;
    private final ModelRenderer Plume8;
    private final ModelRenderer VisorTopRight;
    private final ModelRenderer Plume28;
    private final ModelRenderer Plume19;
    private final ModelRenderer Armet;
    private final ModelRenderer Plume13;
    private final ModelRenderer Plume5;
    private final ModelRenderer Plume14;
    private final ModelRenderer Plume22;
    private final ModelRenderer Plume17;
    private final ModelRenderer Plume24;
    private final ModelRenderer VisorBottomLeft;

    public ArmetModel() {
        super(-4.5F, 0.0F, 64, 64);

        this.head = new ModelRenderer(this);
        this.hat = new ModelRenderer(this);

        this.texWidth = 64;
        this.texHeight = 32;

        Plume13 = new ModelRenderer(this);
		Plume13.setPos(-4.0F, -8.0F, -4.0F);
		setRotationAngle(Plume13, -1.9124F, 0.0911F, -0.4554F);
		Plume13.texOffs(12, 17).addBox(-2.2F, -16.7F, 1.3F, 3.0F, 3.0F, 3.0F, 0.5F, true);

		Plume4 = new ModelRenderer(this);
		Plume4.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume4);
		setRotationAngle(Plume4, -1.0016F, -0.2731F, 1.0016F);
		Plume4.texOffs(12, 18).addBox(4.2F, -12.6F, 6.8F, 3.0F, 3.0F, 3.0F, 0.5F, true);

		Plume12 = new ModelRenderer(this);
		Plume12.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume12);
		setRotationAngle(Plume12, 0.8652F, -0.1367F, -0.5918F);
		Plume12.texOffs(0, 23).addBox(3.7F, 5.9F, 8.0F, 3.0F, 3.0F, 3.0F, 0.5F, false);

		VisorTopLeft = new ModelRenderer(this);
		VisorTopLeft.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(VisorTopLeft);
		setRotationAngle(VisorTopLeft, -0.7285F, -0.6829F, 0.0F);
		VisorTopLeft.texOffs(47, 0).addBox(0.4F, 0.65F, -2.6F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		VisorBottomRight = new ModelRenderer(this);
		VisorBottomRight.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(VisorBottomRight);
		setRotationAngle(VisorBottomRight, 0.6829F, 0.6829F, 0.0F);
		VisorBottomRight.texOffs(30, 0).addBox(-0.8F, 1.75F, -2.9F, 7.0F, 6.0F, 0.0F, 0.0F, false);

		Plume7 = new ModelRenderer(this);
		Plume7.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume7);
		setRotationAngle(Plume7, -1.0016F, 0.1367F, 2.4586F);
		Plume7.texOffs(12, 25).addBox(-5.7F, -16.8F, 3.4F, 3.0F, 3.0F, 3.0F, 0.5F, true);

		Plume21 = new ModelRenderer(this);
		Plume21.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume21);
		setRotationAngle(Plume21, -1.3203F, 0.6829F, 0.0F);
		Plume21.texOffs(12, 25).addBox(-2.9F, -14.8F, 2.8F, 3.0F, 3.0F, 3.0F, 0.5F, true);

		Plume1 = new ModelRenderer(this);
		Plume1.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume1);
		setRotationAngle(Plume1, -0.3643F, 0.0F, 0.0F);
		Plume1.texOffs(0, 23).addBox(2.5F, -6.8F, 9.7F, 3.0F, 3.0F, 3.0F, 0.5F, true);

		Plume0 = new ModelRenderer(this);
		Plume0.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume0);
		setRotationAngle(Plume0, -1.4114F, 0.0911F, -0.6829F);
		Plume0.texOffs(24, 17).addBox(1.1F, -11.9F, 3.0F, 2.0F, 3.0F, 2.0F, 0.5F, false);

		Plume2 = new ModelRenderer(this);
		Plume2.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume2);
		setRotationAngle(Plume2, -1.1383F, -0.0911F, 1.2748F);
		Plume2.texOffs(12, 25).addBox(-0.6F, -15.6F, 2.7F, 3.0F, 3.0F, 3.0F, 0.5F, true);

		Plume11 = new ModelRenderer(this);
		Plume11.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume11);
		setRotationAngle(Plume11, 0.3643F, 0.0F, 0.0F);
		Plume11.texOffs(0, 23).addBox(2.5F, 4.5F, 12.1F, 3.0F, 3.0F, 3.0F, 0.5F, false);

		Plume27 = new ModelRenderer(this);
		Plume27.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume27);
		setRotationAngle(Plume27, -0.9561F, 0.3643F, -0.1367F);
		Plume27.texOffs(12, 25).addBox(-0.6F, -14.6F, 5.2F, 3.0F, 3.0F, 3.0F, 0.5F, true);

		Plume8 = new ModelRenderer(this);
		Plume8.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume8);
		setRotationAngle(Plume8, -1.5026F, -0.2276F, -0.9561F);
		Plume8.texOffs(12, 25).addBox(-1.5F, -14.6F, 3.0F, 3.0F, 3.0F, 3.0F, 0.5F, true);

		VisorTopRight = new ModelRenderer(this);
		VisorTopRight.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(VisorTopRight);
		setRotationAngle(VisorTopRight, -0.7285F, 0.6374F, 0.0F);
		VisorTopRight.texOffs(47, 0).addBox(-1.1F, -2.6F, 1.1F, 7.0F, 5.0F, 0.0F, 0.0F, true);

		Plume28 = new ModelRenderer(this);
		Plume28.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume28);
		setRotationAngle(Plume28, 0.4098F, 0.182F, -1.4114F);
		Plume28.texOffs(0, 23).addBox(2.3F, 5.7F, 7.2F, 3.0F, 3.0F, 3.0F, 0.5F, false);

		Plume19 = new ModelRenderer(this);
		Plume19.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume19);
		setRotationAngle(Plume19, -1.5026F, 0.4554F, 0.3643F);
		Plume19.texOffs(12, 25).addBox(-1.5F, -15.4F, 0.3F, 3.0F, 3.0F, 3.0F, 0.5F, true);

		Armet = new ModelRenderer(this);
		Armet.setPos(-4.0F, -8.0F, -4.0F);
		Armet.texOffs(0, 0).addBox(0.0F, -0.1F, 0.8F, 8.0F, 7.0F, 7.0F, 1.0F, false);
		Armet.texOffs(6, 6).addBox(0.0F, -0.1F, 0.3F, 8.0F, 7.0F, 1.0F, 0.97F, false);
		head.addChild(Armet);

		Plume5 = new ModelRenderer(this);
		Plume5.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume5);
		setRotationAngle(Plume5, -0.8652F, 0.1367F, 0.4554F);
		Plume5.texOffs(12, 25).addBox(-0.6F, -15.5F, 5.2F, 3.0F, 3.0F, 3.0F, 0.5F, true);

		Plume14 = new ModelRenderer(this);
		Plume14.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume14);
		setRotationAngle(Plume14, 0.5463F, -0.5009F, -1.457F);
		Plume14.texOffs(0, 23).addBox(6.6F, 1.7F, 6.5F, 3.0F, 3.0F, 3.0F, 0.5F, false);

		Plume22 = new ModelRenderer(this);
		Plume22.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume22);
		setRotationAngle(Plume22, -0.0911F, 0.6829F, -2.6407F);
		Plume22.texOffs(0, 23).addBox(-7.1F, 2.3F, 2.7F, 3.0F, 3.0F, 3.0F, 0.5F, false);

		Plume17 = new ModelRenderer(this);
		Plume17.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume17);
		setRotationAngle(Plume17, 1.639F, -0.4554F, 0.2731F);
		Plume17.texOffs(0, 23).addBox(3.4F, 5.4F, 2.1F, 3.0F, 3.0F, 3.0F, 0.5F, true);

		Plume24 = new ModelRenderer(this);
		Plume24.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(Plume24);
		setRotationAngle(Plume24, 0.3643F, 0.0456F, 0.0911F);
		Plume24.texOffs(0, 23).addBox(-1.4F, 4.3F, 12.6F, 3.0F, 3.0F, 3.0F, 0.5F, false);

		VisorBottomLeft = new ModelRenderer(this);
		VisorBottomLeft.setPos(-4.0F, -8.0F, -4.0F);
		head.addChild(VisorBottomLeft);
		setRotationAngle(VisorBottomLeft, 0.6829F, -0.6829F, 0.0F);
		VisorBottomLeft.texOffs(30, 0).addBox(0.0F, -1.5F, -6.9F, 7.0F, 6.0F, 0.0F, 0.0F, true);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
