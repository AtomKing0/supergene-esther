package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Painter.kt */
/* JADX INFO: loaded from: classes.dex */
final class Painter$drawLambda$1 extends v implements l<DrawScope, k0> {
    final /* synthetic */ Painter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Painter$drawLambda$1(Painter painter) {
        super(1);
        this.this$0 = painter;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawScope drawScope) {
        t.i(drawScope, "$this$null");
        this.this$0.onDraw(drawScope);
    }
}
