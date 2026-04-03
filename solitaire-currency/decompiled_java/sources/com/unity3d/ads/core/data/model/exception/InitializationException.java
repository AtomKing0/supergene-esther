package com.unity3d.ads.core.data.model.exception;

import com.unity3d.ads.core.domain.InitializeAndroidBoldSDK;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.d3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InitializationException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializationException extends Exception {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final String message;

    @NotNull
    private final String reason;

    @Nullable
    private final String reasonDebug;

    @Nullable
    private final Throwable throwable;

    /* JADX INFO: compiled from: InitializationException.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final InitializationException parseFrom(@NotNull Exception e10) {
            t.i(e10, "e");
            if (e10 instanceof d3) {
                return new InitializationException(InitializeAndroidBoldSDK.MSG_TIMEOUT, e10, "timeout", e10.getMessage());
            }
            if (!(e10 instanceof UnityAdsNetworkException)) {
                if (!(e10 instanceof GatewayException)) {
                    return e10 instanceof InitializationException ? (InitializationException) e10 : new InitializationException(InitializeAndroidBoldSDK.MSG_UNKNOWN, e10, "unknown", e10.getMessage());
                }
                GatewayException gatewayException = (GatewayException) e10;
                return new InitializationException(InitializeAndroidBoldSDK.MSG_UNKNOWN, gatewayException.getThrowable(), gatewayException.getReason(), gatewayException.getReasonDebug());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("network.");
            UnityAdsNetworkException unityAdsNetworkException = (UnityAdsNetworkException) e10;
            sb.append(unityAdsNetworkException.getCode());
            return new InitializationException(InitializeAndroidBoldSDK.MSG_NETWORK, e10, sb.toString(), unityAdsNetworkException.getMessage());
        }
    }

    public /* synthetic */ InitializationException(String str, Throwable th, String str2, String str3, int i10, k kVar) {
        this(str, (i10 & 2) != 0 ? null : th, (i10 & 4) != 0 ? "gateway" : str2, (i10 & 8) != 0 ? null : str3);
    }

    public static /* synthetic */ InitializationException copy$default(InitializationException initializationException, String str, Throwable th, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = initializationException.getMessage();
        }
        if ((i10 & 2) != 0) {
            th = initializationException.throwable;
        }
        if ((i10 & 4) != 0) {
            str2 = initializationException.reason;
        }
        if ((i10 & 8) != 0) {
            str3 = initializationException.reasonDebug;
        }
        return initializationException.copy(str, th, str2, str3);
    }

    @NotNull
    public final String component1() {
        return getMessage();
    }

    @Nullable
    public final Throwable component2() {
        return this.throwable;
    }

    @NotNull
    public final String component3() {
        return this.reason;
    }

    @Nullable
    public final String component4() {
        return this.reasonDebug;
    }

    @NotNull
    public final InitializationException copy(@NotNull String message, @Nullable Throwable th, @NotNull String reason, @Nullable String str) {
        t.i(message, "message");
        t.i(reason, "reason");
        return new InitializationException(message, th, reason, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitializationException)) {
            return false;
        }
        InitializationException initializationException = (InitializationException) obj;
        return t.d(getMessage(), initializationException.getMessage()) && t.d(this.throwable, initializationException.throwable) && t.d(this.reason, initializationException.reason) && t.d(this.reasonDebug, initializationException.reasonDebug);
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getReason() {
        return this.reason;
    }

    @Nullable
    public final String getReasonDebug() {
        return this.reasonDebug;
    }

    @Nullable
    public final Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        int iHashCode = getMessage().hashCode() * 31;
        Throwable th = this.throwable;
        int iHashCode2 = (((iHashCode + (th == null ? 0 : th.hashCode())) * 31) + this.reason.hashCode()) * 31;
        String str = this.reasonDebug;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        return "InitializationException(message=" + getMessage() + ", throwable=" + this.throwable + ", reason=" + this.reason + ", reasonDebug=" + this.reasonDebug + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializationException(@NotNull String message, @Nullable Throwable th, @NotNull String reason, @Nullable String str) {
        super(message);
        t.i(message, "message");
        t.i(reason, "reason");
        this.message = message;
        this.throwable = th;
        this.reason = reason;
        this.reasonDebug = str;
    }
}
