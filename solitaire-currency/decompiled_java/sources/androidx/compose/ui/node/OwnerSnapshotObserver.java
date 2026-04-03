package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: OwnerSnapshotObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OwnerSnapshotObserver {

    @NotNull
    private final SnapshotStateObserver observer;

    @NotNull
    private final l<LayoutNode, k0> onCommitAffectingLayout;

    @NotNull
    private final l<LayoutNode, k0> onCommitAffectingLayoutModifier;

    @NotNull
    private final l<LayoutNode, k0> onCommitAffectingMeasure;

    public OwnerSnapshotObserver(@NotNull l<? super h9.a<k0>, k0> onChangedExecutor) {
        t.i(onChangedExecutor, "onChangedExecutor");
        this.observer = new SnapshotStateObserver(onChangedExecutor);
        this.onCommitAffectingMeasure = OwnerSnapshotObserver$onCommitAffectingMeasure$1.INSTANCE;
        this.onCommitAffectingLayout = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE;
        this.onCommitAffectingLayoutModifier = OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1.INSTANCE;
    }

    public final void clear$ui_release(@NotNull Object target) {
        t.i(target, "target");
        this.observer.clear(target);
    }

    public final void clearInvalidObservations$ui_release() {
        this.observer.clearIf(OwnerSnapshotObserver$clearInvalidObservations$1.INSTANCE);
    }

    public final void observeLayoutModifierSnapshotReads$ui_release(@NotNull LayoutNode node, @NotNull h9.a<k0> block) {
        t.i(node, "node");
        t.i(block, "block");
        observeReads$ui_release(node, this.onCommitAffectingLayoutModifier, block);
    }

    public final void observeLayoutSnapshotReads$ui_release(@NotNull LayoutNode node, @NotNull h9.a<k0> block) {
        t.i(node, "node");
        t.i(block, "block");
        observeReads$ui_release(node, this.onCommitAffectingLayout, block);
    }

    public final void observeMeasureSnapshotReads$ui_release(@NotNull LayoutNode node, @NotNull h9.a<k0> block) {
        t.i(node, "node");
        t.i(block, "block");
        observeReads$ui_release(node, this.onCommitAffectingMeasure, block);
    }

    public final <T extends OwnerScope> void observeReads$ui_release(@NotNull T target, @NotNull l<? super T, k0> onChanged, @NotNull h9.a<k0> block) {
        t.i(target, "target");
        t.i(onChanged, "onChanged");
        t.i(block, "block");
        this.observer.observeReads(target, onChanged, block);
    }

    public final void startObserving$ui_release() {
        this.observer.start();
    }

    public final void stopObserving$ui_release() {
        this.observer.stop();
        this.observer.clear();
    }
}
