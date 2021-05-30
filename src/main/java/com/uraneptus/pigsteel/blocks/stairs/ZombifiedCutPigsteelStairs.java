package com.uraneptus.pigsteel.blocks.stairs;

import net.minecraft.block.*;

public class ZombifiedCutPigsteelStairs extends StairsBlock {

    public ZombifiedCutPigsteelStairs(BlockState state, Properties properties) {
        super(state, AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).randomTicks());
    }
}
