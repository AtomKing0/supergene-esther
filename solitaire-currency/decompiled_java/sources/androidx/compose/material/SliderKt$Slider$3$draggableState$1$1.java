package androidx.compose.material;

import androidx.compose.material.SliderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import h9.l;
import kotlin.jvm.internal.v;
import n9.e;
import n9.o;
import v8.k0;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
final class SliderKt$Slider$3$draggableState$1$1 extends v implements l<Float, k0> {
    final /* synthetic */ kotlin.jvm.internal.k0 $maxPx;
    final /* synthetic */ kotlin.jvm.internal.k0 $minPx;
    final /* synthetic */ State<l<Float, k0>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $pressOffset;
    final /* synthetic */ MutableState<Float> $rawOffset;
    final /* synthetic */ e<Float> $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$Slider$3$draggableState$1$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, State<? extends l<? super Float, k0>> state, e<Float> eVar) {
        super(1);
        this.$rawOffset = mutableState;
        this.$pressOffset = mutableState2;
        this.$minPx = k0Var;
        this.$maxPx = k0Var2;
        this.$onValueChangeState = state;
        this.$valueRange = eVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Float f10) {
        invoke(f10.floatValue());
        return k0.f35197a;
    }

    public final void invoke(float f10) {
        MutableState<Float> mutableState = this.$rawOffset;
        mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + f10 + this.$pressOffset.getValue().floatValue()));
        this.$pressOffset.setValue(Float.valueOf(0.0f));
        this.$onValueChangeState.getValue().invoke(Float.valueOf(SliderKt.C09333.invoke$scaleToUserValue(this.$minPx, this.$maxPx, this.$valueRange, o.m(this.$rawOffset.getValue().floatValue(), this.$minPx.f29829a, this.$maxPx.f29829a))));
    }
}
