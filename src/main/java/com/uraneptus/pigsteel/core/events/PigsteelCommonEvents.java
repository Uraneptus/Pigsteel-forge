package com.uraneptus.pigsteel.core.events;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.data.client.PigsteelLangProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;

@Mod.EventBusSubscriber(modid = PigsteelMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PigsteelCommonEvents {

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        event.addRepositorySource(consumer -> {
            String path = PigsteelMod.modPrefix("ore_revert").toString();
            IModFile file = ModList.get().getModFileById(PigsteelMod.MOD_ID).getFile();
            try (PathPackResources packResources = new PathPackResources(path, true, file.findResource("builtin/ore_revert"))) {
                consumer.accept(Pack.readMetaAndCreate(path, Component.literal(PigsteelLangProvider.createTranslation("pigsteel_ore_revert")), false, (id) -> packResources, PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN));
            }
        });
    }
}
