package com.magistuarmory.client.renderer.model.item;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


public class RondacheModel extends MedievalShieldModel
{
	private final ModelRenderer plate;
	private final ModelRenderer handle;

	public RondacheModel() 
	{
		super();

		texWidth = 64;
		texHeight = 64;

		plate = new ModelRenderer(this);
		plate.setPos(1.0F, 2.0F, 0.0F);
		plate.texOffs(0, 0).addBox(-17.0F, -17.0F, -2.0F, 31, 31, 1, 0.0F);
		plate.texOffs(0, 33).addBox(-9.0F, -5.0F, -2.0F, 16, 6, 1, 0.0F);
		plate.texOffs(34, 33).addBox(-8.0F, 1.0F, -2.0F, 14, 2, 1, 0.0F);
		plate.texOffs(38, 36).addBox(-7.0F, 3.0F, -2.0F, 12, 1, 1, 0.0F);
		plate.texOffs(42, 38).addBox(-6.0F, 4.0F, -2.0F, 10, 1, 1, 0.0F);
		plate.texOffs(50, 40).addBox(-4.0F, 5.0F, -2.0F, 6, 1, 1, 0.0F);
		plate.texOffs(34, 42).addBox(-8.0F, -7.0F, -2.0F, 14, 2, 1, 0.0F);
		plate.texOffs(38, 45).addBox(-7.0F, -8.0F, -2.0F, 12, 1, 1, 0.0F);
		plate.texOffs(42, 49).addBox(-6.0F, -9.0F, -2.0F, 10, 1, 1, 0.0F);
		plate.texOffs(50, 47).addBox(-4.0F, -10.0F, -2.0F, 6, 1, 1, 0.0F);

		handle = new ModelRenderer(this);
		handle.setPos(0.0F, 0.0F, 0.0F);
		handle.texOffs(48, 52).addBox(-1.0F, -3.0F, -1.0F, 2, 6, 6, 0.0F);
	}
	
	public ModelRenderer plate() 
	{
		return this.plate;
	}

	public ModelRenderer handle() 
	{
		return this.handle;
	}

	@Override
	public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_)
	{
		plate.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
		handle.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
	}
}