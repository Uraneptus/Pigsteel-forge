package com.uraneptus.pigsteel.blocks.waxed_blocks;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class WaxedInfectedCutPigsteel extends Block {

    public WaxedInfectedCutPigsteel(AbstractBlock.Properties properties) {
        super(properties);
    }

    public ActionResultType use(BlockState state, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        if(playerEntity.getItemInHand(hand).getItem() instanceof AxeItem) {
            playerEntity.swing(hand);
            world.setBlockAndUpdate(blockPos, BlockInit.INFECTED_CUT_PIGSTEEL.get().defaultBlockState());
        }
        return ActionResultType.PASS;
    }
}
