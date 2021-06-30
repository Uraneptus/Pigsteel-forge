package com.uraneptus.pigsteel.blocks.stairs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class InfectedCutPigsteelStairs extends StairsBlock {

    public InfectedCutPigsteelStairs(BlockState state, Properties properties) {
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
                world.setBlockAndUpdate(pos, BlockInit.CORRUPTED_CUT_PIGSTEEL_STAIRS.get().defaultBlockState()
                        .setValue(BlockStateProperties.HORIZONTAL_FACING, direction)
                        .setValue(BlockStateProperties.WATERLOGGED, watered)
                        .setValue(BlockStateProperties.STAIRS_SHAPE, shape)
                        .setValue(BlockStateProperties.HALF, half));
            }
        }
    }

    public ActionResultType use(BlockState state, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        if(playerEntity.getItemInHand(hand).getItem() == Items.HONEYCOMB) {
            Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);
            StairsShape shape = state.getValue(BlockStateProperties.STAIRS_SHAPE);
            Half half = state.getValue(BlockStateProperties.HALF);

            playerEntity.swing(hand);
            world.setBlockAndUpdate(blockPos, BlockInit.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS.get().defaultBlockState()
                    .setValue(BlockStateProperties.HORIZONTAL_FACING, direction)
                    .setValue(BlockStateProperties.WATERLOGGED, watered)
                    .setValue(BlockStateProperties.STAIRS_SHAPE, shape)
                    .setValue(BlockStateProperties.HALF, half));
        }
        return ActionResultType.PASS;
    }
}
