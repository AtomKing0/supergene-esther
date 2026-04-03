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
final class ExpandShrinkModifier$measure$offsetDelta$1 extends v implements l<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> {
    public static final ExpandShrinkModifier$measure$offsetDelta$1 INSTANCE = new ExpandShrinkModifier$measure$offsetDelta$1();

    ExpandShrinkModifier$measure$offsetDelta$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final FiniteAnimationSpec<IntOffset> invoke(@NotNull Transition.Segment<EnterExitState> animate) {
        t.i(animate, "$this$animate");
        return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
    }
}
