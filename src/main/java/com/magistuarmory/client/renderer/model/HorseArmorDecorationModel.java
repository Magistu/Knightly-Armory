package com.magistuarmory.client.renderer.model;

import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.animal.horse.AbstractHorse;

public abstract class HorseArmorDecorationModel<T extends AbstractHorse> extends HorseModel<T>
{
    public HorseArmorDecorationModel(ModelPart modelpart)
    {
        super(modelpart);
    }

    public abstract ModelPart[] getParts();
}
