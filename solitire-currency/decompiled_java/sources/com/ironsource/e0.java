package com.ironsource;

import com.ironsource.m1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private m1.a f11881a;

    public e0(@NotNull m1.a performance) {
        kotlin.jvm.internal.t.i(performance, "performance");
        this.f11881a = performance;
    }

    public static /* synthetic */ e0 a(e0 e0Var, m1.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = e0Var.f11881a;
        }
        return e0Var.a(aVar);
    }

    @NotNull
    public final m1.a b() {
        return this.f11881a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e0) && this.f11881a == ((e0) obj).f11881a;
    }

    public int hashCode() {
        return this.f11881a.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdInstancePerformance(performance=" + this.f11881a + ')';
    }

    @NotNull
    public final e0 a(@NotNull m1.a performance) {
        kotlin.jvm.internal.t.i(performance, "performance");
        return new e0(performance);
    }

    public final void b(@NotNull m1.a aVar) {
        kotlin.jvm.internal.t.i(aVar, "<set-?>");
        this.f11881a = aVar;
    }

    @NotNull
    public final m1.a a() {
        return this.f11881a;
    }
}
