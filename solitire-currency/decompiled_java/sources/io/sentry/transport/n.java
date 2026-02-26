package io.sentry.transport;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: CurrentDateProvider.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class n implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p f28290a = new n();

    private n() {
    }

    public static p b() {
        return f28290a;
    }

    @Override // io.sentry.transport.p
    public final long a() {
        return System.currentTimeMillis();
    }
}
