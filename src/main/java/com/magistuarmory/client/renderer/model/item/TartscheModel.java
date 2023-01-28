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

// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


public class TartscheModel extends MedievalShieldModel 
{
	private final ModelPart root;
	private final ModelPart plate;
	private final ModelPart handle;

	public TartscheModel(ModelPart p_170911_)
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
		partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(0, 0).addBox(-15.5F, -17.0F, -2.0F, 31F, 31F, 1F).texOffs(0, 33).addBox(-6.5F, -4.0F, -2.0F, 13F, 5F, 1F).texOffs(32, 33).addBox(-7.5F, 1.0F, -2.0F, 15F, 4F, 1F).texOffs(36, 38).addBox(-6.5F, 5.0F, -2.0F, 13F, 1F, 1F).texOffs(44, 40).addBox(-4.5F, 6.0F, -2.0F, 9F, 1F, 1F).texOffs(48, 42).addBox(-1.5F, -11.0F, -2.0F, 7F, 1F, 1F).texOffs(46, 44).addBox(-1.5F, -10.0F, -2.0F, 8F, 1F, 1F).texOffs(44, 46).addBox(-1.5F, -9.0F, -2.0F, 9F, 1F, 1F).texOffs(42, 48).addBox(-2.5F, -8.0F, -2.0F, 10F, 1F, 1F).texOffs(0, 51).addBox(-7.5F, -7.0F, -2.0F, 15F, 3F, 1F).texOffs(42, 44).addBox(-6.5F, -10.0F, -2.0F, 1F, 1F, 1F).texOffs(38, 46).addBox(-7.5F, -9.0F, -2.0F, 2F, 1F, 1F).texOffs(34, 48).addBox(-7.5F, -8.0F, -2.0F, 3F, 1F, 1F), PartPose.ZERO);
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