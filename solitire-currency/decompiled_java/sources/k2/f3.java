package k2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SeekParameters.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f3 f29109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f3 f29110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f3 f29111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f3 f29112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f3 f29113g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f29114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f29115b;

    static {
        f3 f3Var = new f3(0L, 0L);
        f29109c = f3Var;
        f29110d = new f3(Long.MAX_VALUE, Long.MAX_VALUE);
        f29111e = new f3(Long.MAX_VALUE, 0L);
        f29112f = new f3(0L, Long.MAX_VALUE);
        f29113g = f3Var;
    }

    public f3(long j10, long j11) {
        a4.a.a(j10 >= 0);
        a4.a.a(j11 >= 0);
        this.f29114a = j10;
        this.f29115b = j11;
    }

    public long a(long j10, long j11, long j12) {
        long j13 = this.f29114a;
        if (j13 == 0 && this.f29115b == 0) {
            return j10;
        }
        long jK0 = a4.o0.K0(j10, j13, Long.MIN_VALUE);
        long jB = a4.o0.b(j10, this.f29115b, Long.MAX_VALUE);
        boolean z10 = jK0 <= j11 && j11 <= jB;
        boolean z11 = jK0 <= j12 && j12 <= jB;
        return (z10 && z11) ? Math.abs(j11 - j10) <= Math.abs(j12 - j10) ? j11 : j12 : z10 ? j11 : z11 ? j12 : jK0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f3.class != obj.getClass()) {
            return false;
        }
        f3 f3Var = (f3) obj;
        return this.f29114a == f3Var.f29114a && this.f29115b == f3Var.f29115b;
    }

    public int hashCode() {
        return (((int) this.f29114a) * 31) + ((int) this.f29115b);
    }
}
