package l3;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import k2.n3;
import l2.t1;
import l3.a0;
import l3.g0;
import o2.w;

/* JADX INFO: compiled from: BaseMediaSource.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<a0.c> f30451a = new ArrayList<>(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashSet<a0.c> f30452b = new HashSet<>(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g0.a f30453c = new g0.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final w.a f30454d = new w.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Looper f30455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private n3 f30456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private t1 f30457g;

    @Override // l3.a0
    public final void a(a0.c cVar) {
        this.f30451a.remove(cVar);
        if (!this.f30451a.isEmpty()) {
            i(cVar);
            return;
        }
        this.f30455e = null;
        this.f30456f = null;
        this.f30457g = null;
        this.f30452b.clear();
        u();
    }

    @Override // l3.a0
    public final void b(a0.c cVar) {
        a4.a.e(this.f30455e);
        boolean zIsEmpty = this.f30452b.isEmpty();
        this.f30452b.add(cVar);
        if (zIsEmpty) {
            p();
        }
    }

    @Override // l3.a0
    public final void c(a0.c cVar, @Nullable z3.m0 m0Var, t1 t1Var) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f30455e;
        a4.a.a(looper == null || looper == looperMyLooper);
        this.f30457g = t1Var;
        n3 n3Var = this.f30456f;
        this.f30451a.add(cVar);
        if (this.f30455e == null) {
            this.f30455e = looperMyLooper;
            this.f30452b.add(cVar);
            s(m0Var);
        } else if (n3Var != null) {
            b(cVar);
            cVar.a(this, n3Var);
        }
    }

    @Override // l3.a0
    public final void d(Handler handler, o2.w wVar) {
        a4.a.e(handler);
        a4.a.e(wVar);
        this.f30454d.g(handler, wVar);
    }

    @Override // l3.a0
    public final void f(o2.w wVar) {
        this.f30454d.t(wVar);
    }

    @Override // l3.a0
    public final void g(g0 g0Var) {
        this.f30453c.w(g0Var);
    }

    @Override // l3.a0
    public /* synthetic */ n3 getInitialTimeline() {
        return z.a(this);
    }

    @Override // l3.a0
    public final void h(Handler handler, g0 g0Var) {
        a4.a.e(handler);
        a4.a.e(g0Var);
        this.f30453c.f(handler, g0Var);
    }

    @Override // l3.a0
    public final void i(a0.c cVar) {
        boolean z10 = !this.f30452b.isEmpty();
        this.f30452b.remove(cVar);
        if (z10 && this.f30452b.isEmpty()) {
            o();
        }
    }

    @Override // l3.a0
    public /* synthetic */ boolean isSingleWindow() {
        return z.b(this);
    }

    protected final w.a k(int i10, @Nullable a0.b bVar) {
        return this.f30454d.u(i10, bVar);
    }

    protected final w.a l(@Nullable a0.b bVar) {
        return this.f30454d.u(0, bVar);
    }

    protected final g0.a m(int i10, @Nullable a0.b bVar, long j10) {
        return this.f30453c.x(i10, bVar, j10);
    }

    protected final g0.a n(@Nullable a0.b bVar) {
        return this.f30453c.x(0, bVar, 0L);
    }

    protected final t1 q() {
        return (t1) a4.a.i(this.f30457g);
    }

    protected final boolean r() {
        return !this.f30452b.isEmpty();
    }

    protected abstract void s(@Nullable z3.m0 m0Var);

    protected final void t(n3 n3Var) {
        this.f30456f = n3Var;
        Iterator<a0.c> it = this.f30451a.iterator();
        while (it.hasNext()) {
            it.next().a(this, n3Var);
        }
    }

    protected abstract void u();

    protected void o() {
    }

    protected void p() {
    }
}
