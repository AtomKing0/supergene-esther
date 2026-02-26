package androidx.compose.ui.text.platform;

import h9.a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Synchronization.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Synchronization_jvmKt {
    @NotNull
    public static final SynchronizedObject createSynchronizedObject() {
        return new SynchronizedObject();
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m3527synchronized(@NotNull SynchronizedObject lock, @NotNull a<? extends R> block) {
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
