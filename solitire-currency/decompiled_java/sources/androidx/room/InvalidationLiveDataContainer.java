package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InvalidationLiveDataContainer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InvalidationLiveDataContainer {

    @NotNull
    private final RoomDatabase database;

    @NotNull
    private final Set<LiveData<?>> liveDataSet;

    public InvalidationLiveDataContainer(@NotNull RoomDatabase database) {
        kotlin.jvm.internal.t.i(database, "database");
        this.database = database;
        Set<LiveData<?>> setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        kotlin.jvm.internal.t.h(setNewSetFromMap, "newSetFromMap(IdentityHashMap())");
        this.liveDataSet = setNewSetFromMap;
    }

    @NotNull
    public final <T> LiveData<T> create(@NotNull String[] tableNames, boolean z10, @NotNull Callable<T> computeFunction) {
        kotlin.jvm.internal.t.i(tableNames, "tableNames");
        kotlin.jvm.internal.t.i(computeFunction, "computeFunction");
        return new RoomTrackingLiveData(this.database, this, z10, computeFunction, tableNames);
    }

    @NotNull
    public final Set<LiveData<?>> getLiveDataSet$room_runtime_release() {
        return this.liveDataSet;
    }

    public final void onActive(@NotNull LiveData<?> liveData) {
        kotlin.jvm.internal.t.i(liveData, "liveData");
        this.liveDataSet.add(liveData);
    }

    public final void onInactive(@NotNull LiveData<?> liveData) {
        kotlin.jvm.internal.t.i(liveData, "liveData");
        this.liveDataSet.remove(liveData);
    }
}
