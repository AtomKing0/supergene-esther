package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes.dex */
final class SubcomposeLayoutState$setMeasurePolicy$1 extends v implements p<LayoutNode, p<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, k0> {
    final /* synthetic */ SubcomposeLayoutState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutState$setMeasurePolicy$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.this$0 = subcomposeLayoutState;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(LayoutNode layoutNode, p<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> pVar) {
        invoke2(layoutNode, pVar);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutNode layoutNode, @NotNull p<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> it) {
        t.i(layoutNode, "$this$null");
        t.i(it, "it");
        layoutNode.setMeasurePolicy(this.this$0.getState().createMeasurePolicy(it));
    }
}
