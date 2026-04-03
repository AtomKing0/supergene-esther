package com.ironsource;

import com.ironsource.environment.ContextProvider;
import com.ironsource.g2;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.s1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f6 extends s1 {

    @NotNull
    public static final a A = new a(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    private final c6 f12073u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f12074v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NotNull
    private final r1 f12075w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NotNull
    private final n6 f12076x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NotNull
    private final String f12077y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NotNull
    private final String f12078z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final f6 a(@NotNull c6 adProperties, @Nullable ak akVar, boolean z10) {
            List<rm> listL;
            cr crVarD;
            kotlin.jvm.internal.t.i(adProperties, "adProperties");
            s1.a aVar = s1.f14755s;
            m8 m8VarC = (akVar == null || (crVarD = akVar.d()) == null) ? null : crVarD.c();
            n6 n6VarC = m8VarC != null ? m8VarC.c() : null;
            if (n6VarC == null) {
                throw new IllegalStateException("Error getting " + adProperties.a() + " configurations");
            }
            if (akVar == null || (listL = akVar.b(adProperties.c(), adProperties.b())) == null) {
                listL = kotlin.collections.v.l();
            }
            String userIdForNetworks = IronSourceUtils.getUserIdForNetworks();
            ArrayList arrayList = new ArrayList(kotlin.collections.w.v(listL, 10));
            Iterator<T> it = listL.iterator();
            while (it.hasNext()) {
                arrayList.add(((rm) it.next()).f());
            }
            lj ljVarB = lj.b();
            kotlin.jvm.internal.t.h(ljVarB, "getInstance()");
            return new f6(adProperties, z10, new r1(userIdForNetworks, arrayList, ljVarB), n6VarC);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f6(@NotNull c6 adProperties, boolean z10, @NotNull r1 adUnitCommonData, @NotNull n6 configs) {
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        kotlin.jvm.internal.t.i(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.t.i(configs, "configs");
        String strF = adUnitCommonData.f();
        List<NetworkSettings> listD = adUnitCommonData.d();
        lj ljVarE = adUnitCommonData.e();
        h5 h5VarD = configs.d();
        kotlin.jvm.internal.t.h(h5VarD, "configs.bannerAuctionSettings");
        super(adProperties, z10, strF, listD, ljVarE, h5VarD, configs.a(), (int) (configs.b() / ((long) 1000)), configs.c(), configs.g(), -1, new g2(g2.a.MANUAL_WITH_AUTOMATIC_RELOAD, configs.d().j(), configs.d().b(), 1000 * ((long) configs.i())), configs.e(), configs.f(), configs.m(), configs.o(), configs.n(), false, 131072, null);
        this.f12073u = adProperties;
        this.f12074v = z10;
        this.f12075w = adUnitCommonData;
        this.f12076x = configs;
        this.f12077y = "BN";
        this.f12078z = bk.f11419d;
    }

    @NotNull
    public final n6 A() {
        return this.f12076x;
    }

    @Override // com.ironsource.s1
    @NotNull
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public c6 b() {
        return this.f12073u;
    }

    @NotNull
    public final r1 C() {
        return this.f12075w;
    }

    @NotNull
    public final n6 D() {
        return this.f12076x;
    }

    @NotNull
    public final f6 a(@NotNull c6 adProperties, boolean z10, @NotNull r1 adUnitCommonData, @NotNull n6 configs) {
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        kotlin.jvm.internal.t.i(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.t.i(configs, "configs");
        return new f6(adProperties, z10, adUnitCommonData, configs);
    }

    @Override // com.ironsource.s1
    @NotNull
    public String c() {
        return this.f12077y;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f6)) {
            return false;
        }
        f6 f6Var = (f6) obj;
        return kotlin.jvm.internal.t.d(b(), f6Var.b()) && v() == f6Var.v() && kotlin.jvm.internal.t.d(this.f12075w, f6Var.f12075w) && kotlin.jvm.internal.t.d(this.f12076x, f6Var.f12076x);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = b().hashCode() * 31;
        boolean zV = v();
        ?? r12 = zV;
        if (zV) {
            r12 = 1;
        }
        return ((((iHashCode + r12) * 31) + this.f12075w.hashCode()) * 31) + this.f12076x.hashCode();
    }

    @Override // com.ironsource.s1
    @NotNull
    public String k() {
        return this.f12078z;
    }

    @NotNull
    public String toString() {
        return "BannerAdUnitData(adProperties=" + b() + ", isPublisherLoad=" + v() + ", adUnitCommonData=" + this.f12075w + ", configs=" + this.f12076x + ')';
    }

    @Override // com.ironsource.s1
    public boolean v() {
        return this.f12074v;
    }

    @NotNull
    public final c6 x() {
        return b();
    }

    public final boolean y() {
        return v();
    }

    @NotNull
    public final r1 z() {
        return this.f12075w;
    }

    public static /* synthetic */ f6 a(f6 f6Var, c6 c6Var, boolean z10, r1 r1Var, n6 n6Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            c6Var = f6Var.b();
        }
        if ((i10 & 2) != 0) {
            z10 = f6Var.v();
        }
        if ((i10 & 4) != 0) {
            r1Var = f6Var.f12075w;
        }
        if ((i10 & 8) != 0) {
            n6Var = f6Var.f12076x;
        }
        return f6Var.a(c6Var, z10, r1Var, n6Var);
    }

    @Override // com.ironsource.s1
    @NotNull
    public JSONObject b(@NotNull NetworkSettings providerSettings) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        JSONObject bannerSettings = providerSettings.getBannerSettings();
        kotlin.jvm.internal.t.h(bannerSettings, "providerSettings.bannerSettings");
        return bannerSettings;
    }

    @Override // com.ironsource.s1
    @NotNull
    public AdData a(@NotNull NetworkSettings providerSettings) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        AdData adDataCreateAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(b(providerSettings), b().a(), s(), new IronSourceBannerLayout(ContextProvider.getInstance().getCurrentActiveActivity(), new h1().b(b().g())));
        kotlin.jvm.internal.t.h(adDataCreateAdDataForNetworkAdapter, "createAdDataForNetworkAd…ze(adProperties.adSize)))");
        return adDataCreateAdDataForNetworkAdapter;
    }
}
