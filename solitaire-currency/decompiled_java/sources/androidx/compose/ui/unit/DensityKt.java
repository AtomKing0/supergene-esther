package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Density.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DensityKt {
    @Stable
    @NotNull
    public static final Density Density(float f10, float f11) {
        return new DensityImpl(f10, f11);
    }

    public static /* synthetic */ Density Density$default(float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = 1.0f;
        }
        return Density(f10, f11);
    }
}
