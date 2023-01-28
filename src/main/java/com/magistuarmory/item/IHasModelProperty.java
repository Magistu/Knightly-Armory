package com.magistuarmory.item;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public interface IHasModelProperty 
{
	@OnlyIn(Dist.CLIENT)
	void registerModelProperty();
}
