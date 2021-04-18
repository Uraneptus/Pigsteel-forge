package com.uraneptus.pigsteel.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class PigsteelOre extends Block {

    public PigsteelOre(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }
    protected int getExperienceWhenMined(Random random) {
        return MathHelper.nextInt(random, 1,2);
    }

    public void spawnAfterBreak(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.spawnAfterBreak(state, world, pos, stack);
            if(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0){
                int i = this.getExperienceWhenMined(world.random);
                if(i > 0) {
                    this.popExperience(world, pos, i);
                }
            }
    }
}
