package com.shrhang.kaleidoscope_cookery_satiated_shield_tuner.util;

import com.github.ysbbbbbb.kaleidoscopecookery.config.GeneralConfig;
import com.github.ysbbbbbb.kaleidoscopecookery.init.ModEffects;
import com.github.ysbbbbbb.kaleidoscopecookery.init.tag.TagMod;
import com.shrhang.kaleidoscope_cookery_satiated_shield_tuner.compat.kaleidoscope_compat.KaleidoscopeCompat;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.loading.LoadingModList;

import static com.github.ysbbbbbb.kaleidoscopecookery.config.GeneralConfig.SATIATED_SHIELD_ABSORB_EXCESS_DAMAGE;
import static com.shrhang.kaleidoscope_cookery_satiated_shield_tuner.Config.*;

public class SatiatedShieldEventMixinUtils {
    public static boolean isModifiedSatiatedShield() {
        if (!IS_MODIFY_SATIATED_SHIELD.get() || !GeneralConfig.SATIATED_SHIELD_ABSORB_ENABLED.get()) {
            return false;
        }
        if (LoadingModList.get().getModFileById("kealeidoscope_compat") != null) {
            return !KaleidoscopeCompat.isWeakenEnabled();
        }
        return true;
    }

    public static boolean isSatiatedShieldApply(Player player) {
        if (player.hasEffect(MobEffects.HUNGER) && IS_SATIATED_SHIELD_DISABLE_WHEN_HUNGRY_EFFECT.get()) {
            return false;
        }
        return player.getFoodData().getFoodLevel() >= SATIATED_SHIELD_MIN_FOOD_LEVEL.get() && player.hasEffect(ModEffects.SATIATED_SHIELD.get());
    }

    public static float calculateFinalDamage(Player player, DamageSource source, float originalDamage) {
        float reducedDamage = (float) (originalDamage * SATIATED_SHIELD_DAMAGE_REDUCTION_PERCENT.get());
        if (reducedDamage > SATIATED_SHIELD_MAX_DAMAGE_REDUCTION.get()) {
            reducedDamage = (float) (SATIATED_SHIELD_MAX_DAMAGE_REDUCTION.get() * 1f);
        }
        float finalDamage = originalDamage - reducedDamage;
        if (originalDamage > SATIATED_SHIELD_MIN_DAMAGE.get()) {
            finalDamage = (float) Math.max(finalDamage, SATIATED_SHIELD_MIN_DAMAGE.get());
            reducedDamage = originalDamage - finalDamage;
        }

        int exhaustionAmount = Math.toIntExact(Math.round(reducedDamage * SATIATED_SHIELD_ADDITIONAL_EXHAUSTION_PER_DAMAGE.get()));

        if (source.is(TagMod.SATIATED_SHIELD_WEAKNESS)) {
            exhaustionAmount *= SATIATED_SHIELD_WEAKNESS_DAMAGE_MULTIPLIER.get();
        }

        if (!SATIATED_SHIELD_ABSORB_EXCESS_DAMAGE.get()) {
            float absorbedDamage = (float) (player.getFoodData().getFoodLevel() * 4 /  SATIATED_SHIELD_DAMAGE_REDUCTION_PERCENT.get());
            if (source.is(TagMod.SATIATED_SHIELD_WEAKNESS)) {
                absorbedDamage /= SATIATED_SHIELD_WEAKNESS_DAMAGE_MULTIPLIER.get();
            }
            finalDamage += Math.max(0, reducedDamage - absorbedDamage);
        }

        float exhaustion = Math.max(0, exhaustionAmount);
        player.causeFoodExhaustion(exhaustion);

        return finalDamage;
    }
}
