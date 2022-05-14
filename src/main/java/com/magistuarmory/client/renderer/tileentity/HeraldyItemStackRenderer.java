package com.magistuarmory.client.renderer.tileentity;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.model.item.*;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.datafixers.util.Pair;
import java.util.List;

import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import com.magistuarmory.item.MedievalShieldItem;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HeraldyItemStackRenderer extends ItemStackTileEntityRenderer 
{
	public static final HeaterShieldModel heaterShieldModel = new HeaterShieldModel();
	public static final PaveseModel paveseModel = new PaveseModel();
	public static final RoundShieldModel roundShieldModel = new RoundShieldModel();
	public static final EllipticalShieldModel ellipticalShieldModel = new EllipticalShieldModel();
	public static final TartscheModel tartscheModel = new TartscheModel();
	public static final RondacheModel rondacheModel = new RondacheModel();
	public static final KiteShieldModel kiteShieldModel = new KiteShieldModel();
	
	private String textureName;
	private String shieldName;
	private MedievalShieldModel model;
	private RenderMaterial SHIELD_BASE;
	private RenderMaterial NO_PATTERN_SHIELD;
	private boolean initialized = false;
	
	
	public HeraldyItemStackRenderer() {}


	public void init(String textureName, String shieldName)
	{
		this.model = shieldName == "heatershield" ? heaterShieldModel :
			shieldName == "pavese" ? paveseModel :
			shieldName == "roundshield" ? roundShieldModel :
			shieldName == "ellipticalshield" ? ellipticalShieldModel :
			shieldName == "tartsche" ? tartscheModel :
			shieldName == "rondache" ? rondacheModel :
			shieldName == "kiteshield" ? kiteShieldModel : null;

		this.SHIELD_BASE = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, new ResourceLocation(KnightlyArmory.ID, "entity/" + textureName + "_pattern"));
		this.NO_PATTERN_SHIELD = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, new ResourceLocation(KnightlyArmory.ID, "entity/" + textureName + "_nopattern"));

		initialized = true;
	}

	@Override
	public void renderByItem(ItemStack p_239207_1_, ItemCameraTransforms.TransformType p_239207_2_, MatrixStack p_239207_3_, IRenderTypeBuffer p_239207_4_, int p_239207_5_, int p_239207_6_)
	{
		Item item = p_239207_1_.getItem();

		if (item instanceof MedievalShieldItem)
	    {
			MedievalShieldItem shield = (MedievalShieldItem)item;
			textureName = shield.getMaterialName() + "_" + shield.getShieldName();
			shieldName = shield.getShieldName();

			if (!initialized)
			{
				init(textureName, shieldName);
			}

			if (model == null)
			{
				super.renderByItem(p_239207_1_, p_239207_2_, p_239207_3_, p_239207_4_, p_239207_5_, p_239207_6_);
				return;
			}

			boolean flag = p_239207_1_.getTagElement("BlockEntityTag") != null;
            p_239207_3_.pushPose();
            p_239207_3_.scale(1.0F, -1.0F, -1.0F);
            RenderMaterial rendermaterial = flag ? SHIELD_BASE : NO_PATTERN_SHIELD;
            IVertexBuilder ivertexbuilder = rendermaterial.sprite().wrap(ItemRenderer.getFoilBufferDirect(p_239207_4_, this.model.renderType(rendermaterial.atlasLocation()), true, p_239207_1_.hasFoil()));
            this.model.handle().render(p_239207_3_, ivertexbuilder, p_239207_5_, p_239207_6_, 1.0F, 1.0F, 1.0F, 1.0F);

			if (flag)
			{
               List<Pair<BannerPattern, DyeColor>> list = BannerTileEntity.createPatterns(ShieldItem.getColor(p_239207_1_), BannerTileEntity.getItemPatterns(p_239207_1_));
               renderPatterns(p_239207_3_, p_239207_4_, p_239207_5_, p_239207_6_, this.model.plate(), rendermaterial, list, p_239207_1_.hasFoil());
            }
			else
			{
               this.model.plate().render(p_239207_3_, ivertexbuilder, p_239207_5_, p_239207_6_, 1.0F, 1.0F, 1.0F, 1.0F);
            }

            p_239207_3_.popPose();
	    }
	}
	
	public void renderPatterns(MatrixStack p_241717_0_, IRenderTypeBuffer p_241717_1_, int p_241717_2_, int p_241717_3_, ModelRenderer p_241717_4_, RenderMaterial p_241717_5_, List<Pair<BannerPattern, DyeColor>> p_241717_7_, boolean p_241717_8_)
	{
		p_241717_4_.render(p_241717_0_, p_241717_5_.buffer(p_241717_1_, RenderType::entityCutout, p_241717_8_), p_241717_2_, p_241717_3_);

		for(int i = 0; i < 17 && i < p_241717_7_.size(); ++i)
		{
			Pair<BannerPattern, DyeColor> pair = p_241717_7_.get(i);
			float[] afloat = pair.getSecond().getTextureDiffuseColors();
			BannerPattern bannerpattern = pair.getFirst();

			RenderMaterial rendermaterial = new RenderMaterial(Atlases.SHIELD_SHEET, new ResourceLocation(KnightlyArmory.ID, "entity/" + shieldName + "/" + bannerpattern.getFilename()));
			p_241717_4_.render(p_241717_0_, rendermaterial.buffer(p_241717_1_, RenderType::entityNoOutline), p_241717_2_, p_241717_3_, afloat[0], afloat[1], afloat[2], 1.0F);
		}
	}
}