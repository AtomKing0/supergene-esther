package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TracesSampler.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class w8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28457a;

    public w8(@NotNull SentryOptions sentryOptions) {
        this.f28457a = (SentryOptions) io.sentry.util.w.c(sentryOptions, "options are required");
    }

    private boolean b(@NotNull Double d10, @NotNull Double d11) {
        return d10.doubleValue() >= d11.doubleValue();
    }

    @NotNull
    public x8 a(@NotNull e4 e4Var) {
        Double dA = e4Var.a();
        x8 x8VarJ = e4Var.b().j();
        if (x8VarJ != null) {
            return io.sentry.util.a0.a(x8VarJ);
        }
        this.f28457a.getProfilesSampler();
        Double profilesSampleRate = this.f28457a.getProfilesSampleRate();
        Boolean boolValueOf = Boolean.valueOf(profilesSampleRate != null && b(profilesSampleRate, dA));
        this.f28457a.getTracesSampler();
        x8 x8VarX = e4Var.b().x();
        if (x8VarX != null) {
            return io.sentry.util.a0.a(x8VarX);
        }
        Double tracesSampleRate = this.f28457a.getTracesSampleRate();
        Double dValueOf = tracesSampleRate == null ? null : Double.valueOf(tracesSampleRate.doubleValue() / Double.valueOf(Math.pow(2.0d, this.f28457a.getBackpressureMonitor().a())).doubleValue());
        if (dValueOf != null) {
            return new x8(Boolean.valueOf(b(dValueOf, dA)), dValueOf, dA, boolValueOf, profilesSampleRate);
        }
        Boolean bool = Boolean.FALSE;
        return new x8(bool, null, dA, bool, null);
    }

    public boolean c(double d10) {
        Double profileSessionSampleRate = this.f28457a.getProfileSessionSampleRate();
        return profileSessionSampleRate != null && b(profileSessionSampleRate, Double.valueOf(d10));
    }
}
