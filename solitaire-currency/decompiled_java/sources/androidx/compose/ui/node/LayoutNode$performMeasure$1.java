package androidx.compose.ui.node;

import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: LayoutNode.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutNode$performMeasure$1 extends v implements h9.a<k0> {
    final /* synthetic */ long $constraints;
    final /* synthetic */ LayoutNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNode$performMeasure$1(LayoutNode layoutNode, long j10) {
        super(0);
        this.this$0 = layoutNode;
        this.$constraints = j10;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getOuterLayoutNodeWrapper$ui_release().mo2987measureBRTryo0(this.$constraints);
    }
}
