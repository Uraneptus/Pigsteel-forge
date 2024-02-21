package com.uraneptus.pigsteel.core.other.tags;

import com.uraneptus.pigsteel.PigsteelMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class PigsteelItemTags {

    public static final TagKey<Item> PIGSTEEL_ORES = of("pigsteel_ores");

    public static final TagKey<Item> C_ORES = of("c","ores");

    private static TagKey<Item> of(String id) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(PigsteelMod.MOD_ID, id));
    }
    private static TagKey<Item> of(String modid,String id) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(modid, id));
    }
}
