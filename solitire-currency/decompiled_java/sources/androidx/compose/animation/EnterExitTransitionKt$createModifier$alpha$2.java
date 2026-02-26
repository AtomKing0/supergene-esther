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
final class EnterExitTransitionKt$createModifier$alpha$2 extends v implements q<Transition.Segment<EnterExitState>, Composer, Integer, FiniteAnimationSpec<Float>> {
    final /* synthetic */ EnterTransition $enter;
    final /* synthetic */ ExitTransition $exit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$createModifier$alpha$2(EnterTransition enterTransition, ExitTransition exitTransition) {
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
        Fade fade;
        t.i(animateFloat, "$this$animateFloat");
        composer.startReplaceableGroup(-57153604);
        EnterExitState enterExitState = EnterExitState.PreEnter;
        EnterExitState enterExitState2 = EnterExitState.Visible;
        if (animateFloat.isTransitioningTo(enterExitState, enterExitState2)) {
            Fade fade2 = this.$enter.getData$animation_release().getFade();
            if (fade2 == null || (animationSpec = fade2.getAnimationSpec()) == null) {
                animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
        } else if (!animateFloat.isTransitioningTo(enterExitState2, EnterExitState.PostExit) || (fade = this.$exit.getData$animation_release().getFade()) == null || (animationSpec = fade.getAnimationSpec()) == null) {
            animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
        }
        composer.endReplaceableGroup();
        return animationSpec;
    }
}
