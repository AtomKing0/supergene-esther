package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
final class DragGestureDetectorKt$detectVerticalDragGestures$5$1$drag$1 extends v implements p<PointerInputChange, Float, k0> {
    final /* synthetic */ kotlin.jvm.internal.k0 $overSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectVerticalDragGestures$5$1$drag$1(kotlin.jvm.internal.k0 k0Var) {
        super(2);
        this.$overSlop = k0Var;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(PointerInputChange pointerInputChange, Float f10) {
        invoke(pointerInputChange, f10.floatValue());
        return k0.f35197a;
    }

    public final void invoke(@NotNull PointerInputChange change, float f10) {
        t.i(change, "change");
        change.consume();
        this.$overSlop.f29829a = f10;
    }
}
