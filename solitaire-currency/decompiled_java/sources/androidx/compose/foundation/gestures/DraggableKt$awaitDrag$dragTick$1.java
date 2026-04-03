package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import r9.u;
import v8.k0;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
final class DraggableKt$awaitDrag$dragTick$1 extends v implements l<PointerInputChange, k0> {
    final /* synthetic */ u<DragEvent> $channel;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $reverseDirection;
    final /* synthetic */ VelocityTracker $velocityTracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DraggableKt$awaitDrag$dragTick$1(VelocityTracker velocityTracker, Orientation orientation, u<? super DragEvent> uVar, boolean z10) {
        super(1);
        this.$velocityTracker = velocityTracker;
        this.$orientation = orientation;
        this.$channel = uVar;
        this.$reverseDirection = z10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(PointerInputChange pointerInputChange) {
        invoke2(pointerInputChange);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull PointerInputChange event) {
        t.i(event, "event");
        VelocityTrackerKt.addPointerInputChange(this.$velocityTracker, event);
        float fM270toFloat3MmeM6k = DraggableKt.m270toFloat3MmeM6k(PointerEventKt.positionChange(event), this.$orientation);
        event.consume();
        u<DragEvent> uVar = this.$channel;
        if (this.$reverseDirection) {
            fM270toFloat3MmeM6k *= -1;
        }
        uVar.f(new DragEvent.DragDelta(fM270toFloat3MmeM6k, event.m2873getPositionF1C5BW0(), null));
    }
}
