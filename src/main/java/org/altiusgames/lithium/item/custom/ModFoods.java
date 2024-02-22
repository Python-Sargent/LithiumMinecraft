package org.altiusgames.lithium.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties GILDED_LITHORIUM =
            new FoodProperties.Builder().alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200), 1)
                    .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 600), 1)
                    .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200), 0.5f)
                    .alwaysEat().nutrition(4).saturationMod(4).build();
}
