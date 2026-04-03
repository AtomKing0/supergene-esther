package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class a6 extends q0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private final String f11199t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private final List<NetworkSettings> f11200u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private final n6 f11201v;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public a6(@Nullable String str, @Nullable List<? extends NetworkSettings> list, @NotNull n6 configs) {
        kotlin.jvm.internal.t.i(configs, "configs");
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        h5 h5VarD = configs.d();
        kotlin.jvm.internal.t.h(h5VarD, "configs.bannerAuctionSettings");
        super(ad_unit, str, list, h5VarD, configs.a(), (int) (configs.b() / ((long) 1000)), configs.c(), configs.g(), -1, b6.b(configs), new b2(configs.k()), configs.e(), configs.f(), configs.m(), configs.o(), configs.n(), false, 65536, null);
        this.f11199t = str;
        this.f11200u = list;
        this.f11201v = configs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a6 a(a6 a6Var, String str, List list, n6 n6Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = a6Var.p();
        }
        if ((i10 & 2) != 0) {
            list = a6Var.k();
        }
        if ((i10 & 4) != 0) {
            n6Var = a6Var.f11201v;
        }
        return a6Var.a(str, list, n6Var);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a6)) {
            return false;
        }
        a6 a6Var = (a6) obj;
        return kotlin.jvm.internal.t.d(p(), a6Var.p()) && kotlin.jvm.internal.t.d(k(), a6Var.k()) && kotlin.jvm.internal.t.d(this.f11201v, a6Var.f11201v);
    }

    public int hashCode() {
        return ((((p() == null ? 0 : p().hashCode()) * 31) + (k() != null ? k().hashCode() : 0)) * 31) + this.f11201v.hashCode();
    }

    @Override // com.ironsource.q0
    @Nullable
    public List<NetworkSettings> k() {
        return this.f11200u;
    }

    @Override // com.ironsource.q0
    @Nullable
    public String p() {
        return this.f11199t;
    }

    @Nullable
    public final String t() {
        return p();
    }

    @NotNull
    public String toString() {
        return "BannerAdManagerData(userId=" + p() + ", providerList=" + k() + ", configs=" + this.f11201v + ')';
    }

    @Nullable
    public final List<NetworkSettings> u() {
        return k();
    }

    @NotNull
    public final n6 v() {
        return this.f11201v;
    }

    @NotNull
    public final n6 w() {
        return this.f11201v;
    }

    @NotNull
    public final a6 a(@Nullable String str, @Nullable List<? extends NetworkSettings> list, @NotNull n6 configs) {
        kotlin.jvm.internal.t.i(configs, "configs");
        return new a6(str, list, configs);
    }
}
