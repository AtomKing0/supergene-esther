package l3;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import k2.n3;
import l3.a0;
import l3.g0;
import o2.w;

/* JADX INFO: compiled from: CompositeMediaSource.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f<T> extends l3.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashMap<T, b<T>> f30520h = new HashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Handler f30521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private z3.m0 f30522j;

    /* JADX INFO: compiled from: CompositeMediaSource.java */
    private final class a implements g0, o2.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f30523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private g0.a f30524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private w.a f30525c;

        public a(T t10) {
            this.f30524b = f.this.n(null);
            this.f30525c = f.this.l(null);
            this.f30523a = t10;
        }

        private boolean a(int i10, @Nullable a0.b bVar) {
            a0.b bVarW;
            if (bVar != null) {
                bVarW = f.this.w(this.f30523a, bVar);
                if (bVarW == null) {
                    return false;
                }
            } else {
                bVarW = null;
            }
            int iY = f.this.y(this.f30523a, i10);
            g0.a aVar = this.f30524b;
            if (aVar.f30536a != iY || !a4.o0.c(aVar.f30537b, bVarW)) {
                this.f30524b = f.this.m(iY, bVarW, 0L);
            }
            w.a aVar2 = this.f30525c;
            if (aVar2.f31944a == iY && a4.o0.c(aVar2.f31945b, bVarW)) {
                return true;
            }
            this.f30525c = f.this.k(iY, bVarW);
            return true;
        }

        private w f(w wVar) {
            long jX = f.this.x(this.f30523a, wVar.f30758f);
            long jX2 = f.this.x(this.f30523a, wVar.f30759g);
            return (jX == wVar.f30758f && jX2 == wVar.f30759g) ? wVar : new w(wVar.f30753a, wVar.f30754b, wVar.f30755c, wVar.f30756d, wVar.f30757e, jX, jX2);
        }

        @Override // o2.w
        public void A(int i10, @Nullable a0.b bVar) {
            if (a(i10, bVar)) {
                this.f30525c.m();
            }
        }

        @Override // o2.w
        public void C(int i10, @Nullable a0.b bVar, int i11) {
            if (a(i10, bVar)) {
                this.f30525c.k(i11);
            }
        }

        @Override // l3.g0
        public void J(int i10, @Nullable a0.b bVar, t tVar, w wVar) {
            if (a(i10, bVar)) {
                this.f30524b.p(tVar, f(wVar));
            }
        }

        @Override // l3.g0
        public void K(int i10, @Nullable a0.b bVar, w wVar) {
            if (a(i10, bVar)) {
                this.f30524b.i(f(wVar));
            }
        }

        @Override // l3.g0
        public void k(int i10, @Nullable a0.b bVar, t tVar, w wVar) {
            if (a(i10, bVar)) {
                this.f30524b.v(tVar, f(wVar));
            }
        }

        @Override // l3.g0
        public void n(int i10, @Nullable a0.b bVar, t tVar, w wVar) {
            if (a(i10, bVar)) {
                this.f30524b.r(tVar, f(wVar));
            }
        }

        @Override // l3.g0
        public void o(int i10, @Nullable a0.b bVar, t tVar, w wVar, IOException iOException, boolean z10) {
            if (a(i10, bVar)) {
                this.f30524b.t(tVar, f(wVar), iOException, z10);
            }
        }

        @Override // o2.w
        public void p(int i10, @Nullable a0.b bVar) {
            if (a(i10, bVar)) {
                this.f30525c.i();
            }
        }

        @Override // o2.w
        public /* synthetic */ void q(int i10, a0.b bVar) {
            o2.p.a(this, i10, bVar);
        }

        @Override // o2.w
        public void s(int i10, @Nullable a0.b bVar) {
            if (a(i10, bVar)) {
                this.f30525c.j();
            }
        }

        @Override // o2.w
        public void v(int i10, @Nullable a0.b bVar) {
            if (a(i10, bVar)) {
                this.f30525c.h();
            }
        }

        @Override // o2.w
        public void w(int i10, @Nullable a0.b bVar, Exception exc) {
            if (a(i10, bVar)) {
                this.f30525c.l(exc);
            }
        }
    }

    /* JADX INFO: compiled from: CompositeMediaSource.java */
    private static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0 f30527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a0.c f30528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f<T>.a f30529c;

        public b(a0 a0Var, a0.c cVar, f<T>.a aVar) {
            this.f30527a = a0Var;
            this.f30528b = cVar;
            this.f30529c = aVar;
        }
    }

    protected f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public abstract void z(T t10, a0 a0Var, n3 n3Var);

    protected final void B(final T t10, a0 a0Var) {
        a4.a.a(!this.f30520h.containsKey(t10));
        a0.c cVar = new a0.c() { // from class: l3.e
            @Override // l3.a0.c
            public final void a(a0 a0Var2, n3 n3Var) {
                this.f30509a.z(t10, a0Var2, n3Var);
            }
        };
        a aVar = new a(t10);
        this.f30520h.put(t10, new b<>(a0Var, cVar, aVar));
        a0Var.h((Handler) a4.a.e(this.f30521i), aVar);
        a0Var.d((Handler) a4.a.e(this.f30521i), aVar);
        a0Var.c(cVar, this.f30522j, q());
        if (r()) {
            return;
        }
        a0Var.i(cVar);
    }

    @Override // l3.a0
    @CallSuper
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Iterator<b<T>> it = this.f30520h.values().iterator();
        while (it.hasNext()) {
            it.next().f30527a.maybeThrowSourceInfoRefreshError();
        }
    }

    @Override // l3.a
    @CallSuper
    protected void o() {
        for (b<T> bVar : this.f30520h.values()) {
            bVar.f30527a.i(bVar.f30528b);
        }
    }

    @Override // l3.a
    @CallSuper
    protected void p() {
        for (b<T> bVar : this.f30520h.values()) {
            bVar.f30527a.b(bVar.f30528b);
        }
    }

    @Override // l3.a
    @CallSuper
    protected void s(@Nullable z3.m0 m0Var) {
        this.f30522j = m0Var;
        this.f30521i = a4.o0.u();
    }

    @Override // l3.a
    @CallSuper
    protected void u() {
        for (b<T> bVar : this.f30520h.values()) {
            bVar.f30527a.a(bVar.f30528b);
            bVar.f30527a.g(bVar.f30529c);
            bVar.f30527a.f(bVar.f30529c);
        }
        this.f30520h.clear();
    }

    @Nullable
    protected abstract a0.b w(T t10, a0.b bVar);

    protected long x(T t10, long j10) {
        return j10;
    }

    protected int y(T t10, int i10) {
        return i10;
    }
}
