package com.uraneptus.pigsteel.init;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.blocks.*;
import com.uraneptus.pigsteel.blocks.slabs.CorruptedCutPigsteelSlabs;
import com.uraneptus.pigsteel.blocks.slabs.CutPigsteelSlabs;
import com.uraneptus.pigsteel.blocks.slabs.InfectedCutPigsteelSlabs;
import com.uraneptus.pigsteel.blocks.slabs.ZombifiedCutPigsteelSlabs;
import com.uraneptus.pigsteel.blocks.slabs.waxed_slabs.WaxedCorruptedCutPigsteelSlab;
import com.uraneptus.pigsteel.blocks.slabs.waxed_slabs.WaxedCutPigsteelSlab;
import com.uraneptus.pigsteel.blocks.slabs.waxed_slabs.WaxedInfectedCutPigsteelSlab;
import com.uraneptus.pigsteel.blocks.slabs.waxed_slabs.WaxedZombifiedCutPigsteelSlab;
import com.uraneptus.pigsteel.blocks.stairs.CorruptedCutPigsteelStairs;
import com.uraneptus.pigsteel.blocks.stairs.CutPigsteelStairs;
import com.uraneptus.pigsteel.blocks.stairs.InfectedCutPigsteelStairs;
import com.uraneptus.pigsteel.blocks.stairs.ZombifiedCutPigsteelStairs;
import com.uraneptus.pigsteel.blocks.stairs.waxed_stairs.WaxedCorruptedCutPigsteelStairs;
import com.uraneptus.pigsteel.blocks.stairs.waxed_stairs.WaxedCutPigsteelStairs;
import com.uraneptus.pigsteel.blocks.stairs.waxed_stairs.WaxedInfectedCutPigsteelStairs;
import com.uraneptus.pigsteel.blocks.stairs.waxed_stairs.WaxedZombifiedCutPigsteelStairs;
import com.uraneptus.pigsteel.blocks.waxed_blocks.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final BlockBehaviour.Properties CUT_BLOCKS = BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK);
    public static final BlockBehaviour.Properties BLOCK = BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK);
    public static final BlockBehaviour.Properties NETHER_ORE = BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PigsteelMod.MOD_ID);

    //Ores
    public static final RegistryObject<Block> PIGSTEEL_ORE = BLOCKS.register("pigsteel_ore",
            () -> new PigsteelOre(NETHER_ORE));

    public static final RegistryObject<Block> STONE_PIGSTEEL_ORE = BLOCKS.register("stone_pigsteel_ore",
            () -> new PigsteelOre(BLOCK));

    public static final RegistryObject<Block> DEEPSLATE_PIGSTEEL_ORE = BLOCKS.register("deepslate_pigsteel_ore",
            () -> new PigsteelOre(BLOCK));

    //Block
    public static final RegistryObject<Block> PIGSTEEL_BLOCK = BLOCKS.register("pigsteel_block",
            () -> new PigsteelBlock(BLOCK));

    public static final RegistryObject<Block> WAXED_PIGSTEEL_BLOCK = BLOCKS.register("waxed_pigsteel_block",
            () -> new WaxedPigsteelBlock(BLOCK));

    //Cut
    public static final RegistryObject<Block> CUT_PIGSTEEL = BLOCKS.register("cut_pigsteel",
            () -> new CutPigsteel(CUT_BLOCKS));

    public static final RegistryObject<Block> INFECTED_CUT_PIGSTEEL = BLOCKS.register("infected_cut_pigsteel",
            () -> new InfectedCutPigsteel(CUT_BLOCKS));

    public static final RegistryObject<Block> CORRUPTED_CUT_PIGSTEEL = BLOCKS.register("corrupted_cut_pigsteel",
            () -> new CorruptedCutPigsteel(CUT_BLOCKS));

    public static final RegistryObject<Block> ZOMBIFIED_CUT_PIGSTEEL = BLOCKS.register("zombified_cut_pigsteel",
            () -> new ZombifiedCutPigsteel(CUT_BLOCKS));

    //Cut Stairs
    public static final RegistryObject<Block> CUT_PIGSTEEL_STAIRS = BLOCKS.register("cut_pigsteel_stairs",
            () -> new CutPigsteelStairs(CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    public static final RegistryObject<Block> INFECTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("infected_cut_pigsteel_stairs",
            () -> new InfectedCutPigsteelStairs(INFECTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    public static final RegistryObject<Block> CORRUPTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("corrupted_cut_pigsteel_stairs",
            () -> new CorruptedCutPigsteelStairs(CORRUPTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    public static final RegistryObject<Block> ZOMBIFIED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("zombified_cut_pigsteel_stairs",
            () -> new ZombifiedCutPigsteelStairs(ZOMBIFIED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    //Cut SLabs
    public static final RegistryObject<Block> CUT_PIGSTEEL_SLAB = BLOCKS.register("cut_pigsteel_slab",
            () -> new CutPigsteelSlabs(CUT_BLOCKS));

    public static final RegistryObject<Block> INFECTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("infected_cut_pigsteel_slab",
            () -> new InfectedCutPigsteelSlabs(CUT_BLOCKS));

    public static final RegistryObject<Block> CORRUPTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("corrupted_cut_pigsteel_slab",
            () -> new CorruptedCutPigsteelSlabs(CUT_BLOCKS));

    public static final RegistryObject<Block> ZOMBIFIED_CUT_PIGSTEEL_SLAB = BLOCKS.register("zombified_cut_pigsteel_slab",
            () -> new ZombifiedCutPigsteelSlabs(CUT_BLOCKS));

    //Waxed cut
    public static final RegistryObject<Block> WAXED_CUT_PIGSTEEL = BLOCKS.register("waxed_cut_pigsteel",
            () -> new WaxedCutPigsteel(CUT_BLOCKS));

    public static final RegistryObject<Block> WAXED_INFECTED_CUT_PIGSTEEL = BLOCKS.register("waxed_infected_cut_pigsteel",
            () -> new WaxedInfectedCutPigsteel(CUT_BLOCKS));

    public static final RegistryObject<Block> WAXED_CORRUPTED_CUT_PIGSTEEL = BLOCKS.register("waxed_corrupted_cut_pigsteel",
            () -> new WaxedCorruptedCutPigsteel(CUT_BLOCKS));

    public static final RegistryObject<Block> WAXED_ZOMBIFIED_CUT_PIGSTEEL = BLOCKS.register("waxed_zombified_cut_pigsteel",
            () -> new WaxedZombifiedCutPigsteel(CUT_BLOCKS));

    //Waxed cut stairs
    public static final RegistryObject<Block> WAXED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_cut_pigsteel_stairs",
            () -> new WaxedCutPigsteelStairs(WAXED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    public static final RegistryObject<Block> WAXED_INFECTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_infected_cut_pigsteel_stairs",
            () -> new WaxedInfectedCutPigsteelStairs(WAXED_INFECTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    public static final RegistryObject<Block> WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_corrupted_cut_pigsteel_stairs",
            () -> new WaxedCorruptedCutPigsteelStairs(WAXED_CORRUPTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    public static final RegistryObject<Block> WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_zombified_cut_pigsteel_stairs",
            () -> new WaxedZombifiedCutPigsteelStairs(WAXED_ZOMBIFIED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    //Waxed cut slabs
    public static final RegistryObject<Block> WAXED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_cut_pigsteel_slab",
            () -> new WaxedCutPigsteelSlab(CUT_BLOCKS));

    public static final RegistryObject<Block> WAXED_INFECTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_infected_cut_pigsteel_slab",
            () -> new WaxedInfectedCutPigsteelSlab(CUT_BLOCKS));

    public static final RegistryObject<Block> WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_corrupted_cut_pigsteel_slab",
            () -> new WaxedCorruptedCutPigsteelSlab(CUT_BLOCKS));

    public static final RegistryObject<Block> WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_zombified_cut_pigsteel_slab",
            () -> new WaxedZombifiedCutPigsteelSlab(CUT_BLOCKS));




}

