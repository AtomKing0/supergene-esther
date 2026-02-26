package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f14370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final g8 f14371b;

    public pn(long j10, @NotNull g8 unit) {
        kotlin.jvm.internal.t.i(unit, "unit");
        this.f14370a = j10;
        this.f14371b = unit;
    }

    public final long a() {
        return this.f14370a;
    }

    @NotNull
    public final g8 b() {
        return this.f14371b;
    }

    @NotNull
    public String toString() {
        return "PacingCappingConfig(timeInterval=" + this.f14370a + " unit=" + this.f14371b + ')';
    }

    public /* synthetic */ pn(long j10, g8 g8Var, int i10, kotlin.jvm.internal.k kVar) {
        this(j10, (i10 & 2) != 0 ? g8.Second : g8Var);
    }
}
