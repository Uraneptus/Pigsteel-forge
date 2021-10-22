package com.uraneptus.pigsteel.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class PigsteelOre extends Block {

    public PigsteelOre(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }
    protected int getExperienceWhenMined(Random random) {
        return Mth.nextInt(random, 1,2);
    }

    public void spawnAfterBreak(BlockState state, ServerLevel world, BlockPos pos, ItemStack stack) {
        super.spawnAfterBreak(state, world, pos, stack);
            if(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0){
                int i = this.getExperienceWhenMined(world.random);
                if(i > 0) {
                    this.popExperience(world, pos, i);
                }
            }
    }
}
