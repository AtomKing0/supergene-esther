package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class t6 implements eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final v2 f15385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final n6 f15386b;

    public t6(@NotNull v2 adapterConfig, @NotNull n6 adFormatConfigurations) {
        kotlin.jvm.internal.t.i(adapterConfig, "adapterConfig");
        kotlin.jvm.internal.t.i(adFormatConfigurations, "adFormatConfigurations");
        this.f15385a = adapterConfig;
        this.f15386b = adFormatConfigurations;
    }

    @Override // com.ironsource.w2
    public boolean a() {
        return !this.f15385a.j();
    }

    @Override // com.ironsource.w2
    @NotNull
    public String b() {
        String strA = this.f15385a.a();
        kotlin.jvm.internal.t.h(strA, "adapterConfig.adSourceNameForEvents");
        return strA;
    }

    @Override // com.ironsource.w2
    @NotNull
    public gh c() {
        return gh.f12287b.a(this.f15385a.d());
    }

    @Override // com.ironsource.w2
    public boolean d() {
        return true;
    }

    @Override // com.ironsource.s
    public long e() {
        return this.f15386b.b();
    }

    @Override // com.ironsource.w2
    @NotNull
    public String f() {
        String strF = this.f15385a.f();
        kotlin.jvm.internal.t.h(strF, "adapterConfig.providerName");
        return strF;
    }
}
