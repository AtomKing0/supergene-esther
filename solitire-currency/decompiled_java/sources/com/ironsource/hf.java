package com.ironsource;

/* JADX INFO: loaded from: classes4.dex */
public class hf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12479c;

    public hf() {
        this.f12477a = 0;
        this.f12478b = 0;
        this.f12479c = "";
    }

    public int a() {
        return this.f12478b;
    }

    public String b() {
        return this.f12479c;
    }

    public int c() {
        return this.f12477a;
    }

    public boolean d() {
        return this.f12478b > 0 && this.f12477a > 0;
    }

    public boolean e() {
        return this.f12478b == 0 && this.f12477a == 0;
    }

    public String toString() {
        return this.f12479c;
    }

    public hf(int i10, int i11, String str) {
        this.f12477a = i10;
        this.f12478b = i11;
        this.f12479c = str;
    }
}
