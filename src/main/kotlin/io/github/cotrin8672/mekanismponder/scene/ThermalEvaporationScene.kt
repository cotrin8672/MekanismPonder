package io.github.cotrin8672.mekanismponder.scene

import mekanism.common.block.attribute.AttributeStateActive
import mekanism.common.block.attribute.Attributes
import mekanism.common.registries.MekanismBlocks
import mekanism.common.tile.multiblock.TileEntityThermalEvaporationBlock
import net.createmod.ponder.api.scene.SceneBuilder
import net.createmod.ponder.api.scene.SceneBuildingUtil
import net.createmod.ponder.api.scene.WorldInstructions
import net.createmod.ponder.foundation.PonderSceneBuilder
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.block.entity.BlockEntity

object ThermalEvaporationScene {
    fun build(builder: SceneBuilder, util: SceneBuildingUtil) {
        val valve = util.grid().at(3, 2, 1)
        val controller = util.grid().at(2, 2, 1)
        val block = util.grid().at(1, 2, 1)
        val controllerState = MekanismBlocks.THERMAL_EVAPORATION_CONTROLLER.block.defaultBlockState()

        with(PonderSceneBuilder(builder.scene)) {
            title("thermal_evaporation", "Building Thermal Evaporation Plant")
            configureBasePlate(0, 0, 6)

            world().setBlock(controller, controllerState, false)

            world().showSection(util.select().layer(0), Direction.UP)
            idle(5)
            world().showSection(util.select().layer(1), Direction.DOWN)
            idle(5)
            world().showSection(util.select().layer(2), Direction.DOWN)
            idle(5)
            world().showSection(util.select().layer(3), Direction.DOWN)
            idle(20)

            world().setBlock(
                controller,
                (Attributes.ACTIVE as AttributeStateActive).setActive(controllerState, true),
                false
            )

            idle(10)

            world().modifyBlockEntity<TileEntityThermalEvaporationBlock>(block) {
                createMultiblock()
                createFormationProtocol()
            }

            effects().indicateRedstone(controller)

            overlay().showText(60)
                .attachKeyFrame()
                .placeNearTarget()
                .pointAt(util.vector().topOf(controller))
                .text("The Ender Tank has a slot for setting its frequency")
            idle(80)
        }
    }
}

inline fun <reified T : BlockEntity> WorldInstructions.modifyBlockEntity(
    blockPos: BlockPos,
    noinline block: T.() -> Unit,
) {
    this.modifyBlockEntity(blockPos, T::class.java, block)
}
