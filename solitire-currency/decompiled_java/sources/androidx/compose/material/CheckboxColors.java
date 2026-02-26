package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface CheckboxColors {
    @Composable
    @NotNull
    State<Color> borderColor(boolean z10, @NotNull ToggleableState toggleableState, @Nullable Composer composer, int i10);

    @Composable
    @NotNull
    State<Color> boxColor(boolean z10, @NotNull ToggleableState toggleableState, @Nullable Composer composer, int i10);

    @Composable
    @NotNull
    State<Color> checkmarkColor(@NotNull ToggleableState toggleableState, @Nullable Composer composer, int i10);
}
