package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ModalBottomSheetDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final ModalBottomSheetDefaults INSTANCE = new ModalBottomSheetDefaults();
    private static final float Elevation = Dp.m3673constructorimpl(16);

    private ModalBottomSheetDefaults() {
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m1063getElevationD9Ej5fM() {
        return Elevation;
    }

    @Composable
    public final long getScrimColor(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-112572414);
        long jM1597copywmQWz5c$default = Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        composer.endReplaceableGroup();
        return jM1597copywmQWz5c$default;
    }
}
