package androidx.compose.runtime;

import h9.p;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ActualJvm.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActualJvm_jvmKt {
    public static final void ensureMutable(@NotNull Object it) {
        t.i(it, "it");
    }

    public static final int identityHashCode(@Nullable Object obj) {
        return System.identityHashCode(obj);
    }

    public static final void invokeComposable(@NotNull Composer composer, @NotNull p<? super Composer, ? super Integer, k0> composable) {
        t.i(composer, "composer");
        t.i(composable, "composable");
        ((p) t0.f(composable, 2)).mo4invoke(composer, 1);
    }

    public static final <T> T invokeComposableForResult(@NotNull Composer composer, @NotNull p<? super Composer, ? super Integer, ? extends T> composable) {
        t.i(composer, "composer");
        t.i(composable, "composable");
        return (T) ((p) t0.f(composable, 2)).mo4invoke(composer, 1);
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m1243synchronized(@NotNull Object lock, @NotNull h9.a<? extends R> block) {
        R rInvoke;
        t.i(lock, "lock");
        t.i(block, "block");
        synchronized (lock) {
            try {
                rInvoke = block.invoke();
                r.b(1);
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
        r.a(1);
        return rInvoke;
    }
}
