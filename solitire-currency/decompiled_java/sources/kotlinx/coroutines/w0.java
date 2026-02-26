package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes5.dex */
class w0<T> extends a<T> implements v0<T> {
    public w0(@NotNull z8.g gVar, boolean z10) {
        super(gVar, true, z10);
    }

    static /* synthetic */ <T> Object U0(w0<T> w0Var, z8.d<? super T> dVar) throws Throwable {
        Object objD = w0Var.D(dVar);
        a9.d.e();
        return objD;
    }

    @Override // kotlinx.coroutines.v0
    @Nullable
    public Object i0(@NotNull z8.d<? super T> dVar) {
        return U0(this, dVar);
    }

    @Override // kotlinx.coroutines.v0
    public T n() {
        return (T) X();
    }
}
