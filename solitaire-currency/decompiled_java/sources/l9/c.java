package l9;

import java.io.Serializable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f30972a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final c f30973b = c9.b.f4637a.b();

    /* JADX INFO: compiled from: Random.kt */
    public static final class a extends c implements Serializable {
        public /* synthetic */ a(k kVar) {
            this();
        }

        @Override // l9.c
        public int b(int i10) {
            return c.f30973b.b(i10);
        }

        @Override // l9.c
        public int c() {
            return c.f30973b.c();
        }

        @Override // l9.c
        public int d(int i10) {
            return c.f30973b.d(i10);
        }

        @Override // l9.c
        public int e(int i10, int i11) {
            return c.f30973b.e(i10, i11);
        }

        @Override // l9.c
        public long f() {
            return c.f30973b.f();
        }

        @Override // l9.c
        public long g(long j10) {
            return c.f30973b.g(j10);
        }

        @Override // l9.c
        public long h(long j10, long j11) {
            return c.f30973b.h(j10, j11);
        }

        private a() {
        }
    }

    public abstract int b(int i10);

    public abstract int c();

    public int d(int i10) {
        return e(0, i10);
    }

    public int e(int i10, int i11) {
        int iC;
        int i12;
        int iB;
        int iC2;
        boolean z10;
        d.c(i10, i11);
        int i13 = i11 - i10;
        if (i13 > 0 || i13 == Integer.MIN_VALUE) {
            if (((-i13) & i13) == i13) {
                iB = b(d.e(i13));
            } else {
                do {
                    iC = c() >>> 1;
                    i12 = iC % i13;
                } while ((iC - i12) + (i13 - 1) < 0);
                iB = i12;
            }
            return i10 + iB;
        }
        do {
            iC2 = c();
            z10 = false;
            if (i10 <= iC2 && iC2 < i11) {
                z10 = true;
            }
        } while (!z10);
        return iC2;
    }

    public long f() {
        return (((long) c()) << 32) + ((long) c());
    }

    public long g(long j10) {
        return h(0L, j10);
    }

    public long h(long j10, long j11) {
        long jF;
        boolean z10;
        long jF2;
        long j12;
        long jB;
        int iC;
        d.d(j10, j11);
        long j13 = j11 - j10;
        if (j13 <= 0) {
            do {
                jF = f();
                z10 = false;
                if (j10 <= jF && jF < j11) {
                    z10 = true;
                }
            } while (!z10);
            return jF;
        }
        if (((-j13) & j13) == j13) {
            int i10 = (int) j13;
            int i11 = (int) (j13 >>> 32);
            if (i10 != 0) {
                iC = b(d.e(i10));
            } else if (i11 == 1) {
                iC = c();
            } else {
                jB = (((long) b(d.e(i11))) << 32) + (((long) c()) & 4294967295L);
            }
            jB = ((long) iC) & 4294967295L;
        } else {
            do {
                jF2 = f() >>> 1;
                j12 = jF2 % j13;
            } while ((jF2 - j12) + (j13 - 1) < 0);
            jB = j12;
        }
        return j10 + jB;
    }
}
