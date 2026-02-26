package g8;

import g8.b;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AttributesJvm.kt */
/* JADX INFO: loaded from: classes.dex */
abstract class c implements b {
    @Override // g8.b
    @NotNull
    public <T> T a(@NotNull a<T> aVar) {
        return (T) b.a.a(this, aVar);
    }

    @Override // g8.b
    public final <T> void b(@NotNull a<T> key) {
        kotlin.jvm.internal.t.i(key, "key");
        h().remove(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g8.b
    public final <T> void c(@NotNull a<T> key, @NotNull T value) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(value, "value");
        h().put(key, value);
    }

    @Override // g8.b
    @Nullable
    public final <T> T d(@NotNull a<T> key) {
        kotlin.jvm.internal.t.i(key, "key");
        return (T) h().get(key);
    }

    @Override // g8.b
    public final boolean e(@NotNull a<?> key) {
        kotlin.jvm.internal.t.i(key, "key");
        return h().containsKey(key);
    }

    @Override // g8.b
    @NotNull
    public final List<a<?>> f() {
        return d0.P0(h().keySet());
    }

    @NotNull
    protected abstract Map<a<?>, Object> h();
}
