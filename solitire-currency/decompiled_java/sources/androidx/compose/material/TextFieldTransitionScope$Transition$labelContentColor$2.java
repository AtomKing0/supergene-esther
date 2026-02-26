package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldTransitionScope$Transition$labelContentColor$2 extends v implements q<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>> {
    public static final TextFieldTransitionScope$Transition$labelContentColor$2 INSTANCE = new TextFieldTransitionScope$Transition$labelContentColor$2();

    TextFieldTransitionScope$Transition$labelContentColor$2() {
        super(3);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
        return invoke(segment, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final FiniteAnimationSpec<Color> invoke(@NotNull Transition.Segment<InputPhase> animateColor, @Nullable Composer composer, int i10) {
        t.i(animateColor, "$this$animateColor");
        composer.startReplaceableGroup(-32667848);
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
        composer.endReplaceableGroup();
        return tweenSpecTween$default;
    }
}
