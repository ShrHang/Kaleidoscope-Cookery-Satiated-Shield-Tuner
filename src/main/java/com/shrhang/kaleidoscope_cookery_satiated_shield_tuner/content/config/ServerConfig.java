package com.shrhang.kaleidoscope_cookery_satiated_shield_tuner.content.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfig {
    private static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
    public static ModConfigSpec serverSpec;

    public static final ModConfigSpec.BooleanValue IS_MODIFY_SATIATED_SHIELD;
    public static final ModConfigSpec.BooleanValue IS_SATIATED_SHIELD_DISABLE_WHEN_HUNGRY_EFFECT;
    public static final ModConfigSpec.IntValue SATIATED_SHIELD_MIN_FOOD_LEVEL;
    public static final ModConfigSpec.DoubleValue SATIATED_SHIELD_ADDITIONAL_EXHAUSTION_PER_DAMAGE;
    public static final ModConfigSpec.DoubleValue SATIATED_SHIELD_DAMAGE_REDUCTION_PERCENT;
    public static final ModConfigSpec.DoubleValue SATIATED_SHIELD_MAX_DAMAGE_REDUCTION;
    public static final ModConfigSpec.DoubleValue SATIATED_SHIELD_MIN_DAMAGE;
    public static final ModConfigSpec.DoubleValue SATIATED_SHIELD_WEAKNESS_DAMAGE_MULTIPLIER;

    static {
        IS_MODIFY_SATIATED_SHIELD = builder
                .comment(
                        "Whether to weaken the shield provided by satiated effect.",
                        "If the Satiated Shield Weakness from the Kaleidoscope Compat mod is enabled, its effects will take precedence. And the configuration options of this mod will be disabled."
                )
                .comment(
                        "是否启用饱腹代偿效果削弱。",
                        "如果《森罗物语：兼容》的饱腹代偿效果削弱被启用，则优先使用它的削弱效果。且本模组的配置项无效。"
                )
                .translation("kaleidoscope_cookery_satiated_shield_tuner.configgui.is_modify_satiated_shield")
                .define("IS_MODIFY_SATIATED_SHIELD", true);

        IS_SATIATED_SHIELD_DISABLE_WHEN_HUNGRY_EFFECT = builder
                .comment("If true, the Satiated Shield effect will not apply while the player has the Hunger effect.")
                .comment("当为 true 时，玩家存在饥饿状态效果时饱腹代偿效果不生效。")
                .translation("kaleidoscope_cookery_satiated_shield_tuner.configgui.is_satiated_shield_disable_when_hungry_effect")
                .define("IS_SATIATED_SHIELD_DISABLE_WHEN_HUNGRY_EFFECT", true);

        SATIATED_SHIELD_MIN_FOOD_LEVEL = builder
                .comment(
                        "Minimum Hunger Value required for the Satiated Shield to apply (int).",
                        "If player's Hunger Value is below this, the effect will not apply."
                )
                .comment(
                        "饱腹代偿生效所需的最小饥饿值（整数）。",
                        "当玩家饥饿值低于该值时，饱腹代偿不生效。"
                )
                .translation("kaleidoscope_cookery_satiated_shield_tuner.configgui.satiated_shield_min_food_level")
                .defineInRange("SATIATED_SHIELD_MIN_FOOD_LEVEL", 14, 1, 20);

        SATIATED_SHIELD_ADDITIONAL_EXHAUSTION_PER_DAMAGE = builder
                .comment(
                        "The exhaustion added each time the player takes damage.",
                        "4 points of exhaustion = 1 point of food/hunger value, and the player can accumulate up to 40 points of exhaustion in 1 game tick.",
                        "For example: if set to 0.5, each point of damage reduced will cause an additional 0.5 exhaustion."
                )
                .comment(
                        "每次受到伤害时增加的疲劳值。",
                        "4点疲劳值 = 1点饱食度/饥饿值，在 1 游戏刻中玩家最多积累 40 点疲劳值。",
                        "例如：如果设置为 0.5，每点被减免的伤害将额外造成 0.5 点疲劳值。"
                )
                .translation("kaleidoscope_cookery_satiated_shield_tuner.configgui.satiated_shield_additional_exhaustion_per_damage")
                .defineInRange("SATIATED_SHIELD_ADDITIONAL_EXHAUSTION_PER_DAMAGE", 2.0, 0.0, 40.0);

        SATIATED_SHIELD_DAMAGE_REDUCTION_PERCENT = builder
                .comment(
                        "The damage reduction percentage of the Satiated Shield effect.",
                        "The <Damage Reduction Amount> is calculated by multiplying the <Original Damage> by the <Damage Reduction Percentage>.",
                        "For example: if set to 0.85, the player will take 15% of the original damage."
                )
                .comment(
                        "饱腹代偿效果的<伤害减免百分比>。",
                        "玩家受到的<原始伤害>将乘以<伤害减免百分比>来计算<伤害减免量>。",
                        "例如：如果设置为 0.85，玩家将受到 15% 的原始伤害。"
                )
                .translation("kaleidoscope_cookery_satiated_shield_tuner.configgui.satiated_shield_damage_reduction_percent")
                .defineInRange("SATIATED_SHIELD_DAMAGE_REDUCTION_PERCENT", 0.85, 0.0, 1.0);

        SATIATED_SHIELD_MAX_DAMAGE_REDUCTION = builder
                .comment(
                        "The maximum damage reduction amount of the Satiated Shield effect.",
                        "If the <Damage Reduction Amount> calculated by multiplying the <Original Damage> by the <Damage Reduction Percentage> is greater than this value, it will be limited to this value.",
                        "For example: if set to 10.0, the damage the player takes will be limited to a maximum reduction of 10 points of damage."
                )
                .comment(
                        "饱腹代偿效果的<最大伤害减免量>。",
                        "<伤害减免量>大于该值时，将被限制为该值。",
                        "例如：如果设置为 10.0，玩家受到的伤害将被限制为最多减少 10 点伤害。"
                )
                .translation("kaleidoscope_cookery_satiated_shield_tuner.configgui.satiated_shield_max_damage_reduction")
                .defineInRange("SATIATED_SHIELD_MAX_DAMAGE_REDUCTION", 10.0, 0.0, Integer.MAX_VALUE);

        SATIATED_SHIELD_MIN_DAMAGE = builder
                .comment(
                        "The minimum damage that can be got in the Satiated Shield effect.",
                        "If the <Final Damage> after damage reduction is less than this value, it will be limited to this value.",
                        "<Final Damage> = <Original Damage> - <Damage Reduction Amount>"
                )
                .comment(
                        "饱腹代偿效果下可造成的最小伤害。",
                        "<原始伤害>高于该值时，<最终伤害>将被限制为不低于该值。",
                        "<最终伤害> = <原始伤害> - <伤害减免量>"
                )
                .translation("kaleidoscope_cookery_satiated_shield_tuner.configgui.satiated_shield_min_damage")
                .defineInRange("SATIATED_SHIELD_MIN_DAMAGE", 2.0, 0.0, Integer.MAX_VALUE);

        SATIATED_SHIELD_WEAKNESS_DAMAGE_MULTIPLIER = builder
                .comment(
                        "The multiplier for the exhaustion added per point of Satiated Shield Weakness Damage.",
                        "4 points of exhaustion = 1 point of food/hunger value, and the player can accumulate up to 40 points of exhaustion in 1 game tick."
                )
                .comment(
                        "当玩家受到饱腹代偿弱点伤害时，每点伤害增加的疲劳值的乘算倍率。",
                        "4点疲劳值 = 1点饱食度/饥饿值，在 1 游戏刻中玩家最多积累 40 点疲劳值。"
                )
                .translation("kaleidoscope_cookery_satiated_shield_tuner.configgui.satiated_shield_weakness_damage_multiplier")
                .defineInRange("SATIATED_SHIELD_WEAKNESS_DAMAGE_MULTIPLIER", 2.0, 1.0, Integer.MAX_VALUE);

        serverSpec = builder.build();
    }
}
