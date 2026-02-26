package com.vungle.ads.internal.model;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdvertisingInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    @Nullable
    private String advertisingId;
    private boolean limitAdTracking;

    @Nullable
    public final String getAdvertisingId() {
        return this.advertisingId;
    }

    public final boolean getLimitAdTracking() {
        return this.limitAdTracking;
    }

    public final void setAdvertisingId(@Nullable String str) {
        this.advertisingId = str;
    }

    public final void setLimitAdTracking(boolean z10) {
        this.limitAdTracking = z10;
    }
}
