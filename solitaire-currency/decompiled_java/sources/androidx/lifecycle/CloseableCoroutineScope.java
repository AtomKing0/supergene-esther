package androidx.lifecycle;

import java.io.Closeable;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CloseableCoroutineScope implements Closeable, o0 {

    @NotNull
    private final z8.g coroutineContext;

    public CloseableCoroutineScope(@NotNull z8.g gVar) {
        this.coroutineContext = gVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        h2.f(getCoroutineContext(), null, 1, null);
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return this.coroutineContext;
    }
}
