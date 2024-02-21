package com.uraneptus.pigsteel.data.tags;

import com.uraneptus.pigsteel.PigsteelMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PigsteelBiomeTagsProvider extends BiomeTagsProvider {
    public PigsteelBiomeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper fileHelper) {
        super(packOutput, pProvider, PigsteelMod.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

    }
}
