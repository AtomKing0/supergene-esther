package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface SliderColors {
    @Composable
    @NotNull
    State<Color> thumbColor(boolean z10, @Nullable Composer composer, int i10);

    @Composable
    @NotNull
    State<Color> tickColor(boolean z10, boolean z11, @Nullable Composer composer, int i10);

    @Composable
    @NotNull
    State<Color> trackColor(boolean z10, boolean z11, @Nullable Composer composer, int i10);
}
