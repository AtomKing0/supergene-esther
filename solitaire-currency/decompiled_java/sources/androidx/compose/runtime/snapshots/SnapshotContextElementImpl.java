package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import androidx.compose.runtime.snapshots.SnapshotContextElement;
import h9.p;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.z2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: SnapshotContextElement.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeApi
final class SnapshotContextElementImpl implements SnapshotContextElement, z2<Snapshot> {

    @NotNull
    private final Snapshot snapshot;

    public SnapshotContextElementImpl(@NotNull Snapshot snapshot) {
        t.i(snapshot, "snapshot");
        this.snapshot = snapshot;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) SnapshotContextElement.DefaultImpls.fold(this, r10, pVar);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) SnapshotContextElement.DefaultImpls.get(this, cVar);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, z8.g.b
    @NotNull
    public g.c<?> getKey() {
        return SnapshotContextElement.Key;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, z8.g.b, z8.g
    @NotNull
    public g minusKey(@NotNull g.c<?> cVar) {
        return SnapshotContextElement.DefaultImpls.minusKey(this, cVar);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, z8.g
    @NotNull
    public g plus(@NotNull g gVar) {
        return SnapshotContextElement.DefaultImpls.plus(this, gVar);
    }

    @Override // kotlinx.coroutines.z2
    public void restoreThreadContext(@NotNull g context, @Nullable Snapshot snapshot) {
        t.i(context, "context");
        this.snapshot.unsafeLeave(snapshot);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.z2
    @Nullable
    public Snapshot updateThreadContext(@NotNull g context) {
        t.i(context, "context");
        return this.snapshot.unsafeEnter();
    }
}
