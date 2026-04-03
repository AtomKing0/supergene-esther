package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Vector.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorComponent$drawVectorBlock$1 extends v implements l<DrawScope, k0> {
    final /* synthetic */ VectorComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VectorComponent$drawVectorBlock$1(VectorComponent vectorComponent) {
        super(1);
        this.this$0 = vectorComponent;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawScope drawScope) {
        t.i(drawScope, "$this$null");
        this.this$0.getRoot().draw(drawScope);
    }
}
