package z2;

import android.net.Uri;
import androidx.media3.common.C;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import k2.j2;
import p2.b0;
import z2.i0;

/* JADX INFO: compiled from: AdtsExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements p2.l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final p2.r f37074m = new p2.r() { // from class: z2.g
        @Override // p2.r
        public final p2.l[] createExtractors() {
            return h.h();
        }

        @Override // p2.r
        public /* synthetic */ p2.l[] createExtractors(Uri uri, Map map) {
            return p2.q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f37076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a4.c0 f37077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a4.c0 f37078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a4.b0 f37079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private p2.n f37080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f37081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f37082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f37083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f37084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f37085k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f37086l;

    public h() {
        this(0);
    }

    private void e(p2.m mVar) throws IOException {
        int iH;
        if (this.f37084j) {
            return;
        }
        this.f37083i = -1;
        mVar.resetPeekPosition();
        long j10 = 0;
        if (mVar.getPosition() == 0) {
            j(mVar);
        }
        int i10 = 0;
        int i11 = 0;
        do {
            try {
                if (!mVar.peekFully(this.f37078d.d(), 0, 2, true)) {
                    break;
                }
                this.f37078d.P(0);
                if (!i.k(this.f37078d.J())) {
                    break;
                }
                if (!mVar.peekFully(this.f37078d.d(), 0, 4, true)) {
                    break;
                }
                this.f37079e.p(14);
                iH = this.f37079e.h(13);
                if (iH <= 6) {
                    this.f37084j = true;
                    throw j2.a("Malformed ADTS stream", null);
                }
                j10 += (long) iH;
                i11++;
                if (i11 == 1000) {
                    break;
                }
            } catch (EOFException unused) {
            }
        } while (mVar.advancePeekPosition(iH - 6, true));
        i10 = i11;
        mVar.resetPeekPosition();
        if (i10 > 0) {
            this.f37083i = (int) (j10 / ((long) i10));
        } else {
            this.f37083i = -1;
        }
        this.f37084j = true;
    }

    private static int f(int i10, long j10) {
        return (int) (((((long) i10) * 8) * 1000000) / j10);
    }

    private p2.b0 g(long j10, boolean z10) {
        return new p2.e(j10, this.f37082h, f(this.f37083i, this.f37076b.i()), this.f37083i, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ p2.l[] h() {
        return new p2.l[]{new h()};
    }

    private void i(long j10, boolean z10) {
        if (this.f37086l) {
            return;
        }
        boolean z11 = (this.f37075a & 1) != 0 && this.f37083i > 0;
        if (z11 && this.f37076b.i() == C.TIME_UNSET && !z10) {
            return;
        }
        if (!z11 || this.f37076b.i() == C.TIME_UNSET) {
            this.f37080f.h(new b0.b(C.TIME_UNSET));
        } else {
            this.f37080f.h(g(j10, (this.f37075a & 2) != 0));
        }
        this.f37086l = true;
    }

    private int j(p2.m mVar) throws IOException {
        int i10 = 0;
        while (true) {
            mVar.peekFully(this.f37078d.d(), 0, 10);
            this.f37078d.P(0);
            if (this.f37078d.G() != 4801587) {
                break;
            }
            this.f37078d.Q(3);
            int iC = this.f37078d.C();
            i10 += iC + 10;
            mVar.advancePeekPosition(iC);
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i10);
        if (this.f37082h == -1) {
            this.f37082h = i10;
        }
        return i10;
    }

    @Override // p2.l
    public int a(p2.m mVar, p2.a0 a0Var) throws IOException {
        a4.a.i(this.f37080f);
        long length = mVar.getLength();
        int i10 = this.f37075a;
        if (((i10 & 2) == 0 && ((i10 & 1) == 0 || length == -1)) ? false : true) {
            e(mVar);
        }
        int i11 = mVar.read(this.f37077c.d(), 0, 2048);
        boolean z10 = i11 == -1;
        i(length, z10);
        if (z10) {
            return -1;
        }
        this.f37077c.P(0);
        this.f37077c.O(i11);
        if (!this.f37085k) {
            this.f37076b.packetStarted(this.f37081g, 4);
            this.f37085k = true;
        }
        this.f37076b.a(this.f37077c);
        return 0;
    }

    @Override // p2.l
    public void b(p2.n nVar) {
        this.f37080f = nVar;
        this.f37076b.c(nVar, new i0.d(0, 1));
        nVar.endTracks();
    }

    @Override // p2.l
    public boolean c(p2.m mVar) throws IOException {
        int iJ = j(mVar);
        int i10 = iJ;
        int i11 = 0;
        int i12 = 0;
        do {
            mVar.peekFully(this.f37078d.d(), 0, 2);
            this.f37078d.P(0);
            if (i.k(this.f37078d.J())) {
                i11++;
                if (i11 >= 4 && i12 > 188) {
                    return true;
                }
                mVar.peekFully(this.f37078d.d(), 0, 4);
                this.f37079e.p(14);
                int iH = this.f37079e.h(13);
                if (iH <= 6) {
                    i10++;
                    mVar.resetPeekPosition();
                    mVar.advancePeekPosition(i10);
                } else {
                    mVar.advancePeekPosition(iH - 6);
                    i12 += iH;
                }
            } else {
                i10++;
                mVar.resetPeekPosition();
                mVar.advancePeekPosition(i10);
            }
            i11 = 0;
            i12 = 0;
        } while (i10 - iJ < 8192);
        return false;
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        this.f37085k = false;
        this.f37076b.seek();
        this.f37081g = j11;
    }

    public h(int i10) {
        this.f37075a = (i10 & 2) != 0 ? i10 | 1 : i10;
        this.f37076b = new i(true);
        this.f37077c = new a4.c0(2048);
        this.f37083i = -1;
        this.f37082h = -1L;
        a4.c0 c0Var = new a4.c0(10);
        this.f37078d = c0Var;
        this.f37079e = new a4.b0(c0Var.d());
    }

    @Override // p2.l
    public void release() {
    }
}
