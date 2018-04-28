package me.eftelist.ParkBase.Builders.Messages

import me.eftelist.ParkBase.Utils.StringUtil
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class MessageBuilder {

    private val messagelist: ArrayList<String> =  ArrayList<String>()

    fun add(message: String): MessageBuilder {
        messagelist.add(ChatColor.translateAlternateColorCodes('&',message))
        return this
    }
    
    fun addEnter(): MessageBuilder{
        messagelist.add(" ")
        return this
    }
    
    fun addColored(message: String, chatColor: ChatColor): MessageBuilder{
        messagelist.add("" + ChatColor.RESET + chatColor + message)
        return this
    }
    
    fun addCentered(message: String): MessageBuilder{
        messagelist.add(StringUtil.sendCenteredMessage(message))
        return this
    }
    
    fun build(player: Player){
        for(Message in messagelist){
            player.sendMessage(Message)
        }
    }
}