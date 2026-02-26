package com.ironsource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class nu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<x> f14180a;

    /* JADX WARN: Multi-variable type inference failed */
    public nu(@NotNull List<? extends x> instances) {
        kotlin.jvm.internal.t.i(instances, "instances");
        this.f14180a = instances;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ nu a(nu nuVar, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = nuVar.f14180a;
        }
        return nuVar.a(list);
    }

    @NotNull
    public final List<x> b() {
        return this.f14180a;
    }

    public final int c() {
        return this.f14180a.size();
    }

    @NotNull
    public final String d() {
        ArrayList arrayList = new ArrayList();
        for (x xVar : this.f14180a) {
            arrayList.add(a(xVar.g(), xVar.p()));
        }
        return kotlin.collections.d0.r0(arrayList, ",", null, null, 0, null, null, 62, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof nu) && kotlin.jvm.internal.t.d(this.f14180a, ((nu) obj).f14180a);
    }

    public int hashCode() {
        return this.f14180a.hashCode();
    }

    @NotNull
    public String toString() {
        return "WaterfallInstances(instances=" + this.f14180a + ')';
    }

    @NotNull
    public final nu a(@NotNull List<? extends x> instances) {
        kotlin.jvm.internal.t.i(instances, "instances");
        return new nu(instances);
    }

    private final String a(f5 f5Var, int i10) {
        kotlin.jvm.internal.s0 s0Var = kotlin.jvm.internal.s0.f29840a;
        String str = String.format("%s%s", Arrays.copyOf(new Object[]{Integer.valueOf(i10), f5Var.c()}, 2));
        kotlin.jvm.internal.t.h(str, "format(format, *args)");
        return str;
    }

    @NotNull
    public final List<x> a() {
        return this.f14180a;
    }
}
