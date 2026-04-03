package androidx.compose.material.ripple;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RippleTheme.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RippleTheme {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: RippleTheme.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        /* JADX INFO: renamed from: defaultRippleAlpha-DxMtmZc, reason: not valid java name */
        public final RippleAlpha m1238defaultRippleAlphaDxMtmZc(long j10, boolean z10) {
            return z10 ? ((double) ColorKt.m1651luminance8_81llA(j10)) > 0.5d ? RippleThemeKt.LightThemeHighContrastRippleAlpha : RippleThemeKt.LightThemeLowContrastRippleAlpha : RippleThemeKt.DarkThemeRippleAlpha;
        }

        /* JADX INFO: renamed from: defaultRippleColor-5vOe2sY, reason: not valid java name */
        public final long m1239defaultRippleColor5vOe2sY(long j10, boolean z10) {
            return (z10 || ((double) ColorKt.m1651luminance8_81llA(j10)) >= 0.5d) ? j10 : Color.Companion.m1635getWhite0d7_KjU();
        }
    }

    @Composable
    /* JADX INFO: renamed from: defaultColor-WaAFU9c */
    long mo1053defaultColorWaAFU9c(@Nullable Composer composer, int i10);

    @Composable
    @NotNull
    RippleAlpha rippleAlpha(@Nullable Composer composer, int i10);
}
