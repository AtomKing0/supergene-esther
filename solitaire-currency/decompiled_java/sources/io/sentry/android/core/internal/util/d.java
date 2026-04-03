package io.sentry.android.core.internal.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import io.sentry.protocol.SentryThread;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidThreadChecker.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class d implements io.sentry.util.thread.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f27299a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f27300b = Process.myTid();

    private d() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.internal.util.c
            @Override // java.lang.Runnable
            public final void run() {
                d.i();
            }
        });
    }

    public static d e() {
        return f27299a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i() {
        f27300b = Process.myTid();
    }

    @Override // io.sentry.util.thread.a
    public boolean a() {
        return h(Thread.currentThread());
    }

    @Override // io.sentry.util.thread.a
    @NotNull
    public String b() {
        return a() ? "main" : Thread.currentThread().getName();
    }

    @Override // io.sentry.util.thread.a
    public long c() {
        return Process.myTid();
    }

    public boolean f(long j10) {
        return Looper.getMainLooper().getThread().getId() == j10;
    }

    public boolean g(@NotNull SentryThread sentryThread) {
        Long id = sentryThread.getId();
        return id != null && f(id.longValue());
    }

    public boolean h(@NotNull Thread thread) {
        return f(thread.getId());
    }
}
