package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface ButtonColors {
    @Composable
    @NotNull
    State<Color> backgroundColor(boolean z10, @Nullable Composer composer, int i10);

    @Composable
    @NotNull
    State<Color> contentColor(boolean z10, @Nullable Composer composer, int i10);
}
