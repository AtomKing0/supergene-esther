package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
final class DraggableKt$awaitDownAndSlop$postPointerSlop$1 extends v implements p<PointerInputChange, Float, k0> {
    final /* synthetic */ kotlin.jvm.internal.k0 $initialDelta;
    final /* synthetic */ VelocityTracker $velocityTracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DraggableKt$awaitDownAndSlop$postPointerSlop$1(VelocityTracker velocityTracker, kotlin.jvm.internal.k0 k0Var) {
        super(2);
        this.$velocityTracker = velocityTracker;
        this.$initialDelta = k0Var;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(PointerInputChange pointerInputChange, Float f10) {
        invoke(pointerInputChange, f10.floatValue());
        return k0.f35197a;
    }

    public final void invoke(@NotNull PointerInputChange event, float f10) {
        t.i(event, "event");
        VelocityTrackerKt.addPointerInputChange(this.$velocityTracker, event);
        event.consume();
        this.$initialDelta.f29829a = f10;
    }
}
