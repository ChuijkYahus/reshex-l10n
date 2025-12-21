@file:JvmName("ReshexAbstractionsImpl")

package io.github.emir4169.reshex.fabric

import io.github.emir4169.reshex.registry.ReshexRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: ReshexRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
