package net.mehvahdjukaar.every_compat;

import net.minecraft.resources.ResourceLocation;

public class EveryCompat {
    public static ResourceLocation res(String path) {
        return ResourceLocation.fromNamespaceAndPath("everycomp", path);
    }
}
