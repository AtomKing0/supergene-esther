package io.sentry.hints;

import io.sentry.SentryLevel;
import io.sentry.w0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BlockingFlushHint.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public abstract class d implements f, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CountDownLatch f27852a = new CountDownLatch(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f27853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final w0 f27854c;

    public d(long j10, @NotNull w0 w0Var) {
        this.f27853b = j10;
        this.f27854c = w0Var;
    }

    @Override // io.sentry.hints.f
    public void d() {
        this.f27852a.countDown();
    }

    @Override // io.sentry.hints.i
    public boolean g() {
        try {
            return this.f27852a.await(this.f27853b, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            this.f27854c.b(SentryLevel.ERROR, "Exception while awaiting for flush in BlockingFlushHint", e10);
            return false;
        }
    }
}
