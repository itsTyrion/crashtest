package de.itsTyrion.crashtest.bungee.cmd

import de.itsTyrion.crashtest.bungee.api.string.Text
import de.itsTyrion.crashtest.bungee.sendMessage
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.plugin.Command

class Ping : Command("ping") {
    private val pong = Text.makePrefix("<blue>Pong")

    override fun execute(sender: CommandSender, args: Array<String>) {
        val p = sender as? ProxiedPlayer ?: return

        val ping = p.ping
        val color = when {
            ping < 45 -> NamedTextColor.GREEN
            ping > 300 -> NamedTextColor.DARK_RED
            ping > 150 -> NamedTextColor.RED
            ping > 100 -> TextColor.color(0xFF8500) // bright orange-yellow
            else -> NamedTextColor.YELLOW
        }.asHexString()
        val message = pong.append(Text.miniMsg("<aqua>Dein Ping beträgt <$color>$ping <aqua>ms"))

        p.sendMessage(message)
    }
}