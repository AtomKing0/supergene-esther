package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SnackbarDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final SnackbarDefaults INSTANCE = new SnackbarDefaults();
    private static final float SnackbarOverlayAlpha = 0.8f;

    private SnackbarDefaults() {
    }

    @Composable
    public final long getBackgroundColor(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(1630911716);
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        long jM1644compositeOverOWjLjI = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(materialTheme.getColors(composer, 6).m950getOnSurface0d7_KjU(), SnackbarOverlayAlpha, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m955getSurface0d7_KjU());
        composer.endReplaceableGroup();
        return jM1644compositeOverOWjLjI;
    }

    @Composable
    public final long getPrimaryActionColor(@Nullable Composer composer, int i10) {
        long jM952getPrimaryVariant0d7_KjU;
        composer.startReplaceableGroup(-810329402);
        Colors colors = MaterialTheme.INSTANCE.getColors(composer, 6);
        if (colors.isLight()) {
            jM952getPrimaryVariant0d7_KjU = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(colors.m955getSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), colors.m951getPrimary0d7_KjU());
        } else {
            jM952getPrimaryVariant0d7_KjU = colors.m952getPrimaryVariant0d7_KjU();
        }
        composer.endReplaceableGroup();
        return jM952getPrimaryVariant0d7_KjU;
    }
}
