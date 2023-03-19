package de.itsTyrion.crashtest.bungee.api.string

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer

object Text {
    @JvmField
    val PREFIX_NETWORK = makePrefix(miniMsg("<#FFA000>VG</#FFA000>"))

    @JvmField
    val ERROR_COLOR = TextColor.color(0xDB3434)
    private val ERROR_COLOR_HEX = ERROR_COLOR.asHexString()

    @JvmStatic
    fun error(msg: String) = miniMsg("<error>$msg")

    @JvmField
    val NO_PERMS = error("Keine Rechte")

    @JvmField
    val NO_PERMS_NETWORK = PREFIX_NETWORK.append(NO_PERMS)

    private const val PREFIX_BASE = " <dark_gray>┃ </dark_gray>"

    @JvmStatic
    fun makePrefix(base: String): Component = miniMsg("$base$PREFIX_BASE")

    @JvmStatic
    fun makePrefix(base: Component): Component = base.append(miniMsg(PREFIX_BASE))

    @JvmStatic
    fun prefixed(message: Component) = prefixed(PREFIX_NETWORK, message)

    @JvmStatic
    fun prefixed(prefix: Component, message: Component) =
        Component.text().append(prefix).append(message).build()



    /**
     * Parse [MiniMessage](https://docs.adventure.kyori.net/minimyessage/index.html) text
     */
    @JvmStatic
    fun miniMsg(text: String) = MiniMessage.builder().build()
        .deserialize(text
            .replace("<pink>", "<light_purple>").replace("</pink>", "</light_purple>")
            .replace("<purple>", "<dark_purple>").replace("</purple>", "</dark_purple>")
            .replace("<error>", "<$ERROR_COLOR_HEX>").replace("</error>", "<$ERROR_COLOR_HEX>")
        )



    @JvmStatic
    fun fromComponent(c: Component) = LegacyComponentSerializer.legacySection().serialize(c)
}