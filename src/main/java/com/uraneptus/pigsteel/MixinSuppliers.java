package com.uraneptus.pigsteel;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class MixinSuppliers {

    public static final Supplier<BiMap<Block, Block>> PIGSTEEL_UNWAX_TO_WAX = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder().put(BlockInit.CUT_PIGSTEEL.get(), BlockInit.WAXED_CUT_PIGSTEEL.get()).put(BlockInit.INFECTED_CUT_PIGSTEEL.get(), BlockInit.WAXED_INFECTED_CUT_PIGSTEEL.get()).put(BlockInit.CORRUPTED_CUT_PIGSTEEL.get(), BlockInit.WAXED_CORRUPTED_CUT_PIGSTEEL.get()).put(BlockInit.ZOMBIFIED_CUT_PIGSTEEL.get(), BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL.get()).put(BlockInit.CUT_PIGSTEEL_STAIRS.get(), BlockInit.WAXED_CUT_PIGSTEEL_STAIRS.get()).put(BlockInit.INFECTED_CUT_PIGSTEEL_STAIRS.get(), BlockInit.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS.get()).put(BlockInit.CORRUPTED_CUT_PIGSTEEL_STAIRS.get(), BlockInit.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS.get()).put(BlockInit.ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get(), BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get()).put(BlockInit.CUT_PIGSTEEL_SLAB.get(), BlockInit.WAXED_CUT_PIGSTEEL_SLAB.get()).put(BlockInit.INFECTED_CUT_PIGSTEEL_SLAB.get(), BlockInit.WAXED_INFECTED_CUT_PIGSTEEL_SLAB.get()).put(BlockInit.CORRUPTED_CUT_PIGSTEEL_SLAB.get(), BlockInit.WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB.get()).put(BlockInit.ZOMBIFIED_CUT_PIGSTEEL_SLAB.get(), BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB.get()).put(BlockInit.PIGSTEEL_BLOCK.get(), BlockInit.WAXED_PIGSTEEL_BLOCK.get()).build());

    public static final Supplier<BiMap<Block, Block>> PIGSTEEL_WAX_TO_UNWAX = Suppliers.memoize(() -> PIGSTEEL_UNWAX_TO_WAX.get().inverse());

    private static final Supplier<BiMap<Block, Block>> PIGSTEEL_ZOMBIFICATION_LEVEL_INCREASES = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder().put(BlockInit.CUT_PIGSTEEL.get(), BlockInit.INFECTED_CUT_PIGSTEEL.get()).put(BlockInit.INFECTED_CUT_PIGSTEEL.get(), BlockInit.CORRUPTED_CUT_PIGSTEEL.get()).put(BlockInit.CORRUPTED_CUT_PIGSTEEL.get(), BlockInit.ZOMBIFIED_CUT_PIGSTEEL.get()).put(BlockInit.CUT_PIGSTEEL_STAIRS.get(), BlockInit.INFECTED_CUT_PIGSTEEL_STAIRS.get()).put(BlockInit.INFECTED_CUT_PIGSTEEL_STAIRS.get(), BlockInit.CORRUPTED_CUT_PIGSTEEL_STAIRS.get()).put(BlockInit.CORRUPTED_CUT_PIGSTEEL_STAIRS.get(), BlockInit.ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get()).put(BlockInit.CUT_PIGSTEEL_SLAB.get(), BlockInit.INFECTED_CUT_PIGSTEEL_SLAB.get()).put(BlockInit.INFECTED_CUT_PIGSTEEL_SLAB.get(), BlockInit.CORRUPTED_CUT_PIGSTEEL_SLAB.get()).put(BlockInit.CORRUPTED_CUT_PIGSTEEL_SLAB.get(), BlockInit.ZOMBIFIED_CUT_PIGSTEEL_SLAB.get()).build());

    public static final Supplier<BiMap<Block, Block>> PIGSTEEL_ZOMBIFICATION_LEVEL_DECREASES = Suppliers.memoize(() -> PIGSTEEL_ZOMBIFICATION_LEVEL_INCREASES.get().inverse());
}
