package me.eftelist.ParkBase

class BaseImpl : ParkBase() {

    override fun loadDependencies() {
        addDependency(Dependency("WorldGuard"))
        addDependency(Dependency("WorldEdit"))
        addDependency(Dependency("PermissionsEx"))
        addDependency(Dependency("Vault"))
        addDependency(Dependency("ProtocolLib"))
    }

    override fun enable() {
        logger.info("Great. It works!")
    }

    override fun disable() {
        logger.info("Bye.")
    }

}