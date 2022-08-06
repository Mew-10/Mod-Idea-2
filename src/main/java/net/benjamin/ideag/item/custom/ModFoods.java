package net.benjamin.ideag.item.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties AMBROSIA = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000, 333), 4f).build();

    public static final FoodProperties NECTOR = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 2000, 333), 4f).build();
}
