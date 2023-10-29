package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
//Made with Blockbench 3.9.2
//Exported for Minecraft version 1.15 - 1.16 with MCP mappings
//Paste this class into your mod and generate all required imports


public class BarbuteModel extends ModelBiped {
	private final ModelRenderer Helmet;

	public BarbuteModel() {
		super(-4.0f, 0.0F, 64, 64);
		
		textureWidth = 64;
		textureHeight = 32;
		
		bipedHead = new ModelRenderer(this);

		Helmet = new ModelRenderer(this, 0, 0);
		Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Helmet);
		Helmet.addBox(-4.0F, -7.9F, -4.2F, 8, 7, 8, 1.0F);
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