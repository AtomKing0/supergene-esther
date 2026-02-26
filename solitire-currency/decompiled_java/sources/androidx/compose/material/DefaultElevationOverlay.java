package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ElevationOverlay.kt */
/* JADX INFO: loaded from: classes.dex */
final class DefaultElevationOverlay implements ElevationOverlay {

    @NotNull
    public static final DefaultElevationOverlay INSTANCE = new DefaultElevationOverlay();

    private DefaultElevationOverlay() {
    }

    @Override // androidx.compose.material.ElevationOverlay
    @Composable
    @ReadOnlyComposable
    /* JADX INFO: renamed from: apply-7g2Lkgo, reason: not valid java name */
    public long mo985apply7g2Lkgo(long j10, float f10, @Nullable Composer composer, int i10) {
        Colors colors = MaterialTheme.INSTANCE.getColors(composer, 6);
        if (Dp.m3672compareTo0680j_4(f10, Dp.m3673constructorimpl(0)) <= 0 || colors.isLight()) {
            return j10;
        }
        return ColorKt.m1644compositeOverOWjLjI(ElevationOverlayKt.m1019calculateForegroundColorCLU3JFs(j10, f10, composer, (i10 & 112) | (i10 & 14)), j10);
    }
}
