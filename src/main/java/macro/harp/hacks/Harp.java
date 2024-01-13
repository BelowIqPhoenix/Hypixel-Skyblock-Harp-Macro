package macro.harp.hacks;

import macro.harp.utils.InventoryUtils;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Arrays;
import java.util.List;

import static macro.harp.Main.mc;

public class Harp {

    public static boolean toggle = false;
    private List<Note> notes = Arrays.asList(new Note(37), new Note(38), new Note(39), new Note(40), new Note(41), new Note(42), new Note(43));
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event)
    {
        if (!toggle || mc.thePlayer == null || mc.currentScreen == null)
            return;

        if (!InventoryUtils.getInventoryName().contains("Harp"))
            return;

        ContainerChest chest = (ContainerChest)((GuiChest)mc.currentScreen).inventorySlots;
        IInventory inv = chest.getLowerChestInventory();
        for (Note note : notes) {
            if (note.delay > 0)
                note.delay--;

            ItemStack stack = inv.getStackInSlot(note.slot);
            if (stack == null)
                continue;

            int id = Item.getIdFromItem(stack.getItem());
            if (id == 159) {
                note.clicked = false;
                note.delay = 0;
            } else if (id == 155) {
                if (note.clicked || note.delay != 0)
                    continue;

                ItemStack stack2 = inv.getStackInSlot(note.slot - 9);
                int id2 = Item.getIdFromItem(stack2.getItem());
                if (id2 == 35) note.delay = 7;
                else note.clicked = true;
                mc.playerController.windowClick(chest.windowId, note.slot, 0, 0, mc.thePlayer);
            }
        }
    }

    private class Note {
        private int slot;
        private boolean clicked;
        private int delay;

        public Note(int slot) {
            this.slot = slot;
        }
    }
}
