package androidx.compose.material.ripple;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RippleTheme.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
final class DebugRippleTheme implements RippleTheme {

    @NotNull
    public static final DebugRippleTheme INSTANCE = new DebugRippleTheme();

    private DebugRippleTheme() {
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Composable
    /* JADX INFO: renamed from: defaultColor-WaAFU9c */
    public long mo1053defaultColorWaAFU9c(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(2042140174);
        long jM1239defaultRippleColor5vOe2sY = RippleTheme.Companion.m1239defaultRippleColor5vOe2sY(Color.Companion.m1624getBlack0d7_KjU(), true);
        composer.endReplaceableGroup();
        return jM1239defaultRippleColor5vOe2sY;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Composable
    @NotNull
    public RippleAlpha rippleAlpha(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1629816343);
        RippleAlpha rippleAlphaM1238defaultRippleAlphaDxMtmZc = RippleTheme.Companion.m1238defaultRippleAlphaDxMtmZc(Color.Companion.m1624getBlack0d7_KjU(), true);
        composer.endReplaceableGroup();
        return rippleAlphaM1238defaultRippleAlphaDxMtmZc;
    }
}
