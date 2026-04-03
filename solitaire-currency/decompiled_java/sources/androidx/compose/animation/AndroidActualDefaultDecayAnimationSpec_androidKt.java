package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidActualDefaultDecayAnimationSpec.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidActualDefaultDecayAnimationSpec_androidKt {
    @Composable
    @NotNull
    public static final DecayAnimationSpec<Float> defaultDecayAnimationSpec(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1468328074);
        DecayAnimationSpec<Float> decayAnimationSpecRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        composer.endReplaceableGroup();
        return decayAnimationSpecRememberSplineBasedDecay;
    }
}
