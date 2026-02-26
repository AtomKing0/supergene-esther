package io.sentry.util.thread;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NoOpThreadChecker.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f28370a = new b();

    public static b d() {
        return f28370a;
    }

    @Override // io.sentry.util.thread.a
    public boolean a() {
        return false;
    }

    @Override // io.sentry.util.thread.a
    @NotNull
    public String b() {
        return "";
    }

    @Override // io.sentry.util.thread.a
    public long c() {
        return 0L;
    }
}
