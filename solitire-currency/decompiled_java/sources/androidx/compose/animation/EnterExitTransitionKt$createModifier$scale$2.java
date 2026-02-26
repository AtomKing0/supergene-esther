package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class EnterExitTransitionKt$createModifier$scale$2 extends v implements q<Transition.Segment<EnterExitState>, Composer, Integer, FiniteAnimationSpec<Float>> {
    final /* synthetic */ EnterTransition $enter;
    final /* synthetic */ ExitTransition $exit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$createModifier$scale$2(EnterTransition enterTransition, ExitTransition exitTransition) {
        super(3);
        this.$enter = enterTransition;
        this.$exit = exitTransition;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment, Composer composer, Integer num) {
        return invoke(segment, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<EnterExitState> animateFloat, @Nullable Composer composer, int i10) {
        FiniteAnimationSpec<Float> animationSpec;
        Scale scale;
        t.i(animateFloat, "$this$animateFloat");
        composer.startReplaceableGroup(-53984035);
        EnterExitState enterExitState = EnterExitState.PreEnter;
        EnterExitState enterExitState2 = EnterExitState.Visible;
        if (animateFloat.isTransitioningTo(enterExitState, enterExitState2)) {
            Scale scale2 = this.$enter.getData$animation_release().getScale();
            if (scale2 == null || (animationSpec = scale2.getAnimationSpec()) == null) {
                animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
        } else if (!animateFloat.isTransitioningTo(enterExitState2, EnterExitState.PostExit) || (scale = this.$exit.getData$animation_release().getScale()) == null || (animationSpec = scale.getAnimationSpec()) == null) {
            animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
        }
        composer.endReplaceableGroup();
        return animationSpec;
    }
}
