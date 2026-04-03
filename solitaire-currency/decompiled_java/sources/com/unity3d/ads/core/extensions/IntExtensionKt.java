package com.unity3d.ads.core.extensions;

import androidx.compose.ui.graphics.Float16;
import androidx.media3.common.C;
import com.applovin.sdk.AppLovinErrorCodes;
import com.unity3d.ads.adplayer.model.ErrorReason;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IntExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IntExtensionKt {
    @NotNull
    public static final ErrorReason webResourceToErrorReason(int i10) {
        switch (i10) {
            case -16:
                return ErrorReason.REASON_WEB_ERROR_UNSAFE_RESOURCE;
            case -15:
                return ErrorReason.REASON_WEB_ERROR_TOO_MANY_REQUESTS;
            case Float16.MinExponent /* -14 */:
                return ErrorReason.REASON_WEB_ERROR_FILE_NOT_FOUND;
            case -13:
                return ErrorReason.REASON_WEB_ERROR_FILE;
            case -12:
                return ErrorReason.REASON_WEB_ERROR_BAD_URL;
            case -11:
                return ErrorReason.REASON_WEB_ERROR_FAILED_SSL_HANDSHAKE;
            case -10:
                return ErrorReason.REASON_WEB_ERROR_UNSUPPORTED_SCHEME;
            case -9:
                return ErrorReason.REASON_WEB_ERROR_REDIRECT_LOOP;
            case AppLovinErrorCodes.INVALID_AD_TOKEN /* -8 */:
                return ErrorReason.REASON_WEB_ERROR_TIMEOUT;
            case AppLovinErrorCodes.INVALID_ZONE /* -7 */:
                return ErrorReason.REASON_WEB_ERROR_IO;
            case AppLovinErrorCodes.UNABLE_TO_RENDER_AD /* -6 */:
                return ErrorReason.REASON_WEB_ERROR_CONNECT;
            case C.RESULT_FORMAT_READ /* -5 */:
                return ErrorReason.REASON_WEB_ERROR_PROXY_AUTHENTICATION;
            case -4:
                return ErrorReason.REASON_WEB_ERROR_AUTHENTICATION;
            case -3:
                return ErrorReason.REASON_WEB_ERROR_UNSUPPORTED_AUTH_SCHEME;
            case -2:
                return ErrorReason.REASON_WEB_ERROR_HOST_LOOKUP;
            case -1:
                return ErrorReason.REASON_WEB_ERROR_UNKNOWN;
            default:
                return ErrorReason.REASON_UNKNOWN;
        }
    }
}
