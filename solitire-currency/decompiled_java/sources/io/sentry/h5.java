package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SentryAutoDateProvider.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class h5 implements o5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final o5 f27848a;

    public h5() {
        if (b()) {
            this.f27848a = new z6();
        } else {
            this.f27848a = new j7();
        }
    }

    private static boolean b() {
        return io.sentry.util.y.c() && io.sentry.util.y.b();
    }

    @Override // io.sentry.o5
    @NotNull
    public n5 a() {
        return this.f27848a.a();
    }
}
