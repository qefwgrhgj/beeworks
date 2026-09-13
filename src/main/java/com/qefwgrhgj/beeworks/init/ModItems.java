package com.qefwgrhgj.beeworks.init;

import com.qefwgrhgj.beeworks.BeeWorks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BeeWorks.MOD_ID);
    public static final Map<String, RegistryObject<Item>> BEEHIVE_ITEMS = new LinkedHashMap<>();
    public static final RegistryObject<Item> SPRUCE_BEEHIVE = registerBeehiveItem("spruce_beehive", ModBlocks.SPRUCE_BEEHIVE);
    public static final RegistryObject<Item> BIRCH_BEEHIVE = registerBeehiveItem("birch_beehive", ModBlocks.BIRCH_BEEHIVE);
    public static final RegistryObject<Item> JUNGLE_BEEHIVE = registerBeehiveItem("jungle_beehive", ModBlocks.JUNGLE_BEEHIVE);
    public static final RegistryObject<Item> ACACIA_BEEHIVE = registerBeehiveItem("acacia_beehive", ModBlocks.ACACIA_BEEHIVE);
    public static final RegistryObject<Item> DARK_OAK_BEEHIVE = registerBeehiveItem("dark_oak_beehive", ModBlocks.DARK_OAK_BEEHIVE);
    public static final RegistryObject<Item> MANGROVE_BEEHIVE = registerBeehiveItem("mangrove_beehive", ModBlocks.MANGROVE_BEEHIVE);
    public static final RegistryObject<Item> CHERRY_BEEHIVE = registerBeehiveItem("cherry_beehive", ModBlocks.CHERRY_BEEHIVE);
    public static final RegistryObject<Item> BAMBOO_BEEHIVE = registerBeehiveItem("bamboo_beehive", ModBlocks.BAMBOO_BEEHIVE);
    public static final RegistryObject<Item> CRIMSON_BEEHIVE = registerBeehiveItem("crimson_beehive", ModBlocks.CRIMSON_BEEHIVE);
    public static final RegistryObject<Item> WARPED_BEEHIVE = registerBeehiveItem("warped_beehive", ModBlocks.WARPED_BEEHIVE);

    private static RegistryObject<Item> registerBeehiveItem(String name, RegistryObject<Block> block) {
        RegistryObject<Item> item = ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        BEEHIVE_ITEMS.put(name, item);
        return item;
    }
}
