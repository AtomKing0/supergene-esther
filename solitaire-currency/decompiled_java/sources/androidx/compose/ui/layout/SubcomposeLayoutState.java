package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SubcomposeLayoutState {
    public static final int $stable = 8;

    @Nullable
    private LayoutNodeSubcompositionsState _state;

    @NotNull
    private final p<LayoutNode, CompositionContext, k0> setCompositionContext;

    @NotNull
    private final p<LayoutNode, p<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, k0> setMeasurePolicy;

    @NotNull
    private final p<LayoutNode, SubcomposeLayoutState, k0> setRoot;

    @NotNull
    private final SubcomposeSlotReusePolicy slotReusePolicy;

    /* JADX INFO: compiled from: SubcomposeLayout.kt */
    public interface PrecomposedSlotHandle {
        void dispose();

        int getPlaceablesCount();

        /* JADX INFO: renamed from: premeasure-0kLqBqw */
        void mo2996premeasure0kLqBqw(int i10, long j10);
    }

    public SubcomposeLayoutState(@NotNull SubcomposeSlotReusePolicy slotReusePolicy) {
        t.i(slotReusePolicy, "slotReusePolicy");
        this.slotReusePolicy = slotReusePolicy;
        this.setRoot = new SubcomposeLayoutState$setRoot$1(this);
        this.setCompositionContext = new SubcomposeLayoutState$setCompositionContext$1(this);
        this.setMeasurePolicy = new SubcomposeLayoutState$setMeasurePolicy$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutNodeSubcompositionsState getState() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this._state;
        if (layoutNodeSubcompositionsState != null) {
            return layoutNodeSubcompositionsState;
        }
        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout".toString());
    }

    public final void disposeCurrentNodes$ui_release() {
        getState().disposeCurrentNodes();
    }

    public final void forceRecomposeChildren$ui_release() {
        getState().forceRecomposeChildren();
    }

    @NotNull
    public final p<LayoutNode, CompositionContext, k0> getSetCompositionContext$ui_release() {
        return this.setCompositionContext;
    }

    @NotNull
    public final p<LayoutNode, p<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, k0> getSetMeasurePolicy$ui_release() {
        return this.setMeasurePolicy;
    }

    @NotNull
    public final p<LayoutNode, SubcomposeLayoutState, k0> getSetRoot$ui_release() {
        return this.setRoot;
    }

    @NotNull
    public final PrecomposedSlotHandle precompose(@Nullable Object obj, @NotNull p<? super Composer, ? super Integer, k0> content) {
        t.i(content, "content");
        return getState().precompose(obj, content);
    }

    public SubcomposeLayoutState() {
        this(NoOpSubcomposeSlotReusePolicy.INSTANCE);
    }

    public SubcomposeLayoutState(int i10) {
        this(SubcomposeLayoutKt.SubcomposeSlotReusePolicy(i10));
    }
}
