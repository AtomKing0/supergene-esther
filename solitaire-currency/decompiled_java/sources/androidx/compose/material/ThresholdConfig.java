package androidx.compose.material;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterialApi
public interface ThresholdConfig {
    float computeThreshold(@NotNull Density density, float f10, float f11);
}
