package com.onetrust.otpublishers.headless.gcm.consent;

import androidx.annotation.Keep;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public final class OTGoogleConsentModeData {

    @NotNull
    private OTGoogleConsentType consentType;

    @NotNull
    private OTSDKStatus sdkStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public OTGoogleConsentModeData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OTGoogleConsentModeData copy$default(OTGoogleConsentModeData oTGoogleConsentModeData, OTSDKStatus oTSDKStatus, OTGoogleConsentType oTGoogleConsentType, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            oTSDKStatus = oTGoogleConsentModeData.sdkStatus;
        }
        if ((i10 & 2) != 0) {
            oTGoogleConsentType = oTGoogleConsentModeData.consentType;
        }
        return oTGoogleConsentModeData.copy(oTSDKStatus, oTGoogleConsentType);
    }

    @NotNull
    public final OTSDKStatus component1() {
        return this.sdkStatus;
    }

    @NotNull
    public final OTGoogleConsentType component2() {
        return this.consentType;
    }

    @NotNull
    public final OTGoogleConsentModeData copy(@NotNull OTSDKStatus sdkStatus, @NotNull OTGoogleConsentType consentType) {
        t.i(sdkStatus, "sdkStatus");
        t.i(consentType, "consentType");
        return new OTGoogleConsentModeData(sdkStatus, consentType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OTGoogleConsentModeData)) {
            return false;
        }
        OTGoogleConsentModeData oTGoogleConsentModeData = (OTGoogleConsentModeData) obj;
        return this.sdkStatus == oTGoogleConsentModeData.sdkStatus && t.d(this.consentType, oTGoogleConsentModeData.consentType);
    }

    @NotNull
    public final OTGoogleConsentType getConsentType() {
        return this.consentType;
    }

    @NotNull
    public final OTSDKStatus getSdkStatus() {
        return this.sdkStatus;
    }

    public int hashCode() {
        return this.consentType.hashCode() + (this.sdkStatus.hashCode() * 31);
    }

    public final void setConsentType(@NotNull OTGoogleConsentType oTGoogleConsentType) {
        t.i(oTGoogleConsentType, "<set-?>");
        this.consentType = oTGoogleConsentType;
    }

    public final void setSdkStatus(@NotNull OTSDKStatus oTSDKStatus) {
        t.i(oTSDKStatus, "<set-?>");
        this.sdkStatus = oTSDKStatus;
    }

    @NotNull
    public String toString() {
        return "OTGoogleConsentModeData(sdkStatus=" + this.sdkStatus + ", consentType=" + this.consentType + ')';
    }

    public OTGoogleConsentModeData(@NotNull OTSDKStatus sdkStatus, @NotNull OTGoogleConsentType consentType) {
        t.i(sdkStatus, "sdkStatus");
        t.i(consentType, "consentType");
        this.sdkStatus = sdkStatus;
        this.consentType = consentType;
    }

    public /* synthetic */ OTGoogleConsentModeData(OTSDKStatus oTSDKStatus, OTGoogleConsentType oTGoogleConsentType, int i10, k kVar) {
        this((i10 & 1) != 0 ? OTSDKStatus.NOT_INITIALIZED : oTSDKStatus, (i10 & 2) != 0 ? new OTGoogleConsentType(null, null, null, null, null, null, null, 127, null) : oTGoogleConsentType);
    }
}
