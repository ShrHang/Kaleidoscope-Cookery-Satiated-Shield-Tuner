package com.shrhang.kaleidoscope_cookery_satiated_shield_tuner.mixin.kaleidoscope_cookery.event.effect;

import com.github.ysbbbbbb.kaleidoscopecookery.event.effect.SatiatedShieldEvent;
import com.shrhang.kaleidoscope_cookery_satiated_shield_tuner.util.SatiatedShieldEventMixinUtils;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SatiatedShieldEvent.class, priority = 1024, remap = false)
public class SatiatedShieldEventMixin {
    @Inject(method = "onPlayerHurt", at = @At("HEAD"), cancellable = true)
    private static void satiated_shield_tuner$onPlayerHurt(LivingDamageEvent event, CallbackInfo ci) {
        if (!SatiatedShieldEventMixinUtils.isModifiedSatiatedShield()) return;
        DamageSource source = event.getSource();
        if (event.getEntity() instanceof Player player && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            if (!SatiatedShieldEventMixinUtils.isSatiatedShieldApply(player)) return;
            float originalDamage = event.getAmount();
            float finalDamage = SatiatedShieldEventMixinUtils.calculateFinalDamage(player, source, originalDamage);
            event.setAmount(finalDamage);
            ci.cancel();
        }
    }
}
