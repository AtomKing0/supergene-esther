package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.state.ToggleableState;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
final class CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 extends v implements q<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 INSTANCE = new CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2();

    CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2() {
        super(3);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer, Integer num) {
        return invoke(segment, composer, num.intValue());
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @NotNull
    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<ToggleableState> animateFloat, @Nullable Composer composer, int i10) {
        t.i(animateFloat, "$this$animateFloat");
        composer.startReplaceableGroup(1075283605);
        ToggleableState initialState = animateFloat.getInitialState();
        ToggleableState toggleableState = ToggleableState.Off;
        FiniteAnimationSpec<Float> finiteAnimationSpecSnap$default = initialState == toggleableState ? AnimationSpecKt.snap$default(0, 1, null) : animateFloat.getTargetState() == toggleableState ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
        composer.endReplaceableGroup();
        return finiteAnimationSpecSnap$default;
    }
}
