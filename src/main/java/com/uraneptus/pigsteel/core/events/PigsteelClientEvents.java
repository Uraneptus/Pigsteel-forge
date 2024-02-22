package com.uraneptus.pigsteel.core.events;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import com.uraneptus.pigsteel.core.registry.PigsteelItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = PigsteelMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PigsteelClientEvents {

    @SubscribeEvent
    public static void buildTabContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
        if (tabKey == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(PigsteelBlocks.UNAFFECTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.INFECTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.INFECTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.INFECTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.INFECTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.CORRUPTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.ZOMBIFIED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.WAXED_UNAFFECTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.WAXED_INFECTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.WAXED_CORRUPTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.WAXED_ZOMBIFIED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB);
        }
        if (tabKey == CreativeModeTabs.NATURAL_BLOCKS) {
            addBefore(Items.ANCIENT_DEBRIS, PigsteelBlocks.PORKSLAG, event);
            addAfter(Items.RAW_IRON_BLOCK, PigsteelBlocks.PIGSTEEL_CHUNK_BLOCK, event);
        }
        if (tabKey == CreativeModeTabs.INGREDIENTS) {
           addAfter(Items.RAW_IRON, PigsteelItems.PIGSTEEL_CHUNK, event);
        }
    }

    private static void addBefore(Item before, Supplier<? extends ItemLike> inputItem, BuildCreativeModeTabContentsEvent event) {
        event.getEntries().putBefore(before.getDefaultInstance(), inputItem.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    private static void addAfter(Item after, Supplier<? extends ItemLike> inputItem, BuildCreativeModeTabContentsEvent event) {
        event.getEntries().putAfter(after.getDefaultInstance(), inputItem.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}
