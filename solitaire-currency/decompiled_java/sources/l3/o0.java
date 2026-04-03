package l3;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import k2.f3;
import k2.j2;
import k2.o1;
import k2.p1;
import l3.g0;
import l3.s;
import l3.t0;
import l3.x;
import o2.w;
import p2.b0;
import z3.f0;
import z3.g0;
import z3.o;

/* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
/* JADX INFO: loaded from: classes2.dex */
final class o0 implements x, p2.n, g0.b<a>, g0.f, t0.d {
    private static final Map<String, String> M = z();
    private static final o1 N = new o1.b().S("icy").e0(MimeTypes.APPLICATION_ICY).E();
    private boolean A;
    private boolean C;
    private boolean D;
    private int E;
    private boolean F;
    private long G;
    private boolean I;
    private int J;
    private boolean K;
    private boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f30590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z3.k f30591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o2.y f30592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z3.f0 f30593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g0.a f30594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final w.a f30595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f30596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final z3.b f30597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final String f30598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f30599j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final j0 f30601l;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private x.a f30606q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private g3.b f30607r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f30610u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f30611v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f30612w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private e f30613x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private p2.b0 f30614y;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final z3.g0 f30600k = new z3.g0("ProgressiveMediaPeriod");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final a4.g f30602m = new a4.g();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Runnable f30603n = new Runnable() { // from class: l3.k0
        @Override // java.lang.Runnable
        public final void run() {
            this.f30578a.I();
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Runnable f30604o = new Runnable() { // from class: l3.l0
        @Override // java.lang.Runnable
        public final void run() {
            this.f30581a.F();
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Handler f30605p = a4.o0.u();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private d[] f30609t = new d[0];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private t0[] f30608s = new t0[0];
    private long H = C.TIME_UNSET;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f30615z = C.TIME_UNSET;
    private int B = 1;

    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    final class a implements g0.e, s.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f30617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final z3.l0 f30618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final j0 f30619d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final p2.n f30620e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final a4.g f30621f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile boolean f30623h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f30625j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        private p2.e0 f30627l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f30628m;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final p2.a0 f30622g = new p2.a0();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f30624i = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f30616a = t.a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private z3.o f30626k = g(0);

        public a(Uri uri, z3.k kVar, j0 j0Var, p2.n nVar, a4.g gVar) {
            this.f30617b = uri;
            this.f30618c = new z3.l0(kVar);
            this.f30619d = j0Var;
            this.f30620e = nVar;
            this.f30621f = gVar;
        }

        private z3.o g(long j10) {
            return new o.b().h(this.f30617b).g(j10).f(o0.this.f30598i).b(6).e(o0.M).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(long j10, long j11) {
            this.f30622g.f32443a = j10;
            this.f30625j = j11;
            this.f30624i = true;
            this.f30628m = false;
        }

        @Override // l3.s.a
        public void a(a4.c0 c0Var) {
            long jMax = !this.f30628m ? this.f30625j : Math.max(o0.this.B(true), this.f30625j);
            int iA = c0Var.a();
            p2.e0 e0Var = (p2.e0) a4.a.e(this.f30627l);
            e0Var.e(c0Var, iA);
            e0Var.a(jMax, 1, iA, 0, null);
            this.f30628m = true;
        }

        @Override // z3.g0.e
        public void cancelLoad() {
            this.f30623h = true;
        }

        @Override // z3.g0.e
        public void load() throws IOException {
            int iB = 0;
            while (iB == 0 && !this.f30623h) {
                try {
                    long j10 = this.f30622g.f32443a;
                    z3.o oVarG = g(j10);
                    this.f30626k = oVarG;
                    long jA = this.f30618c.a(oVarG);
                    if (jA != -1) {
                        jA += j10;
                        o0.this.N();
                    }
                    long j11 = jA;
                    o0.this.f30607r = g3.b.a(this.f30618c.getResponseHeaders());
                    z3.h sVar = this.f30618c;
                    if (o0.this.f30607r != null && o0.this.f30607r.f25876f != -1) {
                        sVar = new s(this.f30618c, o0.this.f30607r.f25876f, this);
                        p2.e0 e0VarC = o0.this.C();
                        this.f30627l = e0VarC;
                        e0VarC.f(o0.N);
                    }
                    long currentInputPosition = j10;
                    this.f30619d.a(sVar, this.f30617b, this.f30618c.getResponseHeaders(), j10, j11, this.f30620e);
                    if (o0.this.f30607r != null) {
                        this.f30619d.disableSeekingOnMp3Streams();
                    }
                    if (this.f30624i) {
                        this.f30619d.seek(currentInputPosition, this.f30625j);
                        this.f30624i = false;
                    }
                    while (true) {
                        long j12 = currentInputPosition;
                        while (iB == 0 && !this.f30623h) {
                            try {
                                this.f30621f.a();
                                iB = this.f30619d.b(this.f30622g);
                                currentInputPosition = this.f30619d.getCurrentInputPosition();
                                if (currentInputPosition > o0.this.f30599j + j12) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f30621f.c();
                        o0.this.f30605p.post(o0.this.f30604o);
                    }
                    if (iB == 1) {
                        iB = 0;
                    } else if (this.f30619d.getCurrentInputPosition() != -1) {
                        this.f30622g.f32443a = this.f30619d.getCurrentInputPosition();
                    }
                    z3.n.a(this.f30618c);
                } catch (Throwable th) {
                    if (iB != 1 && this.f30619d.getCurrentInputPosition() != -1) {
                        this.f30622g.f32443a = this.f30619d.getCurrentInputPosition();
                    }
                    z3.n.a(this.f30618c);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    interface b {
        void onSourceInfoRefreshed(long j10, boolean z10, boolean z11);
    }

    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    private final class c implements u0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f30630a;

        public c(int i10) {
            this.f30630a = i10;
        }

        @Override // l3.u0
        public int a(p1 p1Var, n2.g gVar, int i10) {
            return o0.this.S(this.f30630a, p1Var, gVar, i10);
        }

        @Override // l3.u0
        public boolean isReady() {
            return o0.this.E(this.f30630a);
        }

        @Override // l3.u0
        public void maybeThrowError() throws IOException {
            o0.this.M(this.f30630a);
        }

        @Override // l3.u0
        public int skipData(long j10) {
            return o0.this.W(this.f30630a, j10);
        }
    }

    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f30633b;

        public d(int i10, boolean z10) {
            this.f30632a = i10;
            this.f30633b = z10;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f30632a == dVar.f30632a && this.f30633b == dVar.f30633b;
        }

        public int hashCode() {
            return (this.f30632a * 31) + (this.f30633b ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e1 f30634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f30635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean[] f30636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean[] f30637d;

        public e(e1 e1Var, boolean[] zArr) {
            this.f30634a = e1Var;
            this.f30635b = zArr;
            int i10 = e1Var.f30517a;
            this.f30636c = new boolean[i10];
            this.f30637d = new boolean[i10];
        }
    }

    public o0(Uri uri, z3.k kVar, j0 j0Var, o2.y yVar, w.a aVar, z3.f0 f0Var, g0.a aVar2, b bVar, z3.b bVar2, @Nullable String str, int i10) {
        this.f30590a = uri;
        this.f30591b = kVar;
        this.f30592c = yVar;
        this.f30595f = aVar;
        this.f30593d = f0Var;
        this.f30594e = aVar2;
        this.f30596g = bVar;
        this.f30597h = bVar2;
        this.f30598i = str;
        this.f30599j = i10;
        this.f30601l = j0Var;
    }

    private int A() {
        int iA = 0;
        for (t0 t0Var : this.f30608s) {
            iA += t0Var.A();
        }
        return iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long B(boolean z10) {
        long jMax = Long.MIN_VALUE;
        for (int i10 = 0; i10 < this.f30608s.length; i10++) {
            if (z10 || ((e) a4.a.e(this.f30613x)).f30636c[i10]) {
                jMax = Math.max(jMax, this.f30608s[i10].t());
            }
        }
        return jMax;
    }

    private boolean D() {
        return this.H != C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        if (this.L) {
            return;
        }
        ((x.a) a4.a.e(this.f30606q)).c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.L || this.f30611v || !this.f30610u || this.f30614y == null) {
            return;
        }
        for (t0 t0Var : this.f30608s) {
            if (t0Var.z() == null) {
                return;
            }
        }
        this.f30602m.c();
        int length = this.f30608s.length;
        c1[] c1VarArr = new c1[length];
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            o1 o1VarE = (o1) a4.a.e(this.f30608s[i10].z());
            String str = o1VarE.f29347l;
            boolean zL = a4.x.l(str);
            boolean z10 = zL || a4.x.o(str);
            zArr[i10] = z10;
            this.f30612w = z10 | this.f30612w;
            g3.b bVar = this.f30607r;
            if (bVar != null) {
                if (zL || this.f30609t[i10].f30633b) {
                    c3.a aVar = o1VarE.f29345j;
                    o1VarE = o1VarE.b().X(aVar == null ? new c3.a(bVar) : aVar.a(bVar)).E();
                }
                if (zL && o1VarE.f29341f == -1 && o1VarE.f29342g == -1 && bVar.f25871a != -1) {
                    o1VarE = o1VarE.b().G(bVar.f25871a).E();
                }
            }
            c1VarArr[i10] = new c1(Integer.toString(i10), o1VarE.c(this.f30592c.b(o1VarE)));
        }
        this.f30613x = new e(new e1(c1VarArr), zArr);
        this.f30611v = true;
        ((x.a) a4.a.e(this.f30606q)).d(this);
    }

    private void J(int i10) {
        x();
        e eVar = this.f30613x;
        boolean[] zArr = eVar.f30637d;
        if (zArr[i10]) {
            return;
        }
        o1 o1VarC = eVar.f30634a.b(i10).c(0);
        this.f30594e.h(a4.x.i(o1VarC.f29347l), o1VarC, 0, null, this.G);
        zArr[i10] = true;
    }

    private void K(int i10) {
        x();
        boolean[] zArr = this.f30613x.f30635b;
        if (this.I && zArr[i10]) {
            if (this.f30608s[i10].D(false)) {
                return;
            }
            this.H = 0L;
            this.I = false;
            this.D = true;
            this.G = 0L;
            this.J = 0;
            for (t0 t0Var : this.f30608s) {
                t0Var.N();
            }
            ((x.a) a4.a.e(this.f30606q)).c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.f30605p.post(new Runnable() { // from class: l3.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30584a.G();
            }
        });
    }

    private p2.e0 R(d dVar) {
        int length = this.f30608s.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (dVar.equals(this.f30609t[i10])) {
                return this.f30608s[i10];
            }
        }
        t0 t0VarK = t0.k(this.f30597h, this.f30592c, this.f30595f);
        t0VarK.T(this);
        int i11 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.f30609t, i11);
        dVarArr[length] = dVar;
        this.f30609t = (d[]) a4.o0.k(dVarArr);
        t0[] t0VarArr = (t0[]) Arrays.copyOf(this.f30608s, i11);
        t0VarArr[length] = t0VarK;
        this.f30608s = (t0[]) a4.o0.k(t0VarArr);
        return t0VarK;
    }

    private boolean U(boolean[] zArr, long j10) {
        int length = this.f30608s.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (!this.f30608s[i10].Q(j10, false) && (zArr[i10] || !this.f30612w)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public void H(p2.b0 b0Var) {
        this.f30614y = this.f30607r == null ? b0Var : new b0.b(C.TIME_UNSET);
        this.f30615z = b0Var.getDurationUs();
        boolean z10 = !this.F && b0Var.getDurationUs() == C.TIME_UNSET;
        this.A = z10;
        this.B = z10 ? 7 : 1;
        this.f30596g.onSourceInfoRefreshed(this.f30615z, b0Var.isSeekable(), this.A);
        if (this.f30611v) {
            return;
        }
        I();
    }

    private void X() {
        a aVar = new a(this.f30590a, this.f30591b, this.f30601l, this, this.f30602m);
        if (this.f30611v) {
            a4.a.g(D());
            long j10 = this.f30615z;
            if (j10 != C.TIME_UNSET && this.H > j10) {
                this.K = true;
                this.H = C.TIME_UNSET;
                return;
            }
            aVar.h(((p2.b0) a4.a.e(this.f30614y)).getSeekPoints(this.H).f32444a.f32450b, this.H);
            for (t0 t0Var : this.f30608s) {
                t0Var.R(this.H);
            }
            this.H = C.TIME_UNSET;
        }
        this.J = A();
        this.f30594e.u(new t(aVar.f30616a, aVar.f30626k, this.f30600k.n(aVar, this, this.f30593d.getMinimumLoadableRetryCount(this.B))), 1, -1, null, 0, null, aVar.f30625j, this.f30615z);
    }

    private boolean Y() {
        return this.D || D();
    }

    private void x() {
        a4.a.g(this.f30611v);
        a4.a.e(this.f30613x);
        a4.a.e(this.f30614y);
    }

    private boolean y(a aVar, int i10) {
        p2.b0 b0Var;
        if (this.F || !((b0Var = this.f30614y) == null || b0Var.getDurationUs() == C.TIME_UNSET)) {
            this.J = i10;
            return true;
        }
        if (this.f30611v && !Y()) {
            this.I = true;
            return false;
        }
        this.D = this.f30611v;
        this.G = 0L;
        this.J = 0;
        for (t0 t0Var : this.f30608s) {
            t0Var.N();
        }
        aVar.h(0L, 0L);
        return true;
    }

    private static Map<String, String> z() {
        HashMap map = new HashMap();
        map.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        return Collections.unmodifiableMap(map);
    }

    p2.e0 C() {
        return R(new d(0, true));
    }

    boolean E(int i10) {
        return !Y() && this.f30608s[i10].D(this.K);
    }

    void L() throws IOException {
        this.f30600k.k(this.f30593d.getMinimumLoadableRetryCount(this.B));
    }

    void M(int i10) throws IOException {
        this.f30608s[i10].G();
        L();
    }

    @Override // z3.g0.b
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void e(a aVar, long j10, long j11, boolean z10) {
        z3.l0 l0Var = aVar.f30618c;
        t tVar = new t(aVar.f30616a, aVar.f30626k, l0Var.d(), l0Var.e(), j10, j11, l0Var.c());
        this.f30593d.onLoadTaskConcluded(aVar.f30616a);
        this.f30594e.o(tVar, 1, -1, null, 0, null, aVar.f30625j, this.f30615z);
        if (z10) {
            return;
        }
        for (t0 t0Var : this.f30608s) {
            t0Var.N();
        }
        if (this.E > 0) {
            ((x.a) a4.a.e(this.f30606q)).c(this);
        }
    }

    @Override // z3.g0.b
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void d(a aVar, long j10, long j11) {
        p2.b0 b0Var;
        if (this.f30615z == C.TIME_UNSET && (b0Var = this.f30614y) != null) {
            boolean zIsSeekable = b0Var.isSeekable();
            long jB = B(true);
            long j12 = jB == Long.MIN_VALUE ? 0L : jB + 10000;
            this.f30615z = j12;
            this.f30596g.onSourceInfoRefreshed(j12, zIsSeekable, this.A);
        }
        z3.l0 l0Var = aVar.f30618c;
        t tVar = new t(aVar.f30616a, aVar.f30626k, l0Var.d(), l0Var.e(), j10, j11, l0Var.c());
        this.f30593d.onLoadTaskConcluded(aVar.f30616a);
        this.f30594e.q(tVar, 1, -1, null, 0, null, aVar.f30625j, this.f30615z);
        this.K = true;
        ((x.a) a4.a.e(this.f30606q)).c(this);
    }

    @Override // z3.g0.b
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public g0.c c(a aVar, long j10, long j11, IOException iOException, int i10) {
        boolean z10;
        a aVar2;
        g0.c cVarG;
        z3.l0 l0Var = aVar.f30618c;
        t tVar = new t(aVar.f30616a, aVar.f30626k, l0Var.d(), l0Var.e(), j10, j11, l0Var.c());
        long jA = this.f30593d.a(new f0.a(tVar, new w(1, -1, null, 0, null, a4.o0.P0(aVar.f30625j), a4.o0.P0(this.f30615z)), iOException, i10));
        if (jA == C.TIME_UNSET) {
            cVarG = z3.g0.f37403g;
        } else {
            int iA = A();
            if (iA > this.J) {
                aVar2 = aVar;
                z10 = true;
            } else {
                z10 = false;
                aVar2 = aVar;
            }
            cVarG = y(aVar2, iA) ? z3.g0.g(z10, jA) : z3.g0.f37402f;
        }
        boolean z11 = !cVarG.c();
        this.f30594e.s(tVar, 1, -1, null, 0, null, aVar.f30625j, this.f30615z, iOException, z11);
        if (z11) {
            this.f30593d.onLoadTaskConcluded(aVar.f30616a);
        }
        return cVarG;
    }

    int S(int i10, p1 p1Var, n2.g gVar, int i11) {
        if (Y()) {
            return -3;
        }
        J(i10);
        int iK = this.f30608s[i10].K(p1Var, gVar, i11, this.K);
        if (iK == -3) {
            K(i10);
        }
        return iK;
    }

    public void T() {
        if (this.f30611v) {
            for (t0 t0Var : this.f30608s) {
                t0Var.J();
            }
        }
        this.f30600k.m(this);
        this.f30605p.removeCallbacksAndMessages(null);
        this.f30606q = null;
        this.L = true;
    }

    int W(int i10, long j10) {
        if (Y()) {
            return 0;
        }
        J(i10);
        t0 t0Var = this.f30608s[i10];
        int iY = t0Var.y(j10, this.K);
        t0Var.U(iY);
        if (iY == 0) {
            K(i10);
        }
        return iY;
    }

    @Override // l3.x, l3.v0
    public boolean a(long j10) {
        if (this.K || this.f30600k.h() || this.I) {
            return false;
        }
        if (this.f30611v && this.E == 0) {
            return false;
        }
        boolean zE = this.f30602m.e();
        if (this.f30600k.i()) {
            return zE;
        }
        X();
        return true;
    }

    @Override // l3.x
    public void b(x.a aVar, long j10) {
        this.f30606q = aVar;
        this.f30602m.e();
        X();
    }

    @Override // l3.x
    public void discardBuffer(long j10, boolean z10) {
        x();
        if (D()) {
            return;
        }
        boolean[] zArr = this.f30613x.f30636c;
        int length = this.f30608s.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f30608s[i10].o(j10, z10, zArr[i10]);
        }
    }

    @Override // p2.n
    public void endTracks() {
        this.f30610u = true;
        this.f30605p.post(this.f30603n);
    }

    @Override // l3.t0.d
    public void f(o1 o1Var) {
        this.f30605p.post(this.f30603n);
    }

    @Override // l3.x
    public long g(x3.s[] sVarArr, boolean[] zArr, u0[] u0VarArr, boolean[] zArr2, long j10) {
        x3.s sVar;
        x();
        e eVar = this.f30613x;
        e1 e1Var = eVar.f30634a;
        boolean[] zArr3 = eVar.f30636c;
        int i10 = this.E;
        int i11 = 0;
        for (int i12 = 0; i12 < sVarArr.length; i12++) {
            u0 u0Var = u0VarArr[i12];
            if (u0Var != null && (sVarArr[i12] == null || !zArr[i12])) {
                int i13 = ((c) u0Var).f30630a;
                a4.a.g(zArr3[i13]);
                this.E--;
                zArr3[i13] = false;
                u0VarArr[i12] = null;
            }
        }
        boolean z10 = !this.C ? j10 == 0 : i10 != 0;
        for (int i14 = 0; i14 < sVarArr.length; i14++) {
            if (u0VarArr[i14] == null && (sVar = sVarArr[i14]) != null) {
                a4.a.g(sVar.length() == 1);
                a4.a.g(sVar.getIndexInTrackGroup(0) == 0);
                int iC = e1Var.c(sVar.getTrackGroup());
                a4.a.g(!zArr3[iC]);
                this.E++;
                zArr3[iC] = true;
                u0VarArr[i14] = new c(iC);
                zArr2[i14] = true;
                if (!z10) {
                    t0 t0Var = this.f30608s[iC];
                    z10 = (t0Var.Q(j10, true) || t0Var.w() == 0) ? false : true;
                }
            }
        }
        if (this.E == 0) {
            this.I = false;
            this.D = false;
            if (this.f30600k.i()) {
                t0[] t0VarArr = this.f30608s;
                int length = t0VarArr.length;
                while (i11 < length) {
                    t0VarArr[i11].p();
                    i11++;
                }
                this.f30600k.e();
            } else {
                t0[] t0VarArr2 = this.f30608s;
                int length2 = t0VarArr2.length;
                while (i11 < length2) {
                    t0VarArr2[i11].N();
                    i11++;
                }
            }
        } else if (z10) {
            j10 = seekToUs(j10);
            while (i11 < u0VarArr.length) {
                if (u0VarArr[i11] != null) {
                    zArr2[i11] = true;
                }
                i11++;
            }
        }
        this.C = true;
        return j10;
    }

    @Override // l3.x, l3.v0
    public long getBufferedPositionUs() {
        long jB;
        x();
        if (this.K || this.E == 0) {
            return Long.MIN_VALUE;
        }
        if (D()) {
            return this.H;
        }
        if (this.f30612w) {
            int length = this.f30608s.length;
            jB = Long.MAX_VALUE;
            for (int i10 = 0; i10 < length; i10++) {
                e eVar = this.f30613x;
                if (eVar.f30635b[i10] && eVar.f30636c[i10] && !this.f30608s[i10].C()) {
                    jB = Math.min(jB, this.f30608s[i10].t());
                }
            }
        } else {
            jB = Long.MAX_VALUE;
        }
        if (jB == Long.MAX_VALUE) {
            jB = B(false);
        }
        return jB == Long.MIN_VALUE ? this.G : jB;
    }

    @Override // l3.x, l3.v0
    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // l3.x
    public e1 getTrackGroups() {
        x();
        return this.f30613x.f30634a;
    }

    @Override // p2.n
    public void h(final p2.b0 b0Var) {
        this.f30605p.post(new Runnable() { // from class: l3.n0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30586a.H(b0Var);
            }
        });
    }

    @Override // l3.x
    public long i(long j10, f3 f3Var) {
        x();
        if (!this.f30614y.isSeekable()) {
            return 0L;
        }
        b0.a seekPoints = this.f30614y.getSeekPoints(j10);
        return f3Var.a(j10, seekPoints.f32444a.f32449a, seekPoints.f32445b.f32449a);
    }

    @Override // l3.x, l3.v0
    public boolean isLoading() {
        return this.f30600k.i() && this.f30602m.d();
    }

    @Override // l3.x
    public void maybeThrowPrepareError() throws IOException {
        L();
        if (this.K && !this.f30611v) {
            throw j2.a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // z3.g0.f
    public void onLoaderReleased() {
        for (t0 t0Var : this.f30608s) {
            t0Var.L();
        }
        this.f30601l.release();
    }

    @Override // l3.x
    public long readDiscontinuity() {
        if (!this.D) {
            return C.TIME_UNSET;
        }
        if (!this.K && A() <= this.J) {
            return C.TIME_UNSET;
        }
        this.D = false;
        return this.G;
    }

    @Override // l3.x
    public long seekToUs(long j10) {
        x();
        boolean[] zArr = this.f30613x.f30635b;
        if (!this.f30614y.isSeekable()) {
            j10 = 0;
        }
        int i10 = 0;
        this.D = false;
        this.G = j10;
        if (D()) {
            this.H = j10;
            return j10;
        }
        if (this.B != 7 && U(zArr, j10)) {
            return j10;
        }
        this.I = false;
        this.H = j10;
        this.K = false;
        if (this.f30600k.i()) {
            t0[] t0VarArr = this.f30608s;
            int length = t0VarArr.length;
            while (i10 < length) {
                t0VarArr[i10].p();
                i10++;
            }
            this.f30600k.e();
        } else {
            this.f30600k.f();
            t0[] t0VarArr2 = this.f30608s;
            int length2 = t0VarArr2.length;
            while (i10 < length2) {
                t0VarArr2[i10].N();
                i10++;
            }
        }
        return j10;
    }

    @Override // p2.n
    public p2.e0 track(int i10, int i11) {
        return R(new d(i10, false));
    }

    @Override // l3.x, l3.v0
    public void reevaluateBuffer(long j10) {
    }
}
