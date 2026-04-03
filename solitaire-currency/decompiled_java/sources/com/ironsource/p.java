package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Boolean f14288a;

    public p(@NotNull JSONObject adFormatAuctionSettings) {
        kotlin.jvm.internal.t.i(adFormatAuctionSettings, "adFormatAuctionSettings");
        this.f14288a = adFormatAuctionSettings.has("isLoadWhileShow") ? Boolean.valueOf(adFormatAuctionSettings.optBoolean("isLoadWhileShow")) : null;
    }

    @Nullable
    public final Boolean a() {
        return this.f14288a;
    }
}
