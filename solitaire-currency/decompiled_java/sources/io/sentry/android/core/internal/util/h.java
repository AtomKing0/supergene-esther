package io.sentry.android.core.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Debouncer.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f27305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final io.sentry.transport.p f27306b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f27308d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final AtomicInteger f27307c = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final AtomicLong f27309e = new AtomicLong(0);

    public h(@NotNull io.sentry.transport.p pVar, long j10, int i10) {
        this.f27306b = pVar;
        this.f27305a = j10;
        this.f27308d = i10 <= 0 ? 1 : i10;
    }

    public boolean a() {
        long jA = this.f27306b.a();
        if (this.f27309e.get() == 0 || this.f27309e.get() + this.f27305a <= jA) {
            this.f27307c.set(0);
            this.f27309e.set(jA);
            return false;
        }
        if (this.f27307c.incrementAndGet() < this.f27308d) {
            return false;
        }
        this.f27307c.set(0);
        return true;
    }
}
