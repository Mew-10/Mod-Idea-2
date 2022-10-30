package net.benjamin.ideag.block;

import net.benjamin.ideag.block.entity.HephaestusForgeBlockEntity;
import net.benjamin.ideag.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class HephaestusForgeBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public HephaestusForgeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(0, 1, 0, 16, 2, 13),
            Block.box(0, 2, 0, 16, 18, 1),
            Block.box(0, 17, 1, 16, 18, 17),
            Block.box(0, 16, 1, 16, 17, 11),
            Block.box(0, 15, 1, 16, 16, 9),
            Block.box(0, 2, 1, 16, 3, 9),
            Block.box(0, 3, 1, 16, 15, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(0, 1, 0, 13, 2, 16),
            Block.box(0, 2, 0, 1, 18, 16),
            Block.box(1, 17, 0, 17, 18, 16),
            Block.box(1, 16, 0, 11, 17, 16),
            Block.box(1, 15, 0, 9, 16, 16),
            Block.box(1, 2, 0, 9, 3, 16),
            Block.box(1, 3, 0, 6, 15, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(0, 1, 3, 16, 2, 16),
            Block.box(0, 2, 15, 16, 18, 16),
            Block.box(0, 17, -1, 16, 18, 15),
            Block.box(0, 16, 5, 16, 17, 15),
            Block.box(0, 15, 7, 16, 16, 15),
            Block.box(0, 2, 7, 16, 3, 15),
            Block.box(0, 3, 10, 16, 15, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(3, 1, 0, 16, 2, 16),
            Block.box(15, 2, 0, 16, 18, 16),
            Block.box(-1, 17, 0, 15, 18, 16),
            Block.box(5, 16, 0, 15, 17, 16),
            Block.box(7, 15, 0, 15, 16, 16),
            Block.box(7, 2, 0, 15, 3, 16),
            Block.box(10, 3, 0, 15, 15, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof HephaestusForgeBlockEntity) {
                ((HephaestusForgeBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof HephaestusForgeBlockEntity) {
                NetworkHooks.openGui(((ServerPlayer)pPlayer), (HephaestusForgeBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new HephaestusForgeBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.HEPHAESTUS_FORGE_BLOCK_ENTITY.get(), HephaestusForgeBlockEntity::tick);
    }
}