package com.ironsource;

import com.ironsource.g2;
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
public final class yl extends s1 {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NotNull
    public static final a f16333z = new a(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    private final b1 f16334u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private final r1 f16335v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NotNull
    private final jl f16336w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NotNull
    private final String f16337x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NotNull
    private final String f16338y;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final yl a(@NotNull b1 adProperties, @Nullable ak akVar) {
            List<rm> listL;
            cr crVarD;
            kotlin.jvm.internal.t.i(adProperties, "adProperties");
            s1.a aVar = s1.f14755s;
            m8 m8VarC = (akVar == null || (crVarD = akVar.d()) == null) ? null : crVarD.c();
            jl jlVarE = m8VarC != null ? m8VarC.e() : null;
            if (jlVarE == null) {
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
            return new yl(adProperties, new r1(userIdForNetworks, arrayList, ljVarB), jlVarE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yl(@NotNull b1 adProperties, @NotNull r1 adUnitCommonData, @NotNull jl configs) {
        super(adProperties, true, adUnitCommonData.f(), adUnitCommonData.d(), adUnitCommonData.e(), configs.d(), configs.b(), (int) (configs.c() / ((long) 1000)), configs.a(), configs.f(), -1, new g2(g2.a.MANUAL, configs.d().j(), configs.d().b(), -1L), configs.h(), configs.i(), configs.j(), configs.l(), configs.k(), false, 131072, null);
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        kotlin.jvm.internal.t.i(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.t.i(configs, "configs");
        this.f16334u = adProperties;
        this.f16335v = adUnitCommonData;
        this.f16336w = configs;
        this.f16337x = "NA";
        this.f16338y = bk.f11420e;
    }

    @NotNull
    public final r1 A() {
        return this.f16335v;
    }

    @NotNull
    public final jl B() {
        return this.f16336w;
    }

    @NotNull
    public final yl a(@NotNull b1 adProperties, @NotNull r1 adUnitCommonData, @NotNull jl configs) {
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        kotlin.jvm.internal.t.i(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.t.i(configs, "configs");
        return new yl(adProperties, adUnitCommonData, configs);
    }

    @Override // com.ironsource.s1
    @NotNull
    public b1 b() {
        return this.f16334u;
    }

    @Override // com.ironsource.s1
    @NotNull
    public String c() {
        return this.f16337x;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yl)) {
            return false;
        }
        yl ylVar = (yl) obj;
        return kotlin.jvm.internal.t.d(b(), ylVar.b()) && kotlin.jvm.internal.t.d(this.f16335v, ylVar.f16335v) && kotlin.jvm.internal.t.d(this.f16336w, ylVar.f16336w);
    }

    public int hashCode() {
        return (((b().hashCode() * 31) + this.f16335v.hashCode()) * 31) + this.f16336w.hashCode();
    }

    @Override // com.ironsource.s1
    @NotNull
    public String k() {
        return this.f16338y;
    }

    @NotNull
    public String toString() {
        return "NativeAdUnitData(adProperties=" + b() + ", adUnitCommonData=" + this.f16335v + ", configs=" + this.f16336w + ')';
    }

    @NotNull
    public final b1 x() {
        return b();
    }

    @NotNull
    public final r1 y() {
        return this.f16335v;
    }

    @NotNull
    public final jl z() {
        return this.f16336w;
    }

    public static /* synthetic */ yl a(yl ylVar, b1 b1Var, r1 r1Var, jl jlVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            b1Var = ylVar.b();
        }
        if ((i10 & 2) != 0) {
            r1Var = ylVar.f16335v;
        }
        if ((i10 & 4) != 0) {
            jlVar = ylVar.f16336w;
        }
        return ylVar.a(b1Var, r1Var, jlVar);
    }

    @Override // com.ironsource.s1
    @NotNull
    public JSONObject b(@NotNull NetworkSettings providerSettings) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        JSONObject nativeAdSettings = providerSettings.getNativeAdSettings();
        kotlin.jvm.internal.t.h(nativeAdSettings, "providerSettings.nativeAdSettings");
        return nativeAdSettings;
    }
}
