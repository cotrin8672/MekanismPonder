package io.github.cotrin8672.mekanismponder

import io.github.cotrin8672.mekanismponder.registry.PonderScenes
import net.createmod.ponder.api.registration.PonderPlugin
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper
import net.minecraft.resources.ResourceLocation

object MekanismPonderPlugin : PonderPlugin {
    override fun getModId(): String {
        return MekanismPonder.ID
    }

    override fun registerScenes(helper: PonderSceneRegistrationHelper<ResourceLocation>) {
        PonderScenes.register(helper)
    }
}
