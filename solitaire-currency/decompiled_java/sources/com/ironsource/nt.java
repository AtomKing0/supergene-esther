package com.ironsource;

/* JADX INFO: loaded from: classes4.dex */
public class nt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f14177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f14178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f14179c;

    public long a() {
        return Math.max(0L, this.f14177a - System.currentTimeMillis());
    }

    public void b() {
        this.f14177a = 0L;
        this.f14178b = 0L;
        this.f14179c = 0L;
    }

    public void c(long j10) {
        this.f14178b = j10;
        this.f14179c = 0L;
    }

    public void a(long j10) {
        this.f14177a = System.currentTimeMillis() + j10;
    }

    public void b(long j10) {
        this.f14179c = j10;
        this.f14177a += j10 - this.f14178b;
    }
}
