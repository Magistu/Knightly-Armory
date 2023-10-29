package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


public class BascinetModel extends ModelBiped {
	private final ModelRenderer Helmet;
	private final ModelRenderer Helmet_r1;
	private final ModelRenderer Helmet_r2;
	private final ModelRenderer Helmet_r3;
	private final ModelRenderer Helmet_r4;
	private final ModelRenderer Helmet_r5;

	public BascinetModel() {
		super(-4.5f, 0.0F, 64, 64);
    	
    	textureWidth = 64;
        textureHeight = 32;
        
        bipedHead = new ModelRenderer(this);

		Helmet = new ModelRenderer(this);
		bipedHead.addChild(Helmet);
		Helmet.setRotationPoint(0.0F, 1.0F, 0.0F);
		Helmet.cubeList.add(new ModelBox(Helmet, 0, 0, -4.0F, -8.9F, -3.2F, 8, 7, 7, 1.0F, false));

		Helmet_r1 = new ModelRenderer(this);
		Helmet_r1.setRotationPoint(4.0F, -4.5F, -4.0F);
		Helmet.addChild(Helmet_r1);
		setRotationAngle(Helmet_r1, 0.0F, -0.6615F, 0.0F);
		Helmet_r1.cubeList.add(new ModelBox(Helmet_r1, 50, 21, -6.35F, -1.2F, -1.7F, 0, 4, 7, 0.0F, false));

		Helmet_r2 = new ModelRenderer(this);
		Helmet_r2.setRotationPoint(4.0F, -4.5F, -4.0F);
		Helmet.addChild(Helmet_r2);
		setRotationAngle(Helmet_r2, 0.0F, 0.6615F, 0.0F);
		Helmet_r2.cubeList.add(new ModelBox(Helmet_r2, 50, 21, 0.0F, -1.2F, -6.6F, 0, 4, 7, 0.0F, false));

		Helmet_r3 = new ModelRenderer(this);
		Helmet_r3.setRotationPoint(0.0F, -8.0F, -5.0F);
		Helmet.addChild(Helmet_r3);
		setRotationAngle(Helmet_r3, 0.7854F, 0.0F, 0.0F);
		Helmet_r3.cubeList.add(new ModelBox(Helmet_r3, 0, 14, -4.0F, 1.0F, -1.8F, 8, 2, 2, 0.0F, false));

		Helmet_r4 = new ModelRenderer(this);
		Helmet_r4.setRotationPoint(0.0F, -2.872F, -6.8663F);
		Helmet.addChild(Helmet_r4);
		setRotationAngle(Helmet_r4, -0.2618F, 0.0F, 0.0F);
		Helmet_r4.cubeList.add(new ModelBox(Helmet_r4, 36, 8, -4.0F, 0.372F, -2.1837F, 8, 0, 6, 0.0F, false));

		Helmet_r5 = new ModelRenderer(this);
		Helmet_r5.setRotationPoint(0.0F, -6.0F, -4.0F);
		Helmet.addChild(Helmet_r5);
		setRotationAngle(Helmet_r5, 0.5672F, 0.0F, 0.0F);
		Helmet_r5.cubeList.add(new ModelBox(Helmet_r5, 34, 0, -4.0F, 0.0F, -6.25F, 8, 0, 7, 0.0F, false));
	}

	@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {

        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}