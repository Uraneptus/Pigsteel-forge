package com.uraneptus.pigsteel.blocks;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

//Original Waxing/Scrapping Code by MiteBeMana, used with Permission
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CutPigsteelStairBlock extends StairBlock {

    public CutPigsteelStairBlock(BlockState state, Properties properties) {
        super(state, properties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        HashMap<Block, Block> WAX_OFF_LIST = new HashMap<>();
        WAX_OFF_LIST.put(BlockInit.WAXED_CUT_PIGSTEEL_STAIRS.get(), BlockInit.CUT_PIGSTEEL_STAIRS.get());
        WAX_OFF_LIST.put(BlockInit.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS.get(), BlockInit.INFECTED_CUT_PIGSTEEL_STAIRS.get());
        WAX_OFF_LIST.put(BlockInit.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS.get(), BlockInit.CORRUPTED_CUT_PIGSTEEL_STAIRS.get());
        WAX_OFF_LIST.put(BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get(), BlockInit.ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get());

        HashMap<Block, Block> WAX_ON_LIST = new HashMap<>();
        for (Map.Entry<Block, Block> entry : WAX_OFF_LIST.entrySet()) {
            WAX_ON_LIST.put(entry.getValue(), entry.getKey());
        }

        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult returnResult = InteractionResult.PASS;

        if (itemStack.getItem() instanceof AxeItem) {
            if (ZombifyingCutPigsteelStairBlock.PREVIOUS_BY_BLOCK.get().containsKey(blockState.getBlock())) {
                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, itemStack);
                }

                level.setBlock(pos, ZombifyingCutPigsteelStairBlock.PREVIOUS_BY_BLOCK.get().get(blockState.getBlock()).withPropertiesOf(blockState), 11);
                level.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3005, pos, 0);

                if (!player.isCreative())
                    itemStack.hurtAndBreak(1, player, (player1) -> player1.broadcastBreakEvent(hand));
                returnResult = InteractionResult.sidedSuccess(true);
            }
            else if (WAX_OFF_LIST.containsKey(blockState.getBlock())) {
                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, itemStack);
                }

                level.setBlock(pos, WAX_OFF_LIST.get(blockState.getBlock()).withPropertiesOf(blockState), 11);
                level.playSound(player, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3004, pos, 0);

                if (!player.isCreative())
                    itemStack.hurtAndBreak(1, player, (player1) -> player1.broadcastBreakEvent(hand));
                returnResult = InteractionResult.sidedSuccess(true);
            }
        }
        else if (itemStack.getItem().equals(Items.HONEYCOMB)) {
            if (WAX_ON_LIST.containsKey(blockState.getBlock())) {
                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, itemStack);
                }

                level.setBlock(pos, WAX_ON_LIST.get(blockState.getBlock()).withPropertiesOf(blockState), 11);
                level.playSound(player, pos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3003, pos, 0);

                if (!player.isCreative())
                    itemStack.shrink(1);
                returnResult = InteractionResult.sidedSuccess(true);
            }
        }
        else {
            returnResult = super.use(blockState, level, pos, player, hand, hitResult);
        }
        return returnResult;
    }
}
