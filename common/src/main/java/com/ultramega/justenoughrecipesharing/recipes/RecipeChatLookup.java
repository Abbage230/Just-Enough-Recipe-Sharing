package com.ultramega.justenoughrecipesharing.recipes;

import java.util.UUID;
import javax.annotation.Nullable;

import net.minecraft.client.multiplayer.chat.GuiMessage;

public interface RecipeChatLookup {
    @Nullable
    UUID jers$getRecipeId(GuiMessage message);

    @Nullable
    Integer jers$getSpacerIndexFromBottom(GuiMessage.Line line);
}
