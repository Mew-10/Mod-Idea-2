package net.benjamin.ideag.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraft.world.item.Items;

public class ModTiers {
    public static final ForgeTier HADES = new ForgeTier(20, 1900, 1f,
            15f, 60, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));

    public static final ForgeTier ARES = new ForgeTier(19, 2000, 0.9f,
            20f, 60, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.REDSTONE));

    public static final ForgeTier THANATOS = new ForgeTier(50, 2000, 0.9f,
            30f, 60, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.REDSTONE));
}
