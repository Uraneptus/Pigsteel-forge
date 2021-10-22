package com.uraneptus.pigsteel.blocks;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ZombifiedCutPigsteel extends Block {

    public ZombifiedCutPigsteel(Properties properties) {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).randomTicks());
    }

    public InteractionResult use(BlockState state, Level world, BlockPos blockPos, Player playerEntity, InteractionHand hand, BlockHitResult result) {
        if(playerEntity.getItemInHand(hand).getItem() == Items.HONEYCOMB) {
            playerEntity.swing(hand);
            world.setBlockAndUpdate(blockPos, BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL.get().defaultBlockState());
        }
        return InteractionResult.PASS;
    }

}
