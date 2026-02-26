package androidx.compose.ui.node;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.layout.MeasurePolicy;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IntrinsicsPolicy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IntrinsicsPolicy {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final String NoPolicyError = "Intrinsic size is queried but there is no measure policy in place.";

    @NotNull
    private final LayoutNode layoutNode;

    @Nullable
    private MutableState<MeasurePolicy> measurePolicyState;

    @Nullable
    private MeasurePolicy pendingMeasurePolicy;

    /* JADX INFO: compiled from: IntrinsicsPolicy.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public IntrinsicsPolicy(@NotNull LayoutNode layoutNode) {
        t.i(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
    }

    private final MeasurePolicy measurePolicyFromState() {
        MutableState<MeasurePolicy> mutableStateMutableStateOf$default = this.measurePolicyState;
        if (mutableStateMutableStateOf$default == null) {
            MeasurePolicy measurePolicy = this.pendingMeasurePolicy;
            if (measurePolicy == null) {
                throw new IllegalStateException(NoPolicyError.toString());
            }
            mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(measurePolicy, null, 2, null);
        }
        this.measurePolicyState = mutableStateMutableStateOf$default;
        return mutableStateMutableStateOf$default.getValue();
    }

    @NotNull
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final int maxIntrinsicHeight(int i10) {
        return measurePolicyFromState().maxIntrinsicHeight(this.layoutNode.getMeasureScope$ui_release(), this.layoutNode.getChildren$ui_release(), i10);
    }

    public final int maxIntrinsicWidth(int i10) {
        return measurePolicyFromState().maxIntrinsicWidth(this.layoutNode.getMeasureScope$ui_release(), this.layoutNode.getChildren$ui_release(), i10);
    }

    public final int minIntrinsicHeight(int i10) {
        return measurePolicyFromState().minIntrinsicHeight(this.layoutNode.getMeasureScope$ui_release(), this.layoutNode.getChildren$ui_release(), i10);
    }

    public final int minIntrinsicWidth(int i10) {
        return measurePolicyFromState().minIntrinsicWidth(this.layoutNode.getMeasureScope$ui_release(), this.layoutNode.getChildren$ui_release(), i10);
    }

    public final void updateFrom(@NotNull MeasurePolicy measurePolicy) {
        t.i(measurePolicy, "measurePolicy");
        MutableState<MeasurePolicy> mutableState = this.measurePolicyState;
        if (mutableState == null) {
            this.pendingMeasurePolicy = measurePolicy;
        } else {
            t.f(mutableState);
            mutableState.setValue(measurePolicy);
        }
    }
}
