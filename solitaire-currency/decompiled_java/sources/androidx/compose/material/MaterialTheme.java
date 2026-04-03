package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class MaterialTheme {
    public static final int $stable = 0;

    @NotNull
    public static final MaterialTheme INSTANCE = new MaterialTheme();

    private MaterialTheme() {
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public final Colors getColors(@Nullable Composer composer, int i10) {
        return (Colors) composer.consume(ColorsKt.getLocalColors());
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public final Shapes getShapes(@Nullable Composer composer, int i10) {
        return (Shapes) composer.consume(ShapesKt.getLocalShapes());
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public final Typography getTypography(@Nullable Composer composer, int i10) {
        return (Typography) composer.consume(TypographyKt.getLocalTypography());
    }
}
