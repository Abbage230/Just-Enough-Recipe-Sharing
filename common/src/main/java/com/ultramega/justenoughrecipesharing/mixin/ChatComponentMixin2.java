package com.ultramega.justenoughrecipesharing.mixin;

import com.ultramega.justenoughrecipesharing.client.ClientDrawRecipeInChat;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.components.ChatComponent.ChatGraphicsAccess;
import net.minecraft.client.multiplayer.chat.GuiMessage;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.client.gui.components.ChatComponent$1")
public abstract class ChatComponentMixin2 {
    @Redirect(method = "accept", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/gui/components/ChatComponent$ChatGraphicsAccess;handleMessage(IFLnet/minecraft/util/FormattedCharSequence;)Z"))
    private boolean jers$drawRecipes(final ChatGraphicsAccess graphics,
                                     final int textTop,
                                     final float opacity,
                                     final FormattedCharSequence message,
                                     @Local(argsOnly = true) final GuiMessage.Line line) {
        ClientDrawRecipeInChat.renderRecipeForLine(line, textTop, opacity);

        return graphics.handleMessage(textTop, opacity, message);
    }
}
