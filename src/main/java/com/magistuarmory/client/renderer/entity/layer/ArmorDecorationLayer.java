package com.magistuarmory.client.renderer.entity.layer;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.model.ArmorDecorationModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ArmorDecorationLayer<T extends LivingEntity, M extends HumanoidModel<T>, A extends ArmorDecorationModel<T>> extends RenderLayer<T, M>
{
   private final A model;
   private final ResourceLocation BASE_RESOURCE_LOCATION;
   private final String name;

   public ArmorDecorationLayer(RenderLayerParent<T, M> p_i50936_1_, A p_i50936_2_, ResourceLocation texture, String name)
   {
      super(p_i50936_1_);
      this.model = p_i50936_2_;
      this.BASE_RESOURCE_LOCATION = texture;
      this.name = name;
   }

   @Override
   public void render(PoseStack p_117096_, MultiBufferSource p_117097_, int p_117098_, T p_117099_, float p_117100_, float p_117101_, float p_117102_, float p_117103_, float p_117104_, float p_117105_)
   {
      this.renderArmorPiece(p_117096_, p_117097_, p_117099_, EquipmentSlot.CHEST, p_117098_, this.getArmorDecorationModel(EquipmentSlot.CHEST));
      this.renderArmorPiece(p_117096_, p_117097_, p_117099_, EquipmentSlot.LEGS, p_117098_, this.getArmorDecorationModel(EquipmentSlot.LEGS));
      this.renderArmorPiece(p_117096_, p_117097_, p_117099_, EquipmentSlot.FEET, p_117098_, this.getArmorDecorationModel(EquipmentSlot.FEET));
      this.renderArmorPiece(p_117096_, p_117097_, p_117099_, EquipmentSlot.HEAD, p_117098_, this.getArmorDecorationModel(EquipmentSlot.HEAD));
   }

   private void renderArmorPiece(PoseStack p_117119_, MultiBufferSource p_117120_, T p_117121_, EquipmentSlot p_117122_, int p_117123_, A p_117124_)
   {
      ItemStack itemstack = p_117121_.getItemBySlot(p_117122_);
      if (itemstack.getItem() instanceof ArmorItem)
      {
         ArmorItem armoritem = (ArmorItem)itemstack.getItem();
         if (armoritem.getSlot() == p_117122_)
         {
            this.getParentModel().copyPropertiesTo(p_117124_);
            this.setPartVisibility(p_117124_, p_117122_);
            boolean flag1 = itemstack.hasFoil();

            if (BlockItem.getBlockEntityData(itemstack) != null)
            {
               List<Pair<Holder<BannerPattern>, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(itemstack), BannerBlockEntity.getItemPatterns(itemstack));

               renderPatterns(p_117119_, p_117120_, p_117123_, OverlayTexture.NO_OVERLAY, list, flag1, p_117124_);
            }
         }
      }
   }

   protected void setPartVisibility(A p_188359_1_, EquipmentSlot p_188359_2_)
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

   private void renderModel(PoseStack p_117107_, MultiBufferSource p_117108_, int p_117109_, ArmorItem p_117110_, boolean p_117111_, A p_117112_, boolean p_117113_, float p_117114_, float p_117115_, float p_117116_, @Nullable String p_117117_)
   {
       renderModel(p_117107_, p_117108_, p_117109_, p_117111_, p_117112_, p_117114_, p_117115_, p_117116_, this.getArmorDecorationResource());
   }

   private void renderModel(PoseStack p_117107_, MultiBufferSource p_117108_, int p_117109_, boolean p_117111_, A p_117112_, float p_117114_, float p_117115_, float p_117116_, ResourceLocation armorResource)
   {
      VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(p_117108_, RenderType.armorCutoutNoCull(armorResource), false, p_117111_);
      p_117112_.renderToBuffer(p_117107_, vertexconsumer, p_117109_, OverlayTexture.NO_OVERLAY, p_117114_, p_117115_, p_117116_, 1.0F);
   }

   private A getArmorDecorationModel(EquipmentSlot p_241736_1_)
   {
      return this.model;
   }

   public ResourceLocation getArmorDecorationResource()
   {
      return BASE_RESOURCE_LOCATION;
   }

   public void renderPatterns(PoseStack p_241717_0_, MultiBufferSource p_241717_1_, int p_241717_2_, int p_241717_3_, List<Pair<Holder<BannerPattern>, DyeColor>> p_241717_7_, boolean hasfoil, A model)
   {
      renderPatterns(p_241717_0_, p_241717_1_, p_241717_2_, p_241717_3_, p_241717_7_, hasfoil, model, 1.0f, 1.0f, 1.0f);
   }

   public void renderPatterns(PoseStack p_241717_0_, MultiBufferSource p_241717_1_, int p_241717_2_, int p_241717_3_, List<Pair<Holder<BannerPattern>, DyeColor>> p_241717_7_, boolean hasfoil, A model, float f, float f1, float f2)
   {
      VertexConsumer ivertexbuilder = ItemRenderer.getArmorFoilBuffer(p_241717_1_, RenderType.entityCutout(getArmorDecorationResource()), false, hasfoil);

      for (ModelPart part : model.getParts())
      {
         part.render(p_241717_0_, ivertexbuilder, p_241717_2_, p_241717_3_, f, f1, f2, 1.0F);

         for (int i = 0; i < 17 && i < p_241717_7_.size(); ++i) {
            Pair<Holder<BannerPattern>, DyeColor> pair = p_241717_7_.get(i);
            float[] afloat = pair.getSecond().getTextureDiffuseColors();
            if (pair.getFirst().unwrapKey().isPresent()) 
            {
               VertexConsumer ivertexbuilder0 = ItemRenderer.getArmorFoilBuffer(p_241717_1_, RenderType.entityNoOutline(new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/" + name + "/" + pair.getFirst().unwrapKey().get().location().getPath() + ".png")), false, hasfoil);
               part.render(p_241717_0_, ivertexbuilder0, p_241717_2_, p_241717_3_, afloat[0], afloat[1], afloat[2], 1.0F);
            }
         }
      }
   }
}
