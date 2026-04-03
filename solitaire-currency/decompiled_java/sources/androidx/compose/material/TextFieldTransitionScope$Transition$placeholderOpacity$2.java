package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldTransitionScope$Transition$placeholderOpacity$2 extends v implements q<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final TextFieldTransitionScope$Transition$placeholderOpacity$2 INSTANCE = new TextFieldTransitionScope$Transition$placeholderOpacity$2();

    TextFieldTransitionScope$Transition$placeholderOpacity$2() {
        super(3);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
        return invoke(segment, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<InputPhase> animateFloat, @Nullable Composer composer, int i10) {
        t.i(animateFloat, "$this$animateFloat");
        composer.startReplaceableGroup(-1079955085);
        InputPhase inputPhase = InputPhase.Focused;
        InputPhase inputPhase2 = InputPhase.UnfocusedEmpty;
        FiniteAnimationSpec<Float> finiteAnimationSpecTween$default = animateFloat.isTransitioningTo(inputPhase, inputPhase2) ? AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null) : (animateFloat.isTransitioningTo(inputPhase2, inputPhase) || animateFloat.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase2)) ? AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing()) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        composer.endReplaceableGroup();
        return finiteAnimationSpecTween$default;
    }
}
