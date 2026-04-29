package org.wayggstar.starstream_core

import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.LogManager
import org.wayggstar.starstream_api.StarstreamAPI
import org.wayggstar.starstream_core.data.PlayerDataManager
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

@Mod(Starstream_core.ID)
object Starstream_core {
    const val ID = "starstream_core"

    val LOGGER = LogManager.getLogger(ID)

    init {
        LOGGER.info("Starstream Core initialized")

        StarstreamAPI.setPlayerDataProvider { PlayerDataManager.currentPlayerData }

        MOD_BUS.addListener(::onCommonSetup)
    }

    private fun onCommonSetup(event: FMLCommonSetupEvent) {
        LOGGER.info("Core common setup complete")
    }
}
