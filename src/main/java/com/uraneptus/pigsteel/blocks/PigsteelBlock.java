package com.uraneptus.pigsteel.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PigsteelBlock extends Block {


    public PigsteelBlock(Properties properties) {
        super(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK));
    }

    public void onPlace(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if(world.dimensionType().bedWorks()) {
            world.setBlock(pos, Blocks.IRON_BLOCK.defaultBlockState(), 3);
            world.levelEvent(2009, pos, 0);
            world.playSound((PlayerEntity)null, pos, SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS,
                    1.0F, (1.0F + world.getRandom().nextFloat() * 0.2F) * 0.7F);
        }
    }
}
