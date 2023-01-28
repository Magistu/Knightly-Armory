package com.magistuarmory.client.renderer.entity.layer;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.model.CaparisonModel;
import com.magistuarmory.client.renderer.model.HorseArmorDecorationModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class HorseArmorDecorationLayer extends RenderLayer<Horse, HorseModel<Horse>>
{
   private final HorseArmorDecorationModel<Horse> model;
   private final ResourceLocation BASE_RESOURCE_LOCATION;
   private final String name;

   public HorseArmorDecorationLayer(RenderLayerParent<Horse, HorseModel<Horse>> entityRendererIn, HorseArmorDecorationModel<Horse> p_i50936_2_, ResourceLocation texture, String name)
   {
      super(entityRendererIn);
      this.model = p_i50936_2_;
      this.BASE_RESOURCE_LOCATION = texture;
      this.name = name;
   }

   public void render(PoseStack p_117032_, MultiBufferSource p_117033_, int p_117034_, Horse p_117035_, float p_117036_, float p_117037_, float p_117038_, float p_117039_, float p_117040_, float p_117041_)
   {
      ItemStack itemstack = p_117035_.getArmor();
      if (itemstack.getItem() instanceof HorseArmorItem)
      {
         this.getParentModel().copyPropertiesTo(this.model);
         this.model.prepareMobModel(p_117035_, p_117036_, p_117037_, p_117038_);
         this.model.setupAnim(p_117035_, p_117036_, p_117037_, p_117039_, p_117040_, p_117041_);

         if (BlockItem.getBlockEntityData(itemstack) != null)
         {
            List<Pair<Holder<BannerPattern>, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(itemstack), BannerBlockEntity.getItemPatterns(itemstack));

            renderPatterns(p_117032_, p_117033_, p_117034_, OverlayTexture.NO_OVERLAY, list, false, this.model);
         }
      }
   }

   public ResourceLocation getArmorDecorationResource()
   {
      return BASE_RESOURCE_LOCATION;
   }

   public void renderPatterns(PoseStack p_241717_0_, MultiBufferSource p_241717_1_, int p_241717_2_, int p_241717_3_, List<Pair<Holder<BannerPattern>, DyeColor>> p_241717_7_, boolean hasfoil, HorseArmorDecorationModel<Horse> model)
   {
      renderPatterns(p_241717_0_, p_241717_1_, p_241717_2_, p_241717_3_, p_241717_7_, hasfoil, model, 1.0f, 1.0f, 1.0f);
   }

   public void renderPatterns(PoseStack p_241717_0_, MultiBufferSource p_241717_1_, int p_241717_2_, int p_241717_3_, List<Pair<Holder<BannerPattern>, DyeColor>> p_241717_7_, boolean hasfoil, HorseArmorDecorationModel<Horse> model, float f, float f1, float f2)
   {
      VertexConsumer ivertexbuilder = ItemRenderer.getArmorFoilBuffer(p_241717_1_, RenderType.entityCutout(getArmorDecorationResource()), false, hasfoil);

      for (ModelPart part : model.getParts())
      {
         part.render(p_241717_0_, ivertexbuilder, p_241717_2_, p_241717_3_, f, f1, f2, 1.0F);

         for (int i = 0; i < 17 && i < p_241717_7_.size(); ++i)
         {
            Pair<Holder<BannerPattern>, DyeColor> pair = p_241717_7_.get(i);
            float[] afloat = pair.getSecond().getTextureDiffuseColors();
            if (pair.getFirst().unwrapKey().isPresent()) 
            {
               VertexConsumer ivertexbuilder0 = ItemRenderer.getArmorFoilBuffer(p_241717_1_, RenderType.entityNoOutline(new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/" + name + "/" + pair.getFirst().unwrapKey().get().location().getPath() + ".png")), false, hasfoil);
               part.render(p_241717_0_, ivertexbuilder0, p_241717_2_, p_241717_3_, afloat[0], afloat[1], afloat[2], 1.0F);
            }
         }
      }
   }
}
