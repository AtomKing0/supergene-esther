package androidx.datastore.core;

import h9.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: InitializerApi.kt */
/* JADX INFO: loaded from: classes.dex */
public interface InitializerApi<T> {
    @Nullable
    Object updateData(@NotNull p<? super T, ? super d<? super T>, ? extends Object> pVar, @NotNull d<? super T> dVar);
}
