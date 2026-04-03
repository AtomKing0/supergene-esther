package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SnapshotMutableState.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SnapshotMutableState<T> extends MutableState<T> {
    @NotNull
    SnapshotMutationPolicy<T> getPolicy();
}
