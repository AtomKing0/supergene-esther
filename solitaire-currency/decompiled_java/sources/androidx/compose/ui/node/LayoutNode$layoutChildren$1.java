package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: LayoutNode.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutNode$layoutChildren$1 extends v implements h9.a<k0> {
    final /* synthetic */ LayoutNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNode$layoutChildren$1(LayoutNode layoutNode) {
        super(0);
        this.this$0 = layoutNode;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int i10 = 0;
        this.this$0.nextChildPlaceOrder = 0;
        MutableVector<LayoutNode> mutableVector = this.this$0.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i11 = 0;
            do {
                LayoutNode layoutNode = content[i11];
                layoutNode.previousPlaceOrder = layoutNode.getPlaceOrder$ui_release();
                layoutNode.placeOrder = Integer.MAX_VALUE;
                layoutNode.getAlignmentLines$ui_release().setUsedDuringParentLayout$ui_release(false);
                if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                    layoutNode.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                }
                i11++;
            } while (i11 < size);
        }
        this.this$0.getInnerLayoutNodeWrapper$ui_release().getMeasureResult().placeChildren();
        MutableVector<LayoutNode> mutableVector2 = this.this$0.get_children$ui_release();
        LayoutNode layoutNode2 = this.this$0;
        int size2 = mutableVector2.getSize();
        if (size2 > 0) {
            LayoutNode[] content2 = mutableVector2.getContent();
            do {
                LayoutNode layoutNode3 = content2[i10];
                if (layoutNode3.previousPlaceOrder != layoutNode3.getPlaceOrder$ui_release()) {
                    layoutNode2.onZSortedChildrenInvalidated();
                    layoutNode2.invalidateLayer$ui_release();
                    if (layoutNode3.getPlaceOrder$ui_release() == Integer.MAX_VALUE) {
                        layoutNode3.markSubtreeAsNotPlaced();
                    }
                }
                layoutNode3.getAlignmentLines$ui_release().setPreviousUsedDuringParentLayout$ui_release(layoutNode3.getAlignmentLines$ui_release().getUsedDuringParentLayout$ui_release());
                i10++;
            } while (i10 < size2);
        }
    }
}
