@file:JvmName("ReshexAbstractions")

package io.github.emir4169.reshex

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.emir4169.reshex.registry.ReshexRegistrar

fun initRegistries(vararg registries: ReshexRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: ReshexRegistrar<T>) {
    throw AssertionError()
}
