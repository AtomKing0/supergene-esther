package u0;

import com.bumptech.glide.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u0.h;
import y0.n;

/* JADX INFO: compiled from: DecodeHelper.java */
/* JADX INFO: loaded from: classes2.dex */
final class g<Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<n.a<?>> f34250a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<r0.f> f34251b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.d f34252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f34253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f34254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f34255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Class<?> f34256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h.e f34257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private r0.h f34258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<Class<?>, r0.l<?>> f34259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Class<Transcode> f34260k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f34261l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f34262m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private r0.f f34263n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.bumptech.glide.f f34264o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private j f34265p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f34266q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f34267r;

    g() {
    }

    void a() {
        this.f34252c = null;
        this.f34253d = null;
        this.f34263n = null;
        this.f34256g = null;
        this.f34260k = null;
        this.f34258i = null;
        this.f34264o = null;
        this.f34259j = null;
        this.f34265p = null;
        this.f34250a.clear();
        this.f34261l = false;
        this.f34251b.clear();
        this.f34262m = false;
    }

    v0.b b() {
        return this.f34252c.b();
    }

    List<r0.f> c() {
        if (!this.f34262m) {
            this.f34262m = true;
            this.f34251b.clear();
            List<n.a<?>> listG = g();
            int size = listG.size();
            for (int i10 = 0; i10 < size; i10++) {
                n.a<?> aVar = listG.get(i10);
                if (!this.f34251b.contains(aVar.f36303a)) {
                    this.f34251b.add(aVar.f36303a);
                }
                for (int i11 = 0; i11 < aVar.f36304b.size(); i11++) {
                    if (!this.f34251b.contains(aVar.f36304b.get(i11))) {
                        this.f34251b.add(aVar.f36304b.get(i11));
                    }
                }
            }
        }
        return this.f34251b;
    }

    w0.a d() {
        return this.f34257h.a();
    }

    j e() {
        return this.f34265p;
    }

    int f() {
        return this.f34255f;
    }

    List<n.a<?>> g() {
        if (!this.f34261l) {
            this.f34261l = true;
            this.f34250a.clear();
            List listI = this.f34252c.h().i(this.f34253d);
            int size = listI.size();
            for (int i10 = 0; i10 < size; i10++) {
                n.a<?> aVarB = ((y0.n) listI.get(i10)).b(this.f34253d, this.f34254e, this.f34255f, this.f34258i);
                if (aVarB != null) {
                    this.f34250a.add(aVarB);
                }
            }
        }
        return this.f34250a;
    }

    <Data> t<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f34252c.h().h(cls, this.f34256g, this.f34260k);
    }

    Class<?> i() {
        return this.f34253d.getClass();
    }

    List<y0.n<File, ?>> j(File file) throws h.c {
        return this.f34252c.h().i(file);
    }

    r0.h k() {
        return this.f34258i;
    }

    com.bumptech.glide.f l() {
        return this.f34264o;
    }

    List<Class<?>> m() {
        return this.f34252c.h().j(this.f34253d.getClass(), this.f34256g, this.f34260k);
    }

    <Z> r0.k<Z> n(v<Z> vVar) {
        return this.f34252c.h().k(vVar);
    }

    r0.f o() {
        return this.f34263n;
    }

    <X> r0.d<X> p(X x10) throws h.e {
        return this.f34252c.h().m(x10);
    }

    Class<?> q() {
        return this.f34260k;
    }

    <Z> r0.l<Z> r(Class<Z> cls) {
        r0.l<Z> lVar = (r0.l) this.f34259j.get(cls);
        if (lVar == null) {
            Iterator<Map.Entry<Class<?>, r0.l<?>>> it = this.f34259j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, r0.l<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    lVar = (r0.l) next.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            return lVar;
        }
        if (!this.f34259j.isEmpty() || !this.f34266q) {
            return a1.k.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    int s() {
        return this.f34254e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void u(com.bumptech.glide.d dVar, Object obj, r0.f fVar, int i10, int i11, j jVar, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, r0.h hVar, Map<Class<?>, r0.l<?>> map, boolean z10, boolean z11, h.e eVar) {
        this.f34252c = dVar;
        this.f34253d = obj;
        this.f34263n = fVar;
        this.f34254e = i10;
        this.f34255f = i11;
        this.f34265p = jVar;
        this.f34256g = cls;
        this.f34257h = eVar;
        this.f34260k = cls2;
        this.f34264o = fVar2;
        this.f34258i = hVar;
        this.f34259j = map;
        this.f34266q = z10;
        this.f34267r = z11;
    }

    boolean v(v<?> vVar) {
        return this.f34252c.h().n(vVar);
    }

    boolean w() {
        return this.f34267r;
    }

    boolean x(r0.f fVar) {
        List<n.a<?>> listG = g();
        int size = listG.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (listG.get(i10).f36303a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
