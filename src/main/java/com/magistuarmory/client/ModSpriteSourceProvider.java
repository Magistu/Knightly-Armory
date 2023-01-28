package com.magistuarmory.client;

import com.magistuarmory.KnightlyArmory;
import net.minecraft.client.renderer.texture.atlas.sources.SingleFile;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SpriteSourceProvider;

import java.util.Optional;

public class ModSpriteSourceProvider extends SpriteSourceProvider
{
//    protected static final ResourceLocation SHIELD_PATTERNS_ATLAS = new ResourceLocation(KnightlyArmory.ID, "shield_patterns");

	public ModSpriteSourceProvider(PackOutput output, ExistingFileHelper fileHelper)
	{
		super(output, fileHelper, KnightlyArmory.ID);
	}

	@Override
	protected void addSources()
	{
		atlas(SpriteSourceProvider.SHIELD_PATTERNS_ATLAS).addSource(new SingleFile(new ResourceLocation("magistuarmory:entity/bronze_buckler_nopattern"), Optional.empty()));
	}
}
