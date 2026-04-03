package u0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import p1.a;

/* JADX INFO: compiled from: LockedResource.java */
/* JADX INFO: loaded from: classes2.dex */
final class u<Z> implements v<Z>, a.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pools.Pool<u<?>> f34415e = p1.a.d(20, new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p1.c f34416a = p1.c.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v<Z> f34417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f34418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f34419d;

    /* JADX INFO: compiled from: LockedResource.java */
    class a implements a.d<u<?>> {
        a() {
        }

        @Override // p1.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public u<?> a() {
            return new u<>();
        }
    }

    u() {
    }

    private void b(v<Z> vVar) {
        this.f34419d = false;
        this.f34418c = true;
        this.f34417b = vVar;
    }

    @NonNull
    static <Z> u<Z> d(v<Z> vVar) {
        u<Z> uVar = (u) o1.j.d(f34415e.acquire());
        uVar.b(vVar);
        return uVar;
    }

    private void e() {
        this.f34417b = null;
        f34415e.release(this);
    }

    @Override // u0.v
    @NonNull
    public Class<Z> a() {
        return this.f34417b.a();
    }

    @Override // p1.a.f
    @NonNull
    public p1.c c() {
        return this.f34416a;
    }

    synchronized void f() {
        this.f34416a.c();
        if (!this.f34418c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f34418c = false;
        if (this.f34419d) {
            recycle();
        }
    }

    @Override // u0.v
    @NonNull
    public Z get() {
        return this.f34417b.get();
    }

    @Override // u0.v
    public int getSize() {
        return this.f34417b.getSize();
    }

    @Override // u0.v
    public synchronized void recycle() {
        this.f34416a.c();
        this.f34419d = true;
        if (!this.f34418c) {
            this.f34417b.recycle();
            e();
        }
    }
}
