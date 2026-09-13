package com.qefwgrhgj.beeworks.compat.everycomp;

import com.qefwgrhgj.beeworks.block.ModBeehiveBlock;
import com.qefwgrhgj.beeworks.init.ModBlockEntityTypes;
import com.qefwgrhgj.beeworks.init.ModBlocks;
import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;

public class BeeWorksEveryCompatModule extends SimpleModule {
    public final SimpleEntrySet<WoodType, ModBeehiveBlock> beehives;

    public BeeWorksEveryCompatModule(String modId) {
        super(modId, "bw");

        beehives = SimpleEntrySet.builder(WoodType.class, "beehive",
                        ModBlocks.SPRUCE_BEEHIVE,
                        () -> VanillaWoodTypes.SPRUCE,
                        woodType -> new ModBeehiveBlock(Utils.copyPropertySafe(woodType.log))
                )
                .addTile(ModBlockEntityTypes.BEEHIVE)
                .addTextureM(EveryCompat.res("block/spruce_beehive_front_honey"), EveryCompat.res("block/spruce_beehive_front_honey_m"))
                .addTextureM(EveryCompat.res("block/spruce_beehive_front"), EveryCompat.res("block/spruce_beehive_front_m"))
                .addTextureM(EveryCompat.res("block/spruce_beehive_side"), EveryCompat.res("block/spruce_beehive_side_m"))
                .addTexture(EveryCompat.res("block/spruce_beehive_end"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.BEEHIVES, Registries.BLOCK)
                .addTag(new ResourceLocation("blueprint:wooden_beehives"), Registries.BLOCK, Registries.ITEM)
                .addTag(new ResourceLocation("forge:beehives"), Registries.BLOCK, Registries.ITEM)
                .setTabKey(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .defaultRecipe()
                .copyParentDrop()
                .build();

        this.addEntry(beehives);
    }

    public static void register() {
        EveryCompatAPI.registerModule(new BeeWorksEveryCompatModule("beeworks"));
    }
}
