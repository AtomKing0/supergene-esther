package t9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SendingCollector.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class w<T> implements s9.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final r9.u<T> f34183a;

    /* JADX WARN: Multi-variable type inference failed */
    public w(@NotNull r9.u<? super T> uVar) {
        this.f34183a = uVar;
    }

    @Override // s9.i
    @Nullable
    public Object emit(T t10, @NotNull z8.d<? super k0> dVar) {
        Object objP = this.f34183a.p(t10, dVar);
        return objP == a9.d.e() ? objP : k0.f35197a;
    }
}
