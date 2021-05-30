package com.uraneptus.pigsteel.blocks.stairs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.block.*;
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
                world.setBlockAndUpdate(pos, BlockInit.ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get().defaultBlockState());
            }
        }
    }
}
