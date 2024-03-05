package com.uraneptus.pigsteel.data.server;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.other.tags.PigsteelBiomeTags;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import com.uraneptus.pigsteel.data.PigsteelDatagenUtil;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class PigsteelDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder SET_BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatures::create)
            .add(Registries.PLACED_FEATURE, PlacedFeatures::create)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifiers::create);

    public PigsteelDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, SET_BUILDER, Set.of(PigsteelMod.MOD_ID));
    }

    public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_PIGSTEEL_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, PigsteelMod.modPrefix("pigsteel_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_PIGSTEEL_ORE_EXTRA = ResourceKey.create(Registries.CONFIGURED_FEATURE, PigsteelMod.modPrefix("pigsteel_ore_extra"));
    public static final ResourceKey<PlacedFeature> PLACED_PIGSTEEL_ORE = ResourceKey.create(Registries.PLACED_FEATURE, PigsteelMod.modPrefix("pigsteel_ore"));
    public static final ResourceKey<PlacedFeature> PLACED_PIGSTEEL_ORE_EXTRA = ResourceKey.create(Registries.PLACED_FEATURE, PigsteelMod.modPrefix("pigsteel_ore_extra"));

    private static class ConfiguredFeatures {

        public static void create(BootstapContext<ConfiguredFeature<?, ?>> context) {
            register(context, PigsteelDatapackBuiltinEntriesProvider.CONFIGURED_PIGSTEEL_ORE, () -> addPigsteelOreConfig(5, 0.5F));
            register(context, PigsteelDatapackBuiltinEntriesProvider.CONFIGURED_PIGSTEEL_ORE_EXTRA, () -> addPigsteelOreConfig(7, 0.0F));
        }

        private static ConfiguredFeature<?, ?> addPigsteelOreConfig(int veinSize, float discardChanceOnAirExposure) {
            return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_NETHER), PigsteelBlocks.PORKSLAG.get().defaultBlockState(), veinSize, discardChanceOnAirExposure));
        }

        private static void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> featureKey, Supplier<? extends ConfiguredFeature<?, ?>> feature) {
            context.register(featureKey, feature.get());
        }
    }

    private static class PlacedFeatures {
        public static void create(BootstapContext<PlacedFeature> context) {
            register(context, PigsteelDatapackBuiltinEntriesProvider.PLACED_PIGSTEEL_ORE, addOreFeature(context, PigsteelDatapackBuiltinEntriesProvider.CONFIGURED_PIGSTEEL_ORE, 0, 128, 12));
            register(context, PigsteelDatapackBuiltinEntriesProvider.PLACED_PIGSTEEL_ORE_EXTRA, addOreFeature(context, PigsteelDatapackBuiltinEntriesProvider.CONFIGURED_PIGSTEEL_ORE_EXTRA, 0, 128, 8));

        }

        private static PlacedFeature addOreFeature(BootstapContext<PlacedFeature> context, ResourceKey<ConfiguredFeature<?, ?>> configureFeature, int minHeight, int maxHeight, int count) {
            return addFeaturePlacement(context.lookup(Registries.CONFIGURED_FEATURE).get(configureFeature).orElseThrow(), HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)), CountPlacement.of(count), InSquarePlacement.spread(), BiomeFilter.biome());
        }

        private static PlacedFeature addFeaturePlacement(Holder<ConfiguredFeature<?, ?>> configureFeature, PlacementModifier... placementModifiers) {
            return new PlacedFeature(configureFeature, List.of(placementModifiers));
        }

        private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> featureKey, PlacedFeature feature) {
            context.register(featureKey, feature);
        }
    }

    private static class BiomeModifiers {
        public static void create(BootstapContext<BiomeModifier> context) {
            register(context, "pigsteel_ore", () -> addFeatureModifier(context, PigsteelDatagenUtil.getPlacedHolderSet(context, PigsteelDatapackBuiltinEntriesProvider.PLACED_PIGSTEEL_ORE), PigsteelBiomeTags.PIGSTEEL_GENERATE_IN, GenerationStep.Decoration.UNDERGROUND_ORES));
            register(context, "pigsteel_ore_extra", () -> addFeatureModifier(context, PigsteelDatagenUtil.getPlacedHolderSet(context, PigsteelDatapackBuiltinEntriesProvider.PLACED_PIGSTEEL_ORE_EXTRA), PigsteelBiomeTags.HAS_EXTRA_PIGSTEEL, GenerationStep.Decoration.UNDERGROUND_ORES));

        }

        private static ForgeBiomeModifiers.AddFeaturesBiomeModifier addFeatureModifier(BootstapContext<BiomeModifier> context, HolderSet<PlacedFeature> placedSet, TagKey<Biome> biomeTag, GenerationStep.Decoration decoration) {
            return new ForgeBiomeModifiers.AddFeaturesBiomeModifier(context.lookup(Registries.BIOME).getOrThrow(biomeTag), placedSet, decoration);
        }

        private static ForgeBiomeModifiers.AddSpawnsBiomeModifier addSingleSpawnModifier(BootstapContext<BiomeModifier> context, TagKey<Biome> biomeTag, EntityType<?> entity, int weight, int minCount, int maxCount) {
            return ForgeBiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(context.lookup(Registries.BIOME).getOrThrow(biomeTag), new MobSpawnSettings.SpawnerData(entity, weight, minCount, maxCount));
        }

        private static void register(BootstapContext<BiomeModifier> context, String name, Supplier<? extends BiomeModifier> modifier) {
            context.register(ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, PigsteelMod.modPrefix(name)), modifier.get());
        }
    }
}
