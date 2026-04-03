package x3;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import k2.c3;
import k2.n3;
import l3.a0;
import l3.e1;

/* JADX INFO: compiled from: TrackSelector.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private a f35924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private z3.e f35925b;

    /* JADX INFO: compiled from: TrackSelector.java */
    public interface a {
        void onTrackSelectionsInvalidated();
    }

    protected final z3.e a() {
        return (z3.e) a4.a.i(this.f35925b);
    }

    public z b() {
        return z.A;
    }

    @CallSuper
    public void c(a aVar, z3.e eVar) {
        this.f35924a = aVar;
        this.f35925b = eVar;
    }

    protected final void d() {
        a aVar = this.f35924a;
        if (aVar != null) {
            aVar.onTrackSelectionsInvalidated();
        }
    }

    public boolean e() {
        return false;
    }

    public abstract void f(@Nullable Object obj);

    @CallSuper
    public void g() {
        this.f35924a = null;
        this.f35925b = null;
    }

    public abstract c0 h(c3[] c3VarArr, e1 e1Var, a0.b bVar, n3 n3Var) throws k2.q;

    public void i(m2.e eVar) {
    }

    public void j(z zVar) {
    }
}
