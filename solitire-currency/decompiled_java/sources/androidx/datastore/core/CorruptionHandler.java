package androidx.datastore.core;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: CorruptionHandler.kt */
/* JADX INFO: loaded from: classes.dex */
public interface CorruptionHandler<T> {
    @Nullable
    Object handleCorruption(@NotNull CorruptionException corruptionException, @NotNull d<? super T> dVar);
}
