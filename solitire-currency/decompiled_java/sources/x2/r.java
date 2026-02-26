package x2;

import a4.o0;

/* JADX INFO: compiled from: TrackSampleTable.java */
/* JADX INFO: loaded from: classes2.dex */
final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f35892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f35894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f35895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f35896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f35897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f35898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f35899h;

    public r(o oVar, long[] jArr, int[] iArr, int i10, long[] jArr2, int[] iArr2, long j10) {
        a4.a.a(iArr.length == jArr2.length);
        a4.a.a(jArr.length == jArr2.length);
        a4.a.a(iArr2.length == jArr2.length);
        this.f35892a = oVar;
        this.f35894c = jArr;
        this.f35895d = iArr;
        this.f35896e = i10;
        this.f35897f = jArr2;
        this.f35898g = iArr2;
        this.f35899h = j10;
        this.f35893b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j10) {
        for (int i10 = o0.i(this.f35897f, j10, true, false); i10 >= 0; i10--) {
            if ((this.f35898g[i10] & 1) != 0) {
                return i10;
            }
        }
        return -1;
    }

    public int b(long j10) {
        for (int iE = o0.e(this.f35897f, j10, true, false); iE < this.f35897f.length; iE++) {
            if ((this.f35898g[iE] & 1) != 0) {
                return iE;
            }
        }
        return -1;
    }
}
