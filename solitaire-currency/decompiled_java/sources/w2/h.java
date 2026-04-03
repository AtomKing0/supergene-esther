package w2;

import a4.c0;
import a4.o0;
import a4.t;
import androidx.annotation.Nullable;
import m2.h0;
import p2.b0;

/* JADX INFO: compiled from: VbriSeeker.java */
/* JADX INFO: loaded from: classes2.dex */
final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f35357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f35358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f35359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f35360d;

    private h(long[] jArr, long[] jArr2, long j10, long j11) {
        this.f35357a = jArr;
        this.f35358b = jArr2;
        this.f35359c = j10;
        this.f35360d = j11;
    }

    @Nullable
    public static h a(long j10, long j11, h0.a aVar, c0 c0Var) {
        int iD;
        c0Var.Q(10);
        int iN = c0Var.n();
        if (iN <= 0) {
            return null;
        }
        int i10 = aVar.f31290d;
        long jF0 = o0.F0(iN, ((long) (i10 >= 32000 ? 1152 : 576)) * 1000000, i10);
        int iJ = c0Var.J();
        int iJ2 = c0Var.J();
        int iJ3 = c0Var.J();
        c0Var.Q(2);
        long j12 = j11 + ((long) aVar.f31289c);
        long[] jArr = new long[iJ];
        long[] jArr2 = new long[iJ];
        int i11 = 0;
        long j13 = j11;
        while (i11 < iJ) {
            int i12 = iJ2;
            long j14 = j12;
            jArr[i11] = (((long) i11) * jF0) / ((long) iJ);
            jArr2[i11] = Math.max(j13, j14);
            if (iJ3 == 1) {
                iD = c0Var.D();
            } else if (iJ3 == 2) {
                iD = c0Var.J();
            } else if (iJ3 == 3) {
                iD = c0Var.G();
            } else {
                if (iJ3 != 4) {
                    return null;
                }
                iD = c0Var.H();
            }
            j13 += ((long) iD) * ((long) i12);
            i11++;
            jArr = jArr;
            iJ2 = i12;
            j12 = j14;
        }
        long[] jArr3 = jArr;
        if (j10 != -1 && j10 != j13) {
            t.i("VbriSeeker", "VBRI data size mismatch: " + j10 + ", " + j13);
        }
        return new h(jArr3, jArr2, jF0, j13);
    }

    @Override // w2.g
    public long getDataEndPosition() {
        return this.f35360d;
    }

    @Override // p2.b0
    public long getDurationUs() {
        return this.f35359c;
    }

    @Override // p2.b0
    public b0.a getSeekPoints(long j10) {
        int i10 = o0.i(this.f35357a, j10, true, true);
        p2.c0 c0Var = new p2.c0(this.f35357a[i10], this.f35358b[i10]);
        if (c0Var.f32449a >= j10 || i10 == this.f35357a.length - 1) {
            return new b0.a(c0Var);
        }
        int i11 = i10 + 1;
        return new b0.a(c0Var, new p2.c0(this.f35357a[i11], this.f35358b[i11]));
    }

    @Override // w2.g
    public long getTimeUs(long j10) {
        return this.f35357a[o0.i(this.f35358b, j10, true, true)];
    }

    @Override // p2.b0
    public boolean isSeekable() {
        return true;
    }
}
