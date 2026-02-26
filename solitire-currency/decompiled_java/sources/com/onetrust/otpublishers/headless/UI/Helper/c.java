package com.onetrust.otpublishers.headless.UI.Helper;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends com.onetrust.otpublishers.headless.UI.UIProperty.f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22152o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f22153p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f22154q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.f f22155r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f22156s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f22157t = 8;

    @Override // com.onetrust.otpublishers.headless.UI.UIProperty.f
    @NonNull
    public final String a() {
        String str = this.f22764g;
        return str == null ? "" : str;
    }

    @Override // com.onetrust.otpublishers.headless.UI.UIProperty.f
    public final void b(int i10) {
        this.f22152o = i10;
    }

    @Override // com.onetrust.otpublishers.headless.UI.UIProperty.f
    @NonNull
    public final String c() {
        String str = this.f22760c;
        return str != null ? str : "#E8E8E8";
    }

    @Override // com.onetrust.otpublishers.headless.UI.UIProperty.f
    public final int d() {
        return this.f22152o;
    }
}
