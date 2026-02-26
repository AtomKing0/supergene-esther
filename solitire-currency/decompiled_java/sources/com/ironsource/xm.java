package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class xm extends lu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final p2 f16195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final s1 f16196f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xm(@NotNull p2 tools, @NotNull s1 adUnitData) {
        super(tools, adUnitData);
        kotlin.jvm.internal.t.i(tools, "tools");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        this.f16195e = tools;
        this.f16196f = adUnitData;
    }

    private final c5 b() {
        return new c5("", new JSONObject(), null, 0, "");
    }

    private final String c() {
        return "fallback_" + System.currentTimeMillis();
    }

    private final List<f5> d() {
        ts tsVarF = this.f16196f.b().f();
        List<NetworkSettings> listN = this.f16196f.n();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN) {
            NetworkSettings networkSettings = (NetworkSettings) obj;
            if ((tsVarF == null || tsVarF.a(networkSettings, this.f16196f.b().a())) && !networkSettings.isBidder(this.f16196f.b().a())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new f5(((NetworkSettings) it.next()).getProviderInstanceName()));
        }
        return arrayList2;
    }

    @Override // com.ironsource.lu
    public void a(@NotNull a0 adInstanceFactory, @NotNull mu waterfallFetcherListener) {
        kotlin.jvm.internal.t.i(adInstanceFactory, "adInstanceFactory");
        kotlin.jvm.internal.t.i(waterfallFetcherListener, "waterfallFetcherListener");
        IronLog.INTERNAL.verbose(k1.a(this.f16195e, "auction disabled", (String) null, 2, (Object) null));
        a(waterfallFetcherListener, b(), adInstanceFactory);
    }

    public final void a(@NotNull mu waterfallFetcherListener, int i10, @NotNull String auctionFallback, @NotNull a0 adInstanceFactory) {
        kotlin.jvm.internal.t.i(waterfallFetcherListener, "waterfallFetcherListener");
        kotlin.jvm.internal.t.i(auctionFallback, "auctionFallback");
        kotlin.jvm.internal.t.i(adInstanceFactory, "adInstanceFactory");
        a(waterfallFetcherListener, new c5(c(), new JSONObject(), null, i10, auctionFallback), adInstanceFactory);
    }

    private final void a(mu muVar, c5 c5Var, a0 a0Var) {
        IronLog.INTERNAL.verbose(k1.a(this.f16195e, (String) null, (String) null, 3, (Object) null));
        muVar.a(a(d(), c5Var, a0Var));
    }
}
