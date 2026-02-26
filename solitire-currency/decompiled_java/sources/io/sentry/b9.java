package io.sentry;

import java.lang.Thread;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UncaughtExceptionHandler.java */
/* JADX INFO: loaded from: classes5.dex */
interface b9 {

    /* JADX INFO: compiled from: UncaughtExceptionHandler.java */
    public static final class a implements b9 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f27620a = new a();

        private a() {
        }

        static b9 c() {
            return f27620a;
        }

        @Override // io.sentry.b9
        public void a(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }

        @Override // io.sentry.b9
        public Thread.UncaughtExceptionHandler b() {
            return Thread.getDefaultUncaughtExceptionHandler();
        }
    }

    void a(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler);

    Thread.UncaughtExceptionHandler b();
}
