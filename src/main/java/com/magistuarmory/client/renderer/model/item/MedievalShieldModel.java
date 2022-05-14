package com.magistuarmory.client.renderer.model.item;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public abstract class MedievalShieldModel extends Model
{

	public MedievalShieldModel()
	{
		super(RenderType::entityCutout);
	}
	
	public abstract ModelRenderer plate();

	public abstract ModelRenderer handle();
}
