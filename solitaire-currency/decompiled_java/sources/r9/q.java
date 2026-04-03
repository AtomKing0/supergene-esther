package r9;

import kotlinx.coroutines.m0;
import org.jetbrains.annotations.NotNull;
import r9.u;
import v8.k0;

/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes5.dex */
final class q<E> extends e<E> implements r<E> {
    public q(@NotNull z8.g gVar, @NotNull d<E> dVar) {
        super(gVar, dVar, true, true);
    }

    @Override // kotlinx.coroutines.a
    protected void R0(@NotNull Throwable th, boolean z10) {
        if (V0().d(th) || z10) {
            return;
        }
        m0.a(getContext(), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public void S0(@NotNull k0 k0Var) {
        u.a.a(V0(), null, 1, null);
    }

    @Override // r9.r
    public /* bridge */ /* synthetic */ u a() {
        return U0();
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.j2, kotlinx.coroutines.b2
    public boolean isActive() {
        return super.isActive();
    }
}
