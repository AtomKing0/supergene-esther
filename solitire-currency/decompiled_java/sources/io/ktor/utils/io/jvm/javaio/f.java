package io.ktor.utils.io.jvm.javaio;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Pollers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ThreadLocal<e<Thread>> f26906a = new ThreadLocal<>();

    @NotNull
    public static final e<Thread> a() {
        e<Thread> eVar = f26906a.get();
        return eVar == null ? c.f26895a : eVar;
    }

    public static final boolean b() {
        return a() != g.f26907a;
    }
}
