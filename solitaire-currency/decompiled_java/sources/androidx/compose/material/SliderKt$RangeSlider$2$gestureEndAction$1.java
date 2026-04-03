package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.material.SliderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import h9.a;
import h9.l;
import h9.p;
import java.util.List;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import n9.e;
import n9.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
final class SliderKt$RangeSlider$2$gestureEndAction$1 extends v implements l<Boolean, k0> {
    final /* synthetic */ kotlin.jvm.internal.k0 $maxPx;
    final /* synthetic */ kotlin.jvm.internal.k0 $minPx;
    final /* synthetic */ a<k0> $onValueChangeFinished;
    final /* synthetic */ State<l<e<Float>, k0>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
    final /* synthetic */ MutableState<Float> $rawOffsetStart;
    final /* synthetic */ o0 $scope;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ e<Float> $valueRange;

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Slider.kt */
    @f(c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1", f = "Slider.kt", l = {352}, m = "invokeSuspend")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ boolean $isStart;
        final /* synthetic */ kotlin.jvm.internal.k0 $maxPx;
        final /* synthetic */ kotlin.jvm.internal.k0 $minPx;
        final /* synthetic */ a<k0> $onValueChangeFinished;
        final /* synthetic */ State<l<e<Float>, k0>> $onValueChangeState;
        final /* synthetic */ MutableState<Float> $rawOffsetEnd;
        final /* synthetic */ MutableState<Float> $rawOffsetStart;
        final /* synthetic */ float $target;
        final /* synthetic */ e<Float> $valueRange;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Slider.kt */
        static final class C01041 extends v implements l<Animatable<Float, AnimationVector1D>, k0> {
            final /* synthetic */ boolean $isStart;
            final /* synthetic */ kotlin.jvm.internal.k0 $maxPx;
            final /* synthetic */ kotlin.jvm.internal.k0 $minPx;
            final /* synthetic */ State<l<e<Float>, k0>> $onValueChangeState;
            final /* synthetic */ MutableState<Float> $rawOffsetEnd;
            final /* synthetic */ MutableState<Float> $rawOffsetStart;
            final /* synthetic */ e<Float> $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01041(boolean z10, MutableState<Float> mutableState, MutableState<Float> mutableState2, State<? extends l<? super e<Float>, k0>> state, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, e<Float> eVar) {
                super(1);
                this.$isStart = z10;
                this.$rawOffsetStart = mutableState;
                this.$rawOffsetEnd = mutableState2;
                this.$onValueChangeState = state;
                this.$minPx = k0Var;
                this.$maxPx = k0Var2;
                this.$valueRange = eVar;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Animatable<Float, AnimationVector1D> animatable) {
                invoke2(animatable);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Animatable<Float, AnimationVector1D> animateTo) {
                t.i(animateTo, "$this$animateTo");
                (this.$isStart ? this.$rawOffsetStart : this.$rawOffsetEnd).setValue(animateTo.getValue());
                this.$onValueChangeState.getValue().invoke(SliderKt.C09312.invoke$scaleToUserValue(this.$minPx, this.$maxPx, this.$valueRange, n.b(this.$rawOffsetStart.getValue().floatValue(), this.$rawOffsetEnd.getValue().floatValue())));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(float f10, float f11, a<k0> aVar, boolean z10, MutableState<Float> mutableState, MutableState<Float> mutableState2, State<? extends l<? super e<Float>, k0>> state, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, e<Float> eVar, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$current = f10;
            this.$target = f11;
            this.$onValueChangeFinished = aVar;
            this.$isStart = z10;
            this.$rawOffsetStart = mutableState;
            this.$rawOffsetEnd = mutableState2;
            this.$onValueChangeState = state;
            this.$minPx = k0Var;
            this.$maxPx = k0Var2;
            this.$valueRange = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$current, this.$target, this.$onValueChangeFinished, this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null);
                Float fC = b.c(this.$target);
                TweenSpec tweenSpec = SliderKt.SliderToTickAnimation;
                Float fC2 = b.c(0.0f);
                C01041 c01041 = new C01041(this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange);
                this.label = 1;
                if (animatableAnimatable$default.animateTo(fC, tweenSpec, fC2, c01041, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            a<k0> aVar = this.$onValueChangeFinished;
            if (aVar != null) {
                aVar.invoke();
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$RangeSlider$2$gestureEndAction$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, List<Float> list, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, a<k0> aVar, o0 o0Var, State<? extends l<? super e<Float>, k0>> state, e<Float> eVar) {
        super(1);
        this.$rawOffsetStart = mutableState;
        this.$rawOffsetEnd = mutableState2;
        this.$tickFractions = list;
        this.$minPx = k0Var;
        this.$maxPx = k0Var2;
        this.$onValueChangeFinished = aVar;
        this.$scope = o0Var;
        this.$onValueChangeState = state;
        this.$valueRange = eVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return k0.f35197a;
    }

    public final void invoke(boolean z10) {
        float fFloatValue = (z10 ? this.$rawOffsetStart : this.$rawOffsetEnd).getValue().floatValue();
        float fSnapValueToTick = SliderKt.snapValueToTick(fFloatValue, this.$tickFractions, this.$minPx.f29829a, this.$maxPx.f29829a);
        if (!(fFloatValue == fSnapValueToTick)) {
            k.d(this.$scope, null, null, new AnonymousClass1(fFloatValue, fSnapValueToTick, this.$onValueChangeFinished, z10, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, null), 3, null);
            return;
        }
        a<k0> aVar = this.$onValueChangeFinished;
        if (aVar != null) {
            aVar.invoke();
        }
    }
}
