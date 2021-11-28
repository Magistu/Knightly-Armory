package com.magistuarmory.client.renderer.entity.layer;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.item.INoHatLayer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class RemovingHatLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M>
{

    public RemovingHatLayer(IEntityRenderer<T, M> entityRendererIn)
    {
        super(entityRendererIn);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
    {
        EntityModel<T> entitymodel = this.getParentModel();
        if (entitymodel instanceof BipedModel)
        {
            BipedModel<T> bipedmodel = (BipedModel<T>)entitymodel;
            if (entitylivingbaseIn.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof INoHatLayer)
            {
                bipedmodel.hat = new ModelRenderer(bipedmodel);
                bipedmodel.hat.visible = false;
            }
            else
            {
                bipedmodel.hat = new ModelRenderer(bipedmodel, 32, 0);
                bipedmodel.hat.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5f);
                bipedmodel.hat.visible = true;
            }
        }
    }
}
