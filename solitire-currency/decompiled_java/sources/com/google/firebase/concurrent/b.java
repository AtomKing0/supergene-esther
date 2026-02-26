package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: CustomThreadFactory.java */
/* JADX INFO: loaded from: classes3.dex */
class b implements ThreadFactory {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ThreadFactory f10244e = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f10245a = new AtomicLong();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StrictMode.ThreadPolicy f10248d;

    b(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        this.f10246b = str;
        this.f10247c = i10;
        this.f10248d = threadPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        Process.setThreadPriority(this.f10247c);
        StrictMode.ThreadPolicy threadPolicy = this.f10248d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f10244e.newThread(new Runnable() { // from class: com.google.firebase.concurrent.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f10242a.b(runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f10246b, Long.valueOf(this.f10245a.getAndIncrement())));
        return threadNewThread;
    }
}
