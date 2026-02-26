package m9;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformThreadLocalRandom.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends l9.a {
    @Override // l9.c
    public int e(int i10, int i11) {
        return ThreadLocalRandom.current().nextInt(i10, i11);
    }

    @Override // l9.c
    public long g(long j10) {
        return ThreadLocalRandom.current().nextLong(j10);
    }

    @Override // l9.c
    public long h(long j10, long j11) {
        return ThreadLocalRandom.current().nextLong(j10, j11);
    }

    @Override // l9.a
    @NotNull
    public Random i() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        t.h(threadLocalRandomCurrent, "current()");
        return threadLocalRandomCurrent;
    }
}
