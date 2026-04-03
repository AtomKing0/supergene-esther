package w9;

import kotlinx.coroutines.k0;
import org.jetbrains.annotations.NotNull;
import u9.p;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final c f35532g = new c();

    private c() {
        super(l.f35545c, l.f35546d, l.f35547e, l.f35543a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public k0 limitedParallelism(int i10) {
        p.a(i10);
        return i10 >= l.f35545c ? this : super.limitedParallelism(i10);
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public String toString() {
        return "Dispatchers.Default";
    }
}
