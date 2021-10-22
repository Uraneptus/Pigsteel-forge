package com.uraneptus.pigsteel.blocks.stairs.waxed_stairs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.phys.BlockHitResult;

public class WaxedInfectedCutPigsteelStairs extends StairBlock {

    public WaxedInfectedCutPigsteelStairs(BlockState state, BlockBehaviour.Properties properties) {
        super(state, properties);
    }

    public InteractionResult use(BlockState state, Level world, BlockPos blockPos, Player playerEntity, InteractionHand hand, BlockHitResult result) {
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
        return InteractionResult.PASS;
    }
}
