@file:JvmName("ReshexAbstractionsImpl")

package io.github.emir4169.reshex.forge

import io.github.emir4169.reshex.registry.ReshexRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: ReshexRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
