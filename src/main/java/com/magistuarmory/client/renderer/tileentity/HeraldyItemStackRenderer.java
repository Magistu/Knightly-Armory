package com.magistuarmory.client.renderer.tileentity;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.HeraldyTextures;
import com.magistuarmory.client.renderer.model.item.AbstractModelBase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class HeraldyItemStackRenderer extends TileEntityItemStackRenderer 
{
  protected final HeraldyTextures.Cache BANNER_DESIGNS;
  protected final ResourceLocation TEXTURE_NO_PATTERN;
  protected final Item item;
  protected final AbstractModelBase model;
  protected final TileEntityBanner teBanner = new TileEntityBanner();
  
  public HeraldyItemStackRenderer(ItemShield item, String textureName, String patternName, String bannerID, AbstractModelBase model) 
  {
    this.item = (Item)item;
    this.model = model;
    String textureNoPattern = String.format("textures/entity/%s_nopattern.png", new Object[] { textureName });
    String texturePattern = String.format("textures/entity/%s_pattern.png", new Object[] { textureName });
    this.TEXTURE_NO_PATTERN = new ResourceLocation(KnightlyArmory.ID, textureNoPattern);
    this.BANNER_DESIGNS = new HeraldyTextures.Cache(bannerID, new ResourceLocation(KnightlyArmory.ID, texturePattern), KnightlyArmory.ID + ":textures/entity/" + patternName + "/");
  }
  
  public void renderByItem(ItemStack stack) 
  {
	renderByItem(stack, 1.0F);
  }
  
  public void renderByItem(ItemStack stack, float partialTicks) 
  {
    Item item = stack.getItem();
    if (item == this.item) 
    {
      if (stack.getSubCompound("BlockEntityTag") != null) 
      {
        this.teBanner.setItemValues(stack, true);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.BANNER_DESIGNS.getResourceLocation(this.teBanner.getPatternResourceLocation(), this.teBanner.getPatternList(), this.teBanner.getColorList()));
      } 
      else 
      {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.TEXTURE_NO_PATTERN);
      } 
      GlStateManager.pushMatrix();
      GlStateManager.scale(1.0F, -1.0F, -1.0F);
      this.model.render();
      GlStateManager.popMatrix();
    } 
    super.renderByItem(stack, partialTicks);
  }
}