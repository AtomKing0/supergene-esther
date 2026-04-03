package io.sentry;

import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import java.io.IOException;
import java.util.ArrayList;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryEnvelope.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class p5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final q5 f28043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Iterable<p6> f28044b;

    public p5(@NotNull q5 q5Var, @NotNull Iterable<p6> iterable) {
        this.f28043a = (q5) io.sentry.util.w.c(q5Var, "SentryEnvelopeHeader is required.");
        this.f28044b = (Iterable) io.sentry.util.w.c(iterable, "SentryEnvelope items are required.");
    }

    @NotNull
    public static p5 a(@NotNull l1 l1Var, @NotNull e8 e8Var, @Nullable SdkVersion sdkVersion) throws IOException {
        io.sentry.util.w.c(l1Var, "Serializer is required.");
        io.sentry.util.w.c(e8Var, "session is required.");
        return new p5(null, sdkVersion, p6.F(l1Var, e8Var));
    }

    @NotNull
    public q5 b() {
        return this.f28043a;
    }

    @NotNull
    public Iterable<p6> c() {
        return this.f28044b;
    }

    public p5(@Nullable SentryId sentryId, @Nullable SdkVersion sdkVersion, @NotNull p6 p6Var) {
        io.sentry.util.w.c(p6Var, "SentryEnvelopeItem is required.");
        this.f28043a = new q5(sentryId, sdkVersion);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(p6Var);
        this.f28044b = arrayList;
    }
}
