package com.uraneptus.pigsteel;

import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import com.uraneptus.pigsteel.core.registry.PigsteelItems;
import com.uraneptus.pigsteel.data.client.PigsteelBlockStateProvider;
import com.uraneptus.pigsteel.data.client.PigsteelItemModelProvider;
import com.uraneptus.pigsteel.data.client.PigsteelLangProvider;
import com.uraneptus.pigsteel.data.server.loot.PigsteelLootTableProvider;
import com.uraneptus.pigsteel.data.tags.PigsteelBiomeTagsProvider;
import com.uraneptus.pigsteel.data.tags.PigsteelBlockTagsProvider;
import com.uraneptus.pigsteel.data.tags.PigsteelItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.concurrent.CompletableFuture;

@Mod(PigsteelMod.MOD_ID)
@Mod.EventBusSubscriber(modid = PigsteelMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PigsteelMod
{
    public static final String MOD_ID = "pigsteel";

    public static boolean QUARK_FLAG = ModList.get().isLoaded("quark");

    public static ResourceLocation modPrefix(String path) {
        return new ResourceLocation(PigsteelMod.MOD_ID, path);
    }

    public PigsteelMod() {
        IEventBus event_bus = FMLJavaModLoadingContext.get().getModEventBus();
        event_bus.addListener(this::setup);
        event_bus.addListener(this::gatherData);

        PigsteelItems.ITEMS.register(event_bus);
        PigsteelBlocks.BLOCKS.register(event_bus);
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(includeClient, new PigsteelLangProvider(packOutput));
        generator.addProvider(includeClient, new PigsteelBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(includeClient, new PigsteelItemModelProvider(packOutput, fileHelper));
        PigsteelBlockTagsProvider blockTagsProvider = new PigsteelBlockTagsProvider(packOutput, lookupProvider, fileHelper);
        generator.addProvider(includeServer, blockTagsProvider);
        generator.addProvider(includeServer, new PigsteelItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), fileHelper));
        generator.addProvider(includeServer, new PigsteelBiomeTagsProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(includeServer, new PigsteelLootTableProvider(packOutput));
        //generator.addProvider(includeServer, new PigsteelRecipeProvider(packOutput));
    }


}
