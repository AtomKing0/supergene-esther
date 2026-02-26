package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ManifestVersionDetector.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class k2 implements s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27962a;

    public k2(@NotNull SentryOptions sentryOptions) {
        this.f27962a = sentryOptions;
    }

    @Override // io.sentry.s1
    public boolean a() throws Throwable {
        io.sentry.internal.a.a().b();
        return a7.d().c(this.f27962a.getFatalLogger());
    }
}
