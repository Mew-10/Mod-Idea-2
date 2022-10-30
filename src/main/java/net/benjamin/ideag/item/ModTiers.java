package net.benjamin.ideag.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraft.world.item.Items;

public class ModTiers {
    public static final ForgeTier HADES = new ForgeTier(20, 1900, 1f,
            25f, 60, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));

    public static final ForgeTier HERO = new ForgeTier(10, 1000, 0.8f,
            13f, 60, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));

    public static final ForgeTier ARES = new ForgeTier(19, 2000, 0.9f,
            20f, 60, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.REDSTONE));

    public static final ForgeTier THANATOS = new ForgeTier(50, 2000, 0.9f,
            20f, 60, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.REDSTONE));

    public static final ForgeTier RALLEN = new ForgeTier(24, 650, 0.5f,
            12f, 26, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.RALLEN.get()));

    public static final ForgeTier EREBUS = new ForgeTier(75, 65000, 0.8f,
            47f, 50, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.RALLEN.get()));

    public static final ForgeTier COSMOS = new ForgeTier(1000, 650000, 0.4f,
            77f, 50, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.RALLEN.get()));

}
