package tk.mypalsgaming.TARDIScraft;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class TARDIScraft extends JavaPlugin {
	
	// Logger console = getLogger();
	
	/*
	 * Vault Permissions object
	 */
	public static Permission perms = null;
	
	/*
	 * (non-Javadoc)
	 * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
	 */
	@Override
	public void onEnable() {
		
		getLogger().info("Enabling the TARDIS plugin...");
		
		// TODO: onEnable code
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.bukkit.plugin.java.JavaPlugin#onDisable()
	 */
	@Override
	public void onDisable() {
		
		getLogger().info("Disabling the TARDIS plugin...");
		
		// TODO: onDisable code
		
	}
	
	
	/*
	 * Method called by Vault to set up perms
	 */
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
	
    /*
     * Called on player join by Spigot
     */
	public void onPlayerJoin(PlayerJoinEvent evt) {
		
		Player player = evt.getPlayer();
		
		if ( /*player.hasPermission("TARDIScraft.admin")*/ perms.has(player, "TARDIScraft.admin") ) {
			
			getLogger().info("Admin " + player.getName() + " has joined the game.");
			
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.bukkit.plugin.java.JavaPlugin#onCommand(org.bukkit.command.CommandSender, org.bukkit.command.Command, java.lang.String, java.lang.String[])
	 */
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if ( cmd.getName().equalsIgnoreCase("tardis") ) {
			
			boolean senderIsPlayer;
			
			if ( sender instanceof Player ) {
				
				senderIsPlayer = true;
				
			} else senderIsPlayer = false;
			
			// TODO: tardis Command
			
			if ( args[0].equalsIgnoreCase("admin") ) {
				
				Player playerToAdmin = Bukkit.getPlayer(args[1]);
				if ( playerToAdmin != null ) {
					
					if ( !playerToAdmin.hasPermission("TARDIScraft.admin") ) {
						
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerToAdmin.getName() + " add TARDIScraft.admin");
						// perms.playerAddTransient(playerToAdmin, "TARDIScraft.admin");
						sender.sendMessage("Player has been set to Admin");
						
					} else {
						
						sender.sendMessage("Player " + args[1] + " is already admin. Perhaps you meant /tardis unadmin " + args[1] + "?");
						
					}
					
				} else {
					
					sender.sendMessage("Player " + args[1] + " is not online.");
					
				}
				
			}
			
			return true;
			
		} else {
			
			return false;
		}
		
	}
	
}
