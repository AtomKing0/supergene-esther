package k2;

import a4.s;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import c4.l;
import com.ironsource.v8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import k2.b;
import k2.d;
import k2.i2;
import k2.i3;
import k2.k1;
import k2.n3;
import k2.r2;
import k2.s;
import k2.v2;
import l3.a0;
import l3.w0;

/* JADX INFO: compiled from: ExoPlayerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class y0 extends k2.e implements s {
    private final k2.d A;
    private final i3 B;
    private final t3 C;
    private final u3 D;
    private final long E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private boolean J;
    private int K;
    private f3 L;
    private l3.w0 M;
    private boolean N;
    private r2.b O;
    private b2 P;
    private b2 Q;

    @Nullable
    private o1 R;

    @Nullable
    private o1 S;

    @Nullable
    private AudioTrack T;

    @Nullable
    private Object U;

    @Nullable
    private Surface V;

    @Nullable
    private SurfaceHolder W;

    @Nullable
    private c4.l X;
    private boolean Y;

    @Nullable
    private TextureView Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private int f29619a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final x3.c0 f29620b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f29621b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final r2.b f29622c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private a4.g0 f29623c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a4.g f29624d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @Nullable
    private n2.e f29625d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f29626e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @Nullable
    private n2.e f29627e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final r2 f29628f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f29629f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a3[] f29630g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private m2.e f29631g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final x3.b0 f29632h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f29633h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a4.p f29634i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f29635i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final k1.f f29636j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private n3.f f29637j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final k1 f29638k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f29639k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final a4.s<r2.d> f29640l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f29641l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final CopyOnWriteArraySet<s.a> f29642m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    @Nullable
    private a4.e0 f29643m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final n3.b f29644n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f29645n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List<e> f29646o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private boolean f29647o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f29648p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private o f29649p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final a0.a f29650q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private b4.b0 f29651q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final l2.a f29652r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private b2 f29653r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Looper f29654s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private o2 f29655s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final z3.e f29656t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f29657t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final long f29658u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f29659u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final long f29660v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private long f29661v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final a4.d f29662w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final c f29663x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final d f29664y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final k2.b f29665z;

    /* JADX INFO: compiled from: ExoPlayerImpl.java */
    @RequiresApi(31)
    private static final class b {
        @DoNotInline
        public static l2.t1 a(Context context, y0 y0Var, boolean z10) {
            l2.r1 r1VarA0 = l2.r1.A0(context);
            if (r1VarA0 == null) {
                a4.t.i("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new l2.t1(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z10) {
                y0Var.r0(r1VarA0);
            }
            return new l2.t1(r1VarA0.H0());
        }
    }

    /* JADX INFO: compiled from: ExoPlayerImpl.java */
    private static final class d implements b4.l, c4.a, v2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private b4.l f29667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private c4.a f29668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private b4.l f29669c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private c4.a f29670d;

        private d() {
        }

        @Override // b4.l
        public void a(long j10, long j11, o1 o1Var, @Nullable MediaFormat mediaFormat) {
            b4.l lVar = this.f29669c;
            if (lVar != null) {
                lVar.a(j10, j11, o1Var, mediaFormat);
            }
            b4.l lVar2 = this.f29667a;
            if (lVar2 != null) {
                lVar2.a(j10, j11, o1Var, mediaFormat);
            }
        }

        @Override // k2.v2.b
        public void handleMessage(int i10, @Nullable Object obj) {
            if (i10 == 7) {
                this.f29667a = (b4.l) obj;
                return;
            }
            if (i10 == 8) {
                this.f29668b = (c4.a) obj;
                return;
            }
            if (i10 != 10000) {
                return;
            }
            c4.l lVar = (c4.l) obj;
            if (lVar == null) {
                this.f29669c = null;
                this.f29670d = null;
            } else {
                this.f29669c = lVar.getVideoFrameMetadataListener();
                this.f29670d = lVar.getCameraMotionListener();
            }
        }

        @Override // c4.a
        public void onCameraMotion(long j10, float[] fArr) {
            c4.a aVar = this.f29670d;
            if (aVar != null) {
                aVar.onCameraMotion(j10, fArr);
            }
            c4.a aVar2 = this.f29668b;
            if (aVar2 != null) {
                aVar2.onCameraMotion(j10, fArr);
            }
        }

        @Override // c4.a
        public void onCameraMotionReset() {
            c4.a aVar = this.f29670d;
            if (aVar != null) {
                aVar.onCameraMotionReset();
            }
            c4.a aVar2 = this.f29668b;
            if (aVar2 != null) {
                aVar2.onCameraMotionReset();
            }
        }
    }

    /* JADX INFO: compiled from: ExoPlayerImpl.java */
    private static final class e implements g2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f29671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private n3 f29672b;

        public e(Object obj, n3 n3Var) {
            this.f29671a = obj;
            this.f29672b = n3Var;
        }

        @Override // k2.g2
        public n3 getTimeline() {
            return this.f29672b;
        }

        @Override // k2.g2
        public Object getUid() {
            return this.f29671a;
        }
    }

    static {
        l1.a("goog.exo.exoplayer");
    }

    @SuppressLint({"HandlerLeak"})
    public y0(s.b bVar, @Nullable r2 r2Var) {
        a4.g gVar = new a4.g();
        this.f29624d = gVar;
        try {
            a4.t.f("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.2] [" + a4.o0.f218e + v8.i.f15839e);
            Context applicationContext = bVar.f29444a.getApplicationContext();
            this.f29626e = applicationContext;
            l2.a aVarApply = bVar.f29452i.apply(bVar.f29445b);
            this.f29652r = aVarApply;
            this.f29643m0 = bVar.f29454k;
            this.f29631g0 = bVar.f29455l;
            this.f29619a0 = bVar.f29460q;
            this.f29621b0 = bVar.f29461r;
            this.f29635i0 = bVar.f29459p;
            this.E = bVar.f29468y;
            c cVar = new c();
            this.f29663x = cVar;
            d dVar = new d();
            this.f29664y = dVar;
            Handler handler = new Handler(bVar.f29453j);
            a3[] a3VarArrA = bVar.f29447d.get().a(handler, cVar, cVar, cVar, cVar);
            this.f29630g = a3VarArrA;
            a4.a.g(a3VarArrA.length > 0);
            x3.b0 b0Var = bVar.f29449f.get();
            this.f29632h = b0Var;
            this.f29650q = bVar.f29448e.get();
            z3.e eVar = bVar.f29451h.get();
            this.f29656t = eVar;
            this.f29648p = bVar.f29462s;
            this.L = bVar.f29463t;
            this.f29658u = bVar.f29464u;
            this.f29660v = bVar.f29465v;
            this.N = bVar.f29469z;
            Looper looper = bVar.f29453j;
            this.f29654s = looper;
            a4.d dVar2 = bVar.f29445b;
            this.f29662w = dVar2;
            r2 r2Var2 = r2Var == null ? this : r2Var;
            this.f29628f = r2Var2;
            this.f29640l = new a4.s<>(looper, dVar2, new s.b() { // from class: k2.k0
                @Override // a4.s.b
                public final void a(Object obj, a4.m mVar) {
                    this.f29209a.P0((r2.d) obj, mVar);
                }
            });
            this.f29642m = new CopyOnWriteArraySet<>();
            this.f29646o = new ArrayList();
            this.M = new w0.a(0);
            x3.c0 c0Var = new x3.c0(new d3[a3VarArrA.length], new x3.s[a3VarArrA.length], s3.f29474b, null);
            this.f29620b = c0Var;
            this.f29644n = new n3.b();
            r2.b bVarE = new r2.b.a().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).d(29, b0Var.e()).e();
            this.f29622c = bVarE;
            this.O = new r2.b.a().b(bVarE).a(4).a(10).e();
            this.f29634i = dVar2.createHandler(looper, null);
            k1.f fVar = new k1.f() { // from class: k2.q0
                @Override // k2.k1.f
                public final void a(k1.e eVar2) {
                    this.f29418a.R0(eVar2);
                }
            };
            this.f29636j = fVar;
            this.f29655s0 = o2.j(c0Var);
            aVarApply.l(r2Var2, looper);
            int i10 = a4.o0.f214a;
            k1 k1Var = new k1(a3VarArrA, b0Var, c0Var, bVar.f29450g.get(), eVar, this.F, this.G, aVarApply, this.L, bVar.f29466w, bVar.f29467x, this.N, looper, dVar2, fVar, i10 < 31 ? new l2.t1() : b.a(applicationContext, this, bVar.A));
            this.f29638k = k1Var;
            this.f29633h0 = 1.0f;
            this.F = 0;
            b2 b2Var = b2.G;
            this.P = b2Var;
            this.Q = b2Var;
            this.f29653r0 = b2Var;
            this.f29657t0 = -1;
            if (i10 < 21) {
                this.f29629f0 = M0(0);
            } else {
                this.f29629f0 = a4.o0.C(applicationContext);
            }
            this.f29637j0 = n3.f.f31657c;
            this.f29639k0 = true;
            a(aVarApply);
            eVar.c(new Handler(looper), aVarApply);
            s0(cVar);
            long j10 = bVar.f29446c;
            if (j10 > 0) {
                k1Var.r(j10);
            }
            k2.b bVar2 = new k2.b(bVar.f29444a, handler, cVar);
            this.f29665z = bVar2;
            bVar2.b(bVar.f29458o);
            k2.d dVar3 = new k2.d(bVar.f29444a, handler, cVar);
            this.A = dVar3;
            dVar3.m(bVar.f29456m ? this.f29631g0 : null);
            i3 i3Var = new i3(bVar.f29444a, handler, cVar);
            this.B = i3Var;
            i3Var.h(a4.o0.a0(this.f29631g0.f31253c));
            t3 t3Var = new t3(bVar.f29444a);
            this.C = t3Var;
            t3Var.a(bVar.f29457n != 0);
            u3 u3Var = new u3(bVar.f29444a);
            this.D = u3Var;
            u3Var.a(bVar.f29457n == 2);
            this.f29649p0 = x0(i3Var);
            this.f29651q0 = b4.b0.f2077e;
            this.f29623c0 = a4.g0.f164c;
            b0Var.i(this.f29631g0);
            u1(1, 10, Integer.valueOf(this.f29629f0));
            u1(2, 10, Integer.valueOf(this.f29629f0));
            u1(1, 3, this.f29631g0);
            u1(2, 4, Integer.valueOf(this.f29619a0));
            u1(2, 5, Integer.valueOf(this.f29621b0));
            u1(1, 9, Boolean.valueOf(this.f29635i0));
            u1(2, 7, dVar);
            u1(6, 8, dVar);
            gVar.e();
        } catch (Throwable th) {
            this.f29624d.e();
            throw th;
        }
    }

    private v2 A0(v2.b bVar) {
        int iE0 = E0();
        k1 k1Var = this.f29638k;
        n3 n3Var = this.f29655s0.f29389a;
        if (iE0 == -1) {
            iE0 = 0;
        }
        return new v2(k1Var, bVar, n3Var, iE0, this.f29662w, k1Var.y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        B1(surface);
        this.V = surface;
    }

    private Pair<Boolean, Integer> B0(o2 o2Var, o2 o2Var2, boolean z10, int i10, boolean z11, boolean z12) {
        n3 n3Var = o2Var2.f29389a;
        n3 n3Var2 = o2Var.f29389a;
        if (n3Var2.u() && n3Var.u()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i11 = 3;
        if (n3Var2.u() != n3Var.u()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (n3Var.r(n3Var.l(o2Var2.f29390b.f30778a, this.f29644n).f29300c, this.f29076a).f29313a.equals(n3Var2.r(n3Var2.l(o2Var.f29390b.f30778a, this.f29644n).f29300c, this.f29076a).f29313a)) {
            return (z10 && i10 == 0 && o2Var2.f29390b.f30781d < o2Var.f29390b.f30781d) ? new Pair<>(Boolean.TRUE, 0) : (z10 && i10 == 1 && z12) ? new Pair<>(Boolean.TRUE, 2) : new Pair<>(Boolean.FALSE, -1);
        }
        if (z10 && i10 == 0) {
            i11 = 1;
        } else if (z10 && i10 == 1) {
            i11 = 2;
        } else if (!z11) {
            throw new IllegalStateException();
        }
        return new Pair<>(Boolean.TRUE, Integer.valueOf(i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(@Nullable Object obj) {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        a3[] a3VarArr = this.f29630g;
        int length = a3VarArr.length;
        int i10 = 0;
        while (true) {
            z10 = true;
            if (i10 >= length) {
                break;
            }
            a3 a3Var = a3VarArr[i10];
            if (a3Var.getTrackType() == 2) {
                arrayList.add(A0(a3Var).n(1).m(obj).l());
            }
            i10++;
        }
        Object obj2 = this.U;
        if (obj2 == null || obj2 == obj) {
            z10 = false;
        } else {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((v2) it.next()).a(this.E);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z10 = false;
            Object obj3 = this.U;
            Surface surface = this.V;
            if (obj3 == surface) {
                surface.release();
                this.V = null;
            }
        }
        this.U = obj;
        if (z10) {
            D1(false, q.j(new m1(3), 1003));
        }
    }

    private long D0(o2 o2Var) {
        return o2Var.f29389a.u() ? a4.o0.w0(this.f29661v0) : o2Var.f29390b.b() ? o2Var.f29406r : p1(o2Var.f29389a, o2Var.f29390b, o2Var.f29406r);
    }

    private void D1(boolean z10, @Nullable q qVar) {
        o2 o2VarB;
        if (z10) {
            o2VarB = q1(0, this.f29646o.size()).e(null);
        } else {
            o2 o2Var = this.f29655s0;
            o2VarB = o2Var.b(o2Var.f29390b);
            o2VarB.f29404p = o2VarB.f29406r;
            o2VarB.f29405q = 0L;
        }
        o2 o2VarG = o2VarB.g(1);
        if (qVar != null) {
            o2VarG = o2VarG.e(qVar);
        }
        o2 o2Var2 = o2VarG;
        this.H++;
        this.f29638k.d1();
        G1(o2Var2, 0, 1, false, o2Var2.f29389a.u() && !this.f29655s0.f29389a.u(), 4, D0(o2Var2), -1, false);
    }

    private int E0() {
        if (this.f29655s0.f29389a.u()) {
            return this.f29657t0;
        }
        o2 o2Var = this.f29655s0;
        return o2Var.f29389a.l(o2Var.f29390b.f30778a, this.f29644n).f29300c;
    }

    private void E1() {
        r2.b bVar = this.O;
        r2.b bVarE = a4.o0.E(this.f29628f, this.f29622c);
        this.O = bVarE;
        if (bVarE.equals(bVar)) {
            return;
        }
        this.f29640l.i(13, new s.a() { // from class: k2.o0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                this.f29335a.X0((r2.d) obj);
            }
        });
    }

    @Nullable
    private Pair<Object, Long> F0(n3 n3Var, n3 n3Var2) {
        long contentPosition = getContentPosition();
        if (n3Var.u() || n3Var2.u()) {
            boolean z10 = !n3Var.u() && n3Var2.u();
            int iE0 = z10 ? -1 : E0();
            if (z10) {
                contentPosition = -9223372036854775807L;
            }
            return n1(n3Var2, iE0, contentPosition);
        }
        Pair<Object, Long> pairN = n3Var.n(this.f29076a, this.f29644n, getCurrentMediaItemIndex(), a4.o0.w0(contentPosition));
        Object obj = ((Pair) a4.o0.j(pairN)).first;
        if (n3Var2.f(obj) != -1) {
            return pairN;
        }
        Object objV0 = k1.v0(this.f29076a, this.f29644n, this.F, this.G, obj, n3Var, n3Var2);
        if (objV0 == null) {
            return n1(n3Var2, -1, C.TIME_UNSET);
        }
        n3Var2.l(objV0, this.f29644n);
        int i10 = this.f29644n.f29300c;
        return n1(n3Var2, i10, n3Var2.r(i10, this.f29076a).e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1(boolean z10, int i10, int i11) {
        int i12 = 0;
        boolean z11 = z10 && i10 != -1;
        if (z11 && i10 != 1) {
            i12 = 1;
        }
        o2 o2Var = this.f29655s0;
        if (o2Var.f29400l == z11 && o2Var.f29401m == i12) {
            return;
        }
        this.H++;
        o2 o2VarD = o2Var.d(z11, i12);
        this.f29638k.M0(z11, i12);
        G1(o2VarD, 0, i11, false, false, 5, C.TIME_UNSET, -1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int G0(boolean z10, int i10) {
        return (!z10 || i10 == 1) ? 1 : 2;
    }

    private void G1(final o2 o2Var, final int i10, final int i11, boolean z10, boolean z11, final int i12, long j10, int i13, boolean z12) {
        o2 o2Var2 = this.f29655s0;
        this.f29655s0 = o2Var;
        boolean z13 = !o2Var2.f29389a.equals(o2Var.f29389a);
        Pair<Boolean, Integer> pairB0 = B0(o2Var, o2Var2, z11, i12, z13, z12);
        boolean zBooleanValue = ((Boolean) pairB0.first).booleanValue();
        final int iIntValue = ((Integer) pairB0.second).intValue();
        b2 b2VarU0 = this.P;
        if (zBooleanValue) {
            w1Var = o2Var.f29389a.u() ? null : o2Var.f29389a.r(o2Var.f29389a.l(o2Var.f29390b.f30778a, this.f29644n).f29300c, this.f29076a).f29315c;
            this.f29653r0 = b2.G;
        }
        if (zBooleanValue || !o2Var2.f29398j.equals(o2Var.f29398j)) {
            this.f29653r0 = this.f29653r0.b().J(o2Var.f29398j).F();
            b2VarU0 = u0();
        }
        boolean z14 = !b2VarU0.equals(this.P);
        this.P = b2VarU0;
        boolean z15 = o2Var2.f29400l != o2Var.f29400l;
        boolean z16 = o2Var2.f29393e != o2Var.f29393e;
        if (z16 || z15) {
            I1();
        }
        boolean z17 = o2Var2.f29395g;
        boolean z18 = o2Var.f29395g;
        boolean z19 = z17 != z18;
        if (z19) {
            H1(z18);
        }
        if (z13) {
            this.f29640l.i(0, new s.a() { // from class: k2.u0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.Y0(o2Var, i10, (r2.d) obj);
                }
            });
        }
        if (z11) {
            final r2.e eVarJ0 = J0(i12, o2Var2, i13);
            final r2.e eVarI0 = I0(j10);
            this.f29640l.i(11, new s.a() { // from class: k2.c0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.Z0(i12, eVarJ0, eVarI0, (r2.d) obj);
                }
            });
        }
        if (zBooleanValue) {
            this.f29640l.i(1, new s.a() { // from class: k2.d0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).x(w1Var, iIntValue);
                }
            });
        }
        if (o2Var2.f29394f != o2Var.f29394f) {
            this.f29640l.i(10, new s.a() { // from class: k2.e0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.b1(o2Var, (r2.d) obj);
                }
            });
            if (o2Var.f29394f != null) {
                this.f29640l.i(10, new s.a() { // from class: k2.f0
                    @Override // a4.s.a
                    public final void invoke(Object obj) {
                        y0.c1(o2Var, (r2.d) obj);
                    }
                });
            }
        }
        x3.c0 c0Var = o2Var2.f29397i;
        x3.c0 c0Var2 = o2Var.f29397i;
        if (c0Var != c0Var2) {
            this.f29632h.f(c0Var2.f35937e);
            this.f29640l.i(2, new s.a() { // from class: k2.g0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.d1(o2Var, (r2.d) obj);
                }
            });
        }
        if (z14) {
            final b2 b2Var = this.P;
            this.f29640l.i(14, new s.a() { // from class: k2.h0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).m(b2Var);
                }
            });
        }
        if (z19) {
            this.f29640l.i(3, new s.a() { // from class: k2.i0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.f1(o2Var, (r2.d) obj);
                }
            });
        }
        if (z16 || z15) {
            this.f29640l.i(-1, new s.a() { // from class: k2.j0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.g1(o2Var, (r2.d) obj);
                }
            });
        }
        if (z16) {
            this.f29640l.i(4, new s.a() { // from class: k2.l0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.h1(o2Var, (r2.d) obj);
                }
            });
        }
        if (z15) {
            this.f29640l.i(5, new s.a() { // from class: k2.v0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.i1(o2Var, i11, (r2.d) obj);
                }
            });
        }
        if (o2Var2.f29401m != o2Var.f29401m) {
            this.f29640l.i(6, new s.a() { // from class: k2.w0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.j1(o2Var, (r2.d) obj);
                }
            });
        }
        if (N0(o2Var2) != N0(o2Var)) {
            this.f29640l.i(7, new s.a() { // from class: k2.x0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.k1(o2Var, (r2.d) obj);
                }
            });
        }
        if (!o2Var2.f29402n.equals(o2Var.f29402n)) {
            this.f29640l.i(12, new s.a() { // from class: k2.a0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.l1(o2Var, (r2.d) obj);
                }
            });
        }
        if (z10) {
            this.f29640l.i(-1, new s.a() { // from class: k2.b0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).y();
                }
            });
        }
        E1();
        this.f29640l.f();
        if (o2Var2.f29403o != o2Var.f29403o) {
            Iterator<s.a> it = this.f29642m.iterator();
            while (it.hasNext()) {
                it.next().m(o2Var.f29403o);
            }
        }
    }

    private void H1(boolean z10) {
        a4.e0 e0Var = this.f29643m0;
        if (e0Var != null) {
            if (z10 && !this.f29645n0) {
                e0Var.a(0);
                this.f29645n0 = true;
            } else {
                if (z10 || !this.f29645n0) {
                    return;
                }
                e0Var.b(0);
                this.f29645n0 = false;
            }
        }
    }

    private r2.e I0(long j10) {
        w1 w1Var;
        Object obj;
        int iF;
        Object obj2;
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        if (this.f29655s0.f29389a.u()) {
            w1Var = null;
            obj = null;
            iF = -1;
            obj2 = null;
        } else {
            o2 o2Var = this.f29655s0;
            Object obj3 = o2Var.f29390b.f30778a;
            o2Var.f29389a.l(obj3, this.f29644n);
            iF = this.f29655s0.f29389a.f(obj3);
            obj = obj3;
            obj2 = this.f29655s0.f29389a.r(currentMediaItemIndex, this.f29076a).f29313a;
            w1Var = this.f29076a.f29315c;
        }
        long jP0 = a4.o0.P0(j10);
        long jP02 = this.f29655s0.f29390b.b() ? a4.o0.P0(K0(this.f29655s0)) : jP0;
        a0.b bVar = this.f29655s0.f29390b;
        return new r2.e(obj2, currentMediaItemIndex, w1Var, obj, iF, jP0, jP02, bVar.f30779b, bVar.f30780c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.C.b(getPlayWhenReady() && !C0());
                this.D.b(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.C.b(false);
        this.D.b(false);
    }

    private r2.e J0(int i10, o2 o2Var, int i11) {
        int i12;
        Object obj;
        w1 w1Var;
        Object obj2;
        int i13;
        long jK0;
        long jK02;
        n3.b bVar = new n3.b();
        if (o2Var.f29389a.u()) {
            i12 = i11;
            obj = null;
            w1Var = null;
            obj2 = null;
            i13 = -1;
        } else {
            Object obj3 = o2Var.f29390b.f30778a;
            o2Var.f29389a.l(obj3, bVar);
            int i14 = bVar.f29300c;
            int iF = o2Var.f29389a.f(obj3);
            Object obj4 = o2Var.f29389a.r(i14, this.f29076a).f29313a;
            w1Var = this.f29076a.f29315c;
            obj2 = obj3;
            i13 = iF;
            obj = obj4;
            i12 = i14;
        }
        if (i10 == 0) {
            if (o2Var.f29390b.b()) {
                a0.b bVar2 = o2Var.f29390b;
                jK0 = bVar.e(bVar2.f30779b, bVar2.f30780c);
                jK02 = K0(o2Var);
            } else {
                jK0 = o2Var.f29390b.f30782e != -1 ? K0(this.f29655s0) : bVar.f29302e + bVar.f29301d;
                jK02 = jK0;
            }
        } else if (o2Var.f29390b.b()) {
            jK0 = o2Var.f29406r;
            jK02 = K0(o2Var);
        } else {
            jK0 = bVar.f29302e + o2Var.f29406r;
            jK02 = jK0;
        }
        long jP0 = a4.o0.P0(jK0);
        long jP02 = a4.o0.P0(jK02);
        a0.b bVar3 = o2Var.f29390b;
        return new r2.e(obj, i12, w1Var, obj2, i13, jP0, jP02, bVar3.f30779b, bVar3.f30780c);
    }

    private void J1() {
        this.f29624d.b();
        if (Thread.currentThread() != getApplicationLooper().getThread()) {
            String strZ = a4.o0.z("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), getApplicationLooper().getThread().getName());
            if (this.f29639k0) {
                throw new IllegalStateException(strZ);
            }
            a4.t.j("ExoPlayerImpl", strZ, this.f29641l0 ? null : new IllegalStateException());
            this.f29641l0 = true;
        }
    }

    private static long K0(o2 o2Var) {
        n3.d dVar = new n3.d();
        n3.b bVar = new n3.b();
        o2Var.f29389a.l(o2Var.f29390b.f30778a, bVar);
        return o2Var.f29391c == C.TIME_UNSET ? o2Var.f29389a.r(bVar.f29300c, dVar).f() : bVar.q() + o2Var.f29391c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public void Q0(k1.e eVar) {
        long j10;
        boolean z10;
        long jP1;
        int i10 = this.H - eVar.f29251c;
        this.H = i10;
        boolean z11 = true;
        if (eVar.f29252d) {
            this.I = eVar.f29253e;
            this.J = true;
        }
        if (eVar.f29254f) {
            this.K = eVar.f29255g;
        }
        if (i10 == 0) {
            n3 n3Var = eVar.f29250b.f29389a;
            if (!this.f29655s0.f29389a.u() && n3Var.u()) {
                this.f29657t0 = -1;
                this.f29661v0 = 0L;
                this.f29659u0 = 0;
            }
            if (!n3Var.u()) {
                List<n3> listK = ((w2) n3Var).K();
                a4.a.g(listK.size() == this.f29646o.size());
                for (int i11 = 0; i11 < listK.size(); i11++) {
                    this.f29646o.get(i11).f29672b = listK.get(i11);
                }
            }
            if (this.J) {
                if (eVar.f29250b.f29390b.equals(this.f29655s0.f29390b) && eVar.f29250b.f29392d == this.f29655s0.f29406r) {
                    z11 = false;
                }
                if (z11) {
                    if (n3Var.u() || eVar.f29250b.f29390b.b()) {
                        jP1 = eVar.f29250b.f29392d;
                    } else {
                        o2 o2Var = eVar.f29250b;
                        jP1 = p1(n3Var, o2Var.f29390b, o2Var.f29392d);
                    }
                    j10 = jP1;
                } else {
                    j10 = -9223372036854775807L;
                }
                z10 = z11;
            } else {
                j10 = -9223372036854775807L;
                z10 = false;
            }
            this.J = false;
            G1(eVar.f29250b, 1, this.K, false, z10, this.I, j10, -1, false);
        }
    }

    private int M0(int i10) {
        AudioTrack audioTrack = this.T;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i10) {
            this.T.release();
            this.T = null;
        }
        if (this.T == null) {
            this.T = new AudioTrack(3, 4000, 4, 2, 2, 0, i10);
        }
        return this.T.getAudioSessionId();
    }

    private static boolean N0(o2 o2Var) {
        return o2Var.f29393e == 3 && o2Var.f29400l && o2Var.f29401m == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(r2.d dVar, a4.m mVar) {
        dVar.t(this.f29628f, new r2.c(mVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(final k1.e eVar) {
        this.f29634i.post(new Runnable() { // from class: k2.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29288a.Q0(eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S0(r2.d dVar) {
        dVar.u(q.j(new m1(1), 1003));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(r2.d dVar) {
        dVar.F(this.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y0(o2 o2Var, int i10, r2.d dVar) {
        dVar.z(o2Var.f29389a, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z0(int i10, r2.e eVar, r2.e eVar2, r2.d dVar) {
        dVar.onPositionDiscontinuity(i10);
        dVar.D(eVar, eVar2, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b1(o2 o2Var, r2.d dVar) {
        dVar.E(o2Var.f29394f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c1(o2 o2Var, r2.d dVar) {
        dVar.u(o2Var.f29394f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d1(o2 o2Var, r2.d dVar) {
        dVar.G(o2Var.f29397i.f35936d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f1(o2 o2Var, r2.d dVar) {
        dVar.onLoadingChanged(o2Var.f29395g);
        dVar.onIsLoadingChanged(o2Var.f29395g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g1(o2 o2Var, r2.d dVar) {
        dVar.onPlayerStateChanged(o2Var.f29400l, o2Var.f29393e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h1(o2 o2Var, r2.d dVar) {
        dVar.onPlaybackStateChanged(o2Var.f29393e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i1(o2 o2Var, int i10, r2.d dVar) {
        dVar.onPlayWhenReadyChanged(o2Var.f29400l, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j1(o2 o2Var, r2.d dVar) {
        dVar.onPlaybackSuppressionReasonChanged(o2Var.f29401m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k1(o2 o2Var, r2.d dVar) {
        dVar.onIsPlayingChanged(N0(o2Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l1(o2 o2Var, r2.d dVar) {
        dVar.h(o2Var.f29402n);
    }

    private o2 m1(o2 o2Var, n3 n3Var, @Nullable Pair<Object, Long> pair) {
        a4.a.a(n3Var.u() || pair != null);
        n3 n3Var2 = o2Var.f29389a;
        o2 o2VarI = o2Var.i(n3Var);
        if (n3Var.u()) {
            a0.b bVarK = o2.k();
            long jW0 = a4.o0.w0(this.f29661v0);
            o2 o2VarB = o2VarI.c(bVarK, jW0, jW0, jW0, 0L, l3.e1.f30515d, this.f29620b, com.google.common.collect.y.q()).b(bVarK);
            o2VarB.f29404p = o2VarB.f29406r;
            return o2VarB;
        }
        Object obj = o2VarI.f29390b.f30778a;
        boolean z10 = !obj.equals(((Pair) a4.o0.j(pair)).first);
        a0.b bVar = z10 ? new a0.b(pair.first) : o2VarI.f29390b;
        long jLongValue = ((Long) pair.second).longValue();
        long jW02 = a4.o0.w0(getContentPosition());
        if (!n3Var2.u()) {
            jW02 -= n3Var2.l(obj, this.f29644n).q();
        }
        if (z10 || jLongValue < jW02) {
            a4.a.g(!bVar.b());
            o2 o2VarB2 = o2VarI.c(bVar, jLongValue, jLongValue, jLongValue, 0L, z10 ? l3.e1.f30515d : o2VarI.f29396h, z10 ? this.f29620b : o2VarI.f29397i, z10 ? com.google.common.collect.y.q() : o2VarI.f29398j).b(bVar);
            o2VarB2.f29404p = jLongValue;
            return o2VarB2;
        }
        if (jLongValue == jW02) {
            int iF = n3Var.f(o2VarI.f29399k.f30778a);
            if (iF == -1 || n3Var.j(iF, this.f29644n).f29300c != n3Var.l(bVar.f30778a, this.f29644n).f29300c) {
                n3Var.l(bVar.f30778a, this.f29644n);
                long jE = bVar.b() ? this.f29644n.e(bVar.f30779b, bVar.f30780c) : this.f29644n.f29301d;
                o2VarI = o2VarI.c(bVar, o2VarI.f29406r, o2VarI.f29406r, o2VarI.f29392d, jE - o2VarI.f29406r, o2VarI.f29396h, o2VarI.f29397i, o2VarI.f29398j).b(bVar);
                o2VarI.f29404p = jE;
            }
        } else {
            a4.a.g(!bVar.b());
            long jMax = Math.max(0L, o2VarI.f29405q - (jLongValue - jW02));
            long j10 = o2VarI.f29404p;
            if (o2VarI.f29399k.equals(o2VarI.f29390b)) {
                j10 = jLongValue + jMax;
            }
            o2VarI = o2VarI.c(bVar, jLongValue, jLongValue, jLongValue, jMax, o2VarI.f29396h, o2VarI.f29397i, o2VarI.f29398j);
            o2VarI.f29404p = j10;
        }
        return o2VarI;
    }

    @Nullable
    private Pair<Object, Long> n1(n3 n3Var, int i10, long j10) {
        if (n3Var.u()) {
            this.f29657t0 = i10;
            if (j10 == C.TIME_UNSET) {
                j10 = 0;
            }
            this.f29661v0 = j10;
            this.f29659u0 = 0;
            return null;
        }
        if (i10 == -1 || i10 >= n3Var.t()) {
            i10 = n3Var.e(this.G);
            j10 = n3Var.r(i10, this.f29076a).e();
        }
        return n3Var.n(this.f29076a, this.f29644n, i10, a4.o0.w0(j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(final int i10, final int i11) {
        if (i10 == this.f29623c0.b() && i11 == this.f29623c0.a()) {
            return;
        }
        this.f29623c0 = new a4.g0(i10, i11);
        this.f29640l.l(24, new s.a() { // from class: k2.z
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((r2.d) obj).onSurfaceSizeChanged(i10, i11);
            }
        });
    }

    private long p1(n3 n3Var, a0.b bVar, long j10) {
        n3Var.l(bVar.f30778a, this.f29644n);
        return j10 + this.f29644n.q();
    }

    private o2 q1(int i10, int i11) {
        boolean z10 = false;
        a4.a.a(i10 >= 0 && i11 >= i10 && i11 <= this.f29646o.size());
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        n3 currentTimeline = getCurrentTimeline();
        int size = this.f29646o.size();
        this.H++;
        r1(i10, i11);
        n3 n3VarY0 = y0();
        o2 o2VarM1 = m1(this.f29655s0, n3VarY0, F0(currentTimeline, n3VarY0));
        int i12 = o2VarM1.f29393e;
        if (i12 != 1 && i12 != 4 && i10 < i11 && i11 == size && currentMediaItemIndex >= o2VarM1.f29389a.t()) {
            z10 = true;
        }
        if (z10) {
            o2VarM1 = o2VarM1.g(4);
        }
        this.f29638k.k0(i10, i11, this.M);
        return o2VarM1;
    }

    private void r1(int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            this.f29646o.remove(i12);
        }
        this.M = this.M.cloneAndRemove(i10, i11);
    }

    private void s1() {
        if (this.X != null) {
            A0(this.f29664y).n(10000).m(null).l();
            this.X.i(this.f29663x);
            this.X = null;
        }
        TextureView textureView = this.Z;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f29663x) {
                a4.t.i("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.Z.setSurfaceTextureListener(null);
            }
            this.Z = null;
        }
        SurfaceHolder surfaceHolder = this.W;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f29663x);
            this.W = null;
        }
    }

    private List<i2.c> t0(int i10, List<l3.a0> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            i2.c cVar = new i2.c(list.get(i11), this.f29648p);
            arrayList.add(cVar);
            this.f29646o.add(i11 + i10, new e(cVar.f29153b, cVar.f29152a.P()));
        }
        this.M = this.M.cloneAndInsert(i10, arrayList.size());
        return arrayList;
    }

    private void t1(int i10, long j10, boolean z10) {
        this.f29652r.notifySeekStarted();
        n3 n3Var = this.f29655s0.f29389a;
        if (i10 < 0 || (!n3Var.u() && i10 >= n3Var.t())) {
            throw new s1(n3Var, i10, j10);
        }
        this.H++;
        if (isPlayingAd()) {
            a4.t.i("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            k1.e eVar = new k1.e(this.f29655s0);
            eVar.b(1);
            this.f29636j.a(eVar);
            return;
        }
        int i11 = getPlaybackState() != 1 ? 2 : 1;
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        o2 o2VarM1 = m1(this.f29655s0.g(i11), n3Var, n1(n3Var, i10, j10));
        this.f29638k.x0(n3Var, i10, a4.o0.w0(j10));
        G1(o2VarM1, 0, 1, true, true, 1, D0(o2VarM1), currentMediaItemIndex, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b2 u0() {
        n3 currentTimeline = getCurrentTimeline();
        if (currentTimeline.u()) {
            return this.f29653r0;
        }
        return this.f29653r0.b().H(currentTimeline.r(getCurrentMediaItemIndex(), this.f29076a).f29315c.f29520e).F();
    }

    private void u1(int i10, int i11, @Nullable Object obj) {
        for (a3 a3Var : this.f29630g) {
            if (a3Var.getTrackType() == i10) {
                A0(a3Var).n(i11).m(obj).l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        u1(1, 2, Float.valueOf(this.f29633h0 * this.A.g()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static o x0(i3 i3Var) {
        return new o(0, i3Var.d(), i3Var.c());
    }

    private n3 y0() {
        return new w2(this.f29646o, this.M);
    }

    private void y1(List<l3.a0> list, int i10, long j10, boolean z10) {
        int i11;
        long j11;
        int iE0 = E0();
        long currentPosition = getCurrentPosition();
        this.H++;
        if (!this.f29646o.isEmpty()) {
            r1(0, this.f29646o.size());
        }
        List<i2.c> listT0 = t0(0, list);
        n3 n3VarY0 = y0();
        if (!n3VarY0.u() && i10 >= n3VarY0.t()) {
            throw new s1(n3VarY0, i10, j10);
        }
        if (z10) {
            int iE = n3VarY0.e(this.G);
            j11 = C.TIME_UNSET;
            i11 = iE;
        } else if (i10 == -1) {
            i11 = iE0;
            j11 = currentPosition;
        } else {
            i11 = i10;
            j11 = j10;
        }
        o2 o2VarM1 = m1(this.f29655s0, n3VarY0, n1(n3VarY0, i11, j11));
        int i12 = o2VarM1.f29393e;
        if (i11 != -1 && i12 != 1) {
            i12 = (n3VarY0.u() || i11 >= n3VarY0.t()) ? 4 : 2;
        }
        o2 o2VarG = o2VarM1.g(i12);
        this.f29638k.J0(listT0, i11, a4.o0.w0(j11), this.M);
        G1(o2VarG, 0, 1, false, (this.f29655s0.f29390b.f30778a.equals(o2VarG.f29390b.f30778a) || this.f29655s0.f29389a.u()) ? false : true, 4, D0(o2VarG), -1, false);
    }

    private List<l3.a0> z0(List<w1> list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            arrayList.add(this.f29650q.b(list.get(i10)));
        }
        return arrayList;
    }

    private void z1(SurfaceHolder surfaceHolder) {
        this.Y = false;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.f29663x);
        Surface surface = this.W.getSurface();
        if (surface == null || !surface.isValid()) {
            o1(0, 0);
        } else {
            Rect surfaceFrame = this.W.getSurfaceFrame();
            o1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public boolean C0() {
        J1();
        return this.f29655s0.f29403o;
    }

    public void C1(@Nullable SurfaceHolder surfaceHolder) {
        J1();
        if (surfaceHolder == null) {
            v0();
            return;
        }
        s1();
        this.Y = true;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.f29663x);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            B1(null);
            o1(0, 0);
        } else {
            B1(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            o1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // k2.r2
    @Nullable
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public q getPlayerError() {
        J1();
        return this.f29655s0.f29394f;
    }

    @Override // k2.r2
    public void a(r2.d dVar) {
        this.f29640l.c((r2.d) a4.a.e(dVar));
    }

    @Override // k2.r2
    public void b(q2 q2Var) {
        J1();
        if (q2Var == null) {
            q2Var = q2.f29419d;
        }
        if (this.f29655s0.f29402n.equals(q2Var)) {
            return;
        }
        o2 o2VarF = this.f29655s0.f(q2Var);
        this.H++;
        this.f29638k.O0(q2Var);
        G1(o2VarF, 0, 1, false, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // k2.r2
    public void c(final x3.z zVar) {
        J1();
        if (!this.f29632h.e() || zVar.equals(this.f29632h.b())) {
            return;
        }
        this.f29632h.j(zVar);
        this.f29640l.l(19, new s.a() { // from class: k2.p0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((r2.d) obj).H(zVar);
            }
        });
    }

    @Override // k2.r2
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        J1();
        w0(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // k2.r2
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        J1();
        if (textureView == null || textureView != this.Z) {
            return;
        }
        v0();
    }

    @Override // k2.s
    public void e(l3.a0 a0Var) {
        J1();
        w1(Collections.singletonList(a0Var));
    }

    @Override // k2.r2
    public void f(r2.d dVar) {
        a4.a.e(dVar);
        this.f29640l.k(dVar);
    }

    @Override // k2.r2
    public Looper getApplicationLooper() {
        return this.f29654s;
    }

    @Override // k2.r2
    public r2.b getAvailableCommands() {
        J1();
        return this.O;
    }

    @Override // k2.r2
    public long getContentBufferedPosition() {
        J1();
        if (this.f29655s0.f29389a.u()) {
            return this.f29661v0;
        }
        o2 o2Var = this.f29655s0;
        if (o2Var.f29399k.f30781d != o2Var.f29390b.f30781d) {
            return o2Var.f29389a.r(getCurrentMediaItemIndex(), this.f29076a).g();
        }
        long j10 = o2Var.f29404p;
        if (this.f29655s0.f29399k.b()) {
            o2 o2Var2 = this.f29655s0;
            n3.b bVarL = o2Var2.f29389a.l(o2Var2.f29399k.f30778a, this.f29644n);
            long jI = bVarL.i(this.f29655s0.f29399k.f30779b);
            j10 = jI == Long.MIN_VALUE ? bVarL.f29301d : jI;
        }
        o2 o2Var3 = this.f29655s0;
        return a4.o0.P0(p1(o2Var3.f29389a, o2Var3.f29399k, j10));
    }

    @Override // k2.r2
    public long getContentPosition() {
        J1();
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        o2 o2Var = this.f29655s0;
        o2Var.f29389a.l(o2Var.f29390b.f30778a, this.f29644n);
        o2 o2Var2 = this.f29655s0;
        return o2Var2.f29391c == C.TIME_UNSET ? o2Var2.f29389a.r(getCurrentMediaItemIndex(), this.f29076a).e() : this.f29644n.p() + a4.o0.P0(this.f29655s0.f29391c);
    }

    @Override // k2.r2
    public int getCurrentAdGroupIndex() {
        J1();
        if (isPlayingAd()) {
            return this.f29655s0.f29390b.f30779b;
        }
        return -1;
    }

    @Override // k2.r2
    public int getCurrentAdIndexInAdGroup() {
        J1();
        if (isPlayingAd()) {
            return this.f29655s0.f29390b.f30780c;
        }
        return -1;
    }

    @Override // k2.r2
    public n3.f getCurrentCues() {
        J1();
        return this.f29637j0;
    }

    @Override // k2.r2
    public int getCurrentMediaItemIndex() {
        J1();
        int iE0 = E0();
        if (iE0 == -1) {
            return 0;
        }
        return iE0;
    }

    @Override // k2.r2
    public int getCurrentPeriodIndex() {
        J1();
        if (this.f29655s0.f29389a.u()) {
            return this.f29659u0;
        }
        o2 o2Var = this.f29655s0;
        return o2Var.f29389a.f(o2Var.f29390b.f30778a);
    }

    @Override // k2.r2
    public long getCurrentPosition() {
        J1();
        return a4.o0.P0(D0(this.f29655s0));
    }

    @Override // k2.r2
    public n3 getCurrentTimeline() {
        J1();
        return this.f29655s0.f29389a;
    }

    @Override // k2.r2
    public s3 getCurrentTracks() {
        J1();
        return this.f29655s0.f29397i.f35936d;
    }

    @Override // k2.r2
    public long getDuration() {
        J1();
        if (!isPlayingAd()) {
            return g();
        }
        o2 o2Var = this.f29655s0;
        a0.b bVar = o2Var.f29390b;
        o2Var.f29389a.l(bVar.f30778a, this.f29644n);
        return a4.o0.P0(this.f29644n.e(bVar.f30779b, bVar.f30780c));
    }

    @Override // k2.r2
    public long getMaxSeekToPreviousPosition() {
        J1();
        return C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    }

    @Override // k2.r2
    public b2 getMediaMetadata() {
        J1();
        return this.P;
    }

    @Override // k2.r2
    public boolean getPlayWhenReady() {
        J1();
        return this.f29655s0.f29400l;
    }

    @Override // k2.r2
    public q2 getPlaybackParameters() {
        J1();
        return this.f29655s0.f29402n;
    }

    @Override // k2.r2
    public int getPlaybackState() {
        J1();
        return this.f29655s0.f29393e;
    }

    @Override // k2.r2
    public int getPlaybackSuppressionReason() {
        J1();
        return this.f29655s0.f29401m;
    }

    @Override // k2.r2
    public int getRepeatMode() {
        J1();
        return this.F;
    }

    @Override // k2.r2
    public long getSeekBackIncrement() {
        J1();
        return this.f29658u;
    }

    @Override // k2.r2
    public long getSeekForwardIncrement() {
        J1();
        return this.f29660v;
    }

    @Override // k2.r2
    public boolean getShuffleModeEnabled() {
        J1();
        return this.G;
    }

    @Override // k2.r2
    public long getTotalBufferedDuration() {
        J1();
        return a4.o0.P0(this.f29655s0.f29405q);
    }

    @Override // k2.r2
    public x3.z getTrackSelectionParameters() {
        J1();
        return this.f29632h.b();
    }

    @Override // k2.r2
    public b4.b0 getVideoSize() {
        J1();
        return this.f29651q0;
    }

    @Override // k2.r2
    public boolean isPlayingAd() {
        J1();
        return this.f29655s0.f29390b.b();
    }

    @Override // k2.e
    protected void k() {
        J1();
        t1(getCurrentMediaItemIndex(), C.TIME_UNSET, true);
    }

    @Override // k2.r2
    public void prepare() {
        J1();
        boolean playWhenReady = getPlayWhenReady();
        int iP = this.A.p(playWhenReady, 2);
        F1(playWhenReady, iP, G0(playWhenReady, iP));
        o2 o2Var = this.f29655s0;
        if (o2Var.f29393e != 1) {
            return;
        }
        o2 o2VarE = o2Var.e(null);
        o2 o2VarG = o2VarE.g(o2VarE.f29389a.u() ? 4 : 2);
        this.H++;
        this.f29638k.f0();
        G1(o2VarG, 1, 1, false, false, 5, C.TIME_UNSET, -1, false);
    }

    public void r0(l2.c cVar) {
        this.f29652r.I((l2.c) a4.a.e(cVar));
    }

    @Override // k2.r2
    public void release() {
        AudioTrack audioTrack;
        a4.t.f("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.2] [" + a4.o0.f218e + "] [" + l1.b() + v8.i.f15839e);
        J1();
        if (a4.o0.f214a < 21 && (audioTrack = this.T) != null) {
            audioTrack.release();
            this.T = null;
        }
        this.f29665z.b(false);
        this.B.g();
        this.C.b(false);
        this.D.b(false);
        this.A.i();
        if (!this.f29638k.h0()) {
            this.f29640l.l(10, new s.a() { // from class: k2.r0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    y0.S0((r2.d) obj);
                }
            });
        }
        this.f29640l.j();
        this.f29634i.removeCallbacksAndMessages(null);
        this.f29656t.a(this.f29652r);
        o2 o2VarG = this.f29655s0.g(1);
        this.f29655s0 = o2VarG;
        o2 o2VarB = o2VarG.b(o2VarG.f29390b);
        this.f29655s0 = o2VarB;
        o2VarB.f29404p = o2VarB.f29406r;
        this.f29655s0.f29405q = 0L;
        this.f29652r.release();
        this.f29632h.g();
        s1();
        Surface surface = this.V;
        if (surface != null) {
            surface.release();
            this.V = null;
        }
        if (this.f29645n0) {
            ((a4.e0) a4.a.e(this.f29643m0)).b(0);
            this.f29645n0 = false;
        }
        this.f29637j0 = n3.f.f31657c;
        this.f29647o0 = true;
    }

    public void s0(s.a aVar) {
        this.f29642m.add(aVar);
    }

    @Override // k2.r2
    public void seekTo(int i10, long j10) {
        J1();
        t1(i10, j10, false);
    }

    @Override // k2.r2
    public void setMediaItems(List<w1> list, boolean z10) {
        J1();
        x1(z0(list), z10);
    }

    @Override // k2.r2
    public void setPlayWhenReady(boolean z10) {
        J1();
        int iP = this.A.p(z10, getPlaybackState());
        F1(z10, iP, G0(z10, iP));
    }

    @Override // k2.r2
    public void setRepeatMode(final int i10) {
        J1();
        if (this.F != i10) {
            this.F = i10;
            this.f29638k.Q0(i10);
            this.f29640l.i(8, new s.a() { // from class: k2.t0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).onRepeatModeChanged(i10);
                }
            });
            E1();
            this.f29640l.f();
        }
    }

    @Override // k2.r2
    public void setShuffleModeEnabled(final boolean z10) {
        J1();
        if (this.G != z10) {
            this.G = z10;
            this.f29638k.T0(z10);
            this.f29640l.i(9, new s.a() { // from class: k2.n0
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).onShuffleModeEnabledChanged(z10);
                }
            });
            E1();
            this.f29640l.f();
        }
    }

    @Override // k2.r2
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        J1();
        if (surfaceView instanceof b4.k) {
            s1();
            B1(surfaceView);
            z1(surfaceView.getHolder());
        } else {
            if (!(surfaceView instanceof c4.l)) {
                C1(surfaceView == null ? null : surfaceView.getHolder());
                return;
            }
            s1();
            this.X = (c4.l) surfaceView;
            A0(this.f29664y).n(10000).m(this.X).l();
            this.X.d(this.f29663x);
            B1(this.X.getVideoSurface());
            z1(surfaceView.getHolder());
        }
    }

    @Override // k2.r2
    public void setVideoTextureView(@Nullable TextureView textureView) {
        J1();
        if (textureView == null) {
            v0();
            return;
        }
        s1();
        this.Z = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            a4.t.i("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f29663x);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            B1(null);
            o1(0, 0);
        } else {
            A1(surfaceTexture);
            o1(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // k2.r2
    public void setVolume(float f10) {
        J1();
        final float fO = a4.o0.o(f10, 0.0f, 1.0f);
        if (this.f29633h0 == fO) {
            return;
        }
        this.f29633h0 = fO;
        v1();
        this.f29640l.l(22, new s.a() { // from class: k2.s0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((r2.d) obj).onVolumeChanged(fO);
            }
        });
    }

    public void v0() {
        J1();
        s1();
        B1(null);
        o1(0, 0);
    }

    public void w0(@Nullable SurfaceHolder surfaceHolder) {
        J1();
        if (surfaceHolder == null || surfaceHolder != this.W) {
            return;
        }
        v0();
    }

    public void w1(List<l3.a0> list) {
        J1();
        x1(list, true);
    }

    public void x1(List<l3.a0> list, boolean z10) {
        J1();
        y1(list, -1, C.TIME_UNSET, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ExoPlayerImpl.java */
    final class c implements b4.z, m2.t, n3.p, c3.f, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, l.b, d.b, b.InterfaceC0600b, i3.b, s.a {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(r2.d dVar) {
            dVar.m(y0.this.P);
        }

        @Override // n3.p
        public void a(final n3.f fVar) {
            y0.this.f29637j0 = fVar;
            y0.this.f29640l.l(27, new s.a() { // from class: k2.e1
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).a(fVar);
                }
            });
        }

        @Override // m2.t
        public void b(n2.e eVar) {
            y0.this.f29652r.b(eVar);
            y0.this.S = null;
            y0.this.f29627e0 = null;
        }

        @Override // b4.z
        public void c(n2.e eVar) {
            y0.this.f29625d0 = eVar;
            y0.this.f29652r.c(eVar);
        }

        @Override // b4.z
        public void d(o1 o1Var, @Nullable n2.i iVar) {
            y0.this.R = o1Var;
            y0.this.f29652r.d(o1Var, iVar);
        }

        @Override // m2.t
        public void e(o1 o1Var, @Nullable n2.i iVar) {
            y0.this.S = o1Var;
            y0.this.f29652r.e(o1Var, iVar);
        }

        @Override // k2.d.b
        public void executePlayerCommand(int i10) {
            boolean playWhenReady = y0.this.getPlayWhenReady();
            y0.this.F1(playWhenReady, i10, y0.G0(playWhenReady, i10));
        }

        @Override // b4.z
        public void f(final b4.b0 b0Var) {
            y0.this.f29651q0 = b0Var;
            y0.this.f29640l.l(25, new s.a() { // from class: k2.g1
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).f(b0Var);
                }
            });
        }

        @Override // m2.t
        public void g(n2.e eVar) {
            y0.this.f29627e0 = eVar;
            y0.this.f29652r.g(eVar);
        }

        @Override // m2.t
        public /* synthetic */ void h(o1 o1Var) {
            m2.i.a(this, o1Var);
        }

        @Override // b4.z
        public void i(n2.e eVar) {
            y0.this.f29652r.i(eVar);
            y0.this.R = null;
            y0.this.f29625d0 = null;
        }

        @Override // c3.f
        public void j(final c3.a aVar) {
            y0 y0Var = y0.this;
            y0Var.f29653r0 = y0Var.f29653r0.b().I(aVar).F();
            b2 b2VarU0 = y0.this.u0();
            if (!b2VarU0.equals(y0.this.P)) {
                y0.this.P = b2VarU0;
                y0.this.f29640l.i(14, new s.a() { // from class: k2.z0
                    @Override // a4.s.a
                    public final void invoke(Object obj) {
                        this.f29676a.x((r2.d) obj);
                    }
                });
            }
            y0.this.f29640l.i(28, new s.a() { // from class: k2.a1
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).j(aVar);
                }
            });
            y0.this.f29640l.f();
        }

        @Override // b4.z
        public /* synthetic */ void k(o1 o1Var) {
            b4.o.a(this, o1Var);
        }

        @Override // k2.s.a
        public /* synthetic */ void l(boolean z10) {
            r.a(this, z10);
        }

        @Override // k2.s.a
        public void m(boolean z10) {
            y0.this.I1();
        }

        @Override // k2.b.InterfaceC0600b
        public void onAudioBecomingNoisy() {
            y0.this.F1(false, -1, 3);
        }

        @Override // m2.t
        public void onAudioCodecError(Exception exc) {
            y0.this.f29652r.onAudioCodecError(exc);
        }

        @Override // m2.t
        public void onAudioDecoderInitialized(String str, long j10, long j11) {
            y0.this.f29652r.onAudioDecoderInitialized(str, j10, j11);
        }

        @Override // m2.t
        public void onAudioDecoderReleased(String str) {
            y0.this.f29652r.onAudioDecoderReleased(str);
        }

        @Override // m2.t
        public void onAudioPositionAdvancing(long j10) {
            y0.this.f29652r.onAudioPositionAdvancing(j10);
        }

        @Override // m2.t
        public void onAudioSinkError(Exception exc) {
            y0.this.f29652r.onAudioSinkError(exc);
        }

        @Override // m2.t
        public void onAudioUnderrun(int i10, long j10, long j11) {
            y0.this.f29652r.onAudioUnderrun(i10, j10, j11);
        }

        @Override // n3.p
        public void onCues(final List<n3.b> list) {
            y0.this.f29640l.l(27, new s.a() { // from class: k2.b1
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).onCues(list);
                }
            });
        }

        @Override // b4.z
        public void onDroppedFrames(int i10, long j10) {
            y0.this.f29652r.onDroppedFrames(i10, j10);
        }

        @Override // b4.z
        public void onRenderedFirstFrame(Object obj, long j10) {
            y0.this.f29652r.onRenderedFirstFrame(obj, j10);
            if (y0.this.U == obj) {
                y0.this.f29640l.l(26, new s.a() { // from class: k2.f1
                    @Override // a4.s.a
                    public final void invoke(Object obj2) {
                        ((r2.d) obj2).onRenderedFirstFrame();
                    }
                });
            }
        }

        @Override // m2.t
        public void onSkipSilenceEnabledChanged(final boolean z10) {
            if (y0.this.f29635i0 == z10) {
                return;
            }
            y0.this.f29635i0 = z10;
            y0.this.f29640l.l(23, new s.a() { // from class: k2.h1
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).onSkipSilenceEnabledChanged(z10);
                }
            });
        }

        @Override // k2.i3.b
        public void onStreamTypeChanged(int i10) {
            final o oVarX0 = y0.x0(y0.this.B);
            if (oVarX0.equals(y0.this.f29649p0)) {
                return;
            }
            y0.this.f29649p0 = oVarX0;
            y0.this.f29640l.l(29, new s.a() { // from class: k2.c1
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).B(oVarX0);
                }
            });
        }

        @Override // k2.i3.b
        public void onStreamVolumeChanged(final int i10, final boolean z10) {
            y0.this.f29640l.l(30, new s.a() { // from class: k2.d1
                @Override // a4.s.a
                public final void invoke(Object obj) {
                    ((r2.d) obj).onDeviceVolumeChanged(i10, z10);
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            y0.this.A1(surfaceTexture);
            y0.this.o1(i10, i11);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            y0.this.B1(null);
            y0.this.o1(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            y0.this.o1(i10, i11);
        }

        @Override // b4.z
        public void onVideoCodecError(Exception exc) {
            y0.this.f29652r.onVideoCodecError(exc);
        }

        @Override // b4.z
        public void onVideoDecoderInitialized(String str, long j10, long j11) {
            y0.this.f29652r.onVideoDecoderInitialized(str, j10, j11);
        }

        @Override // b4.z
        public void onVideoDecoderReleased(String str) {
            y0.this.f29652r.onVideoDecoderReleased(str);
        }

        @Override // b4.z
        public void onVideoFrameProcessingOffset(long j10, int i10) {
            y0.this.f29652r.onVideoFrameProcessingOffset(j10, i10);
        }

        @Override // c4.l.b
        public void onVideoSurfaceCreated(Surface surface) {
            y0.this.B1(surface);
        }

        @Override // c4.l.b
        public void onVideoSurfaceDestroyed(Surface surface) {
            y0.this.B1(null);
        }

        @Override // k2.d.b
        public void setVolumeMultiplier(float f10) {
            y0.this.v1();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            y0.this.o1(i11, i12);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (y0.this.Y) {
                y0.this.B1(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (y0.this.Y) {
                y0.this.B1(null);
            }
            y0.this.o1(0, 0);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
