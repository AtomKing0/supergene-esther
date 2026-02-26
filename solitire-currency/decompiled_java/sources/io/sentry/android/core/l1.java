package io.sentry.android.core;

import android.os.FileObserver;
import io.sentry.SentryLevel;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EnvelopeFileObserver.java */
/* JADX INFO: loaded from: classes5.dex */
final class l1 extends FileObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final io.sentry.u0 f27396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.w0 f27397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f27398d;

    /* JADX INFO: compiled from: EnvelopeFileObserver.java */
    private static final class a implements io.sentry.hints.e, io.sentry.hints.k, io.sentry.hints.p, io.sentry.hints.i, io.sentry.hints.b, io.sentry.hints.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f27399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f27400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private CountDownLatch f27401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f27402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private final io.sentry.w0 f27403e;

        public a(long j10, @NotNull io.sentry.w0 w0Var) {
            reset();
            this.f27402d = j10;
            this.f27403e = (io.sentry.w0) io.sentry.util.w.c(w0Var, "ILogger is required.");
        }

        @Override // io.sentry.hints.k
        public boolean a() {
            return this.f27399a;
        }

        @Override // io.sentry.hints.p
        public void c(boolean z10) {
            this.f27400b = z10;
            this.f27401c.countDown();
        }

        @Override // io.sentry.hints.k
        public void d(boolean z10) {
            this.f27399a = z10;
        }

        @Override // io.sentry.hints.i
        public boolean g() {
            try {
                return this.f27401c.await(this.f27402d, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                this.f27403e.b(SentryLevel.ERROR, "Exception while awaiting on lock.", e10);
                return false;
            }
        }

        @Override // io.sentry.hints.p
        public boolean isSuccess() {
            return this.f27400b;
        }

        @Override // io.sentry.hints.j
        public void reset() {
            this.f27401c = new CountDownLatch(1);
            this.f27399a = false;
            this.f27400b = false;
        }
    }

    l1(String str, io.sentry.u0 u0Var, @NotNull io.sentry.w0 w0Var, long j10) {
        super(str);
        this.f27395a = str;
        this.f27396b = (io.sentry.u0) io.sentry.util.w.c(u0Var, "Envelope sender is required.");
        this.f27397c = (io.sentry.w0) io.sentry.util.w.c(w0Var, "Logger is required.");
        this.f27398d = j10;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i10, @Nullable String str) {
        if (str == null || i10 != 8) {
            return;
        }
        this.f27397c.c(SentryLevel.DEBUG, "onEvent fired for EnvelopeFileObserver with event type %d on path: %s for file %s.", Integer.valueOf(i10), this.f27395a, str);
        io.sentry.l0 l0VarE = io.sentry.util.m.e(new a(this.f27398d, this.f27397c));
        this.f27396b.a(this.f27395a + File.separator + str, l0VarE);
    }
}
