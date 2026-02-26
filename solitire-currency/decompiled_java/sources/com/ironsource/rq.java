package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class rq {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private static Boolean f14724b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final rq f14723a = new rq();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static qq f14725c = qq.NOT_INIT;

    private rq() {
    }

    @NotNull
    public final synchronized qq a() {
        return f14725c;
    }

    @NotNull
    public final qq b() {
        Boolean bool = f14724b;
        if (bool == null ? true : kotlin.jvm.internal.t.d(bool, Boolean.FALSE)) {
            return qq.NOT_INIT;
        }
        if (kotlin.jvm.internal.t.d(bool, Boolean.TRUE)) {
            return f14725c;
        }
        throw new v8.q();
    }

    public final synchronized void a(@NotNull qq qqVar) {
        kotlin.jvm.internal.t.i(qqVar, "<set-?>");
        f14725c = qqVar;
    }

    public final void a(boolean z10) {
        f14724b = Boolean.valueOf(z10);
    }
}
