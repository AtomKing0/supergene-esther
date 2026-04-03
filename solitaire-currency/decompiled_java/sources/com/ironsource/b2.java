package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11336a;

    public b2(long j10) {
        this.f11336a = j10;
    }

    public final long a() {
        return this.f11336a;
    }

    public final long b() {
        return this.f11336a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b2) && this.f11336a == ((b2) obj).f11336a;
    }

    public int hashCode() {
        return androidx.compose.animation.a.a(this.f11336a);
    }

    @NotNull
    public String toString() {
        return "AdUnitInteractionData(impressionTimeout=" + this.f11336a + ')';
    }

    @NotNull
    public final b2 a(long j10) {
        return new b2(j10);
    }

    public static /* synthetic */ b2 a(b2 b2Var, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = b2Var.f11336a;
        }
        return b2Var.a(j10);
    }
}
