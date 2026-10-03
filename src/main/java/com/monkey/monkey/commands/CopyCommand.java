package com.monkey.monkey.commands;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import java.awt.*;

public class CopyCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "copy";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/copy";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            return;
        }

        GuiScreen.setClipboardString(String.join(" ", args));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
