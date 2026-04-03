package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Typography.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TypographyKt {

    @NotNull
    private static final ProvidableCompositionLocal<Typography> LocalTypography = CompositionLocalKt.staticCompositionLocalOf(TypographyKt$LocalTypography$1.INSTANCE);

    @NotNull
    public static final ProvidableCompositionLocal<Typography> getLocalTypography() {
        return LocalTypography;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextStyle withDefaultFontFamily(TextStyle textStyle, FontFamily fontFamily) {
        return textStyle.getFontFamily() != null ? textStyle : textStyle.m3346copyHL5avdY((262111 & 1) != 0 ? textStyle.spanStyle.m3308getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? textStyle.spanStyle.m3309getFontSizeXSAIIZE() : 0L, (262111 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? textStyle.spanStyle.m3310getFontStyle4Lr2A7w() : null, (262111 & 16) != 0 ? textStyle.spanStyle.m3311getFontSynthesisZQGJjVo() : null, (262111 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily, (262111 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? textStyle.spanStyle.m3312getLetterSpacingXSAIIZE() : 0L, (262111 & 256) != 0 ? textStyle.spanStyle.m3307getBaselineShift5SSeXJ0() : null, (262111 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? textStyle.spanStyle.m3306getBackground0d7_KjU() : 0L, (262111 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? textStyle.paragraphStyle.m3269getTextAlignbuA522U() : null, (262111 & 32768) != 0 ? textStyle.paragraphStyle.m3270getTextDirectionmmuk1to() : null, (262111 & 65536) != 0 ? textStyle.paragraphStyle.m3268getLineHeightXSAIIZE() : 0L, (262111 & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : null);
    }
}
