package com.onetrust.otpublishers.headless.Public.Response;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class OTResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22028d;

    public OTResponse(@NonNull String str, int i10, @NonNull String str2, @Nullable String str3) {
        this.f22025a = str;
        this.f22026b = i10;
        this.f22027c = str2;
        this.f22028d = str3;
    }

    public int getResponseCode() {
        return this.f22026b;
    }

    @Nullable
    public String getResponseData() {
        return this.f22028d;
    }

    @NonNull
    public String getResponseMessage() {
        return this.f22027c;
    }

    @NonNull
    public String getResponseType() {
        return this.f22025a;
    }

    @NonNull
    public String toString() {
        return "OTResponse{responseType='" + this.f22025a + "', responseCode=" + this.f22026b + ", responseMessage='" + this.f22027c + "', responseData='" + this.f22028d + "'}";
    }
}
