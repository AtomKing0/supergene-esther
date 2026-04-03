package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.geometry.Offset;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: SelectionMagnifier.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2", f = "SelectionMagnifier.kt", l = {102}, m = "invokeSuspend")
final class SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2 extends l implements p<o0, d<? super k0>, Object> {
    final /* synthetic */ Animatable<Offset, AnimationVector2D> $animatable;
    final /* synthetic */ long $targetValue;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2(Animatable<Offset, AnimationVector2D> animatable, long j10, d<? super SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2> dVar) {
        super(2, dVar);
        this.$animatable = animatable;
        this.$targetValue = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2(this.$animatable, this.$targetValue, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            Animatable<Offset, AnimationVector2D> animatable = this.$animatable;
            Offset offsetM1356boximpl = Offset.m1356boximpl(this.$targetValue);
            SpringSpec springSpec = SelectionMagnifierKt.MagnifierSpringSpec;
            this.label = 1;
            if (Animatable.animateTo$default(animatable, offsetM1356boximpl, springSpec, null, null, this, 12, null) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
        return ((SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
