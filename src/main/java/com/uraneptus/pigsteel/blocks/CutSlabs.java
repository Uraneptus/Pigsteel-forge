package com.uraneptus.pigsteel.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;

import java.util.Random;

public class CutSlabs extends SlabBlock {
    private final BlockState zombifyingResult;

    public CutSlabs(BlockState zombifyingResult, Properties properties) {
        super(properties.randomTicks());
        this.zombifyingResult = zombifyingResult;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if(!world.isClientSide) {
            if (world.dimensionType().bedWorks()) {
                if (random.nextInt(10) > 6) {
                    SlabType type = state.getValue(BlockStateProperties.SLAB_TYPE);
                    Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);

                    world.setBlockAndUpdate(pos, zombifyingResult
                            .setValue(BlockStateProperties.SLAB_TYPE, type)
                            .setValue(BlockStateProperties.WATERLOGGED, watered));
                }
            }
        }
    }

}
