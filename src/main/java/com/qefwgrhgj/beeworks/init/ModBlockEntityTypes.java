package com.qefwgrhgj.beeworks.init;

import com.qefwgrhgj.beeworks.BeeWorks;
import com.qefwgrhgj.beeworks.block.entity.ModBeehiveBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, BeeWorks.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModBeehiveBlockEntity>> BEEHIVE =
            BLOCK_ENTITY_TYPES.register("beehive", () ->
                    BlockEntityType.Builder.of(ModBeehiveBlockEntity::new, ModBlocks.getBeehivesArray()).build(null)
            );
}
