package me.eftelist.ParkBase.Utils

import org.bukkit.ChatColor

object StringUtil {
    
    private val CENTER_PX = 154

    fun sendCenteredMessage(messagem: String?): String {
        val messaged = ChatColor.translateAlternateColorCodes('&', messagem)
        var messagePxSize = 0
        var previousCode = false
        var isBold = false

        for (c in messaged.toCharArray()) {
            if (c == '§') {
                previousCode = true
                continue
            } else if (previousCode == true) {
                previousCode = false
                if (c == 'l' || c == 'L') {
                    isBold = true
                    continue
                } else
                    isBold = false
            } else {
                val dFI = DefaultFontInfo.getDefaultFontInfo(c)
                messagePxSize += if (isBold) dFI.boldLength else dFI.length
                messagePxSize++
            }
        }

        val halvedMessageSize = messagePxSize / 2
        val toCompensate = CENTER_PX - halvedMessageSize
        val spaceLength = DefaultFontInfo.SPACE.length + 1
        var compensated = 0
        val sb = StringBuilder()
        while (compensated < toCompensate) {
            sb.append(" ")
            compensated += spaceLength
        }
        return sb.toString() + messaged
    }
}
