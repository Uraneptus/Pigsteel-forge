package com.uraneptus.pigsteel.init;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.blocks.*;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final BlockBehaviour.Properties CUT_BLOCKS = BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK);
    public static final BlockBehaviour.Properties BLOCK = BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK);
    public static final BlockBehaviour.Properties NETHER_ORE = BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PigsteelMod.MOD_ID);

    //Ores
    public static final RegistryObject<Block> PIGSTEEL_ORE = BLOCKS.register("pigsteel_ore", () -> new DropExperienceBlock(NETHER_ORE, UniformInt.of(1, 2)));
    public static final RegistryObject<Block> STONE_PIGSTEEL_ORE = BLOCKS.register("stone_pigsteel_ore", () -> new DropExperienceBlock(BLOCK));
    public static final RegistryObject<Block> DEEPSLATE_PIGSTEEL_ORE = BLOCKS.register("deepslate_pigsteel_ore", () -> new DropExperienceBlock(BLOCK));

    //Block
    public static final RegistryObject<Block> PIGSTEEL_BLOCK = BLOCKS.register("pigsteel_block", () -> new PigsteelBlock(BLOCK));
    public static final RegistryObject<Block> WAXED_PIGSTEEL_BLOCK = BLOCKS.register("waxed_pigsteel_block", () -> new Block(BLOCK));

    //Cut
    public static final RegistryObject<Block> CUT_PIGSTEEL = BLOCKS.register("cut_pigsteel", () -> new ZombifyingCutPigsteelBlock(WeatheringCopper.WeatherState.UNAFFECTED, CUT_BLOCKS));
    public static final RegistryObject<Block> INFECTED_CUT_PIGSTEEL = BLOCKS.register("infected_cut_pigsteel", () -> new ZombifyingCutPigsteelBlock(WeatheringCopper.WeatherState.EXPOSED, CUT_BLOCKS));
    public static final RegistryObject<Block> CORRUPTED_CUT_PIGSTEEL = BLOCKS.register("corrupted_cut_pigsteel", () -> new ZombifyingCutPigsteelBlock(WeatheringCopper.WeatherState.WEATHERED, CUT_BLOCKS));
    public static final RegistryObject<Block> ZOMBIFIED_CUT_PIGSTEEL = BLOCKS.register("zombified_cut_pigsteel", () -> new ZombifyingCutPigsteelBlock(WeatheringCopper.WeatherState.OXIDIZED, CUT_BLOCKS));

    //Cut Stairs
    public static final RegistryObject<Block> CUT_PIGSTEEL_STAIRS = BLOCKS.register("cut_pigsteel_stairs", () -> new ZombifyingCutPigsteelStairBlock(WeatheringCopper.WeatherState.UNAFFECTED, CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> INFECTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("infected_cut_pigsteel_stairs", () -> new ZombifyingCutPigsteelStairBlock(WeatheringCopper.WeatherState.EXPOSED, INFECTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> CORRUPTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("corrupted_cut_pigsteel_stairs", () -> new ZombifyingCutPigsteelStairBlock(WeatheringCopper.WeatherState.WEATHERED, CORRUPTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> ZOMBIFIED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("zombified_cut_pigsteel_stairs", () -> new ZombifyingCutPigsteelStairBlock(WeatheringCopper.WeatherState.OXIDIZED, ZOMBIFIED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    //Cut SLabs
    public static final RegistryObject<Block> CUT_PIGSTEEL_SLAB = BLOCKS.register("cut_pigsteel_slab", () -> new ZombifyingCutPigsteelSlabBlock(WeatheringCopper.WeatherState.UNAFFECTED, CUT_BLOCKS));
    public static final RegistryObject<Block> INFECTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("infected_cut_pigsteel_slab", () -> new ZombifyingCutPigsteelSlabBlock(WeatheringCopper.WeatherState.EXPOSED, CUT_BLOCKS));
    public static final RegistryObject<Block> CORRUPTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("corrupted_cut_pigsteel_slab", () -> new ZombifyingCutPigsteelSlabBlock(WeatheringCopper.WeatherState.WEATHERED, CUT_BLOCKS));
    public static final RegistryObject<Block> ZOMBIFIED_CUT_PIGSTEEL_SLAB = BLOCKS.register("zombified_cut_pigsteel_slab", () -> new ZombifyingCutPigsteelSlabBlock(WeatheringCopper.WeatherState.OXIDIZED, CUT_BLOCKS));

    //Cut Vertical Slabs
    public static final RegistryObject<Block> VERTICAL_CUT_PIGSTEEL_SLAB = BLOCKS.register("vertical_cut_pigsteel_slab", () -> new ZombifyingCutPigsteelVerticalSlabBlock(WeatheringCopper.WeatherState.UNAFFECTED, CUT_BLOCKS));
    public static final RegistryObject<Block> VERTICAL_INFECTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("vertical_infected_cut_pigsteel_slab", () -> new ZombifyingCutPigsteelVerticalSlabBlock(WeatheringCopper.WeatherState.EXPOSED, CUT_BLOCKS));
    public static final RegistryObject<Block> VERTICAL_CORRUPTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("vertical_corrupted_cut_pigsteel_slab", () -> new ZombifyingCutPigsteelVerticalSlabBlock(WeatheringCopper.WeatherState.WEATHERED, CUT_BLOCKS));
    public static final RegistryObject<Block> VERTICAL_ZOMBIFIED_CUT_PIGSTEEL_SLAB = BLOCKS.register("vertical_zombified_cut_pigsteel_slab", () -> new ZombifyingCutPigsteelVerticalSlabBlock(WeatheringCopper.WeatherState.OXIDIZED, CUT_BLOCKS));

    //Waxed cut
    public static final RegistryObject<Block> WAXED_CUT_PIGSTEEL = BLOCKS.register("waxed_cut_pigsteel", () -> new CutPigsteelBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_INFECTED_CUT_PIGSTEEL = BLOCKS.register("waxed_infected_cut_pigsteel", () -> new CutPigsteelBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_CORRUPTED_CUT_PIGSTEEL = BLOCKS.register("waxed_corrupted_cut_pigsteel", () -> new CutPigsteelBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_ZOMBIFIED_CUT_PIGSTEEL = BLOCKS.register("waxed_zombified_cut_pigsteel", () -> new CutPigsteelBlock(CUT_BLOCKS));

    //Waxed cut stairs
    public static final RegistryObject<Block> WAXED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_cut_pigsteel_stairs", () -> new CutPigsteelStairBlock(WAXED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_INFECTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_infected_cut_pigsteel_stairs", () -> new CutPigsteelStairBlock(WAXED_INFECTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_corrupted_cut_pigsteel_stairs", () -> new CutPigsteelStairBlock(WAXED_CORRUPTED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS = BLOCKS.register("waxed_zombified_cut_pigsteel_stairs", () -> new CutPigsteelStairBlock(WAXED_ZOMBIFIED_CUT_PIGSTEEL.get().defaultBlockState(), CUT_BLOCKS));

    //Waxed cut slabs
    public static final RegistryObject<Block> WAXED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_cut_pigsteel_slab", () -> new CutPigsteelSlabBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_INFECTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_infected_cut_pigsteel_slab", () -> new CutPigsteelSlabBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_corrupted_cut_pigsteel_slab", () -> new CutPigsteelSlabBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_zombified_cut_pigsteel_slab", () -> new CutPigsteelSlabBlock(CUT_BLOCKS));

    //Waxed Cut Vertical Slabs
    public static final RegistryObject<Block> WAXED_VERTICAL_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_vertical_cut_pigsteel_slab", () -> new CutPigsteelVerticalSlabBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_VERTICAL_INFECTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_vertical_infected_cut_pigsteel_slab", () -> new CutPigsteelVerticalSlabBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_VERTICAL_CORRUPTED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_vertical_corrupted_cut_pigsteel_slab", () -> new CutPigsteelVerticalSlabBlock(CUT_BLOCKS));
    public static final RegistryObject<Block> WAXED_VERTICAL_ZOMBIFIED_CUT_PIGSTEEL_SLAB = BLOCKS.register("waxed_vertical_zombified_cut_pigsteel_slab", () -> new CutPigsteelVerticalSlabBlock(CUT_BLOCKS));

}