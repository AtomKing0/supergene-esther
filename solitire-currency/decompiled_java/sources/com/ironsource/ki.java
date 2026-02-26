package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ki implements eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final v2 f12876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final hi f12877b;

    public ki(@NotNull v2 adapterConfig, @NotNull hi adFormatConfigurations) {
        kotlin.jvm.internal.t.i(adapterConfig, "adapterConfig");
        kotlin.jvm.internal.t.i(adFormatConfigurations, "adFormatConfigurations");
        this.f12876a = adapterConfig;
        this.f12877b = adFormatConfigurations;
    }

    @Override // com.ironsource.w2
    public boolean a() {
        return !this.f12876a.j();
    }

    @Override // com.ironsource.w2
    @NotNull
    public String b() {
        String strA = this.f12876a.a();
        kotlin.jvm.internal.t.h(strA, "adapterConfig.adSourceNameForEvents");
        return strA;
    }

    @Override // com.ironsource.w2
    @NotNull
    public gh c() {
        return gh.f12287b.a(this.f12876a.d());
    }

    @Override // com.ironsource.w2
    public boolean d() {
        return true;
    }

    @Override // com.ironsource.s
    public long e() {
        return this.f12877b.e();
    }

    @Override // com.ironsource.w2
    @NotNull
    public String f() {
        String strF = this.f12876a.f();
        kotlin.jvm.internal.t.h(strF, "adapterConfig.providerName");
        return strF;
    }
}
