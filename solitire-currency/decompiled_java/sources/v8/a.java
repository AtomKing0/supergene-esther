package v8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DeepRecursive.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a<T, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.q<c<T, R>, T, z8.d<? super R>, Object> f35163a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull h9.q<? super c<T, R>, ? super T, ? super z8.d<? super R>, ? extends Object> block) {
        kotlin.jvm.internal.t.i(block, "block");
        this.f35163a = block;
    }

    @NotNull
    public final h9.q<c<T, R>, T, z8.d<? super R>, Object> a() {
        return this.f35163a;
    }
}
