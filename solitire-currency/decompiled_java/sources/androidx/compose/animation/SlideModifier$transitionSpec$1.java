package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.unit.IntOffset;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class SlideModifier$transitionSpec$1 extends v implements l<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> {
    final /* synthetic */ SlideModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SlideModifier$transitionSpec$1(SlideModifier slideModifier) {
        super(1);
        this.this$0 = slideModifier;
    }

    @Override // h9.l
    @NotNull
    public final FiniteAnimationSpec<IntOffset> invoke(@NotNull Transition.Segment<EnterExitState> segment) {
        FiniteAnimationSpec<IntOffset> animationSpec;
        FiniteAnimationSpec<IntOffset> animationSpec2;
        t.i(segment, "$this$null");
        EnterExitState enterExitState = EnterExitState.PreEnter;
        EnterExitState enterExitState2 = EnterExitState.Visible;
        if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
            Slide value = this.this$0.getSlideIn().getValue();
            return (value == null || (animationSpec2 = value.getAnimationSpec()) == null) ? EnterExitTransitionKt.DefaultOffsetAnimationSpec : animationSpec2;
        }
        if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
            return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
        }
        Slide value2 = this.this$0.getSlideOut().getValue();
        return (value2 == null || (animationSpec = value2.getAnimationSpec()) == null) ? EnterExitTransitionKt.DefaultOffsetAnimationSpec : animationSpec;
    }
}
