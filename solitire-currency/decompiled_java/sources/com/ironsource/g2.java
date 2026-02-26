package com.ironsource;

/* JADX INFO: loaded from: classes4.dex */
public class g2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12201e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12205d;

    public enum a {
        MANUAL,
        MANUAL_WITH_AUTOMATIC_RELOAD,
        MANUAL_WITH_LOAD_ON_SHOW,
        AUTOMATIC_LOAD_AFTER_CLOSE,
        AUTOMATIC_LOAD_WHILE_SHOW
    }

    public g2(a aVar, long j10, long j11, long j12) {
        this.f12202a = aVar;
        this.f12203b = j10;
        this.f12204c = j11;
        this.f12205d = j12;
    }

    public a a() {
        return this.f12202a;
    }

    public long b() {
        return this.f12205d;
    }

    public long c() {
        return this.f12204c;
    }

    public long d() {
        return this.f12203b;
    }

    public boolean e() {
        a aVar = this.f12202a;
        return aVar == a.AUTOMATIC_LOAD_AFTER_CLOSE || aVar == a.AUTOMATIC_LOAD_WHILE_SHOW;
    }

    public boolean f() {
        a aVar = this.f12202a;
        return aVar == a.MANUAL || aVar == a.MANUAL_WITH_AUTOMATIC_RELOAD || aVar == a.MANUAL_WITH_LOAD_ON_SHOW;
    }
}
