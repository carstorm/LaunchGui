package main.launchgui;

import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiEventHandler {

	private boolean shouldLoadGUI = true;

	public static GuiEventHandler instance = new GuiEventHandler();

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void openMainMenu(GuiOpenEvent event) {
		if (shouldLoadGUI && ((ConfigHandler.displayGuiOnLaunch && Loader.isModLoaded(ConfigHandler.modToFind)) || (ConfigHandler.enableUpdateChecker && Utils.isUpdateAvailable()))) {
			event.gui = new StartupGui();
			shouldLoadGUI = false;
		}
	}
}
