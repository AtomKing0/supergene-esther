package com.ironsource;

import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i0 f12521a = new i0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, Long> f12522b = new HashMap<>();

    private i0() {
    }

    @NotNull
    public final HashMap<String, Long> a() {
        return f12522b;
    }

    public final long b(@NotNull String instance) {
        kotlin.jvm.internal.t.i(instance, "instance");
        Long l10 = f12522b.get(instance);
        if (l10 != null) {
            return System.currentTimeMillis() - l10.longValue();
        }
        return -1L;
    }

    public final long c(@NotNull String instance) {
        kotlin.jvm.internal.t.i(instance, "instance");
        Long l10 = f12522b.get(instance);
        if (l10 != null) {
            return l10.longValue();
        }
        return -1L;
    }

    public final boolean a(@NotNull String instance) {
        kotlin.jvm.internal.t.i(instance, "instance");
        HashMap<String, Long> map = f12522b;
        if (map.get(instance) == null) {
            return false;
        }
        map.remove(instance);
        return true;
    }

    public final boolean a(@NotNull String instance, long j10) {
        kotlin.jvm.internal.t.i(instance, "instance");
        if (!(instance.length() == 0)) {
            HashMap<String, Long> map = f12522b;
            if (!map.containsKey(instance)) {
                map.put(instance, Long.valueOf(j10));
                return true;
            }
        }
        return false;
    }
}
