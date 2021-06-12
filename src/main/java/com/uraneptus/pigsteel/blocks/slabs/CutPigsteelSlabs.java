package com.uraneptus.pigsteel.blocks.slabs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class CutPigsteelSlabs extends SlabBlock {

    public CutPigsteelSlabs(Properties properties) {
        super(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).randomTicks());
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(!world.isClientSide) {
            if (world.dimensionType().bedWorks()) {
                SlabType type = state.getValue(BlockStateProperties.SLAB_TYPE);
                Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);

                world.setBlockAndUpdate(pos, BlockInit.INFECTED_CUT_PIGSTEEL_SLAB.get().defaultBlockState()
                        .setValue(BlockStateProperties.SLAB_TYPE, type)
                        .setValue(BlockStateProperties.WATERLOGGED, watered));
            }
        }
    }
}
