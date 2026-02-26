package com.ironsource;

import com.ironsource.m1;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final s1 f16214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final NetworkSettings f16215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final c5 f16216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final v2 f16217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final f5 f16218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final e0 f16220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final IronSource.AD_UNIT f16221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final JSONObject f16222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final String f16223j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f16224k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final String f16225l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private final f5 f16226m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private final String f16227n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private final String f16228o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f16229p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    private final AdData f16230q;

    public y(@NotNull s1 adUnitData, @NotNull NetworkSettings providerSettings, @NotNull c5 auctionData, @NotNull v2 adapterConfig, @NotNull f5 auctionResponseItem, int i10) {
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        kotlin.jvm.internal.t.i(auctionData, "auctionData");
        kotlin.jvm.internal.t.i(adapterConfig, "adapterConfig");
        kotlin.jvm.internal.t.i(auctionResponseItem, "auctionResponseItem");
        this.f16214a = adUnitData;
        this.f16215b = providerSettings;
        this.f16216c = auctionData;
        this.f16217d = adapterConfig;
        this.f16218e = auctionResponseItem;
        this.f16219f = i10;
        this.f16220g = new e0(m1.a.DidntAttemptToLoad);
        IronSource.AD_UNIT ad_unitA = adUnitData.b().a();
        this.f16221h = ad_unitA;
        this.f16222i = auctionData.h();
        this.f16223j = auctionData.g();
        this.f16224k = auctionData.i();
        this.f16225l = auctionData.f();
        this.f16226m = auctionData.j();
        String strF = adapterConfig.f();
        kotlin.jvm.internal.t.h(strF, "adapterConfig.providerName");
        this.f16227n = strF;
        kotlin.jvm.internal.s0 s0Var = kotlin.jvm.internal.s0.f29840a;
        String str = String.format("%s %s", Arrays.copyOf(new Object[]{strF, Integer.valueOf(hashCode())}, 2));
        kotlin.jvm.internal.t.h(str, "format(format, *args)");
        this.f16228o = str;
        this.f16229p = adapterConfig.d();
        String strJ = auctionResponseItem.j();
        Map<String, Object> mapA = hj.a(auctionResponseItem.a());
        kotlin.jvm.internal.t.h(mapA, "jsonObjectToMap(auctionResponseItem.adData)");
        mapA.put("adUnit", ad_unitA);
        HashMap map = new HashMap();
        Map<String, Object> mapA2 = hj.a(adapterConfig.c());
        kotlin.jvm.internal.t.h(mapA2, "jsonObjectToMap(adapterConfig.adUnitSettings)");
        map.putAll(mapA2);
        mapA.put("userId", adUnitData.s());
        mapA.put("adUnitId", adUnitData.b().b());
        mapA.put("isMultipleAdUnits", Boolean.TRUE);
        this.f16230q = new AdData(strJ, map, mapA);
    }

    @NotNull
    public final s1 a() {
        return this.f16214a;
    }

    @NotNull
    public final NetworkSettings b() {
        return this.f16215b;
    }

    @NotNull
    public final c5 c() {
        return this.f16216c;
    }

    @NotNull
    public final v2 d() {
        return this.f16217d;
    }

    @NotNull
    public final f5 e() {
        return this.f16218e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return kotlin.jvm.internal.t.d(this.f16214a, yVar.f16214a) && kotlin.jvm.internal.t.d(this.f16215b, yVar.f16215b) && kotlin.jvm.internal.t.d(this.f16216c, yVar.f16216c) && kotlin.jvm.internal.t.d(this.f16217d, yVar.f16217d) && kotlin.jvm.internal.t.d(this.f16218e, yVar.f16218e) && this.f16219f == yVar.f16219f;
    }

    public final int f() {
        return this.f16219f;
    }

    @NotNull
    public final AdData g() {
        return this.f16230q;
    }

    @NotNull
    public final IronSource.AD_UNIT h() {
        return this.f16221h;
    }

    public int hashCode() {
        return (((((((((this.f16214a.hashCode() * 31) + this.f16215b.hashCode()) * 31) + this.f16216c.hashCode()) * 31) + this.f16217d.hashCode()) * 31) + this.f16218e.hashCode()) * 31) + this.f16219f;
    }

    @NotNull
    public final s1 i() {
        return this.f16214a;
    }

    @NotNull
    public final v2 j() {
        return this.f16217d;
    }

    @NotNull
    public final c5 k() {
        return this.f16216c;
    }

    @NotNull
    public final String l() {
        return this.f16225l;
    }

    @NotNull
    public final String m() {
        return this.f16223j;
    }

    @NotNull
    public final f5 n() {
        return this.f16218e;
    }

    public final int o() {
        return this.f16224k;
    }

    @Nullable
    public final f5 p() {
        return this.f16226m;
    }

    @NotNull
    public final JSONObject q() {
        return this.f16222i;
    }

    @NotNull
    public final String r() {
        return this.f16227n;
    }

    public final int s() {
        return this.f16229p;
    }

    @NotNull
    public final e0 t() {
        return this.f16220g;
    }

    @NotNull
    public String toString() {
        return "AdInstanceData(adUnitData=" + this.f16214a + ", providerSettings=" + this.f16215b + ", auctionData=" + this.f16216c + ", adapterConfig=" + this.f16217d + ", auctionResponseItem=" + this.f16218e + ", sessionDepth=" + this.f16219f + ')';
    }

    @NotNull
    public final NetworkSettings u() {
        return this.f16215b;
    }

    public final int v() {
        return this.f16219f;
    }

    @NotNull
    public final String w() {
        return this.f16228o;
    }

    @NotNull
    public final y a(@NotNull s1 adUnitData, @NotNull NetworkSettings providerSettings, @NotNull c5 auctionData, @NotNull v2 adapterConfig, @NotNull f5 auctionResponseItem, int i10) {
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        kotlin.jvm.internal.t.i(auctionData, "auctionData");
        kotlin.jvm.internal.t.i(adapterConfig, "adapterConfig");
        kotlin.jvm.internal.t.i(auctionResponseItem, "auctionResponseItem");
        return new y(adUnitData, providerSettings, auctionData, adapterConfig, auctionResponseItem, i10);
    }

    public static /* synthetic */ y a(y yVar, s1 s1Var, NetworkSettings networkSettings, c5 c5Var, v2 v2Var, f5 f5Var, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            s1Var = yVar.f16214a;
        }
        if ((i11 & 2) != 0) {
            networkSettings = yVar.f16215b;
        }
        NetworkSettings networkSettings2 = networkSettings;
        if ((i11 & 4) != 0) {
            c5Var = yVar.f16216c;
        }
        c5 c5Var2 = c5Var;
        if ((i11 & 8) != 0) {
            v2Var = yVar.f16217d;
        }
        v2 v2Var2 = v2Var;
        if ((i11 & 16) != 0) {
            f5Var = yVar.f16218e;
        }
        f5 f5Var2 = f5Var;
        if ((i11 & 32) != 0) {
            i10 = yVar.f16219f;
        }
        return yVar.a(s1Var, networkSettings2, c5Var2, v2Var2, f5Var2, i10);
    }

    public final void a(@NotNull m1.a performance) {
        kotlin.jvm.internal.t.i(performance, "performance");
        this.f16220g.b(performance);
    }
}
