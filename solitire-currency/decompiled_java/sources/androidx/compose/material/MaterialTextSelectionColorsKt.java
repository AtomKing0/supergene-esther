package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MaterialTextSelectionColors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    /* JADX INFO: renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m1054binarySearchForAccessibleSelectionColorAlphaysEtTa8(long j10, long j11, long j12) {
        float f10 = 0.2f;
        float f11 = 0.4f;
        float f12 = 0.4f;
        for (int i10 = 0; i10 < 7; i10++) {
            float fM1056calculateContrastRationb2GgbA = (m1056calculateContrastRationb2GgbA(j10, f11, j11, j12) / DesiredContrastRatio) - 1.0f;
            if (0.0f <= fM1056calculateContrastRationb2GgbA && fM1056calculateContrastRationb2GgbA <= 0.01f) {
                break;
            }
            if (fM1056calculateContrastRationb2GgbA < 0.0f) {
                f12 = f11;
            } else {
                f10 = f11;
            }
            f11 = (f12 + f10) / 2.0f;
        }
        return f11;
    }

    /* JADX INFO: renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m1055calculateContrastRatioOWjLjI(long j10, long j11) {
        float fM1651luminance8_81llA = ColorKt.m1651luminance8_81llA(j10) + 0.05f;
        float fM1651luminance8_81llA2 = ColorKt.m1651luminance8_81llA(j11) + 0.05f;
        return Math.max(fM1651luminance8_81llA, fM1651luminance8_81llA2) / Math.min(fM1651luminance8_81llA, fM1651luminance8_81llA2);
    }

    /* JADX INFO: renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m1056calculateContrastRationb2GgbA(long j10, float f10, long j11, long j12) {
        long jM1644compositeOverOWjLjI = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(j10, f10, 0.0f, 0.0f, 0.0f, 14, null), j12);
        return m1055calculateContrastRatioOWjLjI(ColorKt.m1644compositeOverOWjLjI(j11, jM1644compositeOverOWjLjI), jM1644compositeOverOWjLjI);
    }

    /* JADX INFO: renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m1057calculateSelectionBackgroundColorysEtTa8(long j10, long j11, long j12) {
        return Color.m1597copywmQWz5c$default(j10, m1056calculateContrastRationb2GgbA(j10, DefaultSelectionBackgroundAlpha, j11, j12) >= DesiredContrastRatio ? DefaultSelectionBackgroundAlpha : m1056calculateContrastRationb2GgbA(j10, 0.2f, j11, j12) < DesiredContrastRatio ? 0.2f : m1054binarySearchForAccessibleSelectionColorAlphaysEtTa8(j10, j11, j12), 0.0f, 0.0f, 0.0f, 14, null);
    }

    @Composable
    @NotNull
    public static final TextSelectionColors rememberTextSelectionColors(@NotNull Colors colors, @Nullable Composer composer, int i10) {
        t.i(colors, "colors");
        composer.startReplaceableGroup(-721696685);
        long jM951getPrimary0d7_KjU = colors.m951getPrimary0d7_KjU();
        long jM944getBackground0d7_KjU = colors.m944getBackground0d7_KjU();
        composer.startReplaceableGroup(35572910);
        long jM968contentColorFor4WTKRHQ = ColorsKt.m968contentColorFor4WTKRHQ(colors, jM944getBackground0d7_KjU);
        if (!(jM968contentColorFor4WTKRHQ != Color.Companion.m1634getUnspecified0d7_KjU())) {
            jM968contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl();
        }
        composer.endReplaceableGroup();
        long jM1597copywmQWz5c$default = Color.m1597copywmQWz5c$default(jM968contentColorFor4WTKRHQ, ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        Color colorM1588boximpl = Color.m1588boximpl(jM951getPrimary0d7_KjU);
        Color colorM1588boximpl2 = Color.m1588boximpl(jM944getBackground0d7_KjU);
        Color colorM1588boximpl3 = Color.m1588boximpl(jM1597copywmQWz5c$default);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(colorM1588boximpl) | composer.changed(colorM1588boximpl2) | composer.changed(colorM1588boximpl3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new TextSelectionColors(colors.m951getPrimary0d7_KjU(), m1057calculateSelectionBackgroundColorysEtTa8(jM951getPrimary0d7_KjU, jM1597copywmQWz5c$default, jM944getBackground0d7_KjU), null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        TextSelectionColors textSelectionColors = (TextSelectionColors) objRememberedValue;
        composer.endReplaceableGroup();
        return textSelectionColors;
    }
}
