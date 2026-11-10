
package dev.example.overhaul;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(
                    Registries.CREATIVE_MODE_TAB,
                    Overhaul.MODID
            );

    public static final Supplier<CreativeModeTab> OVERHAUL_TAB =
            CREATIVE_TABS.register("overhaul_tab", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable(
                                    "creativetab.overhaul.overhaul_tab"
                            ))
                            .icon(() -> ModItems.CRYSTAL_SHARD.get().getDefaultInstance())
                            .displayItems((parameters, output) -> {
                                output.accept(ModItems.CRYSTAL_SHARD.get());
                                output.accept(ModItems.RAW_CRYSTAL.get());
                                output.accept(ModItems.CRYSTAL_FOCUS.get());
                                output.accept(ModItems.CRYSTAL_ORE_ITEM);
                                output.accept(ModItems.POLISHED_HEARTSTONE.get());
                                output.accept(ModItems.RAW_HEARTSTONE.get());
                                output.accept(ModItems.HEARTSTONE_CORE.get());
                                output.accept(ModItems.REINFORCED_HEARTSTONE_CORE.get());
                                output.accept(ModItems.HEARTSTONE_ORE_ITEM);
                            })
                            .build()
            );
}
