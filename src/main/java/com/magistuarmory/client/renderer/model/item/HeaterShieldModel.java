package com.magistuarmory.client.renderer.model.item;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HeaterShieldModel extends AbstractModelBase 
{
	private final ModelRenderer plate;
	private final ModelRenderer handle;

	public HeaterShieldModel()
	{
		textureWidth = 64;
		textureHeight = 64;

		plate = new ModelRenderer(this);
		plate.setRotationPoint(0.0F, 2.0F, 0.0F);
		plate.setTextureOffset(0, 0).addBox(-15.5F, -17.0F, -2.0F, 32, 32, 1, 0.0F);
		plate.setTextureOffset(0, 33).addBox(-7.5F, -10.0F, -2.0F, 15, 11, 1, 0.0F);
		plate.setTextureOffset(36, 33).addBox(-6.5F, 1.0F, -2.0F, 13, 2, 1, 0.0F);
		plate.setTextureOffset(40, 36).addBox(-5.5F, 3.0F, -2.0F, 11, 1, 1, 0.0F);
		plate.setTextureOffset(44, 38).addBox(-4.5F, 4.0F, -2.0F, 9, 1, 1, 0.0F);
		plate.setTextureOffset(48, 40).addBox(-3.5F, 5.0F, -2.0F, 7, 1, 1, 0.0F);
		plate.setTextureOffset(56, 42).addBox(-1.5F, 6.0F, -2.0F, 3, 1, 1, 0.0F);

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