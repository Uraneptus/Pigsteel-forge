package com.uraneptus.pigsteel.core.registry;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.common.blocks.*;
import com.uraneptus.pigsteel.core.other.PigsteelProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


@SuppressWarnings("unused")
public class PigsteelBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PigsteelMod.MOD_ID);
    public static Map<RegistryObject<Block>, RegistryObject<Block>> PIGSTEEL_WAXING_MAP = new HashMap<>();
    public static Map<RegistryObject<Block>, RegistryObject<Block>> PIGSTEEL_ZOMBIFYING_MAP = new HashMap<>();

    public static Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder()
            .put(PigsteelBlocks.UNAFFECTED_REFINED_PIGSTEEL.get(), PigsteelBlocks.INFECTED_REFINED_PIGSTEEL.get())
            .put(PigsteelBlocks.INFECTED_REFINED_PIGSTEEL.get(), PigsteelBlocks.CORRUPTED_REFINED_PIGSTEEL.get())
            .put(PigsteelBlocks.CORRUPTED_REFINED_PIGSTEEL.get(), PigsteelBlocks.ZOMBIFIED_REFINED_PIGSTEEL.get())
            .build());

    public static Supplier<BiMap<Block, Block>> NEXT_WAXED_BY_BLOCK = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder()
            .put(PigsteelBlocks.UNAFFECTED_REFINED_PIGSTEEL.get(), PigsteelBlocks.WAXED_UNAFFECTED_REFINED_PIGSTEEL.get())
            .put(PigsteelBlocks.INFECTED_REFINED_PIGSTEEL.get(), PigsteelBlocks.WAXED_INFECTED_REFINED_PIGSTEEL.get())
            .put(PigsteelBlocks.CORRUPTED_REFINED_PIGSTEEL.get(), PigsteelBlocks.WAXED_CORRUPTED_REFINED_PIGSTEEL.get())
            .put(PigsteelBlocks.ZOMBIFIED_REFINED_PIGSTEEL.get(), PigsteelBlocks.WAXED_ZOMBIFIED_REFINED_PIGSTEEL.get())
            .build());


    public static List<Supplier<Block>> SLABS = new ArrayList<>();
    public static List<Supplier<Block>> STAIRS = new ArrayList<>();
    public static List<RegistryObject<Block>> SIMPLE_TRANSLATION = new ArrayList<>();

    public static final RegistryObject<Block> PORKSLAG = register("porkslag", true, () -> new DropExperienceBlock(PigsteelProperties.PORKSLAG));
    public static final RegistryObject<Block> PIGSTEEL_CHUNK_BLOCK = register("pigsteel_chunk_block", false, () -> new Block(PigsteelProperties.PIGSTEEL_CHUNK_BLOCK));

    public static final RegistryObject<Block> UNAFFECTED_REFINED_PIGSTEEL = registerZombifiableBlock("refined_pigsteel", Zombifiable.ZombificationLevel.UNAFFECTED);
    public static final RegistryObject<Block> INFECTED_REFINED_PIGSTEEL = registerZombifiableBlock("infected_refined_pigsteel", Zombifiable.ZombificationLevel.INFECTED);
    public static final RegistryObject<Block> CORRUPTED_REFINED_PIGSTEEL = registerZombifiableBlock("corrupted_refined_pigsteel", Zombifiable.ZombificationLevel.CORRUPTED);
    public static final RegistryObject<Block> ZOMBIFIED_REFINED_PIGSTEEL = registerZombifiableBlock("zombified_refined_pigsteel", Zombifiable.ZombificationLevel.ZOMBIFIED);

    public static final RegistryObject<Block> WAXED_UNAFFECTED_REFINED_PIGSTEEL = registerZombifiableBlock("waxed_refined_pigsteel", Zombifiable.ZombificationLevel.UNAFFECTED);
    public static final RegistryObject<Block> WAXED_INFECTED_REFINED_PIGSTEEL = registerZombifiableBlock("waxed_infected_refined_pigsteel", Zombifiable.ZombificationLevel.INFECTED);
    public static final RegistryObject<Block> WAXED_CORRUPTED_REFINED_PIGSTEEL = registerZombifiableBlock("waxed_corrupted_refined_pigsteel", Zombifiable.ZombificationLevel.CORRUPTED);
    public static final RegistryObject<Block> WAXED_ZOMBIFIED_REFINED_PIGSTEEL = registerZombifiableBlock("waxed_zombified_refined_pigsteel", Zombifiable.ZombificationLevel.ZOMBIFIED);

    private static RegistryObject<Block> registerZombifiableBlock(String name, Zombifiable.ZombificationLevel level) {
        return register(name, true, () -> new ZombifiableBlock(level, PigsteelProperties.zombifiedBlock(level.getMapColor())));
    }

    private static RegistryObject<Block> register(String name, boolean isSimpleName, Supplier<Block> block) {
        RegistryObject<Block> registryObject = register(name, block, PigsteelProperties.basePigsteelItem());
        if (isSimpleName) SIMPLE_TRANSLATION.add(registryObject);
        return registryObject;
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block, Item.Properties properties) {
        RegistryObject<Block> registryObject = BLOCKS.register(name, block);
        RegistryObject<Item> itemRegistryObject = PigsteelItems.ITEMS.register(name, () -> new BlockItem(registryObject.get(), properties));
        return registryObject;
    }
}