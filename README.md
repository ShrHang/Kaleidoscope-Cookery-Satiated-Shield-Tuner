# Kaleidoscope Cookery: Satiated Shield Tuner

[![CN](https://img.shields.io/badge/简体中文-CN-red)](README-CN.md)
[![CurseForge](https://img.shields.io/curseforge/dt/1496142?logo=curseforge&label=CurseForge)](https://www.curseforge.com/minecraft/mc-mods/kaleidoscope-cookery-satiated-shield-tuner)
[![MCMOD](https://img.shields.io/badge/MC百科-MCMOD-lime)](https://www.mcmod.cn/class/25807.html)

## Overview

Satiated Shield is a effect in Kaleidoscope Cookery, it is cheap to obtain but has powerful effects, which makes players who care about game balance very frustrated.

This mod provides several configurable options for the Satiated Shield effect, allowing players to adjust its intensity according to their needs and preferences.

After installing this mod and running the game, you can adjust these options in the
`kaleidoscope_cookery_satiated_shield_tuner-server.toml`
file under the `config` folder to achieve a more suitable gaming experience.

## Environment

Only need to install this mod on the server side.

## Configuration Options

- IS_MODIFY_SATIATED_SHIELD
  - Whether to enable the Satiated Shield tuner.
  - If the Satiated Shield Weakness from the Kaleidoscope Compat mod is enabled, its effects will take precedence. And the configuration options of this mod will be disabled.
- IS_SATIATED_SHIELD_DISABLE_WHEN_HUNGRY_EFFECT
  - Whether to disable the Satiated Shield effect when the player has hungry effect.
  - If true, the Satiated Shield effect will not apply while the player has the Hunger effect.
- SATIATED_SHIELD_MIN_FOOD_LEVEL
  - The minimum Hunger Value required for the Satiated Shield effect to take effect.
  - When the player's hunger value is below this threshold, the Satiated Shield effect will not be active.
- SATIATED_SHIELD_ADDITIONAL_EXHAUSTION_PER_DAMAGE
  - The exhaustion added each time the player takes damage.
  - 4 points of exhaustion = 1 point of food/hunger value, and the player can accumulate up to 40 points of exhaustion in 1 game tick.
  - For example: If set to 0.5, each point of reduced damage will additionally cause 0.5 points of exhaustion.
- SATIATED_SHIELD_DAMAGE_REDUCTION_PERCENT
  - The damage reduction percentage of the Satiated Shield effect.
  - The player's incoming `original damage` will be multiplied by the `damage reduction percentage` to calculate the `damage reduction amount`.
  - For example: If set to 0.5, the player's incoming damage will be reduced by 50%.
- SATIATED_SHIELD_MAX_DAMAGE_REDUCTION
  - The maximum damage reduction amount of the Satiated Shield effect.
  - If the `damage reduction amount` exceeds this value, it will be capped at this limit.
  - For example: If set to 10.0, the player's incoming damage will be limited to a maximum reduction of 10 points.
- SATIATED_SHIELD_MIN_DAMAGE
  - The minimum damage that can be got in the Satiated Shield effect.
  - When the `original damage` is higher than this value, the `final damage` will be limited to not be lower than this value.
  - `final damage` = `original damage` - `damage reduction amount`
- SATIATED_SHIELD_WEAKNESS_DAMAGE_MULTIPLIER
  - The multiplier for the exhaustion added per point of Satiated Shield Weakness Damage.
  - 4 points of exhaustion = 1 point of food/hunger value, and the player can accumulate up to 40 points of exhaustion in 1 game tick.
