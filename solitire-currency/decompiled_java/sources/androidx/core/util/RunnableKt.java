package androidx.core.util;

import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Runnable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableKt {
    @NotNull
    public static final Runnable asRunnable(@NotNull z8.d<? super k0> dVar) {
        return new ContinuationRunnable(dVar);
    }
}
