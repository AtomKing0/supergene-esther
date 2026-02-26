package p2;

import androidx.media3.common.C;
import p2.b0;

/* JADX INFO: compiled from: ConstantBitrateSeekMap.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f32457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f32458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f32459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f32460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f32461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f32462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f32463g;

    public e(long j10, long j11, int i10, int i11, boolean z10) {
        this.f32457a = j10;
        this.f32458b = j11;
        this.f32459c = i11 == -1 ? 1 : i11;
        this.f32461e = i10;
        this.f32463g = z10;
        if (j10 == -1) {
            this.f32460d = -1L;
            this.f32462f = C.TIME_UNSET;
        } else {
            this.f32460d = j10 - j11;
            this.f32462f = c(j10, j11, i10);
        }
    }

    private long a(long j10) {
        long j11 = (j10 * ((long) this.f32461e)) / 8000000;
        int i10 = this.f32459c;
        long jMin = (j11 / ((long) i10)) * ((long) i10);
        long j12 = this.f32460d;
        if (j12 != -1) {
            jMin = Math.min(jMin, j12 - ((long) i10));
        }
        return this.f32458b + Math.max(jMin, 0L);
    }

    private static long c(long j10, long j11, int i10) {
        return ((Math.max(0L, j10 - j11) * 8) * 1000000) / ((long) i10);
    }

    public long b(long j10) {
        return c(j10, this.f32458b, this.f32461e);
    }

    @Override // p2.b0
    public long getDurationUs() {
        return this.f32462f;
    }

    @Override // p2.b0
    public b0.a getSeekPoints(long j10) {
        if (this.f32460d == -1 && !this.f32463g) {
            return new b0.a(new c0(0L, this.f32458b));
        }
        long jA = a(j10);
        long jB = b(jA);
        c0 c0Var = new c0(jB, jA);
        if (this.f32460d != -1 && jB < j10) {
            int i10 = this.f32459c;
            if (((long) i10) + jA < this.f32457a) {
                long j11 = jA + ((long) i10);
                return new b0.a(c0Var, new c0(b(j11), j11));
            }
        }
        return new b0.a(c0Var);
    }

    @Override // p2.b0
    public boolean isSeekable() {
        return this.f32460d != -1 || this.f32463g;
    }
}
