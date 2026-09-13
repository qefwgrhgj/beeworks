package net.mehvahdjukaar.moonlight.api.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Utils {
    public static BlockBehaviour.Properties copyPropertySafe(Block block) {
        return BlockBehaviour.Properties.ofFullCopy(block);
    }
}
