package com.magistuarmory.client.renderer.model.entity;// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class SurcoatModel<T extends LivingEntity> extends ArmorDecorationModel<T>
{
	private final ModelRenderer[] parts;

	public SurcoatModel()
	{
		super(-4.0F, 0.0F, 64, 32);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.0F, 0.0F);
		body.texOffs(0, 0).addBox(-5.0F, -1.0F, -3.5F, 10.0F, 19.0F, 7.0F, -0.2F, false);

		parts = new ModelRenderer[] { body };
	}

	public ModelRenderer[] getParts()
	{
		return parts;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}