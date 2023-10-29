package com.magistuarmory.proxy;

import java.io.IOException;

import com.magistuarmory.config.EpicFightConfig;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class CommonProxy 
{
	public void registerItemRenderer(Item item, int meta, String id) {}
	
	public void registerHeraldyItemStackRenderer(Item item) {}

	public static void addEpicFightConfig() throws IOException {}
}