package com.magistuarmory.client.renderer.entity.layer;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.model.entity.ArmorDecorationModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ArmorDecorationLayer<T extends LivingEntity, M extends BipedModel<T>, A extends ArmorDecorationModel<T>> extends LayerRenderer<T, M>
{
   private final A model;
   private final ResourceLocation BASE_RESOURCE_LOCATION;
   private final String name;

   public ArmorDecorationLayer(IEntityRenderer<T, M> p_i50936_1_, A p_i50936_2_, ResourceLocation texture, String name)
   {
      super(p_i50936_1_);
      this.model = p_i50936_2_;
      this.BASE_RESOURCE_LOCATION = texture;
      this.name = name;
   }

   public void render(@NotNull MatrixStack p_225628_1_, @NotNull IRenderTypeBuffer p_225628_2_, int p_225628_3_, @NotNull T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_)
   {
      this.renderArmorPiece(p_225628_1_, p_225628_2_, p_225628_4_, EquipmentSlotType.CHEST, p_225628_3_, this.getArmorDecorationModel(EquipmentSlotType.CHEST));
      this.renderArmorPiece(p_225628_1_, p_225628_2_, p_225628_4_, EquipmentSlotType.LEGS, p_225628_3_, this.getArmorDecorationModel(EquipmentSlotType.LEGS));
      this.renderArmorPiece(p_225628_1_, p_225628_2_, p_225628_4_, EquipmentSlotType.FEET, p_225628_3_, this.getArmorDecorationModel(EquipmentSlotType.FEET));
      this.renderArmorPiece(p_225628_1_, p_225628_2_, p_225628_4_, EquipmentSlotType.HEAD, p_225628_3_, this.getArmorDecorationModel(EquipmentSlotType.HEAD));
   }

   private void renderArmorPiece(MatrixStack p_241739_1_, IRenderTypeBuffer p_241739_2_, T p_241739_3_, EquipmentSlotType p_241739_4_, int p_241739_5_, A p_241739_6_)
   {
      ItemStack itemstack = p_241739_3_.getItemBySlot(p_241739_4_);
      if (itemstack.getItem() instanceof ArmorItem)
      {
         ArmorItem armoritem = (ArmorItem)itemstack.getItem();
         if (armoritem.getSlot() == p_241739_4_)
         {
            this.getParentModel().copyPropertiesTo(p_241739_6_);
            this.setPartVisibility(p_241739_6_, p_241739_4_);
            boolean flag1 = itemstack.hasFoil();

            if (itemstack.getTagElement("BlockEntityTag") != null)
            {
               List<Pair<BannerPattern, DyeColor>> list = BannerTileEntity.createPatterns(ShieldItem.getColor(itemstack), BannerTileEntity.getItemPatterns(itemstack));

//               if (armoritem instanceof IDyeableArmorItem)
//               {
//                  int i = ((IDyeableArmorItem)armoritem).getColor(itemstack);
//                  float f = (float)(i >> 16 & 255) / 255.0F;
//                  float f1 = (float)(i >> 8 & 255) / 255.0F;
//                  float f2 = (float)(i & 255) / 255.0F;
//                  this.renderPatterns(p_241739_1_, p_241739_2_, p_241739_5_, OverlayTexture.NO_OVERLAY, list, flag1, p_241739_6_, f, f1, f2);
//               }


               this.renderPatterns(p_241739_1_, p_241739_2_, p_241739_5_, OverlayTexture.NO_OVERLAY, list, flag1, p_241739_6_);
            }
         }
      }
   }

   protected void setPartVisibility(A p_188359_1_, EquipmentSlotType p_188359_2_)
   {
      p_188359_1_.setAllVisible(false);
      switch(p_188359_2_)
      {
      case HEAD:
         p_188359_1_.head.visible = true;
         p_188359_1_.hat.visible = true;
         break;
      case CHEST:
         p_188359_1_.body.visible = true;
         p_188359_1_.rightArm.visible = true;
         p_188359_1_.leftArm.visible = true;
         break;
      case LEGS:
      case FEET:
         p_188359_1_.rightLeg.visible = true;
         p_188359_1_.leftLeg.visible = true;
      }

   }

   private void renderModel(MatrixStack p_241738_1_, IRenderTypeBuffer p_241738_2_, int p_241738_3_, ArmorItem p_241738_4_, boolean p_241738_5_, A p_241738_6_, boolean p_241738_7_, float p_241738_8_, float p_241738_9_, float p_241738_10_, String p_241738_11_)
   {
       renderModel(p_241738_1_, p_241738_2_, p_241738_3_, p_241738_5_, p_241738_6_, p_241738_8_, p_241738_9_, p_241738_10_, this.getArmorDecorationResource());
   }

   private void renderModel(MatrixStack p_241738_1_, IRenderTypeBuffer p_241738_2_, int p_241738_3_, boolean p_241738_5_, A p_241738_6_, float p_241738_8_, float p_241738_9_, float p_241738_10_, ResourceLocation armorResource)
   {
      IVertexBuilder ivertexbuilder = ItemRenderer.getArmorFoilBuffer(p_241738_2_, RenderType.armorCutoutNoCull(armorResource), false, p_241738_5_);
      p_241738_6_.renderToBuffer(p_241738_1_, ivertexbuilder, p_241738_3_, OverlayTexture.NO_OVERLAY, p_241738_8_, p_241738_9_, p_241738_10_, 1.0F);
   }

   private A getArmorDecorationModel(EquipmentSlotType p_241736_1_)
   {
      return this.model;
   }

   private boolean usesInnerModel(EquipmentSlotType p_188363_1_)
   {
      return p_188363_1_ == EquipmentSlotType.LEGS;
   }

   public ResourceLocation getArmorDecorationResource()
   {
      return BASE_RESOURCE_LOCATION;
   }

   public void renderPatterns(MatrixStack p_241717_0_, IRenderTypeBuffer p_241717_1_, int p_241717_2_, int p_241717_3_, List<Pair<BannerPattern, DyeColor>> p_241717_7_, boolean hasfoil, A model)
   {
      renderPatterns(p_241717_0_, p_241717_1_, p_241717_2_, p_241717_3_, p_241717_7_, hasfoil, model, 1.0f, 1.0f, 1.0f);
   }

   public void renderPatterns(MatrixStack p_241717_0_, IRenderTypeBuffer p_241717_1_, int p_241717_2_, int p_241717_3_, List<Pair<BannerPattern, DyeColor>> p_241717_7_, boolean hasfoil, A model, float f, float f1, float f2)
   {
      IVertexBuilder ivertexbuilder = ItemRenderer.getArmorFoilBuffer(p_241717_1_, RenderType.entityCutout(getArmorDecorationResource()), false, hasfoil);

      for (ModelRenderer part : model.getParts())
      {
         part.render(p_241717_0_, ivertexbuilder, p_241717_2_, p_241717_3_, f, f1, f2, 1.0F);

         for (int i = 0; i < 17 && i < p_241717_7_.size(); ++i)
         {
            Pair<BannerPattern, DyeColor> pair = p_241717_7_.get(i);
            float[] afloat = pair.getSecond().getTextureDiffuseColors();

            IVertexBuilder ivertexbuilder0 = ItemRenderer.getArmorFoilBuffer(p_241717_1_, RenderType.entityNoOutline(new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/" + name + "/" + pair.getFirst().getFilename() + ".png")), false, hasfoil);

            part.render(p_241717_0_, ivertexbuilder0, p_241717_2_, p_241717_3_, afloat[0], afloat[1], afloat[2], 1.0F);
         }
      }
   }
}
