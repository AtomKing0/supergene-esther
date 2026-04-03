package androidx.compose.material;

import h9.l;
import kotlin.jvm.internal.v;
import n9.o;
import v8.k0;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
final class SwipeableState$draggableState$1 extends v implements l<Float, k0> {
    final /* synthetic */ SwipeableState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableState$draggableState$1(SwipeableState<T> swipeableState) {
        super(1);
        this.this$0 = swipeableState;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Float f10) {
        invoke(f10.floatValue());
        return k0.f35197a;
    }

    public final void invoke(float f10) {
        float fFloatValue = ((Number) ((SwipeableState) this.this$0).absoluteOffset.getValue()).floatValue() + f10;
        float fM = o.m(fFloatValue, this.this$0.getMinBound$material_release(), this.this$0.getMaxBound$material_release());
        float f11 = fFloatValue - fM;
        ResistanceConfig resistance$material_release = this.this$0.getResistance$material_release();
        ((SwipeableState) this.this$0).offsetState.setValue(Float.valueOf(fM + (resistance$material_release != null ? resistance$material_release.computeResistance(f11) : 0.0f)));
        ((SwipeableState) this.this$0).overflowState.setValue(Float.valueOf(f11));
        ((SwipeableState) this.this$0).absoluteOffset.setValue(Float.valueOf(fFloatValue));
    }
}
