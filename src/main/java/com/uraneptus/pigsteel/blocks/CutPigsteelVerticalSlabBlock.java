package com.uraneptus.pigsteel.blocks;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

//Original Waxing/Scrapping Code by MiteBeMana, used with Permission
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CutPigsteelVerticalSlabBlock extends Block implements SimpleWaterloggedBlock {
    public static final EnumProperty<VerticalSlabType> TYPE = EnumProperty.create("type", VerticalSlabType.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public CutPigsteelVerticalSlabBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TYPE, VerticalSlabType.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        HashMap<Block, Block> WAX_OFF_LIST = new HashMap<>();
        WAX_OFF_LIST.put(BlockInit.WAXED_VERTICAL_CUT_PIGSTEEL_SLAB.get(), BlockInit.VERTICAL_CUT_PIGSTEEL_SLAB.get());
        WAX_OFF_LIST.put(BlockInit.WAXED_VERTICAL_INFECTED_CUT_PIGSTEEL_SLAB.get(), BlockInit.VERTICAL_INFECTED_CUT_PIGSTEEL_SLAB.get());
        WAX_OFF_LIST.put(BlockInit.WAXED_VERTICAL_CORRUPTED_CUT_PIGSTEEL_SLAB.get(), BlockInit.VERTICAL_CORRUPTED_CUT_PIGSTEEL_SLAB.get());
        WAX_OFF_LIST.put(BlockInit.WAXED_VERTICAL_ZOMBIFIED_CUT_PIGSTEEL_SLAB.get(), BlockInit.VERTICAL_ZOMBIFIED_CUT_PIGSTEEL_SLAB.get());

        HashMap<Block, Block> WAX_ON_LIST = new HashMap<>();
        for (Map.Entry<Block, Block> entry : WAX_OFF_LIST.entrySet()) {
            WAX_ON_LIST.put(entry.getValue(), entry.getKey());
        }

        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult returnResult = InteractionResult.PASS;

        if (itemStack.getItem() instanceof AxeItem) {
            if (ZombifyingCutPigsteelVerticalSlabBlock.PREVIOUS_BY_BLOCK.get().containsKey(blockState.getBlock())) {
                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, itemStack);
                }

                level.setBlock(pos, ZombifyingCutPigsteelVerticalSlabBlock.PREVIOUS_BY_BLOCK.get().get(blockState.getBlock()).withPropertiesOf(blockState), 11);
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

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(TYPE, WATERLOGGED);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return pState.getValue(TYPE) != VerticalSlabType.DOUBLE;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pos, CollisionContext pContext) {
        return pState.getValue(TYPE).shape;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = pContext.getLevel().getBlockState(blockpos);
        if (blockstate.getBlock() == this)
            return blockstate.setValue(TYPE, VerticalSlabType.DOUBLE).setValue(WATERLOGGED, false);
        return this.defaultBlockState().setValue(WATERLOGGED, pContext.getLevel().getFluidState(blockpos).getType() == Fluids.WATER).setValue(TYPE, VerticalSlabType.fromDirection(this.getDirectionForPlacement(pContext)));
    }

    private Direction getDirectionForPlacement(BlockPlaceContext pContext) {
        Direction face = pContext.getClickedFace();
        if (face.getAxis() != Direction.Axis.Y) return face;
        Vec3 difference = pContext.getClickLocation().subtract(Vec3.atLowerCornerOf(pContext.getClickedPos())).subtract(0.5, 0, 0.5);
        return Direction.fromYRot(-Math.toDegrees(Math.atan2(difference.x(), difference.z()))).getOpposite();
    }

    @Override
    public boolean canBeReplaced(BlockState state, @Nonnull BlockPlaceContext pContext) {
        VerticalSlabType slabtype = state.getValue(TYPE);
        return slabtype != VerticalSlabType.DOUBLE && pContext.getItemInHand().getItem() == this.asItem() && pContext.replacingClickedOnBlock() && (pContext.getClickedFace() == slabtype.direction && this.getDirectionForPlacement(pContext) == slabtype.direction);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    @Override
    public boolean placeLiquid(LevelAccessor pLevel, BlockPos pos, BlockState state, FluidState fluidState) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE && SimpleWaterloggedBlock.super.placeLiquid(pLevel, pos, state, fluidState);
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter pLevel, BlockPos pos, BlockState state, Fluid fluid) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE && SimpleWaterloggedBlock.super.canPlaceLiquid(pLevel, pos, state, fluid);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor pLevel, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
        return state;
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pos, PathComputationType type) {
        return type == PathComputationType.WATER && pLevel.getFluidState(pos).is(FluidTags.WATER);
    }

    public enum VerticalSlabType implements StringRepresentable {
        NORTH(Direction.NORTH),
        SOUTH(Direction.SOUTH),
        WEST(Direction.WEST),
        EAST(Direction.EAST),
        DOUBLE(null);

        private final String name;
        @Nullable
        public final Direction direction;
        public final VoxelShape shape;

        VerticalSlabType(@Nullable Direction direction) {
            this.name = direction == null ? "double" : direction.getSerializedName();
            this.direction = direction;
            if (direction == null) {
                this.shape = Shapes.block();
            } else {
                double min = 0;
                double max = 8;
                if (direction.getAxisDirection() == Direction.AxisDirection.NEGATIVE) {
                    min = 8;
                    max = 16;
                }
                this.shape = direction.getAxis() == Direction.Axis.X ? Block.box(min, 0, 0, max, 16, 16) : Block.box(0, 0, min, 16, 16, max);
            }
        }

        public static VerticalSlabType fromDirection(Direction direction) {
            for (VerticalSlabType type : VerticalSlabType.values()) {
                if (type.direction != null && direction == type.direction) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

        @NotNull
        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
