package io.sentry.util;

import io.sentry.k1;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AutoClosableReentrantLock.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends ReentrantLock {

    /* JADX INFO: renamed from: io.sentry.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoClosableReentrantLock.java */
    static final class C0588a implements k1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ReentrantLock f28338a;

        C0588a(@NotNull ReentrantLock reentrantLock) {
            this.f28338a = reentrantLock;
        }

        @Override // io.sentry.k1, java.lang.AutoCloseable
        public void close() {
            this.f28338a.unlock();
        }
    }

    public k1 a() {
        lock();
        return new C0588a(this);
    }
}
