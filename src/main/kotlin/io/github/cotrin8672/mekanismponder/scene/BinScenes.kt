package io.github.cotrin8672.mekanismponder.scene

import mekanism.common.block.basic.BlockBin
import mekanism.common.item.block.ItemBlockBin
import mekanism.common.registration.impl.BlockRegistryObject
import mekanism.common.tile.TileEntityBin
import net.createmod.catnip.math.Pointing
import net.createmod.ponder.api.scene.SceneBuilder
import net.createmod.ponder.api.scene.SceneBuildingUtil
import net.createmod.ponder.foundation.PonderSceneBuilder
import net.minecraft.core.Direction
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.ListTag
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items

object BinScenes {
    fun abstractBin(blockRegistry: BlockRegistryObject<BlockBin, ItemBlockBin>) =
        { builder: SceneBuilder, util: SceneBuildingUtil ->
            val bin = util.grid().at(2, 1, 2)

            with(PonderSceneBuilder(builder.scene)) {
                title(blockRegistry.name, "Storing Items by Bin")
                configureBasePlate(0, 0, 5)

                world().setBlock(bin, blockRegistry.block.defaultBlockState(), false)

                world().showSection(util.select().layer(0), Direction.UP)
                idle(5)
                world().showSection(util.select().position(bin), Direction.DOWN)
                idle(20)

                overlay().showText(60)
                    .attachKeyFrame()
                    .placeNearTarget()
                    .pointAt(util.vector().topOf(bin))
                    .text("The Ender Tank has a slot for setting its frequency")
                idle(80)

                overlay().showControls(util.vector().topOf(bin), Pointing.DOWN, 30).rightClick()
                    .withItem(ItemStack(Items.REDSTONE))

                idle(10)

                world().modifyBlockEntityNBT(util.select().position(bin), TileEntityBin::class.java) {
                    it.put("Items", ListTag().apply {
                        add(CompoundTag().apply {
                            put("Item", CompoundTag().apply {
                                putString("id", "minecraft:redstone")
                                putByte("Count", 64)
                            })
                            putByte("Slot", 0)
                            putInt("SizeOverride", 64)
                        })
                    })
                }

                idle(40)

                overlay().showControls(util.vector().topOf(bin), Pointing.DOWN, 30).rightClick()
                    .withItem(ItemStack(Items.REDSTONE))

                idle(10)

                world().modifyBlockEntityNBT(util.select().position(bin), TileEntityBin::class.java) {
                    it.put("Items", ListTag().apply {
                        add(CompoundTag().apply {
                            put("Item", CompoundTag().apply {
                                putString("id", "minecraft:redstone")
                                putByte("Count", 64)
                            })
                            putByte("Slot", 0)
                            putInt("SizeOverride", 128)
                        })
                    })
                }

                idle(20)

                overlay().showText(60)
                    .attachKeyFrame()
                    .placeNearTarget()
                    .pointAt(util.vector().topOf(bin))
                    .text("The Ender Tank has a slot for setting its frequency")
                idle(80)

                overlay().showControls(util.vector().topOf(bin), Pointing.DOWN, 30).leftClick().whileSneaking()
                    .withItem(ItemStack(Items.REDSTONE))

                idle(10)

                world().modifyBlockEntityNBT(util.select().position(bin), TileEntityBin::class.java) {
                    it.put("Items", ListTag().apply {
                        add(CompoundTag().apply {
                            put("Item", CompoundTag().apply {
                                putString("id", "minecraft:redstone")
                                putByte("Count", 63)
                            })
                            putByte("Slot", 0)
                            putInt("SizeOverride", 127)
                        })
                    })
                }

                overlay().showText(60)
                    .attachKeyFrame()
                    .placeNearTarget()
                    .pointAt(util.vector().topOf(bin))
                    .text("The Ender Tank has a slot for setting its frequency")
                idle(80)

                overlay().showControls(util.vector().topOf(bin), Pointing.DOWN, 30).leftClick()
                    .withItem(ItemStack(Items.REDSTONE))

                idle(10)

                world().modifyBlockEntityNBT(util.select().position(bin), TileEntityBin::class.java) {
                    it.put("Items", ListTag().apply {
                        add(CompoundTag().apply {
                            put("Item", CompoundTag().apply {
                                putString("id", "minecraft:redstone")
                                putByte("Count", 63)
                            })
                            putByte("Slot", 0)
                        })
                    })
                }

                overlay().showText(60)
                    .attachKeyFrame()
                    .placeNearTarget()
                    .pointAt(util.vector().topOf(bin))
                    .text("The Ender Tank has a slot for setting its frequency")
                idle(80)

                overlay().showControls(util.vector().topOf(bin), Pointing.DOWN, 30).rightClick().whileSneaking()

                idle(10)

                world().modifyBlockEntity(bin, TileEntityBin::class.java, TileEntityBin::toggleLock)

                overlay().showText(60)
                    .attachKeyFrame()
                    .placeNearTarget()
                    .pointAt(util.vector().topOf(bin))
                    .text("The Ender Tank has a slot for setting its frequency")
                idle(80)
            }
        }
}
