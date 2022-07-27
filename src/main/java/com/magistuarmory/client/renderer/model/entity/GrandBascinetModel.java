package com.magistuarmory.client.renderer.model.entity;
// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class GrandBascinetModel extends BipedModel<LivingEntity> {
	private final ModelRenderer Helmet;
	private final ModelRenderer Helmet_r1;
	private final ModelRenderer Helmet_r2;
	private final ModelRenderer Helmet_r3;
	private final ModelRenderer Helmet_r4;
	private final ModelRenderer Helmet_r5;
	private final ModelRenderer Helmet_r6;
	private final ModelRenderer Helmet_r7;

	public GrandBascinetModel() {
		super(-4.5F, 0.0F, 64, 64);
		
		texWidth = 64;
		texHeight = 32;

		this.head = new ModelRenderer(this);
		this.hat = new ModelRenderer(this);

		Helmet = new ModelRenderer(this);
		Helmet.setPos(0.0F, 0.0F, 0.0F);
		Helmet.texOffs(32, 0).addBox(-4.0F, -7.9F, -3.2F, 8.0F, 7.0F, 7.0F, 1.0F, false);
		Helmet.texOffs(38, 6).addBox(-4.0F, -7.9F, -3.7F, 8.0F, 7.0F, 1.0F, 0.97F, false);
		head.addChild(Helmet);

		Helmet_r1 = new ModelRenderer(this);
		Helmet_r1.setPos(0.0354F, -5.2F, -8.1841F);
		Helmet.addChild(Helmet_r1);
		setRotationAngle(Helmet_r1, 0.0F, -0.4648F, 0.0F);
		Helmet_r1.texOffs(0, 10).addBox(-0.0354F, -0.5F, 0.0F, 5.0F, 1.0F, 0.0F, 0.0F, false);

		Helmet_r2 = new ModelRenderer(this);
		Helmet_r2.setPos(0.0354F, -5.2F, -8.1841F);
		Helmet.addChild(Helmet_r2);
		setRotationAngle(Helmet_r2, 0.0F, 0.4648F, 0.0F);
		Helmet_r2.texOffs(0, 10).addBox(-5.0354F, -0.5F, 0.0F, 5.0F, 1.0F, 0.0F, 0.0F, true);

		Helmet_r3 = new ModelRenderer(this);
		Helmet_r3.setPos(-4.6F, -4.9144F, -3.9244F);
		Helmet.addChild(Helmet_r3);
		setRotationAngle(Helmet_r3, -0.829F, 0.0F, 0.0F);
		Helmet_r3.texOffs(23, 19).addBox(0.2F, -2.6856F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, false);
		Helmet_r3.texOffs(23, 19).addBox(9.0F, -2.6856F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, false);

		Helmet_r4 = new ModelRenderer(this);
		Helmet_r4.setPos(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r4);
		setRotationAngle(Helmet_r4, 0.552F, -0.4648F, 0.0F);
		Helmet_r4.texOffs(0, 5).addBox(-3.8F, -8.1F, -3.75F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		Helmet_r5 = new ModelRenderer(this);
		Helmet_r5.setPos(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r5);
		setRotationAngle(Helmet_r5, 0.552F, 0.4648F, 0.0F);
		Helmet_r5.texOffs(0, 5).addBox(-3.2F, -8.1F, -3.75F, 7.0F, 5.0F, 0.0F, 0.0F, true);

		Helmet_r6 = new ModelRenderer(this);
		Helmet_r6.setPos(2.9849F, -5.569F, -6.6221F);
		Helmet.addChild(Helmet_r6);
		setRotationAngle(Helmet_r6, -0.7266F, -0.4648F, 0.0F);
		Helmet_r6.texOffs(0, 0).addBox(-3.5F, -4.931F, -0.1089F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		Helmet_r7 = new ModelRenderer(this);
		Helmet_r7.setPos(-2.9697F, -5.6238F, -6.592F);
		Helmet.addChild(Helmet_r7);
		setRotationAngle(Helmet_r7, -0.7266F, 0.4648F, 0.0F);
		Helmet_r7.texOffs(0, 0).addBox(-3.5F, -4.8762F, -0.108F, 7.0F, 5.0F, 0.0F, 0.0F, true);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}