package com.uraneptus.pigsteel.blocks.stairs.waxed_stairs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class WaxedInfectedCutPigsteelStairs extends StairsBlock {

    public WaxedInfectedCutPigsteelStairs(BlockState state, AbstractBlock.Properties properties) {
        super(state, properties);
    }

    public ActionResultType use(BlockState state, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        if(playerEntity.getItemInHand(hand).getItem() instanceof AxeItem) {
            Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);
            StairsShape shape = state.getValue(BlockStateProperties.STAIRS_SHAPE);
            Half half = state.getValue(BlockStateProperties.HALF);

            playerEntity.swing(hand);
            world.setBlockAndUpdate(blockPos, BlockInit.INFECTED_CUT_PIGSTEEL_STAIRS.get().defaultBlockState()
                    .setValue(BlockStateProperties.HORIZONTAL_FACING, direction)
                    .setValue(BlockStateProperties.WATERLOGGED, watered)
                    .setValue(BlockStateProperties.STAIRS_SHAPE, shape)
                    .setValue(BlockStateProperties.HALF, half));
        }
        return ActionResultType.PASS;
    }
}
