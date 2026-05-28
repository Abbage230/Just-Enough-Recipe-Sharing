package com.ultramega.justenoughrecipesharing.neoforge.platform;

import com.ultramega.justenoughrecipesharing.Config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class ConfigImpl implements Config {
    public static final ConfigImpl INSTANCE = new ConfigImpl();

    private final ModConfigSpec spec;
    private final ModConfigSpec.ConfigValue<Boolean> showSharedRecipesInChat;

    private ConfigImpl() {
        final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        this.showSharedRecipesInChat = builder
            .comment("Whether shared recipes should appear in chat.")
            .translation("text.autoconfig.justenoughrecipesharing.option.showSharedRecipesInChat")
            .define("showSharedRecipesInChat", true);

        this.spec = builder.build();
    }

    public ModConfigSpec getSpec() {
        return this.spec;
    }

    @Override
    public boolean showSharedRecipesInChat() {
        return this.showSharedRecipesInChat.get();
    }
}
