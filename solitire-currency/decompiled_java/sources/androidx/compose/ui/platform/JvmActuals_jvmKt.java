package androidx.compose.ui.platform;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JvmActuals.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class JvmActuals_jvmKt {
    @NotNull
    public static final Object nativeClass(@NotNull Object obj) {
        kotlin.jvm.internal.t.i(obj, "<this>");
        return obj.getClass();
    }

    @NotNull
    public static final String simpleIdentityToString(@NotNull Object obj, @Nullable String str) {
        kotlin.jvm.internal.t.i(obj, "obj");
        if (str == null) {
            str = obj.getClass().isAnonymousClass() ? obj.getClass().getName() : obj.getClass().getSimpleName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('@');
        kotlin.jvm.internal.s0 s0Var = kotlin.jvm.internal.s0.f29840a;
        String str2 = String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1));
        kotlin.jvm.internal.t.h(str2, "format(format, *args)");
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m3188synchronized(@NotNull Object lock, @NotNull h9.a<? extends R> block) {
        R rInvoke;
        kotlin.jvm.internal.t.i(lock, "lock");
        kotlin.jvm.internal.t.i(block, "block");
        synchronized (lock) {
            try {
                rInvoke = block.invoke();
                kotlin.jvm.internal.r.b(1);
            } catch (Throwable th) {
                kotlin.jvm.internal.r.b(1);
                kotlin.jvm.internal.r.a(1);
                throw th;
            }
        }
        kotlin.jvm.internal.r.a(1);
        return rInvoke;
    }
}
