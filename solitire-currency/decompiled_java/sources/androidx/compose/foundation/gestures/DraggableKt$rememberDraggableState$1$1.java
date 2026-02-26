package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import h9.l;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
final class DraggableKt$rememberDraggableState$1$1 extends v implements l<Float, k0> {
    final /* synthetic */ State<l<Float, k0>> $onDeltaState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DraggableKt$rememberDraggableState$1$1(State<? extends l<? super Float, k0>> state) {
        super(1);
        this.$onDeltaState = state;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Float f10) {
        invoke(f10.floatValue());
        return k0.f35197a;
    }

    public final void invoke(float f10) {
        this.$onDeltaState.getValue().invoke(Float.valueOf(f10));
    }
}
