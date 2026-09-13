package com.qefwgrhgj.beeworks.init;

import com.qefwgrhgj.beeworks.BeeWorks;
import com.qefwgrhgj.beeworks.block.ModBeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BeeWorks.MOD_ID);
    public static final Map<String, RegistryObject<Block>> BEEHIVES = new LinkedHashMap<>();
    public static final RegistryObject<Block> SPRUCE_BEEHIVE = registerBeehive("spruce_beehive");
    public static final RegistryObject<Block> BIRCH_BEEHIVE = registerBeehive("birch_beehive");
    public static final RegistryObject<Block> JUNGLE_BEEHIVE = registerBeehive("jungle_beehive");
    public static final RegistryObject<Block> ACACIA_BEEHIVE = registerBeehive("acacia_beehive");
    public static final RegistryObject<Block> DARK_OAK_BEEHIVE = registerBeehive("dark_oak_beehive");
    public static final RegistryObject<Block> MANGROVE_BEEHIVE = registerBeehive("mangrove_beehive");
    public static final RegistryObject<Block> CHERRY_BEEHIVE = registerBeehive("cherry_beehive");
    public static final RegistryObject<Block> BAMBOO_BEEHIVE = registerBeehive("bamboo_beehive");
    public static final RegistryObject<Block> CRIMSON_BEEHIVE = registerBeehive("crimson_beehive");
    public static final RegistryObject<Block> WARPED_BEEHIVE = registerBeehive("warped_beehive");

    private static RegistryObject<Block> registerBeehive(String name) {
        RegistryObject<Block> reg = BLOCKS.register(name, () -> new ModBeehiveBlock(
                BlockBehaviour.Properties.copy(Blocks.BEEHIVE)
        ));
        BEEHIVES.put(name, reg);
        return reg;
    }

    public static Block[] getBeehivesArray() {
        return BEEHIVES.values().stream().map(RegistryObject::get).toArray(Block[]::new);
    }

    public static Block[] getAllBeehivesArray() {
        Set<Block> set = new HashSet<>(Arrays.asList(getBeehivesArray()));
        for (Block block : ForgeRegistries.BLOCKS) {
            if (block instanceof ModBeehiveBlock) {
                set.add(block);
            }
        }
        return set.toArray(Block[]::new);
    }

    public static Set<BlockState> getAllBeehiveBlockStates() {
        Set<BlockState> states = new HashSet<>();
        for (RegistryObject<Block> reg : BEEHIVES.values()) {
            states.addAll(reg.get().getStateDefinition().getPossibleStates());
        }
        for (Block block : ForgeRegistries.BLOCKS) {
            if (block instanceof ModBeehiveBlock) {
                states.addAll(block.getStateDefinition().getPossibleStates());
            }
        }
        return states;
    }
}
