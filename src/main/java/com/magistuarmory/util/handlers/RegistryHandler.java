package com.magistuarmory.util.handlers;


import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.model.item.HeaterShieldModel;
import com.magistuarmory.client.renderer.model.item.EllipticalShieldModel;
import com.magistuarmory.client.renderer.model.item.AbstractModelBase;
import com.magistuarmory.client.renderer.model.item.PaveseModel;
import com.magistuarmory.client.renderer.model.item.RoundShieldModel;
import com.magistuarmory.client.renderer.model.item.TartscheModel;
import com.magistuarmory.client.renderer.tileentity.HeraldyItemStackRenderer;
import com.magistuarmory.init.ModItems;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.util.IHasModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelShield;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler
{
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.items)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		
		
	}
}
