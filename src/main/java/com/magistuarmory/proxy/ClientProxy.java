package com.magistuarmory.proxy;

import java.io.IOException;

import com.magistuarmory.client.renderer.model.item.AbstractModelBase;
import com.magistuarmory.client.renderer.model.item.HeaterShieldModel;
import com.magistuarmory.client.renderer.model.item.EllipticalShieldModel;
import com.magistuarmory.client.renderer.model.item.PaveseModel;
import com.magistuarmory.client.renderer.model.item.RondacheModel;
import com.magistuarmory.client.renderer.model.item.RoundShieldModel;
import com.magistuarmory.client.renderer.model.item.TartscheModel;
import com.magistuarmory.client.renderer.tileentity.HeraldyItemStackRenderer;
import com.magistuarmory.config.EpicFightConfig;
import com.magistuarmory.init.ModItems;
import com.magistuarmory.item.MedievalShieldItem;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy
{
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	public void registerHeraldyItemStackRenderer(Item item)
	{
		if (item instanceof MedievalShieldItem && ((MedievalShieldItem)item).getModel() != null)
		{
			setHeraldyItemStackRenderer((ItemShield)item, item.getRegistryName().getResourcePath(), ((MedievalShieldItem)item).getShieldName(), item.getRegistryName().getResourcePath().toUpperCase(), ((MedievalShieldItem)item).getModel());
		}
	}
	
	protected static void setHeraldyItemStackRenderer(ItemShield item, String textureName, String patternName, String bannerID, AbstractModelBase model) {
	    if (item == null)
	        return;
	    item.setTileEntityItemStackRenderer((TileEntityItemStackRenderer)new HeraldyItemStackRenderer(item, textureName, patternName, bannerID, model));
	}
	
	public static void addEpicFightConfig() throws IOException 
	{
		EpicFightConfig epicFightConfig = new EpicFightConfig();
		epicFightConfig.addEpicFightConfig();
	}
	
}
