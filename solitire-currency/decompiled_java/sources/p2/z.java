package p2;

import a4.o0;
import p2.b0;

/* JADX INFO: compiled from: IndexSeekMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f32551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f32552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f32553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f32554d;

    public z(long[] jArr, long[] jArr2, long j10) {
        a4.a.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z10 = length > 0;
        this.f32554d = z10;
        if (!z10 || jArr2[0] <= 0) {
            this.f32551a = jArr;
            this.f32552b = jArr2;
        } else {
            int i10 = length + 1;
            long[] jArr3 = new long[i10];
            this.f32551a = jArr3;
            long[] jArr4 = new long[i10];
            this.f32552b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f32553c = j10;
    }

    @Override // p2.b0
    public long getDurationUs() {
        return this.f32553c;
    }

    @Override // p2.b0
    public b0.a getSeekPoints(long j10) {
        if (!this.f32554d) {
            return new b0.a(c0.f32448c);
        }
        int i10 = o0.i(this.f32552b, j10, true, true);
        c0 c0Var = new c0(this.f32552b[i10], this.f32551a[i10]);
        if (c0Var.f32449a == j10 || i10 == this.f32552b.length - 1) {
            return new b0.a(c0Var);
        }
        int i11 = i10 + 1;
        return new b0.a(c0Var, new c0(this.f32552b[i11], this.f32551a[i11]));
    }

    @Override // p2.b0
    public boolean isSeekable() {
        return this.f32554d;
    }
}
