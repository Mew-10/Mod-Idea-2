package net.benjamin.ideag.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.benjamin.ideag.IdeagMod;
import net.benjamin.ideag.entity.custom.MedusaEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MedusaRenderer extends GeoEntityRenderer<MedusaEntity> {
    public MedusaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MedusaModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(MedusaEntity instance) {
        return new ResourceLocation(IdeagMod.MOD_ID, "textures/entity/medusa/medusa.png");
    }

    @Override
    public RenderType getRenderType(MedusaEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
