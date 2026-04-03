package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class SnapshotApplyResult {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: Snapshot.kt */
    @StabilityInferred(parameters = 0)
    public static final class Failure extends SnapshotApplyResult {
        public static final int $stable = 8;

        @NotNull
        private final Snapshot snapshot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(@NotNull Snapshot snapshot) {
            super(null);
            t.i(snapshot, "snapshot");
            this.snapshot = snapshot;
        }

        @Override // androidx.compose.runtime.snapshots.SnapshotApplyResult
        public void check() throws SnapshotApplyConflictException {
            this.snapshot.dispose();
            throw new SnapshotApplyConflictException(this.snapshot);
        }

        @NotNull
        public final Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // androidx.compose.runtime.snapshots.SnapshotApplyResult
        public boolean getSucceeded() {
            return false;
        }
    }

    private SnapshotApplyResult() {
    }

    public /* synthetic */ SnapshotApplyResult(k kVar) {
        this();
    }

    public abstract void check();

    public abstract boolean getSucceeded();

    /* JADX INFO: compiled from: Snapshot.kt */
    @StabilityInferred(parameters = 0)
    public static final class Success extends SnapshotApplyResult {
        public static final int $stable = 0;

        @NotNull
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }

        @Override // androidx.compose.runtime.snapshots.SnapshotApplyResult
        public boolean getSucceeded() {
            return true;
        }

        @Override // androidx.compose.runtime.snapshots.SnapshotApplyResult
        public void check() {
        }
    }
}
