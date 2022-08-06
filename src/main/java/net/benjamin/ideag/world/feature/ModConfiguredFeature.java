package net.benjamin.ideag.world.feature;

import net.benjamin.ideag.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class ModConfiguredFeature {
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_RALLEN_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RALLEN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RALLEN_ORE.get().defaultBlockState()));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> RALLEN_ORE = FeatureUtils.register("rallen_ore",
            Feature.ORE,(new OreConfiguration(OVERWORLD_RALLEN_ORES, 9)));
}
