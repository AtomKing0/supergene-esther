package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f11525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final JSONObject f11526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final f5 f11527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f11528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f11529e;

    public c5(@NotNull String auctionId, @NotNull JSONObject auctionResponseGenericParam, @Nullable f5 f5Var, int i10, @NotNull String auctionFallback) {
        kotlin.jvm.internal.t.i(auctionId, "auctionId");
        kotlin.jvm.internal.t.i(auctionResponseGenericParam, "auctionResponseGenericParam");
        kotlin.jvm.internal.t.i(auctionFallback, "auctionFallback");
        this.f11525a = auctionId;
        this.f11526b = auctionResponseGenericParam;
        this.f11527c = f5Var;
        this.f11528d = i10;
        this.f11529e = auctionFallback;
    }

    public static /* synthetic */ c5 a(c5 c5Var, String str, JSONObject jSONObject, f5 f5Var, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = c5Var.f11525a;
        }
        if ((i11 & 2) != 0) {
            jSONObject = c5Var.f11526b;
        }
        JSONObject jSONObject2 = jSONObject;
        if ((i11 & 4) != 0) {
            f5Var = c5Var.f11527c;
        }
        f5 f5Var2 = f5Var;
        if ((i11 & 8) != 0) {
            i10 = c5Var.f11528d;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            str2 = c5Var.f11529e;
        }
        return c5Var.a(str, jSONObject2, f5Var2, i12, str2);
    }

    @NotNull
    public final JSONObject b() {
        return this.f11526b;
    }

    @Nullable
    public final f5 c() {
        return this.f11527c;
    }

    public final int d() {
        return this.f11528d;
    }

    @NotNull
    public final String e() {
        return this.f11529e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c5)) {
            return false;
        }
        c5 c5Var = (c5) obj;
        return kotlin.jvm.internal.t.d(this.f11525a, c5Var.f11525a) && kotlin.jvm.internal.t.d(this.f11526b, c5Var.f11526b) && kotlin.jvm.internal.t.d(this.f11527c, c5Var.f11527c) && this.f11528d == c5Var.f11528d && kotlin.jvm.internal.t.d(this.f11529e, c5Var.f11529e);
    }

    @NotNull
    public final String f() {
        return this.f11529e;
    }

    @NotNull
    public final String g() {
        return this.f11525a;
    }

    @NotNull
    public final JSONObject h() {
        return this.f11526b;
    }

    public int hashCode() {
        int iHashCode = ((this.f11525a.hashCode() * 31) + this.f11526b.hashCode()) * 31;
        f5 f5Var = this.f11527c;
        return ((((iHashCode + (f5Var == null ? 0 : f5Var.hashCode())) * 31) + this.f11528d) * 31) + this.f11529e.hashCode();
    }

    public final int i() {
        return this.f11528d;
    }

    @Nullable
    public final f5 j() {
        return this.f11527c;
    }

    @NotNull
    public String toString() {
        return "AuctionResponseData(auctionId=" + this.f11525a + ", auctionResponseGenericParam=" + this.f11526b + ", genericNotifications=" + this.f11527c + ", auctionTrial=" + this.f11528d + ", auctionFallback=" + this.f11529e + ')';
    }

    @NotNull
    public final c5 a(@NotNull String auctionId, @NotNull JSONObject auctionResponseGenericParam, @Nullable f5 f5Var, int i10, @NotNull String auctionFallback) {
        kotlin.jvm.internal.t.i(auctionId, "auctionId");
        kotlin.jvm.internal.t.i(auctionResponseGenericParam, "auctionResponseGenericParam");
        kotlin.jvm.internal.t.i(auctionFallback, "auctionFallback");
        return new c5(auctionId, auctionResponseGenericParam, f5Var, i10, auctionFallback);
    }

    @NotNull
    public final String a() {
        return this.f11525a;
    }
}
