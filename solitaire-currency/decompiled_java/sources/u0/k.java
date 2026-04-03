package u0;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import java.util.Map;
import java.util.concurrent.Executor;
import p1.a;
import u0.h;
import u0.p;
import w0.a;
import w0.h;

/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements m, h.a, p.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f34326i = Log.isLoggable("Engine", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f34327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f34328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w0.h f34329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f34330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y f34331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f34332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f34333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final u0.a f34334h;

    /* JADX INFO: compiled from: Engine.java */
    @VisibleForTesting
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h.e f34335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Pools.Pool<h<?>> f34336b = p1.a.d(150, new C0704a());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f34337c;

        /* JADX INFO: renamed from: u0.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Engine.java */
        class C0704a implements a.d<h<?>> {
            C0704a() {
            }

            @Override // p1.a.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h<?> a() {
                a aVar = a.this;
                return new h<>(aVar.f34335a, aVar.f34336b);
            }
        }

        a(h.e eVar) {
            this.f34335a = eVar;
        }

        <R> h<R> a(com.bumptech.glide.d dVar, Object obj, n nVar, r0.f fVar, int i10, int i11, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, j jVar, Map<Class<?>, r0.l<?>> map, boolean z10, boolean z11, boolean z12, r0.h hVar, h.b<R> bVar) {
            h hVar2 = (h) o1.j.d(this.f34336b.acquire());
            int i12 = this.f34337c;
            this.f34337c = i12 + 1;
            return hVar2.o(dVar, obj, nVar, fVar, i10, i11, cls, cls2, fVar2, jVar, map, z10, z11, z12, hVar, bVar, i12);
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    @VisibleForTesting
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final x0.a f34339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final x0.a f34340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final x0.a f34341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final x0.a f34342d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final m f34343e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final p.a f34344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Pools.Pool<l<?>> f34345g = p1.a.d(150, new a());

        /* JADX INFO: compiled from: Engine.java */
        class a implements a.d<l<?>> {
            a() {
            }

            @Override // p1.a.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public l<?> a() {
                b bVar = b.this;
                return new l<>(bVar.f34339a, bVar.f34340b, bVar.f34341c, bVar.f34342d, bVar.f34343e, bVar.f34344f, bVar.f34345g);
            }
        }

        b(x0.a aVar, x0.a aVar2, x0.a aVar3, x0.a aVar4, m mVar, p.a aVar5) {
            this.f34339a = aVar;
            this.f34340b = aVar2;
            this.f34341c = aVar3;
            this.f34342d = aVar4;
            this.f34343e = mVar;
            this.f34344f = aVar5;
        }

        <R> l<R> a(r0.f fVar, boolean z10, boolean z11, boolean z12, boolean z13) {
            return ((l) o1.j.d(this.f34345g.acquire())).l(fVar, z10, z11, z12, z13);
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    private static class c implements h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0717a f34347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile w0.a f34348b;

        c(a.InterfaceC0717a interfaceC0717a) {
            this.f34347a = interfaceC0717a;
        }

        @Override // u0.h.e
        public w0.a a() {
            if (this.f34348b == null) {
                synchronized (this) {
                    if (this.f34348b == null) {
                        this.f34348b = this.f34347a.build();
                    }
                    if (this.f34348b == null) {
                        this.f34348b = new w0.b();
                    }
                }
            }
            return this.f34348b;
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l<?> f34349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final k1.g f34350b;

        d(k1.g gVar, l<?> lVar) {
            this.f34350b = gVar;
            this.f34349a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.f34349a.r(this.f34350b);
            }
        }
    }

    public k(w0.h hVar, a.InterfaceC0717a interfaceC0717a, x0.a aVar, x0.a aVar2, x0.a aVar3, x0.a aVar4, boolean z10) {
        this(hVar, interfaceC0717a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z10);
    }

    private p<?> e(r0.f fVar) {
        v<?> vVarC = this.f34329c.c(fVar);
        if (vVarC == null) {
            return null;
        }
        return vVarC instanceof p ? (p) vVarC : new p<>(vVarC, true, true, fVar, this);
    }

    @Nullable
    private p<?> g(r0.f fVar) {
        p<?> pVarE = this.f34334h.e(fVar);
        if (pVarE != null) {
            pVarE.b();
        }
        return pVarE;
    }

    private p<?> h(r0.f fVar) {
        p<?> pVarE = e(fVar);
        if (pVarE != null) {
            pVarE.b();
            this.f34334h.a(fVar, pVarE);
        }
        return pVarE;
    }

    @Nullable
    private p<?> i(n nVar, boolean z10, long j10) {
        if (!z10) {
            return null;
        }
        p<?> pVarG = g(nVar);
        if (pVarG != null) {
            if (f34326i) {
                j("Loaded resource from active resources", j10, nVar);
            }
            return pVarG;
        }
        p<?> pVarH = h(nVar);
        if (pVarH == null) {
            return null;
        }
        if (f34326i) {
            j("Loaded resource from cache", j10, nVar);
        }
        return pVarH;
    }

    private static void j(String str, long j10, r0.f fVar) {
        Log.v("Engine", str + " in " + o1.f.a(j10) + "ms, key: " + fVar);
    }

    private <R> d l(com.bumptech.glide.d dVar, Object obj, r0.f fVar, int i10, int i11, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, j jVar, Map<Class<?>, r0.l<?>> map, boolean z10, boolean z11, r0.h hVar, boolean z12, boolean z13, boolean z14, boolean z15, k1.g gVar, Executor executor, n nVar, long j10) {
        l<?> lVarA = this.f34327a.a(nVar, z15);
        if (lVarA != null) {
            lVarA.e(gVar, executor);
            if (f34326i) {
                j("Added to existing load", j10, nVar);
            }
            return new d(gVar, lVarA);
        }
        l<R> lVarA2 = this.f34330d.a(nVar, z12, z13, z14, z15);
        h<R> hVarA = this.f34333g.a(dVar, obj, nVar, fVar, i10, i11, cls, cls2, fVar2, jVar, map, z10, z11, z15, hVar, lVarA2);
        this.f34327a.c(nVar, lVarA2);
        lVarA2.e(gVar, executor);
        lVarA2.s(hVarA);
        if (f34326i) {
            j("Started new load", j10, nVar);
        }
        return new d(gVar, lVarA2);
    }

    @Override // w0.h.a
    public void a(@NonNull v<?> vVar) {
        this.f34331e.a(vVar);
    }

    @Override // u0.p.a
    public void b(r0.f fVar, p<?> pVar) {
        this.f34334h.d(fVar);
        if (pVar.d()) {
            this.f34329c.d(fVar, pVar);
        } else {
            this.f34331e.a(pVar);
        }
    }

    @Override // u0.m
    public synchronized void c(l<?> lVar, r0.f fVar, p<?> pVar) {
        if (pVar != null) {
            if (pVar.d()) {
                this.f34334h.a(fVar, pVar);
            }
            this.f34327a.d(fVar, lVar);
        } else {
            this.f34327a.d(fVar, lVar);
        }
    }

    @Override // u0.m
    public synchronized void d(l<?> lVar, r0.f fVar) {
        this.f34327a.d(fVar, lVar);
    }

    public <R> d f(com.bumptech.glide.d dVar, Object obj, r0.f fVar, int i10, int i11, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, j jVar, Map<Class<?>, r0.l<?>> map, boolean z10, boolean z11, r0.h hVar, boolean z12, boolean z13, boolean z14, boolean z15, k1.g gVar, Executor executor) {
        long jB = f34326i ? o1.f.b() : 0L;
        n nVarA = this.f34328b.a(obj, fVar, i10, i11, map, cls, cls2, hVar);
        synchronized (this) {
            p<?> pVarI = i(nVarA, z12, jB);
            if (pVarI == null) {
                return l(dVar, obj, fVar, i10, i11, cls, cls2, fVar2, jVar, map, z10, z11, hVar, z12, z13, z14, z15, gVar, executor, nVarA, jB);
            }
            gVar.a(pVarI, r0.a.MEMORY_CACHE);
            return null;
        }
    }

    public void k(v<?> vVar) {
        if (!(vVar instanceof p)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((p) vVar).e();
    }

    @VisibleForTesting
    k(w0.h hVar, a.InterfaceC0717a interfaceC0717a, x0.a aVar, x0.a aVar2, x0.a aVar3, x0.a aVar4, s sVar, o oVar, u0.a aVar5, b bVar, a aVar6, y yVar, boolean z10) {
        this.f34329c = hVar;
        c cVar = new c(interfaceC0717a);
        this.f34332f = cVar;
        u0.a aVar7 = aVar5 == null ? new u0.a(z10) : aVar5;
        this.f34334h = aVar7;
        aVar7.f(this);
        this.f34328b = oVar == null ? new o() : oVar;
        this.f34327a = sVar == null ? new s() : sVar;
        this.f34330d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.f34333g = aVar6 == null ? new a(cVar) : aVar6;
        this.f34331e = yVar == null ? new y() : yVar;
        hVar.e(this);
    }
}
