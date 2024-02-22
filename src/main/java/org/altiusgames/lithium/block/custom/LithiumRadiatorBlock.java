package org.altiusgames.lithium.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class LithiumRadiatorBlock extends Block {
    public LithiumRadiatorBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 600));
        }

        super.stepOn(level, pos, state, entity);
    }
}
