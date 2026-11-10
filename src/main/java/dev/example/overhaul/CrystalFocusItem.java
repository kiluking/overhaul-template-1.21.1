package dev.example.overhaul;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;


public class CrystalFocusItem extends Item {
    public static final int MAX_ENERGY = 5;
    public static final int SPEED_AMPLIFIER = 15;
    public static final int SPEED_DURATION = 100;
    public static final int SPEED_COOLDOWN = 600;

    public CrystalFocusItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            int energy = stack.getOrDefault(ModDataComponents.ENERGY, MAX_ENERGY);

            if (energy <= 0) {
                player.sendSystemMessage(Component.literal("The Crystal Focus is out of energy!"));
            }
            else {
                stack.set(ModDataComponents.ENERGY, energy - 1);
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, SPEED_DURATION, SPEED_AMPLIFIER, false, false));
                player.getCooldowns().addCooldown(this, SPEED_COOLDOWN);
                player.sendSystemMessage(Component.literal("Crystal Focus Energy: " + (energy - 1) + "/" + MAX_ENERGY));
            }
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context,
                                List<Component> tooltip, TooltipFlag tooltipFlag) {
        int energy = stack.getOrDefault(ModDataComponents.ENERGY, MAX_ENERGY);

        if (energy >= MAX_ENERGY * 0.8) {
            tooltip.add(Component.literal("Energy: " + energy + "/" + MAX_ENERGY).withStyle(ChatFormatting.GREEN));
        }
        else if (energy >= MAX_ENERGY * 0.4) {
            tooltip.add(Component.literal("Energy: " + energy + "/" + MAX_ENERGY).withStyle(ChatFormatting.YELLOW));
        }
        else {
            tooltip.add(Component.literal("Energy: " + energy + "/" + MAX_ENERGY).withStyle(ChatFormatting.RED));
        }
    }
}
