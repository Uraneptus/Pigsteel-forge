package com.uraneptus.pigsteel.blocks;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class CutStairs extends StairBlock {
    private final BlockState zombifyingResult;

    public CutStairs(BlockState zombifyingResult, BlockState state, Properties properties) {
        super(state, properties.randomTicks());
        this.zombifyingResult = zombifyingResult;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (!world.isClientSide) {
            if (world.dimensionType().bedWorks()) {
                if (random.nextInt(10) > 6) {
                    Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                    Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);
                    StairsShape shape = state.getValue(BlockStateProperties.STAIRS_SHAPE);
                    Half half = state.getValue(BlockStateProperties.HALF);
                    world.setBlockAndUpdate(pos, zombifyingResult
                            .setValue(BlockStateProperties.HORIZONTAL_FACING, direction)
                            .setValue(BlockStateProperties.WATERLOGGED, watered)
                            .setValue(BlockStateProperties.STAIRS_SHAPE, shape)
                            .setValue(BlockStateProperties.HALF, half));
                }

            }
        }
    }

}
