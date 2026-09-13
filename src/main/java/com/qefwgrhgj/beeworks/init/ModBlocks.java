package com.qefwgrhgj.beeworks.init;

import com.qefwgrhgj.beeworks.BeeWorks;
import com.qefwgrhgj.beeworks.block.ModBeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BeeWorks.MOD_ID);
    public static final Map<String, DeferredBlock<Block>> BEEHIVES = new LinkedHashMap<>();

    public static final DeferredBlock<Block> SPRUCE_BEEHIVE = registerBeehive("spruce_beehive");
    public static final DeferredBlock<Block> BIRCH_BEEHIVE = registerBeehive("birch_beehive");
    public static final DeferredBlock<Block> JUNGLE_BEEHIVE = registerBeehive("jungle_beehive");
    public static final DeferredBlock<Block> ACACIA_BEEHIVE = registerBeehive("acacia_beehive");
    public static final DeferredBlock<Block> DARK_OAK_BEEHIVE = registerBeehive("dark_oak_beehive");
    public static final DeferredBlock<Block> MANGROVE_BEEHIVE = registerBeehive("mangrove_beehive");
    public static final DeferredBlock<Block> CHERRY_BEEHIVE = registerBeehive("cherry_beehive");
    public static final DeferredBlock<Block> BAMBOO_BEEHIVE = registerBeehive("bamboo_beehive");
    public static final DeferredBlock<Block> CRIMSON_BEEHIVE = registerBeehive("crimson_beehive");
    public static final DeferredBlock<Block> WARPED_BEEHIVE = registerBeehive("warped_beehive");
    public static final DeferredBlock<Block> PALE_OAK_BEEHIVE = registerBeehive("pale_oak_beehive");

    private static DeferredBlock<Block> registerBeehive(String name) {
        DeferredBlock<Block> reg = BLOCKS.register(name, () -> new ModBeehiveBlock(
                BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)
        ));
        BEEHIVES.put(name, reg);
        return reg;
    }

    public static Block[] getBeehivesArray() {
        return BEEHIVES.values().stream().map(DeferredBlock::get).toArray(Block[]::new);
    }

    public static Set<BlockState> getAllBeehiveBlockStates() {
        Set<BlockState> states = new HashSet<>();
        for (DeferredBlock<Block> reg : BEEHIVES.values()) {
            states.addAll(reg.get().getStateDefinition().getPossibleStates());
        }
        return states;
    }
}
