package io.sentry;

import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NoOpContinuousProfiler.java */
/* JADX INFO: loaded from: classes5.dex */
public final class p2 implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p2 f28040a = new p2();

    private p2() {
    }

    public static p2 a() {
        return f28040a;
    }

    @Override // io.sentry.s0
    @NotNull
    public SentryId f() {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.s0
    public boolean isRunning() {
        return false;
    }

    @Override // io.sentry.s0
    public void d() {
    }

    @Override // io.sentry.s0
    public void b(boolean z10) {
    }

    @Override // io.sentry.s0
    public void e(@NotNull v3 v3Var) {
    }

    @Override // io.sentry.s0
    public void c(@NotNull v3 v3Var, @NotNull w8 w8Var) {
    }
}
