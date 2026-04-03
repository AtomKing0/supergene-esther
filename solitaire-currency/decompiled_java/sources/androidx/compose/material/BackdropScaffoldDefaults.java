package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class BackdropScaffoldDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final BackdropScaffoldDefaults INSTANCE = new BackdropScaffoldDefaults();
    private static final float PeekHeight = Dp.m3673constructorimpl(56);
    private static final float HeaderHeight = Dp.m3673constructorimpl(48);
    private static final float FrontLayerElevation = Dp.m3673constructorimpl(1);

    private BackdropScaffoldDefaults() {
    }

    /* JADX INFO: renamed from: getFrontLayerElevation-D9Ej5fM, reason: not valid java name */
    public final float m864getFrontLayerElevationD9Ej5fM() {
        return FrontLayerElevation;
    }

    @Composable
    public final long getFrontLayerScrimColor(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(1806270648);
        long jM1597copywmQWz5c$default = Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
        composer.endReplaceableGroup();
        return jM1597copywmQWz5c$default;
    }

    @Composable
    @NotNull
    public final Shape getFrontLayerShape(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(1580588700);
        float f10 = 16;
        CornerBasedShape cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 6).getLarge(), CornerSizeKt.m638CornerSize0680j_4(Dp.m3673constructorimpl(f10)), CornerSizeKt.m638CornerSize0680j_4(Dp.m3673constructorimpl(f10)), null, null, 12, null);
        composer.endReplaceableGroup();
        return cornerBasedShapeCopy$default;
    }

    /* JADX INFO: renamed from: getHeaderHeight-D9Ej5fM, reason: not valid java name */
    public final float m865getHeaderHeightD9Ej5fM() {
        return HeaderHeight;
    }

    /* JADX INFO: renamed from: getPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m866getPeekHeightD9Ej5fM() {
        return PeekHeight;
    }
}
