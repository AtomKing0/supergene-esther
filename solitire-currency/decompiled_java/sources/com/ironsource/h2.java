package com.ironsource;

/* JADX INFO: loaded from: classes4.dex */
public class h2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12365e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12369d;

    public enum a {
        MANUAL,
        MANUAL_WITH_AUTOMATIC_RELOAD,
        AUTOMATIC_LOAD_AFTER_CLOSE,
        AUTOMATIC_LOAD_WHILE_SHOW
    }

    public h2(a aVar, long j10, long j11, long j12) {
        this.f12366a = aVar;
        this.f12367b = j10;
        this.f12368c = j11;
        this.f12369d = j12;
    }

    public a a() {
        return this.f12366a;
    }

    public long b() {
        return this.f12369d;
    }

    public long c() {
        return this.f12368c;
    }

    public long d() {
        return this.f12367b;
    }

    public boolean e() {
        a aVar = this.f12366a;
        return aVar == a.AUTOMATIC_LOAD_AFTER_CLOSE || aVar == a.AUTOMATIC_LOAD_WHILE_SHOW;
    }

    public boolean f() {
        a aVar = this.f12366a;
        return aVar == a.MANUAL || aVar == a.MANUAL_WITH_AUTOMATIC_RELOAD;
    }
}
