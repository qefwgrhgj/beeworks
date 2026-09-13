package com.teamabnormals.blueprint.core.registry;

import com.qefwgrhgj.beeworks.block.entity.ModBeehiveBlockEntity;
import com.qefwgrhgj.beeworks.init.ModBlockEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class BlueprintBlockEntityTypes {
    public static final Supplier<BlockEntityType<ModBeehiveBlockEntity>> BEEHIVE = ModBlockEntityTypes.BEEHIVE;
}
