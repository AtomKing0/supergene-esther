package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ip extends q0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private final String f12648t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private final List<NetworkSettings> f12649u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private final pp f12650v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final boolean f12651w;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public ip(@Nullable String str, @Nullable List<? extends NetworkSettings> list, @NotNull pp configs, boolean z10) {
        kotlin.jvm.internal.t.i(configs, "configs");
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        h5 h5VarK = configs.k();
        kotlin.jvm.internal.t.h(h5VarK, "configs.rewardedVideoAuctionSettings");
        super(ad_unit, str, list, h5VarK, configs.g(), configs.h(), configs.j(), configs.b(), configs.c(), jp.b(configs, z10), new b2(-1L), configs.l(), configs.m(), configs.f(), configs.p(), configs.o(), false, 65536, null);
        this.f12648t = str;
        this.f12649u = list;
        this.f12650v = configs;
        this.f12651w = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ip a(ip ipVar, String str, List list, pp ppVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = ipVar.p();
        }
        if ((i10 & 2) != 0) {
            list = ipVar.k();
        }
        if ((i10 & 4) != 0) {
            ppVar = ipVar.f12650v;
        }
        if ((i10 & 8) != 0) {
            z10 = ipVar.f12651w;
        }
        return ipVar.a(str, list, ppVar, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ip)) {
            return false;
        }
        ip ipVar = (ip) obj;
        return kotlin.jvm.internal.t.d(p(), ipVar.p()) && kotlin.jvm.internal.t.d(k(), ipVar.k()) && kotlin.jvm.internal.t.d(this.f12650v, ipVar.f12650v) && this.f12651w == ipVar.f12651w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = (((((p() == null ? 0 : p().hashCode()) * 31) + (k() != null ? k().hashCode() : 0)) * 31) + this.f12650v.hashCode()) * 31;
        boolean z10 = this.f12651w;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        return iHashCode + r12;
    }

    @Override // com.ironsource.q0
    @Nullable
    public List<NetworkSettings> k() {
        return this.f12649u;
    }

    @Override // com.ironsource.q0
    @Nullable
    public String p() {
        return this.f12648t;
    }

    @Nullable
    public final String t() {
        return p();
    }

    @NotNull
    public String toString() {
        return "RewardedVideoAdDataManager(userId=" + p() + ", providerList=" + k() + ", configs=" + this.f12650v + ", isManual=" + this.f12651w + ')';
    }

    @Nullable
    public final List<NetworkSettings> u() {
        return k();
    }

    @NotNull
    public final pp v() {
        return this.f12650v;
    }

    public final boolean w() {
        return this.f12651w;
    }

    @NotNull
    public final pp x() {
        return this.f12650v;
    }

    public final boolean y() {
        return this.f12651w;
    }

    @NotNull
    public final ip a(@Nullable String str, @Nullable List<? extends NetworkSettings> list, @NotNull pp configs, boolean z10) {
        kotlin.jvm.internal.t.i(configs, "configs");
        return new ip(str, list, configs, z10);
    }
}
