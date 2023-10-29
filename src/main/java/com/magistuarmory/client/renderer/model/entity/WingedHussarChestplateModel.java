package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


public class WingedHussarChestplateModel extends ModelBiped {
	private final ModelRenderer Wing_r1;
	private final ModelRenderer Wing_r2;

	public WingedHussarChestplateModel() 
	{
		textureWidth = 64;
		textureHeight = 32;

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 0, 0, -4.0F, 0.0F, -2.0F, 8, 12, 4, 1.0F, false));

		Wing_r1 = new ModelRenderer(this);
		Wing_r1.setRotationPoint(-4.0524F, -3.7999F, 6.0F);
		bipedBody.addChild(Wing_r1);
		setRotationAngle(Wing_r1, -0.1309F, 0.0F, -0.1309F);
		Wing_r1.cubeList.add(new ModelBox(Wing_r1, 36, -14, 0.0F, -17.0F, -5.0F, 0, 32, 14, 0.0F, true));

		Wing_r2 = new ModelRenderer(this);
		Wing_r2.setRotationPoint(4.0524F, -3.7999F, 6.5F);
		bipedBody.addChild(Wing_r2);
		setRotationAngle(Wing_r2, -0.1309F, 0.0F, 0.1309F);
		Wing_r2.cubeList.add(new ModelBox(Wing_r2, 36, -14, 0.0F, -17.0F, -5.5F, 0, 32, 14, 0.0F, false));

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 0, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F, false));

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 0, 16, -1.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F, true));
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