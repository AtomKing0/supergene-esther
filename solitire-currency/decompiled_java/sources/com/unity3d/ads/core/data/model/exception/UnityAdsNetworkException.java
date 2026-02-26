package com.unity3d.ads.core.data.model.exception;

import com.unity3d.ads.core.data.model.OperationType;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UnityAdsNetworkException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UnityAdsNetworkException extends Exception {

    @Nullable
    private final String client;

    @Nullable
    private final Integer code;

    @Nullable
    private final Integer cronetCode;

    @NotNull
    private final String message;

    @Nullable
    private final String protocol;

    @NotNull
    private final OperationType type;

    @Nullable
    private final String url;

    public /* synthetic */ UnityAdsNetworkException(String str, OperationType operationType, Integer num, String str2, String str3, Integer num2, String str4, int i10, k kVar) {
        this(str, (i10 & 2) != 0 ? OperationType.UNKNOWN : operationType, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : num2, (i10 & 64) == 0 ? str4 : null);
    }

    public static /* synthetic */ UnityAdsNetworkException copy$default(UnityAdsNetworkException unityAdsNetworkException, String str, OperationType operationType, Integer num, String str2, String str3, Integer num2, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = unityAdsNetworkException.getMessage();
        }
        if ((i10 & 2) != 0) {
            operationType = unityAdsNetworkException.type;
        }
        OperationType operationType2 = operationType;
        if ((i10 & 4) != 0) {
            num = unityAdsNetworkException.code;
        }
        Integer num3 = num;
        if ((i10 & 8) != 0) {
            str2 = unityAdsNetworkException.url;
        }
        String str5 = str2;
        if ((i10 & 16) != 0) {
            str3 = unityAdsNetworkException.protocol;
        }
        String str6 = str3;
        if ((i10 & 32) != 0) {
            num2 = unityAdsNetworkException.cronetCode;
        }
        Integer num4 = num2;
        if ((i10 & 64) != 0) {
            str4 = unityAdsNetworkException.client;
        }
        return unityAdsNetworkException.copy(str, operationType2, num3, str5, str6, num4, str4);
    }

    @NotNull
    public final String component1() {
        return getMessage();
    }

    @NotNull
    public final OperationType component2() {
        return this.type;
    }

    @Nullable
    public final Integer component3() {
        return this.code;
    }

    @Nullable
    public final String component4() {
        return this.url;
    }

    @Nullable
    public final String component5() {
        return this.protocol;
    }

    @Nullable
    public final Integer component6() {
        return this.cronetCode;
    }

    @Nullable
    public final String component7() {
        return this.client;
    }

    @NotNull
    public final UnityAdsNetworkException copy(@NotNull String message, @NotNull OperationType type, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Integer num2, @Nullable String str3) {
        t.i(message, "message");
        t.i(type, "type");
        return new UnityAdsNetworkException(message, type, num, str, str2, num2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnityAdsNetworkException)) {
            return false;
        }
        UnityAdsNetworkException unityAdsNetworkException = (UnityAdsNetworkException) obj;
        return t.d(getMessage(), unityAdsNetworkException.getMessage()) && this.type == unityAdsNetworkException.type && t.d(this.code, unityAdsNetworkException.code) && t.d(this.url, unityAdsNetworkException.url) && t.d(this.protocol, unityAdsNetworkException.protocol) && t.d(this.cronetCode, unityAdsNetworkException.cronetCode) && t.d(this.client, unityAdsNetworkException.client);
    }

    @Nullable
    public final String getClient() {
        return this.client;
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final Integer getCronetCode() {
        return this.cronetCode;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getProtocol() {
        return this.protocol;
    }

    @NotNull
    public final OperationType getType() {
        return this.type;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = ((getMessage().hashCode() * 31) + this.type.hashCode()) * 31;
        Integer num = this.code;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.url;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.protocol;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.cronetCode;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.client;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        return "UnityAdsNetworkException(message=" + getMessage() + ", type=" + this.type + ", code=" + this.code + ", url=" + this.url + ", protocol=" + this.protocol + ", cronetCode=" + this.cronetCode + ", client=" + this.client + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnityAdsNetworkException(@NotNull String message, @NotNull OperationType type, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Integer num2, @Nullable String str3) {
        super(message);
        t.i(message, "message");
        t.i(type, "type");
        this.message = message;
        this.type = type;
        this.code = num;
        this.url = str;
        this.protocol = str2;
        this.cronetCode = num2;
        this.client = str3;
    }
}
