package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextDrawStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextStyle.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextStyle {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final TextStyle Default = new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262143, (k) null);

    @NotNull
    private final ParagraphStyle paragraphStyle;

    @Nullable
    private final PlatformTextStyle platformStyle;

    @NotNull
    private final SpanStyle spanStyle;

    @ExperimentalTextApi
    public /* synthetic */ TextStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j14, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, k kVar) {
        this(j10, j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, textAlign, textDirection, j14, textIndent, platformTextStyle, lineHeightStyle);
    }

    /* JADX INFO: renamed from: copy-WQp3-mU$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m3345copyWQp3mU$default(TextStyle textStyle, Brush brush, long j10, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j11, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j12, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j13, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i10, Object obj) {
        TextAlign textAlign2;
        TextDirection textDirectionM3270getTextDirectionmmuk1to;
        TextDirection textDirection2;
        long jM3268getLineHeightXSAIIZE;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        long jM3309getFontSizeXSAIIZE = (i10 & 2) != 0 ? textStyle.spanStyle.m3309getFontSizeXSAIIZE() : j10;
        FontWeight fontWeight2 = (i10 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyleM3310getFontStyle4Lr2A7w = (i10 & 8) != 0 ? textStyle.spanStyle.m3310getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis fontSynthesisM3311getFontSynthesisZQGJjVo = (i10 & 16) != 0 ? textStyle.spanStyle.m3311getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i10 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i10 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long jM3312getLetterSpacingXSAIIZE = (i10 & 128) != 0 ? textStyle.spanStyle.m3312getLetterSpacingXSAIIZE() : j11;
        BaselineShift baselineShiftM3307getBaselineShift5SSeXJ0 = (i10 & 256) != 0 ? textStyle.spanStyle.m3307getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i10 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i10 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long jM3306getBackground0d7_KjU = (i10 & 2048) != 0 ? textStyle.spanStyle.m3306getBackground0d7_KjU() : j12;
        TextDecoration textDecoration2 = (i10 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i10 & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextAlign textAlignM3269getTextAlignbuA522U = (i10 & 16384) != 0 ? textStyle.paragraphStyle.m3269getTextAlignbuA522U() : textAlign;
        if ((i10 & 32768) != 0) {
            textAlign2 = textAlignM3269getTextAlignbuA522U;
            textDirectionM3270getTextDirectionmmuk1to = textStyle.paragraphStyle.m3270getTextDirectionmmuk1to();
        } else {
            textAlign2 = textAlignM3269getTextAlignbuA522U;
            textDirectionM3270getTextDirectionmmuk1to = textDirection;
        }
        if ((i10 & 65536) != 0) {
            textDirection2 = textDirectionM3270getTextDirectionmmuk1to;
            jM3268getLineHeightXSAIIZE = textStyle.paragraphStyle.m3268getLineHeightXSAIIZE();
        } else {
            textDirection2 = textDirectionM3270getTextDirectionmmuk1to;
            jM3268getLineHeightXSAIIZE = j13;
        }
        TextIndent textIndent3 = (131072 & i10) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        if ((i10 & 262144) != 0) {
            textIndent2 = textIndent3;
            platformTextStyle2 = textStyle.platformStyle;
        } else {
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle;
        }
        return textStyle.m3348copyWQp3mU(brush, jM3309getFontSizeXSAIIZE, fontWeight2, fontStyleM3310getFontStyle4Lr2A7w, fontSynthesisM3311getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, jM3312getLetterSpacingXSAIIZE, baselineShiftM3307getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, jM3306getBackground0d7_KjU, textDecoration2, shadow2, textAlign2, textDirection2, jM3268getLineHeightXSAIIZE, textIndent2, platformTextStyle2, (i10 & 524288) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle);
    }

    public static /* synthetic */ TextStyle merge$default(TextStyle textStyle, TextStyle textStyle2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            textStyle2 = null;
        }
        return textStyle.merge(textStyle2);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-HL5avdY, reason: not valid java name */
    public final TextStyle m3346copyHL5avdY(long j10, long j11, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j12, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j13, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j14, @Nullable TextIndent textIndent) {
        return new TextStyle(new SpanStyle(Color.m1599equalsimpl0(j10, this.spanStyle.m3308getColor0d7_KjU()) ? this.spanStyle.getTextDrawStyle$ui_text_release() : TextDrawStyle.Companion.m3611from8_81llA(j10), j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, this.spanStyle.getPlatformStyle(), (k) null), new ParagraphStyle(textAlign, textDirection, j14, textIndent, this.paragraphStyle.getPlatformStyle(), getLineHeightStyle(), null), this.platformStyle);
    }

    @ExperimentalTextApi
    @NotNull
    /* JADX INFO: renamed from: copy-NOaFTUo, reason: not valid java name */
    public final TextStyle m3347copyNOaFTUo(long j10, long j11, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j12, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j13, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j14, @Nullable TextIndent textIndent, @Nullable PlatformTextStyle platformTextStyle, @Nullable LineHeightStyle lineHeightStyle) {
        return new TextStyle(new SpanStyle(Color.m1599equalsimpl0(j10, this.spanStyle.m3308getColor0d7_KjU()) ? this.spanStyle.getTextDrawStyle$ui_text_release() : TextDrawStyle.Companion.m3611from8_81llA(j10), j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, (k) null), new ParagraphStyle(textAlign, textDirection, j14, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, null), platformTextStyle);
    }

    @ExperimentalTextApi
    @NotNull
    /* JADX INFO: renamed from: copy-WQp3-mU, reason: not valid java name */
    public final TextStyle m3348copyWQp3mU(@Nullable Brush brush, long j10, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j11, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j12, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j13, @Nullable TextIndent textIndent, @Nullable PlatformTextStyle platformTextStyle, @Nullable LineHeightStyle lineHeightStyle) {
        return new TextStyle(new SpanStyle(brush, j10, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j11, baselineShift, textGeometricTransform, localeList, j12, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, (k) null), new ParagraphStyle(textAlign, textDirection, j13, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, null), platformTextStyle);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        return t.d(this.spanStyle, textStyle.spanStyle) && t.d(this.paragraphStyle, textStyle.paragraphStyle) && t.d(this.platformStyle, textStyle.platformStyle);
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m3349getBackground0d7_KjU() {
        return this.spanStyle.m3306getBackground0d7_KjU();
    }

    @Nullable
    /* JADX INFO: renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name */
    public final BaselineShift m3350getBaselineShift5SSeXJ0() {
        return this.spanStyle.m3307getBaselineShift5SSeXJ0();
    }

    @ExperimentalTextApi
    @Nullable
    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m3351getColor0d7_KjU() {
        return this.spanStyle.m3308getColor0d7_KjU();
    }

    @Nullable
    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    @Nullable
    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    /* JADX INFO: renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m3352getFontSizeXSAIIZE() {
        return this.spanStyle.m3309getFontSizeXSAIIZE();
    }

    @Nullable
    /* JADX INFO: renamed from: getFontStyle-4Lr2A7w, reason: not valid java name */
    public final FontStyle m3353getFontStyle4Lr2A7w() {
        return this.spanStyle.m3310getFontStyle4Lr2A7w();
    }

    @Nullable
    /* JADX INFO: renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name */
    public final FontSynthesis m3354getFontSynthesisZQGJjVo() {
        return this.spanStyle.m3311getFontSynthesisZQGJjVo();
    }

    @Nullable
    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    /* JADX INFO: renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m3355getLetterSpacingXSAIIZE() {
        return this.spanStyle.m3312getLetterSpacingXSAIIZE();
    }

    /* JADX INFO: renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m3356getLineHeightXSAIIZE() {
        return this.paragraphStyle.m3268getLineHeightXSAIIZE();
    }

    @ExperimentalTextApi
    @Nullable
    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    @Nullable
    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    @NotNull
    public final ParagraphStyle getParagraphStyle$ui_text_release() {
        return this.paragraphStyle;
    }

    @ExperimentalTextApi
    @Nullable
    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    @Nullable
    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    @NotNull
    public final SpanStyle getSpanStyle$ui_text_release() {
        return this.spanStyle;
    }

    @Nullable
    /* JADX INFO: renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final TextAlign m3357getTextAlignbuA522U() {
        return this.paragraphStyle.m3269getTextAlignbuA522U();
    }

    @Nullable
    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    @Nullable
    /* JADX INFO: renamed from: getTextDirection-mmuk1to, reason: not valid java name */
    public final TextDirection m3358getTextDirectionmmuk1to() {
        return this.paragraphStyle.m3270getTextDirectionmmuk1to();
    }

    @Nullable
    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    @Nullable
    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    public final boolean hasSameLayoutAffectingAttributes(@NotNull TextStyle other) {
        t.i(other, "other");
        return this == other || (t.d(this.paragraphStyle, other.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text_release(other.spanStyle));
    }

    public int hashCode() {
        int iHashCode = ((this.spanStyle.hashCode() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return iHashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    @Stable
    @NotNull
    public final TextStyle merge(@Nullable TextStyle textStyle) {
        return (textStyle == null || t.d(textStyle, Default)) ? this : new TextStyle(toSpanStyle().merge(textStyle.toSpanStyle()), toParagraphStyle().merge(textStyle.toParagraphStyle()));
    }

    @Stable
    @NotNull
    public final TextStyle plus(@NotNull TextStyle other) {
        t.i(other, "other");
        return merge(other);
    }

    @Stable
    @NotNull
    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    @Stable
    @NotNull
    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    @NotNull
    public String toString() {
        return "TextStyle(color=" + ((Object) Color.m1606toStringimpl(m3351getColor0d7_KjU())) + ", brush=" + getBrush() + ", fontSize=" + ((Object) TextUnit.m3861toStringimpl(m3352getFontSizeXSAIIZE())) + ", fontWeight=" + getFontWeight() + ", fontStyle=" + m3353getFontStyle4Lr2A7w() + ", fontSynthesis=" + m3354getFontSynthesisZQGJjVo() + ", fontFamily=" + getFontFamily() + ", fontFeatureSettings=" + getFontFeatureSettings() + ", letterSpacing=" + ((Object) TextUnit.m3861toStringimpl(m3355getLetterSpacingXSAIIZE())) + ", baselineShift=" + m3350getBaselineShift5SSeXJ0() + ", textGeometricTransform=" + getTextGeometricTransform() + ", localeList=" + getLocaleList() + ", background=" + ((Object) Color.m1606toStringimpl(m3349getBackground0d7_KjU())) + ", textDecoration=" + getTextDecoration() + ", shadow=" + getShadow() + ", textAlign=" + m3357getTextAlignbuA522U() + ", textDirection=" + m3358getTextDirectionmmuk1to() + ", lineHeight=" + ((Object) TextUnit.m3861toStringimpl(m3356getLineHeightXSAIIZE())) + ", textIndent=" + getTextIndent() + ", platformStyle=" + this.platformStyle + "lineHeightStyle=" + getLineHeightStyle() + ')';
    }

    public /* synthetic */ TextStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j14, TextIndent textIndent, k kVar) {
        this(j10, j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, textAlign, textDirection, j14, textIndent);
    }

    @Stable
    @NotNull
    public final TextStyle plus(@NotNull ParagraphStyle other) {
        t.i(other, "other");
        return merge(other);
    }

    @ExperimentalTextApi
    public /* synthetic */ TextStyle(Brush brush, long j10, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j11, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j12, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j13, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, k kVar) {
        this(brush, j10, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j11, baselineShift, textGeometricTransform, localeList, j12, textDecoration, shadow, textAlign, textDirection, j13, textIndent, platformTextStyle, lineHeightStyle);
    }

    @Stable
    @NotNull
    public final TextStyle plus(@NotNull SpanStyle other) {
        t.i(other, "other");
        return merge(other);
    }

    public TextStyle(@NotNull SpanStyle spanStyle, @NotNull ParagraphStyle paragraphStyle, @ExperimentalTextApi @Nullable PlatformTextStyle platformTextStyle) {
        t.i(spanStyle, "spanStyle");
        t.i(paragraphStyle, "paragraphStyle");
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
        this.platformStyle = platformTextStyle;
    }

    @Stable
    @NotNull
    public final TextStyle merge(@NotNull SpanStyle other) {
        t.i(other, "other");
        return new TextStyle(toSpanStyle().merge(other), toParagraphStyle());
    }

    public /* synthetic */ TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle, int i10, k kVar) {
        this(spanStyle, paragraphStyle, (i10 & 4) != 0 ? null : platformTextStyle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextStyle(@NotNull SpanStyle spanStyle, @NotNull ParagraphStyle paragraphStyle) {
        this(spanStyle, paragraphStyle, TextStyleKt.createPlatformTextStyleInternal(spanStyle.getPlatformStyle(), paragraphStyle.getPlatformStyle()));
        t.i(spanStyle, "spanStyle");
        t.i(paragraphStyle, "paragraphStyle");
    }

    @Stable
    @NotNull
    public final TextStyle merge(@NotNull ParagraphStyle other) {
        t.i(other, "other");
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(other));
    }

    public /* synthetic */ TextStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j14, TextIndent textIndent, int i10, k kVar) {
        this((i10 & 1) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j10, (i10 & 2) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j11, (i10 & 4) != 0 ? null : fontWeight, (i10 & 8) != 0 ? null : fontStyle, (i10 & 16) != 0 ? null : fontSynthesis, (i10 & 32) != 0 ? null : fontFamily, (i10 & 64) != 0 ? null : str, (i10 & 128) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j12, (i10 & 256) != 0 ? null : baselineShift, (i10 & 512) != 0 ? null : textGeometricTransform, (i10 & 1024) != 0 ? null : localeList, (i10 & 2048) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j13, (i10 & 4096) != 0 ? null : textDecoration, (i10 & 8192) != 0 ? null : shadow, (i10 & 16384) != 0 ? null : textAlign, (i10 & 32768) != 0 ? null : textDirection, (i10 & 65536) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j14, (i10 & 131072) != 0 ? null : textIndent, null);
    }

    /* JADX INFO: compiled from: TextStyle.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final TextStyle getDefault() {
            return TextStyle.Default;
        }

        @Stable
        public static /* synthetic */ void getDefault$annotations() {
        }
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getBrush$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getLineHeightStyle$annotations() {
    }

    private TextStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j14, TextIndent textIndent) {
        this(new SpanStyle(j10, j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, (PlatformSpanStyle) null, (k) null), new ParagraphStyle(textAlign, textDirection, j14, textIndent, null, null, null), null);
    }

    public /* synthetic */ TextStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j14, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i10, k kVar) {
        this((i10 & 1) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j10, (i10 & 2) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j11, (i10 & 4) != 0 ? null : fontWeight, (i10 & 8) != 0 ? null : fontStyle, (i10 & 16) != 0 ? null : fontSynthesis, (i10 & 32) != 0 ? null : fontFamily, (i10 & 64) != 0 ? null : str, (i10 & 128) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j12, (i10 & 256) != 0 ? null : baselineShift, (i10 & 512) != 0 ? null : textGeometricTransform, (i10 & 1024) != 0 ? null : localeList, (i10 & 2048) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j13, (i10 & 4096) != 0 ? null : textDecoration, (i10 & 8192) != 0 ? null : shadow, (i10 & 16384) != 0 ? null : textAlign, (i10 & 32768) != 0 ? null : textDirection, (i10 & 65536) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j14, (i10 & 131072) != 0 ? null : textIndent, (i10 & 262144) != 0 ? null : platformTextStyle, (i10 & 524288) != 0 ? null : lineHeightStyle, (k) null);
    }

    private TextStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j14, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle) {
        this(new SpanStyle(j10, j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, (k) null), new ParagraphStyle(textAlign, textDirection, j14, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, null), platformTextStyle);
    }

    public /* synthetic */ TextStyle(Brush brush, long j10, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j11, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j12, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j13, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i10, k kVar) {
        this(brush, (i10 & 2) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j10, (i10 & 4) != 0 ? null : fontWeight, (i10 & 8) != 0 ? null : fontStyle, (i10 & 16) != 0 ? null : fontSynthesis, (i10 & 32) != 0 ? null : fontFamily, (i10 & 64) != 0 ? null : str, (i10 & 128) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j11, (i10 & 256) != 0 ? null : baselineShift, (i10 & 512) != 0 ? null : textGeometricTransform, (i10 & 1024) != 0 ? null : localeList, (i10 & 2048) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j12, (i10 & 4096) != 0 ? null : textDecoration, (i10 & 8192) != 0 ? null : shadow, (i10 & 16384) != 0 ? null : textAlign, (32768 & i10) != 0 ? null : textDirection, (65536 & i10) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j13, (131072 & i10) != 0 ? null : textIndent, (262144 & i10) != 0 ? null : platformTextStyle, (i10 & 524288) != 0 ? null : lineHeightStyle, (k) null);
    }

    private TextStyle(Brush brush, long j10, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j11, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j12, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j13, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle) {
        this(new SpanStyle(brush, j10, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j11, baselineShift, textGeometricTransform, localeList, j12, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, (k) null), new ParagraphStyle(textAlign, textDirection, j13, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, null), platformTextStyle);
    }
}
