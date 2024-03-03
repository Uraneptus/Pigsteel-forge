package com.uraneptus.pigsteel.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

public class ZombifiableBlock extends Block implements Zombifiable {
    private ZombificationLevel zombificationLevel;

    public ZombifiableBlock(ZombificationLevel zombificationLevel, Properties properties) {
        super(properties);
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
    public boolean isRandomlyTicking(BlockState state) {
        return this.canRandomTick(state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        return Zombifiable.applyWax(state, level, pos, player, hand, result);
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
    public ZombificationLevel getAge() {
        return this.zombificationLevel;
    }
}
