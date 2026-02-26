package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JavaMemoryCollector.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class w1 implements a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Runtime f28451a = Runtime.getRuntime();

    @Override // io.sentry.a1
    public void d(@NotNull r3 r3Var) {
        r3Var.b(new m2(this.f28451a.totalMemory() - this.f28451a.freeMemory(), new i7()));
    }

    @Override // io.sentry.a1
    public void c() {
    }
}
