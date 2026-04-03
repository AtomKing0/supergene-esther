package io.sentry.android.core;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryFrameMetrics.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f27231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f27233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f27234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f27235e;

    public void a(long j10, long j11, boolean z10, boolean z11) {
        this.f27235e += j10;
        if (z11) {
            this.f27234d += j11;
            this.f27232b++;
        } else if (z10) {
            this.f27233c += j11;
            this.f27231a++;
        }
    }

    public int b() {
        return this.f27232b;
    }

    public long c() {
        return this.f27234d;
    }

    public int d() {
        return this.f27231a;
    }

    public long e() {
        return this.f27233c;
    }

    public int f() {
        return this.f27231a + this.f27232b;
    }

    public long g() {
        return this.f27235e;
    }
}
