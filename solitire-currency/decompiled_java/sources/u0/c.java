package u0;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.List;
import s0.d;
import u0.f;
import y0.n;

/* JADX INFO: compiled from: DataCacheGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements f, d.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<r0.f> f34236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<?> f34237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f.a f34238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private r0.f f34240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<y0.n<File, ?>> f34241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f34242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile n.a<?> f34243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private File f34244i;

    c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean a() {
        return this.f34242g < this.f34241f.size();
    }

    @Override // u0.f
    public boolean b() {
        while (true) {
            boolean z10 = false;
            if (this.f34241f != null && a()) {
                this.f34243h = null;
                while (!z10 && a()) {
                    List<y0.n<File, ?>> list = this.f34241f;
                    int i10 = this.f34242g;
                    this.f34242g = i10 + 1;
                    this.f34243h = list.get(i10).b(this.f34244i, this.f34237b.s(), this.f34237b.f(), this.f34237b.k());
                    if (this.f34243h != null && this.f34237b.t(this.f34243h.f36305c.a())) {
                        this.f34243h.f36305c.e(this.f34237b.l(), this);
                        z10 = true;
                    }
                }
                return z10;
            }
            int i11 = this.f34239d + 1;
            this.f34239d = i11;
            if (i11 >= this.f34236a.size()) {
                return false;
            }
            r0.f fVar = this.f34236a.get(this.f34239d);
            File fileA = this.f34237b.d().a(new d(fVar, this.f34237b.o()));
            this.f34244i = fileA;
            if (fileA != null) {
                this.f34240e = fVar;
                this.f34241f = this.f34237b.j(fileA);
                this.f34242g = 0;
            }
        }
    }

    @Override // s0.d.a
    public void c(@NonNull Exception exc) {
        this.f34238c.a(this.f34240e, exc, this.f34243h.f36305c, r0.a.DATA_DISK_CACHE);
    }

    @Override // u0.f
    public void cancel() {
        n.a<?> aVar = this.f34243h;
        if (aVar != null) {
            aVar.f36305c.cancel();
        }
    }

    @Override // s0.d.a
    public void f(Object obj) {
        this.f34238c.d(this.f34240e, obj, this.f34243h.f36305c, r0.a.DATA_DISK_CACHE, this.f34240e);
    }

    c(List<r0.f> list, g<?> gVar, f.a aVar) {
        this.f34239d = -1;
        this.f34236a = list;
        this.f34237b = gVar;
        this.f34238c = aVar;
    }
}
