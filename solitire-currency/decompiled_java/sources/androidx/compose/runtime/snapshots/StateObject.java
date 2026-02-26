package androidx.compose.runtime.snapshots;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
public interface StateObject {

    /* JADX INFO: compiled from: Snapshot.kt */
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static StateRecord mergeRecords(@NotNull StateObject stateObject, @NotNull StateRecord previous, @NotNull StateRecord current, @NotNull StateRecord applied) {
            t.i(previous, "previous");
            t.i(current, "current");
            t.i(applied, "applied");
            return a.a(stateObject, previous, current, applied);
        }
    }

    @NotNull
    StateRecord getFirstStateRecord();

    @Nullable
    StateRecord mergeRecords(@NotNull StateRecord stateRecord, @NotNull StateRecord stateRecord2, @NotNull StateRecord stateRecord3);

    void prependStateRecord(@NotNull StateRecord stateRecord);
}
