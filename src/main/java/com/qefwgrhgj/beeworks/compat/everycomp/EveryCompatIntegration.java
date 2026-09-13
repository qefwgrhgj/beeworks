package com.qefwgrhgj.beeworks.compat.everycomp;

import net.neoforged.fml.ModList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EveryCompatIntegration {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void init() {
        if (ModList.get().isLoaded("everycomp")) {
            try {
                Class<?> moduleClass = Class.forName("com.qefwgrhgj.beeworks.compat.everycomp.BeeWorksEveryCompatModule");
                moduleClass.getMethod("register").invoke(null);
                LOGGER.info("Successfully registered Bee Works module with Every Compat!");
            } catch (Throwable t) {
                LOGGER.warn("Failed to load Every Compat integration for Bee Works", t);
            }
        }
    }
}
