package com.magistuarmory.client.renderer.model.item;
// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;


public class TargeModel extends MedievalShieldModel 
{
	private final ModelPart root;
	private final ModelPart plate;
	private final ModelPart handle;

	public TargeModel(ModelPart root)
	{
		super(RenderType::entityCutout);
		this.root = root;
		this.plate = root.getChild("plate");
		this.handle = root.getChild("handle");
	}

	public static LayerDefinition createLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(13, 34).addBox(-4.0F, -8.0F, -2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(11, 36).addBox(-6.0F, -7.0F, -2.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 39).addBox(-7.0F, -5.0F, -2.0F, 12.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(11, 46).addBox(-6.0F, 1.0F, -2.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(13, 49).addBox(-4.0F, 3.0F, -2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.0F, 0.0F));
		partdefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(48, 52).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
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