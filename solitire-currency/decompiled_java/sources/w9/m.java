package w9;

import kotlinx.coroutines.k0;
import org.jetbrains.annotations.NotNull;
import u9.p;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
final class m extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f35551a = new m();

    private m() {
    }

    @Override // kotlinx.coroutines.k0
    public void dispatch(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        c.f35532g.K0(runnable, l.f35550h, false);
    }

    @Override // kotlinx.coroutines.k0
    public void dispatchYield(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        c.f35532g.K0(runnable, l.f35550h, true);
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public k0 limitedParallelism(int i10) {
        p.a(i10);
        return i10 >= l.f35546d ? this : super.limitedParallelism(i10);
    }
}
