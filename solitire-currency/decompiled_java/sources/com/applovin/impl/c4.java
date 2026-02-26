package com.applovin.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f4957c;

    c4(String str, String str2, Context context) {
        this.f4955a = str.replace("android.permission.", "");
        this.f4956b = str2;
        this.f4957c = k0.a(str, context);
    }

    public String a() {
        return this.f4956b;
    }

    public String b() {
        return this.f4955a;
    }

    public boolean c() {
        return this.f4957c;
    }
}
