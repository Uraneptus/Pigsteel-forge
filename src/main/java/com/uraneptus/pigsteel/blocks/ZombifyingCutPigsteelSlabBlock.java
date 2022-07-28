package com.uraneptus.pigsteel.blocks;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

//Original Oxidization Code by MiteBeMana, used with Permission
public class ZombifyingCutPigsteelSlabBlock extends CutPigsteelSlabBlock implements WeatheringCopper {
    private final WeatheringCopper.WeatherState weatherState;

    public ZombifyingCutPigsteelSlabBlock(WeatheringCopper.WeatherState weatherState, Properties properties) {
        super(properties.randomTicks());
        this.weatherState = weatherState;
    }

    public static Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() ->
            ImmutableBiMap.<Block, Block>builder()
                    .put(BlockInit.CUT_PIGSTEEL_SLAB.get(), BlockInit.INFECTED_CUT_PIGSTEEL_SLAB.get())
                    .put(BlockInit.INFECTED_CUT_PIGSTEEL_SLAB.get(), BlockInit.CORRUPTED_CUT_PIGSTEEL_SLAB.get())
                    .put(BlockInit.CORRUPTED_CUT_PIGSTEEL_SLAB.get(), BlockInit.ZOMBIFIED_CUT_PIGSTEEL_SLAB.get())
                    .build()
    );

    public static final Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());

    @Override
    public void randomTick(BlockState blockState, ServerLevel level, BlockPos pos, Random random) {
        if (level.dimension() == Level.OVERWORLD) {
            this.onRandomTick(blockState, level, pos, random);
        }
    }

    @Override
    public Optional<BlockState> getNext(BlockState state) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(state.getBlock())).map((block -> block.withPropertiesOf(state)));
    }

    public static Optional<BlockState> getPrevious(BlockState state) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(state.getBlock())).isPresent();
    }

    @Override
    public WeatherState getAge() {
        return weatherState;
    }
}
