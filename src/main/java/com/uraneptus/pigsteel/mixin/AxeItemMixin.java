package com.uraneptus.pigsteel.mixin;

import com.google.common.collect.BiMap;
import com.uraneptus.pigsteel.MixinSuppliers;
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
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(AxeItem.class)
public class AxeItemMixin {

    @Inject(method = "useOn", at = @At("HEAD"))
    private void pigsteelUseOnInject(UseOnContext pContext, CallbackInfoReturnable<InteractionResult> cir) {
        Level world = pContext.getLevel();
        BlockPos blockPos = pContext.getClickedPos();
        Player playerEntity = pContext.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);
        ItemStack itemStack = pContext.getItemInHand();
        Optional<BlockState> optional4 = Optional.empty();
        Optional<BlockState> optional5 = Optional.ofNullable((Block)((BiMap<?, ?>) MixinSuppliers.PIGSTEEL_ZOMBIFICATION_LEVEL_DECREASES.get()).get(blockState.getBlock())).map((block) -> block.withPropertiesOf(blockState));
        Optional<BlockState> optional6 = Optional.ofNullable((Block)((BiMap<?, ?>) MixinSuppliers.PIGSTEEL_WAX_TO_UNWAX.get()).get(blockState.getBlock())).map((block) -> block.withPropertiesOf(blockState));

        if (optional5.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (playerEntity != null) {
                playerEntity.swing(InteractionHand.MAIN_HAND);
            }
            world.levelEvent(playerEntity, 3005, blockPos, 0);
            optional4 = optional5;
        } else if (optional6.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (playerEntity != null) {
                playerEntity.swing(InteractionHand.MAIN_HAND);
            }
            world.levelEvent(playerEntity, 3004, blockPos, 0);
            optional4 = optional6;
        }

        if (optional4.isPresent()) {
            if (playerEntity instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)playerEntity, blockPos, itemStack);
            }

            world.setBlock(blockPos, optional4.get(), 11);
            if (playerEntity != null) {
                itemStack.hurtAndBreak(1, playerEntity, (p) -> p.broadcastBreakEvent(pContext.getHand()));
            }
        }
        
    }

}
