package l3;

import androidx.annotation.Nullable;
import k2.n3;
import k2.w1;
import l3.a0;

/* JADX INFO: compiled from: WrappingMediaSource.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g1 extends f<Void> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Void f30542l = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final a0 f30543k;

    protected g1(a0 a0Var) {
        this.f30543k = a0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l3.f
    @Nullable
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final a0.b w(Void r12, a0.b bVar) {
        return D(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l3.f
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public final long x(Void r12, long j10) {
        return E(j10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l3.f
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final int y(Void r12, int i10) {
        return G(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l3.f
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final void z(Void r12, a0 a0Var, n3 n3Var) {
        J(n3Var);
    }

    protected abstract void J(n3 n3Var);

    protected final void K() {
        B(f30542l, this.f30543k);
    }

    protected void L() {
        K();
    }

    @Override // l3.a, l3.a0
    @Nullable
    public n3 getInitialTimeline() {
        return this.f30543k.getInitialTimeline();
    }

    @Override // l3.a0
    public w1 getMediaItem() {
        return this.f30543k.getMediaItem();
    }

    @Override // l3.a, l3.a0
    public boolean isSingleWindow() {
        return this.f30543k.isSingleWindow();
    }

    @Override // l3.f, l3.a
    protected final void s(@Nullable z3.m0 m0Var) {
        super.s(m0Var);
        L();
    }

    @Nullable
    protected a0.b D(a0.b bVar) {
        return bVar;
    }

    protected long E(long j10) {
        return j10;
    }

    protected int G(int i10) {
        return i10;
    }
}
