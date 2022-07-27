package com.uraneptus.pigsteel.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ModVerticalSlabs extends Block implements SimpleWaterloggedBlock {
    public static final EnumProperty<VerticalSlabType> TYPE = EnumProperty.create("type", VerticalSlabType.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public ModVerticalSlabs(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TYPE, VerticalSlabType.NORTH).setValue(WATERLOGGED, false));
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
