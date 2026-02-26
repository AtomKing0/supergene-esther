package androidx.compose.runtime;

import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: ProduceState.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ProduceStateScope<T> extends MutableState<T>, o0 {
    @Nullable
    Object awaitDispose(@NotNull h9.a<k0> aVar, @NotNull z8.d<?> dVar);

    @Override // kotlinx.coroutines.o0
    @NotNull
    /* synthetic */ g getCoroutineContext();
}
