package com.uraneptus.pigsteel.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class CutBlocks extends Block {
    private final BlockState zombifyingResult;

    public CutBlocks(BlockState zombifyingResult, Properties properties) {
        super(properties.randomTicks());
        this.zombifyingResult = zombifyingResult;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (!world.isClientSide) {
            if (world.dimensionType().bedWorks()) {
                if (random.nextInt(10) > 6) {
                    world.setBlockAndUpdate(pos, zombifyingResult);
                }
            }
        }
    }

}
