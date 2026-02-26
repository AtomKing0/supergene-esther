package p2;

import a4.o0;
import p2.b0;
import p2.v;

/* JADX INFO: compiled from: FlacSeekTableSeekMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v f32530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f32531b;

    public u(v vVar, long j10) {
        this.f32530a = vVar;
        this.f32531b = j10;
    }

    private c0 a(long j10, long j11) {
        return new c0((j10 * 1000000) / ((long) this.f32530a.f32536e), this.f32531b + j11);
    }

    @Override // p2.b0
    public long getDurationUs() {
        return this.f32530a.f();
    }

    @Override // p2.b0
    public b0.a getSeekPoints(long j10) {
        a4.a.i(this.f32530a.f32542k);
        v vVar = this.f32530a;
        v.a aVar = vVar.f32542k;
        long[] jArr = aVar.f32544a;
        long[] jArr2 = aVar.f32545b;
        int i10 = o0.i(jArr, vVar.i(j10), true, false);
        c0 c0VarA = a(i10 == -1 ? 0L : jArr[i10], i10 != -1 ? jArr2[i10] : 0L);
        if (c0VarA.f32449a == j10 || i10 == jArr.length - 1) {
            return new b0.a(c0VarA);
        }
        int i11 = i10 + 1;
        return new b0.a(c0VarA, a(jArr[i11], jArr2[i11]));
    }

    @Override // p2.b0
    public boolean isSeekable() {
        return true;
    }
}
