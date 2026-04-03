package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultVersionDetector.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class t implements s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28227a;

    public t(@NotNull SentryOptions sentryOptions) {
        this.f28227a = sentryOptions;
    }

    @Override // io.sentry.s1
    public boolean a() {
        return a7.d().c(this.f28227a.getFatalLogger());
    }
}
