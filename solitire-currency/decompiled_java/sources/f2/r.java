package f2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import b2.c;
import h2.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import z1.g;

/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f25630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z1.e f25631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g2.d f25632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x f25633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f25634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h2.b f25635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i2.a f25636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final i2.a f25637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final g2.c f25638i;

    public r(Context context, z1.e eVar, g2.d dVar, x xVar, Executor executor, h2.b bVar, i2.a aVar, i2.a aVar2, g2.c cVar) {
        this.f25630a = context;
        this.f25631b = eVar;
        this.f25632c = dVar;
        this.f25633d = xVar;
        this.f25634e = executor;
        this.f25635f = bVar;
        this.f25636g = aVar;
        this.f25637h = aVar2;
        this.f25638i = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l(y1.o oVar) {
        return Boolean.valueOf(this.f25632c.t0(oVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterable m(y1.o oVar) {
        return this.f25632c.Q(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable, y1.o oVar, long j10) {
        this.f25632c.Y(iterable);
        this.f25632c.H0(oVar, this.f25636g.a() + j10);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(Iterable iterable) {
        this.f25632c.m(iterable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p() {
        this.f25638i.a();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.f25638i.c(((Integer) r0.getValue()).intValue(), c.b.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(y1.o oVar, long j10) {
        this.f25632c.H0(oVar, this.f25636g.a() + j10);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(y1.o oVar, int i10) {
        this.f25633d.a(oVar, i10 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final y1.o oVar, final int i10, Runnable runnable) {
        try {
            try {
                h2.b bVar = this.f25635f;
                final g2.d dVar = this.f25632c;
                Objects.requireNonNull(dVar);
                bVar.i(new b.a() { // from class: f2.i
                    @Override // h2.b.a
                    public final Object execute() {
                        return Integer.valueOf(dVar.l());
                    }
                });
                if (k()) {
                    u(oVar, i10);
                } else {
                    this.f25635f.i(new b.a() { // from class: f2.j
                        @Override // h2.b.a
                        public final Object execute() {
                            return this.f25611a.s(oVar, i10);
                        }
                    });
                }
            } catch (h2.a unused) {
                this.f25633d.a(oVar, i10 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    @VisibleForTesting
    public y1.i j(z1.m mVar) {
        h2.b bVar = this.f25635f;
        final g2.c cVar = this.f25638i;
        Objects.requireNonNull(cVar);
        return mVar.a(y1.i.a().i(this.f25636g.a()).k(this.f25637h.a()).j("GDT_CLIENT_METRICS").h(new y1.h(w1.c.b("proto"), ((b2.a) bVar.i(new b.a() { // from class: f2.h
            @Override // h2.b.a
            public final Object execute() {
                return cVar.n();
            }
        })).f())).d());
    }

    boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f25630a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public z1.g u(final y1.o oVar, int i10) {
        z1.g gVarB;
        z1.m mVar = this.f25631b.get(oVar.b());
        long jMax = 0;
        z1.g gVarE = z1.g.e(0L);
        while (true) {
            final long j10 = jMax;
            while (((Boolean) this.f25635f.i(new b.a() { // from class: f2.k
                @Override // h2.b.a
                public final Object execute() {
                    return this.f25614a.l(oVar);
                }
            })).booleanValue()) {
                final Iterable iterable = (Iterable) this.f25635f.i(new b.a() { // from class: f2.l
                    @Override // h2.b.a
                    public final Object execute() {
                        return this.f25616a.m(oVar);
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return gVarE;
                }
                if (mVar == null) {
                    c2.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", oVar);
                    gVarB = z1.g.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((g2.k) it.next()).b());
                    }
                    if (oVar.e()) {
                        arrayList.add(j(mVar));
                    }
                    gVarB = mVar.b(z1.f.a().b(arrayList).c(oVar.c()).a());
                }
                gVarE = gVarB;
                if (gVarE.c() == g.a.TRANSIENT_ERROR) {
                    this.f25635f.i(new b.a() { // from class: f2.m
                        @Override // h2.b.a
                        public final Object execute() {
                            return this.f25618a.n(iterable, oVar, j10);
                        }
                    });
                    this.f25633d.b(oVar, i10 + 1, true);
                    return gVarE;
                }
                this.f25635f.i(new b.a() { // from class: f2.n
                    @Override // h2.b.a
                    public final Object execute() {
                        return this.f25622a.o(iterable);
                    }
                });
                if (gVarE.c() == g.a.OK) {
                    jMax = Math.max(j10, gVarE.b());
                    if (oVar.e()) {
                        this.f25635f.i(new b.a() { // from class: f2.o
                            @Override // h2.b.a
                            public final Object execute() {
                                return this.f25624a.p();
                            }
                        });
                    }
                } else if (gVarE.c() == g.a.INVALID_PAYLOAD) {
                    final HashMap map = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String strJ = ((g2.k) it2.next()).b().j();
                        if (map.containsKey(strJ)) {
                            map.put(strJ, Integer.valueOf(((Integer) map.get(strJ)).intValue() + 1));
                        } else {
                            map.put(strJ, 1);
                        }
                    }
                    this.f25635f.i(new b.a() { // from class: f2.p
                        @Override // h2.b.a
                        public final Object execute() {
                            return this.f25625a.q(map);
                        }
                    });
                }
            }
            this.f25635f.i(new b.a() { // from class: f2.q
                @Override // h2.b.a
                public final Object execute() {
                    return this.f25627a.r(oVar, j10);
                }
            });
            return gVarE;
        }
    }

    public void v(final y1.o oVar, final int i10, final Runnable runnable) {
        this.f25634e.execute(new Runnable() { // from class: f2.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f25605a.t(oVar, i10, runnable);
            }
        });
    }
}
