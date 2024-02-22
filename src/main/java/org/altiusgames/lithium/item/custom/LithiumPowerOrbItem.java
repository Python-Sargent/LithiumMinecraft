package org.altiusgames.lithium.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.altiusgames.lithium.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class LithiumPowerOrbItem extends Item {
    public LithiumPowerOrbItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if(!level.isClientSide()) {

            SpawnAction(player, level);
            player.getCooldowns().addCooldown(this, 20);
            player.getItemInHand(hand).hurtAndBreak(1, player,
                    player1 -> player.broadcastBreakEvent(player.getUsedItemHand()));
        }

        return super.use(level, player, hand);
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext pContext) {
        BlockPos positionClicked = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState state = pContext.getLevel().getBlockState(positionClicked);
        if (state.is(ModTags.Blocks.LITHIUM_REACTIVE)) {
            pContext.getItemInHand().hurtAndBreak(-1, Objects.requireNonNull(player),
                    player1 -> player.broadcastBreakEvent(player.getUsedItemHand()));
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.literal("Rightclick to use\nProperties:\n  Speed: 1\n  Charge Type: Large").withStyle(ChatFormatting.GREEN));
        } else {
            components.add(Component.literal("Press Shift").withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(itemStack, level, components, flag);
    }

    private  void SpawnAction(Player player, Level level) {
        Vec3 target = player.getForward();

        double x = target.x;
        double y = target.y;
        double z = target.z;

        LargeFireball fireball = new LargeFireball(level, player, x, y, z, 1); //(level, player, x, y, z);
        fireball.setPos(fireball.getX(), player.getY(0.5) + 0.5, fireball.getZ());
        player.level().addFreshEntity(fireball);
    }
}
