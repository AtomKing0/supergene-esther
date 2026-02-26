package com.unity3d.ads.injection;

import h9.a;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import s9.o0;
import s9.y;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: Registry.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Registry {

    @NotNull
    private final y<Map<EntryKey, l<?>>> _services = o0.a(r0.g());

    public static /* synthetic */ EntryKey factory$default(Registry registry, String named, a instance, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            named = "";
        }
        t.i(named, "named");
        t.i(instance, "instance");
        t.o(4, "T");
        EntryKey entryKey = new EntryKey(named, kotlin.jvm.internal.o0.b(Object.class));
        registry.add(entryKey, new Factory(instance));
        return entryKey;
    }

    public static /* synthetic */ Object get$default(Registry registry, String named, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            named = "";
        }
        t.i(named, "named");
        t.o(4, "T");
        EntryKey entryKey = new EntryKey(named, kotlin.jvm.internal.o0.b(Object.class));
        l<?> lVar = registry.getServices().get(entryKey);
        if (lVar != null) {
            Object value = lVar.getValue();
            t.o(1, "T");
            return value;
        }
        throw new IllegalStateException("No entry found for " + entryKey);
    }

    public static /* synthetic */ Object getOrNull$default(Registry registry, String named, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            named = "";
        }
        t.i(named, "named");
        t.o(4, "T");
        l<?> lVar = registry.getServices().get(new EntryKey(named, kotlin.jvm.internal.o0.b(Object.class)));
        if (lVar == null) {
            return null;
        }
        Object value = lVar.getValue();
        t.o(1, "T");
        return value;
    }

    public static /* synthetic */ EntryKey single$default(Registry registry, String named, a instance, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            named = "";
        }
        t.i(named, "named");
        t.i(instance, "instance");
        t.o(4, "T");
        EntryKey entryKey = new EntryKey(named, kotlin.jvm.internal.o0.b(Object.class));
        registry.add(entryKey, n.a(instance));
        return entryKey;
    }

    public final <T> void add(@NotNull EntryKey key, @NotNull l<? extends T> instance) {
        Map<EntryKey, l<?>> value;
        t.i(key, "key");
        t.i(instance, "instance");
        if (!(!getServices().containsKey(key))) {
            throw new IllegalStateException("Cannot have identical entries.".toString());
        }
        y<Map<EntryKey, l<?>>> yVar = this._services;
        do {
            value = yVar.getValue();
        } while (!yVar.d(value, r0.n(value, q0.e(v8.y.a(key, instance)))));
    }

    public final /* synthetic */ <T> EntryKey factory(String named, a<? extends T> instance) {
        t.i(named, "named");
        t.i(instance, "instance");
        t.o(4, "T");
        EntryKey entryKey = new EntryKey(named, kotlin.jvm.internal.o0.b(Object.class));
        add(entryKey, new Factory(instance));
        return entryKey;
    }

    public final /* synthetic */ <T> T get(String named) {
        t.i(named, "named");
        t.o(4, "T");
        EntryKey entryKey = new EntryKey(named, kotlin.jvm.internal.o0.b(Object.class));
        l<?> lVar = getServices().get(entryKey);
        if (lVar != null) {
            T t10 = (T) lVar.getValue();
            t.o(1, "T");
            return t10;
        }
        throw new IllegalStateException("No entry found for " + entryKey);
    }

    public final /* synthetic */ <T> T getOrNull(String named) {
        t.i(named, "named");
        t.o(4, "T");
        l<?> lVar = getServices().get(new EntryKey(named, kotlin.jvm.internal.o0.b(Object.class)));
        if (lVar == null) {
            return null;
        }
        T t10 = (T) lVar.getValue();
        t.o(1, "T");
        return t10;
    }

    @NotNull
    public final Map<EntryKey, l<?>> getServices() {
        return this._services.getValue();
    }

    public final /* synthetic */ <T> EntryKey single(String named, a<? extends T> instance) {
        t.i(named, "named");
        t.i(instance, "instance");
        t.o(4, "T");
        EntryKey entryKey = new EntryKey(named, kotlin.jvm.internal.o0.b(Object.class));
        add(entryKey, n.a(instance));
        return entryKey;
    }
}
