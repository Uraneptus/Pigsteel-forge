package com.uraneptus.pigsteel.init;

import com.uraneptus.pigsteel.PigsteelMod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PigsteelMod.MOD_ID);

    //Items
    public static final RegistryObject<Item> PIGSTEEL_INGOT = ITEMS.register("pigsteel_ingot",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> PIGSTEEL_NUGGET = ITEMS.register("pigsteel_nugget",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));


    //Block Items
    public static final RegistryObject<BlockItem> PIG_STEEL_ORE = ITEMS.register("pigsteel_ore",
            () -> new BlockItem(BlockInit.PIGSTEEL_ORE.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> PIGSTEEL_BLOCK = ITEMS.register("pigsteel_block",
            () -> new BlockItem(BlockInit.PIGSTEEL_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> CUT_PIGSTEEL = ITEMS.register("cut_pigsteel",
            () -> new BlockItem(BlockInit.CUT_PIGSTEEL.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> INFECTED_CUT_PIGSTEEL = ITEMS.register("infected_cut_pigsteel",
            () -> new BlockItem(BlockInit.INFECTED_CUT_PIGSTEEL.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> CORRUPTED_CUT_PIGSTEEL = ITEMS.register("corrupted_cut_pigsteel",
            () -> new BlockItem(BlockInit.CORRUPTED_CUT_PIGSTEEL.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> ZOMBIFIED_CUT_PIGSTEEL = ITEMS.register("zombified_cut_pigsteel",
            () -> new BlockItem(BlockInit.ZOMBIFIED_CUT_PIGSTEEL.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> STONE_PIGSTEEL_ORE = ITEMS.register("stone_pigsteel_ore",
            () -> new BlockItem(BlockInit.STONE_PIGSTEEL_ORE.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    //Block Items Waxed
    public static final RegistryObject<BlockItem> WAXED_PIGSTEEL_BLOCK = ITEMS.register("waxed_pigsteel_block",
            () -> new BlockItem(BlockInit.WAXED_PIGSTEEL_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> WAXED_CUT_PIGSTEEL = ITEMS.register("waxed_cut_pigsteel",
            () -> new BlockItem(BlockInit.WAXED_CUT_PIGSTEEL.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> WAXED_INFECTED_CUT_PIGSTEEL = ITEMS.register("waxed_infected_cut_pigsteel",
            () -> new BlockItem(BlockInit.WAXED_INFECTED_CUT_PIGSTEEL.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> WAXED_CORRUPTED_CUT_PIGSTEEL = ITEMS.register("waxed_corrupted_cut_pigsteel",
            () -> new BlockItem(BlockInit.WAXED_CORRUPTED_CUT_PIGSTEEL.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> WAXED_ZOMBIFIED_CUT_PIGSTEEL = ITEMS.register("waxed_zombified_cut_pigsteel",
            () -> new BlockItem(BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    //Block Item Stairs
    public static final RegistryObject<BlockItem> CUT_PIGSTEEL_STAIRS = ITEMS.register("cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.CUT_PIGSTEEL_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> INFECTED_CUT_PIGSTEEL_STAIRS = ITEMS.register("infected_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.INFECTED_CUT_PIGSTEEL_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> CORRUPTED_CUT_PIGSTEEL_STAIRS = ITEMS.register("corrupted_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.CORRUPTED_CUT_PIGSTEEL_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> ZOMBIFIED_CUT_PIGSTEEL_STAIRS = ITEMS.register("zombified_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));


    public static final RegistryObject<BlockItem> WAXED_CUT_PIGSTEEL_STAIRS = ITEMS.register("waxed_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.WAXED_CUT_PIGSTEEL_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> WAXED_INFECTED_CUT_PIGSTEEL_STAIRS = ITEMS.register("waxed_infected_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS = ITEMS.register("waxed_corrupted_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS = ITEMS.register("waxed_zombified_cut_pigsteel_stairs",
            () -> new BlockItem(BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    //Block Item Slabs
    public static final RegistryObject<BlockItem> CUT_PIGSTEEL_SLAB = ITEMS.register("cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.CUT_PIGSTEEL_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> INFECTED_CUT_PIGSTEEL_SLAB = ITEMS.register("infected_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.INFECTED_CUT_PIGSTEEL_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> CORRUPTED_CUT_PIGSTEEL_SLAB = ITEMS.register("corrupted_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.CORRUPTED_CUT_PIGSTEEL_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> ZOMBIFIED_CUT_PIGSTEEL_SLAB = ITEMS.register("zombified_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.ZOMBIFIED_CUT_PIGSTEEL_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));


    public static final RegistryObject<BlockItem> WAXED_CUT_PIGSTEEL_SLAB = ITEMS.register("waxed_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.WAXED_CUT_PIGSTEEL_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> WAXED_INFECTED_CUT_PIGSTEEL_SLAB = ITEMS.register("waxed_infected_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.WAXED_INFECTED_CUT_PIGSTEEL_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB = ITEMS.register("waxed_corrupted_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB = ITEMS.register("waxed_zombified_cut_pigsteel_slab",
            () -> new BlockItem(BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

}
