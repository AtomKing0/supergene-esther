package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final u9.h0 f29959a = new u9.h0("REMOVED_TASK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final u9.h0 f29960b = new u9.h0("CLOSED_EMPTY");

    public static final long c(long j10) {
        if (j10 <= 0) {
            return 0L;
        }
        if (j10 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j10;
    }
}
