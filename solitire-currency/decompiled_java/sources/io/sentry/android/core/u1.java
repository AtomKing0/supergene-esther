package io.sentry.android.core;

import android.os.Handler;
import android.os.Looper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MainLooperHandler.java */
/* JADX INFO: loaded from: classes5.dex */
final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Handler f27536a;

    u1() {
        this(Looper.getMainLooper());
    }

    @NotNull
    public Thread a() {
        return this.f27536a.getLooper().getThread();
    }

    public void b(@NotNull Runnable runnable) {
        this.f27536a.post(runnable);
    }

    u1(@NotNull Looper looper) {
        this.f27536a = new Handler(looper);
    }
}
