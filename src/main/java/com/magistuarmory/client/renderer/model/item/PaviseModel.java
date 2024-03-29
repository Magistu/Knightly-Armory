package com.magistuarmory.client.renderer.model.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;

public class PaviseModel extends MedievalShieldModel
{
	private final ModelPart root;
	private final ModelPart plate;
	private final ModelPart handle;

	public PaviseModel(ModelPart p_170911_)
	{
		super(RenderType::entityCutout);
		this.root = p_170911_;
		this.plate = p_170911_.getChild("plate");
		this.handle = p_170911_.getChild("handle");

	}
	
	public static LayerDefinition createLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(0, 0).addBox(-15.5F, -17.0F, -2.0F, 31F, 31F, 1F).texOffs(0, 33).addBox(-9.5F, -12.0F, -2.0F, 19F, 22F, 1F).texOffs(0, 56).addBox(-8.5F, 10.0F, -2.0F, 17F, 1F, 1F).texOffs(0, 58).addBox(-7.5F, 11.0F, -2.0F, 15F, 1F, 1F).texOffs(0, 60).addBox(-8.5F, -13.0F, -2.0F, 17F, 1F, 1F).texOffs(0, 62).addBox(-7.5F, -14.0F, -2.0F, 15F, 1F, 1F).texOffs(13, 0).addBox(-2.5F, -17.0F, -3.0F, 5F, 32F, 1F).texOffs(52, 33).addBox(-2.5F, -14.0F, -3.0F, 5F, 1F, 1F).texOffs(52, 35).addBox(-2.5F, 11.0F, -3.0F, 5F, 1F, 1F), PartPose.ZERO);
		partdefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(48, 52).addBox(-1.0F, -3.0F, -1.0F, 2F, 6F, 6F), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	
	public ModelPart plate() 
	{
		return this.plate;
	}

	public ModelPart handle() 
	{
		return this.handle;
	}

	public void renderToBuffer(PoseStack p_103703_, VertexConsumer p_103704_, int p_103705_, int p_103706_, float p_103707_, float p_103708_, float p_103709_, float p_103710_) 
	{
		this.root.render(p_103703_, p_103704_, p_103705_, p_103706_, p_103707_, p_103708_, p_103709_, p_103710_);
	}
}
