package com.uraneptus.pigsteel.blocks.slabs.waxed_slabs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class WaxedCorruptedCutPigsteelSlab extends SlabBlock {

    public WaxedCorruptedCutPigsteelSlab(AbstractBlock.Properties properties) {
        super(properties);
    }

    public ActionResultType use(BlockState state, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        if(playerEntity.getItemInHand(hand).getItem() instanceof AxeItem) {
            SlabType type = state.getValue(BlockStateProperties.SLAB_TYPE);
            Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);

            playerEntity.swing(hand);
            world.setBlockAndUpdate(blockPos, BlockInit.CORRUPTED_CUT_PIGSTEEL_SLAB.get().defaultBlockState()
                    .setValue(BlockStateProperties.SLAB_TYPE, type)
                    .setValue(BlockStateProperties.WATERLOGGED, watered));
        }
        return ActionResultType.PASS;
    }
}
