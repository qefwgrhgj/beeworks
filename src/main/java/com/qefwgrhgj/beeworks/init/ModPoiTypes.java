package com.qefwgrhgj.beeworks.init;

import com.qefwgrhgj.beeworks.BeeWorks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPoiTypes {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, BeeWorks.MOD_ID);

    public static final DeferredHolder<PoiType, PoiType> BEEHIVE = POI_TYPES.register("beehive", () ->
            new PoiType(ModBlocks.getAllBeehiveBlockStates(), 0, 1)
    );
}
