package u0;

import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;
import s0.d;
import u0.f;
import y0.n;

/* JADX INFO: compiled from: SourceGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
class z implements f, d.a<Object>, f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g<?> f34441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f.a f34442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f34444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f34445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile n.a<?> f34446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f34447g;

    z(g<?> gVar, f.a aVar) {
        this.f34441a = gVar;
        this.f34442b = aVar;
    }

    private void g(Object obj) {
        long jB = o1.f.b();
        try {
            r0.d<X> dVarP = this.f34441a.p(obj);
            e eVar = new e(dVarP, obj, this.f34441a.k());
            this.f34447g = new d(this.f34446f.f36303a, this.f34441a.o());
            this.f34441a.d().b(this.f34447g, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f34447g + ", data: " + obj + ", encoder: " + dVarP + ", duration: " + o1.f.a(jB));
            }
            this.f34446f.f36305c.b();
            this.f34444d = new c(Collections.singletonList(this.f34446f.f36303a), this.f34441a, this);
        } catch (Throwable th) {
            this.f34446f.f36305c.b();
            throw th;
        }
    }

    private boolean h() {
        return this.f34443c < this.f34441a.g().size();
    }

    @Override // u0.f.a
    public void a(r0.f fVar, Exception exc, s0.d<?> dVar, r0.a aVar) {
        this.f34442b.a(fVar, exc, dVar, this.f34446f.f36305c.d());
    }

    @Override // u0.f
    public boolean b() {
        Object obj = this.f34445e;
        if (obj != null) {
            this.f34445e = null;
            g(obj);
        }
        c cVar = this.f34444d;
        if (cVar != null && cVar.b()) {
            return true;
        }
        this.f34444d = null;
        this.f34446f = null;
        boolean z10 = false;
        while (!z10 && h()) {
            List<n.a<?>> listG = this.f34441a.g();
            int i10 = this.f34443c;
            this.f34443c = i10 + 1;
            this.f34446f = listG.get(i10);
            if (this.f34446f != null && (this.f34441a.e().c(this.f34446f.f36305c.d()) || this.f34441a.t(this.f34446f.f36305c.a()))) {
                this.f34446f.f36305c.e(this.f34441a.l(), this);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // s0.d.a
    public void c(@NonNull Exception exc) {
        this.f34442b.a(this.f34447g, exc, this.f34446f.f36305c, this.f34446f.f36305c.d());
    }

    @Override // u0.f
    public void cancel() {
        n.a<?> aVar = this.f34446f;
        if (aVar != null) {
            aVar.f36305c.cancel();
        }
    }

    @Override // u0.f.a
    public void d(r0.f fVar, Object obj, s0.d<?> dVar, r0.a aVar, r0.f fVar2) {
        this.f34442b.d(fVar, obj, dVar, this.f34446f.f36305c.d(), fVar);
    }

    @Override // u0.f.a
    public void e() {
        throw new UnsupportedOperationException();
    }

    @Override // s0.d.a
    public void f(Object obj) {
        j jVarE = this.f34441a.e();
        if (obj == null || !jVarE.c(this.f34446f.f36305c.d())) {
            this.f34442b.d(this.f34446f.f36303a, obj, this.f34446f.f36305c, this.f34446f.f36305c.d(), this.f34447g);
        } else {
            this.f34445e = obj;
            this.f34442b.e();
        }
    }
}
