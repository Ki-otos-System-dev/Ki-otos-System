package com.kiotos.system;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(KiotosSystem.MODID)
public class KiotosSystem {
    public static final String MODID = "kiotos_system";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public KiotosSystem(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("Initializing {} v{}", KiotosSystem.MODID, "0.0.0");

        // Register all deferred registers with the mod event bus.
        // Individual systems (data, networking, gui) will register their
        // own DeferredRegisters here in later modules.
        for (DeferredRegister<?> register : ModRegistry.getRegistrars()) {
            register.register(modEventBus);
        }
    }
}
