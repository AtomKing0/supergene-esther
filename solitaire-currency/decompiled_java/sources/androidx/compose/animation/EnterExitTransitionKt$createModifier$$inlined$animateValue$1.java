package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.TransformOrigin;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionKt$createModifier$$inlined$animateValue$1 extends v implements q<Transition.Segment<EnterExitState>, Composer, Integer, SpringSpec<TransformOrigin>> {
    public static final EnterExitTransitionKt$createModifier$$inlined$animateValue$1 INSTANCE = new EnterExitTransitionKt$createModifier$$inlined$animateValue$1();

    public EnterExitTransitionKt$createModifier$$inlined$animateValue$1() {
        super(3);
    }

    @Composable
    @NotNull
    public final SpringSpec<TransformOrigin> invoke(@NotNull Transition.Segment<EnterExitState> segment, @Nullable Composer composer, int i10) {
        t.i(segment, "$this$null");
        composer.startReplaceableGroup(-895531546);
        SpringSpec<TransformOrigin> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        composer.endReplaceableGroup();
        return springSpecSpring$default;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer composer, Integer num) {
        return invoke(segment, composer, num.intValue());
    }
}
