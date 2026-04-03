package androidx.compose.ui.viewinterop;

import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidViewHolder$layoutNode$1$coreModifier$1 extends v implements l<DrawScope, k0> {
    final /* synthetic */ LayoutNode $layoutNode;
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$layoutNode$1$coreModifier$1(LayoutNode layoutNode, AndroidViewHolder androidViewHolder) {
        super(1);
        this.$layoutNode = layoutNode;
        this.this$0 = androidViewHolder;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawScope drawBehind) {
        t.i(drawBehind, "$this$drawBehind");
        LayoutNode layoutNode = this.$layoutNode;
        AndroidViewHolder androidViewHolder = this.this$0;
        Canvas canvas = drawBehind.getDrawContext().getCanvas();
        Owner owner$ui_release = layoutNode.getOwner$ui_release();
        AndroidComposeView androidComposeView = owner$ui_release instanceof AndroidComposeView ? (AndroidComposeView) owner$ui_release : null;
        if (androidComposeView != null) {
            androidComposeView.drawAndroidView(androidViewHolder, AndroidCanvas_androidKt.getNativeCanvas(canvas));
        }
    }
}
