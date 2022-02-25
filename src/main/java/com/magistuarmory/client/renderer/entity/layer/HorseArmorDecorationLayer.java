package com.magistuarmory.client.renderer.entity.layer;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.model.entity.ArmorDecorationModel;
import com.magistuarmory.client.renderer.model.entity.CaparisonModel;
import com.magistuarmory.client.renderer.model.entity.HorseArmorDecorationModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.item.*;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class HorseArmorDecorationLayer extends LayerRenderer<HorseEntity, HorseModel<HorseEntity>>
{
   private final HorseArmorDecorationModel<HorseEntity> model;
   private final ResourceLocation BASE_RESOURCE_LOCATION;
   private final String name;

   public HorseArmorDecorationLayer(IEntityRenderer<HorseEntity, HorseModel<HorseEntity>> p_i50936_1_, CaparisonModel p_i50936_2_, ResourceLocation texture, String name)
   {
      super(p_i50936_1_);
      this.model = p_i50936_2_;
      this.BASE_RESOURCE_LOCATION = texture;
      this.name = name;
   }

   public void render(@NotNull MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, HorseEntity p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_)
   {
      ItemStack itemstack = p_225628_4_.getArmor();
      if (itemstack.getItem() instanceof HorseArmorItem)
      {
         this.getParentModel().copyPropertiesTo(this.model);
         this.model.prepareMobModel(p_225628_4_, p_225628_5_, p_225628_6_, p_225628_7_);
         this.model.setupAnim(p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_);

         if (itemstack.getTagElement("BlockEntityTag") != null)
         {
            List<Pair<BannerPattern, DyeColor>> list = BannerTileEntity.createPatterns(ShieldItem.getColor(itemstack), BannerTileEntity.getItemPatterns(itemstack));
            renderPatterns(p_225628_1_, p_225628_2_, p_225628_3_, OverlayTexture.NO_OVERLAY, list, false, this.model);
         }
      }
   }

   public ResourceLocation getArmorDecorationResource()
   {
      return BASE_RESOURCE_LOCATION;
   }

   public void renderPatterns(MatrixStack p_241717_0_, IRenderTypeBuffer p_241717_1_, int p_241717_2_, int p_241717_3_, List<Pair<BannerPattern, DyeColor>> p_241717_7_, boolean hasfoil, HorseArmorDecorationModel<HorseEntity> model)
   {
      renderPatterns(p_241717_0_, p_241717_1_, p_241717_2_, p_241717_3_, p_241717_7_, hasfoil, model, 1.0f, 1.0f, 1.0f);
   }

   public void renderPatterns(MatrixStack p_241717_0_, IRenderTypeBuffer p_241717_1_, int p_241717_2_, int p_241717_3_, List<Pair<BannerPattern, DyeColor>> p_241717_7_, boolean hasfoil, HorseArmorDecorationModel<HorseEntity> model, float f, float f1, float f2)
   {
      IVertexBuilder ivertexbuilder = ItemRenderer.getArmorFoilBuffer(p_241717_1_, RenderType.entityCutout(getArmorDecorationResource()), false, hasfoil);

      for (ModelRenderer part : model.getParts())
      {
         part.render(p_241717_0_, ivertexbuilder, p_241717_2_, p_241717_3_, f, f1, f2, 1.0F);

         for (int i = 0; i < 17 && i < p_241717_7_.size(); ++i)
         {
            Pair<BannerPattern, DyeColor> pair = p_241717_7_.get(i);
            float[] afloat = pair.getSecond().getTextureDiffuseColors();
            IVertexBuilder ivertexbuilder0 = ItemRenderer.getArmorFoilBuffer(p_241717_1_, RenderType.entityNoOutline(new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/" + name + "/" + pair.getFirst().getFilename() + ".png")), false, hasfoil);

            part.render(p_241717_0_, ivertexbuilder0, p_241717_2_, p_241717_3_, afloat[0], afloat[1], afloat[2], 1.0F);
         }
      }
   }
}
