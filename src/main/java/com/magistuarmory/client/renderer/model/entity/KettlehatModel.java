package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
//Made with Blockbench 3.9.2
//Exported for Minecraft version 1.15 - 1.16 with MCP mappings
//Paste this class into your mod and generate all required imports


public class KettlehatModel extends ModelBiped {
	private final ModelRenderer Helmet;
	private final ModelRenderer Helmet_r1;
	private final ModelRenderer Helmet_r2;

	public KettlehatModel() {
		super(-4.0f, 0.0F, 64, 64);
		
		textureWidth = 64;
		textureHeight = 32;
		
		bipedHead = new ModelRenderer(this);

		Helmet = new ModelRenderer(this, 32, 0);
		Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Helmet);
		Helmet.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 1.0F);
		
		Helmet_r1 = new ModelRenderer(this, 0, 18);
		Helmet_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Helmet_r1);
		Helmet_r1.addBox(-7.0F, -4.3F, -7.0F, 14, -2, 14, 1.0F);
		
		Helmet_r2 = new ModelRenderer(this, 28, 18);
		Helmet_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Helmet_r1);
		Helmet_r2.addBox(-7.0F, -4.4F, -7.0F, 14, -2, 14, 1.0F);
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