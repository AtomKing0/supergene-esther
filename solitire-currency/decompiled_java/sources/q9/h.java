package q9;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import q9.b;

/* JADX INFO: compiled from: longSaturatedMath.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h {
    private static final long a(long j10) {
        return j10 < 0 ? b.f33177b.b() : b.f33177b.a();
    }

    public static final long b(long j10, long j11, @NotNull e unit) {
        t.i(unit, "unit");
        return ((1 | (j11 - 1)) > Long.MAX_VALUE ? 1 : ((1 | (j11 - 1)) == Long.MAX_VALUE ? 0 : -1)) == 0 ? b.J(a(j11)) : c(j10, j11, unit);
    }

    private static final long c(long j10, long j11, e eVar) {
        long j12 = j10 - j11;
        if (((j12 ^ j10) & (~(j12 ^ j11))) >= 0) {
            return d.t(j12, eVar);
        }
        e eVar2 = e.f33186d;
        if (eVar.compareTo(eVar2) >= 0) {
            return b.J(a(j12));
        }
        long jB = f.b(1L, eVar2, eVar);
        long j13 = (j10 / jB) - (j11 / jB);
        long j14 = (j10 % jB) - (j11 % jB);
        b.a aVar = b.f33177b;
        return b.E(d.t(j13, eVar2), d.t(j14, eVar));
    }

    public static final long d(long j10, long j11, @NotNull e unit) {
        t.i(unit, "unit");
        if (((j11 - 1) | 1) == Long.MAX_VALUE) {
            return j10 == j11 ? b.f33177b.c() : b.J(a(j11));
        }
        return (1 | (j10 - 1)) == Long.MAX_VALUE ? a(j10) : c(j10, j11, unit);
    }
}
