package com.uraneptus.pigsteel.core.registry;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.other.PigsteelProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class PigsteelItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PigsteelMod.MOD_ID);

    public static RegistryObject<Item> registerItem(String id, Supplier<Item> item) {
        return ITEMS.register(id, item);
    }

    public static final RegistryObject<Item> PIGSTEEL_CHUNK = registerItem("pigsteel_chunk", () -> new Item(PigsteelProperties.basePigsteelItem()));

    /*
    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(entries -> {
                    entries.addBefore(Items.ANCIENT_DEBRIS, PigsteelBlocks.PORKSLAG);
                    entries.addAfter(Items.RAW_IRON_BLOCK, PigsteelBlocks.PIGSTEEL_CHUNK_BLOCK);
                });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(entries -> {
                    entries.addAfter(Items.RAW_IRON, PigsteelItems.PIGSTEEL_CHUNK);
        });


        PigsteelBlocks.pigsteelSoulLanterns.addToItemGroup(ItemGroups.FUNCTIONAL, Items.SOUL_LANTERN);
        PigsteelBlocks.pigsteelLanterns.addToItemGroup(ItemGroups.FUNCTIONAL, Items.SOUL_LANTERN);




        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(entries -> {
                    entries.add(PigsteelBlocks.refinedPigsteel.getUnaffectedBlock());
                    entries.add(PigsteelBlocks.cutPigsteel.getUnaffectedBlock());
                    entries.add(PigsteelBlocks.CUT_PIGSTEEL_STAIRS);
                    entries.add(PigsteelBlocks.cutPigsteelSlabs.getUnaffectedBlock());

                    entries.add(PigsteelBlocks.refinedPigsteel.getInfectedBlock());
                    entries.add(PigsteelBlocks.cutPigsteel.getInfectedBlock());
                    entries.add(PigsteelBlocks.INFECTED_CUT_PIGSTEEL_STAIRS);
                    entries.add(PigsteelBlocks.cutPigsteelSlabs.getInfectedBlock());

                    entries.add(PigsteelBlocks.refinedPigsteel.getCorruptedBlock());
                    entries.add(PigsteelBlocks.cutPigsteel.getCorruptedBlock());
                    entries.add(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_STAIRS);
                    entries.add(PigsteelBlocks.cutPigsteelSlabs.getCorruptedBlock());

                    entries.add(PigsteelBlocks.refinedPigsteel.getZombifiedBlock());
                    entries.add(PigsteelBlocks.cutPigsteel.getZombifiedBlock());
                    entries.add(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_STAIRS);
                    entries.add(PigsteelBlocks.cutPigsteelSlabs.getZombifiedBlock());

                    entries.add(PigsteelBlocks.refinedPigsteel.getWaxedUnaffectedBlock());
                    entries.add(PigsteelBlocks.cutPigsteel.getWaxedUnaffectedBlock());
                    entries.add(PigsteelBlocks.WAXED_CUT_PIGSTEEL_STAIRS);
                    entries.add(PigsteelBlocks.cutPigsteelSlabs.getWaxedUnaffectedBlock());

                    entries.add(PigsteelBlocks.refinedPigsteel.getWaxedInfectedBlock());
                    entries.add(PigsteelBlocks.cutPigsteel.getWaxedInfectedBlock());
                    entries.add(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS);
                    entries.add(PigsteelBlocks.cutPigsteelSlabs.getWaxedInfectedBlock());

                    entries.add(PigsteelBlocks.refinedPigsteel.getWaxedCorruptedBlock());
                    entries.add(PigsteelBlocks.cutPigsteel.getWaxedCorruptedBlock());
                    entries.add(PigsteelBlocks.cutPigsteelSlabs.getWaxedCorruptedBlock());
                    entries.add(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS);

                    entries.add(PigsteelBlocks.refinedPigsteel.getWaxedZombifiedBlock());
                    entries.add(PigsteelBlocks.cutPigsteel.getWaxedZombifiedBlock());
                    entries.add(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS);
                    entries.add(PigsteelBlocks.cutPigsteelSlabs.getWaxedZombifiedBlock());
                });

    }

     */
}
