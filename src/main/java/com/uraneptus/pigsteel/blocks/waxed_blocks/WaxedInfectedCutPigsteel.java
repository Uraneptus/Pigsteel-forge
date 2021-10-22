package com.uraneptus.pigsteel.blocks.waxed_blocks;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class WaxedInfectedCutPigsteel extends Block {

    public WaxedInfectedCutPigsteel(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public InteractionResult use(BlockState state, Level world, BlockPos blockPos, Player playerEntity, InteractionHand hand, BlockHitResult result) {
        if(playerEntity.getItemInHand(hand).getItem() instanceof AxeItem) {
            playerEntity.swing(hand);
            world.setBlockAndUpdate(blockPos, BlockInit.INFECTED_CUT_PIGSTEEL.get().defaultBlockState());
        }
        return InteractionResult.PASS;
    }
}
