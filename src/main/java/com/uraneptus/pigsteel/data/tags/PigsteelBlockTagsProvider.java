package com.uraneptus.pigsteel.data.tags;

import com.uraneptus.pigsteel.PigsteelMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PigsteelBlockTagsProvider extends BlockTagsProvider {

    public PigsteelBlockTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, pProvider, PigsteelMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.Provider pProvider) {

    }
}
