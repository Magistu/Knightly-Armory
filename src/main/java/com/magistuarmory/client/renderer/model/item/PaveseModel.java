package com.magistuarmory.client.renderer.model.item;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.model.ModelRenderer;

public class PaveseModel extends MedievalShieldModel
{
    public ModelRenderer plate;
    public ModelRenderer handle;

    public PaveseModel() 
	{
		super();

        this.texWidth = 64;
        this.texHeight = 64;
        
        plate = new ModelRenderer(this);
		plate.setPos(0.0F, 2.0F, 0.0F);
		plate.texOffs(0, 0).addBox(-15.5F, -17.0F, -2.0F, 31, 31, 1, 0.0F);
		plate.texOffs(0, 33).addBox(-9.5F, -12.0F, -2.0F, 19, 22, 1, 0.0F);
		plate.texOffs(0, 56).addBox(-8.5F, 10.0F, -2.0F, 17, 1, 1, 0.0F);
		plate.texOffs(0, 58).addBox(-7.5F, 11.0F, -2.0F, 15, 1, 1, 0.0F);
		plate.texOffs(0, 60).addBox(-8.5F, -13.0F, -2.0F, 17, 1, 1, 0.0F);
		plate.texOffs(0, 62).addBox(-7.5F, -14.0F, -2.0F, 15, 1, 1, 0.0F);
		plate.texOffs(13, 0).addBox(-2.5F, -17.0F, -3.0F, 5, 32, 1, 0.0F);
		plate.texOffs(52, 33).addBox(-2.5F, -14.0F, -3.0F, 5, 1, 1, 0.0F);
		plate.texOffs(52, 35).addBox(-2.5F, 11.0F, -3.0F, 5, 1, 1, 0.0F);

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
