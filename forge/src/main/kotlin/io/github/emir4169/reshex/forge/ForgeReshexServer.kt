package io.github.emir4169.reshex.forge

import io.github.emir4169.reshex.Reshex
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object ForgeReshexServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        Reshex.initServer()
    }
}
