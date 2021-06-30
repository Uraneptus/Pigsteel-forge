package com.uraneptus.pigsteel.blocks;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class CutPigsteel extends Block {

    public CutPigsteel(Properties properties) {
        super(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).randomTicks());
    }

    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClientSide) {
            if (world.dimensionType().bedWorks()) {
                world.setBlockAndUpdate(pos, BlockInit.INFECTED_CUT_PIGSTEEL.get().defaultBlockState());
            }
        }
    }

    public ActionResultType use(BlockState state, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        if(playerEntity.getItemInHand(hand).getItem() == Items.HONEYCOMB) {
            playerEntity.swing(hand);
            world.setBlockAndUpdate(blockPos, BlockInit.WAXED_CUT_PIGSTEEL.get().defaultBlockState());
        }
        return ActionResultType.PASS;
    }
}
