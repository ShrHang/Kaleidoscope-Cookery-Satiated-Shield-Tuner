package com.shrhang.kaleidoscope_cookery_satiated_shield_tuner;

import com.shrhang.kaleidoscope_cookery_satiated_shield_tuner.content.config.ServerConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(Kaleidoscope_Cookery_Satiated_Shield_Tuner.MODID)
public class Kaleidoscope_Cookery_Satiated_Shield_Tuner {
    public static final String MODID = "kaleidoscope_cookery_satiated_shield_tuner";
    public Kaleidoscope_Cookery_Satiated_Shield_Tuner(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.SERVER, ServerConfig.serverSpec);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }
    }
}