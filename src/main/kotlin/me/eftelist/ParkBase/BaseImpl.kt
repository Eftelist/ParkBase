package me.eftelist.ParkBase

import com.earth2me.essentials.Essentials
import me.eftelist.ParkBase.Base.Dependency
import me.eftelist.ParkBase.Base.ParkBase
import me.eftelist.ParkBase.Commands.Manager.CommandManager
import me.eftelist.ParkBase.Listeners.BaseListener
import me.eftelist.ParkBase.Utils.Exceptions.ErrorUtil
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin

class BaseImpl : ParkBase() {

    override fun loadDependencies() {
        addDependency(Dependency("WorldGuard"))
        addDependency(Dependency("WorldEdit"))
        addDependency(Dependency("PermissionsEx"))
        addDependency(Dependency("Vault"))
        addDependency(Dependency("ProtocolLib"))
    }

    override fun enable() {
        try {
            instance = this;
            plugin = this;
            essentials = Bukkit.getPluginManager().getPlugin("Essentials") as Essentials
            Bukkit.getPluginManager().registerEvents(BaseListener(),this)
            CommandManager()
            logger.info("Great. It works!")
        } catch (exception: Exception){
            ErrorUtil.reportException(exception, this.javaClass, true)
        }

    }

    override fun disable() {
        logger.info("Bye.")
        plugin = null;
        instance = null;
    }

    companion object {
        var instance: BaseImpl? = null
        var essentials: Essentials? = null
        var plugin: JavaPlugin? = null;
    }

}