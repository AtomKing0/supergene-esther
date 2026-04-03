package q9;

import org.jetbrains.annotations.NotNull;
import q9.k;

/* JADX INFO: compiled from: MonoTimeSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f33194a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f33195b = System.nanoTime();

    private i() {
    }

    private final long d() {
        return System.nanoTime() - f33195b;
    }

    public final long a(long j10, long j11) {
        return h.d(j10, j11, e.f33184b);
    }

    public final long b(long j10) {
        return h.b(d(), j10, e.f33184b);
    }

    public long c() {
        return k.a.e(d());
    }

    @NotNull
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
