package com.magistuarmory.client.renderer.model.item;

import java.util.function.Function;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public abstract class MedievalShieldModel extends Model
{

	public MedievalShieldModel(Function<ResourceLocation, RenderType> p_103110_) 
	{
		super(p_103110_);
	}

	public abstract ModelPart plate();

	public abstract ModelPart handle();

	public abstract void renderToBuffer(PoseStack p_103703_, VertexConsumer p_103704_, int p_103705_, int p_103706_, float p_103707_, float p_103708_, float p_103709_, float p_103710_);
}
