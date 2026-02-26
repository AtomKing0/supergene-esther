package l3;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k2.o1;
import k2.w1;
import l3.a0;
import l3.p0;
import l3.z0;
import p2.b0;
import z3.k;
import z3.s;

/* JADX INFO: compiled from: DefaultMediaSourceFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements a0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f30638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k.a f30639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private a0.a f30640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private z3.f0 f30641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f30642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f30643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f30644g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f30645h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f30646i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f30647j;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DefaultMediaSourceFactory.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p2.r f30648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<Integer, e5.u<a0.a>> f30649b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<Integer> f30650c = new HashSet();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<Integer, a0.a> f30651d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private k.a f30652e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private o2.b0 f30653f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private z3.f0 f30654g;

        public a(p2.r rVar) {
            this.f30648a = rVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ a0.a k(k.a aVar) {
            return new p0.b(aVar, this.f30648a);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
        @androidx.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private e5.u<l3.a0.a> l(int r5) {
            /*
                r4 = this;
                java.util.Map<java.lang.Integer, e5.u<l3.a0$a>> r0 = r4.f30649b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L19
                java.util.Map<java.lang.Integer, e5.u<l3.a0$a>> r0 = r4.f30649b
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r5 = r0.get(r5)
                e5.u r5 = (e5.u) r5
                return r5
            L19:
                z3.k$a r0 = r4.f30652e
                java.lang.Object r0 = a4.a.e(r0)
                z3.k$a r0 = (z3.k.a) r0
                java.lang.Class<l3.a0$a> r1 = l3.a0.a.class
                r2 = 0
                if (r5 == 0) goto L6a
                r3 = 1
                if (r5 == r3) goto L5a
                r3 = 2
                if (r5 == r3) goto L4a
                r3 = 3
                if (r5 == r3) goto L3a
                r1 = 4
                if (r5 == r1) goto L33
                goto L7a
            L33:
                l3.o r1 = new l3.o     // Catch: java.lang.ClassNotFoundException -> L7a
                r1.<init>()     // Catch: java.lang.ClassNotFoundException -> L7a
            L38:
                r2 = r1
                goto L7a
            L3a:
                java.lang.String r0 = "com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory"
                java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.ClassNotFoundException -> L7a
                java.lang.Class r0 = r0.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L7a
                l3.n r1 = new l3.n     // Catch: java.lang.ClassNotFoundException -> L7a
                r1.<init>()     // Catch: java.lang.ClassNotFoundException -> L7a
                goto L38
            L4a:
                java.lang.String r3 = "com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L7a
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L7a
                l3.m r3 = new l3.m     // Catch: java.lang.ClassNotFoundException -> L7a
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L7a
                goto L79
            L5a:
                java.lang.String r3 = "com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L7a
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L7a
                l3.l r3 = new l3.l     // Catch: java.lang.ClassNotFoundException -> L7a
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L7a
                goto L79
            L6a:
                java.lang.String r3 = "com.google.android.exoplayer2.source.dash.DashMediaSource$Factory"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L7a
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L7a
                l3.k r3 = new l3.k     // Catch: java.lang.ClassNotFoundException -> L7a
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L7a
            L79:
                r2 = r3
            L7a:
                java.util.Map<java.lang.Integer, e5.u<l3.a0$a>> r0 = r4.f30649b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                r0.put(r1, r2)
                if (r2 == 0) goto L8e
                java.util.Set<java.lang.Integer> r0 = r4.f30650c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r0.add(r5)
            L8e:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: l3.p.a.l(int):e5.u");
        }

        @Nullable
        public a0.a f(int i10) {
            a0.a aVar = this.f30651d.get(Integer.valueOf(i10));
            if (aVar != null) {
                return aVar;
            }
            e5.u<a0.a> uVarL = l(i10);
            if (uVarL == null) {
                return null;
            }
            a0.a aVar2 = uVarL.get();
            o2.b0 b0Var = this.f30653f;
            if (b0Var != null) {
                aVar2.c(b0Var);
            }
            z3.f0 f0Var = this.f30654g;
            if (f0Var != null) {
                aVar2.a(f0Var);
            }
            this.f30651d.put(Integer.valueOf(i10), aVar2);
            return aVar2;
        }

        public void m(k.a aVar) {
            if (aVar != this.f30652e) {
                this.f30652e = aVar;
                this.f30649b.clear();
                this.f30651d.clear();
            }
        }

        public void n(o2.b0 b0Var) {
            this.f30653f = b0Var;
            Iterator<a0.a> it = this.f30651d.values().iterator();
            while (it.hasNext()) {
                it.next().c(b0Var);
            }
        }

        public void o(z3.f0 f0Var) {
            this.f30654g = f0Var;
            Iterator<a0.a> it = this.f30651d.values().iterator();
            while (it.hasNext()) {
                it.next().a(f0Var);
            }
        }
    }

    public p(Context context, p2.r rVar) {
        this(new s.a(context), rVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ a0.a e(Class cls) {
        return j(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ a0.a f(Class cls, k.a aVar) {
        return k(cls, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ p2.l[] g(o1 o1Var) {
        p2.l[] lVarArr = new p2.l[1];
        n3.l lVar = n3.l.f31671a;
        lVarArr[0] = lVar.a(o1Var) ? new n3.m(lVar.b(o1Var), o1Var) : new b(o1Var);
        return lVarArr;
    }

    private static a0 h(w1 w1Var, a0 a0Var) {
        w1.d dVar = w1Var.f29521f;
        if (dVar.f29538a == 0 && dVar.f29539b == Long.MIN_VALUE && !dVar.f29541d) {
            return a0Var;
        }
        long jW0 = a4.o0.w0(w1Var.f29521f.f29538a);
        long jW02 = a4.o0.w0(w1Var.f29521f.f29539b);
        w1.d dVar2 = w1Var.f29521f;
        return new d(a0Var, jW0, jW02, !dVar2.f29542e, dVar2.f29540c, dVar2.f29541d);
    }

    private a0 i(w1 w1Var, a0 a0Var) {
        a4.a.e(w1Var.f29517b);
        w1Var.f29517b.getClass();
        return a0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a0.a j(Class<? extends a0.a> cls) {
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e10) {
            throw new IllegalStateException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a0.a k(Class<? extends a0.a> cls, k.a aVar) {
        try {
            return cls.getConstructor(k.a.class).newInstance(aVar);
        } catch (Exception e10) {
            throw new IllegalStateException(e10);
        }
    }

    @Override // l3.a0.a
    public a0 b(w1 w1Var) {
        a4.a.e(w1Var.f29517b);
        String scheme = w1Var.f29517b.f29580a.getScheme();
        if (scheme != null && scheme.equals(C.SSAI_SCHEME)) {
            return ((a0.a) a4.a.e(this.f30640c)).b(w1Var);
        }
        w1.h hVar = w1Var.f29517b;
        int iK0 = a4.o0.k0(hVar.f29580a, hVar.f29581b);
        a0.a aVarF = this.f30638a.f(iK0);
        a4.a.j(aVarF, "No suitable media source factory found for content type: " + iK0);
        w1.g.a aVarB = w1Var.f29519d.b();
        if (w1Var.f29519d.f29570a == C.TIME_UNSET) {
            aVarB.k(this.f30642e);
        }
        if (w1Var.f29519d.f29573d == -3.4028235E38f) {
            aVarB.j(this.f30645h);
        }
        if (w1Var.f29519d.f29574e == -3.4028235E38f) {
            aVarB.h(this.f30646i);
        }
        if (w1Var.f29519d.f29571b == C.TIME_UNSET) {
            aVarB.i(this.f30643f);
        }
        if (w1Var.f29519d.f29572c == C.TIME_UNSET) {
            aVarB.g(this.f30644g);
        }
        w1.g gVarF = aVarB.f();
        if (!gVarF.equals(w1Var.f29519d)) {
            w1Var = w1Var.b().c(gVarF).a();
        }
        a0 a0VarB = aVarF.b(w1Var);
        com.google.common.collect.y<w1.l> yVar = ((w1.h) a4.o0.j(w1Var.f29517b)).f29585f;
        if (!yVar.isEmpty()) {
            a0[] a0VarArr = new a0[yVar.size() + 1];
            a0VarArr[0] = a0VarB;
            for (int i10 = 0; i10 < yVar.size(); i10++) {
                if (this.f30647j) {
                    final o1 o1VarE = new o1.b().e0(yVar.get(i10).f29597b).V(yVar.get(i10).f29598c).g0(yVar.get(i10).f29599d).c0(yVar.get(i10).f29600e).U(yVar.get(i10).f29601f).S(yVar.get(i10).f29602g).E();
                    p0.b bVar = new p0.b(this.f30639b, new p2.r() { // from class: l3.j
                        @Override // p2.r
                        public final p2.l[] createExtractors() {
                            return p.g(o1VarE);
                        }

                        @Override // p2.r
                        public /* synthetic */ p2.l[] createExtractors(Uri uri, Map map) {
                            return p2.q.a(this, uri, map);
                        }
                    });
                    z3.f0 f0Var = this.f30641d;
                    if (f0Var != null) {
                        bVar.a(f0Var);
                    }
                    a0VarArr[i10 + 1] = bVar.b(w1.d(yVar.get(i10).f29596a.toString()));
                } else {
                    z0.b bVar2 = new z0.b(this.f30639b);
                    z3.f0 f0Var2 = this.f30641d;
                    if (f0Var2 != null) {
                        bVar2.b(f0Var2);
                    }
                    a0VarArr[i10 + 1] = bVar2.a(yVar.get(i10), C.TIME_UNSET);
                }
            }
            a0VarB = new i0(a0VarArr);
        }
        return i(w1Var, h(w1Var, a0VarB));
    }

    @Override // l3.a0.a
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public p c(o2.b0 b0Var) {
        this.f30638a.n((o2.b0) a4.a.f(b0Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @Override // l3.a0.a
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public p a(z3.f0 f0Var) {
        this.f30641d = (z3.f0) a4.a.f(f0Var, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f30638a.o(f0Var);
        return this;
    }

    public p(k.a aVar) {
        this(aVar, new p2.i());
    }

    public p(k.a aVar, p2.r rVar) {
        this.f30639b = aVar;
        a aVar2 = new a(rVar);
        this.f30638a = aVar2;
        aVar2.m(aVar);
        this.f30642e = C.TIME_UNSET;
        this.f30643f = C.TIME_UNSET;
        this.f30644g = C.TIME_UNSET;
        this.f30645h = -3.4028235E38f;
        this.f30646i = -3.4028235E38f;
    }

    /* JADX INFO: compiled from: DefaultMediaSourceFactory.java */
    private static final class b implements p2.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o1 f30655a;

        public b(o1 o1Var) {
            this.f30655a = o1Var;
        }

        @Override // p2.l
        public int a(p2.m mVar, p2.a0 a0Var) throws IOException {
            return mVar.skip(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        @Override // p2.l
        public void b(p2.n nVar) {
            p2.e0 e0VarTrack = nVar.track(0, 3);
            nVar.h(new b0.b(C.TIME_UNSET));
            nVar.endTracks();
            e0VarTrack.f(this.f30655a.b().e0(MimeTypes.TEXT_UNKNOWN).I(this.f30655a.f29347l).E());
        }

        @Override // p2.l
        public boolean c(p2.m mVar) {
            return true;
        }

        @Override // p2.l
        public void release() {
        }

        @Override // p2.l
        public void seek(long j10, long j11) {
        }
    }
}
