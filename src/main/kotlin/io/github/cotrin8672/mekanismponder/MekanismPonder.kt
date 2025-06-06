package io.github.cotrin8672.mekanismponder

import net.createmod.ponder.foundation.PonderIndex
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.DistExecutor
import net.minecraftforge.fml.common.Mod

@Mod(MekanismPonder.ID)
object MekanismPonder {
    const val ID = "mekanismponder"

    init {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT) {
            Runnable {
                PonderIndex.addPlugin(MekanismPonderPlugin)
            }
        }
    }
}
