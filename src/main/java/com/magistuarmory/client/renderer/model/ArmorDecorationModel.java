package com.magistuarmory.client.renderer.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public abstract class ArmorDecorationModel<T extends LivingEntity> extends HumanoidModel<T>
{
    public ArmorDecorationModel(ModelPart modelpart)
    {
        super(modelpart);
    }

    public abstract ModelPart[] getParts();
}
