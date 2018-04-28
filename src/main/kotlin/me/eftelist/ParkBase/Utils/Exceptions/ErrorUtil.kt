package me.eftelist.ParkBase.Utils.Exceptions

import com.okkero.skedule.BukkitDispatcher
import com.okkero.skedule.schedule
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import me.eftelist.ParkBase.BaseImpl
import org.apache.commons.io.FileUtils.waitFor
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.scheduler.BukkitRunnable
import java.util.concurrent.TimeUnit

object ErrorUtil {

    fun reportException(e: Exception, c: Class<Any>, stop: Boolean) {
        Bukkit.broadcast(ChatColor.translateAlternateColorCodes('&',"&4Unhandled exception caught: &c" + e.message + " in " + c.getName()), "PB.Admin")
        e.printStackTrace()
        if(stop){
            launch(BukkitDispatcher(BaseImpl.plugin!!)){
                delay(5, TimeUnit.SECONDS)
                Bukkit.shutdown()
            }
        }
    }
}