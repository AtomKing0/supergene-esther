package androidx.compose.runtime;

import androidx.compose.runtime.internal.ThreadMap;
import androidx.compose.runtime.internal.ThreadMapKt;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ActualJvm.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotThreadLocal<T> {

    @NotNull
    private final AtomicReference<ThreadMap> map = new AtomicReference<>(ThreadMapKt.getEmptyThreadMap());

    @NotNull
    private final Object writeMutex = new Object();

    @Nullable
    public final T get() {
        return (T) this.map.get().get(Thread.currentThread().getId());
    }

    public final void set(@Nullable T t10) {
        long id = Thread.currentThread().getId();
        synchronized (this.writeMutex) {
            ThreadMap threadMap = this.map.get();
            if (threadMap.trySet(id, t10)) {
                return;
            }
            this.map.set(threadMap.newWith(id, t10));
            k0 k0Var = k0.f35197a;
        }
    }
}
