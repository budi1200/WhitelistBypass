package si.budimir.whitelistbypass

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import si.budimir.whitelistbypass.listeners.PlayerLoginListener

class WhitelistBypassMain: JavaPlugin() {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(PlayerLoginListener(this), this)
    }
}