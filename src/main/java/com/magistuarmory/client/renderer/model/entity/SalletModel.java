package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this,  class into your mod and generate all required imports


public class SalletModel extends ModelBiped {
    private final ModelRenderer Helmet;
    private final ModelRenderer Helmet_r1;
    private final ModelRenderer Helmet_r2;
    private final ModelRenderer Helmet_r3;
    private final ModelRenderer Helmet_r4;
    private final ModelRenderer Helmet_r5;
    private final ModelRenderer Helmet_r6;

    public SalletModel() 
    {
        super(-4.0f, 0.0F, 64, 64);
        
        textureWidth = 64;
        textureHeight = 32;
        
        bipedHead = new ModelRenderer(this);

        Helmet = new ModelRenderer(this, 32, 0);
        Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.addChild(Helmet);
        Helmet.addBox(-4.0F, -8.1F, -4.2F, 8, 7, 8, 1.0F);

        Helmet_r1 = new ModelRenderer(this, 39, 5);
        Helmet_r1.setRotationPoint(-4.0F, 0.0F, -3.0F);
        bipedHead.addChild(Helmet_r1);
        setRotationAngle(Helmet_r1, 0.0F, 0.2618F, 1.5708F);
        Helmet_r1.addBox(-3.3F, -9.5F, -1.6F, 1, 11, 9, 0.0F);

        Helmet_r2 = new ModelRenderer(this, 0, 18);
        Helmet_r2.setRotationPoint(6.0F, 0.0F, 0.0F);
        bipedHead.addChild(Helmet_r2);
        setRotationAngle(Helmet_r2, -1.789F, 0.1309F, 1.5708F);
        Helmet_r2.addBox(-9.3F, 1.6F, 1.67F, 8, 4, 6, 0.0F);

        Helmet_r3 = new ModelRenderer(this, 0, 0);
        Helmet_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.addChild(Helmet_r3);
        setRotationAngle(Helmet_r3, -1.3526F, 0.1309F, 1.5708F);
        Helmet_r3.addBox(-9.3F, 2.9F, -1.806F, 8, 4, 6, 0.0F);

        Helmet_r4 = new ModelRenderer(this, 28, 18);
        Helmet_r4.setRotationPoint(-4.0F, 0.0F, 0.0F);
        bipedHead.addChild(Helmet_r4);
        setRotationAngle(Helmet_r4, -2.0071F, 0.2618F, 1.5708F);
        Helmet_r4.addBox(-2.501F, -4.7F, -6.6F, 1, 4, 6, 0.0F);

        Helmet_r5 = new ModelRenderer(this, 28, 18);
        Helmet_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.addChild(Helmet_r5);
        setRotationAngle(Helmet_r5, -1.1345F, 0.2618F, 1.5708F);
        Helmet_r5.addBox(-2.5F, -6.4F, -3.01F, 1, 4, 6, 0.0F);
        
        Helmet_r6 = new ModelRenderer(this, 45, 15);
        Helmet_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.addChild(Helmet_r6);
        setRotationAngle(Helmet_r6, 0.0F, -0.7854F, 0.0F);
        Helmet_r6.addBox(-4.7F, -2.6F, -4.7F, 3, 3, 3, -0.2F);
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}