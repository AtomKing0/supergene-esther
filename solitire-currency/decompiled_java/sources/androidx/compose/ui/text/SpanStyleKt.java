package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyle;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpanStyle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpanStyleKt {
    private static final long DefaultBackgroundColor;
    private static final long DefaultColor;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    /* JADX INFO: renamed from: androidx.compose.ui.text.SpanStyleKt$resolveSpanStyleDefaults$1, reason: invalid class name */
    /* JADX INFO: compiled from: SpanStyle.kt */
    static final class AnonymousClass1 extends v implements h9.a<TextDrawStyle> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final TextDrawStyle invoke() {
            return TextDrawStyle.Companion.m3611from8_81llA(SpanStyleKt.DefaultColor);
        }
    }

    static {
        Color.Companion companion = Color.Companion;
        DefaultBackgroundColor = companion.m1633getTransparent0d7_KjU();
        DefaultColor = companion.m1624getBlack0d7_KjU();
    }

    @NotNull
    public static final SpanStyle lerp(@NotNull SpanStyle start, @NotNull SpanStyle stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        TextDrawStyle textDrawStyleLerp = TextDrawStyleKt.lerp(start.getTextDrawStyle$ui_text_release(), stop.getTextDrawStyle$ui_text_release(), f10);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(start.getFontFamily(), stop.getFontFamily(), f10);
        long jM3313lerpTextUnitInheritableC3pnCVY = m3313lerpTextUnitInheritableC3pnCVY(start.m3309getFontSizeXSAIIZE(), stop.m3309getFontSizeXSAIIZE(), f10);
        FontWeight fontWeight = start.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = stop.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeightLerp = FontWeightKt.lerp(fontWeight, fontWeight2, f10);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(start.m3310getFontStyle4Lr2A7w(), stop.m3310getFontStyle4Lr2A7w(), f10);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(start.m3311getFontSynthesisZQGJjVo(), stop.m3311getFontSynthesisZQGJjVo(), f10);
        String str = (String) lerpDiscrete(start.getFontFeatureSettings(), stop.getFontFeatureSettings(), f10);
        long jM3313lerpTextUnitInheritableC3pnCVY2 = m3313lerpTextUnitInheritableC3pnCVY(start.m3312getLetterSpacingXSAIIZE(), stop.m3312getLetterSpacingXSAIIZE(), f10);
        BaselineShift baselineShiftM3307getBaselineShift5SSeXJ0 = start.m3307getBaselineShift5SSeXJ0();
        float fM3548unboximpl = baselineShiftM3307getBaselineShift5SSeXJ0 != null ? baselineShiftM3307getBaselineShift5SSeXJ0.m3548unboximpl() : BaselineShift.m3543constructorimpl(0.0f);
        BaselineShift baselineShiftM3307getBaselineShift5SSeXJ02 = stop.m3307getBaselineShift5SSeXJ0();
        float fM3555lerpjWV1Mfo = BaselineShiftKt.m3555lerpjWV1Mfo(fM3548unboximpl, baselineShiftM3307getBaselineShift5SSeXJ02 != null ? baselineShiftM3307getBaselineShift5SSeXJ02.m3548unboximpl() : BaselineShift.m3543constructorimpl(0.0f), f10);
        TextGeometricTransform textGeometricTransform = start.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = stop.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransformLerp = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f10);
        LocaleList localeList = (LocaleList) lerpDiscrete(start.getLocaleList(), stop.getLocaleList(), f10);
        long jM1650lerpjxsXWHM = ColorKt.m1650lerpjxsXWHM(start.m3306getBackground0d7_KjU(), stop.m3306getBackground0d7_KjU(), f10);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(start.getTextDecoration(), stop.getTextDecoration(), f10);
        Shadow shadow = start.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = stop.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(textDrawStyleLerp, jM3313lerpTextUnitInheritableC3pnCVY, fontWeightLerp, fontStyle, fontSynthesis, fontFamily, str, jM3313lerpTextUnitInheritableC3pnCVY2, BaselineShift.m3542boximpl(fM3555lerpjWV1Mfo), textGeometricTransformLerp, localeList, jM1650lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f10), lerpPlatformStyle(start.getPlatformStyle(), stop.getPlatformStyle(), f10), (k) null);
    }

    public static final <T> T lerpDiscrete(T t10, T t11, float f10) {
        return ((double) f10) < 0.5d ? t10 : t11;
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f10) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.Companion.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f10);
    }

    /* JADX INFO: renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m3313lerpTextUnitInheritableC3pnCVY(long j10, long j11, float f10) {
        return (TextUnitKt.m3872isUnspecifiedR2X_6o(j10) || TextUnitKt.m3872isUnspecifiedR2X_6o(j11)) ? ((TextUnit) lerpDiscrete(TextUnit.m3844boximpl(j10), TextUnit.m3844boximpl(j11), f10)).m3863unboximpl() : TextUnitKt.m3874lerpC3pnCVY(j10, j11, f10);
    }

    @NotNull
    public static final SpanStyle resolveSpanStyleDefaults(@NotNull SpanStyle style) {
        t.i(style, "style");
        TextDrawStyle textDrawStyleTakeOrElse = style.getTextDrawStyle$ui_text_release().takeOrElse(AnonymousClass1.INSTANCE);
        long jM3309getFontSizeXSAIIZE = TextUnitKt.m3872isUnspecifiedR2X_6o(style.m3309getFontSizeXSAIIZE()) ? DefaultFontSize : style.m3309getFontSizeXSAIIZE();
        FontWeight fontWeight = style.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyleM3310getFontStyle4Lr2A7w = style.m3310getFontStyle4Lr2A7w();
        FontStyle fontStyleM3410boximpl = FontStyle.m3410boximpl(fontStyleM3310getFontStyle4Lr2A7w != null ? fontStyleM3310getFontStyle4Lr2A7w.m3416unboximpl() : FontStyle.Companion.m3418getNormal_LCdwA());
        FontSynthesis fontSynthesisM3311getFontSynthesisZQGJjVo = style.m3311getFontSynthesisZQGJjVo();
        FontSynthesis fontSynthesisM3419boximpl = FontSynthesis.m3419boximpl(fontSynthesisM3311getFontSynthesisZQGJjVo != null ? fontSynthesisM3311getFontSynthesisZQGJjVo.m3427unboximpl() : FontSynthesis.Companion.m3428getAllGVVA2EU());
        FontFamily fontFamily = style.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = style.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        long jM3312getLetterSpacingXSAIIZE = TextUnitKt.m3872isUnspecifiedR2X_6o(style.m3312getLetterSpacingXSAIIZE()) ? DefaultLetterSpacing : style.m3312getLetterSpacingXSAIIZE();
        BaselineShift baselineShiftM3307getBaselineShift5SSeXJ0 = style.m3307getBaselineShift5SSeXJ0();
        BaselineShift baselineShiftM3542boximpl = BaselineShift.m3542boximpl(baselineShiftM3307getBaselineShift5SSeXJ0 != null ? baselineShiftM3307getBaselineShift5SSeXJ0.m3548unboximpl() : BaselineShift.Companion.m3552getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = style.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = style.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long jM3306getBackground0d7_KjU = style.m3306getBackground0d7_KjU();
        if (!(jM3306getBackground0d7_KjU != Color.Companion.m1634getUnspecified0d7_KjU())) {
            jM3306getBackground0d7_KjU = DefaultBackgroundColor;
        }
        long j10 = jM3306getBackground0d7_KjU;
        TextDecoration textDecoration = style.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = style.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        return new SpanStyle(textDrawStyleTakeOrElse, jM3309getFontSizeXSAIIZE, fontWeight2, fontStyleM3410boximpl, fontSynthesisM3419boximpl, fontFamily2, str, jM3312getLetterSpacingXSAIIZE, baselineShiftM3542boximpl, textGeometricTransform2, localeList2, j10, textDecoration2, shadow, style.getPlatformStyle(), (k) null);
    }
}
