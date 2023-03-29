package com.maxhyper.snowcoated.mixin;

import com.maxhyper.snowcoated.BlockTagsHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SnowLayerBlock.class)
public class MixinSnowLayerBlock extends Block {

    @Shadow @Final public static IntegerProperty LAYERS;

    public MixinSnowLayerBlock(BlockBehaviour.Properties p_56585_) {
        super(p_56585_);
        this.registerDefaultState(this.stateDefinition.any().setValue(LAYERS, 1));
    }
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState belowState = level.getBlockState(pos.below());
        if (belowState.is(BlockTagsHolder.snowLayerBlacklist)) return false;
        if (belowState.is(BlockTagsHolder.snowLayerWhitelist)) return true;

        return Block.isFaceFull(belowState.getCollisionShape(level, pos.below()), Direction.UP) || belowState.is(this) && belowState.getValue(LAYERS) == 8;
    }

}
