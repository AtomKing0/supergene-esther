package com.applovin.impl;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f5058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f5059d;

    public e(String str, String str2) {
        this(str, str2, null, false);
    }

    public String a() {
        return this.f5057b;
    }

    public Map b() {
        return this.f5058c;
    }

    public String c() {
        return this.f5056a;
    }

    public boolean d() {
        return this.f5059d;
    }

    public String toString() {
        return "AdEventPostback{url='" + this.f5056a + "', backupUrl='" + this.f5057b + "', headers='" + this.f5058c + "', shouldFireInWebView='" + this.f5059d + "'}";
    }

    public e(String str, String str2, Map map, boolean z10) {
        this.f5056a = str;
        this.f5057b = str2;
        this.f5058c = map;
        this.f5059d = z10;
    }
}
