package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.unit.IntSize;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class ExpandShrinkModifier$sizeTransitionSpec$1 extends v implements l<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> {
    final /* synthetic */ ExpandShrinkModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpandShrinkModifier$sizeTransitionSpec$1(ExpandShrinkModifier expandShrinkModifier) {
        super(1);
        this.this$0 = expandShrinkModifier;
    }

    @Override // h9.l
    @NotNull
    public final FiniteAnimationSpec<IntSize> invoke(@NotNull Transition.Segment<EnterExitState> segment) {
        t.i(segment, "$this$null");
        EnterExitState enterExitState = EnterExitState.PreEnter;
        EnterExitState enterExitState2 = EnterExitState.Visible;
        FiniteAnimationSpec<IntSize> animationSpec = null;
        if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
            ChangeSize value = this.this$0.getExpand().getValue();
            if (value != null) {
                animationSpec = value.getAnimationSpec();
            }
        } else if (segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
            ChangeSize value2 = this.this$0.getShrink().getValue();
            if (value2 != null) {
                animationSpec = value2.getAnimationSpec();
            }
        } else {
            animationSpec = EnterExitTransitionKt.DefaultSizeAnimationSpec;
        }
        return animationSpec == null ? EnterExitTransitionKt.DefaultSizeAnimationSpec : animationSpec;
    }
}
