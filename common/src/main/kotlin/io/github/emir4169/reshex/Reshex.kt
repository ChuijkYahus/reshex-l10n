package io.github.emir4169.reshex

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.emir4169.reshex.config.ReshexServerConfig
import io.github.emir4169.reshex.networking.ReshexNetworking
import io.github.emir4169.reshex.registry.ReshexActions

object Reshex {
    const val MODID = "reshex"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        ReshexServerConfig.init()
        initRegistries(
            ReshexActions,
        )
        ReshexNetworking.init()
    }

    fun initServer() {
        ReshexServerConfig.initServer()
    }
}
