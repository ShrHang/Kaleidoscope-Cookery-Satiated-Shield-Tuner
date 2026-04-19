# 森罗物语：厨房——饱腹代偿调整器

[![EN](https://img.shields.io/badge/English-EN-blue)](README.md)
[![CurseForge](https://img.shields.io/curseforge/dt/1496142?logo=curseforge&label=CurseForge)](https://www.curseforge.com/minecraft/mc-mods/kaleidoscope-cookery-satiated-shield-tuner)
[![Modrinth](https://img.shields.io/modrinth/dt/dj8HLXRh?logo=modrinth&label=Modrinth)](https://modrinth.com/mod/kaleidoscope-cookery-satiated-shield-tuner)
[![MCMOD](https://img.shields.io/badge/MC百科-MCMOD-lime)](https://www.mcmod.cn/class/25807.html)

## 须知

本模组仅适用于《森罗物语：厨房》1.1.0至1.2.1版本，因为《森罗物语：厨房》的后续版本已经包含本模组的功能。

## 概述

饱腹代偿是模组《森罗物语：厨房》中的一个状态效果，它来源廉价却效果强力，以至于让注重游戏平衡性的玩家极为头疼。

本模组为饱腹代偿效果提供了数个可配置项，允许玩家根据自己的需求和喜好调整其效果强度。

在安装本模组并运行游戏后，你可以在游戏中调整这些配置（前提是你在客户端也安装了本模组），或者在 `config` 文件夹下的
`kaleidoscope_cookery_satiated_shield_tuner-server.toml`
文件中来调整这些选项，以达到更适合自己的游戏体验。

[ConfigUI](image/ConfigUI.png)

## 运行环境

只需在服务端安装本模组即可。

## 配置项说明

- IS_MODIFY_SATIATED_SHIELD
  - 是否启用饱腹代偿调整器。
  - 如果模组《森罗物语：兼容》的饱腹代偿效果削弱被启用，则优先使用它的削弱效果，且本选项无效。
- IS_SATIATED_SHIELD_DISABLE_WHEN_HUNGRY_EFFECT
  - 当玩家处于饥饿状态效果时是否禁用饱腹代偿效果。
  - 当为 true 时，玩家存在饥饿状态效果时饱腹代偿效果不生效。
- SATIATED_SHIELD_MIN_FOOD_LEVEL
  - 饱腹代偿效果生效所需的最低饥饿值。
  - 当玩家饥饿值低于该值时，饱腹代偿不生效。
- SATIATED_SHIELD_ADDITIONAL_EXHAUSTION_PER_DAMAGE
  - 每次受到伤害时增加的疲劳值。
  - 4点疲劳值 = 1点饱食度/饥饿值，在 1 游戏刻中玩家最多积累 40 点疲劳值。
  - 例如：如果设置为 0.5，每点被减免的伤害将额外造成 0.5 点疲劳值。
- SATIATED_SHIELD_DAMAGE_REDUCTION_PERCENT
  - 饱腹代偿效果的`伤害减免百分比`。
  - 玩家受到的`原始伤害`将乘以`伤害减免百分比`来计算`伤害减免量`。
  - 例如：如果设置为 0.5，玩家受到的伤害将减少 50%。
- SATIATED_SHIELD_MAX_DAMAGE_REDUCTION
  - 饱腹代偿效果的`最大伤害减免量`。
  - 例如：如果设置为 10.0，玩家受到的伤害将被限制为最多减少 10 点伤害。
- SATIATED_SHIELD_MIN_DAMAGE
  - 饱腹代偿效果下可造成的最小伤害。
  - `原始伤害`高于该值时，`最终伤害`将被限制为不低于该值。
  - `最终伤害` = `原始伤害` - `伤害减免量`
- SATIATED_SHIELD_WEAKNESS_DAMAGE_MULTIPLIER
  - 每点饱腹代偿弱点伤害增加的疲劳值的乘算倍率。
  - 4点疲劳值 = 1点饱食度/饥饿值，在 1 游戏刻中玩家最多积累 40 点疲劳值。
