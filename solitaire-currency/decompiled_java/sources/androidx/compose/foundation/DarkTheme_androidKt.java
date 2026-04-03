package androidx.compose.foundation;

import android.content.res.Configuration;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DarkTheme.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DarkTheme_androidKt {
    @Composable
    @ReadOnlyComposable
    public static final boolean _isSystemInDarkTheme(@Nullable Composer composer, int i10) {
        return (((Configuration) composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).uiMode & 48) == 32;
    }
}
