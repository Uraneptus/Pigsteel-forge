package com.uraneptus.pigsteel.init;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class FeatureInit {

    public static final List<OreConfiguration.TargetBlockState> PIGSTEEL_ORE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.NETHERRACK, BlockInit.PIGSTEEL_ORE.get().defaultBlockState()));

    public static final class Configured {
        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> PIGSTEEL_ORE = FeatureUtils.register("pigsteel_ore", Feature.ORE, new OreConfiguration(PIGSTEEL_ORE_TARGET_LIST, 10));
    }

    public static final class Placement {
        public static final Holder<PlacedFeature> PIGSTEEL_ORE_PLACEMENT = PlacementUtils.register("pigsteel_ore", Configured.PIGSTEEL_ORE, PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, CountPlacement.of(20), InSquarePlacement.spread(), BiomeFilter.biome());

        public static void onBiomeLoad(BiomeLoadingEvent event) {
            BiomeGenerationSettings.Builder generation = event.getGeneration();

            if (event.getCategory() == Biome.BiomeCategory.NETHER) {
                generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, PIGSTEEL_ORE_PLACEMENT);
            }
        }
    }
}
