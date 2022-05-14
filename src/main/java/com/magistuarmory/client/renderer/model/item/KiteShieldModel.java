package com.magistuarmory.client.renderer.model.item;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class KiteShieldModel extends MedievalShieldModel
{
	private final ModelRenderer plate;
	private final ModelRenderer handle;

	public KiteShieldModel()
	{
		super();

		texWidth = 64;
		texHeight = 64;

		plate = new ModelRenderer(this);
		plate.setPos(0.0F, 2.0F, 0.0F);
		plate.texOffs(0, 0).addBox(-15.5F, -17.0F, -2.0F, 31.0F, 32.0F, 1.0F, 0.0F, false);
		plate.texOffs(0, 33).addBox(-3.5F, -9.0F, -2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		plate.texOffs(0, 35).addBox(-5.5F, -8.0F, -2.0F, 11.0F, 2.0F, 1.0F, 0.0F, false);
		plate.texOffs(0, 38).addBox(-6.5F, -6.0F, -2.0F, 13.0F, 7.0F, 1.0F, 0.0F, false);
		plate.texOffs(0, 46).addBox(-5.5F, 1.0F, -2.0F, 11.0F, 2.0F, 1.0F, 0.0F, false);
		plate.texOffs(0, 49).addBox(-4.5F, 3.0F, -2.0F, 9.0F, 2.0F, 1.0F, 0.0F, false);
		plate.texOffs(0, 52).addBox(-3.5F, 5.0F, -2.0F, 7.0F, 2.0F, 1.0F, 0.0F, false);
		plate.texOffs(0, 55).addBox(-2.5F, 7.0F, -2.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		plate.texOffs(0, 58).addBox(-1.5F, 9.0F, -2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		handle = new ModelRenderer(this);
		handle.setPos(0.0F, 0.0F, 0.0F);
		handle.texOffs(48, 52).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);
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