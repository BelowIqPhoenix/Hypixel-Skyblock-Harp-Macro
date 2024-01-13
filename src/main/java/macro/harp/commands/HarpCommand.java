package macro.harp.commands;

import macro.harp.hacks.Harp;
import macro.harp.utils.ChatUtils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HarpCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "harp";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName() + " <on/off>";
    }

    @Override
    public List<String> getCommandAliases() {
        return new ArrayList<>(Arrays.asList(new String[]{}));
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            ChatUtils.log("Invalid Usage /harp <on/off>");
            return;
        }

        String toggle = args[0];
        if (toggle.equalsIgnoreCase("on")) {
            Harp.toggle = true;
            ChatUtils.log("HarpMacro On!");
        } else if (toggle.equalsIgnoreCase("off")) {
            Harp.toggle = false;
            ChatUtils.log("HarpMacro Off!");
        } else {
            ChatUtils.log("Invalid Usage /harp <on/off>");
            return;
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
