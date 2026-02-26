package com.unity3d.services.core.di;

import h9.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: ServicesRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ServicesRegistry implements IServicesRegistry {

    @NotNull
    private final ConcurrentHashMap<ServiceKey, l<?>> _services = new ConcurrentHashMap<>();

    public static /* synthetic */ ServiceKey factory$default(ServicesRegistry servicesRegistry, String named, a instance, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            named = "";
        }
        t.i(named, "named");
        t.i(instance, "instance");
        t.o(4, "T");
        ServiceKey serviceKey = new ServiceKey(named, o0.b(Object.class));
        servicesRegistry.updateService(serviceKey, ServiceFactoryKt.factoryOf(instance));
        return serviceKey;
    }

    public static /* synthetic */ Object get$default(ServicesRegistry servicesRegistry, String named, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            named = "";
        }
        t.i(named, "named");
        t.o(4, "T");
        return servicesRegistry.resolveService(new ServiceKey(named, o0.b(Object.class)));
    }

    public static /* synthetic */ Object getOrNull$default(ServicesRegistry servicesRegistry, String named, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            named = "";
        }
        t.i(named, "named");
        t.o(4, "T");
        return servicesRegistry.resolveServiceOrNull(new ServiceKey(named, o0.b(Object.class)));
    }

    public static /* synthetic */ ServiceKey single$default(ServicesRegistry servicesRegistry, String named, a instance, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            named = "";
        }
        t.i(named, "named");
        t.i(instance, "instance");
        t.o(4, "T");
        ServiceKey serviceKey = new ServiceKey(named, o0.b(Object.class));
        servicesRegistry.updateService(serviceKey, n.a(instance));
        return serviceKey;
    }

    public final /* synthetic */ <T> ServiceKey factory(String named, a<? extends T> instance) {
        t.i(named, "named");
        t.i(instance, "instance");
        t.o(4, "T");
        ServiceKey serviceKey = new ServiceKey(named, o0.b(Object.class));
        updateService(serviceKey, ServiceFactoryKt.factoryOf(instance));
        return serviceKey;
    }

    public final /* synthetic */ <T> T get(String named) {
        t.i(named, "named");
        t.o(4, "T");
        return (T) resolveService(new ServiceKey(named, o0.b(Object.class)));
    }

    public final /* synthetic */ <T> T getOrNull(String named) {
        t.i(named, "named");
        t.o(4, "T");
        return (T) resolveServiceOrNull(new ServiceKey(named, o0.b(Object.class)));
    }

    @Override // com.unity3d.services.core.di.IServicesRegistry
    public <T> T getService(@NotNull String named, @NotNull KClass<?> instance) {
        t.i(named, "named");
        t.i(instance, "instance");
        return (T) resolveService(new ServiceKey(named, instance));
    }

    @Override // com.unity3d.services.core.di.IServicesRegistry
    @NotNull
    public Map<ServiceKey, l<?>> getServices() {
        return this._services;
    }

    @Override // com.unity3d.services.core.di.IServicesRegistry
    public <T> T resolveService(@NotNull ServiceKey key) {
        t.i(key, "key");
        l<?> lVar = getServices().get(key);
        if (lVar != null) {
            return (T) lVar.getValue();
        }
        throw new IllegalStateException("No service instance found for " + key);
    }

    @Override // com.unity3d.services.core.di.IServicesRegistry
    @Nullable
    public <T> T resolveServiceOrNull(@NotNull ServiceKey key) {
        t.i(key, "key");
        l<?> lVar = getServices().get(key);
        if (lVar == null) {
            return null;
        }
        return (T) lVar.getValue();
    }

    public final /* synthetic */ <T> ServiceKey single(String named, a<? extends T> instance) {
        t.i(named, "named");
        t.i(instance, "instance");
        t.o(4, "T");
        ServiceKey serviceKey = new ServiceKey(named, o0.b(Object.class));
        updateService(serviceKey, n.a(instance));
        return serviceKey;
    }

    @Override // com.unity3d.services.core.di.IServicesRegistry
    public <T> void updateService(@NotNull ServiceKey key, @NotNull l<? extends T> instance) {
        t.i(key, "key");
        t.i(instance, "instance");
        if (!getServices().containsKey(key)) {
            this._services.put(key, instance);
            return;
        }
        throw new IllegalStateException(("Cannot have multiple identical services: " + key).toString());
    }
}
