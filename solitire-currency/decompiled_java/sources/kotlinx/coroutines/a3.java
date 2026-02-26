package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ThreadContextElement.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a3 {
    @NotNull
    public static final <T> z2<T> a(@NotNull ThreadLocal<T> threadLocal, T t10) {
        return new u9.m0(t10, threadLocal);
    }
}
