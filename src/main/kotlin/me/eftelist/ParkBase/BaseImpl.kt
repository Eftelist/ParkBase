package me.eftelist.ParkBase

import com.earth2me.essentials.Essentials
import org.bukkit.Bukkit

class BaseImpl : ParkBase() {

    override fun loadDependencies() {
        addDependency(Dependency("WorldGuard"))
        addDependency(Dependency("WorldEdit"))
        addDependency(Dependency("PermissionsEx"))
        addDependency(Dependency("Vault"))
        addDependency(Dependency("ProtocolLib"))
    }

    override fun enable() {
        instance = this;
        essentials = Bukkit.getPluginManager().getPlugin("Essentials") as Essentials
        logger.info("Great. It works!")
    }

    override fun disable() {
        logger.info("Bye.")
        instance = null;
    }

    companion object {
        var instance: BaseImpl? = null
        var essentials: Essentials? = null
    }

}