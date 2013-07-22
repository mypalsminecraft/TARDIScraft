package tk.mypalsgaming.TARDIScraft;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class TARDIScraft extends JavaPlugin {
	
	Logger console = getLogger();
	
	@Override
	public void onEnable() {
		
		console.info("Enabling the TARDIS plugin...");
		
		// onEnable code
		
	}
	
	@Override
	public void onDisable() {
		
		console.info("Disabling the TARDIS plugin...");
		
		// onDisable code
		
	}
	
}
