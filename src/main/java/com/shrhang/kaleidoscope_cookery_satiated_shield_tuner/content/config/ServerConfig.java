package com.shrhang.kaleidoscope_cookery_satiated_shield_tuner.content.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfig {
    private static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
    public static ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue IS_WEAKEN_SATIATED_SHIELD;
    public static final ModConfigSpec.BooleanValue IS_SATIATED_SHIELD_DISABLE_WHEN_HUNGRY_EFFECT;
    public static final ModConfigSpec.IntValue SATIATED_SHIELD_MIN_FOOD_LEVEL;
    public static final ModConfigSpec.DoubleValue SATIATED_SHIELD_DAMAGE_REDUCTION_PERCENT;
    public static final ModConfigSpec.DoubleValue SATIATED_SHIELD_MAX_DAMAGE_REDUCTION;
    public static final ModConfigSpec.DoubleValue SATIATED_SHIELD_MIN_DAMAGE_REDUCTION;
    public static final ModConfigSpec.DoubleValue SATIATED_SHIELD_WEAKNESS_DAMAGE_MULTIPLIER;

    static {
        IS_WEAKEN_SATIATED_SHIELD = builder
                .comment("Whether to weaken the shield provided by satiated effect.")
                .comment("是否启用饱腹代偿效果削弱。")
                .comment("If the weakening of the satiated shield effect in 'Kaleidoscope Compat' is enabled, its weakening effect will be used preferentially, and this option will be invalid.")
                .comment("如果《森罗物语：兼容》的饱腹代偿效果削弱被启用，则优先使用它的削弱效果，且本选项无效。")
                .define("isWeakenSatiatedShield", true);

        IS_SATIATED_SHIELD_DISABLE_WHEN_HUNGRY_EFFECT = builder
                .comment("If true, the Satiated Shield effect will not apply while the player has the Hunger effect.")
                .comment("当为 true 时，玩家存在饥饿状态效果时饱腹代偿效果不生效。")
                .define("satiatedShieldDisableWhenHungryEffect", true);

        SATIATED_SHIELD_MIN_FOOD_LEVEL = builder
                .comment("Minimum food level required for the Satiated Shield to apply (int). If player's food level is below this, the effect will not apply.")
                .comment("饱腹代偿生效所需的最小饱食度（整数）。当玩家饱食度低于该值时，饱腹代偿不生效。")
                .defineInRange("satiatedShieldMinFoodLevel", 1, 1, 20);

        SATIATED_SHIELD_DAMAGE_REDUCTION_PERCENT = builder
                .comment("Damage reduction percentage for the Satiated Shield effect.")
                .comment("饱腹代偿效果的伤害减免百分比。")
                .defineInRange("satiatedShieldDamageReductionPercent", 0.85, 0.0, 1.0);

        SATIATED_SHIELD_MAX_DAMAGE_REDUCTION = builder
                .comment("Maximum damage reduction for the Satiated Shield effect.")
                .comment("饱腹代偿效果的最大伤害减免。")
                .defineInRange("satiatedShieldMaxDamageReduction", 10.0, 0.0, Double.MAX_VALUE);

        SATIATED_SHIELD_MIN_DAMAGE_REDUCTION = builder
                .comment("Minimum damage reduction for the Satiated Shield effect.")
                .comment("饱腹代偿效果的最小伤害减免。")
                .defineInRange("satiatedShieldMinDamageReduction", 2.0, 0.0, Double.MAX_VALUE);

        SATIATED_SHIELD_WEAKNESS_DAMAGE_MULTIPLIER = builder
                .comment("Multiplier applied to additional food consumption when get the Satiated Shield's weakness damage.")
                .comment("当玩家受到由饱腹代偿弱点伤害时，增加的饱食度消耗的乘算倍率。")
                .defineInRange("satiatedShieldWeaknessDamageMultiplier", 2.0, 1.0, Double.MAX_VALUE);

        SPEC = builder.build();
    }
}
