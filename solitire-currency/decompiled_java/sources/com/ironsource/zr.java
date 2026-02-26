package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class zr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final g8 f16491b;

    public zr(int i10, @NotNull g8 unit) {
        kotlin.jvm.internal.t.i(unit, "unit");
        this.f16490a = i10;
        this.f16491b = unit;
    }

    public final int a() {
        return this.f16490a;
    }

    @NotNull
    public final g8 b() {
        return this.f16491b;
    }

    @NotNull
    public String toString() {
        return "ShowCountCappingConfig(maxImpressions=" + this.f16490a + ", unit=" + this.f16491b + ')';
    }
}
