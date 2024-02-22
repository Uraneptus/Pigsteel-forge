package com.uraneptus.pigsteel.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public class ZombifiableStairsBlock extends StairBlock implements Zombifiable {

    private ZombificationLevel zombificationLevel;

    public ZombifiableStairsBlock(ZombificationLevel zombificationLevel, Supplier<BlockState> baseBlockState, Properties properties) {
        super(baseBlockState, properties);
        this.zombificationLevel = zombificationLevel;
    }

    @Override
    public MapColor defaultMapColor() {
        return getAge().getMapColor();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel pLevel, BlockPos pos, RandomSource random) {
        this.onRandomTick(state, pLevel, pos, random);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return this.canRandomTick(state);
    }

    @Override
    public ZombificationLevel getAge() {
        return this.zombificationLevel;
    }

}
