package androidx.datastore.core.handlers;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: NoOpCorruptionHandler.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NoOpCorruptionHandler<T> implements CorruptionHandler<T> {
    @Override // androidx.datastore.core.CorruptionHandler
    @Nullable
    public Object handleCorruption(@NotNull CorruptionException corruptionException, @NotNull d<? super T> dVar) throws CorruptionException {
        throw corruptionException;
    }
}
