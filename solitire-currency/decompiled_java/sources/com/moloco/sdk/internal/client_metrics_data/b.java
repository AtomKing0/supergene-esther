package com.moloco.sdk.internal.client_metrics_data;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public enum b {
    Reason("reason"),
    AdType("ad_type"),
    Result("result"),
    Country(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY),
    RetryAttempt("attempt"),
    Step("step");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f17576a;

    b(String str) {
        this.f17576a = str;
    }

    @NotNull
    public final String c() {
        return this.f17576a;
    }
}
