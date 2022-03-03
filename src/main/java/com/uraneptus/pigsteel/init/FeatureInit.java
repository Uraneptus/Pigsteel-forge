package com.uraneptus.pigsteel.init;

import com.uraneptus.pigsteel.PigsteelMod;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, PigsteelMod.MOD_ID);

    public static final RegistryObject<Feature<OreConfiguration>> PIGSTEEL_ORE_FEATURE = FEATURES.register("pigsteel_ore_feature", () -> new OreFeature(OreConfiguration.CODEC));

    public static final class Config {
        public static final ConfiguredFeature<?, ?> PIGSTEEL_ORE_CONFIG = FeatureInit.PIGSTEEL_ORE_FEATURE.get().configured(new OreConfiguration(OreFeatures.NETHERRACK, BlockInit.PIGSTEEL_ORE.get().defaultBlockState(), 7));

        public static void registerFeatures() {
            register("pigsteel_ore_feature", PIGSTEEL_ORE_CONFIG);
        }

        /**
         * Modified version of the .register() method in {@link FeatureUtils}
         */
        private static <FC extends FeatureConfiguration> void register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(PigsteelMod.MOD_ID, name), configuredFeature);
        }
    }

    public static final class Placement {
        public static final PlacedFeature PIGSTEEL_ORE_PLACEMENT = FeatureInit.Placement.register("placed_pigsteel_ore_feature", FeatureInit.Config.PIGSTEEL_ORE_CONFIG.placed(OrePlacements.commonOrePlacement(20, PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT)));

        public static void onBiomeLoad(BiomeLoadingEvent event) {
            BiomeGenerationSettings.Builder generation = event.getGeneration();

            if (event.getCategory() == Biome.BiomeCategory.NETHER) {
                generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, PIGSTEEL_ORE_PLACEMENT);
            }
        }

        /**
         * Modified version of the .register() method in {@link PlacementUtils}
         */
        public static PlacedFeature register(String name, PlacedFeature placedFeature) {
            return Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(PigsteelMod.MOD_ID, name), placedFeature);
        }
    }
}
