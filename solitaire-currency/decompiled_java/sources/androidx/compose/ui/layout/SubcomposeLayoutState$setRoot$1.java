package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes.dex */
final class SubcomposeLayoutState$setRoot$1 extends v implements p<LayoutNode, SubcomposeLayoutState, k0> {
    final /* synthetic */ SubcomposeLayoutState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutState$setRoot$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.this$0 = subcomposeLayoutState;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(LayoutNode layoutNode, SubcomposeLayoutState subcomposeLayoutState) {
        invoke2(layoutNode, subcomposeLayoutState);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutNode layoutNode, @NotNull SubcomposeLayoutState it) {
        t.i(layoutNode, "$this$null");
        t.i(it, "it");
        SubcomposeLayoutState subcomposeLayoutState = this.this$0;
        LayoutNodeSubcompositionsState subcompositionsState$ui_release = layoutNode.getSubcompositionsState$ui_release();
        if (subcompositionsState$ui_release == null) {
            subcompositionsState$ui_release = new LayoutNodeSubcompositionsState(layoutNode, this.this$0.slotReusePolicy);
            layoutNode.setSubcompositionsState$ui_release(subcompositionsState$ui_release);
        }
        subcomposeLayoutState._state = subcompositionsState$ui_release;
        this.this$0.getState().makeSureStateIsConsistent();
        this.this$0.getState().setSlotReusePolicy(this.this$0.slotReusePolicy);
    }
}
