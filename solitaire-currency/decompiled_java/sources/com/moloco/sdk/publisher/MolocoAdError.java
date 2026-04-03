package com.moloco.sdk.publisher;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class MolocoAdError {
    public static final int $stable = 0;

    @NotNull
    private final String adUnitId;

    @NotNull
    private final String description;

    @NotNull
    private final ErrorType errorType;

    @NotNull
    private final String networkName;

    public enum AdCreateError {
        SDK_INIT_FAILED("Failed to create `ad` object due to SDK initialization failure.", 1011),
        SDK_INIT_WAS_NOT_COMPLETED("Failed to create `ad` object due to `Moloco.initialize()` not complete.", 1012),
        UNABLE_TO_CREATE_AD("Failed to create `ad` object due to `Moloco.initialize()` not complete in time", 1013);


        @NotNull
        private final String description;
        private final int errorCode;

        AdCreateError(String str, int i10) {
            this.description = str;
            this.errorCode = i10;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    public enum ErrorType {
        UNKNOWN("Generic failure error code", -1),
        SDK_INIT_ERROR("SDK initialization error", 1000),
        SDK_PERSISTENT_HTTP_REQUEST_FAILED_TO_INIT("WorkManager crash that prevents us from creating a persistent http request client", 1001),
        SDK_INVALID_CONFIGURATION("Ad object cannot be created, due to invalid configuration", 1002),
        AD_LOAD_FAILED("Ad is not loaded", 2000),
        AD_LOAD_FAILED_SDK_NOT_INIT("Ad load failed because SDK was not initialized", 2001),
        AD_LOAD_TIMEOUT_ERROR("Ad failed to load because the request timed out", 2003),
        AD_LOAD_LIMIT_REACHED("Ad load limit reached", 2004),
        AD_LOAD_BID_FAILED("Ad failed to load because bid request failed or no fill", 2005),
        AD_SHOW_ERROR("Ad show failed despite a successful ad load. Internal renderer error", 3000),
        AD_SHOW_ERROR_NOT_LOADED("Ad show failed because ad load was not called", 3001),
        AD_SHOW_ERROR_ALREADY_DISPLAYING("Ad show failed because show() was invoked multiple times when ad was already rendering", 3002),
        AD_BID_PARSE_ERROR("The bid response received was not parseable by the SDK", 4000),
        AD_SIGNAL_COLLECTION_FAILED("The bid token couldn’t be retrieved.", 5000);


        @NotNull
        private final String description;
        private final int errorCode;

        ErrorType(String str, int i10) {
            this.description = str;
            this.errorCode = i10;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    public MolocoAdError(@NotNull String networkName, @NotNull String adUnitId, @NotNull ErrorType errorType, @NotNull String description) {
        t.i(networkName, "networkName");
        t.i(adUnitId, "adUnitId");
        t.i(errorType, "errorType");
        t.i(description, "description");
        this.networkName = networkName;
        this.adUnitId = adUnitId;
        this.errorType = errorType;
        this.description = description;
    }

    public static /* synthetic */ MolocoAdError copy$default(MolocoAdError molocoAdError, String str, String str2, ErrorType errorType, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = molocoAdError.networkName;
        }
        if ((i10 & 2) != 0) {
            str2 = molocoAdError.adUnitId;
        }
        if ((i10 & 4) != 0) {
            errorType = molocoAdError.errorType;
        }
        if ((i10 & 8) != 0) {
            str3 = molocoAdError.description;
        }
        return molocoAdError.copy(str, str2, errorType, str3);
    }

    @NotNull
    public final String component1() {
        return this.networkName;
    }

    @NotNull
    public final String component2() {
        return this.adUnitId;
    }

    @NotNull
    public final ErrorType component3() {
        return this.errorType;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    @NotNull
    public final MolocoAdError copy(@NotNull String networkName, @NotNull String adUnitId, @NotNull ErrorType errorType, @NotNull String description) {
        t.i(networkName, "networkName");
        t.i(adUnitId, "adUnitId");
        t.i(errorType, "errorType");
        t.i(description, "description");
        return new MolocoAdError(networkName, adUnitId, errorType, description);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MolocoAdError)) {
            return false;
        }
        MolocoAdError molocoAdError = (MolocoAdError) obj;
        return t.d(this.networkName, molocoAdError.networkName) && t.d(this.adUnitId, molocoAdError.adUnitId) && this.errorType == molocoAdError.errorType && t.d(this.description, molocoAdError.description);
    }

    @NotNull
    public final String getAdUnitId() {
        return this.adUnitId;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final ErrorType getErrorType() {
        return this.errorType;
    }

    @NotNull
    public final String getNetworkName() {
        return this.networkName;
    }

    public int hashCode() {
        return (((((this.networkName.hashCode() * 31) + this.adUnitId.hashCode()) * 31) + this.errorType.hashCode()) * 31) + this.description.hashCode();
    }

    @NotNull
    public String toString() {
        return "MolocoAdError(networkName=" + this.networkName + ", adUnitId=" + this.adUnitId + ", errorType=" + this.errorType + ", description=" + this.description + ')';
    }

    public /* synthetic */ MolocoAdError(String str, String str2, ErrorType errorType, String str3, int i10, k kVar) {
        this(str, str2, errorType, (i10 & 8) != 0 ? errorType.getDescription() : str3);
    }
}
