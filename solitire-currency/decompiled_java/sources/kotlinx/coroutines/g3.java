package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Unconfined.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g3 extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g3 f29901a = new g3();

    private g3() {
    }

    @Override // kotlinx.coroutines.k0
    public void dispatch(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        k3 k3Var = (k3) gVar.get(k3.f29942b);
        if (k3Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        k3Var.f29943a = true;
    }

    @Override // kotlinx.coroutines.k0
    public boolean isDispatchNeeded(@NotNull z8.g gVar) {
        return false;
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public k0 limitedParallelism(int i10) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
