package com.ironsource;

import com.ironsource.cr;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final jq f11460a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bq(@NotNull bq sdkConfig) {
        this(sdkConfig.f11460a);
        kotlin.jvm.internal.t.i(sdkConfig, "sdkConfig");
    }

    @NotNull
    public final d4 a() {
        return this.f11460a.a().a().c();
    }

    @NotNull
    public final w3 b() {
        return this.f11460a.a().a().b();
    }

    @NotNull
    public final xb c() {
        return this.f11460a.b();
    }

    @NotNull
    public final cr d() {
        return this.f11460a.c();
    }

    @NotNull
    public final yk e() {
        return this.f11460a.a().a().e();
    }

    @NotNull
    public final cr.a f() {
        cr.a aVarH = this.f11460a.c().h();
        kotlin.jvm.internal.t.h(aVarH, "sdkInitResponse.fullResponse.origin");
        return aVarH;
    }

    @NotNull
    protected final jq g() {
        return this.f11460a;
    }

    public bq(@NotNull jq sdkInitResponse) {
        kotlin.jvm.internal.t.i(sdkInitResponse, "sdkInitResponse");
        this.f11460a = sdkInitResponse;
    }
}
