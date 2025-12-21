package io.github.emir4169.reshex

import io.github.emir4169.reshex.config.ReshexClientConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object ReshexClient {
    fun init() {
        ReshexClientConfig.init()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(ReshexClientConfig.GlobalConfig::class.java, parent).get()
    }
}
