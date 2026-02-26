package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EventLoop.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n1 {
    @NotNull
    public static final k1 a() {
        return new h(Thread.currentThread());
    }

    public static final long b() {
        k1 k1VarA = b3.f29862a.a();
        if (k1VarA != null) {
            return k1VarA.R0();
        }
        return Long.MAX_VALUE;
    }
}
