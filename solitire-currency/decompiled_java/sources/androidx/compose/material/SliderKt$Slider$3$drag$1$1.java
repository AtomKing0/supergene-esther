package androidx.compose.material;

import androidx.compose.runtime.State;
import h9.q;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.material.SliderKt$Slider$3$drag$1$1", f = "Slider.kt", l = {}, m = "invokeSuspend")
final class SliderKt$Slider$3$drag$1$1 extends l implements q<o0, Float, d<? super k0>, Object> {
    final /* synthetic */ State<h9.l<Float, k0>> $gestureEndAction;
    /* synthetic */ float F$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$Slider$3$drag$1$1(State<? extends h9.l<? super Float, k0>> state, d<? super SliderKt$Slider$3$drag$1$1> dVar) {
        super(3, dVar);
        this.$gestureEndAction = state;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Object invoke(o0 o0Var, Float f10, d<? super k0> dVar) {
        return invoke(o0Var, f10.floatValue(), dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a9.d.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u.b(obj);
        this.$gestureEndAction.getValue().invoke(b.c(this.F$0));
        return k0.f35197a;
    }

    @Nullable
    public final Object invoke(@NotNull o0 o0Var, float f10, @Nullable d<? super k0> dVar) {
        SliderKt$Slider$3$drag$1$1 sliderKt$Slider$3$drag$1$1 = new SliderKt$Slider$3$drag$1$1(this.$gestureEndAction, dVar);
        sliderKt$Slider$3$drag$1$1.F$0 = f10;
        return sliderKt$Slider$3$drag$1$1.invokeSuspend(k0.f35197a);
    }
}
