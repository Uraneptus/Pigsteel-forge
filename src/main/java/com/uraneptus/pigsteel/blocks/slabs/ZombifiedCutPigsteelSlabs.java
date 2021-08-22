package com.uraneptus.pigsteel.blocks.slabs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;

import java.util.Random;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ZombifiedCutPigsteelSlabs extends SlabBlock {

    public ZombifiedCutPigsteelSlabs(BlockBehaviour.Properties properties) {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).randomTicks());
    }

    public InteractionResult use(BlockState state, Level world, BlockPos blockPos, Player playerEntity, InteractionHand hand, BlockHitResult result) {
        if(playerEntity.getItemInHand(hand).getItem() == Items.HONEYCOMB) {
            SlabType type = state.getValue(BlockStateProperties.SLAB_TYPE);
            Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);

            playerEntity.swing(hand);
            world.setBlockAndUpdate(blockPos, BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB.get().defaultBlockState()
                    .setValue(BlockStateProperties.SLAB_TYPE, type)
                    .setValue(BlockStateProperties.WATERLOGGED, watered));
        }
        return InteractionResult.PASS;
    }

}
