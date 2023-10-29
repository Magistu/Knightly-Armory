package com.magistuarmory.client.renderer.model.item;

import net.minecraft.client.model.ModelRenderer;

// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


public class EllipticalShieldModel extends AbstractModelBase 
{
	private final ModelRenderer plate;
	private final ModelRenderer handle;

	public EllipticalShieldModel() {
		textureWidth = 64;
		textureHeight = 64;

		plate = new ModelRenderer(this);
		plate.setRotationPoint(0.0F, 2.0F, 0.0F);
		plate.setTextureOffset(0, 0).addBox(-15.5F, -17.0F, -2.0F, 32, 32, 1, 0.0F);
		plate.setTextureOffset(0, 33).addBox(-7.5F, -7.0F, -2.0F, 15, 9, 1, 0.0F);
		plate.setTextureOffset(36, 33).addBox(-6.5F, 2.0F, -2.0F, 13, 2, 1, 0.0F);
		plate.setTextureOffset(40, 36).addBox(-5.5F, 4.0F, -2.0F, 11, 1, 1, 0.0F);
		plate.setTextureOffset(44, 38).addBox(-4.5F, 5.0F, -2.0F, 9, 1, 1, 0.0F);
		plate.setTextureOffset(48, 40).addBox(-2.5F, -12.0F, -2.0F, 5, 1, 1, 0.0F);
		plate.setTextureOffset(36, 48).addBox(-6.5F, -9.0F, -2.0F, 13, 2, 1, 0.0F);
		plate.setTextureOffset(40, 42).addBox(-5.5F, -10.0F, -2.0F, 11, 1, 1, 0.0F);
		plate.setTextureOffset(52, 44).addBox(-2.5F, 6.0F, -2.0F, 5, 1, 1, 0.0F);
		plate.setTextureOffset(44, 46).addBox(-4.5F, -11.0F, -2.0F, 9, 1, 1, 0.0F);

		handle = new ModelRenderer(this);
		handle.setRotationPoint(0.0F, 0.0F, 0.0F);
		handle.setTextureOffset(48, 52).addBox(-1.0F, -3.0F, -1.0F, 2, 6, 6, 0.0F);
	}

	@Override
	public void render()
	{
		plate.render(0.0625F);
		handle.render(0.0625F);
	}
}