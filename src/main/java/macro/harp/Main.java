package macro.harp;

import macro.harp.commands.HarpCommand;
import macro.harp.hacks.Harp;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "modid", useMetadata = true)
public class Main
{
    public static final Minecraft mc = Minecraft.getMinecraft();

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new Harp());
        ClientCommandHandler.instance.registerCommand(new HarpCommand());
    }
}
