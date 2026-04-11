package com.ultramega.justenoughrecipesharing.mixin;

import com.ultramega.justenoughrecipesharing.JeiRecipeSharingPlugin;
import com.ultramega.justenoughrecipesharing.client.ClientChatRecipeInteraction;
import com.ultramega.justenoughrecipesharing.client.ClientRecipeShareManager;

import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.input.MouseButtonEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatScreen.class)
public abstract class ChatScreenMixin {
    @Inject(method = "mouseClicked", at = @At("HEAD"))
    private void mouseClicked(final MouseButtonEvent event, final boolean doubleClick, final CallbackInfoReturnable<Boolean> cir) {
        if (event.button() != 0) {
            return;
        }

        final Minecraft mc = Minecraft.getInstance();

        final double localX = event.x() / mc.options.chatScale().get() - 4.0;
        final double localY = event.y() / mc.options.chatScale().get();

        final UUID recipeId = ClientChatRecipeInteraction.findRecipeAt(localX, localY);
        if (recipeId == null) {
            return;
        }
        final ClientRecipeShareManager.SharedRecipeDrawable<?> shared = ClientRecipeShareManager.get(recipeId);
        if (shared == null) {
            return;
        }

        JeiRecipeSharingPlugin.openSharedRecipe(shared);
    }
}
