package com.kiotos.system;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

/**
 * Client-side only entry point. Not loaded on dedicated servers.
 *
 * <p>Client-specific registrations (screens, keybinds, render hooks) are added in
 * later modules. For now it only wires up the config screen.</p>
 */
@Mod(value = KiotosSystem.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = KiotosSystem.MODID, value = Dist.CLIENT)
public class KiotosSystemClient {
    public KiotosSystemClient(ModContainer container) {
        // Allow NeoForge to create a config screen for this mod's configs.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        KiotosSystem.LOGGER.info("Ki-otos System client setup complete");
    }
}
