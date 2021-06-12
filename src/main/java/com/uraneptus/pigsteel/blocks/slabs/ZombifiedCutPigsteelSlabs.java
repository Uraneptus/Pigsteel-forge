package com.uraneptus.pigsteel.blocks.slabs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ZombifiedCutPigsteelSlabs extends SlabBlock {

    public ZombifiedCutPigsteelSlabs(AbstractBlock.Properties properties) {
        super(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).randomTicks());
    }

}
