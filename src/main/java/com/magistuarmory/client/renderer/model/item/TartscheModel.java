package com.magistuarmory.client.renderer.model.item;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


public class TartscheModel extends MedievalShieldModel
{
	private final ModelRenderer plate;
	private final ModelRenderer handle;

	public TartscheModel() 
	{
		super();

		texWidth = 64;
		texHeight = 64;

		plate = new ModelRenderer(this);
		plate.setPos(0.0F, 2.0F, 0.0F);
		plate.texOffs(0, 0).addBox(-15.5F, -17.0F, -2.0F, 31, 31, 1, 0.0F);
		plate.texOffs(0, 33).addBox(-6.5F, -4.0F, -2.0F, 13, 5, 1, 0.0F);
		plate.texOffs(32, 33).addBox(-7.5F, 1.0F, -2.0F, 15, 4, 1, 0.0F);
		plate.texOffs(36, 38).addBox(-6.5F, 5.0F, -2.0F, 13, 1, 1, 0.0F);
		plate.texOffs(44, 40).addBox(-4.5F, 6.0F, -2.0F, 9, 1, 1, 0.0F);
		plate.texOffs(48, 42).addBox(-1.5F, -11.0F, -2.0F, 7, 1, 1, 0.0F);
		plate.texOffs(46, 44).addBox(-1.5F, -10.0F, -2.0F, 8, 1, 1, 0.0F);
		plate.texOffs(44, 46).addBox(-1.5F, -9.0F, -2.0F, 9, 1, 1, 0.0F);
		plate.texOffs(42, 48).addBox(-2.5F, -8.0F, -2.0F, 10, 1, 1, 0.0F);
		plate.texOffs(0, 51).addBox(-7.5F, -7.0F, -2.0F, 15, 3, 1, 0.0F);
		plate.texOffs(42, 44).addBox(-6.5F, -10.0F, -2.0F, 1, 1, 1, 0.0F);
		plate.texOffs(38, 46).addBox(-7.5F, -9.0F, -2.0F, 2, 1, 1, 0.0F);
		plate.texOffs(34, 48).addBox(-7.5F, -8.0F, -2.0F, 3, 1, 1, 0.0F);

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