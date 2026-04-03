package com.moloco.sdk.publisher;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class MolocoAd {
    public static final int $stable = 0;

    @NotNull
    private final String adUnitId;

    @NotNull
    private final String networkName;

    @Nullable
    private final Float revenue;

    public MolocoAd(@NotNull String networkName, @NotNull String adUnitId, @Nullable Float f10) {
        t.i(networkName, "networkName");
        t.i(adUnitId, "adUnitId");
        this.networkName = networkName;
        this.adUnitId = adUnitId;
        this.revenue = f10;
    }

    public static /* synthetic */ MolocoAd copy$default(MolocoAd molocoAd, String str, String str2, Float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = molocoAd.networkName;
        }
        if ((i10 & 2) != 0) {
            str2 = molocoAd.adUnitId;
        }
        if ((i10 & 4) != 0) {
            f10 = molocoAd.revenue;
        }
        return molocoAd.copy(str, str2, f10);
    }

    @NotNull
    public final String component1() {
        return this.networkName;
    }

    @NotNull
    public final String component2() {
        return this.adUnitId;
    }

    @Nullable
    public final Float component3() {
        return this.revenue;
    }

    @NotNull
    public final MolocoAd copy(@NotNull String networkName, @NotNull String adUnitId, @Nullable Float f10) {
        t.i(networkName, "networkName");
        t.i(adUnitId, "adUnitId");
        return new MolocoAd(networkName, adUnitId, f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MolocoAd)) {
            return false;
        }
        MolocoAd molocoAd = (MolocoAd) obj;
        return t.d(this.networkName, molocoAd.networkName) && t.d(this.adUnitId, molocoAd.adUnitId) && t.d(this.revenue, molocoAd.revenue);
    }

    @NotNull
    public final String getAdUnitId() {
        return this.adUnitId;
    }

    @NotNull
    public final String getNetworkName() {
        return this.networkName;
    }

    @Nullable
    public final Float getRevenue() {
        return this.revenue;
    }

    public int hashCode() {
        int iHashCode = ((this.networkName.hashCode() * 31) + this.adUnitId.hashCode()) * 31;
        Float f10 = this.revenue;
        return iHashCode + (f10 == null ? 0 : f10.hashCode());
    }

    @NotNull
    public String toString() {
        return "MolocoAd(networkName=" + this.networkName + ", adUnitId=" + this.adUnitId + ", revenue=" + this.revenue + ')';
    }

    public /* synthetic */ MolocoAd(String str, String str2, Float f10, int i10, k kVar) {
        this(str, str2, (i10 & 4) != 0 ? null : f10);
    }
}
