package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Layout.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutKt$MultiMeasureLayout$1$1 extends v implements h9.l<LayoutNode, k0> {
    public static final LayoutKt$MultiMeasureLayout$1$1 INSTANCE = new LayoutKt$MultiMeasureLayout$1$1();

    LayoutKt$MultiMeasureLayout$1$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(LayoutNode layoutNode) {
        invoke2(layoutNode);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutNode init) {
        t.i(init, "$this$init");
        init.setCanMultiMeasure$ui_release(true);
    }
}
