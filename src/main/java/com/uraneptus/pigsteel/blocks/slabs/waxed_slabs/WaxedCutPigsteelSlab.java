package com.uraneptus.pigsteel.blocks.slabs.waxed_slabs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;

public class WaxedCutPigsteelSlab extends SlabBlock {

    public WaxedCutPigsteelSlab(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public InteractionResult use(BlockState state, Level world, BlockPos blockPos, Player playerEntity, InteractionHand hand, BlockHitResult result) {
        if(playerEntity.getItemInHand(hand).getItem() instanceof AxeItem) {
            SlabType type = state.getValue(BlockStateProperties.SLAB_TYPE);
            Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);

            playerEntity.swing(hand);
            world.setBlockAndUpdate(blockPos, BlockInit.CUT_PIGSTEEL_SLAB.get().defaultBlockState()
                    .setValue(BlockStateProperties.SLAB_TYPE, type)
                    .setValue(BlockStateProperties.WATERLOGGED, watered));
        }
        return InteractionResult.PASS;
    }
}
