package com.qefwgrhgj.beeworks.init;

import com.qefwgrhgj.beeworks.BeeWorks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPoiTypes {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, BeeWorks.MOD_ID);

    public static final RegistryObject<PoiType> BEEHIVE = POI_TYPES.register("beehive", () ->
            new PoiType(ModBlocks.getAllBeehiveBlockStates(), 0, 1)
    );
}
