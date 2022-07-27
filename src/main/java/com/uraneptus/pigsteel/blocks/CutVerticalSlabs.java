package com.uraneptus.pigsteel.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.block.state.properties.SlabType;
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
import java.util.Random;

public class CutVerticalSlabs extends ModVerticalSlabs implements SimpleWaterloggedBlock {
    private final BlockState zombifyingResult;

    public CutVerticalSlabs(BlockState zombifyingResult, Properties properties) {
        super(properties.randomTicks());
        this.zombifyingResult = zombifyingResult;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if(!world.isClientSide) {
            if (world.dimensionType().bedWorks()) {
                if (random.nextInt(10) > 6) {
                    VerticalSlabType type = state.getValue(ModVerticalSlabs.TYPE);
                    Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);

                    world.setBlockAndUpdate(pos, zombifyingResult
                            .setValue(ModVerticalSlabs.TYPE, type)
                            .setValue(BlockStateProperties.WATERLOGGED, watered));
                }
            }
        }
    }

}
