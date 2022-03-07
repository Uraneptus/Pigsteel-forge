package com.uraneptus.pigsteel.init;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class FeatureInit {
    public static Holder<PlacedFeature> PIGSTEEL_ORE_PLACEMENT;

    public static void registerFeatures() {
        OreConfiguration pigsteel_ore = new OreConfiguration(OreFeatures.NETHERRACK, BlockInit.PIGSTEEL_ORE.get().defaultBlockState(), 7);
        PIGSTEEL_ORE_PLACEMENT = register("pigsteel_ore", new ConfiguredFeature<>(Feature.ORE, pigsteel_ore), CountPlacement.of(20), InSquarePlacement.spread(), BiomeFilter.biome(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT);
    }

    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettings.Builder generation = event.getGeneration();

        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, PIGSTEEL_ORE_PLACEMENT);
        }
    }

    public static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> register(String name, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        return PlacementUtils.register(name, Holder.direct(feature), placementModifiers);
    }

}
