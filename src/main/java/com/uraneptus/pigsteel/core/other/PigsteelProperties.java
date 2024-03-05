package com.uraneptus.pigsteel.core.other;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class PigsteelProperties {
    //BLOCKS
    public static final BlockBehaviour.Properties PORKSLAG = BlockBehaviour.Properties.of().sound(SoundType.POLISHED_DEEPSLATE).strength(2.5f).mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops();
    public static final BlockBehaviour.Properties PIGSTEEL_CHUNK_BLOCK = BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.COLOR_PURPLE);
    public static BlockBehaviour.Properties zombifiedBlock(MapColor color) {
        return BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).mapColor(color).randomTicks();
    }

    public static BlockBehaviour.Properties zombifiedLanternBlock(MapColor color) {
        return BlockBehaviour.Properties.of()
                .forceSolidOn()
                .requiresCorrectToolForDrops()
                .strength(3.5F)
                .sound(SoundType.LANTERN)
                .lightLevel((blockState) -> 15)
                .noOcclusion()
                .pushReaction(PushReaction.DESTROY)
                .mapColor(color);
    }

    //ITEMS
    public static Item.Properties basePigsteelItem() {
        return new Item.Properties().fireResistant();
    }

}
