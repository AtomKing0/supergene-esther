package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class yo implements eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final v2 f16339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final pp f16340b;

    public yo(@NotNull v2 adapterConfig, @NotNull pp adFormatConfigurations) {
        kotlin.jvm.internal.t.i(adapterConfig, "adapterConfig");
        kotlin.jvm.internal.t.i(adFormatConfigurations, "adFormatConfigurations");
        this.f16339a = adapterConfig;
        this.f16340b = adFormatConfigurations;
    }

    @Override // com.ironsource.w2
    public boolean a() {
        return !this.f16339a.j();
    }

    @Override // com.ironsource.w2
    @NotNull
    public String b() {
        String strA = this.f16339a.a();
        kotlin.jvm.internal.t.h(strA, "adapterConfig.adSourceNameForEvents");
        return strA;
    }

    @Override // com.ironsource.w2
    @NotNull
    public gh c() {
        return gh.f12287b.a(this.f16339a.d());
    }

    @Override // com.ironsource.w2
    public boolean d() {
        return true;
    }

    @Override // com.ironsource.s
    public long e() {
        return this.f16340b.i();
    }

    @Override // com.ironsource.w2
    @NotNull
    public String f() {
        String strF = this.f16339a.f();
        kotlin.jvm.internal.t.h(strF, "adapterConfig.providerName");
        return strF;
    }
}
