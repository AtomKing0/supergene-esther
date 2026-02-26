package com.ironsource;

/* JADX INFO: loaded from: classes4.dex */
public class rf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f14680c = 1001;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14682b;

    public rf(int i10, String str) {
        this.f14682b = i10;
        this.f14681a = str == null ? "" : str;
    }

    public int a() {
        return this.f14682b;
    }

    public String b() {
        return this.f14681a;
    }

    public String toString() {
        return "error - code:" + this.f14682b + ", message:" + this.f14681a;
    }
}
