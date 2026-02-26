package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalMaterialApi
public final class FractionalThreshold implements ThresholdConfig {
    private final float fraction;

    public FractionalThreshold(float f10) {
        this.fraction = f10;
    }

    private final float component1() {
        return this.fraction;
    }

    public static /* synthetic */ FractionalThreshold copy$default(FractionalThreshold fractionalThreshold, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = fractionalThreshold.fraction;
        }
        return fractionalThreshold.copy(f10);
    }

    @Override // androidx.compose.material.ThresholdConfig
    public float computeThreshold(@NotNull Density density, float f10, float f11) {
        t.i(density, "<this>");
        return MathHelpersKt.lerp(f10, f11, this.fraction);
    }

    @NotNull
    public final FractionalThreshold copy(float f10) {
        return new FractionalThreshold(f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FractionalThreshold) && t.d(Float.valueOf(this.fraction), Float.valueOf(((FractionalThreshold) obj).fraction));
    }

    public int hashCode() {
        return Float.floatToIntBits(this.fraction);
    }

    @NotNull
    public String toString() {
        return "FractionalThreshold(fraction=" + this.fraction + ')';
    }
}
