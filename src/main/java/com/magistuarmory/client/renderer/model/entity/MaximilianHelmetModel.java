package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

//Made with Blockbench 3.9.2
//Exported for Minecraft version 1.15 - 1.16 with MCP mappings
//Paste this,  class into your mod and generate all required imports


public class MaximilianHelmetModel extends ModelBiped {
    private final ModelRenderer Helmet;
    private final ModelRenderer Helmet_r1;
    private final ModelRenderer Helmet_r2;
    private final ModelRenderer Helmet_r3;
    private final ModelRenderer Helmet_r4;

    public MaximilianHelmetModel() {
        super(-4.0f, 0.0F, 64, 64);
        
        textureWidth = 64;
        textureHeight = 32;
        
        bipedHead = new ModelRenderer(this);

        Helmet = new ModelRenderer(this, 32, 0);
        Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.addChild(Helmet);
        Helmet.addBox(-4.0F, -7.9F, -3.2F, 8, 7, 7, 1.0F);

        Helmet_r1 = new ModelRenderer(this, 0, 5);
        Helmet_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.addChild(Helmet_r1);
        setRotationAngle(Helmet_r1, 0.552F, -0.4648F, 0.0F);
        Helmet_r1.addBox(-3.44F, -7.05F, -3.35F, 7, 5, 0, 0.0F);

        Helmet_r2 = new ModelRenderer(this, 0, 5);
        Helmet_r2.mirror = true;
        Helmet_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.addChild(Helmet_r2);
        setRotationAngle(Helmet_r2, 0.552F, 0.4648F, 0.0F);
        Helmet_r2.addBox(-3.5F, -7.05F, -3.35F, 7, 5, 0, 0.0F);

        Helmet_r3 = new ModelRenderer(this, 0, 0);
        Helmet_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.addChild(Helmet_r3);
        setRotationAngle(Helmet_r3, -0.552F, -0.4648F, 0.0F);
        Helmet_r3.addBox(-3.45F, -5.15F, -7.8F, 7, 5, 0, 0.0F);

        Helmet_r4 = new ModelRenderer(this, 0, 0);
        Helmet_r4.mirror = true;
        Helmet_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.addChild(Helmet_r4);
        setRotationAngle(Helmet_r4, -0.552F, 0.4648F, 0.0F);
        Helmet_r4.addBox(-3.5F, -5.15F, -7.8F, 7, 5, 0, 0.0F);
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}