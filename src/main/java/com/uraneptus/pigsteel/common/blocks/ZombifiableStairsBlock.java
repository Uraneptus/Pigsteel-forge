package com.uraneptus.pigsteel.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ZombifiableStairsBlock extends StairBlock implements Zombifiable {

    private ZombificationLevel zombificationLevel;

    public ZombifiableStairsBlock(ZombificationLevel zombificationLevel, Supplier<BlockState> baseBlockState, Properties properties) {
        super(baseBlockState, properties);
        this.zombificationLevel = zombificationLevel;
    }

    @Override
    public MapColor defaultMapColor() {
        return getAge().getMapColor();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel pLevel, BlockPos pos, RandomSource random) {
        this.onRandomTick(state, pLevel, pos, random);
    }

    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction action, boolean simulate) {
        if (action == ToolActions.AXE_SCRAPE) {
            return Zombifiable.getPrevious(state).isPresent() ? Zombifiable.getPrevious(state).get().getBlock().withPropertiesOf(state) : null;
        }
        if (action == ToolActions.AXE_WAX_OFF) {
            return Zombifiable.getPreviousWaxed(state).isPresent() ? Zombifiable.getPreviousWaxed(state).get().getBlock().withPropertiesOf(state) : null;
        }
        return super.getToolModifiedState(state, context, action, simulate);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return this.canRandomTick(state);
    }

    @Override
    public ZombificationLevel getAge() {
        return this.zombificationLevel;
    }

}
