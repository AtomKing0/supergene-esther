package l3;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import k2.f3;
import k2.o1;
import k2.p1;
import l3.d;
import l3.x;

/* JADX INFO: compiled from: ClippingMediaPeriod.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements x, x.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f30468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private x.a f30469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a[] f30470c = new a[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f30471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f30472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f30473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private d.b f30474g;

    /* JADX INFO: compiled from: ClippingMediaPeriod.java */
    private final class a implements u0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u0 f30475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f30476b;

        public a(u0 u0Var) {
            this.f30475a = u0Var;
        }

        @Override // l3.u0
        public int a(p1 p1Var, n2.g gVar, int i10) {
            if (c.this.f()) {
                return -3;
            }
            if (this.f30476b) {
                gVar.k(4);
                return -4;
            }
            int iA = this.f30475a.a(p1Var, gVar, i10);
            if (iA == -5) {
                o1 o1Var = (o1) a4.a.e(p1Var.f29409b);
                int i11 = o1Var.B;
                if (i11 != 0 || o1Var.C != 0) {
                    c cVar = c.this;
                    if (cVar.f30472e != 0) {
                        i11 = 0;
                    }
                    p1Var.f29409b = o1Var.b().N(i11).O(cVar.f30473f == Long.MIN_VALUE ? o1Var.C : 0).E();
                }
                return -5;
            }
            c cVar2 = c.this;
            long j10 = cVar2.f30473f;
            if (j10 == Long.MIN_VALUE || ((iA != -4 || gVar.f31588e < j10) && !(iA == -3 && cVar2.getBufferedPositionUs() == Long.MIN_VALUE && !gVar.f31587d))) {
                return iA;
            }
            gVar.c();
            gVar.k(4);
            this.f30476b = true;
            return -4;
        }

        public void b() {
            this.f30476b = false;
        }

        @Override // l3.u0
        public boolean isReady() {
            return !c.this.f() && this.f30475a.isReady();
        }

        @Override // l3.u0
        public void maybeThrowError() throws IOException {
            this.f30475a.maybeThrowError();
        }

        @Override // l3.u0
        public int skipData(long j10) {
            if (c.this.f()) {
                return -3;
            }
            return this.f30475a.skipData(j10);
        }
    }

    public c(x xVar, boolean z10, long j10, long j11) {
        this.f30468a = xVar;
        this.f30471d = z10 ? j10 : C.TIME_UNSET;
        this.f30472e = j10;
        this.f30473f = j11;
    }

    private f3 e(long j10, f3 f3Var) {
        long jQ = a4.o0.q(f3Var.f29114a, 0L, j10 - this.f30472e);
        long j11 = f3Var.f29115b;
        long j12 = this.f30473f;
        long jQ2 = a4.o0.q(j11, 0L, j12 == Long.MIN_VALUE ? Long.MAX_VALUE : j12 - j10);
        return (jQ == f3Var.f29114a && jQ2 == f3Var.f29115b) ? f3Var : new f3(jQ, jQ2);
    }

    private static boolean k(long j10, x3.s[] sVarArr) {
        if (j10 != 0) {
            for (x3.s sVar : sVarArr) {
                if (sVar != null) {
                    o1 selectedFormat = sVar.getSelectedFormat();
                    if (!a4.x.a(selectedFormat.f29347l, selectedFormat.f29344i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // l3.x, l3.v0
    public boolean a(long j10) {
        return this.f30468a.a(j10);
    }

    @Override // l3.x
    public void b(x.a aVar, long j10) {
        this.f30469b = aVar;
        this.f30468a.b(this, j10);
    }

    @Override // l3.x.a
    public void d(x xVar) {
        if (this.f30474g != null) {
            return;
        }
        ((x.a) a4.a.e(this.f30469b)).d(this);
    }

    @Override // l3.x
    public void discardBuffer(long j10, boolean z10) {
        this.f30468a.discardBuffer(j10, z10);
    }

    boolean f() {
        return this.f30471d != C.TIME_UNSET;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    @Override // l3.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long g(x3.s[] r13, boolean[] r14, l3.u0[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            l3.c$a[] r2 = new l3.c.a[r2]
            r0.f30470c = r2
            int r2 = r1.length
            l3.u0[] r9 = new l3.u0[r2]
            r10 = 0
            r2 = r10
        Lc:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L21
            l3.c$a[] r3 = r0.f30470c
            r4 = r1[r2]
            l3.c$a r4 = (l3.c.a) r4
            r3[r2] = r4
            if (r4 == 0) goto L1c
            l3.u0 r11 = r4.f30475a
        L1c:
            r9[r2] = r11
            int r2 = r2 + 1
            goto Lc
        L21:
            l3.x r2 = r0.f30468a
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.g(r3, r4, r5, r6, r7)
            boolean r4 = r12.f()
            if (r4 == 0) goto L43
            long r4 = r0.f30472e
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L43
            r6 = r13
            boolean r4 = k(r4, r13)
            if (r4 == 0) goto L43
            r4 = r2
            goto L48
        L43:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L48:
            r0.f30471d = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L63
            long r4 = r0.f30472e
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L61
            long r4 = r0.f30473f
            r6 = -9223372036854775808
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 == 0) goto L63
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 > 0) goto L61
            goto L63
        L61:
            r4 = r10
            goto L64
        L63:
            r4 = 1
        L64:
            a4.a.g(r4)
        L67:
            int r4 = r1.length
            if (r10 >= r4) goto L8d
            r4 = r9[r10]
            if (r4 != 0) goto L73
            l3.c$a[] r4 = r0.f30470c
            r4[r10] = r11
            goto L84
        L73:
            l3.c$a[] r5 = r0.f30470c
            r6 = r5[r10]
            if (r6 == 0) goto L7d
            l3.u0 r6 = r6.f30475a
            if (r6 == r4) goto L84
        L7d:
            l3.c$a r6 = new l3.c$a
            r6.<init>(r4)
            r5[r10] = r6
        L84:
            l3.c$a[] r4 = r0.f30470c
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L67
        L8d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.c.g(x3.s[], boolean[], l3.u0[], boolean[], long):long");
    }

    @Override // l3.x, l3.v0
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.f30468a.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j10 = this.f30473f;
            if (j10 == Long.MIN_VALUE || bufferedPositionUs < j10) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // l3.x, l3.v0
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.f30468a.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j10 = this.f30473f;
            if (j10 == Long.MIN_VALUE || nextLoadPositionUs < j10) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // l3.x
    public e1 getTrackGroups() {
        return this.f30468a.getTrackGroups();
    }

    @Override // l3.v0.a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(x xVar) {
        ((x.a) a4.a.e(this.f30469b)).c(this);
    }

    @Override // l3.x
    public long i(long j10, f3 f3Var) {
        long j11 = this.f30472e;
        if (j10 == j11) {
            return j11;
        }
        return this.f30468a.i(j10, e(j10, f3Var));
    }

    @Override // l3.x, l3.v0
    public boolean isLoading() {
        return this.f30468a.isLoading();
    }

    public void j(d.b bVar) {
        this.f30474g = bVar;
    }

    public void l(long j10, long j11) {
        this.f30472e = j10;
        this.f30473f = j11;
    }

    @Override // l3.x
    public void maybeThrowPrepareError() throws IOException {
        d.b bVar = this.f30474g;
        if (bVar != null) {
            throw bVar;
        }
        this.f30468a.maybeThrowPrepareError();
    }

    @Override // l3.x
    public long readDiscontinuity() {
        if (f()) {
            long j10 = this.f30471d;
            this.f30471d = C.TIME_UNSET;
            long discontinuity = readDiscontinuity();
            return discontinuity != C.TIME_UNSET ? discontinuity : j10;
        }
        long discontinuity2 = this.f30468a.readDiscontinuity();
        if (discontinuity2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        boolean z10 = true;
        a4.a.g(discontinuity2 >= this.f30472e);
        long j11 = this.f30473f;
        if (j11 != Long.MIN_VALUE && discontinuity2 > j11) {
            z10 = false;
        }
        a4.a.g(z10);
        return discontinuity2;
    }

    @Override // l3.x, l3.v0
    public void reevaluateBuffer(long j10) {
        this.f30468a.reevaluateBuffer(j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    @Override // l3.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long seekToUs(long r6) {
        /*
            r5 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.f30471d = r0
            l3.c$a[] r0 = r5.f30470c
            int r1 = r0.length
            r2 = 0
            r3 = r2
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.b()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            l3.x r0 = r5.f30468a
            long r0 = r0.seekToUs(r6)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 == 0) goto L34
            long r6 = r5.f30472e
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L35
            long r6 = r5.f30473f
            r3 = -9223372036854775808
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L34
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto L35
        L34:
            r2 = 1
        L35:
            a4.a.g(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.c.seekToUs(long):long");
    }
}
