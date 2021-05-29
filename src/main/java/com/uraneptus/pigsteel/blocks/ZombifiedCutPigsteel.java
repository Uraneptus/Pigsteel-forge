package com.uraneptus.pigsteel.blocks;

import net.minecraft.block.*;

public class ZombifiedCutPigsteel extends Block {

    public ZombifiedCutPigsteel(Properties properties) {
        super(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).randomTicks());
    }

}
