package z8;

import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;
import z8.g.b;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b<B extends g.b, E extends B> implements g.c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final l<g.b, E> f37601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final g.c<?> f37602b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [z8.g$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [h9.l<? super z8.g$b, ? extends E extends B>, h9.l<z8.g$b, E extends B>, java.lang.Object] */
    public b(@NotNull g.c<B> baseKey, @NotNull l<? super g.b, ? extends E> safeCast) {
        t.i(baseKey, "baseKey");
        t.i(safeCast, "safeCast");
        this.f37601a = safeCast;
        this.f37602b = baseKey instanceof b ? (g.c<B>) ((b) baseKey).f37602b : baseKey;
    }

    public final boolean a(@NotNull g.c<?> key) {
        t.i(key, "key");
        return key == this || this.f37602b == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lz8/g$b;)TE; */
    @Nullable
    public final g.b b(@NotNull g.b element) {
        t.i(element, "element");
        return (g.b) this.f37601a.invoke(element);
    }
}
