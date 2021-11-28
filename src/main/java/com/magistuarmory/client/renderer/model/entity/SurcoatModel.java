package com.magistuarmory.client.renderer.model.entity;// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class SurcoatModel<T extends LivingEntity> extends BipedModel<T>
{

	public SurcoatModel() {
		super(-4.0F, 0.0F, 64, 64);

        this.texWidth = 64;
        this.texHeight = 32;

		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.0F, 0.0F);
		body.texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 17.0F, 4.0F, 1.01F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setPos(-5.0F, 2.0F, 0.0F);
		rightArm.texOffs(48, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.01F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setPos(5.0F, 2.0F, 0.0F);
		leftArm.texOffs(48, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.01F, true);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}