package io.github.cotrin8672.mekanismponder.registry

import io.github.cotrin8672.mekanismponder.scene.BinScenes
import io.github.cotrin8672.mekanismponder.scene.ThermalEvaporationScene
import mekanism.common.registration.impl.BlockRegistryObject
import mekanism.common.registries.MekanismBlocks
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper
import net.minecraft.resources.ResourceLocation

typealias MekB = MekanismBlocks

object PonderScenes {
    fun register(helper: PonderSceneRegistrationHelper<ResourceLocation>) {
        val registry = helper.withKeyFunction { obj: BlockRegistryObject<*, *> -> obj.registryName }

        registry.forComponents(MekB.BASIC_BIN)
            .addStoryBoard("base5", BinScenes.abstractBin(MekB.BASIC_BIN))

        registry.forComponents(MekB.ADVANCED_BIN)
            .addStoryBoard("base5", BinScenes.abstractBin(MekB.ADVANCED_BIN))

        registry.forComponents(MekB.ELITE_BIN)
            .addStoryBoard("base5", BinScenes.abstractBin(MekB.ELITE_BIN))

        registry.forComponents(MekB.ULTIMATE_BIN)
            .addStoryBoard("base5", BinScenes.abstractBin(MekB.ULTIMATE_BIN))

        registry.forComponents(
            MekB.THERMAL_EVAPORATION_BLOCK,
            MekB.THERMAL_EVAPORATION_VALVE,
            MekB.THERMAL_EVAPORATION_CONTROLLER
        )
            .addStoryBoard("multiblock/thermal_evaporation", ThermalEvaporationScene::build)
    }
}
