package com.qefwgrhgj.beeworks;

import com.qefwgrhgj.beeworks.compat.everycomp.EveryCompatIntegration;
import com.qefwgrhgj.beeworks.init.ModBlockEntityTypes;
import com.qefwgrhgj.beeworks.init.ModBlocks;
import com.qefwgrhgj.beeworks.init.ModItems;
import com.qefwgrhgj.beeworks.init.ModPoiTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BeeWorks.MOD_ID)
public class BeeWorks {
    public static final String MOD_ID = "beeworks";
    public static final Logger LOGGER = LogManager.getLogger(BeeWorks.class);

    public BeeWorks() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModPoiTypes.POI_TYPES.register(modEventBus);

        EveryCompatIntegration.init();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreativeTab);

        MinecraftForge.EVENT_BUS.addListener(this::remapMissing);

        LOGGER.info("Bee Works initialized successfully! Buzzing into action.");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            Item beforeItem = Items.BEEHIVE;
            for (var itemReg : ModItems.BEEHIVE_ITEMS.values()) {
                event.getEntries().putAfter(beforeItem.getDefaultInstance(), itemReg.get().getDefaultInstance(), net.minecraft.world.item.CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                beforeItem = itemReg.get();
            }
        }
    }

    private void remapMissing(MissingMappingsEvent event) {
        for (var mapping : event.getMappings(ForgeRegistries.Keys.BLOCKS, "woodworks")) {
            String path = mapping.getKey().getPath();
            if (ModBlocks.BEEHIVES.containsKey(path)) {
                Block targetBlock = ModBlocks.BEEHIVES.get(path).get();
                mapping.remap(targetBlock);
                LOGGER.info("Remapped missing block woodworks:{} to beeworks:{}", path, path);
            }
        }

        for (var mapping : event.getMappings(ForgeRegistries.Keys.ITEMS, "woodworks")) {
            String path = mapping.getKey().getPath();
            if (ModItems.BEEHIVE_ITEMS.containsKey(path)) {
                Item targetItem = ModItems.BEEHIVE_ITEMS.get(path).get();
                mapping.remap(targetItem);
                LOGGER.info("Remapped missing item woodworks:{} to beeworks:{}", path, path);
            }
        }

        for (var mapping : event.getMappings(ForgeRegistries.Keys.BLOCKS, "everycomp")) {
            String path = mapping.getKey().getPath();
            if (path.startsWith("abnww/") && path.endsWith("_beehive")) {
                String newPath = "bw/" + path.substring("abnww/".length());
                Block target = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("everycomp", newPath));
                if (target != null) {
                    mapping.remap(target);
                    LOGGER.info("Remapped missing block everycomp:{} to everycomp:{}", path, newPath);
                }
            }
        }

        for (var mapping : event.getMappings(ForgeRegistries.Keys.ITEMS, "everycomp")) {
            String path = mapping.getKey().getPath();
            if (path.startsWith("abnww/") && path.endsWith("_beehive")) {
                String newPath = "bw/" + path.substring("abnww/".length());
                Item target = ForgeRegistries.ITEMS.getValue(new ResourceLocation("everycomp", newPath));
                if (target != null) {
                    mapping.remap(target);
                    LOGGER.info("Remapped missing item everycomp:{} to everycomp:{}", path, newPath);
                }
            }
        }
    }
}
