package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class lu {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13085d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p2 f13086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final s1 f13087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final on f13088c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final lu a(@NotNull p2 adTools, @NotNull s1 adUnitData) {
            kotlin.jvm.internal.t.i(adTools, "adTools");
            kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
            return adUnitData.u() ? new i5(adTools, adUnitData) : new xm(adTools, adUnitData);
        }
    }

    public static final class b implements on {
        b() {
        }

        @Override // com.ironsource.on
        public /* synthetic */ void a(x xVar, String str, lj ljVar) {
            bz.a(this, xVar, str, ljVar);
        }

        @Override // com.ironsource.on
        public /* synthetic */ void a(List list, x xVar) {
            bz.b(this, list, xVar);
        }
    }

    public lu(@NotNull p2 adTools, @NotNull s1 adUnitData) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        this.f13086a = adTools;
        this.f13087b = adUnitData;
        this.f13088c = new b();
    }

    @NotNull
    public final nu a(@NotNull List<? extends f5> waterfallItems, @NotNull c5 auctionData, @NotNull a0 adInstanceFactory) {
        kotlin.jvm.internal.t.i(waterfallItems, "waterfallItems");
        kotlin.jvm.internal.t.i(auctionData, "auctionData");
        kotlin.jvm.internal.t.i(adInstanceFactory, "adInstanceFactory");
        IronLog.INTERNAL.verbose(k1.a(this.f13086a, "waterfall.size() = " + waterfallItems.size(), (String) null, 2, (Object) null));
        ArrayList arrayList = new ArrayList();
        int size = waterfallItems.size();
        for (int i10 = 0; i10 < size; i10++) {
            x xVarA = a(waterfallItems.get(i10), auctionData, adInstanceFactory);
            if (xVarA != null && xVarA.f() != null) {
                arrayList.add(xVarA);
            }
        }
        nu nuVar = new nu(arrayList);
        IronLog.INTERNAL.verbose(k1.a(this.f13086a, "updateWaterfall() - next waterfall is " + nuVar + ".toWaterfallString()", (String) null, 2, (Object) null));
        return nuVar;
    }

    public abstract void a(@NotNull a0 a0Var, @NotNull mu muVar);

    @NotNull
    public on a() {
        return this.f13088c;
    }

    private final x a(f5 f5Var, c5 c5Var, a0 a0Var) {
        s1 s1Var = this.f13087b;
        String strC = f5Var.c();
        kotlin.jvm.internal.t.h(strC, "item.instanceName");
        NetworkSettings networkSettingsA = s1Var.a(strC);
        if (networkSettingsA != null) {
            com.ironsource.mediationsdk.c.b().b(networkSettingsA, this.f13087b.b().a(), this.f13087b.b().d().b());
            int iG = this.f13086a.g();
            s1 s1Var2 = this.f13087b;
            return a0Var.a(new y(s1Var2, networkSettingsA, c5Var, new v2(networkSettingsA, s1Var2.b(networkSettingsA), this.f13087b.b().a()), f5Var, iG));
        }
        String str = "could not find matching provider settings for auction response item - item = " + f5Var.c();
        IronLog.INTERNAL.error(k1.a(this.f13086a, str, (String) null, 2, (Object) null));
        this.f13086a.e().g().g(str);
        return null;
    }
}
