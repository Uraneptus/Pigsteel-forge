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
}
