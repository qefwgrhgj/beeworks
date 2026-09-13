package com.qefwgrhgj.beeworks.init;

import com.qefwgrhgj.beeworks.BeeWorks;
import com.qefwgrhgj.beeworks.block.entity.ModBeehiveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BeeWorks.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModBeehiveBlockEntity>> BEEHIVE =
            BLOCK_ENTITY_TYPES.register("beehive", () ->
                    BlockEntityType.Builder.of(ModBeehiveBlockEntity::new, ModBlocks.getAllBeehivesArray()).build(null)
            );
}
