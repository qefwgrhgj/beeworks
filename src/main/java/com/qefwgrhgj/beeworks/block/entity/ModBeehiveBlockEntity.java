package com.qefwgrhgj.beeworks.block.entity;

import com.qefwgrhgj.beeworks.init.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class ModBeehiveBlockEntity extends BeehiveBlockEntity {

    public ModBeehiveBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @NotNull
    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntityTypes.BEEHIVE.get();
    }
}
