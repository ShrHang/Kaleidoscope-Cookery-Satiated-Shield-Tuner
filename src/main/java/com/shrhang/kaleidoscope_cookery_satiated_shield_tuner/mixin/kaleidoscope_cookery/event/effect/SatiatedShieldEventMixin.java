package com.shrhang.kaleidoscope_cookery_satiated_shield_tuner.mixin.kaleidoscope_cookery.event.effect;

import com.github.ysbbbbbb.kaleidoscopecookery.event.effect.SatiatedShieldEvent;
import com.shrhang.kaleidoscope_cookery_satiated_shield_tuner.content.utils.SatiatedShieldEventMixinUtils;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SatiatedShieldEvent.class, priority = 1024)
public class SatiatedShieldEventMixin {
    @Inject(method = "onPlayerHurt", at = @At("HEAD"), cancellable = true)
    private static void shhs_create_core$onPlayerHurt(LivingDamageEvent.Pre event, CallbackInfo ci) {
        if (!SatiatedShieldEventMixinUtils.isWeakenSatiatedShield()) return;
        DamageSource source = event.getSource();
        if (event.getEntity() instanceof Player player && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            if (!SatiatedShieldEventMixinUtils.isSatiatedShieldApply(player)) return;
            float originalDamage = event.getNewDamage();
            float finalDamage = SatiatedShieldEventMixinUtils.calculateFinalDamage(player, source, originalDamage);
            event.setNewDamage(finalDamage);
            ci.cancel();
        }
    }
}
