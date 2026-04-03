package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SnapshotApplyConflictException extends Exception {
    public static final int $stable = 8;

    @NotNull
    private final Snapshot snapshot;

    public SnapshotApplyConflictException(@NotNull Snapshot snapshot) {
        t.i(snapshot, "snapshot");
        this.snapshot = snapshot;
    }

    @NotNull
    public final Snapshot getSnapshot() {
        return this.snapshot;
    }
}
