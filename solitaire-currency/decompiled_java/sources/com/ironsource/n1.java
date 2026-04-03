package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class n1 implements z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final b1 f14055a;

    public n1(@NotNull b1 adProperties) {
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        this.f14055a = adProperties;
    }

    @Override // com.ironsource.z4
    public void a(@NotNull com.ironsource.mediationsdk.i auctionRequestParams) {
        kotlin.jvm.internal.t.i(auctionRequestParams, "auctionRequestParams");
        auctionRequestParams.b(this.f14055a.b());
        auctionRequestParams.a(this.f14055a.a().toString());
        auctionRequestParams.a(Boolean.TRUE);
    }
}
