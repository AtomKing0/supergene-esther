package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntSize;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class AnimatedContentScope$SizeModifier$measure$size$1<S> extends v implements l<Transition.Segment<S>, FiniteAnimationSpec<IntSize>> {
    final /* synthetic */ AnimatedContentScope<S> this$0;
    final /* synthetic */ AnimatedContentScope<S>.SizeModifier this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimatedContentScope$SizeModifier$measure$size$1(AnimatedContentScope<S> animatedContentScope, AnimatedContentScope<S>.SizeModifier sizeModifier) {
        super(1);
        this.this$0 = animatedContentScope;
        this.this$1 = sizeModifier;
    }

    @Override // h9.l
    @NotNull
    public final FiniteAnimationSpec<IntSize> invoke(@NotNull Transition.Segment<S> animate) {
        FiniteAnimationSpec<IntSize> finiteAnimationSpecMo89createAnimationSpecTemP2vQ;
        t.i(animate, "$this$animate");
        State<IntSize> state = this.this$0.getTargetSizeMap$animation_release().get(animate.getInitialState());
        long jM3837unboximpl = state != null ? state.getValue().m3837unboximpl() : IntSize.Companion.m3838getZeroYbymL2g();
        State<IntSize> state2 = this.this$0.getTargetSizeMap$animation_release().get(animate.getTargetState());
        long jM3837unboximpl2 = state2 != null ? state2.getValue().m3837unboximpl() : IntSize.Companion.m3838getZeroYbymL2g();
        SizeTransform value = this.this$1.getSizeTransform().getValue();
        return (value == null || (finiteAnimationSpecMo89createAnimationSpecTemP2vQ = value.mo89createAnimationSpecTemP2vQ(jM3837unboximpl, jM3837unboximpl2)) == null) ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : finiteAnimationSpecMo89createAnimationSpecTemP2vQ;
    }
}
