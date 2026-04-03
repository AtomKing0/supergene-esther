package androidx.compose.ui.node;

import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: LayoutNodeWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutNodeWrapper$invalidateParentLayer$1 extends v implements h9.a<k0> {
    final /* synthetic */ LayoutNodeWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNodeWrapper$invalidateParentLayer$1(LayoutNodeWrapper layoutNodeWrapper) {
        super(0);
        this.this$0 = layoutNodeWrapper;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LayoutNodeWrapper wrappedBy$ui_release = this.this$0.getWrappedBy$ui_release();
        if (wrappedBy$ui_release != null) {
            wrappedBy$ui_release.invalidateLayer();
        }
    }
}
