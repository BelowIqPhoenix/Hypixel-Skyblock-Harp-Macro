package macro.harp.utils;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import org.apache.commons.lang3.Validate;

import static macro.harp.Main.mc;

public class ChatUtils {

    public static final char COLOUR_CHAR = '\u00A7';

    public static String translateAlternativeColourCode(char alternateColourCode, String string) {
        Validate.notNull(string, "Cannot translate null text");

        char[] b = string.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == alternateColourCode && "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".indexOf(b[i + 1]) > -1) {
                b[i] = ChatUtils.COLOUR_CHAR;
                b[i + 1] = Character.toLowerCase(b[i + 1]);

            }
        }
        return new String(b);
    }
    public static String chat(String string) {
        return ChatUtils.translateAlternativeColourCode('&', string);
    }

    public static void log(String message) {
        mc.thePlayer.addChatMessage(new ChatComponentText(chat("&d[&bHarpMacro&d] &f" + message)));
    }

    public static void log(String message, ClickEvent clickEvent) {
        ChatComponentText result = new ChatComponentText(chat("&d[&bHarpMacro&d] &f" + message));
        result.setChatStyle(new ChatStyle().setChatClickEvent(clickEvent));
        mc.thePlayer.addChatMessage(result);
    }

    public static void command(String message) {
        mc.thePlayer.sendChatMessage(message);
    }
}
