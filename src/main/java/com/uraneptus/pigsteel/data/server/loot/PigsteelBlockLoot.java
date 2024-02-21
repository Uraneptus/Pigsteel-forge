package com.uraneptus.pigsteel.data.server.loot;

import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class PigsteelBlockLoot extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Set.of();

    protected PigsteelBlockLoot() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return PigsteelBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    @Override
    protected void generate() {

    }

    protected void createSlab(Block block) {
        add(block, createSlabItemTable(block));
    }
}
