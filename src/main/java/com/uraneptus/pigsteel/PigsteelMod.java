package com.uraneptus.pigsteel;

import com.uraneptus.pigsteel.init.BlockInit;
import com.uraneptus.pigsteel.init.ItemInit;
import com.uraneptus.pigsteel.other.QuarkRecipeConditionFlag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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

        CraftingHelper.register(new QuarkRecipeConditionFlag.Serializer());
        ItemInit.ITEMS.register(event_bus);
        BlockInit.BLOCKS.register(event_bus);
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }


}
