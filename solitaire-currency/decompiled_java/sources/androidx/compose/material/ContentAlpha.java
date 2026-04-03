package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContentAlpha.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ContentAlpha {
    public static final int $stable = 0;

    @NotNull
    public static final ContentAlpha INSTANCE = new ContentAlpha();

    private ContentAlpha() {
    }

    @Composable
    private final float contentAlpha(float f10, float f11, Composer composer, int i10) {
        composer.startReplaceableGroup(-1528360391);
        long jM1608unboximpl = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl();
        if (!MaterialTheme.INSTANCE.getColors(composer, 6).isLight() ? ColorKt.m1651luminance8_81llA(jM1608unboximpl) >= 0.5d : ColorKt.m1651luminance8_81llA(jM1608unboximpl) <= 0.5d) {
            f10 = f11;
        }
        composer.endReplaceableGroup();
        return f10;
    }

    @Composable
    public final float getDisabled(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(621183615);
        float fContentAlpha = contentAlpha(0.38f, 0.38f, composer, ((i10 << 6) & 896) | 54);
        composer.endReplaceableGroup();
        return fContentAlpha;
    }

    @Composable
    public final float getHigh(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(629162431);
        float fContentAlpha = contentAlpha(1.0f, 0.87f, composer, ((i10 << 6) & 896) | 54);
        composer.endReplaceableGroup();
        return fContentAlpha;
    }

    @Composable
    public final float getMedium(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(1999054879);
        float fContentAlpha = contentAlpha(0.74f, 0.6f, composer, ((i10 << 6) & 896) | 54);
        composer.endReplaceableGroup();
        return fContentAlpha;
    }
}
