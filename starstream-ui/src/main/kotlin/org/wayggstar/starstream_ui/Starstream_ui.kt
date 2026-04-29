package org.wayggstar.starstream_ui

import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.LogManager
import org.wayggstar.starstream_ui.screen.HudManager
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

@Mod(Starstream_ui.ID)
object Starstream_ui {
    const val ID = "starstream_ui"

    val LOGGER = LogManager.getLogger(ID)

    init {
        LOGGER.info("Starstream UI initialized")

        MOD_BUS.addListener(::onClientSetup)
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.info("Registering ModernUI HUD...")
        HudManager.register()
    }
}
