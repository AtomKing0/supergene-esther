package u0;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import p1.a;
import u0.h;
import u0.p;

/* JADX INFO: compiled from: EngineJob.java */
/* JADX INFO: loaded from: classes2.dex */
class l<R> implements h.b<R>, a.f {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final c f34352y = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f34353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p1.c f34354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p.a f34355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool<l<?>> f34356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f34357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m f34358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final x0.a f34359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final x0.a f34360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final x0.a f34361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final x0.a f34362j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f34363k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private r0.f f34364l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f34365m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f34366n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f34367o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f34368p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private v<?> f34369q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    r0.a f34370r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f34371s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    q f34372t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f34373u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    p<?> f34374v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private h<R> f34375w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile boolean f34376x;

    /* JADX INFO: compiled from: EngineJob.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k1.g f34377a;

        a(k1.g gVar) {
            this.f34377a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f34377a.e()) {
                synchronized (l.this) {
                    if (l.this.f34353a.b(this.f34377a)) {
                        l.this.f(this.f34377a);
                    }
                    l.this.i();
                }
            }
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k1.g f34379a;

        b(k1.g gVar) {
            this.f34379a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f34379a.e()) {
                synchronized (l.this) {
                    if (l.this.f34353a.b(this.f34379a)) {
                        l.this.f34374v.b();
                        l.this.g(this.f34379a);
                        l.this.r(this.f34379a);
                    }
                    l.this.i();
                }
            }
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    @VisibleForTesting
    static class c {
        c() {
        }

        public <R> p<R> a(v<R> vVar, boolean z10, r0.f fVar, p.a aVar) {
            return new p<>(vVar, z10, true, fVar, aVar);
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final k1.g f34381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f34382b;

        d(k1.g gVar, Executor executor) {
            this.f34381a = gVar;
            this.f34382b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f34381a.equals(((d) obj).f34381a);
            }
            return false;
        }

        public int hashCode() {
            return this.f34381a.hashCode();
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    static final class e implements Iterable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<d> f34383a;

        e() {
            this(new ArrayList(2));
        }

        private static d e(k1.g gVar) {
            return new d(gVar, o1.e.a());
        }

        void a(k1.g gVar, Executor executor) {
            this.f34383a.add(new d(gVar, executor));
        }

        boolean b(k1.g gVar) {
            return this.f34383a.contains(e(gVar));
        }

        void clear() {
            this.f34383a.clear();
        }

        e d() {
            return new e(new ArrayList(this.f34383a));
        }

        void f(k1.g gVar) {
            this.f34383a.remove(e(gVar));
        }

        boolean isEmpty() {
            return this.f34383a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f34383a.iterator();
        }

        int size() {
            return this.f34383a.size();
        }

        e(List<d> list) {
            this.f34383a = list;
        }
    }

    l(x0.a aVar, x0.a aVar2, x0.a aVar3, x0.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, pool, f34352y);
    }

    private x0.a j() {
        return this.f34366n ? this.f34361i : this.f34367o ? this.f34362j : this.f34360h;
    }

    private boolean m() {
        return this.f34373u || this.f34371s || this.f34376x;
    }

    private synchronized void q() {
        if (this.f34364l == null) {
            throw new IllegalArgumentException();
        }
        this.f34353a.clear();
        this.f34364l = null;
        this.f34374v = null;
        this.f34369q = null;
        this.f34373u = false;
        this.f34376x = false;
        this.f34371s = false;
        this.f34375w.x(false);
        this.f34375w = null;
        this.f34372t = null;
        this.f34370r = null;
        this.f34356d.release(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u0.h.b
    public void a(v<R> vVar, r0.a aVar) {
        synchronized (this) {
            this.f34369q = vVar;
            this.f34370r = aVar;
        }
        o();
    }

    @Override // u0.h.b
    public void b(q qVar) {
        synchronized (this) {
            this.f34372t = qVar;
        }
        n();
    }

    @Override // p1.a.f
    @NonNull
    public p1.c c() {
        return this.f34354b;
    }

    @Override // u0.h.b
    public void d(h<?> hVar) {
        j().execute(hVar);
    }

    synchronized void e(k1.g gVar, Executor executor) {
        this.f34354b.c();
        this.f34353a.a(gVar, executor);
        boolean z10 = true;
        if (this.f34371s) {
            k(1);
            executor.execute(new b(gVar));
        } else if (this.f34373u) {
            k(1);
            executor.execute(new a(gVar));
        } else {
            if (this.f34376x) {
                z10 = false;
            }
            o1.j.a(z10, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    @GuardedBy("this")
    void f(k1.g gVar) {
        try {
            gVar.b(this.f34372t);
        } catch (Throwable th) {
            throw new u0.b(th);
        }
    }

    @GuardedBy("this")
    void g(k1.g gVar) {
        try {
            gVar.a(this.f34374v, this.f34370r);
        } catch (Throwable th) {
            throw new u0.b(th);
        }
    }

    void h() {
        if (m()) {
            return;
        }
        this.f34376x = true;
        this.f34375w.f();
        this.f34358f.d(this, this.f34364l);
    }

    void i() {
        p<?> pVar;
        synchronized (this) {
            this.f34354b.c();
            o1.j.a(m(), "Not yet complete!");
            int iDecrementAndGet = this.f34363k.decrementAndGet();
            o1.j.a(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                pVar = this.f34374v;
                q();
            } else {
                pVar = null;
            }
        }
        if (pVar != null) {
            pVar.e();
        }
    }

    synchronized void k(int i10) {
        p<?> pVar;
        o1.j.a(m(), "Not yet complete!");
        if (this.f34363k.getAndAdd(i10) == 0 && (pVar = this.f34374v) != null) {
            pVar.b();
        }
    }

    @VisibleForTesting
    synchronized l<R> l(r0.f fVar, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f34364l = fVar;
        this.f34365m = z10;
        this.f34366n = z11;
        this.f34367o = z12;
        this.f34368p = z13;
        return this;
    }

    void n() {
        synchronized (this) {
            this.f34354b.c();
            if (this.f34376x) {
                q();
                return;
            }
            if (this.f34353a.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.f34373u) {
                throw new IllegalStateException("Already failed once");
            }
            this.f34373u = true;
            r0.f fVar = this.f34364l;
            e eVarD = this.f34353a.d();
            k(eVarD.size() + 1);
            this.f34358f.c(this, fVar, null);
            for (d dVar : eVarD) {
                dVar.f34382b.execute(new a(dVar.f34381a));
            }
            i();
        }
    }

    void o() {
        synchronized (this) {
            this.f34354b.c();
            if (this.f34376x) {
                this.f34369q.recycle();
                q();
                return;
            }
            if (this.f34353a.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.f34371s) {
                throw new IllegalStateException("Already have resource");
            }
            this.f34374v = this.f34357e.a(this.f34369q, this.f34365m, this.f34364l, this.f34355c);
            this.f34371s = true;
            e eVarD = this.f34353a.d();
            k(eVarD.size() + 1);
            this.f34358f.c(this, this.f34364l, this.f34374v);
            for (d dVar : eVarD) {
                dVar.f34382b.execute(new b(dVar.f34381a));
            }
            i();
        }
    }

    boolean p() {
        return this.f34368p;
    }

    synchronized void r(k1.g gVar) {
        this.f34354b.c();
        this.f34353a.f(gVar);
        if (this.f34353a.isEmpty()) {
            h();
            if ((this.f34371s || this.f34373u) && this.f34363k.get() == 0) {
                q();
            }
        }
    }

    public synchronized void s(h<R> hVar) {
        this.f34375w = hVar;
        (hVar.D() ? this.f34359g : j()).execute(hVar);
    }

    @VisibleForTesting
    l(x0.a aVar, x0.a aVar2, x0.a aVar3, x0.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool, c cVar) {
        this.f34353a = new e();
        this.f34354b = p1.c.a();
        this.f34363k = new AtomicInteger();
        this.f34359g = aVar;
        this.f34360h = aVar2;
        this.f34361i = aVar3;
        this.f34362j = aVar4;
        this.f34358f = mVar;
        this.f34355c = aVar5;
        this.f34356d = pool;
        this.f34357e = cVar;
    }
}
