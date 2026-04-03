package com.ironsource;

import com.ironsource.mediationsdk.ISBannerSize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class l6 extends n1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final ISBannerSize f12985b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l6(@NotNull b1 adProperties, @Nullable ISBannerSize iSBannerSize) {
        super(adProperties);
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        this.f12985b = iSBannerSize;
    }

    @Override // com.ironsource.n1, com.ironsource.z4
    public void a(@NotNull com.ironsource.mediationsdk.i auctionRequestParams) {
        kotlin.jvm.internal.t.i(auctionRequestParams, "auctionRequestParams");
        super.a(auctionRequestParams);
        auctionRequestParams.a(this.f12985b);
    }
}
