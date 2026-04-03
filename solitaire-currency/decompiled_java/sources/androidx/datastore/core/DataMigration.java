package androidx.datastore.core;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: DataMigration.kt */
/* JADX INFO: loaded from: classes.dex */
public interface DataMigration<T> {
    @Nullable
    Object cleanUp(@NotNull d<? super k0> dVar);

    @Nullable
    Object migrate(T t10, @NotNull d<? super T> dVar);

    @Nullable
    Object shouldMigrate(T t10, @NotNull d<? super Boolean> dVar);
}
