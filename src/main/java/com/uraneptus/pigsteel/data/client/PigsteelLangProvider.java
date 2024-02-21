package com.uraneptus.pigsteel.data.client;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Supplier;

public class PigsteelLangProvider extends LanguageProvider {

    public PigsteelLangProvider(PackOutput packOutput) {
        super(packOutput, PigsteelMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        PigsteelBlocks.SIMPLE_TRANSLATION.forEach(this::forBlock);
        addBlock(PigsteelBlocks.PIGSTEEL_CHUNK_BLOCK, "Block of Pigsteel Chunks");
    }

    protected void forItem(Supplier<? extends Item> item) {
        addItem(item, createTranslation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.get())).getPath()));
    }

    protected void forBlock(Supplier<? extends Block> block) {
        addBlock(block, createTranslation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }

    protected void forEntity(Supplier<? extends EntityType<?>> entity) {
        addEntityType(entity, createTranslation(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.get())).getPath()));
    }

    public static String createTranslation(String path) {
        final StringBuilder builder = new StringBuilder();

        for (String part : path.split("_")) {
            if (!builder.isEmpty()) {
                builder.append(" ");
            }
            builder.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
        }
        return builder.toString();
    }
}