package dev.example.overhaul;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class PolishedHeartstoneItem extends Item {

    public static final int MAX_HARDNESS = 3;
    public PolishedHeartstoneItem(Properties properties) {super(properties);}

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);

        if (!level.isClientSide) {
            int hardness = stack.getOrDefault(ModDataComponents.HARDNESS, MAX_HARDNESS);

            stack.set(ModDataComponents.HARDNESS, hardness - 1);

            if (hardness - 1 <= 0){
                //Replace the heartstone item with a heartstone core
                ItemStack coreStack = new ItemStack(ModItems.HEARTSTONE_CORE.get());

                player.setItemInHand(usedHand, coreStack);
                return InteractionResultHolder.sidedSuccess(coreStack, level.isClientSide());
            }
        }

        return InteractionResultHolder.pass(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context,
                                List<Component> tooltip, TooltipFlag tooltipFlag) {
        int hardness = stack.getOrDefault(ModDataComponents.HARDNESS, MAX_HARDNESS);

        if (hardness >= MAX_HARDNESS) {
            tooltip.add(Component.literal("Robust"));
        }
        else if (hardness == 2) {
            tooltip.add(Component.literal("Brittle"));
        }
        else {
            tooltip.add(Component.literal("Extremely Brittle"));
        }
    }
}
