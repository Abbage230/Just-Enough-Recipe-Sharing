package com.ultramega.justenoughrecipesharing.network;

import net.minecraft.world.entity.player.Player;

@FunctionalInterface
public interface PacketContext {
    Player getPlayer();
}
