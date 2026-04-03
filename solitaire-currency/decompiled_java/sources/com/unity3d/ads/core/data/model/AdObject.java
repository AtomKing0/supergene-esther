package com.unity3d.ads.core.data.model;

import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.adplayer.AdPlayer;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdObject.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdObject {

    @Nullable
    private final AdPlayer adPlayer;

    @NotNull
    private final DiagnosticEventRequestOuterClass.DiagnosticAdType adType;

    @Nullable
    private final Boolean isHeaderBidding;

    @NotNull
    private final UnityAdsLoadOptions loadOptions;

    @NotNull
    private final ByteString opportunityId;

    @NotNull
    private final String placementId;

    @Nullable
    private String playerServerId;

    @NotNull
    private ByteString trackingToken;

    public AdObject(@NotNull ByteString opportunityId, @NotNull String placementId, @NotNull ByteString trackingToken, @Nullable AdPlayer adPlayer, @Nullable String str, @NotNull UnityAdsLoadOptions loadOptions, @Nullable Boolean bool, @NotNull DiagnosticEventRequestOuterClass.DiagnosticAdType adType) {
        t.i(opportunityId, "opportunityId");
        t.i(placementId, "placementId");
        t.i(trackingToken, "trackingToken");
        t.i(loadOptions, "loadOptions");
        t.i(adType, "adType");
        this.opportunityId = opportunityId;
        this.placementId = placementId;
        this.trackingToken = trackingToken;
        this.adPlayer = adPlayer;
        this.playerServerId = str;
        this.loadOptions = loadOptions;
        this.isHeaderBidding = bool;
        this.adType = adType;
    }

    @NotNull
    public final ByteString component1() {
        return this.opportunityId;
    }

    @NotNull
    public final String component2() {
        return this.placementId;
    }

    @NotNull
    public final ByteString component3() {
        return this.trackingToken;
    }

    @Nullable
    public final AdPlayer component4() {
        return this.adPlayer;
    }

    @Nullable
    public final String component5() {
        return this.playerServerId;
    }

    @NotNull
    public final UnityAdsLoadOptions component6() {
        return this.loadOptions;
    }

    @Nullable
    public final Boolean component7() {
        return this.isHeaderBidding;
    }

    @NotNull
    public final DiagnosticEventRequestOuterClass.DiagnosticAdType component8() {
        return this.adType;
    }

    @NotNull
    public final AdObject copy(@NotNull ByteString opportunityId, @NotNull String placementId, @NotNull ByteString trackingToken, @Nullable AdPlayer adPlayer, @Nullable String str, @NotNull UnityAdsLoadOptions loadOptions, @Nullable Boolean bool, @NotNull DiagnosticEventRequestOuterClass.DiagnosticAdType adType) {
        t.i(opportunityId, "opportunityId");
        t.i(placementId, "placementId");
        t.i(trackingToken, "trackingToken");
        t.i(loadOptions, "loadOptions");
        t.i(adType, "adType");
        return new AdObject(opportunityId, placementId, trackingToken, adPlayer, str, loadOptions, bool, adType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdObject)) {
            return false;
        }
        AdObject adObject = (AdObject) obj;
        return t.d(this.opportunityId, adObject.opportunityId) && t.d(this.placementId, adObject.placementId) && t.d(this.trackingToken, adObject.trackingToken) && t.d(this.adPlayer, adObject.adPlayer) && t.d(this.playerServerId, adObject.playerServerId) && t.d(this.loadOptions, adObject.loadOptions) && t.d(this.isHeaderBidding, adObject.isHeaderBidding) && this.adType == adObject.adType;
    }

    @Nullable
    public final AdPlayer getAdPlayer() {
        return this.adPlayer;
    }

    @NotNull
    public final DiagnosticEventRequestOuterClass.DiagnosticAdType getAdType() {
        return this.adType;
    }

    @NotNull
    public final UnityAdsLoadOptions getLoadOptions() {
        return this.loadOptions;
    }

    @NotNull
    public final ByteString getOpportunityId() {
        return this.opportunityId;
    }

    @NotNull
    public final String getPlacementId() {
        return this.placementId;
    }

    @Nullable
    public final String getPlayerServerId() {
        return this.playerServerId;
    }

    @NotNull
    public final ByteString getTrackingToken() {
        return this.trackingToken;
    }

    public int hashCode() {
        int iHashCode = ((((this.opportunityId.hashCode() * 31) + this.placementId.hashCode()) * 31) + this.trackingToken.hashCode()) * 31;
        AdPlayer adPlayer = this.adPlayer;
        int iHashCode2 = (iHashCode + (adPlayer == null ? 0 : adPlayer.hashCode())) * 31;
        String str = this.playerServerId;
        int iHashCode3 = (((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.loadOptions.hashCode()) * 31;
        Boolean bool = this.isHeaderBidding;
        return ((iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31) + this.adType.hashCode();
    }

    @Nullable
    public final Boolean isHeaderBidding() {
        return this.isHeaderBidding;
    }

    public final void setPlayerServerId(@Nullable String str) {
        this.playerServerId = str;
    }

    public final void setTrackingToken(@NotNull ByteString byteString) {
        t.i(byteString, "<set-?>");
        this.trackingToken = byteString;
    }

    @NotNull
    public String toString() {
        return "AdObject(opportunityId=" + this.opportunityId + ", placementId=" + this.placementId + ", trackingToken=" + this.trackingToken + ", adPlayer=" + this.adPlayer + ", playerServerId=" + this.playerServerId + ", loadOptions=" + this.loadOptions + ", isHeaderBidding=" + this.isHeaderBidding + ", adType=" + this.adType + ')';
    }

    public /* synthetic */ AdObject(ByteString byteString, String str, ByteString byteString2, AdPlayer adPlayer, String str2, UnityAdsLoadOptions unityAdsLoadOptions, Boolean bool, DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType, int i10, k kVar) {
        this(byteString, str, byteString2, (i10 & 8) != 0 ? null : adPlayer, (i10 & 16) != 0 ? null : str2, unityAdsLoadOptions, (i10 & 64) != 0 ? null : bool, diagnosticAdType);
    }
}
