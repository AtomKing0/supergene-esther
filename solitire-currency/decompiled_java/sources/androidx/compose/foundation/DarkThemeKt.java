package androidx.compose.foundation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ReadOnlyComposable;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DarkTheme.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DarkThemeKt {
    @Composable
    @ReadOnlyComposable
    public static final boolean isSystemInDarkTheme(@Nullable Composer composer, int i10) {
        return DarkTheme_androidKt._isSystemInDarkTheme(composer, 0);
    }
}
