package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompletableDeferred.kt */
/* JADX INFO: loaded from: classes5.dex */
final class y<T> extends j2 implements x<T> {
    public y(@Nullable b2 b2Var) {
        super(true);
        k0(b2Var);
    }

    @Override // kotlinx.coroutines.x
    public boolean O(T t10) {
        return q0(t10);
    }

    @Override // kotlinx.coroutines.j2
    public boolean b0() {
        return true;
    }

    @Override // kotlinx.coroutines.x
    public boolean c(@NotNull Throwable th) {
        return q0(new c0(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.v0
    @Nullable
    public Object i0(@NotNull z8.d<? super T> dVar) throws Throwable {
        Object objD = D(dVar);
        a9.d.e();
        return objD;
    }

    @Override // kotlinx.coroutines.v0
    public T n() {
        return (T) X();
    }
}
