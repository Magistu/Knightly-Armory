package com.magistuarmory.client.renderer.model.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
/**
 * ModelArmetPlume - Magistu
 * Created using Tabula 8.0.0
 */
public class ArmetModel extends ModelBiped {

    private ModelRenderer Plume4;
	private ModelRenderer Plume12;
	private ModelRenderer VisorTopLeft;
	private ModelRenderer VisorBottomRight;
	private ModelRenderer Plume7;
	private ModelRenderer Plume21;
	private ModelRenderer Plume1;
	private ModelRenderer Plume0;
	private ModelRenderer Plume2;
	private ModelRenderer Plume11;
	private ModelRenderer Plume27;
	private ModelRenderer Plume8;
	private ModelRenderer VisorTopRight;
	private ModelRenderer Plume28;
	private ModelRenderer Plume19;
	private ModelRenderer Armet;
	private ModelRenderer Plume13;
	private ModelRenderer Plume5;
	private ModelRenderer Plume14;
	private ModelRenderer Plume22;
	private ModelRenderer Plume17;
	private ModelRenderer Plume24;
	private ModelRenderer VisorBottomLeft;

	public ArmetModel() {
    	super(-4.5f, 0.0F, 64, 64);
    	
    	textureWidth = 64;
        textureHeight = 32;
        
        bipedHead = new ModelRenderer(this);

        Plume4 = new ModelRenderer(this, 12, 18);
        Plume4.mirror = true;
        Plume4.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume4.addBox(4.2F, -12.6F, 6.8F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume4, -1.0016444470669013F, -0.27314402127920984F, 1.0016444470669013F);
        bipedHead.addChild(Plume4);

        Plume12 = new ModelRenderer(this, 0, 23);
        Plume12.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume12.addBox(3.7F, 5.9F, 8.0F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume12, 0.8651597048872669F, -0.13665927909957545F, -0.591841146688116F);
        bipedHead.addChild(Plume12);

        VisorTopLeft = new ModelRenderer(this, 47, 0);
        VisorTopLeft.setRotationPoint(-4.0F, -8.0F, -4.0F);
        VisorTopLeft.addBox(1.0F, 0.36F, -2.216F, 7, 5, 0, 0.0F);
        setRotationAngle(VisorTopLeft, -0.7285004590772052F, -0.6829473549475088F, 0.0F);
        bipedHead.addChild(VisorTopLeft);

        VisorBottomRight = new ModelRenderer(this, 30, 0);
        VisorBottomRight.setRotationPoint(-4.0F, -8.0F, -4.0F);
        VisorBottomRight.addBox(-1.1F, 1.98F, -2.51F, 7, 6, 0, 0.0F);
        setRotationAngle(VisorBottomRight, 0.6829473549475088F, 0.6829473549475088F, 0.0F);
        bipedHead.addChild(VisorBottomRight);

        Plume7 = new ModelRenderer(this, 12, 25);
        Plume7.mirror = true;
        Plume7.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume7.addBox(-5.7F, -16.8F, 3.4F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume7, -1.0016444470669013F, 0.13665927909957545F, 2.458645232063257F);
        bipedHead.addChild(Plume7);

        Plume21 = new ModelRenderer(this, 12, 25);
        Plume21.mirror = true;
        Plume21.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume21.addBox(-2.9F, -14.8F, 2.8F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume21, -1.3203416057653212F, 0.6829473549475088F, 0.0F);
        bipedHead.addChild(Plume21);

        Plume1 = new ModelRenderer(this, 0, 23);
        Plume1.mirror = true;
        Plume1.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume1.addBox(2.5F, -6.8F, 9.7F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume1, -0.3642502295386026F, 0.0F, 0.0F);
        bipedHead.addChild(Plume1);

        Plume0 = new ModelRenderer(this, 24, 17);
        Plume0.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume0.addBox(1.1F, -11.9F, 3.0F, 2, 3, 2, 0.5F);
        setRotationAngle(Plume0, -1.411447814024714F, 0.0911061832922575F, -0.6829473549475088F);
        bipedHead.addChild(Plume0);

        Plume2 = new ModelRenderer(this, 12, 25);
        Plume2.mirror = true;
        Plume2.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume2.addBox(-0.6F, -15.6F, 2.7F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume2, -1.1383037594559906F, -0.0911061832922575F, 1.2747885016356248F);
        bipedHead.addChild(Plume2);

        Plume11 = new ModelRenderer(this, 0, 23);
        Plume11.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume11.addBox(2.5F, 4.5F, 12.1F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume11, 0.3642502295386026F, 0.0F, 0.0F);
        bipedHead.addChild(Plume11);

        Plume27 = new ModelRenderer(this, 12, 25);
        Plume27.mirror = true;
        Plume27.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume27.addBox(-0.6F, -14.6F, 5.2F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume27, -0.956091342937205F, 0.3642502295386026F, -0.13665927909957545F);
        bipedHead.addChild(Plume27);

        Plume8 = new ModelRenderer(this, 12, 25);
        Plume8.mirror = true;
        Plume8.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume8.addBox(-1.5F, -14.6F, 3.0F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume8, -1.5025538891260521F, -0.2275909337942703F, -0.956091342937205F);
        bipedHead.addChild(Plume8);

        VisorTopRight = new ModelRenderer(this, 47, 0);
        VisorTopRight.mirror = true;
        VisorTopRight.setRotationPoint(-4.0F, -8.0F, -4.0F);
        VisorTopRight.addBox(-1.8F, -2.89F, 1.48F, 7, 5, 0, 0.0F);
        setRotationAngle(VisorTopRight, -0.7285004590772052F, 0.6373942508178124F, 0.0F);
        bipedHead.addChild(VisorTopRight);

        Plume28 = new ModelRenderer(this, 0, 23);
        Plume28.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume28.addBox(2.3F, 5.7F, 7.2F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume28, 0.4098033003787853F, 0.18203784630933073F, -1.411447814024714F);
        bipedHead.addChild(Plume28);

        Plume19 = new ModelRenderer(this, 12, 25);
        Plume19.mirror = true;
        Plume19.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume19.addBox(-1.5F, -15.4F, 0.3F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume19, -1.5025538891260521F, 0.45535640450848164F, 0.3642502295386026F);
        bipedHead.addChild(Plume19);

        Armet = new ModelRenderer(this, 0, 0);
        Armet.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Armet.addBox(0.0F, -0.1F, 0.8F, 8, 7, 7, 1.0F);
        Plume13 = new ModelRenderer(this, 12, 17);
        Plume13.mirror = true;
        Plume13.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume13.addBox(-2.2F, -16.7F, 1.3F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume13, -1.9123572560838649F, 0.0911061832922575F, -0.45535640450848164F);
        bipedHead.addChild(Armet);

        Plume5 = new ModelRenderer(this, 12, 25);
        Plume5.mirror = true;
        Plume5.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume5.addBox(-0.6F, -15.5F, 5.2F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume5, -0.8651597048872669F, 0.13665927909957545F, 0.45535640450848164F);
        bipedHead.addChild(Plume5);

        Plume14 = new ModelRenderer(this, 0, 23);
        Plume14.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume14.addBox(6.6F, 1.7F, 6.5F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume14, 0.5462880425584197F, -0.500909508638178F, -1.4570009181544104F);
        bipedHead.addChild(Plume14);

        Plume22 = new ModelRenderer(this, 0, 23);
        Plume22.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume22.addBox(-7.1F, 2.3F, 2.7F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume22, -0.0911061832922575F, 0.6829473549475088F, -2.6406832115306424F);
        bipedHead.addChild(Plume22);

        Plume17 = new ModelRenderer(this, 0, 23);
        Plume17.mirror = true;
        Plume17.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume17.addBox(3.4F, 5.4F, 2.1F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume17, 1.639038764463741F, -0.45535640450848164F, 0.27314402127920984F);
        bipedHead.addChild(Plume17);

        Plume24 = new ModelRenderer(this, 0, 23);
        Plume24.setRotationPoint(-4.0F, -8.0F, -4.0F);
        Plume24.addBox(-1.4F, 4.3F, 12.6F, 3, 3, 3, 0.5F);
        setRotationAngle(Plume24, 0.3642502295386026F, 0.04555309164612875F, 0.0911061832922575F);
        bipedHead.addChild(Plume24);

        VisorBottomLeft = new ModelRenderer(this, 30, 0);
        VisorBottomLeft.mirror = true;
        VisorBottomLeft.setRotationPoint(-4.0F, -8.0F, -4.0F);
        VisorBottomLeft.addBox(0.3F, -1.1655410361852951F, -6.412141966071205F, 7, 6, 0, 0.0F);
        setRotationAngle(VisorBottomLeft, 0.6829473549475088F, -0.6829473549475088F, 0.0F);
        bipedHead.addChild(VisorBottomLeft);
    }

	@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {

        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

