package com.uraneptus.pigsteel.init;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class FeatureInit {

    /*public static void addOres(final BiomeLoadingEvent event) {
        addOre(event, OreConfiguration.Predicates.NETHERRACK, BlockInit.PIGSTEEL_ORE.get().defaultBlockState(), 10, 0, 128, 15);
    }

    public static void addOre(final BiomeLoadingEvent event, RuleTest rule, BlockState state, int veinSize, int minHeight, int maxHight, int amount) {
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Feature.ORE
                .configured(new OreConfiguration(rule, state, veinSize)).decorated(FeatureDecorator.RANGE
                        .configured(new RangeDecoratorConfiguration(minHeight, 0, maxHight))).squared().count(amount));
    }*/
}
