package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import h9.a;
import h9.l;
import h9.p;
import java.util.List;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
final class SliderKt$Slider$3$gestureEndAction$1 extends v implements l<Float, k0> {
    final /* synthetic */ SliderDraggableState $draggableState;
    final /* synthetic */ kotlin.jvm.internal.k0 $maxPx;
    final /* synthetic */ kotlin.jvm.internal.k0 $minPx;
    final /* synthetic */ a<k0> $onValueChangeFinished;
    final /* synthetic */ MutableState<Float> $rawOffset;
    final /* synthetic */ o0 $scope;
    final /* synthetic */ List<Float> $tickFractions;

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Slider.kt */
    @f(c = "androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1", f = "Slider.kt", l = {204}, m = "invokeSuspend")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ SliderDraggableState $draggableState;
        final /* synthetic */ a<k0> $onValueChangeFinished;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SliderDraggableState sliderDraggableState, float f10, float f11, float f12, a<k0> aVar, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$draggableState = sliderDraggableState;
            this.$current = f10;
            this.$target = f11;
            this.$velocity = f12;
            this.$onValueChangeFinished = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$draggableState, this.$current, this.$target, this.$velocity, this.$onValueChangeFinished, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                SliderDraggableState sliderDraggableState = this.$draggableState;
                float f10 = this.$current;
                float f11 = this.$target;
                float f12 = this.$velocity;
                this.label = 1;
                if (SliderKt.animateToTarget(sliderDraggableState, f10, f11, f12, this) == objE) {
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
    SliderKt$Slider$3$gestureEndAction$1(MutableState<Float> mutableState, List<Float> list, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, o0 o0Var, SliderDraggableState sliderDraggableState, a<k0> aVar) {
        super(1);
        this.$rawOffset = mutableState;
        this.$tickFractions = list;
        this.$minPx = k0Var;
        this.$maxPx = k0Var2;
        this.$scope = o0Var;
        this.$draggableState = sliderDraggableState;
        this.$onValueChangeFinished = aVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Float f10) {
        invoke(f10.floatValue());
        return k0.f35197a;
    }

    public final void invoke(float f10) {
        a<k0> aVar;
        float fFloatValue = this.$rawOffset.getValue().floatValue();
        float fSnapValueToTick = SliderKt.snapValueToTick(fFloatValue, this.$tickFractions, this.$minPx.f29829a, this.$maxPx.f29829a);
        if (!(fFloatValue == fSnapValueToTick)) {
            k.d(this.$scope, null, null, new AnonymousClass1(this.$draggableState, fFloatValue, fSnapValueToTick, f10, this.$onValueChangeFinished, null), 3, null);
        } else {
            if (this.$draggableState.isDragging() || (aVar = this.$onValueChangeFinished) == null) {
                return;
            }
            aVar.invoke();
        }
    }
}
