package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class wt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final k9 f16051a;

    public wt(@NotNull k9 currentTimeProvider) {
        kotlin.jvm.internal.t.i(currentTimeProvider, "currentTimeProvider");
        this.f16051a = currentTimeProvider;
    }

    public final boolean a(long j10, long j11) {
        long jA = this.f16051a.a();
        return j11 <= 0 || j10 <= 0 || jA < j10 || jA - j10 > j11;
    }
}
