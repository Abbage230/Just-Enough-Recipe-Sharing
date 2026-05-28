package com.ultramega.justenoughrecipesharing.fabric;

import com.ultramega.justenoughrecipesharing.Config;
import com.ultramega.justenoughrecipesharing.Constants;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

@me.shedaniel.autoconfig.annotation.Config(name = Constants.MOD_ID)
public final class ConfigImpl implements ConfigData, Config {
    @ConfigEntry.Gui.Tooltip
    public boolean showSharedRecipesInChat = true;

    public static void register() {
        AutoConfig.register(ConfigImpl.class, JanksonConfigSerializer::new);
    }

    public static ConfigImpl get() {
        return AutoConfig.getConfigHolder(ConfigImpl.class).getConfig();
    }

    @Override
    public boolean showSharedRecipesInChat() {
        return this.showSharedRecipesInChat;
    }
}
