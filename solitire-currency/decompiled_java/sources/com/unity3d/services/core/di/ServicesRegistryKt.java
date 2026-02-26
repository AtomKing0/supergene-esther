package com.unity3d.services.core.di;

import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ServicesRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ServicesRegistryKt {
    @NotNull
    public static final ServicesRegistry registry(@NotNull l<? super ServicesRegistry, k0> registry) {
        t.i(registry, "registry");
        ServicesRegistry servicesRegistry = new ServicesRegistry();
        registry.invoke(servicesRegistry);
        return servicesRegistry;
    }
}
