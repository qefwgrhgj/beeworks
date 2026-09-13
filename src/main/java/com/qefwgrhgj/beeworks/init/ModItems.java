package com.qefwgrhgj.beeworks.init;

import com.qefwgrhgj.beeworks.BeeWorks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BeeWorks.MOD_ID);
    public static final Map<String, DeferredItem<Item>> BEEHIVE_ITEMS = new LinkedHashMap<>();

    public static final DeferredItem<Item> SPRUCE_BEEHIVE = registerBeehiveItem("spruce_beehive", ModBlocks.SPRUCE_BEEHIVE);
    public static final DeferredItem<Item> BIRCH_BEEHIVE = registerBeehiveItem("birch_beehive", ModBlocks.BIRCH_BEEHIVE);
    public static final DeferredItem<Item> JUNGLE_BEEHIVE = registerBeehiveItem("jungle_beehive", ModBlocks.JUNGLE_BEEHIVE);
    public static final DeferredItem<Item> ACACIA_BEEHIVE = registerBeehiveItem("acacia_beehive", ModBlocks.ACACIA_BEEHIVE);
    public static final DeferredItem<Item> DARK_OAK_BEEHIVE = registerBeehiveItem("dark_oak_beehive", ModBlocks.DARK_OAK_BEEHIVE);
    public static final DeferredItem<Item> MANGROVE_BEEHIVE = registerBeehiveItem("mangrove_beehive", ModBlocks.MANGROVE_BEEHIVE);
    public static final DeferredItem<Item> CHERRY_BEEHIVE = registerBeehiveItem("cherry_beehive", ModBlocks.CHERRY_BEEHIVE);
    public static final DeferredItem<Item> BAMBOO_BEEHIVE = registerBeehiveItem("bamboo_beehive", ModBlocks.BAMBOO_BEEHIVE);
    public static final DeferredItem<Item> CRIMSON_BEEHIVE = registerBeehiveItem("crimson_beehive", ModBlocks.CRIMSON_BEEHIVE);
    public static final DeferredItem<Item> WARPED_BEEHIVE = registerBeehiveItem("warped_beehive", ModBlocks.WARPED_BEEHIVE);
    public static final DeferredItem<Item> PALE_OAK_BEEHIVE = registerBeehiveItem("pale_oak_beehive", ModBlocks.PALE_OAK_BEEHIVE);

    private static DeferredItem<Item> registerBeehiveItem(String name, Supplier<? extends Block> block) {
        DeferredItem<Item> item = ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        BEEHIVE_ITEMS.put(name, item);
        return item;
    }
}
