package s9;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StateFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final u9.h0 f33751a = new u9.h0("NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final u9.h0 f33752b = new u9.h0("PENDING");

    @NotNull
    public static final <T> y<T> a(T t10) {
        if (t10 == null) {
            t10 = (T) t9.s.f34171a;
        }
        return new n0(t10);
    }

    @NotNull
    public static final <T> h<T> d(@NotNull m0<? extends T> m0Var, @NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        boolean z10 = false;
        if (i10 >= 0 && i10 < 2) {
            z10 = true;
        }
        return ((z10 || i10 == -2) && aVar == r9.a.DROP_OLDEST) ? m0Var : e0.e(m0Var, gVar, i10, aVar);
    }
}
