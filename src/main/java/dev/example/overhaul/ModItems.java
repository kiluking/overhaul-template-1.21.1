package dev.example.overhaul;

import com.jcraft.jorbis.Block;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Overhaul.MODID);

    //Crystal
    public static final Supplier<Item> CRYSTAL_SHARD = ITEMS.register("crystal_shard", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> RAW_CRYSTAL = ITEMS.register("raw_crystal", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> CRYSTAL_FOCUS = ITEMS.register("crystal_focus",
            () -> new CrystalFocusItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<BlockItem> CRYSTAL_ORE_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CRYSTAL_ORE);
    public static final Supplier<Item> POLISHED_HEARTSTONE = ITEMS.register("polished_heartstone",
            () -> new PolishedHeartstoneItem(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> RAW_HEARTSTONE = ITEMS.register("raw_heartstone", () -> new Item(new Item.Properties()));

    public static final Supplier<Item> HEARTSTONE_CORE = ITEMS.register("heartstone_core",
            () -> new HeartstoneCoreItem(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> REINFORCED_HEARTSTONE_CORE = ITEMS.register("reinforced_heartstone_core",
            () -> new ReinforcedHeartstoneCoreItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<BlockItem> HEARTSTONE_ORE_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.HEARTSTONE_ORE);

}
