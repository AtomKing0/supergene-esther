package com.ironsource;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class y4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f16253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private String f16256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private Map<String, ? extends Object> f16257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private com.ironsource.mediationsdk.h f16258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private Map<String, Object> f16259g;

    public y4(@NotNull String name, boolean z10) {
        kotlin.jvm.internal.t.i(name, "name");
        this.f16253a = name;
        this.f16254b = z10;
        this.f16256d = "";
        this.f16257e = kotlin.collections.r0.g();
        this.f16259g = new HashMap();
    }

    public static /* synthetic */ y4 a(y4 y4Var, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = y4Var.f16253a;
        }
        if ((i10 & 2) != 0) {
            z10 = y4Var.f16254b;
        }
        return y4Var.a(str, z10);
    }

    public final void b(@NotNull Map<String, ? extends Object> map) {
        kotlin.jvm.internal.t.i(map, "<set-?>");
        this.f16257e = map;
    }

    @NotNull
    public final Map<String, Object> c() {
        return this.f16259g;
    }

    @Nullable
    public final com.ironsource.mediationsdk.h d() {
        return this.f16258f;
    }

    public final boolean e() {
        return this.f16254b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y4)) {
            return false;
        }
        y4 y4Var = (y4) obj;
        return kotlin.jvm.internal.t.d(this.f16253a, y4Var.f16253a) && this.f16254b == y4Var.f16254b;
    }

    @NotNull
    public final Map<String, Object> f() {
        return this.f16257e;
    }

    @NotNull
    public final String g() {
        return this.f16253a;
    }

    @NotNull
    public final String h() {
        return this.f16256d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.f16253a.hashCode() * 31;
        boolean z10 = this.f16254b;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        return iHashCode + r12;
    }

    public final boolean i() {
        return this.f16255c;
    }

    @NotNull
    public String toString() {
        return "AuctionRequestInstanceInfo(name=" + this.f16253a + ", bidder=" + this.f16254b + ')';
    }

    @NotNull
    public final y4 a(@NotNull String name, boolean z10) {
        kotlin.jvm.internal.t.i(name, "name");
        return new y4(name, z10);
    }

    public final boolean b() {
        return this.f16254b;
    }

    @NotNull
    public final String a() {
        return this.f16253a;
    }

    public final void a(@Nullable com.ironsource.mediationsdk.h hVar) {
        this.f16258f = hVar;
    }

    public final void a(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f16256d = str;
    }

    public final void a(@NotNull Map<String, Object> map) {
        kotlin.jvm.internal.t.i(map, "<set-?>");
        this.f16259g = map;
    }

    public final void a(boolean z10) {
        this.f16255c = z10;
    }
}
