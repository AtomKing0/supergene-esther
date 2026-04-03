package androidx.compose.animation;

import android.view.ViewConfiguration;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SplineBasedFloatDecayAnimationSpec.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SplineBasedFloatDecayAnimationSpec_androidKt {
    private static final float platformFlingScrollFriction = ViewConfiguration.getScrollFriction();

    public static final float getPlatformFlingScrollFriction() {
        return platformFlingScrollFriction;
    }

    @Composable
    @NotNull
    public static final <T> DecayAnimationSpec<T> rememberSplineBasedDecay(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(904445851);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Float fValueOf = Float.valueOf(density.getDensity());
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(fValueOf);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(density));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DecayAnimationSpec<T> decayAnimationSpec = (DecayAnimationSpec) objRememberedValue;
        composer.endReplaceableGroup();
        return decayAnimationSpec;
    }

    public static final /* synthetic */ DecayAnimationSpec splineBasedDecay(Density density) {
        t.i(density, "density");
        return SplineBasedDecayKt.splineBasedDecay(density);
    }
}
