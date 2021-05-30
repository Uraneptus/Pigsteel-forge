package com.uraneptus.pigsteel.init;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.blocks.*;
import com.uraneptus.pigsteel.blocks.stairs.CorruptedCutPigsteelStairs;
import com.uraneptus.pigsteel.blocks.stairs.CutPigsteelStairs;
import com.uraneptus.pigsteel.blocks.stairs.InfectedCutPigsteelStairs;
import com.uraneptus.pigsteel.blocks.stairs.ZombifiedCutPigsteelStairs;
import net.minecraft.block.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PigsteelMod.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> PIGSTEEL_ORE = BLOCKS.register("pigsteel_ore",
            () -> new PigsteelOre(AbstractBlock.Properties.copy(Blocks.NETHER_GOLD_ORE)));

    public static final RegistryObject<Block> PIGSTEEL_BLOCK = BLOCKS.register("pigsteel_block",
            () -> new PigsteelBlock(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CUT_PIGSTEEL = BLOCKS.register("cut_pigsteel",
            () -> new CutPigsteel(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> INFECTED_CUT_PIGSTEEL = BLOCKS.register("infected_cut_pigsteel",
            () -> new InfectedCutPigsteel(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> CORRUPTED_CUT_PIGSTEEL = BLOCKS.register("corrupted_cut_pigsteel",
            () -> new CorruptedCutPigsteel(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> ZOMBIFIED_CUT_PIGSTEEL = BLOCKS.register("zombified_cut_pigsteel",
            () -> new ZombifiedCutPigsteel(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> STONE_PIGSTEEL_ORE = BLOCKS.register("stone_pigsteel_ore",
            () -> new PigsteelOre(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));

    //Waxed
    public static final RegistryObject<Block> WAXED_PIGSTEEL_BLOCK = BLOCKS.register("waxed_pigsteel_block",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> WAXED_CUT_PIGSTEEL = BLOCKS.register("waxed_cut_pigsteel",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> WAXED_INFECTED_CUT_PIGSTEEL = BLOCKS.register("waxed_infected_cut_pigsteel",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> WAXED_CORRUPTED_CUT_PIGSTEEL = BLOCKS.register("waxed_corrupted_cut_pigsteel",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> WAXED_ZOMBIFIED_CUT_PIGSTEEL = BLOCKS.register("waxed_zombified_cut_pigsteel",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    //Stairs
    public static final RegistryObject<Block> CUT_PIGSTEEL_STAIRS = BLOCKS.register("cut_pigsteel_stairs",
            () -> new CutPigsteelStairs(CUT_PIGSTEEL.get().defaultBlockState(), AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> INFECTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("infected_cut_pigsteel_stairs",
            () -> new InfectedCutPigsteelStairs(INFECTED_CUT_PIGSTEEL.get().defaultBlockState(), AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> CORRUPTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("corrupted_cut_pigsteel_stairs",
            () -> new CorruptedCutPigsteelStairs(CORRUPTED_CUT_PIGSTEEL.get().defaultBlockState(), AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> ZOMBIFIED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("zombified_cut_pigsteel_stairs",
            () -> new ZombifiedCutPigsteelStairs(ZOMBIFIED_CUT_PIGSTEEL.get().defaultBlockState(), AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));


    public static final RegistryObject<Block> WAXED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_cut_pigsteel_stairs",
            () -> new StairsBlock(WAXED_CUT_PIGSTEEL.get().defaultBlockState(), AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> WAXED_INFECTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_infected_cut_pigsteel_stairs",
            () -> new StairsBlock(WAXED_INFECTED_CUT_PIGSTEEL.get().defaultBlockState(), AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_corrupted_cut_pigsteel_stairs",
            () -> new StairsBlock(WAXED_CORRUPTED_CUT_PIGSTEEL.get().defaultBlockState(), AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_zombified_cut_pigsteel_stairs",
            () -> new StairsBlock(WAXED_ZOMBIFIED_CUT_PIGSTEEL.get().defaultBlockState(), AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));


}

