package com.uraneptus.pigsteel.blocks.stairs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class CorruptedCutPigsteelStairs extends StairsBlock {

    public CorruptedCutPigsteelStairs(BlockState state, Properties properties) {
        super(state, AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).randomTicks());
    }

    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClientSide) {
            if (world.dimensionType().bedWorks()) {
                Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);
                StairsShape shape = state.getValue(BlockStateProperties.STAIRS_SHAPE);
                Half half = state.getValue(BlockStateProperties.HALF);
                world.setBlockAndUpdate(pos, BlockInit.ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get().defaultBlockState()
                        .setValue(BlockStateProperties.HORIZONTAL_FACING, direction)
                        .setValue(BlockStateProperties.WATERLOGGED, watered)
                        .setValue(BlockStateProperties.STAIRS_SHAPE, shape)
                        .setValue(BlockStateProperties.HALF, half));
            }
        }
    }
}
