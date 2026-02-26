package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes5.dex */
final class b0<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.p<i<? super T>, z8.d<? super v8.k0>, Object> f33652a;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(@NotNull h9.p<? super i<? super T>, ? super z8.d<? super v8.k0>, ? extends Object> pVar) {
        this.f33652a = pVar;
    }

    @Override // s9.a
    @Nullable
    public Object f(@NotNull i<? super T> iVar, @NotNull z8.d<? super v8.k0> dVar) {
        Object objMo4invoke = this.f33652a.mo4invoke(iVar, dVar);
        return objMo4invoke == a9.d.e() ? objMo4invoke : v8.k0.f35197a;
    }
}
