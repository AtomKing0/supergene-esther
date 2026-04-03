package com.unity3d.mediation;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LevelPlayAdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f23884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f23885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final ImpressionData f23886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final LevelPlayAdSize f23887d;

    public LevelPlayAdInfo(@NotNull String adUnitId, @NotNull String adFormat, @Nullable ImpressionData impressionData, @Nullable LevelPlayAdSize levelPlayAdSize) {
        t.i(adUnitId, "adUnitId");
        t.i(adFormat, "adFormat");
        this.f23884a = adUnitId;
        this.f23885b = adFormat;
        this.f23886c = impressionData;
        this.f23887d = levelPlayAdSize;
    }

    private final String a() {
        return this.f23884a;
    }

    private final String b() {
        return this.f23885b;
    }

    private final ImpressionData c() {
        return this.f23886c;
    }

    public static /* synthetic */ LevelPlayAdInfo copy$default(LevelPlayAdInfo levelPlayAdInfo, String str, String str2, ImpressionData impressionData, LevelPlayAdSize levelPlayAdSize, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = levelPlayAdInfo.f23884a;
        }
        if ((i10 & 2) != 0) {
            str2 = levelPlayAdInfo.f23885b;
        }
        if ((i10 & 4) != 0) {
            impressionData = levelPlayAdInfo.f23886c;
        }
        if ((i10 & 8) != 0) {
            levelPlayAdSize = levelPlayAdInfo.f23887d;
        }
        return levelPlayAdInfo.copy(str, str2, impressionData, levelPlayAdSize);
    }

    private final LevelPlayAdSize d() {
        return this.f23887d;
    }

    @NotNull
    public final LevelPlayAdInfo copy(@NotNull String adUnitId, @NotNull String adFormat, @Nullable ImpressionData impressionData, @Nullable LevelPlayAdSize levelPlayAdSize) {
        t.i(adUnitId, "adUnitId");
        t.i(adFormat, "adFormat");
        return new LevelPlayAdInfo(adUnitId, adFormat, impressionData, levelPlayAdSize);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LevelPlayAdInfo)) {
            return false;
        }
        LevelPlayAdInfo levelPlayAdInfo = (LevelPlayAdInfo) obj;
        return t.d(this.f23884a, levelPlayAdInfo.f23884a) && t.d(this.f23885b, levelPlayAdInfo.f23885b) && t.d(this.f23886c, levelPlayAdInfo.f23886c) && t.d(this.f23887d, levelPlayAdInfo.f23887d);
    }

    @NotNull
    public final String getAb() {
        ImpressionData impressionData = this.f23886c;
        String ab2 = impressionData != null ? impressionData.getAb() : null;
        return ab2 == null ? "" : ab2;
    }

    @NotNull
    public final String getAdFormat() {
        ImpressionData impressionData = this.f23886c;
        String adFormat = impressionData != null ? impressionData.getAdFormat() : null;
        return adFormat == null ? this.f23885b : adFormat;
    }

    @NotNull
    public final String getAdNetwork() {
        ImpressionData impressionData = this.f23886c;
        String adNetwork = impressionData != null ? impressionData.getAdNetwork() : null;
        return adNetwork == null ? "" : adNetwork;
    }

    @Nullable
    public final LevelPlayAdSize getAdSize() {
        return this.f23887d;
    }

    @NotNull
    public final String getAdUnitId() {
        ImpressionData impressionData = this.f23886c;
        String mediationAdUnitId = impressionData != null ? impressionData.getMediationAdUnitId() : null;
        return mediationAdUnitId == null ? this.f23884a : mediationAdUnitId;
    }

    @NotNull
    public final String getAdUnitName() {
        ImpressionData impressionData = this.f23886c;
        String mediationAdUnitName = impressionData != null ? impressionData.getMediationAdUnitName() : null;
        return mediationAdUnitName == null ? "" : mediationAdUnitName;
    }

    @NotNull
    public final String getAuctionId() {
        ImpressionData impressionData = this.f23886c;
        String auctionId = impressionData != null ? impressionData.getAuctionId() : null;
        return auctionId == null ? "" : auctionId;
    }

    @NotNull
    public final String getCountry() {
        ImpressionData impressionData = this.f23886c;
        String country = impressionData != null ? impressionData.getCountry() : null;
        return country == null ? "" : country;
    }

    @NotNull
    public final String getEncryptedCPM() {
        ImpressionData impressionData = this.f23886c;
        String encryptedCPM = impressionData != null ? impressionData.getEncryptedCPM() : null;
        return encryptedCPM == null ? "" : encryptedCPM;
    }

    @NotNull
    public final String getInstanceId() {
        ImpressionData impressionData = this.f23886c;
        String instanceId = impressionData != null ? impressionData.getInstanceId() : null;
        return instanceId == null ? "" : instanceId;
    }

    @NotNull
    public final String getInstanceName() {
        ImpressionData impressionData = this.f23886c;
        String instanceName = impressionData != null ? impressionData.getInstanceName() : null;
        return instanceName == null ? "" : instanceName;
    }

    @NotNull
    public final String getPlacementName() {
        ImpressionData impressionData = this.f23886c;
        String placement = impressionData != null ? impressionData.getPlacement() : null;
        return placement == null ? "" : placement;
    }

    @NotNull
    public final String getPrecision() {
        ImpressionData impressionData = this.f23886c;
        String precision = impressionData != null ? impressionData.getPrecision() : null;
        return precision == null ? "" : precision;
    }

    public final double getRevenue() {
        ImpressionData impressionData = this.f23886c;
        Double revenue = impressionData != null ? impressionData.getRevenue() : null;
        if (revenue == null) {
            return 0.0d;
        }
        return revenue.doubleValue();
    }

    @NotNull
    public final String getSegmentName() {
        ImpressionData impressionData = this.f23886c;
        String segmentName = impressionData != null ? impressionData.getSegmentName() : null;
        return segmentName == null ? "" : segmentName;
    }

    public int hashCode() {
        int iHashCode = ((this.f23884a.hashCode() * 31) + this.f23885b.hashCode()) * 31;
        ImpressionData impressionData = this.f23886c;
        int iHashCode2 = (iHashCode + (impressionData == null ? 0 : impressionData.hashCode())) * 31;
        LevelPlayAdSize levelPlayAdSize = this.f23887d;
        return iHashCode2 + (levelPlayAdSize != null ? levelPlayAdSize.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "adUnitId: " + getAdUnitId() + ", adUnitName: " + getAdUnitName() + ", adSize: " + this.f23887d + ", adFormat: " + getAdFormat() + ", placementName: " + getPlacementName() + ", auctionId: " + getAuctionId() + ", country: " + getCountry() + ", ab: " + getAb() + ", segmentName: " + getSegmentName() + ", adNetwork: " + getAdNetwork() + ", instanceName: " + getInstanceName() + ", instanceId: " + getInstanceId() + ", revenue: " + getRevenue() + ", precision: " + getPrecision() + ", encryptedCPM: " + getEncryptedCPM();
    }

    public /* synthetic */ LevelPlayAdInfo(String str, String str2, ImpressionData impressionData, LevelPlayAdSize levelPlayAdSize, int i10, k kVar) {
        this(str, str2, (i10 & 4) != 0 ? null : impressionData, (i10 & 8) != 0 ? null : levelPlayAdSize);
    }
}
