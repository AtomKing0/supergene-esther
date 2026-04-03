package io.sentry.android.core;

import android.net.TrafficStats;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AndroidSocketTagger.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class g0 implements io.sentry.m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g0 f27194a = new g0();

    private g0() {
    }

    public static g0 c() {
        return f27194a;
    }

    @Override // io.sentry.m1
    public void a() {
        TrafficStats.clearThreadStatsTag();
    }

    @Override // io.sentry.m1
    public void b() {
        TrafficStats.setThreadStatsTag(61441);
    }
}
