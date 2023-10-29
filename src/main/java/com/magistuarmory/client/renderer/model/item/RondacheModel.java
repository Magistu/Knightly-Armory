package com.magistuarmory.client.renderer.model.item;

import net.minecraft.client.model.ModelRenderer;

// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


public class RondacheModel extends AbstractModelBase 
{
	private final ModelRenderer plate;
	private final ModelRenderer handle;

	public RondacheModel() {
		textureWidth = 64;
		textureHeight = 64;

		plate = new ModelRenderer(this);
		plate.setRotationPoint(1.0F, 2.0F, 0.0F);
		plate.setTextureOffset(0, 0).addBox(-17.0F, -17.0F, -2.0F, 32, 32, 1, 0.0F);
		plate.setTextureOffset(0, 33).addBox(-9.0F, -5.0F, -2.0F, 16, 6, 1, 0.0F);
		plate.setTextureOffset(34, 33).addBox(-8.0F, 1.0F, -2.0F, 14, 2, 1, 0.0F);
		plate.setTextureOffset(38, 36).addBox(-7.0F, 3.0F, -2.0F, 12, 1, 1, 0.0F);
		plate.setTextureOffset(42, 38).addBox(-6.0F, 4.0F, -2.0F, 10, 1, 1, 0.0F);
		plate.setTextureOffset(50, 40).addBox(-4.0F, 5.0F, -2.0F, 6, 1, 1, 0.0F);
		plate.setTextureOffset(34, 42).addBox(-8.0F, -7.0F, -2.0F, 14, 2, 1, 0.0F);
		plate.setTextureOffset(38, 45).addBox(-7.0F, -8.0F, -2.0F, 12, 1, 1, 0.0F);
		plate.setTextureOffset(42, 49).addBox(-6.0F, -9.0F, -2.0F, 10, 1, 1, 0.0F);
		plate.setTextureOffset(50, 47).addBox(-4.0F, -10.0F, -2.0F, 6, 1, 1, 0.0F);

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