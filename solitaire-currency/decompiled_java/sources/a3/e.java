package a3;

import a4.o0;
import p2.b0;
import p2.c0;

/* JADX INFO: compiled from: WavSeekMap.java */
/* JADX INFO: loaded from: classes2.dex */
final class e implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f131e;

    public e(c cVar, int i10, long j10, long j11) {
        this.f127a = cVar;
        this.f128b = i10;
        this.f129c = j10;
        long j12 = (j11 - j10) / ((long) cVar.f122e);
        this.f130d = j12;
        this.f131e = a(j12);
    }

    private long a(long j10) {
        return o0.F0(j10 * ((long) this.f128b), 1000000L, this.f127a.f120c);
    }

    @Override // p2.b0
    public long getDurationUs() {
        return this.f131e;
    }

    @Override // p2.b0
    public b0.a getSeekPoints(long j10) {
        long jQ = o0.q((((long) this.f127a.f120c) * j10) / (((long) this.f128b) * 1000000), 0L, this.f130d - 1);
        long j11 = this.f129c + (((long) this.f127a.f122e) * jQ);
        long jA = a(jQ);
        c0 c0Var = new c0(jA, j11);
        if (jA >= j10 || jQ == this.f130d - 1) {
            return new b0.a(c0Var);
        }
        long j12 = jQ + 1;
        return new b0.a(c0Var, new c0(a(j12), this.f129c + (((long) this.f127a.f122e) * j12)));
    }

    @Override // p2.b0
    public boolean isSeekable() {
        return true;
    }
}
