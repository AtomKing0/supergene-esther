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
public final class fp extends s1 {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NotNull
    public static final a f12162z = new a(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    private final b1 f12163u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private final r1 f12164v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NotNull
    private final pp f12165w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NotNull
    private final String f12166x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NotNull
    private final String f12167y;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final fp a(@NotNull b1 adProperties, @Nullable ak akVar) {
            List<rm> listL;
            cr crVarD;
            kotlin.jvm.internal.t.i(adProperties, "adProperties");
            s1.a aVar = s1.f14755s;
            m8 m8VarC = (akVar == null || (crVarD = akVar.d()) == null) ? null : crVarD.c();
            pp ppVarF = m8VarC != null ? m8VarC.f() : null;
            if (ppVarF == null) {
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
            return new fp(adProperties, new r1(userIdForNetworks, arrayList, ljVarB), ppVarF);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public fp(@NotNull b1 adProperties, @NotNull r1 adUnitCommonData, @NotNull pp configs) {
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        kotlin.jvm.internal.t.i(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.t.i(configs, "configs");
        String strF = adUnitCommonData.f();
        List<NetworkSettings> listD = adUnitCommonData.d();
        lj ljVarE = adUnitCommonData.e();
        h5 h5VarK = configs.k();
        kotlin.jvm.internal.t.h(h5VarK, "configs.rewardedVideoAuctionSettings");
        super(adProperties, true, strF, listD, ljVarE, h5VarK, configs.g(), configs.h(), configs.j(), configs.b(), configs.c(), new g2(g2.a.MANUAL, configs.k().j(), configs.k().b(), -1L), configs.l(), configs.m(), configs.f(), configs.p(), configs.o(), false, 131072, null);
        this.f12163u = adProperties;
        this.f12164v = adUnitCommonData;
        this.f12165w = configs;
        this.f12166x = IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
        this.f12167y = bk.f11417b;
    }

    @NotNull
    public final r1 A() {
        return this.f12164v;
    }

    @NotNull
    public final pp B() {
        return this.f12165w;
    }

    @NotNull
    public final fp a(@NotNull b1 adProperties, @NotNull r1 adUnitCommonData, @NotNull pp configs) {
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        kotlin.jvm.internal.t.i(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.t.i(configs, "configs");
        return new fp(adProperties, adUnitCommonData, configs);
    }

    @Override // com.ironsource.s1
    @NotNull
    public b1 b() {
        return this.f12163u;
    }

    @Override // com.ironsource.s1
    @NotNull
    public String c() {
        return this.f12166x;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fp)) {
            return false;
        }
        fp fpVar = (fp) obj;
        return kotlin.jvm.internal.t.d(b(), fpVar.b()) && kotlin.jvm.internal.t.d(this.f12164v, fpVar.f12164v) && kotlin.jvm.internal.t.d(this.f12165w, fpVar.f12165w);
    }

    public int hashCode() {
        return (((b().hashCode() * 31) + this.f12164v.hashCode()) * 31) + this.f12165w.hashCode();
    }

    @Override // com.ironsource.s1
    @NotNull
    public String k() {
        return this.f12167y;
    }

    @NotNull
    public String toString() {
        return "RewardedAdUnitData(adProperties=" + b() + ", adUnitCommonData=" + this.f12164v + ", configs=" + this.f12165w + ')';
    }

    @NotNull
    public final b1 x() {
        return b();
    }

    @NotNull
    public final r1 y() {
        return this.f12164v;
    }

    @NotNull
    public final pp z() {
        return this.f12165w;
    }

    public static /* synthetic */ fp a(fp fpVar, b1 b1Var, r1 r1Var, pp ppVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            b1Var = fpVar.b();
        }
        if ((i10 & 2) != 0) {
            r1Var = fpVar.f12164v;
        }
        if ((i10 & 4) != 0) {
            ppVar = fpVar.f12165w;
        }
        return fpVar.a(b1Var, r1Var, ppVar);
    }

    @Override // com.ironsource.s1
    @NotNull
    public JSONObject b(@NotNull NetworkSettings providerSettings) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        JSONObject rewardedVideoSettings = providerSettings.getRewardedVideoSettings();
        kotlin.jvm.internal.t.h(rewardedVideoSettings, "providerSettings.rewardedVideoSettings");
        return rewardedVideoSettings;
    }
}
