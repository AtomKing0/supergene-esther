package a4;

import androidx.annotation.GuardedBy;
import androidx.media3.common.C;
import androidx.media3.common.util.TimestampAdjuster;

/* JADX INFO: compiled from: TimestampAdjuster.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private long f191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private long f192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    private long f193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadLocal<Long> f194d = new ThreadLocal<>();

    public l0(long j10) {
        g(j10);
    }

    public static long f(long j10) {
        return (j10 * 1000000) / 90000;
    }

    public static long h(long j10) {
        return (j10 * 90000) / 1000000;
    }

    public synchronized long a(long j10) {
        if (j10 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.f192b == C.TIME_UNSET) {
            long jLongValue = this.f191a;
            if (jLongValue == TimestampAdjuster.MODE_SHARED) {
                jLongValue = ((Long) a.e(this.f194d.get())).longValue();
            }
            this.f192b = jLongValue - j10;
            notifyAll();
        }
        this.f193c = j10;
        return j10 + this.f192b;
    }

    public synchronized long b(long j10) {
        if (j10 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j11 = this.f193c;
        if (j11 != C.TIME_UNSET) {
            long jH = h(j11);
            long j12 = (4294967296L + jH) / 8589934592L;
            long j13 = ((j12 - 1) * 8589934592L) + j10;
            j10 += j12 * 8589934592L;
            if (Math.abs(j13 - jH) < Math.abs(j10 - jH)) {
                j10 = j13;
            }
        }
        return a(f(j10));
    }

    public synchronized long c() {
        long j10;
        j10 = this.f191a;
        if (j10 == Long.MAX_VALUE || j10 == TimestampAdjuster.MODE_SHARED) {
            j10 = C.TIME_UNSET;
        }
        return j10;
    }

    public synchronized long d() {
        long j10;
        j10 = this.f193c;
        return j10 != C.TIME_UNSET ? j10 + this.f192b : c();
    }

    public synchronized long e() {
        return this.f192b;
    }

    public synchronized void g(long j10) {
        this.f191a = j10;
        this.f192b = j10 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f193c = C.TIME_UNSET;
    }
}
