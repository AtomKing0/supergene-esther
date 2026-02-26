package com.unity3d.ironsourceads.interstitial;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class InterstitialAdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f23856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f23857b;

    public InterstitialAdInfo(@NotNull String instanceId, @NotNull String adId) {
        t.i(instanceId, "instanceId");
        t.i(adId, "adId");
        this.f23856a = instanceId;
        this.f23857b = adId;
    }

    @NotNull
    public final String getAdId() {
        return this.f23857b;
    }

    @NotNull
    public final String getInstanceId() {
        return this.f23856a;
    }

    @NotNull
    public String toString() {
        return "[instanceId: '" + this.f23856a + "', adId: '" + this.f23857b + "']";
    }
}
