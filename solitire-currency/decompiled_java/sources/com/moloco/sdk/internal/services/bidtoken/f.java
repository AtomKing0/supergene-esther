package com.moloco.sdk.internal.services.bidtoken;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f18444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final l f18445b;

    static {
        g gVar = new g(false);
        f18444a = gVar;
        f18445b = new l("", "", gVar);
    }

    @NotNull
    public static final g a() {
        return f18444a;
    }

    @NotNull
    public static final g b(@NotNull com.moloco.sdk.c cVar) {
        kotlin.jvm.internal.t.i(cVar, "<this>");
        return cVar.e() ? new g(cVar.c().c()) : f18444a;
    }

    @NotNull
    public static final l c() {
        return f18445b;
    }
}
