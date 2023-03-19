package de.itsTyrion.crashtest.bungee

import de.itsTyrion.crashtest.bungee.cmd.Ping
import net.md_5.bungee.api.ProxyServer
import net.md_5.bungee.api.plugin.Plugin

class CrashtestMain : Plugin() {

    override fun onEnable() {

        val commands = arrayOf(
            Ping()
        )

        val pm = ProxyServer.getInstance().pluginManager
        for (command in commands)
            pm.registerCommand(this, command)
    }
}