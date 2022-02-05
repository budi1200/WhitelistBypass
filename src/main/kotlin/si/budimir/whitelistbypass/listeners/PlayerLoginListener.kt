package si.budimir.whitelistbypass.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerLoginEvent
import si.budimir.whitelistbypass.WhitelistBypassMain

class PlayerLoginListener(private val plugin: WhitelistBypassMain): Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    fun onKick(e: PlayerLoginEvent) {
        // Continue only if whitelist kick
        if (e.result != PlayerLoginEvent.Result.KICK_WHITELIST) return

        // Check for bypass permission
        if (!e.player.hasPermission("whitelistbypass.bypass")) return

        e.result = PlayerLoginEvent.Result.ALLOWED
        plugin.logger.info("${e.player.name} (${e.player.uniqueId}) bypassed the whitelist!")
    }
}