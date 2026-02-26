package com.ironsource;

import com.ironsource.g2;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.s1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class di extends s1 {

    @NotNull
    public static final a A = new a(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    private final b1 f11833u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f11834v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NotNull
    private final r1 f11835w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NotNull
    private final hi f11836x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NotNull
    private final String f11837y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NotNull
    private final String f11838z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final di a(@NotNull b1 adProperties, @Nullable ak akVar, boolean z10) {
            List<rm> listL;
            cr crVarD;
            kotlin.jvm.internal.t.i(adProperties, "adProperties");
            s1.a aVar = s1.f14755s;
            m8 m8VarC = (akVar == null || (crVarD = akVar.d()) == null) ? null : crVarD.c();
            hi hiVarD = m8VarC != null ? m8VarC.d() : null;
            if (hiVarD == null) {
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
            return new di(adProperties, z10, new r1(userIdForNetworks, arrayList, ljVarB), hiVarD);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public di(@NotNull b1 adProperties, boolean z10, @NotNull r1 adUnitCommonData, @NotNull hi configs) {
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        kotlin.jvm.internal.t.i(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.t.i(configs, "configs");
        String strF = adUnitCommonData.f();
        List<NetworkSettings> listD = adUnitCommonData.d();
        lj ljVarE = adUnitCommonData.e();
        h5 h5VarG = configs.g();
        kotlin.jvm.internal.t.h(h5VarG, "configs.interstitialAuctionSettings");
        super(adProperties, z10, strF, listD, ljVarE, h5VarG, configs.c(), configs.d(), configs.f(), configs.b(), -1, new g2(g2.a.MANUAL, configs.g().j(), configs.g().b(), -1L), configs.h(), configs.i(), configs.l(), configs.n(), configs.m(), false, 131072, null);
        this.f11833u = adProperties;
        this.f11834v = z10;
        this.f11835w = adUnitCommonData;
        this.f11836x = configs;
        this.f11837y = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
        this.f11838z = bk.f11418c;
    }

    @NotNull
    public final hi A() {
        return this.f11836x;
    }

    @NotNull
    public final r1 B() {
        return this.f11835w;
    }

    @NotNull
    public final hi C() {
        return this.f11836x;
    }

    @NotNull
    public final di a(@NotNull b1 adProperties, boolean z10, @NotNull r1 adUnitCommonData, @NotNull hi configs) {
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        kotlin.jvm.internal.t.i(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.t.i(configs, "configs");
        return new di(adProperties, z10, adUnitCommonData, configs);
    }

    @Override // com.ironsource.s1
    @NotNull
    public b1 b() {
        return this.f11833u;
    }

    @Override // com.ironsource.s1
    @NotNull
    public String c() {
        return this.f11837y;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof di)) {
            return false;
        }
        di diVar = (di) obj;
        return kotlin.jvm.internal.t.d(b(), diVar.b()) && v() == diVar.v() && kotlin.jvm.internal.t.d(this.f11835w, diVar.f11835w) && kotlin.jvm.internal.t.d(this.f11836x, diVar.f11836x);
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
        return ((((iHashCode + r12) * 31) + this.f11835w.hashCode()) * 31) + this.f11836x.hashCode();
    }

    @Override // com.ironsource.s1
    @NotNull
    public String k() {
        return this.f11838z;
    }

    @NotNull
    public String toString() {
        return "InterstitialAdUnitData(adProperties=" + b() + ", isPublisherLoad=" + v() + ", adUnitCommonData=" + this.f11835w + ", configs=" + this.f11836x + ')';
    }

    @Override // com.ironsource.s1
    public boolean v() {
        return this.f11834v;
    }

    @NotNull
    public final b1 x() {
        return b();
    }

    public final boolean y() {
        return v();
    }

    @NotNull
    public final r1 z() {
        return this.f11835w;
    }

    public static /* synthetic */ di a(di diVar, b1 b1Var, boolean z10, r1 r1Var, hi hiVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            b1Var = diVar.b();
        }
        if ((i10 & 2) != 0) {
            z10 = diVar.v();
        }
        if ((i10 & 4) != 0) {
            r1Var = diVar.f11835w;
        }
        if ((i10 & 8) != 0) {
            hiVar = diVar.f11836x;
        }
        return diVar.a(b1Var, z10, r1Var, hiVar);
    }

    @Override // com.ironsource.s1
    @NotNull
    public JSONObject b(@NotNull NetworkSettings providerSettings) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        JSONObject interstitialSettings = providerSettings.getInterstitialSettings();
        kotlin.jvm.internal.t.h(interstitialSettings, "providerSettings.interstitialSettings");
        return interstitialSettings;
    }
}
