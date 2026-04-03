package androidx.compose.material;

import androidx.compose.runtime.State;
import h9.l;
import kotlin.jvm.internal.v;
import n9.e;
import n9.n;
import v8.k0;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
final class SliderKt$RangeSlider$2$endThumbSemantics$1$1 extends v implements l<Float, k0> {
    final /* synthetic */ float $coercedStart;
    final /* synthetic */ State<l<e<Float>, k0>> $onValueChangeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$RangeSlider$2$endThumbSemantics$1$1(State<? extends l<? super e<Float>, k0>> state, float f10) {
        super(1);
        this.$onValueChangeState = state;
        this.$coercedStart = f10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Float f10) {
        invoke(f10.floatValue());
        return k0.f35197a;
    }

    public final void invoke(float f10) {
        this.$onValueChangeState.getValue().invoke(n.b(this.$coercedStart, f10));
    }
}
