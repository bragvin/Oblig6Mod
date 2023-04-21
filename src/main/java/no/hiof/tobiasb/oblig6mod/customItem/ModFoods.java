package no.hiof.tobiasb.oblig6mod.customItem;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties AMOGUS = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.8F).effect(new MobEffectInstance(MobEffects.REGENERATION, 8000, 5), 1.0F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 8000, 2), 1.0F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 8000, 2), 1.0F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 8000, 5), 1.0F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 10000, 5), 1.0F).alwaysEat().build();


}
