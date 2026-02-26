package k1;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import k1.d;

/* JADX INFO: compiled from: ThumbnailRequestCoordinator.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final d f28958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f28959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile c f28960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile c f28961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private d.a f28962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private d.a f28963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("requestLock")
    private boolean f28964g;

    public i(Object obj, @Nullable d dVar) {
        d.a aVar = d.a.CLEARED;
        this.f28962e = aVar;
        this.f28963f = aVar;
        this.f28959b = obj;
        this.f28958a = dVar;
    }

    private boolean k() {
        boolean z10;
        synchronized (this.f28959b) {
            d.a aVar = this.f28962e;
            d.a aVar2 = d.a.SUCCESS;
            z10 = aVar == aVar2 || this.f28963f == aVar2;
        }
        return z10;
    }

    @GuardedBy("requestLock")
    private boolean l() {
        d dVar = this.f28958a;
        return dVar == null || dVar.e(this);
    }

    @GuardedBy("requestLock")
    private boolean m() {
        d dVar = this.f28958a;
        return dVar == null || dVar.i(this);
    }

    @GuardedBy("requestLock")
    private boolean n() {
        d dVar = this.f28958a;
        return dVar == null || dVar.c(this);
    }

    @GuardedBy("requestLock")
    private boolean o() {
        d dVar = this.f28958a;
        return dVar != null && dVar.b();
    }

    @Override // k1.d
    public void a(c cVar) {
        synchronized (this.f28959b) {
            if (!cVar.equals(this.f28960c)) {
                this.f28963f = d.a.FAILED;
                return;
            }
            this.f28962e = d.a.FAILED;
            d dVar = this.f28958a;
            if (dVar != null) {
                dVar.a(this);
            }
        }
    }

    @Override // k1.d
    public boolean b() {
        boolean z10;
        synchronized (this.f28959b) {
            z10 = o() || k();
        }
        return z10;
    }

    @Override // k1.d
    public boolean c(c cVar) {
        boolean z10;
        synchronized (this.f28959b) {
            z10 = n() && (cVar.equals(this.f28960c) || this.f28962e != d.a.SUCCESS);
        }
        return z10;
    }

    @Override // k1.c
    public void clear() {
        synchronized (this.f28959b) {
            this.f28964g = false;
            d.a aVar = d.a.CLEARED;
            this.f28962e = aVar;
            this.f28963f = aVar;
            this.f28961d.clear();
            this.f28960c.clear();
        }
    }

    @Override // k1.c
    public boolean d() {
        boolean z10;
        synchronized (this.f28959b) {
            z10 = this.f28962e == d.a.CLEARED;
        }
        return z10;
    }

    @Override // k1.d
    public boolean e(c cVar) {
        boolean z10;
        synchronized (this.f28959b) {
            z10 = l() && cVar.equals(this.f28960c) && this.f28962e != d.a.PAUSED;
        }
        return z10;
    }

    @Override // k1.d
    public void f(c cVar) {
        synchronized (this.f28959b) {
            if (cVar.equals(this.f28961d)) {
                this.f28963f = d.a.SUCCESS;
                return;
            }
            this.f28962e = d.a.SUCCESS;
            d dVar = this.f28958a;
            if (dVar != null) {
                dVar.f(this);
            }
            if (!this.f28963f.a()) {
                this.f28961d.clear();
            }
        }
    }

    @Override // k1.c
    public boolean g(c cVar) {
        if (!(cVar instanceof i)) {
            return false;
        }
        i iVar = (i) cVar;
        if (this.f28960c == null) {
            if (iVar.f28960c != null) {
                return false;
            }
        } else if (!this.f28960c.g(iVar.f28960c)) {
            return false;
        }
        if (this.f28961d == null) {
            if (iVar.f28961d != null) {
                return false;
            }
        } else if (!this.f28961d.g(iVar.f28961d)) {
            return false;
        }
        return true;
    }

    @Override // k1.c
    public boolean h() {
        boolean z10;
        synchronized (this.f28959b) {
            z10 = this.f28962e == d.a.SUCCESS;
        }
        return z10;
    }

    @Override // k1.d
    public boolean i(c cVar) {
        boolean z10;
        synchronized (this.f28959b) {
            z10 = m() && cVar.equals(this.f28960c) && !k();
        }
        return z10;
    }

    @Override // k1.c
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f28959b) {
            z10 = this.f28962e == d.a.RUNNING;
        }
        return z10;
    }

    @Override // k1.c
    public void j() {
        synchronized (this.f28959b) {
            this.f28964g = true;
            try {
                if (this.f28962e != d.a.SUCCESS) {
                    d.a aVar = this.f28963f;
                    d.a aVar2 = d.a.RUNNING;
                    if (aVar != aVar2) {
                        this.f28963f = aVar2;
                        this.f28961d.j();
                    }
                }
                if (this.f28964g) {
                    d.a aVar3 = this.f28962e;
                    d.a aVar4 = d.a.RUNNING;
                    if (aVar3 != aVar4) {
                        this.f28962e = aVar4;
                        this.f28960c.j();
                    }
                }
            } finally {
                this.f28964g = false;
            }
        }
    }

    public void p(c cVar, c cVar2) {
        this.f28960c = cVar;
        this.f28961d = cVar2;
    }

    @Override // k1.c
    public void pause() {
        synchronized (this.f28959b) {
            if (!this.f28963f.a()) {
                this.f28963f = d.a.PAUSED;
                this.f28961d.pause();
            }
            if (!this.f28962e.a()) {
                this.f28962e = d.a.PAUSED;
                this.f28960c.pause();
            }
        }
    }
}
