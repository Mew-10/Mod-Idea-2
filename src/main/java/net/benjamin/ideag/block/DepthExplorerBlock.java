package net.benjamin.ideag.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DepthExplorerBlock extends Block {
    public DepthExplorerBlock(Properties properties) {
        super(properties);
    }


    private static final VoxelShape SHAPE =  Block.box(0, 0.4, 0, 32, 8.400000000000004, 16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
