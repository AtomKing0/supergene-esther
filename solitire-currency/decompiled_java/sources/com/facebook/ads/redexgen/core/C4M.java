package com.facebook.ads.redexgen.core;

import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4M, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C4M<R, E extends Exception> implements RunnableFuture<R> {
    public Exception A00;
    public R A01;
    public Thread A02;
    public boolean A03;
    public final C3W A05 = new C3W();
    public final C3W A04 = new C3W();
    public final Object A06 = new Object();

    public abstract R A01() throws Exception;

    public abstract void A03();

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4M != com.facebook.ads.androidx.media3.common.util.RunnableFutureTask<R, E extends java.lang.Exception> */
    private R A00() throws ExecutionException {
        if (!this.A03) {
            if (this.A00 == null) {
                return this.A01;
            }
            throw new ExecutionException(this.A00);
        }
        throw new CancellationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4M != com.facebook.ads.androidx.media3.common.util.RunnableFutureTask<R, E extends java.lang.Exception> */
    public final void A02() {
        this.A04.A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4M != com.facebook.ads.androidx.media3.common.util.RunnableFutureTask<R, E extends java.lang.Exception> */
    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        synchronized (this.A06) {
            if (this.A03 || this.A04.A03()) {
                return false;
            }
            this.A03 = true;
            A03();
            Thread thread = this.A02;
            if (thread != null) {
                if (z10) {
                    thread.interrupt();
                }
            } else {
                this.A05.A04();
                this.A04.A04();
            }
            return true;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4M != com.facebook.ads.androidx.media3.common.util.RunnableFutureTask<R, E extends java.lang.Exception> */
    @Override // java.util.concurrent.Future
    public final R get() throws ExecutionException, InterruptedException {
        this.A04.A00();
        return A00();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4M != com.facebook.ads.androidx.media3.common.util.RunnableFutureTask<R, E extends java.lang.Exception> */
    @Override // java.util.concurrent.Future
    public final R get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.A04.A05(TimeUnit.MILLISECONDS.convert(j10, timeUnit))) {
            return A00();
        }
        throw new TimeoutException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4M != com.facebook.ads.androidx.media3.common.util.RunnableFutureTask<R, E extends java.lang.Exception> */
    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.A03;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4M != com.facebook.ads.androidx.media3.common.util.RunnableFutureTask<R, E extends java.lang.Exception> */
    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.A04.A03();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4M != com.facebook.ads.androidx.media3.common.util.RunnableFutureTask<R, E extends java.lang.Exception> */
    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            synchronized (this.A06) {
                try {
                    if (this.A03) {
                        try {
                            return;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                    this.A02 = Thread.currentThread();
                    this.A05.A04();
                    try {
                        try {
                            this.A01 = A01();
                            synchronized (this.A06) {
                                try {
                                    this.A04.A04();
                                    this.A02 = null;
                                    Thread.interrupted();
                                } catch (Throwable th2) {
                                    th = th2;
                                    while (true) {
                                        try {
                                            throw th;
                                        } catch (Throwable th3) {
                                        }
                                    }
                                }
                            }
                        } catch (Exception e10) {
                            this.A00 = e10;
                            synchronized (this.A06) {
                                try {
                                    this.A04.A04();
                                    this.A02 = null;
                                    Thread.interrupted();
                                } finally {
                                    th = th;
                                    while (true) {
                                        try {
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        synchronized (this.A06) {
                            this.A04.A04();
                            this.A02 = null;
                            Thread.interrupted();
                            throw th5;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        } catch (Throwable th7) {
            AbstractC2066Vl.A00(th7, this);
        }
    }
}
