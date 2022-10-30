package net.benjamin.ideag.entity.client;

import net.benjamin.ideag.IdeagMod;
import net.benjamin.ideag.entity.custom.MedusaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MedusaModel extends AnimatedGeoModel<MedusaEntity> {
    @Override
    public ResourceLocation getModelLocation(MedusaEntity object) {
        return new ResourceLocation(IdeagMod.MOD_ID, "geo/medusa.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MedusaEntity object) {
        return new ResourceLocation(IdeagMod.MOD_ID, "textures/entity/medusa/medusa.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MedusaEntity animatable) {
        return new ResourceLocation(IdeagMod.MOD_ID, "animations/medusa.animation.json");
    }
}