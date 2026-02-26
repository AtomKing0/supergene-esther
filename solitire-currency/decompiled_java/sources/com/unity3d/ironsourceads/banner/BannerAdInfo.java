package com.unity3d.ironsourceads.banner;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class BannerAdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f23837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f23838b;

    public BannerAdInfo(@NotNull String instanceId, @NotNull String adId) {
        t.i(instanceId, "instanceId");
        t.i(adId, "adId");
        this.f23837a = instanceId;
        this.f23838b = adId;
    }

    public static /* synthetic */ BannerAdInfo copy$default(BannerAdInfo bannerAdInfo, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = bannerAdInfo.f23837a;
        }
        if ((i10 & 2) != 0) {
            str2 = bannerAdInfo.f23838b;
        }
        return bannerAdInfo.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.f23837a;
    }

    @NotNull
    public final String component2() {
        return this.f23838b;
    }

    @NotNull
    public final BannerAdInfo copy(@NotNull String instanceId, @NotNull String adId) {
        t.i(instanceId, "instanceId");
        t.i(adId, "adId");
        return new BannerAdInfo(instanceId, adId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannerAdInfo)) {
            return false;
        }
        BannerAdInfo bannerAdInfo = (BannerAdInfo) obj;
        return t.d(this.f23837a, bannerAdInfo.f23837a) && t.d(this.f23838b, bannerAdInfo.f23838b);
    }

    @NotNull
    public final String getAdId() {
        return this.f23838b;
    }

    @NotNull
    public final String getInstanceId() {
        return this.f23837a;
    }

    public int hashCode() {
        return (this.f23837a.hashCode() * 31) + this.f23838b.hashCode();
    }

    @NotNull
    public String toString() {
        return "[instanceId: '" + this.f23837a + "', adId: '" + this.f23838b + "']";
    }
}
