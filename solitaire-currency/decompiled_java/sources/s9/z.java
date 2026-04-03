package s9;

import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes5.dex */
final class z<T> implements c0<T>, c<T>, t9.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final b2 f33926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ c0<T> f33927b;

    /* JADX WARN: Multi-variable type inference failed */
    public z(@NotNull c0<? extends T> c0Var, @Nullable b2 b2Var) {
        this.f33926a = b2Var;
        this.f33927b = c0Var;
    }

    @Override // t9.p
    @NotNull
    public h<T> b(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        return e0.e(this, gVar, i10, aVar);
    }

    @Override // s9.c0, s9.h
    @Nullable
    public Object collect(@NotNull i<? super T> iVar, @NotNull z8.d<?> dVar) {
        return this.f33927b.collect(iVar, dVar);
    }
}
