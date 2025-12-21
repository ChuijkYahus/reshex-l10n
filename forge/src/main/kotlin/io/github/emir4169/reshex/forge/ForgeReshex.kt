package io.github.emir4169.reshex.forge

import dev.architectury.platform.forge.EventBuses
import io.github.emir4169.reshex.Reshex
import io.github.emir4169.reshex.forge.datagen.ForgeReshexDatagen
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Reshex.MODID)
class ForgeReshex {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Reshex.MODID, this)
            addListener(ForgeReshexClient::init)
            addListener(ForgeReshexDatagen::init)
            addListener(ForgeReshexServer::init)
        }
        Reshex.init()
    }
}
