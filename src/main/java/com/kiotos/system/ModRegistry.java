package com.kiotos.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Central holder for every DeferredRegister this mod uses.
 *
 * <p>Each system (items, blocks, attachments, menus, creative tabs, ...) registers
 * its DeferredRegisters here so that {@link KiotosSystem} can register them all
 * with the mod event bus in a single place. Later modules append their registrars
 * through {@link #add(DeferredRegister)}.</p>
 */
public final class ModRegistry {
    private static final List<DeferredRegister<?>> REGISTRARS = new ArrayList<>();

    private ModRegistry() {
    }

    /**
     * Add a DeferredRegister to be registered with the mod event bus.
     *
     * <p>All additions should happen before (or during) the mod constructor so that
     * the register call in {@link KiotosSystem} picks them up.</p>
     */
    public static void add(DeferredRegister<?> register) {
        REGISTRARS.add(register);
    }

    /**
     * @return an immutable view of all added DeferredRegisters.
     */
    public static List<DeferredRegister<?>> getRegistrars() {
        return Collections.unmodifiableList(REGISTRARS);
    }
}
