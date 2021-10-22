package com.uraneptus.pigsteel.init;

import com.uraneptus.pigsteel.PigsteelMod;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, PigsteelMod.MOD_ID);

    public static final RegistryObject<Feature<OreConfiguration>> PIGSTEEL_ORE_FEATURE = FEATURES.register("pigsteel_ore_feature",
            () -> new OreFeature(OreConfiguration.CODEC));

    public static final class Configs {
        public static final ConfiguredFeature<?, ?> PIGSTEEL_ORE_CONFIG = FeatureInit.PIGSTEEL_ORE_FEATURE.get()
                .configured(new OreConfiguration(OreConfiguration.Predicates.NETHERRACK, BlockInit.PIGSTEEL_ORE.get().defaultBlockState(), 7))
                    .range(Features.Decorators.FULL_RANGE).squared().count(20);


        public static void onBiomeLoad(BiomeLoadingEvent event) {
            BiomeGenerationSettingsBuilder generation = event.getGeneration();

            if (event.getCategory() == Biome.BiomeCategory.NETHER) {
                generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, PIGSTEEL_ORE_CONFIG);
            }
        }

        private static <FC extends FeatureConfiguration> void register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(PigsteelMod.MOD_ID, name), configuredFeature);
        }

        public static void registerFeatures() {
            register("pigsteel_ore_feature", PIGSTEEL_ORE_CONFIG);
        }
    }
}
