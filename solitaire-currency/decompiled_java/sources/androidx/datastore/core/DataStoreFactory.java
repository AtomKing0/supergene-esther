package androidx.datastore.core;

import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import h9.a;
import java.io.File;
import java.util.List;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DataStoreFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreFactory {

    @NotNull
    public static final DataStoreFactory INSTANCE = new DataStoreFactory();

    private DataStoreFactory() {
    }

    public static /* synthetic */ DataStore create$default(DataStoreFactory dataStoreFactory, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, o0 o0Var, a aVar, int i10, Object obj) {
        ReplaceFileCorruptionHandler replaceFileCorruptionHandler2 = (i10 & 2) != 0 ? null : replaceFileCorruptionHandler;
        if ((i10 & 4) != 0) {
            list = v.l();
        }
        List list2 = list;
        if ((i10 & 8) != 0) {
            o0Var = p0.a(e1.b().plus(y2.b(null, 1, null)));
        }
        return dataStoreFactory.create(serializer, replaceFileCorruptionHandler2, list2, o0Var, aVar);
    }

    @NotNull
    public final <T> DataStore<T> create(@NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull a<? extends File> produceFile) {
        t.i(serializer, "serializer");
        t.i(produceFile, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, null, null, produceFile, 12, null);
    }

    @NotNull
    public final <T> DataStore<T> create(@NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<T>> migrations, @NotNull a<? extends File> produceFile) {
        t.i(serializer, "serializer");
        t.i(migrations, "migrations");
        t.i(produceFile, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, migrations, null, produceFile, 8, null);
    }

    @NotNull
    public final <T> DataStore<T> create(@NotNull Serializer<T> serializer, @NotNull a<? extends File> produceFile) {
        t.i(serializer, "serializer");
        t.i(produceFile, "produceFile");
        return create$default(this, serializer, null, null, null, produceFile, 14, null);
    }

    @NotNull
    public final <T> DataStore<T> create(@NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<T>> migrations, @NotNull o0 scope, @NotNull a<? extends File> produceFile) {
        t.i(serializer, "serializer");
        t.i(migrations, "migrations");
        t.i(scope, "scope");
        t.i(produceFile, "produceFile");
        if (replaceFileCorruptionHandler == null) {
            replaceFileCorruptionHandler = (ReplaceFileCorruptionHandler<T>) new NoOpCorruptionHandler();
        }
        return new SingleProcessDataStore(produceFile, serializer, u.e(DataMigrationInitializer.Companion.getInitializer(migrations)), replaceFileCorruptionHandler, scope);
    }
}
