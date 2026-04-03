package k2;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l3.a0;
import l3.g0;
import l3.w0;
import o2.w;

/* JADX INFO: compiled from: MediaSourceList.java */
/* JADX INFO: loaded from: classes2.dex */
final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l2.t1 f29133a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f29137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g0.a f29138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final w.a f29139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashMap<c, b> f29140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Set<c> f29141i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f29143k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private z3.m0 f29144l;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private l3.w0 f29142j = new w0.a(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IdentityHashMap<l3.x, c> f29135c = new IdentityHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Object, c> f29136d = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c> f29134b = new ArrayList();

    /* JADX INFO: compiled from: MediaSourceList.java */
    private final class a implements l3.g0, o2.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f29145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private g0.a f29146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private w.a f29147c;

        public a(c cVar) {
            this.f29146b = i2.this.f29138f;
            this.f29147c = i2.this.f29139g;
            this.f29145a = cVar;
        }

        private boolean a(int i10, @Nullable a0.b bVar) {
            a0.b bVarN;
            if (bVar != null) {
                bVarN = i2.n(this.f29145a, bVar);
                if (bVarN == null) {
                    return false;
                }
            } else {
                bVarN = null;
            }
            int iR = i2.r(this.f29145a, i10);
            g0.a aVar = this.f29146b;
            if (aVar.f30536a != iR || !a4.o0.c(aVar.f30537b, bVarN)) {
                this.f29146b = i2.this.f29138f.x(iR, bVarN, 0L);
            }
            w.a aVar2 = this.f29147c;
            if (aVar2.f31944a == iR && a4.o0.c(aVar2.f31945b, bVarN)) {
                return true;
            }
            this.f29147c = i2.this.f29139g.u(iR, bVarN);
            return true;
        }

        @Override // o2.w
        public void A(int i10, @Nullable a0.b bVar) {
            if (a(i10, bVar)) {
                this.f29147c.m();
            }
        }

        @Override // o2.w
        public void C(int i10, @Nullable a0.b bVar, int i11) {
            if (a(i10, bVar)) {
                this.f29147c.k(i11);
            }
        }

        @Override // l3.g0
        public void J(int i10, @Nullable a0.b bVar, l3.t tVar, l3.w wVar) {
            if (a(i10, bVar)) {
                this.f29146b.p(tVar, wVar);
            }
        }

        @Override // l3.g0
        public void K(int i10, @Nullable a0.b bVar, l3.w wVar) {
            if (a(i10, bVar)) {
                this.f29146b.i(wVar);
            }
        }

        @Override // l3.g0
        public void k(int i10, @Nullable a0.b bVar, l3.t tVar, l3.w wVar) {
            if (a(i10, bVar)) {
                this.f29146b.v(tVar, wVar);
            }
        }

        @Override // l3.g0
        public void n(int i10, @Nullable a0.b bVar, l3.t tVar, l3.w wVar) {
            if (a(i10, bVar)) {
                this.f29146b.r(tVar, wVar);
            }
        }

        @Override // l3.g0
        public void o(int i10, @Nullable a0.b bVar, l3.t tVar, l3.w wVar, IOException iOException, boolean z10) {
            if (a(i10, bVar)) {
                this.f29146b.t(tVar, wVar, iOException, z10);
            }
        }

        @Override // o2.w
        public void p(int i10, @Nullable a0.b bVar) {
            if (a(i10, bVar)) {
                this.f29147c.i();
            }
        }

        @Override // o2.w
        public /* synthetic */ void q(int i10, a0.b bVar) {
            o2.p.a(this, i10, bVar);
        }

        @Override // o2.w
        public void s(int i10, @Nullable a0.b bVar) {
            if (a(i10, bVar)) {
                this.f29147c.j();
            }
        }

        @Override // o2.w
        public void v(int i10, @Nullable a0.b bVar) {
            if (a(i10, bVar)) {
                this.f29147c.h();
            }
        }

        @Override // o2.w
        public void w(int i10, @Nullable a0.b bVar, Exception exc) {
            if (a(i10, bVar)) {
                this.f29147c.l(exc);
            }
        }
    }

    /* JADX INFO: compiled from: MediaSourceList.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l3.a0 f29149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a0.c f29150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f29151c;

        public b(l3.a0 a0Var, a0.c cVar, a aVar) {
            this.f29149a = a0Var;
            this.f29150b = cVar;
            this.f29151c = aVar;
        }
    }

    /* JADX INFO: compiled from: MediaSourceList.java */
    static final class c implements g2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l3.v f29152a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f29155d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f29156e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<a0.b> f29154c = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f29153b = new Object();

        public c(l3.a0 a0Var, boolean z10) {
            this.f29152a = new l3.v(a0Var, z10);
        }

        public void a(int i10) {
            this.f29155d = i10;
            this.f29156e = false;
            this.f29154c.clear();
        }

        @Override // k2.g2
        public n3 getTimeline() {
            return this.f29152a.P();
        }

        @Override // k2.g2
        public Object getUid() {
            return this.f29153b;
        }
    }

    /* JADX INFO: compiled from: MediaSourceList.java */
    public interface d {
        void onPlaylistUpdateRequested();
    }

    public i2(d dVar, l2.a aVar, Handler handler, l2.t1 t1Var) {
        this.f29133a = t1Var;
        this.f29137e = dVar;
        g0.a aVar2 = new g0.a();
        this.f29138f = aVar2;
        w.a aVar3 = new w.a();
        this.f29139g = aVar3;
        this.f29140h = new HashMap<>();
        this.f29141i = new HashSet();
        aVar2.f(handler, aVar);
        aVar3.g(handler, aVar);
    }

    private void B(int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            c cVarRemove = this.f29134b.remove(i12);
            this.f29136d.remove(cVarRemove.f29153b);
            g(i12, -cVarRemove.f29152a.P().t());
            cVarRemove.f29156e = true;
            if (this.f29143k) {
                u(cVarRemove);
            }
        }
    }

    private void g(int i10, int i11) {
        while (i10 < this.f29134b.size()) {
            this.f29134b.get(i10).f29155d += i11;
            i10++;
        }
    }

    private void j(c cVar) {
        b bVar = this.f29140h.get(cVar);
        if (bVar != null) {
            bVar.f29149a.i(bVar.f29150b);
        }
    }

    private void k() {
        Iterator<c> it = this.f29141i.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f29154c.isEmpty()) {
                j(next);
                it.remove();
            }
        }
    }

    private void l(c cVar) {
        this.f29141i.add(cVar);
        b bVar = this.f29140h.get(cVar);
        if (bVar != null) {
            bVar.f29149a.b(bVar.f29150b);
        }
    }

    private static Object m(Object obj) {
        return k2.a.B(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static a0.b n(c cVar, a0.b bVar) {
        for (int i10 = 0; i10 < cVar.f29154c.size(); i10++) {
            if (cVar.f29154c.get(i10).f30781d == bVar.f30781d) {
                return bVar.c(p(cVar, bVar.f30778a));
            }
        }
        return null;
    }

    private static Object o(Object obj) {
        return k2.a.C(obj);
    }

    private static Object p(c cVar, Object obj) {
        return k2.a.E(cVar.f29153b, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(c cVar, int i10) {
        return i10 + cVar.f29155d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(l3.a0 a0Var, n3 n3Var) {
        this.f29137e.onPlaylistUpdateRequested();
    }

    private void u(c cVar) {
        if (cVar.f29156e && cVar.f29154c.isEmpty()) {
            b bVar = (b) a4.a.e(this.f29140h.remove(cVar));
            bVar.f29149a.a(bVar.f29150b);
            bVar.f29149a.g(bVar.f29151c);
            bVar.f29149a.f(bVar.f29151c);
            this.f29141i.remove(cVar);
        }
    }

    private void x(c cVar) {
        l3.v vVar = cVar.f29152a;
        a0.c cVar2 = new a0.c() { // from class: k2.h2
            @Override // l3.a0.c
            public final void a(l3.a0 a0Var, n3 n3Var) {
                this.f29122a.t(a0Var, n3Var);
            }
        };
        a aVar = new a(cVar);
        this.f29140h.put(cVar, new b(vVar, cVar2, aVar));
        vVar.h(a4.o0.w(), aVar);
        vVar.d(a4.o0.w(), aVar);
        vVar.c(cVar2, this.f29144l, this.f29133a);
    }

    public n3 A(int i10, int i11, l3.w0 w0Var) {
        a4.a.a(i10 >= 0 && i10 <= i11 && i11 <= q());
        this.f29142j = w0Var;
        B(i10, i11);
        return i();
    }

    public n3 C(List<c> list, l3.w0 w0Var) {
        B(0, this.f29134b.size());
        return f(this.f29134b.size(), list, w0Var);
    }

    public n3 D(l3.w0 w0Var) {
        int iQ = q();
        if (w0Var.getLength() != iQ) {
            w0Var = w0Var.cloneAndClear().cloneAndInsert(0, iQ);
        }
        this.f29142j = w0Var;
        return i();
    }

    public n3 f(int i10, List<c> list, l3.w0 w0Var) {
        if (!list.isEmpty()) {
            this.f29142j = w0Var;
            for (int i11 = i10; i11 < list.size() + i10; i11++) {
                c cVar = list.get(i11 - i10);
                if (i11 > 0) {
                    c cVar2 = this.f29134b.get(i11 - 1);
                    cVar.a(cVar2.f29155d + cVar2.f29152a.P().t());
                } else {
                    cVar.a(0);
                }
                g(i11, cVar.f29152a.P().t());
                this.f29134b.add(i11, cVar);
                this.f29136d.put(cVar.f29153b, cVar);
                if (this.f29143k) {
                    x(cVar);
                    if (this.f29135c.isEmpty()) {
                        this.f29141i.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public l3.x h(a0.b bVar, z3.b bVar2, long j10) {
        Object objO = o(bVar.f30778a);
        a0.b bVarC = bVar.c(m(bVar.f30778a));
        c cVar = (c) a4.a.e(this.f29136d.get(objO));
        l(cVar);
        cVar.f29154c.add(bVarC);
        l3.u uVarJ = cVar.f29152a.j(bVarC, bVar2, j10);
        this.f29135c.put(uVarJ, cVar);
        k();
        return uVarJ;
    }

    public n3 i() {
        if (this.f29134b.isEmpty()) {
            return n3.f29295a;
        }
        int iT = 0;
        for (int i10 = 0; i10 < this.f29134b.size(); i10++) {
            c cVar = this.f29134b.get(i10);
            cVar.f29155d = iT;
            iT += cVar.f29152a.P().t();
        }
        return new w2(this.f29134b, this.f29142j);
    }

    public int q() {
        return this.f29134b.size();
    }

    public boolean s() {
        return this.f29143k;
    }

    public n3 v(int i10, int i11, int i12, l3.w0 w0Var) {
        a4.a.a(i10 >= 0 && i10 <= i11 && i11 <= q() && i12 >= 0);
        this.f29142j = w0Var;
        if (i10 == i11 || i10 == i12) {
            return i();
        }
        int iMin = Math.min(i10, i12);
        int iMax = Math.max(((i11 - i10) + i12) - 1, i11 - 1);
        int iT = this.f29134b.get(iMin).f29155d;
        a4.o0.v0(this.f29134b, i10, i11, i12);
        while (iMin <= iMax) {
            c cVar = this.f29134b.get(iMin);
            cVar.f29155d = iT;
            iT += cVar.f29152a.P().t();
            iMin++;
        }
        return i();
    }

    public void w(@Nullable z3.m0 m0Var) {
        a4.a.g(!this.f29143k);
        this.f29144l = m0Var;
        for (int i10 = 0; i10 < this.f29134b.size(); i10++) {
            c cVar = this.f29134b.get(i10);
            x(cVar);
            this.f29141i.add(cVar);
        }
        this.f29143k = true;
    }

    public void y() {
        for (b bVar : this.f29140h.values()) {
            try {
                bVar.f29149a.a(bVar.f29150b);
            } catch (RuntimeException e10) {
                a4.t.d("MediaSourceList", "Failed to release child source.", e10);
            }
            bVar.f29149a.g(bVar.f29151c);
            bVar.f29149a.f(bVar.f29151c);
        }
        this.f29140h.clear();
        this.f29141i.clear();
        this.f29143k = false;
    }

    public void z(l3.x xVar) {
        c cVar = (c) a4.a.e(this.f29135c.remove(xVar));
        cVar.f29152a.e(xVar);
        cVar.f29154c.remove(((l3.u) xVar).f30732a);
        if (!this.f29135c.isEmpty()) {
            k();
        }
        u(cVar);
    }
}
