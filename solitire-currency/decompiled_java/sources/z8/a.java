package z8;

import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements g.b {

    @NotNull
    private final g.c<?> key;

    public a(@NotNull g.c<?> key) {
        t.i(key, "key");
        this.key = key;
    }

    @Override // z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r10, pVar);
    }

    @Override // z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // z8.g.b
    @NotNull
    public g.c<?> getKey() {
        return this.key;
    }

    @Override // z8.g.b, z8.g
    @NotNull
    public g minusKey(@NotNull g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // z8.g
    @NotNull
    public g plus(@NotNull g gVar) {
        return g.b.a.d(this, gVar);
    }
}
