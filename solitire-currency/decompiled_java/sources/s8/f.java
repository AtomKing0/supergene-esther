package s8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import s8.g;

/* JADX INFO: compiled from: Pool.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f<T> implements g<T> {
    @Override // s8.g
    public void C0(@NotNull T instance) {
        t.i(instance, "instance");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        g.a.a(this);
    }

    @Override // s8.g
    public void dispose() {
    }
}
