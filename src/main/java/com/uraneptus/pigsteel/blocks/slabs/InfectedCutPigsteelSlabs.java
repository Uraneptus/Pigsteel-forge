package com.uraneptus.pigsteel.blocks.slabs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class InfectedCutPigsteelSlabs extends SlabBlock {

    public InfectedCutPigsteelSlabs(AbstractBlock.Properties properties) {
        super(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).randomTicks());
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(!world.isClientSide) {
            if (world.dimensionType().bedWorks()) {
                SlabType type = state.getValue(BlockStateProperties.SLAB_TYPE);
                Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);

                world.setBlockAndUpdate(pos, BlockInit.CORRUPTED_CUT_PIGSTEEL_SLAB.get().defaultBlockState()
                        .setValue(BlockStateProperties.SLAB_TYPE, type)
                        .setValue(BlockStateProperties.WATERLOGGED, watered));
            }
        }
    }

    public ActionResultType use(BlockState state, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        if(playerEntity.getItemInHand(hand).getItem() == Items.HONEYCOMB) {
            SlabType type = state.getValue(BlockStateProperties.SLAB_TYPE);
            Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);

            playerEntity.swing(hand);
            world.setBlockAndUpdate(blockPos, BlockInit.WAXED_INFECTED_CUT_PIGSTEEL_SLAB.get().defaultBlockState()
                    .setValue(BlockStateProperties.SLAB_TYPE, type)
                    .setValue(BlockStateProperties.WATERLOGGED, watered));
        }
        return ActionResultType.PASS;
    }
}
