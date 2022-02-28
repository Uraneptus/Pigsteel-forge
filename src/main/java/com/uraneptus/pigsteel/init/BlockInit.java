package com.uraneptus.pigsteel.init;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.blocks.*;
import com.uraneptus.pigsteel.blocks.CutSlabs;
import com.uraneptus.pigsteel.blocks.CutStairs;
import net.minecraft.world.level.block.*;
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
    public static final RegistryObject<Block> PIGSTEEL_ORE = BLOCKS.register("pigsteel_ore", () -> new PigsteelOre(NETHER_ORE));
    public static final RegistryObject<Block> STONE_PIGSTEEL_ORE = BLOCKS.register("stone_pigsteel_ore", () -> new PigsteelOre(BLOCK));
    public static final RegistryObject<Block> DEEPSLATE_PIGSTEEL_ORE = BLOCKS.register("deepslate_pigsteel_ore", () -> new PigsteelOre(BLOCK));

    //Block
    public static final RegistryObject<Block> PIGSTEEL_BLOCK = BLOCKS.register("pigsteel_block", () -> new PigsteelBlock(BLOCK));
    public static final RegistryObject<Block> WAXED_PIGSTEEL_BLOCK = BLOCKS.register("waxed_pigsteel_block", () -> new Block(BLOCK));

    //Cut
    public static final RegistryObject<Block> ZOMBIFIED_CUT_PIGSTEEL = BLOCKS.register("zombified_cut_pigsteel", () -> new Block(CUT_BLOCKS));
    public static final RegistryObject<Block> CORRUPTED_CUT_PIGSTEEL = BLOCKS.register("corrupted_cut_pigsteel", () -> new CutBlocks(ZOMBIFIED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> INFECTED_CUT_PIGSTEEL = BLOCKS.register("infected_cut_pigsteel", () -> new CutBlocks(CORRUPTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> CUT_PIGSTEEL = BLOCKS.register("cut_pigsteel", () -> new CutBlocks(INFECTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    //Cut Stairs
    public static final RegistryObject<Block> ZOMBIFIED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("zombified_cut_pigsteel_stairs", () -> new StairBlock(ZOMBIFIED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> CORRUPTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("corrupted_cut_pigsteel_stairs", () -> new CutStairs(ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get().defaultBlockState(), CORRUPTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> INFECTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("infected_cut_pigsteel_stairs", () -> new CutStairs(CORRUPTED_CUT_PIGSTEEL_STAIRS.get().defaultBlockState(), INFECTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> CUT_PIGSTEEL_STAIRS = BLOCKS.register("cut_pigsteel_stairs", () -> new CutStairs(INFECTED_CUT_PIGSTEEL_STAIRS.get().defaultBlockState(), CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    //Cut SLabs
    public static final RegistryObject<Block> ZOMBIFIED_CUT_PIGSTEEL_SLAB = BLOCKS.register("zombified_cut_pigsteel_slab", () -> new SlabBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> CORRUPTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("corrupted_cut_pigsteel_slab", () -> new CutSlabs(ZOMBIFIED_CUT_PIGSTEEL_SLAB.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> INFECTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("infected_cut_pigsteel_slab", () -> new CutSlabs(CORRUPTED_CUT_PIGSTEEL_SLAB.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> CUT_PIGSTEEL_SLAB = BLOCKS.register("cut_pigsteel_slab", () -> new CutSlabs(INFECTED_CUT_PIGSTEEL_SLAB.get().defaultBlockState(), CUT_BLOCKS));

    //Waxed cut
    public static final RegistryObject<Block> WAXED_CUT_PIGSTEEL = BLOCKS.register("waxed_cut_pigsteel", () -> new Block(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_INFECTED_CUT_PIGSTEEL = BLOCKS.register("waxed_infected_cut_pigsteel", () -> new Block(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_CORRUPTED_CUT_PIGSTEEL = BLOCKS.register("waxed_corrupted_cut_pigsteel", () -> new Block(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_ZOMBIFIED_CUT_PIGSTEEL = BLOCKS.register("waxed_zombified_cut_pigsteel", () -> new Block(CUT_BLOCKS));

    //Waxed cut stairs
    public static final RegistryObject<Block> WAXED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_cut_pigsteel_stairs", () -> new StairBlock(WAXED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_INFECTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_infected_cut_pigsteel_stairs", () -> new StairBlock(WAXED_INFECTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_corrupted_cut_pigsteel_stairs", () -> new StairBlock(WAXED_CORRUPTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_zombified_cut_pigsteel_stairs", () -> new StairBlock(WAXED_ZOMBIFIED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    //Waxed cut slabs
    public static final RegistryObject<Block> WAXED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_cut_pigsteel_slab", () -> new SlabBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_INFECTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_infected_cut_pigsteel_slab", () -> new SlabBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_corrupted_cut_pigsteel_slab", () -> new SlabBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_zombified_cut_pigsteel_slab", () -> new SlabBlock(CUT_BLOCKS));

}