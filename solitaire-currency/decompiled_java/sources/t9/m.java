package t9;

import org.jetbrains.annotations.NotNull;
import u9.d0;

/* JADX INFO: compiled from: FlowCoroutine.kt */
/* JADX INFO: loaded from: classes5.dex */
final class m<T> extends d0<T> {
    public m(@NotNull z8.g gVar, @NotNull z8.d<? super T> dVar) {
        super(gVar, dVar);
    }

    @Override // kotlinx.coroutines.j2
    public boolean N(@NotNull Throwable th) {
        if (th instanceof j) {
            return true;
        }
        return G(th);
    }
}
