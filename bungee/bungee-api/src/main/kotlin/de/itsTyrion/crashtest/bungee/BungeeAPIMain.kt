package de.itsTyrion.crashtest.bungee

import net.kyori.adventure.platform.bungeecord.BungeeAudiences
import net.kyori.adventure.text.Component
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.plugin.Plugin

internal class BungeeAPIMain : Plugin()  {

    override fun onEnable() {
        instance = this
        audiences = BungeeAudiences.create(this)
    }

    companion object {
        @JvmStatic
        lateinit var audiences: BungeeAudiences
        @JvmStatic
        lateinit var instance: BungeeAPIMain
    }
}
fun CommandSender.sendMessage(component: Component) = BungeeAPIMain.audiences.sender(this).sendMessage(component)
fun ProxiedPlayer.sendMessage(component: Component) = BungeeAPIMain.audiences.player(this).sendMessage(component)