package com.ultramega.justenoughrecipesharing.mixin;

import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ChatComponent.class)
public interface InvokerChatComponent {
    @Invoker(value = "getLineHeight", remap = false)
    int jers$getLineHeight();

    @Invoker(value = "getWidth", remap = false)
    int jers$getWidth();

    @Invoker(value = "getHeight", remap = false)
    int jers$getHeight();
}
