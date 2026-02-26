package androidx.lifecycle;

import kotlinx.coroutines.g1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public interface LiveDataScope<T> {
    @Nullable
    Object emit(T t10, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object emitSource(@NotNull LiveData<T> liveData, @NotNull z8.d<? super g1> dVar);

    @Nullable
    T getLatestValue();
}
