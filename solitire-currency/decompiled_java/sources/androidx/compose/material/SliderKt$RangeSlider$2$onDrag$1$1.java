package androidx.compose.material;

import androidx.compose.material.SliderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import h9.l;
import h9.p;
import kotlin.jvm.internal.v;
import n9.e;
import n9.n;
import n9.o;
import v8.k0;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
final class SliderKt$RangeSlider$2$onDrag$1$1 extends v implements p<Boolean, Float, k0> {
    final /* synthetic */ kotlin.jvm.internal.k0 $maxPx;
    final /* synthetic */ kotlin.jvm.internal.k0 $minPx;
    final /* synthetic */ State<l<e<Float>, k0>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
    final /* synthetic */ MutableState<Float> $rawOffsetStart;
    final /* synthetic */ e<Float> $valueRange;
    final /* synthetic */ e<Float> $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$RangeSlider$2$onDrag$1$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, e<Float> eVar, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, State<? extends l<? super e<Float>, k0>> state, e<Float> eVar2) {
        super(2);
        this.$rawOffsetStart = mutableState;
        this.$rawOffsetEnd = mutableState2;
        this.$values = eVar;
        this.$minPx = k0Var;
        this.$maxPx = k0Var2;
        this.$onValueChangeState = state;
        this.$valueRange = eVar2;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Boolean bool, Float f10) {
        invoke(bool.booleanValue(), f10.floatValue());
        return k0.f35197a;
    }

    public final void invoke(boolean z10, float f10) {
        e eVarB;
        if (z10) {
            MutableState<Float> mutableState = this.$rawOffsetStart;
            mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + f10));
            this.$rawOffsetEnd.setValue(Float.valueOf(SliderKt.C09312.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, this.$values.getEndInclusive().floatValue())));
            float fFloatValue = this.$rawOffsetEnd.getValue().floatValue();
            eVarB = n.b(o.m(this.$rawOffsetStart.getValue().floatValue(), this.$minPx.f29829a, fFloatValue), fFloatValue);
        } else {
            MutableState<Float> mutableState2 = this.$rawOffsetEnd;
            mutableState2.setValue(Float.valueOf(mutableState2.getValue().floatValue() + f10));
            this.$rawOffsetStart.setValue(Float.valueOf(SliderKt.C09312.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, this.$values.getStart().floatValue())));
            float fFloatValue2 = this.$rawOffsetStart.getValue().floatValue();
            eVarB = n.b(fFloatValue2, o.m(this.$rawOffsetEnd.getValue().floatValue(), fFloatValue2, this.$maxPx.f29829a));
        }
        this.$onValueChangeState.getValue().invoke(SliderKt.C09312.invoke$scaleToUserValue(this.$minPx, this.$maxPx, this.$valueRange, eVarB));
    }
}
