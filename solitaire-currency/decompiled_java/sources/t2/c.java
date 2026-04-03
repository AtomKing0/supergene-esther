package t2;

import a4.c0;
import android.net.Uri;
import androidx.media3.common.C;
import java.io.IOException;
import java.util.Map;
import p2.a0;
import p2.b0;
import p2.l;
import p2.m;
import p2.n;
import p2.q;
import p2.r;

/* JADX INFO: compiled from: FlvExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements l {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final r f34037q = new r() { // from class: t2.b
        @Override // p2.r
        public final l[] createExtractors() {
            return c.g();
        }

        @Override // p2.r
        public /* synthetic */ l[] createExtractors(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private n f34043f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f34045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f34046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f34047j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f34048k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f34049l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f34050m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f34051n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private a f34052o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private f f34053p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c0 f34038a = new c0(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c0 f34039b = new c0(9);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c0 f34040c = new c0(11);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c0 f34041d = new c0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f34042e = new d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f34044g = 1;

    private void e() {
        if (this.f34051n) {
            return;
        }
        this.f34043f.h(new b0.b(C.TIME_UNSET));
        this.f34051n = true;
    }

    private long f() {
        if (this.f34045h) {
            return this.f34046i + this.f34050m;
        }
        if (this.f34042e.d() == C.TIME_UNSET) {
            return 0L;
        }
        return this.f34050m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] g() {
        return new l[]{new c()};
    }

    private c0 h(m mVar) throws IOException {
        if (this.f34049l > this.f34041d.b()) {
            c0 c0Var = this.f34041d;
            c0Var.N(new byte[Math.max(c0Var.b() * 2, this.f34049l)], 0);
        } else {
            this.f34041d.P(0);
        }
        this.f34041d.O(this.f34049l);
        mVar.readFully(this.f34041d.d(), 0, this.f34049l);
        return this.f34041d;
    }

    private boolean i(m mVar) throws IOException {
        if (!mVar.readFully(this.f34039b.d(), 0, 9, true)) {
            return false;
        }
        this.f34039b.P(0);
        this.f34039b.Q(4);
        int iD = this.f34039b.D();
        boolean z10 = (iD & 4) != 0;
        boolean z11 = (iD & 1) != 0;
        if (z10 && this.f34052o == null) {
            this.f34052o = new a(this.f34043f.track(8, 1));
        }
        if (z11 && this.f34053p == null) {
            this.f34053p = new f(this.f34043f.track(9, 2));
        }
        this.f34043f.endTracks();
        this.f34047j = (this.f34039b.n() - 9) + 4;
        this.f34044g = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean j(p2.m r10) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.f()
            int r2 = r9.f34048k
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L23
            t2.a r3 = r9.f34052o
            if (r3 == 0) goto L23
            r9.e()
            t2.a r2 = r9.f34052o
            a4.c0 r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
        L21:
            r0 = r6
            goto L75
        L23:
            r3 = 9
            if (r2 != r3) goto L39
            t2.f r3 = r9.f34053p
            if (r3 == 0) goto L39
            r9.e()
            t2.f r2 = r9.f34053p
            a4.c0 r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
            goto L21
        L39:
            r3 = 18
            if (r2 != r3) goto L6e
            boolean r2 = r9.f34051n
            if (r2 != 0) goto L6e
            t2.d r2 = r9.f34042e
            a4.c0 r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
            t2.d r0 = r9.f34042e
            long r0 = r0.d()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L21
            p2.n r2 = r9.f34043f
            p2.z r3 = new p2.z
            t2.d r7 = r9.f34042e
            long[] r7 = r7.e()
            t2.d r8 = r9.f34042e
            long[] r8 = r8.f()
            r3.<init>(r7, r8, r0)
            r2.h(r3)
            r9.f34051n = r6
            goto L21
        L6e:
            int r0 = r9.f34049l
            r10.skipFully(r0)
            r10 = 0
            r0 = r10
        L75:
            boolean r1 = r9.f34045h
            if (r1 != 0) goto L8f
            if (r10 == 0) goto L8f
            r9.f34045h = r6
            t2.d r10 = r9.f34042e
            long r1 = r10.d()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L8b
            long r1 = r9.f34050m
            long r1 = -r1
            goto L8d
        L8b:
            r1 = 0
        L8d:
            r9.f34046i = r1
        L8f:
            r10 = 4
            r9.f34047j = r10
            r10 = 2
            r9.f34044g = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.c.j(p2.m):boolean");
    }

    private boolean k(m mVar) throws IOException {
        if (!mVar.readFully(this.f34040c.d(), 0, 11, true)) {
            return false;
        }
        this.f34040c.P(0);
        this.f34048k = this.f34040c.D();
        this.f34049l = this.f34040c.G();
        this.f34050m = this.f34040c.G();
        this.f34050m = (((long) (this.f34040c.D() << 24)) | this.f34050m) * 1000;
        this.f34040c.Q(3);
        this.f34044g = 4;
        return true;
    }

    private void l(m mVar) throws IOException {
        mVar.skipFully(this.f34047j);
        this.f34047j = 0;
        this.f34044g = 3;
    }

    @Override // p2.l
    public int a(m mVar, a0 a0Var) throws IOException {
        a4.a.i(this.f34043f);
        while (true) {
            int i10 = this.f34044g;
            if (i10 != 1) {
                if (i10 == 2) {
                    l(mVar);
                } else if (i10 != 3) {
                    if (i10 != 4) {
                        throw new IllegalStateException();
                    }
                    if (j(mVar)) {
                        return 0;
                    }
                } else if (!k(mVar)) {
                    return -1;
                }
            } else if (!i(mVar)) {
                return -1;
            }
        }
    }

    @Override // p2.l
    public void b(n nVar) {
        this.f34043f = nVar;
    }

    @Override // p2.l
    public boolean c(m mVar) throws IOException {
        mVar.peekFully(this.f34038a.d(), 0, 3);
        this.f34038a.P(0);
        if (this.f34038a.G() != 4607062) {
            return false;
        }
        mVar.peekFully(this.f34038a.d(), 0, 2);
        this.f34038a.P(0);
        if ((this.f34038a.J() & 250) != 0) {
            return false;
        }
        mVar.peekFully(this.f34038a.d(), 0, 4);
        this.f34038a.P(0);
        int iN = this.f34038a.n();
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(iN);
        mVar.peekFully(this.f34038a.d(), 0, 4);
        this.f34038a.P(0);
        return this.f34038a.n() == 0;
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        if (j10 == 0) {
            this.f34044g = 1;
            this.f34045h = false;
        } else {
            this.f34044g = 3;
        }
        this.f34047j = 0;
    }

    @Override // p2.l
    public void release() {
    }
}
