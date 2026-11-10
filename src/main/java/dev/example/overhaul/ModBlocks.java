package dev.example.overhaul;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Overhaul.MODID);

    public static final DeferredBlock<Block> CRYSTAL_ORE = BLOCKS.registerSimpleBlock("crystal_ore",
            BlockBehaviour.Properties.of()
                    .destroyTime(3.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops());

    public static final DeferredBlock<Block> HEARTSTONE_ORE = BLOCKS.registerSimpleBlock("heartstone_ore",
            BlockBehaviour.Properties.of()
                    .destroyTime(3.0f)
                    .explosionResistance(9.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops());
}
