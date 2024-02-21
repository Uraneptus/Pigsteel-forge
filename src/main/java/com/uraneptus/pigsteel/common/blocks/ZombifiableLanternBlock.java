package com.uraneptus.pigsteel.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;


public class ZombifiableLanternBlock extends PigsteelLanternBlock implements Zombifiable {

    private ZombificationLevel zombificationLevel;

    public ZombifiableLanternBlock(Zombifiable.ZombificationLevel zombificationLevel, Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
        this.zombificationLevel = zombificationLevel;
    }

    @Override
    public MapColor defaultMapColor() {
        return getAge().getMapColor();
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return this.canRandomTick(state);
    }
    @Override
    public void randomTick(BlockState state, ServerLevel pLevel, BlockPos pos, RandomSource random) {
        this.onRandomTick(state, pLevel, pos, random);
    }

    @Override
    public ZombificationLevel getAge() {
        return this.zombificationLevel;
    }
}
