package k1;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import k1.d;

/* JADX INFO: compiled from: ErrorRequestCoordinator.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f28912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final d f28913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile c f28914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile c f28915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private d.a f28916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private d.a f28917f;

    public b(Object obj, @Nullable d dVar) {
        d.a aVar = d.a.CLEARED;
        this.f28916e = aVar;
        this.f28917f = aVar;
        this.f28912a = obj;
        this.f28913b = dVar;
    }

    @GuardedBy("requestLock")
    private boolean k(c cVar) {
        return cVar.equals(this.f28914c) || (this.f28916e == d.a.FAILED && cVar.equals(this.f28915d));
    }

    @GuardedBy("requestLock")
    private boolean l() {
        d dVar = this.f28913b;
        return dVar == null || dVar.e(this);
    }

    @GuardedBy("requestLock")
    private boolean m() {
        d dVar = this.f28913b;
        return dVar == null || dVar.i(this);
    }

    @GuardedBy("requestLock")
    private boolean n() {
        d dVar = this.f28913b;
        return dVar == null || dVar.c(this);
    }

    @GuardedBy("requestLock")
    private boolean o() {
        d dVar = this.f28913b;
        return dVar != null && dVar.b();
    }

    @Override // k1.d
    public void a(c cVar) {
        synchronized (this.f28912a) {
            if (cVar.equals(this.f28915d)) {
                this.f28917f = d.a.FAILED;
                d dVar = this.f28913b;
                if (dVar != null) {
                    dVar.a(this);
                }
                return;
            }
            this.f28916e = d.a.FAILED;
            d.a aVar = this.f28917f;
            d.a aVar2 = d.a.RUNNING;
            if (aVar != aVar2) {
                this.f28917f = aVar2;
                this.f28915d.j();
            }
        }
    }

    @Override // k1.d
    public boolean b() {
        boolean z10;
        synchronized (this.f28912a) {
            z10 = o() || h();
        }
        return z10;
    }

    @Override // k1.d
    public boolean c(c cVar) {
        boolean z10;
        synchronized (this.f28912a) {
            z10 = n() && k(cVar);
        }
        return z10;
    }

    @Override // k1.c
    public void clear() {
        synchronized (this.f28912a) {
            d.a aVar = d.a.CLEARED;
            this.f28916e = aVar;
            this.f28914c.clear();
            if (this.f28917f != aVar) {
                this.f28917f = aVar;
                this.f28915d.clear();
            }
        }
    }

    @Override // k1.c
    public boolean d() {
        boolean z10;
        synchronized (this.f28912a) {
            d.a aVar = this.f28916e;
            d.a aVar2 = d.a.CLEARED;
            z10 = aVar == aVar2 && this.f28917f == aVar2;
        }
        return z10;
    }

    @Override // k1.d
    public boolean e(c cVar) {
        boolean z10;
        synchronized (this.f28912a) {
            z10 = l() && k(cVar);
        }
        return z10;
    }

    @Override // k1.d
    public void f(c cVar) {
        synchronized (this.f28912a) {
            if (cVar.equals(this.f28914c)) {
                this.f28916e = d.a.SUCCESS;
            } else if (cVar.equals(this.f28915d)) {
                this.f28917f = d.a.SUCCESS;
            }
            d dVar = this.f28913b;
            if (dVar != null) {
                dVar.f(this);
            }
        }
    }

    @Override // k1.c
    public boolean g(c cVar) {
        if (!(cVar instanceof b)) {
            return false;
        }
        b bVar = (b) cVar;
        return this.f28914c.g(bVar.f28914c) && this.f28915d.g(bVar.f28915d);
    }

    @Override // k1.c
    public boolean h() {
        boolean z10;
        synchronized (this.f28912a) {
            d.a aVar = this.f28916e;
            d.a aVar2 = d.a.SUCCESS;
            z10 = aVar == aVar2 || this.f28917f == aVar2;
        }
        return z10;
    }

    @Override // k1.d
    public boolean i(c cVar) {
        boolean z10;
        synchronized (this.f28912a) {
            z10 = m() && k(cVar);
        }
        return z10;
    }

    @Override // k1.c
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f28912a) {
            d.a aVar = this.f28916e;
            d.a aVar2 = d.a.RUNNING;
            z10 = aVar == aVar2 || this.f28917f == aVar2;
        }
        return z10;
    }

    @Override // k1.c
    public void j() {
        synchronized (this.f28912a) {
            d.a aVar = this.f28916e;
            d.a aVar2 = d.a.RUNNING;
            if (aVar != aVar2) {
                this.f28916e = aVar2;
                this.f28914c.j();
            }
        }
    }

    public void p(c cVar, c cVar2) {
        this.f28914c = cVar;
        this.f28915d = cVar2;
    }

    @Override // k1.c
    public void pause() {
        synchronized (this.f28912a) {
            d.a aVar = this.f28916e;
            d.a aVar2 = d.a.RUNNING;
            if (aVar == aVar2) {
                this.f28916e = d.a.PAUSED;
                this.f28914c.pause();
            }
            if (this.f28917f == aVar2) {
                this.f28917f = d.a.PAUSED;
                this.f28915d.pause();
            }
        }
    }
}
