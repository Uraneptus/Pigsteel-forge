package com.uraneptus.pigsteel.init;

import com.uraneptus.pigsteel.PigsteelMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final Item.Properties BUILDING_TAB = new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final Item.Properties MISC_TAB = new Item.Properties().tab(CreativeModeTab.TAB_MISC);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PigsteelMod.MOD_ID);

    //Items
    public static final RegistryObject<Item> PIGSTEEL_INGOT = ITEMS.register("pigsteel_ingot",
            () -> new Item(MISC_TAB));

    public static final RegistryObject<Item> PIGSTEEL_NUGGET = ITEMS.register("pigsteel_nugget",
            () -> new Item(MISC_TAB));

    //Ores
    public static final RegistryObject<BlockItem> PIG_STEEL_ORE = ITEMS.register("pigsteel_ore",
            () -> new BlockItem(BlockInit.PIGSTEEL_ORE.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> STONE_PIGSTEEL_ORE = ITEMS.register("stone_pigsteel_ore",
            () -> new BlockItem(BlockInit.STONE_PIGSTEEL_ORE.get(),BUILDING_TAB));

    public static final RegistryObject<BlockItem> DEEPSLATE_PIGSTEEL_ORE = ITEMS.register("deepslate_pigsteel_ore",
            () -> new BlockItem(BlockInit.DEEPSLATE_PIGSTEEL_ORE.get(), BUILDING_TAB));

    //Block
    public static final RegistryObject<BlockItem> PIGSTEEL_BLOCK = ITEMS.register("pigsteel_block",
            () -> new BlockItem(BlockInit.PIGSTEEL_BLOCK.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> WAXED_PIGSTEEL_BLOCK = ITEMS.register("waxed_pigsteel_block",
            () -> new BlockItem(BlockInit.WAXED_PIGSTEEL_BLOCK.get(), BUILDING_TAB));

    //Cut
    public static final RegistryObject<BlockItem> CUT_PIGSTEEL = ITEMS.register("cut_pigsteel",
            () -> new BlockItem(BlockInit.CUT_PIGSTEEL.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> INFECTED_CUT_PIGSTEEL = ITEMS.register("infected_cut_pigsteel",
            () -> new BlockItem(BlockInit.INFECTED_CUT_PIGSTEEL.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> CORRUPTED_CUT_PIGSTEEL = ITEMS.register("corrupted_cut_pigsteel",
            () -> new BlockItem(BlockInit.CORRUPTED_CUT_PIGSTEEL.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> ZOMBIFIED_CUT_PIGSTEEL = ITEMS.register("zombified_cut_pigsteel",
            () -> new BlockItem(BlockInit.ZOMBIFIED_CUT_PIGSTEEL.get(), BUILDING_TAB));

    //Cut Stairs
    public static final RegistryObject<BlockItem> CUT_PIGSTEEL_STAIRS = ITEMS.register("cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.CUT_PIGSTEEL_STAIRS.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> INFECTED_CUT_PIGSTEEL_STAIRS = ITEMS.register("infected_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.INFECTED_CUT_PIGSTEEL_STAIRS.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> CORRUPTED_CUT_PIGSTEEL_STAIRS = ITEMS.register("corrupted_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.CORRUPTED_CUT_PIGSTEEL_STAIRS.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> ZOMBIFIED_CUT_PIGSTEEL_STAIRS = ITEMS.register("zombified_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get(), BUILDING_TAB));

    //Cut SLabs
    public static final RegistryObject<BlockItem> CUT_PIGSTEEL_SLAB = ITEMS.register("cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.CUT_PIGSTEEL_SLAB.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> INFECTED_CUT_PIGSTEEL_SLAB = ITEMS.register("infected_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.INFECTED_CUT_PIGSTEEL_SLAB.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> CORRUPTED_CUT_PIGSTEEL_SLAB = ITEMS.register("corrupted_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.CORRUPTED_CUT_PIGSTEEL_SLAB.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> ZOMBIFIED_CUT_PIGSTEEL_SLAB = ITEMS.register("zombified_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.ZOMBIFIED_CUT_PIGSTEEL_SLAB.get(), BUILDING_TAB));

    //Waxed cut
    public static final RegistryObject<BlockItem> WAXED_CUT_PIGSTEEL = ITEMS.register("waxed_cut_pigsteel",
            () -> new BlockItem(BlockInit.WAXED_CUT_PIGSTEEL.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> WAXED_INFECTED_CUT_PIGSTEEL = ITEMS.register("waxed_infected_cut_pigsteel",
            () -> new BlockItem(BlockInit.WAXED_INFECTED_CUT_PIGSTEEL.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> WAXED_CORRUPTED_CUT_PIGSTEEL = ITEMS.register("waxed_corrupted_cut_pigsteel",
            () -> new BlockItem(BlockInit.WAXED_CORRUPTED_CUT_PIGSTEEL.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> WAXED_ZOMBIFIED_CUT_PIGSTEEL = ITEMS.register("waxed_zombified_cut_pigsteel",
            () -> new BlockItem(BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL.get(), BUILDING_TAB));

    //Waxed cut stairs
    public static final RegistryObject<BlockItem> WAXED_CUT_PIGSTEEL_STAIRS = ITEMS.register("waxed_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.WAXED_CUT_PIGSTEEL_STAIRS.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> WAXED_INFECTED_CUT_PIGSTEEL_STAIRS = ITEMS.register("waxed_infected_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS = ITEMS.register("waxed_corrupted_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS = ITEMS.register("waxed_zombified_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get(), BUILDING_TAB));

    //Waxed cut slabs
    public static final RegistryObject<BlockItem> WAXED_CUT_PIGSTEEL_SLAB = ITEMS.register("waxed_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.WAXED_CUT_PIGSTEEL_SLAB.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> WAXED_INFECTED_CUT_PIGSTEEL_SLAB = ITEMS.register("waxed_infected_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.WAXED_INFECTED_CUT_PIGSTEEL_SLAB.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB = ITEMS.register("waxed_corrupted_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB.get(), BUILDING_TAB));

    public static final RegistryObject<BlockItem> WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB = ITEMS.register("waxed_zombified_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB.get(), BUILDING_TAB));

}
