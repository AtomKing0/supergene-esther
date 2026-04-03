package w2;

import a4.c0;
import a4.o0;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import c3.a;
import h3.h;
import h3.k;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import k2.j2;
import k2.o1;
import m2.h0;
import p2.a0;
import p2.e0;
import p2.l;
import p2.m;
import p2.n;
import p2.q;
import p2.r;
import p2.x;
import p2.y;
import w2.g;

/* JADX INFO: compiled from: Mp3Extractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final r f35335u = new r() { // from class: w2.d
        @Override // p2.r
        public final l[] createExtractors() {
            return f.n();
        }

        @Override // p2.r
        public /* synthetic */ l[] createExtractors(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final h.a f35336v = new h.a() { // from class: w2.e
        @Override // h3.h.a
        public final boolean evaluate(int i10, int i11, int i12, int i13, int i14) {
            return f.o(i10, i11, i12, i13, i14);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f35338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c0 f35339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h0.a f35340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x f35341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final y f35342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e0 f35343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private n f35344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private e0 f35345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private e0 f35346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f35347k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private c3.a f35348l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f35349m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f35350n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f35351o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f35352p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private g f35353q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f35354r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f35355s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f35356t;

    public f() {
        this(0);
    }

    private void f() {
        a4.a.i(this.f35345i);
        o0.j(this.f35344h);
    }

    private g g(m mVar) throws IOException {
        long jK;
        long dataEndPosition;
        g gVarQ = q(mVar);
        c cVarP = p(this.f35348l, mVar.getPosition());
        if (this.f35354r) {
            return new g.a();
        }
        if ((this.f35337a & 4) != 0) {
            if (cVarP != null) {
                jK = cVarP.getDurationUs();
                dataEndPosition = cVarP.getDataEndPosition();
            } else if (gVarQ != null) {
                jK = gVarQ.getDurationUs();
                dataEndPosition = gVarQ.getDataEndPosition();
            } else {
                jK = k(this.f35348l);
                dataEndPosition = -1;
            }
            gVarQ = new b(jK, mVar.getPosition(), dataEndPosition);
        } else if (cVarP != null) {
            gVarQ = cVarP;
        } else if (gVarQ == null) {
            gVarQ = null;
        }
        if (gVarQ == null || !(gVarQ.isSeekable() || (this.f35337a & 1) == 0)) {
            return j(mVar, (this.f35337a & 2) != 0);
        }
        return gVarQ;
    }

    private long h(long j10) {
        return this.f35349m + ((j10 * 1000000) / ((long) this.f35340d.f31290d));
    }

    private g j(m mVar, boolean z10) throws IOException {
        mVar.peekFully(this.f35339c.d(), 0, 4);
        this.f35339c.P(0);
        this.f35340d.a(this.f35339c.n());
        return new a(mVar.getLength(), mVar.getPosition(), this.f35340d, z10);
    }

    private static long k(@Nullable c3.a aVar) {
        if (aVar == null) {
            return C.TIME_UNSET;
        }
        int iE = aVar.e();
        for (int i10 = 0; i10 < iE; i10++) {
            a.b bVarD = aVar.d(i10);
            if (bVarD instanceof h3.m) {
                h3.m mVar = (h3.m) bVarD;
                if (mVar.f26451a.equals("TLEN")) {
                    return o0.w0(Long.parseLong(mVar.f26463c));
                }
            }
        }
        return C.TIME_UNSET;
    }

    private static int l(c0 c0Var, int i10) {
        if (c0Var.f() >= i10 + 4) {
            c0Var.P(i10);
            int iN = c0Var.n();
            if (iN == 1483304551 || iN == 1231971951) {
                return iN;
            }
        }
        if (c0Var.f() < 40) {
            return 0;
        }
        c0Var.P(36);
        return c0Var.n() == 1447187017 ? 1447187017 : 0;
    }

    private static boolean m(int i10, long j10) {
        return ((long) (i10 & (-128000))) == (j10 & (-128000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] n() {
        return new l[]{new f()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean o(int i10, int i11, int i12, int i13, int i14) {
        return (i11 == 67 && i12 == 79 && i13 == 77 && (i14 == 77 || i10 == 2)) || (i11 == 77 && i12 == 76 && i13 == 76 && (i14 == 84 || i10 == 2));
    }

    @Nullable
    private static c p(@Nullable c3.a aVar, long j10) {
        if (aVar == null) {
            return null;
        }
        int iE = aVar.e();
        for (int i10 = 0; i10 < iE; i10++) {
            a.b bVarD = aVar.d(i10);
            if (bVarD instanceof k) {
                return c.a(j10, (k) bVarD, k(aVar));
            }
        }
        return null;
    }

    @Nullable
    private g q(m mVar) throws IOException {
        c0 c0Var = new c0(this.f35340d.f31289c);
        mVar.peekFully(c0Var.d(), 0, this.f35340d.f31289c);
        h0.a aVar = this.f35340d;
        int i10 = 21;
        if ((aVar.f31287a & 1) != 0) {
            if (aVar.f31291e != 1) {
                i10 = 36;
            }
        } else if (aVar.f31291e == 1) {
            i10 = 13;
        }
        int i11 = i10;
        int iL = l(c0Var, i11);
        if (iL != 1483304551 && iL != 1231971951) {
            if (iL != 1447187017) {
                mVar.resetPeekPosition();
                return null;
            }
            h hVarA = h.a(mVar.getLength(), mVar.getPosition(), this.f35340d, c0Var);
            mVar.skipFully(this.f35340d.f31289c);
            return hVarA;
        }
        i iVarA = i.a(mVar.getLength(), mVar.getPosition(), this.f35340d, c0Var);
        if (iVarA != null && !this.f35341e.a()) {
            mVar.resetPeekPosition();
            mVar.advancePeekPosition(i11 + 141);
            mVar.peekFully(this.f35339c.d(), 0, 3);
            this.f35339c.P(0);
            this.f35341e.d(this.f35339c.G());
        }
        mVar.skipFully(this.f35340d.f31289c);
        return (iVarA == null || iVarA.isSeekable() || iL != 1231971951) ? iVarA : j(mVar, false);
    }

    private boolean r(m mVar) throws IOException {
        g gVar = this.f35353q;
        if (gVar != null) {
            long dataEndPosition = gVar.getDataEndPosition();
            if (dataEndPosition != -1 && mVar.getPeekPosition() > dataEndPosition - 4) {
                return true;
            }
        }
        try {
            return !mVar.peekFully(this.f35339c.d(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private int s(m mVar) throws IOException {
        if (this.f35347k == 0) {
            try {
                u(mVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f35353q == null) {
            g gVarG = g(mVar);
            this.f35353q = gVarG;
            this.f35344h.h(gVarG);
            this.f35346j.f(new o1.b().e0(this.f35340d.f31288b).W(4096).H(this.f35340d.f31291e).f0(this.f35340d.f31290d).N(this.f35341e.f32548a).O(this.f35341e.f32549b).X((this.f35337a & 8) != 0 ? null : this.f35348l).E());
            this.f35351o = mVar.getPosition();
        } else if (this.f35351o != 0) {
            long position = mVar.getPosition();
            long j10 = this.f35351o;
            if (position < j10) {
                mVar.skipFully((int) (j10 - position));
            }
        }
        return t(mVar);
    }

    private int t(m mVar) throws IOException {
        if (this.f35352p == 0) {
            mVar.resetPeekPosition();
            if (r(mVar)) {
                return -1;
            }
            this.f35339c.P(0);
            int iN = this.f35339c.n();
            if (!m(iN, this.f35347k) || h0.j(iN) == -1) {
                mVar.skipFully(1);
                this.f35347k = 0;
                return 0;
            }
            this.f35340d.a(iN);
            if (this.f35349m == C.TIME_UNSET) {
                this.f35349m = this.f35353q.getTimeUs(mVar.getPosition());
                if (this.f35338b != C.TIME_UNSET) {
                    this.f35349m += this.f35338b - this.f35353q.getTimeUs(0L);
                }
            }
            h0.a aVar = this.f35340d;
            this.f35352p = aVar.f31289c;
            g gVar = this.f35353q;
            if (gVar instanceof b) {
                b bVar = (b) gVar;
                bVar.b(h(this.f35350n + ((long) aVar.f31293g)), mVar.getPosition() + ((long) this.f35340d.f31289c));
                if (this.f35355s && bVar.a(this.f35356t)) {
                    this.f35355s = false;
                    this.f35346j = this.f35345i;
                }
            }
        }
        int iC = this.f35346j.c(mVar, this.f35352p, true);
        if (iC == -1) {
            return -1;
        }
        int i10 = this.f35352p - iC;
        this.f35352p = i10;
        if (i10 > 0) {
            return 0;
        }
        this.f35346j.a(h(this.f35350n), 1, this.f35340d.f31289c, 0, null);
        this.f35350n += (long) this.f35340d.f31293g;
        this.f35352p = 0;
        return 0;
    }

    private boolean u(m mVar, boolean z10) throws IOException {
        int peekPosition;
        int i10;
        int iJ;
        int i11 = z10 ? 32768 : 131072;
        mVar.resetPeekPosition();
        if (mVar.getPosition() == 0) {
            c3.a aVarA = this.f35342f.a(mVar, (this.f35337a & 8) == 0 ? null : f35336v);
            this.f35348l = aVarA;
            if (aVarA != null) {
                this.f35341e.c(aVarA);
            }
            peekPosition = (int) mVar.getPeekPosition();
            if (!z10) {
                mVar.skipFully(peekPosition);
            }
            i10 = 0;
        } else {
            peekPosition = 0;
            i10 = 0;
        }
        int i12 = i10;
        int i13 = i12;
        while (true) {
            if (!r(mVar)) {
                this.f35339c.P(0);
                int iN = this.f35339c.n();
                if ((i10 == 0 || m(iN, i10)) && (iJ = h0.j(iN)) != -1) {
                    i12++;
                    if (i12 != 1) {
                        if (i12 == 4) {
                            break;
                        }
                    } else {
                        this.f35340d.a(iN);
                        i10 = iN;
                    }
                    mVar.advancePeekPosition(iJ - 4);
                } else {
                    int i14 = i13 + 1;
                    if (i13 == i11) {
                        if (z10) {
                            return false;
                        }
                        throw j2.a("Searched too many bytes.", null);
                    }
                    if (z10) {
                        mVar.resetPeekPosition();
                        mVar.advancePeekPosition(peekPosition + i14);
                    } else {
                        mVar.skipFully(1);
                    }
                    i12 = 0;
                    i13 = i14;
                    i10 = 0;
                }
            } else if (i12 <= 0) {
                throw new EOFException();
            }
        }
        if (z10) {
            mVar.skipFully(peekPosition + i13);
        } else {
            mVar.resetPeekPosition();
        }
        this.f35347k = i10;
        return true;
    }

    @Override // p2.l
    public int a(m mVar, a0 a0Var) throws IOException {
        f();
        int iS = s(mVar);
        if (iS == -1 && (this.f35353q instanceof b)) {
            long jH = h(this.f35350n);
            if (this.f35353q.getDurationUs() != jH) {
                ((b) this.f35353q).c(jH);
                this.f35344h.h(this.f35353q);
            }
        }
        return iS;
    }

    @Override // p2.l
    public void b(n nVar) {
        this.f35344h = nVar;
        e0 e0VarTrack = nVar.track(0, 1);
        this.f35345i = e0VarTrack;
        this.f35346j = e0VarTrack;
        this.f35344h.endTracks();
    }

    @Override // p2.l
    public boolean c(m mVar) throws IOException {
        return u(mVar, true);
    }

    public void i() {
        this.f35354r = true;
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        this.f35347k = 0;
        this.f35349m = C.TIME_UNSET;
        this.f35350n = 0L;
        this.f35352p = 0;
        this.f35356t = j11;
        g gVar = this.f35353q;
        if (!(gVar instanceof b) || ((b) gVar).a(j11)) {
            return;
        }
        this.f35355s = true;
        this.f35346j = this.f35343g;
    }

    public f(int i10) {
        this(i10, C.TIME_UNSET);
    }

    public f(int i10, long j10) {
        this.f35337a = (i10 & 2) != 0 ? i10 | 1 : i10;
        this.f35338b = j10;
        this.f35339c = new c0(10);
        this.f35340d = new h0.a();
        this.f35341e = new x();
        this.f35349m = C.TIME_UNSET;
        this.f35342f = new y();
        p2.k kVar = new p2.k();
        this.f35343g = kVar;
        this.f35346j = kVar;
    }

    @Override // p2.l
    public void release() {
    }
}
