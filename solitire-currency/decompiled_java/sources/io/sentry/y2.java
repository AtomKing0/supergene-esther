package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpSentryClient.java */
/* JADX INFO: loaded from: classes5.dex */
final class y2 implements i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final y2 f28502a = new y2();

    private y2() {
    }

    public static y2 p() {
        return f28502a;
    }

    @Override // io.sentry.i1
    @NotNull
    public SentryId a(@NotNull SentryTransaction sentryTransaction, @Nullable v8 v8Var, @Nullable c1 c1Var, @Nullable l0 l0Var, @Nullable x3 x3Var) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.i1
    public /* synthetic */ SentryId c(r6 r6Var, c1 c1Var) {
        return h1.a(this, r6Var, c1Var);
    }

    @Override // io.sentry.i1
    public /* synthetic */ boolean d() {
        return h1.c(this);
    }

    @Override // io.sentry.i1
    @Nullable
    public io.sentry.transport.b0 e() {
        return null;
    }

    @Override // io.sentry.i1
    @NotNull
    public SentryId h(@NotNull Feedback feedback, @Nullable l0 l0Var, @NotNull c1 c1Var) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.i1
    public SentryId i(@NotNull p5 p5Var, @Nullable l0 l0Var) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.i1
    public boolean isEnabled() {
        return false;
    }

    @Override // io.sentry.i1
    @ApiStatus.Experimental
    @NotNull
    public SentryId l(@NotNull f fVar, @Nullable c1 c1Var, @Nullable l0 l0Var) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.i1
    public /* synthetic */ SentryId m(String str, SentryLevel sentryLevel, c1 c1Var) {
        return h1.b(this, str, sentryLevel, c1Var);
    }

    @Override // io.sentry.i1
    @NotNull
    public SentryId n(@NotNull t3 t3Var, @Nullable c1 c1Var) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.i1
    @NotNull
    public SentryId o(@NotNull r6 r6Var, @Nullable c1 c1Var, @Nullable l0 l0Var) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.i1
    public void b(boolean z10) {
    }

    @Override // io.sentry.i1
    public void f(long j10) {
    }

    @Override // io.sentry.i1
    public void j(@NotNull c9 c9Var) {
    }

    @Override // io.sentry.i1
    @ApiStatus.Internal
    public void k(@NotNull f7 f7Var) {
    }

    @Override // io.sentry.i1
    public void g(@NotNull e8 e8Var, @Nullable l0 l0Var) {
    }
}
