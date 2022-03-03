package com.uraneptus.pigsteel.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class PigsteelBlock extends Block {


    public PigsteelBlock(Properties properties) {
        super(properties);
    }

    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify) {
        if(world.dimensionType().bedWorks()) {
            world.setBlock(pos, Blocks.IRON_BLOCK.defaultBlockState(), 3);
            world.levelEvent(2009, pos, 0);
            world.playSound((Player)null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS,
                    1.0F, (1.0F + world.getRandom().nextFloat() * 0.2F) * 0.7F);
        }
    }

}
