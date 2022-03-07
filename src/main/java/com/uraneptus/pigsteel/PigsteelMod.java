package com.uraneptus.pigsteel;

import com.uraneptus.pigsteel.init.BlockInit;
import com.uraneptus.pigsteel.init.FeatureInit;
import com.uraneptus.pigsteel.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PigsteelMod.MOD_ID)
@Mod.EventBusSubscriber(modid = PigsteelMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PigsteelMod
{
    public static final String MOD_ID = "pigsteel";

    public PigsteelMod() {
        IEventBus event_bus = FMLJavaModLoadingContext.get().getModEventBus();
        event_bus.addListener(this::setup);

        ItemInit.ITEMS.register(event_bus);
        BlockInit.BLOCKS.register(event_bus);

        MinecraftForge.EVENT_BUS.addListener(FeatureInit::onBiomeLoad);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        FeatureInit.registerFeatures();
    }


}
