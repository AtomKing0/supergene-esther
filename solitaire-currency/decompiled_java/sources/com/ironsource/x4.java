package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final s1 f16131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<String, Object> f16132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<String> f16133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final StringBuilder f16134d;

    public x4(@NotNull s1 adUnitData) {
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        this.f16131a = adUnitData;
        this.f16132b = new HashMap();
        this.f16133c = new ArrayList();
        this.f16134d = new StringBuilder();
    }

    @NotNull
    public final Map<String, Object> a() {
        return this.f16132b;
    }

    @NotNull
    public final List<String> b() {
        return this.f16133c;
    }

    @NotNull
    public final StringBuilder c() {
        return this.f16134d;
    }

    public final boolean d() {
        return (this.f16132b.isEmpty() ^ true) || (this.f16133c.isEmpty() ^ true);
    }

    public final void a(@NotNull NetworkSettings providerSettings) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        List<String> list = this.f16133c;
        String providerInstanceName = providerSettings.getProviderInstanceName();
        kotlin.jvm.internal.t.h(providerInstanceName, "providerSettings.providerInstanceName");
        list.add(providerInstanceName);
        StringBuilder sb = this.f16134d;
        sb.append(providerSettings.getInstanceType(this.f16131a.b().a()));
        sb.append(providerSettings.getProviderInstanceName());
        sb.append(",");
    }

    public final void a(@NotNull NetworkSettings providerSettings, @NotNull Map<String, ? extends Object> biddingData) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        kotlin.jvm.internal.t.i(biddingData, "biddingData");
        String providerInstanceName = providerSettings.getProviderInstanceName();
        kotlin.jvm.internal.t.h(providerInstanceName, "providerSettings.providerInstanceName");
        a(providerInstanceName, providerSettings.getInstanceType(this.f16131a.b().a()), biddingData);
    }

    public final void a(@NotNull u7 biddingResponse) {
        kotlin.jvm.internal.t.i(biddingResponse, "biddingResponse");
        String strC = biddingResponse.c();
        kotlin.jvm.internal.t.h(strC, "biddingResponse.instanceName");
        int iD = biddingResponse.d();
        Map<String, Object> mapA = biddingResponse.a();
        kotlin.jvm.internal.t.h(mapA, "biddingResponse.biddingData");
        a(strC, iD, mapA);
    }

    private final void a(String str, int i10, Map<String, ? extends Object> map) {
        this.f16132b.put(str, map);
        StringBuilder sb = this.f16134d;
        sb.append(i10);
        sb.append(str);
        sb.append(",");
    }
}
