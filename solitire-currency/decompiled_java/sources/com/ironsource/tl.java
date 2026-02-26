package com.ironsource;

import com.ironsource.g2;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class tl extends q0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private final String f15405t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private final List<NetworkSettings> f15406u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private final jl f15407v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public tl(@Nullable String str, @Nullable List<? extends NetworkSettings> list, @NotNull jl configs) {
        super(IronSource.AD_UNIT.NATIVE_AD, str, list, configs.d(), configs.b(), (int) (configs.c() / ((long) 1000)), configs.a(), configs.f(), -1, new g2(g2.a.MANUAL, configs.d().j(), configs.d().b(), -1L), new b2(-1L), configs.h(), configs.i(), configs.j(), configs.l(), configs.k(), false, 65536, null);
        kotlin.jvm.internal.t.i(configs, "configs");
        this.f15405t = str;
        this.f15406u = list;
        this.f15407v = configs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ tl a(tl tlVar, String str, List list, jl jlVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = tlVar.p();
        }
        if ((i10 & 2) != 0) {
            list = tlVar.k();
        }
        if ((i10 & 4) != 0) {
            jlVar = tlVar.f15407v;
        }
        return tlVar.a(str, list, jlVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tl)) {
            return false;
        }
        tl tlVar = (tl) obj;
        return kotlin.jvm.internal.t.d(p(), tlVar.p()) && kotlin.jvm.internal.t.d(k(), tlVar.k()) && kotlin.jvm.internal.t.d(this.f15407v, tlVar.f15407v);
    }

    public int hashCode() {
        return ((((p() == null ? 0 : p().hashCode()) * 31) + (k() != null ? k().hashCode() : 0)) * 31) + this.f15407v.hashCode();
    }

    @Override // com.ironsource.q0
    @Nullable
    public List<NetworkSettings> k() {
        return this.f15406u;
    }

    @Override // com.ironsource.q0
    @Nullable
    public String p() {
        return this.f15405t;
    }

    @Nullable
    public final String t() {
        return p();
    }

    @NotNull
    public String toString() {
        return "NativeAdManagerData(userId=" + p() + ", providerList=" + k() + ", configs=" + this.f15407v + ')';
    }

    @Nullable
    public final List<NetworkSettings> u() {
        return k();
    }

    @NotNull
    public final jl v() {
        return this.f15407v;
    }

    @NotNull
    public final jl w() {
        return this.f15407v;
    }

    @NotNull
    public final tl a(@Nullable String str, @Nullable List<? extends NetworkSettings> list, @NotNull jl configs) {
        kotlin.jvm.internal.t.i(configs, "configs");
        return new tl(str, list, configs);
    }
}
