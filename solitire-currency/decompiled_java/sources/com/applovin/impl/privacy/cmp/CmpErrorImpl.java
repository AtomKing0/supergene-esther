package com.applovin.impl.privacy.cmp;

import com.applovin.sdk.AppLovinCmpError;

/* JADX INFO: loaded from: classes2.dex */
public class CmpErrorImpl implements AppLovinCmpError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppLovinCmpError.Code f6587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6590d;

    public CmpErrorImpl(AppLovinCmpError.Code code, String str) {
        this(code, str, -1, "");
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public int getCmpCode() {
        return this.f6589c;
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public String getCmpMessage() {
        return this.f6590d;
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public AppLovinCmpError.Code getCode() {
        return this.f6587a;
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public String getMessage() {
        return this.f6588b;
    }

    public String toString() {
        return "CmpErrorImpl(code=" + getCode() + ", message=" + getMessage() + ", cmpCode=" + getCmpCode() + ", cmpMessage=" + getCmpMessage() + ")";
    }

    public CmpErrorImpl(AppLovinCmpError.Code code, String str, int i10, String str2) {
        this.f6587a = code;
        this.f6588b = str;
        this.f6589c = i10;
        this.f6590d = str2;
    }
}
