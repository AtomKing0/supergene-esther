package p2;

import a4.o0;
import java.util.Arrays;
import p2.b0;

/* JADX INFO: compiled from: ChunkIndex.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f32452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f32453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f32454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f32455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f32456f;

    public d(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f32452b = iArr;
        this.f32453c = jArr;
        this.f32454d = jArr2;
        this.f32455e = jArr3;
        int length = iArr.length;
        this.f32451a = length;
        if (length > 0) {
            this.f32456f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f32456f = 0L;
        }
    }

    public int a(long j10) {
        return o0.i(this.f32455e, j10, true, true);
    }

    @Override // p2.b0
    public long getDurationUs() {
        return this.f32456f;
    }

    @Override // p2.b0
    public b0.a getSeekPoints(long j10) {
        int iA = a(j10);
        c0 c0Var = new c0(this.f32455e[iA], this.f32453c[iA]);
        if (c0Var.f32449a >= j10 || iA == this.f32451a - 1) {
            return new b0.a(c0Var);
        }
        int i10 = iA + 1;
        return new b0.a(c0Var, new c0(this.f32455e[i10], this.f32453c[i10]));
    }

    @Override // p2.b0
    public boolean isSeekable() {
        return true;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f32451a + ", sizes=" + Arrays.toString(this.f32452b) + ", offsets=" + Arrays.toString(this.f32453c) + ", timeUs=" + Arrays.toString(this.f32455e) + ", durationsUs=" + Arrays.toString(this.f32454d) + ")";
    }
}
