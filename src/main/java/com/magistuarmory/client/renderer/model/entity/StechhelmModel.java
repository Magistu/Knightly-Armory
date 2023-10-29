package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


public class StechhelmModel extends ModelBiped {
	private final ModelRenderer Helmet;
	private final ModelRenderer Helmet_r1;
	private final ModelRenderer Helmet_r2;
	private final ModelRenderer Helmet_r3;
	private final ModelRenderer Helmet_r4;
	private final ModelRenderer Helmet_r5;

	public StechhelmModel() 
	{
		super(-4.0f, 0.0F, 64, 64);
		
		textureWidth = 64;
		textureHeight = 32;
		
		bipedHead = new ModelRenderer(this);

		Helmet = new ModelRenderer(this);
		Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Helmet);
		Helmet.setTextureOffset(34, 0).addBox(-4.0F, -7.5F, -3.2F, 8, 7, 7, 1.0f);

		Helmet_r1 = new ModelRenderer(this);
		Helmet_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Helmet_r1);
		setRotationAngle(Helmet_r1, 1.0472F, -0.4363F, 1.5708F);
		Helmet_r1.setTextureOffset(0, 0).addBox(-10.001F, -4.2F, -2.46F, 8, 4, 7, 0.0F);

		Helmet_r2 = new ModelRenderer(this);
		Helmet_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Helmet_r2);
		setRotationAngle(Helmet_r2, 2.0944F, -0.4363F, 1.5708F);
		Helmet_r2.setTextureOffset(0, 12).addBox(-10.0F, -4.2F, -4.54F, 8, 4, 7, 0.0F);

		Helmet_r3 = new ModelRenderer(this);
		Helmet_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Helmet_r3);
		Helmet_r3.setTextureOffset(0, 23).addBox(-4.0F, -9.3F, -4.0F, 8, 1, 8, 0.3F);

		Helmet_r4 = new ModelRenderer(this);
		Helmet_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Helmet_r4);
		setRotationAngle(Helmet_r4, 1.0472F, -0.4363F, 1.5708F);
		Helmet_r4.setTextureOffset(54, 8).addBox(-10.001F, -4.2F, 4.04F, 2, 3, 0, 0.0F);
		Helmet_r4.mirror = true;

		Helmet_r5 = new ModelRenderer(this);
		Helmet_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		Helmet.addChild(Helmet_r5);
		setRotationAngle(Helmet_r5, 2.0944F, -0.4363F, 1.5708F);
		Helmet_r5.setTextureOffset(56, 8).addBox(-10.0F, -4.2F, -4.04F, 2, 3, 0, 0.0F);
	}
	
	@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    }

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}

