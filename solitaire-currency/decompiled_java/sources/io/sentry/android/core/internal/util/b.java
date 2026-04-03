package io.sentry.android.core.internal.util;

import android.os.SystemClock;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AndroidCurrentDateProvider.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class b implements io.sentry.transport.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final io.sentry.transport.p f27298a = new b();

    private b() {
    }

    public static io.sentry.transport.p b() {
        return f27298a;
    }

    @Override // io.sentry.transport.p
    public long a() {
        return SystemClock.uptimeMillis();
    }
}
