package com.ultramega.justenoughrecipesharing;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
    public static final String MOD_ID = "justenoughrecipesharing";
    public static final String MOD_NAME = "Just Enoguh Recipe Sharing";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    private Constants() {
    }

    public static Identifier modLoc(final String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
