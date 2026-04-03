package com.ironsource;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f14628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f14629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private String f14631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private Map<String, ? extends Object> f14632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private com.ironsource.mediationsdk.h f14633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private Map<String, Object> f14634g;

    public r4(@NotNull String name, boolean z10) {
        kotlin.jvm.internal.t.i(name, "name");
        this.f14628a = name;
        this.f14629b = z10;
        this.f14631d = "";
        this.f14632e = kotlin.collections.r0.g();
        this.f14634g = new HashMap();
    }

    public static /* synthetic */ r4 a(r4 r4Var, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = r4Var.f14628a;
        }
        if ((i10 & 2) != 0) {
            z10 = r4Var.f14629b;
        }
        return r4Var.a(str, z10);
    }

    public final void b(@NotNull Map<String, ? extends Object> map) {
        kotlin.jvm.internal.t.i(map, "<set-?>");
        this.f14632e = map;
    }

    @NotNull
    public final Map<String, Object> c() {
        return this.f14634g;
    }

    @Nullable
    public final com.ironsource.mediationsdk.h d() {
        return this.f14633f;
    }

    public final boolean e() {
        return this.f14629b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r4)) {
            return false;
        }
        r4 r4Var = (r4) obj;
        return kotlin.jvm.internal.t.d(this.f14628a, r4Var.f14628a) && this.f14629b == r4Var.f14629b;
    }

    @NotNull
    public final Map<String, Object> f() {
        return this.f14632e;
    }

    @NotNull
    public final String g() {
        return this.f14628a;
    }

    @NotNull
    public final String h() {
        return this.f14631d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.f14628a.hashCode() * 31;
        boolean z10 = this.f14629b;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        return iHashCode + r12;
    }

    public final boolean i() {
        return this.f14630c;
    }

    @NotNull
    public String toString() {
        return "AuctionInstanceInfo(name=" + this.f14628a + ", bidder=" + this.f14629b + ')';
    }

    @NotNull
    public final r4 a(@NotNull String name, boolean z10) {
        kotlin.jvm.internal.t.i(name, "name");
        return new r4(name, z10);
    }

    public final boolean b() {
        return this.f14629b;
    }

    @NotNull
    public final String a() {
        return this.f14628a;
    }

    public final void a(@Nullable com.ironsource.mediationsdk.h hVar) {
        this.f14633f = hVar;
    }

    public final void a(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f14631d = str;
    }

    public final void a(@NotNull Map<String, Object> map) {
        kotlin.jvm.internal.t.i(map, "<set-?>");
        this.f14634g = map;
    }

    public final void a(boolean z10) {
        this.f14630c = z10;
    }
}
