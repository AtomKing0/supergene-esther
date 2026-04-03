package com.unity3d.ironsourceads.rewarded;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class RewardedAdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f23869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f23870b;

    public RewardedAdInfo(@NotNull String instanceId, @NotNull String adId) {
        t.i(instanceId, "instanceId");
        t.i(adId, "adId");
        this.f23869a = instanceId;
        this.f23870b = adId;
    }

    @NotNull
    public final String getAdId() {
        return this.f23870b;
    }

    @NotNull
    public final String getInstanceId() {
        return this.f23869a;
    }

    @NotNull
    public String toString() {
        return "[instanceId: '" + this.f23869a + "', adId: '" + this.f23870b + "']";
    }
}
