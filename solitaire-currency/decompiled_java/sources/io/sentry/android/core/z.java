package io.sentry.android.core;

import android.os.Debug;
import io.sentry.i7;
import io.sentry.r3;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidMemoryCollector.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class z implements io.sentry.a1 {
    @Override // io.sentry.a1
    public void d(@NotNull r3 r3Var) {
        r3Var.b(new io.sentry.m2(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(), Debug.getNativeHeapSize() - Debug.getNativeHeapFreeSize(), new i7()));
    }

    @Override // io.sentry.a1
    public void c() {
    }
}
