package z8;

import h9.p;
import java.io.Serializable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h implements g, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f37608a = new h();

    private h() {
    }

    @Override // z8.g
    public <R> R fold(R r10, @NotNull p<? super R, ? super g.b, ? extends R> operation) {
        t.i(operation, "operation");
        return r10;
    }

    @Override // z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> key) {
        t.i(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // z8.g
    @NotNull
    public g minusKey(@NotNull g.c<?> key) {
        t.i(key, "key");
        return this;
    }

    @Override // z8.g
    @NotNull
    public g plus(@NotNull g context) {
        t.i(context, "context");
        return context;
    }

    @NotNull
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
