package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import h9.a;
import h9.l;
import kotlin.jvm.internal.v;
import n9.e;
import v8.k0;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
final class SliderKt$CorrectValueSideEffect$1$1 extends v implements a<k0> {
    final /* synthetic */ l<Float, Float> $scaleToOffset;
    final /* synthetic */ e<Float> $trackRange;
    final /* synthetic */ float $value;
    final /* synthetic */ e<Float> $valueRange;
    final /* synthetic */ MutableState<Float> $valueState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$CorrectValueSideEffect$1$1(e<Float> eVar, l<? super Float, Float> lVar, float f10, MutableState<Float> mutableState, e<Float> eVar2) {
        super(0);
        this.$valueRange = eVar;
        this.$scaleToOffset = lVar;
        this.$value = f10;
        this.$valueState = mutableState;
        this.$trackRange = eVar2;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        float fFloatValue = (this.$valueRange.getEndInclusive().floatValue() - this.$valueRange.getStart().floatValue()) / 1000;
        float fFloatValue2 = this.$scaleToOffset.invoke(Float.valueOf(this.$value)).floatValue();
        if (Math.abs(fFloatValue2 - this.$valueState.getValue().floatValue()) <= fFloatValue || !this.$trackRange.contains(this.$valueState.getValue())) {
            return;
        }
        this.$valueState.setValue(Float.valueOf(fFloatValue2));
    }
}
