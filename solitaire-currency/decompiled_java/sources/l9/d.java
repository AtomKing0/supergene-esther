package l9;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {
    @NotNull
    public static final c a(long j10) {
        return new e((int) j10, (int) (j10 >> 32));
    }

    @NotNull
    public static final String b(@NotNull Object from, @NotNull Object until) {
        t.i(from, "from");
        t.i(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void c(int i10, int i11) {
        if (!(i11 > i10)) {
            throw new IllegalArgumentException(b(Integer.valueOf(i10), Integer.valueOf(i11)).toString());
        }
    }

    public static final void d(long j10, long j11) {
        if (!(j11 > j10)) {
            throw new IllegalArgumentException(b(Long.valueOf(j10), Long.valueOf(j11)).toString());
        }
    }

    public static final int e(int i10) {
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    public static final int f(int i10, int i11) {
        return (i10 >>> (32 - i11)) & ((-i11) >> 31);
    }
}
