package k2;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.ExoPlayer;
import k2.j;
import k2.s;
import l3.a0;

/* JADX INFO: compiled from: ExoPlayer.java */
/* JADX INFO: loaded from: classes2.dex */
public interface s extends r2 {

    /* JADX INFO: compiled from: ExoPlayer.java */
    public interface a {
        void l(boolean z10);

        void m(boolean z10);
    }

    /* JADX INFO: compiled from: ExoPlayer.java */
    public static final class b {
        boolean A;
        boolean B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f29444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a4.d f29445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f29446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        e5.u<e3> f29447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        e5.u<a0.a> f29448e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        e5.u<x3.b0> f29449f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        e5.u<u1> f29450g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        e5.u<z3.e> f29451h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        e5.g<a4.d, l2.a> f29452i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Looper f29453j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        a4.e0 f29454k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        m2.e f29455l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f29456m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f29457n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f29458o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f29459p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f29460q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f29461r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        boolean f29462s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        f3 f29463t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        long f29464u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        long f29465v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        t1 f29466w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        long f29467x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        long f29468y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        boolean f29469z;

        public b(final Context context) {
            this(context, new e5.u() { // from class: k2.t
                @Override // e5.u
                public final Object get() {
                    return s.b.f(context);
                }
            }, new e5.u() { // from class: k2.u
                @Override // e5.u
                public final Object get() {
                    return s.b.g(context);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e3 f(Context context) {
            return new m(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ a0.a g(Context context) {
            return new l3.p(context, new p2.i());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ x3.b0 h(Context context) {
            return new x3.m(context);
        }

        public s e() {
            a4.a.g(!this.B);
            this.B = true;
            return new y0(this, null);
        }

        public b j(Looper looper) {
            a4.a.g(!this.B);
            a4.a.e(looper);
            this.f29453j = looper;
            return this;
        }

        public b k(boolean z10) {
            a4.a.g(!this.B);
            this.f29469z = z10;
            return this;
        }

        private b(final Context context, e5.u<e3> uVar, e5.u<a0.a> uVar2) {
            this(context, uVar, uVar2, new e5.u() { // from class: k2.v
                @Override // e5.u
                public final Object get() {
                    return s.b.h(context);
                }
            }, new e5.u() { // from class: k2.w
                @Override // e5.u
                public final Object get() {
                    return new k();
                }
            }, new e5.u() { // from class: k2.x
                @Override // e5.u
                public final Object get() {
                    return z3.r.k(context);
                }
            }, new e5.g() { // from class: k2.y
                @Override // e5.g
                public final Object apply(Object obj) {
                    return new l2.o1((a4.d) obj);
                }
            });
        }

        private b(Context context, e5.u<e3> uVar, e5.u<a0.a> uVar2, e5.u<x3.b0> uVar3, e5.u<u1> uVar4, e5.u<z3.e> uVar5, e5.g<a4.d, l2.a> gVar) {
            this.f29444a = (Context) a4.a.e(context);
            this.f29447d = uVar;
            this.f29448e = uVar2;
            this.f29449f = uVar3;
            this.f29450g = uVar4;
            this.f29451h = uVar5;
            this.f29452i = gVar;
            this.f29453j = a4.o0.K();
            this.f29455l = m2.e.f31249g;
            this.f29457n = 0;
            this.f29460q = 1;
            this.f29461r = 0;
            this.f29462s = true;
            this.f29463t = f3.f29113g;
            this.f29464u = 5000L;
            this.f29465v = 15000L;
            this.f29466w = new j.b().a();
            this.f29445b = a4.d.f148a;
            this.f29467x = 500L;
            this.f29468y = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
            this.A = true;
        }
    }

    void e(l3.a0 a0Var);
}
