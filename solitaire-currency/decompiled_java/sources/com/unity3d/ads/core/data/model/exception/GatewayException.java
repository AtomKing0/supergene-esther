package com.unity3d.ads.core.data.model.exception;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GatewayException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GatewayException extends Exception {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String GATEWAY_RESPONSE_DEPTH_INITIALIZATION = "initialization";

    @NotNull
    public static final String GATEWAY_RESPONSE_DEPTH_UNIVERSAL = "universal";

    @NotNull
    private final String message;

    @NotNull
    private final String reason;

    @Nullable
    private final String reasonDebug;

    @Nullable
    private final Throwable throwable;

    /* JADX INFO: compiled from: GatewayException.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public /* synthetic */ GatewayException(String str, Throwable th, String str2, String str3, int i10, k kVar) {
        this(str, (i10 & 2) != 0 ? null : th, (i10 & 4) != 0 ? "gateway" : str2, (i10 & 8) != 0 ? null : str3);
    }

    public static /* synthetic */ GatewayException copy$default(GatewayException gatewayException, String str, Throwable th, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = gatewayException.getMessage();
        }
        if ((i10 & 2) != 0) {
            th = gatewayException.throwable;
        }
        if ((i10 & 4) != 0) {
            str2 = gatewayException.reason;
        }
        if ((i10 & 8) != 0) {
            str3 = gatewayException.reasonDebug;
        }
        return gatewayException.copy(str, th, str2, str3);
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
    public final GatewayException copy(@NotNull String message, @Nullable Throwable th, @NotNull String reason, @Nullable String str) {
        t.i(message, "message");
        t.i(reason, "reason");
        return new GatewayException(message, th, reason, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GatewayException)) {
            return false;
        }
        GatewayException gatewayException = (GatewayException) obj;
        return t.d(getMessage(), gatewayException.getMessage()) && t.d(this.throwable, gatewayException.throwable) && t.d(this.reason, gatewayException.reason) && t.d(this.reasonDebug, gatewayException.reasonDebug);
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
        return "GatewayException(message=" + getMessage() + ", throwable=" + this.throwable + ", reason=" + this.reason + ", reasonDebug=" + this.reasonDebug + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayException(@NotNull String message, @Nullable Throwable th, @NotNull String reason, @Nullable String str) {
        super(message);
        t.i(message, "message");
        t.i(reason, "reason");
        this.message = message;
        this.throwable = th;
        this.reason = reason;
        this.reasonDebug = str;
    }
}
