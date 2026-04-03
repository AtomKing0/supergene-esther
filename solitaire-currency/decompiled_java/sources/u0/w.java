package u0;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.List;
import s0.d;
import u0.f;
import y0.n;

/* JADX INFO: compiled from: ResourceCacheGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
class w implements f, d.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f.a f34420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<?> f34421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34423d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private r0.f f34424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<y0.n<File, ?>> f34425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f34426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile n.a<?> f34427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private File f34428i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private x f34429j;

    w(g<?> gVar, f.a aVar) {
        this.f34421b = gVar;
        this.f34420a = aVar;
    }

    private boolean a() {
        return this.f34426g < this.f34425f.size();
    }

    @Override // u0.f
    public boolean b() {
        List<r0.f> listC = this.f34421b.c();
        boolean z10 = false;
        if (listC.isEmpty()) {
            return false;
        }
        List<Class<?>> listM = this.f34421b.m();
        if (listM.isEmpty()) {
            if (File.class.equals(this.f34421b.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f34421b.i() + " to " + this.f34421b.q());
        }
        while (true) {
            if (this.f34425f != null && a()) {
                this.f34427h = null;
                while (!z10 && a()) {
                    List<y0.n<File, ?>> list = this.f34425f;
                    int i10 = this.f34426g;
                    this.f34426g = i10 + 1;
                    this.f34427h = list.get(i10).b(this.f34428i, this.f34421b.s(), this.f34421b.f(), this.f34421b.k());
                    if (this.f34427h != null && this.f34421b.t(this.f34427h.f36305c.a())) {
                        this.f34427h.f36305c.e(this.f34421b.l(), this);
                        z10 = true;
                    }
                }
                return z10;
            }
            int i11 = this.f34423d + 1;
            this.f34423d = i11;
            if (i11 >= listM.size()) {
                int i12 = this.f34422c + 1;
                this.f34422c = i12;
                if (i12 >= listC.size()) {
                    return false;
                }
                this.f34423d = 0;
            }
            r0.f fVar = listC.get(this.f34422c);
            Class<?> cls = listM.get(this.f34423d);
            this.f34429j = new x(this.f34421b.b(), fVar, this.f34421b.o(), this.f34421b.s(), this.f34421b.f(), this.f34421b.r(cls), cls, this.f34421b.k());
            File fileA = this.f34421b.d().a(this.f34429j);
            this.f34428i = fileA;
            if (fileA != null) {
                this.f34424e = fVar;
                this.f34425f = this.f34421b.j(fileA);
                this.f34426g = 0;
            }
        }
    }

    @Override // s0.d.a
    public void c(@NonNull Exception exc) {
        this.f34420a.a(this.f34429j, exc, this.f34427h.f36305c, r0.a.RESOURCE_DISK_CACHE);
    }

    @Override // u0.f
    public void cancel() {
        n.a<?> aVar = this.f34427h;
        if (aVar != null) {
            aVar.f36305c.cancel();
        }
    }

    @Override // s0.d.a
    public void f(Object obj) {
        this.f34420a.d(this.f34424e, obj, this.f34427h.f36305c, r0.a.RESOURCE_DISK_CACHE, this.f34429j);
    }
}
