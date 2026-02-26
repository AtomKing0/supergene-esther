package u0;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: EngineResource.java */
/* JADX INFO: loaded from: classes2.dex */
class p<Z> implements v<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f34393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f34394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v<Z> f34395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f34396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final r0.f f34397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f34398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f34399g;

    /* JADX INFO: compiled from: EngineResource.java */
    interface a {
        void b(r0.f fVar, p<?> pVar);
    }

    p(v<Z> vVar, boolean z10, boolean z11, r0.f fVar, a aVar) {
        this.f34395c = (v) o1.j.d(vVar);
        this.f34393a = z10;
        this.f34394b = z11;
        this.f34397e = fVar;
        this.f34396d = (a) o1.j.d(aVar);
    }

    @Override // u0.v
    @NonNull
    public Class<Z> a() {
        return this.f34395c.a();
    }

    synchronized void b() {
        if (this.f34399g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f34398f++;
    }

    v<Z> c() {
        return this.f34395c;
    }

    boolean d() {
        return this.f34393a;
    }

    void e() {
        boolean z10;
        synchronized (this) {
            int i10 = this.f34398f;
            if (i10 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z10 = true;
            int i11 = i10 - 1;
            this.f34398f = i11;
            if (i11 != 0) {
                z10 = false;
            }
        }
        if (z10) {
            this.f34396d.b(this.f34397e, this);
        }
    }

    @Override // u0.v
    @NonNull
    public Z get() {
        return this.f34395c.get();
    }

    @Override // u0.v
    public int getSize() {
        return this.f34395c.getSize();
    }

    @Override // u0.v
    public synchronized void recycle() {
        if (this.f34398f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f34399g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f34399g = true;
        if (this.f34394b) {
            this.f34395c.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f34393a + ", listener=" + this.f34396d + ", key=" + this.f34397e + ", acquired=" + this.f34398f + ", isRecycled=" + this.f34399g + ", resource=" + this.f34395c + '}';
    }
}
