package com.onetrust.otpublishers.headless.Public.DataModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;

/* JADX INFO: loaded from: classes4.dex */
public class OTSdkParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OTProfileSyncParams f21998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OTUXParams f21999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f22000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f22001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f22002h;

    public static class SdkParamsBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22005c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public OTProfileSyncParams f22006d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f22007e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f22008f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public OTUXParams f22009g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f22010h;

        @NonNull
        public static SdkParamsBuilder newInstance() {
            return new SdkParamsBuilder();
        }

        @NonNull
        public OTSdkParams build() {
            return new OTSdkParams(this);
        }

        @NonNull
        public SdkParamsBuilder setAPIVersion(@NonNull String str) {
            this.f22005c = str;
            return this;
        }

        @NonNull
        public SdkParamsBuilder setOTCountryCode(@NonNull String str) {
            this.f22003a = str;
            return this;
        }

        @NonNull
        public SdkParamsBuilder setOTRegionCode(@NonNull String str) {
            this.f22004b = str;
            return this;
        }

        @NonNull
        public SdkParamsBuilder setOTUXParams(@NonNull OTUXParams oTUXParams) {
            this.f22009g = oTUXParams;
            return this;
        }

        @NonNull
        @Deprecated
        public SdkParamsBuilder setOtBannerHeightRatio(@NonNull String str) {
            OTLogger.a("OneTrust", 5, "setOtBannerHeightRatio() method is deprecated and eventually will get removed from SDK. Please configure the banner height from OT admin UI template settings");
            this.f22008f = str;
            return this;
        }

        @NonNull
        public SdkParamsBuilder setProfileSyncParams(@NonNull OTProfileSyncParams oTProfileSyncParams) {
            this.f22006d = oTProfileSyncParams;
            return this;
        }

        @NonNull
        public SdkParamsBuilder setSyncWebSDKConsent(boolean z10) {
            this.f22010h = z10;
            return this;
        }

        @NonNull
        public SdkParamsBuilder shouldCreateProfile(@NonNull String str) {
            this.f22007e = str;
            return this;
        }
    }

    public OTSdkParams(@NonNull SdkParamsBuilder sdkParamsBuilder) {
        this.f21995a = sdkParamsBuilder.f22003a;
        this.f21996b = sdkParamsBuilder.f22004b;
        this.f21997c = sdkParamsBuilder.f22005c;
        this.f21998d = sdkParamsBuilder.f22006d;
        this.f22000f = sdkParamsBuilder.f22007e;
        this.f22001g = sdkParamsBuilder.f22008f;
        this.f21999e = sdkParamsBuilder.f22009g;
        this.f22002h = sdkParamsBuilder.f22010h;
    }

    @Nullable
    public String getCreateProfile() {
        return this.f22000f;
    }

    @Nullable
    public String getOTCountryCode() {
        return this.f21995a;
    }

    @Nullable
    public String getOTRegionCode() {
        return this.f21996b;
    }

    @Nullable
    public String getOTSdkAPIVersion() {
        return this.f21997c;
    }

    @Nullable
    public OTUXParams getOTUXParams() {
        return this.f21999e;
    }

    @Nullable
    public String getOtBannerHeight() {
        return this.f22001g;
    }

    @Nullable
    public OTProfileSyncParams getOtProfileSyncParams() {
        return this.f21998d;
    }

    public boolean getSyncWebSDKConsent() {
        return this.f22002h;
    }
}
