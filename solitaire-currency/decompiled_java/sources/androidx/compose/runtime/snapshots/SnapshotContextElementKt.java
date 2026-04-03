package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SnapshotContextElement.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotContextElementKt {
    @ExperimentalComposeApi
    @NotNull
    public static final SnapshotContextElement asContextElement(@NotNull Snapshot snapshot) {
        t.i(snapshot, "<this>");
        return new SnapshotContextElementImpl(snapshot);
    }
}
