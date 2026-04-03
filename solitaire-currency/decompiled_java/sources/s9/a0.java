package s9;

import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes5.dex */
final class a0<T> implements m0<T>, c<T>, t9.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final b2 f33645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ m0<T> f33646b;

    /* JADX WARN: Multi-variable type inference failed */
    public a0(@NotNull m0<? extends T> m0Var, @Nullable b2 b2Var) {
        this.f33645a = b2Var;
        this.f33646b = m0Var;
    }

    @Override // t9.p
    @NotNull
    public h<T> b(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        return o0.d(this, gVar, i10, aVar);
    }

    @Override // s9.c0, s9.h
    @Nullable
    public Object collect(@NotNull i<? super T> iVar, @NotNull z8.d<?> dVar) {
        return this.f33646b.collect(iVar, dVar);
    }

    @Override // s9.m0
    public T getValue() {
        return this.f33646b.getValue();
    }
}
