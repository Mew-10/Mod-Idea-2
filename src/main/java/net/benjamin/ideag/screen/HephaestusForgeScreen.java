package net.benjamin.ideag.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.benjamin.ideag.IdeagMod;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class HephaestusForgeScreen extends AbstractContainerScreen<HephaestusForgeMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(IdeagMod.MOD_ID, "textures/gui/hephaestus_forge_gui.png");

    public HephaestusForgeScreen(HephaestusForgeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTicks, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        if(menu.isCrafting()) {
            blit(pPoseStack, x + 84, y + 22, 176, 14, menu.getScaledProgress(), 36);
        }

        if(menu.hasFuel()) {
            blit(pPoseStack, x + 18, y + 33 + 14 - menu.getScaledFuelProgress(), 176,
                    14 - menu.getScaledFuelProgress(), 14, menu.getScaledFuelProgress());
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}