package macro.harp.utils;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.inventory.ContainerChest;

import static macro.harp.Main.mc;

public class InventoryUtils {
    public static String getInventoryName() {

        GuiScreen gui = mc.currentScreen;
        if (gui instanceof GuiChest) {
            return ((ContainerChest) ((GuiChest) gui).inventorySlots).getLowerChestInventory().getDisplayName().getUnformattedText();
        }
        return "";
    }
}

