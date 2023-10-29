package com.magistuarmory.client.renderer.model.item;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PaveseModel extends AbstractModelBase
{
    public ModelRenderer plate;
    public ModelRenderer handle;

    public PaveseModel()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        
        plate = new ModelRenderer(this);
		plate.setRotationPoint(0.0F, 2.0F, 0.0F);
		plate.setTextureOffset(0, 0).addBox(-15.5F, -17.0F, -2.0F, 32, 32, 1, 0.0F);
		plate.setTextureOffset(0, 33).addBox(-9.5F, -12.0F, -2.0F, 19, 22, 1, 0.0F);
		plate.setTextureOffset(0, 56).addBox(-8.5F, 10.0F, -2.0F, 17, 1, 1, 0.0F);
		plate.setTextureOffset(0, 58).addBox(-7.5F, 11.0F, -2.0F, 15, 1, 1, 0.0F);
		plate.setTextureOffset(0, 60).addBox(-8.5F, -13.0F, -2.0F, 17, 1, 1, 0.0F);
		plate.setTextureOffset(0, 62).addBox(-7.5F, -14.0F, -2.0F, 15, 1, 1, 0.0F);
		plate.setTextureOffset(13, 0).addBox(-2.5F, -17.0F, -3.0F, 5, 32, 1, 0.0F);
		plate.setTextureOffset(52, 33).addBox(-2.5F, -14.0F, -3.0F, 5, 1, 1, 0.0F);
		plate.setTextureOffset(52, 35).addBox(-2.5F, 11.0F, -3.0F, 5, 1, 1, 0.0F);

		handle = new ModelRenderer(this);
		handle.setRotationPoint(0.0F, 0.0F, 0.0F);
		handle.setTextureOffset(48, 52).addBox(-1.0F, -3.0F, -1.0F, 2, 6, 6, 0.0F);
    }

    public void render()
    {
        this.plate.render(0.0625F);
        this.handle.render(0.0625F);
    }
}
