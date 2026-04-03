package com.ironsource;

import com.ironsource.g2;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class yh extends q0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private final String f16326t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private final List<NetworkSettings> f16327u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private final hi f16328v;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public yh(@Nullable String str, @Nullable List<? extends NetworkSettings> list, @NotNull hi configs) {
        kotlin.jvm.internal.t.i(configs, "configs");
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        h5 h5VarG = configs.g();
        kotlin.jvm.internal.t.h(h5VarG, "configs.interstitialAuctionSettings");
        super(ad_unit, str, list, h5VarG, configs.c(), configs.d(), configs.f(), configs.b(), -1, new g2(g2.a.MANUAL, configs.g().j(), configs.g().b(), -1L), new b2(-1L), configs.h(), configs.i(), configs.l(), configs.n(), configs.m(), false, 65536, null);
        this.f16326t = str;
        this.f16327u = list;
        this.f16328v = configs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ yh a(yh yhVar, String str, List list, hi hiVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = yhVar.p();
        }
        if ((i10 & 2) != 0) {
            list = yhVar.k();
        }
        if ((i10 & 4) != 0) {
            hiVar = yhVar.f16328v;
        }
        return yhVar.a(str, list, hiVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yh)) {
            return false;
        }
        yh yhVar = (yh) obj;
        return kotlin.jvm.internal.t.d(p(), yhVar.p()) && kotlin.jvm.internal.t.d(k(), yhVar.k()) && kotlin.jvm.internal.t.d(this.f16328v, yhVar.f16328v);
    }

    public int hashCode() {
        return ((((p() == null ? 0 : p().hashCode()) * 31) + (k() != null ? k().hashCode() : 0)) * 31) + this.f16328v.hashCode();
    }

    @Override // com.ironsource.q0
    @Nullable
    public List<NetworkSettings> k() {
        return this.f16327u;
    }

    @Override // com.ironsource.q0
    @Nullable
    public String p() {
        return this.f16326t;
    }

    @Nullable
    public final String t() {
        return p();
    }

    @NotNull
    public String toString() {
        return "InterstitialAdManagerData(userId=" + p() + ", providerList=" + k() + ", configs=" + this.f16328v + ')';
    }

    @Nullable
    public final List<NetworkSettings> u() {
        return k();
    }

    @NotNull
    public final hi v() {
        return this.f16328v;
    }

    @NotNull
    public final hi w() {
        return this.f16328v;
    }

    @NotNull
    public final yh a(@Nullable String str, @Nullable List<? extends NetworkSettings> list, @NotNull hi configs) {
        kotlin.jvm.internal.t.i(configs, "configs");
        return new yh(str, list, configs);
    }
}
