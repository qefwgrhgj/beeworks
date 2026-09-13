package com.qefwgrhgj.beeworks;

import com.qefwgrhgj.beeworks.compat.everycomp.EveryCompatIntegration;
import com.qefwgrhgj.beeworks.init.ModBlockEntityTypes;
import com.qefwgrhgj.beeworks.init.ModBlocks;
import com.qefwgrhgj.beeworks.init.ModItems;
import com.qefwgrhgj.beeworks.init.ModPoiTypes;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BeeWorks.MOD_ID)
public class BeeWorks {
    public static final String MOD_ID = "beeworks";
    public static final Logger LOGGER = LogManager.getLogger(BeeWorks.class);

    public BeeWorks(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModPoiTypes.POI_TYPES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreativeTab);

        LOGGER.info("Bee Works initialized successfully! Buzzing into action.");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(EveryCompatIntegration::init);
    }

    private void addCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            net.minecraft.world.item.ItemStack beforeStack = Items.BEEHIVE.getDefaultInstance();
            for (var itemReg : ModItems.BEEHIVE_ITEMS.values()) {
                net.minecraft.world.item.ItemStack itemStack = itemReg.get().getDefaultInstance();
                try {
                    event.insertAfter(beforeStack, itemStack, net.minecraft.world.item.CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    beforeStack = itemStack;
                } catch (Exception e) {
                    event.accept(itemStack, net.minecraft.world.item.CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                }
            }
        }
    }
}
