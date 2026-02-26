package androidx.compose.foundation.gestures;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.AndroidOverscrollKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ScrollableDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final ScrollableDefaults INSTANCE = new ScrollableDefaults();

    private ScrollableDefaults() {
    }

    @Composable
    @NotNull
    public final FlingBehavior flingBehavior(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(1107739818);
        DecayAnimationSpec decayAnimationSpecRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(decayAnimationSpecRememberSplineBasedDecay);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecRememberSplineBasedDecay);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultFlingBehavior defaultFlingBehavior = (DefaultFlingBehavior) objRememberedValue;
        composer.endReplaceableGroup();
        return defaultFlingBehavior;
    }

    @Composable
    @ExperimentalFoundationApi
    @NotNull
    public final OverscrollEffect overscrollEffect(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(1809802212);
        OverscrollEffect overscrollEffectRememberOverscrollEffect = AndroidOverscrollKt.rememberOverscrollEffect(composer, 0);
        composer.endReplaceableGroup();
        return overscrollEffectRememberOverscrollEffect;
    }
}
