package z2;

import a4.l0;
import android.net.Uri;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.extractor.ts.PsExtractor;
import java.io.IOException;
import java.util.Map;
import k2.j2;
import p2.b0;
import z2.i0;

/* JADX INFO: compiled from: PsExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements p2.l {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final p2.r f37000l = new p2.r() { // from class: z2.z
        @Override // p2.r
        public final p2.l[] createExtractors() {
            return a0.e();
        }

        @Override // p2.r
        public /* synthetic */ p2.l[] createExtractors(Uri uri, Map map) {
            return p2.q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l0 f37001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray<a> f37002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a4.c0 f37003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final y f37004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f37006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f37007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f37008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private x f37009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private p2.n f37010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f37011k;

    /* JADX INFO: compiled from: PsExtractor.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m f37012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final l0 f37013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final a4.b0 f37014c = new a4.b0(new byte[64]);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f37015d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f37016e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f37017f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f37018g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f37019h;

        public a(m mVar, l0 l0Var) {
            this.f37012a = mVar;
            this.f37013b = l0Var;
        }

        private void b() {
            this.f37014c.r(8);
            this.f37015d = this.f37014c.g();
            this.f37016e = this.f37014c.g();
            this.f37014c.r(6);
            this.f37018g = this.f37014c.h(8);
        }

        private void c() {
            this.f37019h = 0L;
            if (this.f37015d) {
                this.f37014c.r(4);
                long jH = ((long) this.f37014c.h(3)) << 30;
                this.f37014c.r(1);
                long jH2 = jH | ((long) (this.f37014c.h(15) << 15));
                this.f37014c.r(1);
                long jH3 = jH2 | ((long) this.f37014c.h(15));
                this.f37014c.r(1);
                if (!this.f37017f && this.f37016e) {
                    this.f37014c.r(4);
                    long jH4 = ((long) this.f37014c.h(3)) << 30;
                    this.f37014c.r(1);
                    long jH5 = jH4 | ((long) (this.f37014c.h(15) << 15));
                    this.f37014c.r(1);
                    long jH6 = jH5 | ((long) this.f37014c.h(15));
                    this.f37014c.r(1);
                    this.f37013b.b(jH6);
                    this.f37017f = true;
                }
                this.f37019h = this.f37013b.b(jH3);
            }
        }

        public void a(a4.c0 c0Var) throws j2 {
            c0Var.j(this.f37014c.f141a, 0, 3);
            this.f37014c.p(0);
            b();
            c0Var.j(this.f37014c.f141a, 0, this.f37018g);
            this.f37014c.p(0);
            c();
            this.f37012a.packetStarted(this.f37019h, 4);
            this.f37012a.a(c0Var);
            this.f37012a.b();
        }

        public void d() {
            this.f37017f = false;
            this.f37012a.seek();
        }
    }

    public a0() {
        this(new l0(0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ p2.l[] e() {
        return new p2.l[]{new a0()};
    }

    private void f(long j10) {
        if (this.f37011k) {
            return;
        }
        this.f37011k = true;
        if (this.f37004d.c() == C.TIME_UNSET) {
            this.f37010j.h(new b0.b(this.f37004d.c()));
            return;
        }
        x xVar = new x(this.f37004d.d(), this.f37004d.c(), j10);
        this.f37009i = xVar;
        this.f37010j.h(xVar.b());
    }

    @Override // p2.l
    public int a(p2.m mVar, p2.a0 a0Var) throws IOException {
        m nVar;
        a4.a.i(this.f37010j);
        long length = mVar.getLength();
        if ((length != -1) && !this.f37004d.e()) {
            return this.f37004d.g(mVar, a0Var);
        }
        f(length);
        x xVar = this.f37009i;
        if (xVar != null && xVar.d()) {
            return this.f37009i.c(mVar, a0Var);
        }
        mVar.resetPeekPosition();
        long peekPosition = length != -1 ? length - mVar.getPeekPosition() : -1L;
        if ((peekPosition != -1 && peekPosition < 4) || !mVar.peekFully(this.f37003c.d(), 0, 4, true)) {
            return -1;
        }
        this.f37003c.P(0);
        int iN = this.f37003c.n();
        if (iN == 441) {
            return -1;
        }
        if (iN == 442) {
            mVar.peekFully(this.f37003c.d(), 0, 10);
            this.f37003c.P(9);
            mVar.skipFully((this.f37003c.D() & 7) + 14);
            return 0;
        }
        if (iN == 443) {
            mVar.peekFully(this.f37003c.d(), 0, 2);
            this.f37003c.P(0);
            mVar.skipFully(this.f37003c.J() + 6);
            return 0;
        }
        if (((iN & (-256)) >> 8) != 1) {
            mVar.skipFully(1);
            return 0;
        }
        int i10 = iN & 255;
        a aVar = this.f37002b.get(i10);
        if (!this.f37005e) {
            if (aVar == null) {
                if (i10 == 189) {
                    nVar = new c();
                    this.f37006f = true;
                    this.f37008h = mVar.getPosition();
                } else if ((i10 & 224) == 192) {
                    nVar = new t();
                    this.f37006f = true;
                    this.f37008h = mVar.getPosition();
                } else if ((i10 & PsExtractor.VIDEO_STREAM_MASK) == 224) {
                    nVar = new n();
                    this.f37007g = true;
                    this.f37008h = mVar.getPosition();
                } else {
                    nVar = null;
                }
                if (nVar != null) {
                    nVar.c(this.f37010j, new i0.d(i10, 256));
                    aVar = new a(nVar, this.f37001a);
                    this.f37002b.put(i10, aVar);
                }
            }
            if (mVar.getPosition() > ((this.f37006f && this.f37007g) ? this.f37008h + 8192 : 1048576L)) {
                this.f37005e = true;
                this.f37010j.endTracks();
            }
        }
        mVar.peekFully(this.f37003c.d(), 0, 2);
        this.f37003c.P(0);
        int iJ = this.f37003c.J() + 6;
        if (aVar == null) {
            mVar.skipFully(iJ);
        } else {
            this.f37003c.L(iJ);
            mVar.readFully(this.f37003c.d(), 0, iJ);
            this.f37003c.P(6);
            aVar.a(this.f37003c);
            a4.c0 c0Var = this.f37003c;
            c0Var.O(c0Var.b());
        }
        return 0;
    }

    @Override // p2.l
    public void b(p2.n nVar) {
        this.f37010j = nVar;
    }

    @Override // p2.l
    public boolean c(p2.m mVar) throws IOException {
        byte[] bArr = new byte[14];
        mVar.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        mVar.advancePeekPosition(bArr[13] & 7);
        mVar.peekFully(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        boolean z10 = this.f37001a.e() == C.TIME_UNSET;
        if (!z10) {
            long jC = this.f37001a.c();
            z10 = (jC == C.TIME_UNSET || jC == 0 || jC == j11) ? false : true;
        }
        if (z10) {
            this.f37001a.g(j11);
        }
        x xVar = this.f37009i;
        if (xVar != null) {
            xVar.h(j11);
        }
        for (int i10 = 0; i10 < this.f37002b.size(); i10++) {
            this.f37002b.valueAt(i10).d();
        }
    }

    public a0(l0 l0Var) {
        this.f37001a = l0Var;
        this.f37003c = new a4.c0(4096);
        this.f37002b = new SparseArray<>();
        this.f37004d = new y();
    }

    @Override // p2.l
    public void release() {
    }
}
