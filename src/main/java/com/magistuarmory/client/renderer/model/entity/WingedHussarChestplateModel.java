package com.magistuarmory.client.renderer.model.entity;// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class WingedHussarChestplateModel extends BipedModel<LivingEntity>
{
	private final ModelRenderer Wing_r1;
	private final ModelRenderer Wing_r2;

	public WingedHussarChestplateModel() {
		super(-4.0F, 0.0F, 64, 64);

        this.texWidth = 64;
        this.texHeight = 32;

		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.0F, 0.0F);
		body.texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 1.0F, false);

		Wing_r1 = new ModelRenderer(this);
		Wing_r1.setPos(-4.0524F, -3.7999F, 6.0F);
		body.addChild(Wing_r1);
		setRotationAngle(Wing_r1, -0.1309F, 0.0F, -0.1309F);
		Wing_r1.texOffs(36, -14).addBox(0.0F, -17.0F, -5.0F, 0.0F, 32.0F, 14.0F, 0.0F, true);

		Wing_r2 = new ModelRenderer(this);
		Wing_r2.setPos(4.0524F, -3.7999F, 6.5F);
		body.addChild(Wing_r2);
		setRotationAngle(Wing_r2, -0.1309F, 0.0F, 0.1309F);
		Wing_r2.texOffs(36, -14).addBox(0.0F, -17.0F, -5.5F, 0.0F, 32.0F, 14.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setPos(-5.0F, 2.0F, 0.0F);
		rightArm.texOffs(0, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setPos(5.0F, 2.0F, 0.0F);
		leftArm.texOffs(0, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, true);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}