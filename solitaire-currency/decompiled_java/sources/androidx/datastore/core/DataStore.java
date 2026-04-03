package androidx.datastore.core;

import h9.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import z8.d;

/* JADX INFO: compiled from: DataStore.kt */
/* JADX INFO: loaded from: classes.dex */
public interface DataStore<T> {
    @NotNull
    h<T> getData();

    @Nullable
    Object updateData(@NotNull p<? super T, ? super d<? super T>, ? extends Object> pVar, @NotNull d<? super T> dVar);
}
