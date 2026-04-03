package androidx.compose.material;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
final class MaterialRippleTheme implements RippleTheme {

    @NotNull
    public static final MaterialRippleTheme INSTANCE = new MaterialRippleTheme();

    private MaterialRippleTheme() {
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Composable
    /* JADX INFO: renamed from: defaultColor-WaAFU9c, reason: not valid java name */
    public long mo1053defaultColorWaAFU9c(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(550536719);
        long jM1239defaultRippleColor5vOe2sY = RippleTheme.Companion.m1239defaultRippleColor5vOe2sY(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl(), MaterialTheme.INSTANCE.getColors(composer, 6).isLight());
        composer.endReplaceableGroup();
        return jM1239defaultRippleColor5vOe2sY;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Composable
    @NotNull
    public RippleAlpha rippleAlpha(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1419762518);
        RippleAlpha rippleAlphaM1238defaultRippleAlphaDxMtmZc = RippleTheme.Companion.m1238defaultRippleAlphaDxMtmZc(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl(), MaterialTheme.INSTANCE.getColors(composer, 6).isLight());
        composer.endReplaceableGroup();
        return rippleAlphaM1238defaultRippleAlphaDxMtmZc;
    }
}
