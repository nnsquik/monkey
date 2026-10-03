package com.monkey.monkey.chat;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.*;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatMod {
    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent event) {
        if (event.type == 2) {
            return;
        }

        String plain = event.message.getUnformattedText();
        if (plain.trim().isEmpty()) {
            return;
        }

        applyCopy(event.message, plain);
    }

    private void applyCopy(IChatComponent component, String text) {
        ChatStyle style = component.getChatStyle();

        if (style.getChatClickEvent() == null) {
            style.setChatClickEvent(new ClickEvent(
                    ClickEvent.Action.RUN_COMMAND, "/copy " + text));
        }

        for (Object sibling : component.getSiblings()) {
            applyCopy((IChatComponent) sibling, text);
        }
    }
}
