package main.launchgui;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION)
public class LaunchGui {

	public static Logger logger = LogManager.getLogger(ModInformation.NAME);

	@Mod.Instance
	public static LaunchGui instance;
	public static Configuration config;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		ConfigHandler.init(config);

		MinecraftForge.EVENT_BUS.register(GuiEventHandler.instance);
	}
}
